package com.hqyj.personel.service.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hqyj.personel.mapper.UserMapper;
import com.hqyj.personel.po.User;
import com.hqyj.personel.service.EmailService;
import com.hqyj.personel.service.UserService;
import com.hqyj.personel.util.DateTransfer;
import com.hqyj.personel.util.EmailCheckClass;
import com.hqyj.personel.util.MdFive;
import com.hqyj.personel.util.OtherCheckClass;
import com.hqyj.personel.util.PhoneCheckClass;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private EmailService emailService;

	/*
	 * @param userName
	 * 
	 * @param uuid
	 */
	private void setCookieByUuid(String userName, HttpServletResponse response) {

		Random random = new Random();
		/* 生成十个随机数字 */
		String r = "";
		for (int i = 0; i < 10; i++) {
			r += random.nextInt(10);
		}

		MdFive md5 = new MdFive();

		String uuid = md5.encrypt(userName, r) + "";

		Cookie cookie1 = new Cookie("userName", userName);
		Cookie cookie2 = new Cookie("uuid", uuid);
//		cookie1.setMaxAge(24*60*60*1000);
//		cookie2.setMaxAge(24*60*60*1000);
		/* 存入数据库 */
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		/* 修改uuid */
		int i = this.updateUuid(userName, uuid);
	}

	/* 数据库存入uuid */
	private int updateUuid(String userName, String uuid) {
		int i = userMapper.updateUuidByUsername(userName, uuid);
		return i;
	}

	@Override
	public String login(User user, RedirectAttributes ra, HttpServletResponse resp, HttpServletRequest req,
			HttpSession session) {
		/* 清理cookie */
		this.clearCookie(req, resp);

		// 这段代码放到你的登录请求中，获取用户输入的校验码并进行比较
		String verifyCode = req.getParameter("verifyCode");
		String sessionVerifyCode = (String) session.getAttribute("verifyCodeValue");
		if (!verifyCode.equalsIgnoreCase(sessionVerifyCode)) {
			System.err.println("<--登录失败,验证码输入有误！-->");
			ra.addAttribute("error", "验证码输入有误");
			return "redirect:loginPage.do";
		}

		// 创建实体对象
		Subject subject = SecurityUtils.getSubject();
		// 创建shiro令牌
		UsernamePasswordToken token = new UsernamePasswordToken(user.getEmployeeNo(), user.getPassword());
		try {
			// 运行登陆
			subject.login(token);
		} catch (UnknownAccountException e) {
			ra.addAttribute("error", "账户不存在");
			return "redirect:loginPage.do";
		} catch (IncorrectCredentialsException ie) {
			ra.addAttribute("error", "密码不正确");
			return "redirect:loginPage.do";
		}
		/*
		 * 验证正确，存cookie,存uuid
		 */
		String userName = user.getEmployeeNo();

		this.setCookieByUuid(userName, resp);
		req.setAttribute("userName", userName);
		return "index";
	}

	// sql查询分页
	@Override
	public HashMap<String, Object> getUserBySql(User u) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 计算sql查询的起始索引
		int start = (u.getPage() - 1) * u.getRows();
		u.setStart(start);
		// 查询结果集
		List<User> userList = userMapper.selectUserBySql(u);
		// 计算user的总条数
		int total = userMapper.selectCount();
		// 放数据
		map.put("total", total);
		map.put("rows", userList);
		return map;
	}

	/* 添加user */
	@Override
	public String addUser(User u, RedirectAttributes ra) {
		System.out.println("--------------user" + u);
		MdFive md = new MdFive();
		String employeeNo = u.getEmployeeNo();
		User user1 = userMapper.getUserByemployeeNo(employeeNo);
		String email = u.getEmailAddress();
		String telephone = u.getTelephone();
		if (user1 == null) {
			if (PhoneCheckClass.checkPhone(telephone)) {
				if (EmailCheckClass.checkEmail(email)) {
					Object password = md.encrypt("123", u.getEmployeeNo());
					u.setPassword(password + "");
					int i = userMapper.insert(u);
					if (i == 1) {
						return "1";
					} else {
						return "添加失败";
					}

				} else {
					return "邮箱格式不正确";
				}

			} else {
				System.out.println(u.getTelephone());
				System.out.println("phonecheck:  " + PhoneCheckClass.checkPhone(u.getTelephone()));
				return "手机号码格式不正确";
			}

		} else {
			return "添加失败，用户名已经存在";
		}

	}

	@Override
	public int updateUser(User u) {

		return userMapper.updateByPrimaryKeySelective(u);
	}

	/* 假删除 */
	@Override
	public int deleteUserByIdStr(String id) {
		String[] idStr = id.split(",");
		for (String str : idStr) {
			int deleteId = Integer.parseInt(str);
			User user = new User();
			// 设置状态为为1
			user.setDeleteStatus("1");
			user.setUserId(deleteId);
			int i = userMapper.falseDeleteByUser(user);
			if (i == 0) {
				return 0;
			}
		}
		return 1;
	}

	/*
	 * cookie验证
	 * 
	 * @param
	 */
	@Override
	public String cookieCheck(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			if (cookies.length > 2) {
				String userName = "";
				String uuid = "";
				for (Cookie cookie : cookies) {
					if ("userName".equals(cookie.getName())) {
						userName = cookie.getValue();
					}
					if ("uuid".equals(cookie.getName())) {
						uuid = cookie.getValue();
					}
				}
				/* 去数据库查询有没有这个userName和uuid */
				if (userName != null && uuid != null) {
					User user = userMapper.selectByEmployeeAndUuid(userName, uuid);
					if (user != null) {
						/* 不等于null再一次设置uuid到数据库以及页面上 */
						this.setCookieByUuid(userName, response);
						return "index";
					}
				} else {
					return "login";
				}
			} else {
				return "login";
			}

		}
		return "login";
	}

	/* 获取cookie信息 */
	@Override
	public String getCheckId(String employeeNo, String password, String emailAddress, HttpServletResponse resp) {
		/* 检查用户名是否重复 */
		User user = userMapper.getUserByemployeeNo(employeeNo);
		if (user != null) {

			return "用户已存在,请重新输入！";
		}
		if (!EmailCheckClass.checkEmail(emailAddress)) {

			return "输入的邮箱格式有误！";
		}
		/*
		 * 都验证通过，
		 * 
		 * 1.存数据库,验证码、employeeNo、password 2.发验证码到对方邮箱
		 */
		String checkId = this.generateCheckId();
		emailService.seandMail("1975492517@qq.com", emailAddress, "人事管理系统验证码", checkId);

		User user1 = new User();
		user1.setEmployeeNo(employeeNo);
		user1.setEmailAddress(emailAddress);
		user1.setRemark("注册用户,未激活");
		user1.setCheckId(checkId);
		/* 这里存储明码，真正注册的时候存加密的密码 */
		/*
		 * 将用户注册信息存在页面上，以便于删除以下两种情况 1.获取了注册码但不注册 2.或者注册码，密码，或者是用户名写错的
		 */
		Cookie cookie1 = new Cookie("regeisteEmployeeNo", employeeNo);
		resp.addCookie(cookie1);

		user1.setPassword(password);
		int i = userMapper.insert(user1);
		return "验证码已发送,请到邮箱去获取！";
	}

	/* 生成验证码 */
	private String generateCheckId() {
		Random r = new Random();
		String str = "";
		for (int i = 0; i < 6; i++) {
			int j = r.nextInt(10);
			str += j;
		}
		return str;
	}

	@Override
	public String regeisteUser(String employeeNo, String password, String emailAddress, String checkId,
			HttpServletRequest request) {
		User user1 = new User();
		user1.setEmployeeNo(employeeNo);
		user1.setPassword(password);
		user1.setEmailAddress(emailAddress);
		user1.setCheckId(checkId);
		User user2 = userMapper.selectUserByRegeisteMsg(user1);
		/* 判断验证码是否正确 */
		if (user2 != null) {
			/*
			 * 用户已经存在只是修改密码即可
			 */
			MdFive md = new MdFive();

			String pwd = md.encrypt(user2.getPassword(), user2.getEmployeeNo()) + "";
			String remake = "注册用户，已激活";
			/* 账号状态设置为未删除即是0 */
			String deleteStatus = "0";
			int i = userMapper.regeisteUser(pwd, remake, employeeNo, deleteStatus);
		} else {
			/* 信息不匹配直接删除上一次的获取验证码时的信息 */
			Cookie[] cookies = request.getCookies();
			String regeisteEmployeeNo = "";
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if ("regeisteEmployeeNo".equals(cookie.getName())) {
						regeisteEmployeeNo = cookie.getValue();
					}
				}
			}
			if (regeisteEmployeeNo != null) {
				int i = userMapper.deleteLastRegeisteUser(regeisteEmployeeNo);
			}
			return "获取验证码与注册时的信息不一致！请重新注册";
		}

		return "成功注册，请返回登陆";
	}

	/* 安全退出 */
	@Override
	public String clearCookieAndLogout(HttpServletRequest req, HttpServletResponse resp) {
		this.clearCookie(req, resp);
		this.logOut();
		return /* "login"; */
		"login";
	}

	/* 清除cookie */
	public void clearCookie(HttpServletRequest req, HttpServletResponse resp) {
		/* 清除cookie */
//		Cookie [] cookies = req.getCookies();
		Cookie cookie1 = new Cookie("userName", null);
		Cookie cookie2 = new Cookie("uuid", null);
		cookie1.setMaxAge(0);
		cookie2.setMaxAge(0);
		resp.addCookie(cookie1);
		resp.addCookie(cookie2);
	}

	/* 登出 */
	public void logOut() {
		/* logout */
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
			subject.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存
		}
//	 ———————————————— 
//	版权声明：本文为CSDN博主「lhacker」的原创文章，遵循CC 4.0 by-sa版权协议，转载请附上原文出处链接及本声明。
//	原文链接：https://blog.csdn.net/LHacker/article/details/20446111
	}

	@Override
	public String updatePwdByOldPwd(String employeeNo, String oldPassword, String newPassword, HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
		if (cookies == null) {
			return "cookie信息被清除，请重新登录";
		} else if (cookies.length > 2) {
			String cookieEmployeeNo = "";
			for (Cookie cookie : cookies) {
				if ("userName".equals(cookie.getName())) {
					cookieEmployeeNo = cookie.getValue();
				}
			}
			if (cookieEmployeeNo == null) {
				return "cookie信息不完整，请重新登录";
			} else {
				int i = employeeNo.length();
				int j = oldPassword.length();
				int m = newPassword.length();
				if (i > 11) {
					return "账号长度过长";
				} else if (i == 0 || j == 0 || m == 0) {
					return "请不要输入空值";
				} else {
					if (cookieEmployeeNo.equals(employeeNo)) {
						MdFive md = new MdFive();
						/* 将密码加密后才能和数据库匹配 */
						String oldPwd = md.encrypt(oldPassword, employeeNo) + "";
						User user = userMapper.selectUserByNoAndPwd(employeeNo, oldPwd);
						if (user != null) {
							String newPwd = md.encrypt(newPassword, employeeNo) + "";
							int ri = userMapper.updatePwdByOldPwdAndNo(employeeNo, newPwd);
							if (ri == 1) {
								return "1";
							}
						} else {
							return "密码错误！";
						}
					} else {
						return "账号错误！";
					}
				}

			}
		} else {
			return "cookie信息不完整，请重新登录";
		}

//		String newPassword = 
//		
//		userMapper.updatePwdByOldPwd(employeeNo,newPassword);
		return "";
	}

	/* 查詢用戶通過cookie信息 */
	@Override
	public String selectUserByCookie(HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
		String employeeNo = "";
		if (cookies == null) {
			return "cookie为空，用户信息获取失败";
		} else {
			for (Cookie cookie : cookies) {
				if ("userName".equals(cookie.getName())) {
					employeeNo = cookie.getValue();
				}
			}
			if (employeeNo == "") {
				return "用户信息获取是失败，请勿清除cookie";
			}
		}
		return userMapper.getUserByemployeeNo(employeeNo).getName();
	}

	/* 获取校验码 */
	@Override
	public void generate(HttpServletResponse response, HttpSession session) {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		String verifyCodeValue = drawImg(output);
		// 将校验码保存到session中
		session.setAttribute("verifyCodeValue", verifyCodeValue);

		try {
			ServletOutputStream out = response.getOutputStream();
			output.writeTo(out);
		} catch (IOException e) {
			System.out.println("<--验证码前端写出.出现异常-->");
			e.printStackTrace();

		}

	}

	/* 绘制验证码 */
	private String drawImg(ByteArrayOutputStream output) {
		String code = "";
		// 随机产生4个字符

		int width = 90;
		int height = 20;
		int codeaccount = 4;// 定义图片上显示验证码的个数
		int fontHeight = 18;
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Font font = new Font("Fixedsys", Font.BOLD, fontHeight);/* Times New Roman */
		// 调用Graphics绘画验证码
		Graphics g = bi.getGraphics();

		// 将图像填充为白色
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);

		/* 设置字体 */
		g.setFont(font);

//        Color color = new Color(66, 2, 82);
//        g.setColor(color);
//        g.setBackground(new Color(226, 226, 240));
		/* 设置边框 */
//        g.setColor(Color.BLACK);
//        g.drawRect(0, 0, width - 1, height - 1);
		// 创建一个随机数生成器类
		Random random = new Random();
		// 随机产生40条干扰线，使图象中的认证码不易被其它程序探测到。
		g.setColor(Color.BLACK);

		for (int i = 0; i < 30; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}
		int red = 0, green = 0, blue = 0;
		for (int i = 0; i < codeaccount; i++) {
			String mycode = randomChar();
			// 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
			red = random.nextInt(255);
			green = random.nextInt(255);
			blue = random.nextInt(255);
			// 用随机产生的颜色将验证码绘制到图像中。
			g.setColor(new Color(red, green, blue));
			g.drawString(mycode, (i + 1) * 15, 16);
			code += mycode;
		}
//        g.clearRect(0, 0, width, height);
//        FontRenderContext context = g.getFontRenderContext();
//        Rectangle2D bounds = font.getStringBounds(code, context);
//        double x = (width - bounds.getWidth()) / 2;
//        double y = (height - bounds.getHeight()) / 2;
//        double ascent = bounds.getY();
//        double baseY = y - ascent;
//        g.drawString(code, (int) x, (int) baseY);
//        g.dispose();
		try {
			ImageIO.write(bi, "jpg", output);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return code;
	}

	/* 获取随机参数 */
	private String randomChar() {
		Random r = new Random();
		String s = "ABCDEFGHJKLMNPRSTUVWXYZ0123456789";
		return s.charAt(r.nextInt(s.length())) + "";
	}

	@Override
	public HashMap<String, Object> searchUserByDept(String department, User u) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 计算sql查询的起始索引
		int start = (u.getPage() - 1) * u.getRows();
		int rows = u.getRows();

		// 查询结果集
		List<User> userList = userMapper.searchUserByDept(start, rows, department);
		// 计算user的总条数
		int total = userMapper.selectCountByDept(department);
		// 放数据
		map.put("total", total);
		map.put("rows", userList);
		return map;
	}
	/*查询用户通过部门还有入职时间段*/
	@Override
	public HashMap<String, Object> searchUserByDateAndDept(String bTime, String eTime, String deptMsg, User u) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		// 计算sql查询的起始索引
		int start = (u.getPage() - 1) * u.getRows();
		int rows = u.getRows();
		/* 准备数据 */
		List<User> userList = null;
		int total = 0;
		/* 判断输入的部门信息是否为空或者为0 */
		if ("".equals(deptMsg) || "0".equals(deptMsg)) {
			/* 只做时间的查询 */
			if ("empty".equals(bTime)) {
				/* 开始时间为空，只查结束时间 */

				Date endTime = DateTransfer.stringToDate(eTime);
				deptMsg = null;
				Date beginTime = null;

				userList = userMapper.selectUserByBeginTimeAndEndTimeAndDept(start, rows, beginTime, endTime, deptMsg);
				total = userMapper.selectCountByBeginTimeAndEndTimeAndDept(beginTime, endTime, deptMsg);

				map.put("rows", userList);
				map.put("total", total);
				return map;
			} else {
				/* 结束时间为空，只查开始时间 */
				Date beginTime = DateTransfer.stringToDate(bTime);
				deptMsg = null;
				Date endTime = null;

				userList = userMapper.selectUserByBeginTimeAndEndTimeAndDept(start, rows, beginTime, endTime, deptMsg);
				total = userMapper.selectCountByBeginTimeAndEndTimeAndDept(beginTime, endTime, deptMsg);

				map.put("rows", userList);
				map.put("total", total);
				return map;
			}

		} else {
			if ("empty".equals(bTime) || "empty".equals(eTime)) {
				if ("empty".equals(bTime)) {
					/* 在有部门情况下，开始时间为空，查询结束时间 */
					Date endTime = DateTransfer.stringToDate(eTime);
					Date beginTime = null;

					userList = userMapper.selectUserByBeginTimeAndEndTimeAndDept(start, rows, beginTime, endTime,
							deptMsg);
					total = userMapper.selectCountByBeginTimeAndEndTimeAndDept(beginTime, endTime, deptMsg);

					map.put("rows", userList);
					map.put("total", total);
					return map;

				} else {
					/* 在有部门情况下，结束时间为空，查询开始时间 */
					Date beginTime = DateTransfer.stringToDate(bTime);
					Date endTime = null;

					userList = userMapper.selectUserByBeginTimeAndEndTimeAndDept(start, rows, beginTime, endTime,
							deptMsg);
					total = userMapper.selectCountByBeginTimeAndEndTimeAndDept(beginTime, endTime, deptMsg);

					map.put("rows", userList);
					map.put("total", total);
					return map;
				}
			} else {
				/* 在有部门情况下，结束时间，开始时间 */
				Date beginTime = DateTransfer.stringToDate(bTime);
				Date endTime = DateTransfer.stringToDate(eTime);
				userList = userMapper.selectUserByBeginTimeAndEndTimeAndDept(start, rows, beginTime, endTime, deptMsg);
				total = userMapper.selectCountByBeginTimeAndEndTimeAndDept(beginTime, endTime, deptMsg);
				map.put("rows", userList);
				map.put("total", total);
				return map;
			}
		}
	}

	/* 模糊查询， */
	@Override
	public HashMap<String, Object> searchUserByKey(String key, User u) {
		int i = key.length();
		int start = (u.getPage() - 1) * u.getRows();

		HashMap<String, Object> map = new HashMap<String, Object>();
		System.out.println(u + "-----------------");

		if (i > 11) {
			/* 长度大于十一可能是邮箱地址，身份证号，住址,备注 */
			if (EmailCheckClass.checkEmail(key)) {
				u.setEmailAddress(key);
				/* key在user里面 */
				return this.searchBykeyDemo(start, u);
			} else if (OtherCheckClass.personIdCheck(key)) {
				u.setPersonId(key);
				return this.searchBykeyDemo(start, u);
			} else {
				key = "%" + key + "%";
				u.setAddress(key);
				u.setRemark(key);
				return this.searchBykeyDemo(start, u);
			}
		} else if (i == 11) {
			/* 长度为11则表示，它可能是手机号码，地址，备注 */
			if (PhoneCheckClass.checkPhone(key)) {
				u.setTelephone(key);
				return this.searchBykeyDemo(start, u);
			} else {
				key = "%" + key + "%";
				u.setAddress(key);
				u.setRemark(key);
				return this.searchBykeyDemo(start, u);
			}

		} else if (i == 10) {
			/* 生日，地址，备注 */
			if (OtherCheckClass.dateCheck(key)) {
				Date date = DateTransfer.stringToDate(key);
				u.setBirthday(date);
				return this.searchBykeyDemo(start, u);
			} else {
				key = "%" + key + "%";
				u.setAddress(key);
				u.setRemark(key);
				return this.searchBykeyDemo(start, u);
			}
		} else if (i == 1) {
			/* 用户id，部门id，账号状态，性别 */
			if (OtherCheckClass.numCheck(key)) {
				int j = Integer.parseInt(key);
				u.setUserId(j);
				u.setDepartmentId(j);
				u.setDeleteStatus(j + "");
				return this.searchBykeyDemo(start, u);
			} else {
				key = "%" + key + "%";
				u.setSex(key);
				return this.searchBykeyDemo(start, u);
			}
		} else if (i == 2) {
			key = "%" + key + "%";
			/* 人员状态，备注，名字,地址,教育背景 */
			u.setEmploryeeStatus(key);
			u.setRemark(key);
			u.setName(key);
			u.setAddress(key);
			u.setEduBg(key);
			return this.searchBykeyDemo(start, u);
		} else {
			key = "%" + key + "%";
			/* 地址，登录名，名字，备注 */
			u.setAddress(key);
			u.setRemark(key);
			u.setName(key);
			u.setEmployeeNo(key);
			return this.searchBykeyDemo(start, u);
		}
	}

	public HashMap<String, Object> searchBykeyDemo(int start, User u) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		u.setStart(start);
		/* key在user里面 */
		List<User> userList = userMapper.selectUserByKey(u);
		int total = userMapper.selectCountByKey(u);
		map.put("total", total);
		map.put("rows", userList);
		return map;
	}
}

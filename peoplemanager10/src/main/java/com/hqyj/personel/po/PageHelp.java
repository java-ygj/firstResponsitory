package com.hqyj.personel.po;
/**
 * 分页pojo类
 * @author ygj
 *
 */
public class PageHelp {

		//页码
		private int page;
		//每页显示的行数
		private int rows;
		//起始位置
		private int start;
		
		@Override
		public String toString() {
			return "PageHelp [page=" + page + ", rows=" + rows + ", start=" + start + "]";
		}
		public int getPage() {
			return page;
		}
		public void setPage(int page) {
			this.page = page;
		}
		public int getRows() {
			return rows;
		}
		public void setRows(int rows) {
			this.rows = rows;
		}
		public int getStart() {
			return start;
		}
		public void setStart(int start) {
			this.start = start;
		}
		
}

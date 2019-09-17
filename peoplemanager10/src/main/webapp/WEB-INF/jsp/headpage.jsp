<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/1.3.4/themes/default/easyui.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/wu.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/icon.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/1.3.4/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/1.3.4/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>
  <script>
        $(function() {
            $('#myCarousel').carousel({
                interval: 3000
            }).on("slide.bs.carousel", function() {
                console.log("slide.bs.carousel")
            }).on("slid.bs.carousel", function() {
                console.log("slid.bs.carousel")
            })

            $(".start-slide").click(function() {
                $('#myCarousel').carousel('cycle');
            })
			//从左向右循环播放。 
            $(".pause-slide").click(function() {
                $('#myCarousel').carousel('pause');
            })

            $(".prev-slide").click(function() {
                $('#myCarousel').carousel('prev');
            })
			//回到上一帧
            $(".next-slide").click(function() {
                $('#myCarousel').carousel('next');
            })
			//回到下一帧
            $(".slide-one").click(function() {
                $('#myCarousel').carousel(0);
            })

            $(".slide-two").click(function() {
                $('#myCarousel').carousel(1);
            })

            $(".slide-three").click(function() {
                $('#myCarousel').carousel(2);
            })
        })

    </script>
<body>
  <center>
        <h1>不忘初心，方得始终</h1>
    </center>
    <hr>
    <div class="container" style="padding:20px">
        <div id="myCarousel" class="carousel slide">
            <!--轮播指标 -->
          <!--  <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>-->
            <!--轮播内容 -->
            <div class="carousel-inner">
                <div class="item active">
                    <img src="imges/timg 5.jpg" alt="First Slide">
                    <!-- <div class="carousel-caption">标题 1</div>-->
                </div>
                <div class="item">
                    <img src="imges/timg 6.jpg" alt="Second Slide">
                    <!--<div class="carousel-caption">标题 2</div>-->
                </div>
                <div class="item">
                    <img src="imges/timg 7.jpg" alt="Third Slide">
                    <!--<div class="carousel-caption">标题 3</div>-->
                </div>
            </div>
            <!--轮播导航 -->
            <a href="#myCarousel" class="carousel-control left" data-slide="prev">&lsaquo;</a>
            <a href="#myCarousel" class="carousel-control right" data-slide="next">&rsaquo;</a>
        </div>
    </div>
</body>
</html>
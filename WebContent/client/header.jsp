<%@page import="com.model.Category"%>
<%@page import="com.dao.NewDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.Comment"%>
<%@ page import="java.util.List" %>
<%@ page import="com.model.New" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Home</title>

    <!-- Favicon -->
    <link rel="icon" href="client/img/core-img/favicon.ico">

    <!-- Core Stylesheet -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="client/style.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">

</head>

<body>
<header class="header-area">
    <div class="top-header-area">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="top-header-content d-flex align-items-center justify-content-between">
                        <!-- Logo -->
                        <div class="logo">
                            <a href="/home"><img src="client/img/core-img/logo.png" alt=""></a>
                        </div>
                        <div class="login-search-area d-flex align-items-center">
                            <div class="search-form">
                                <form action="#" method="post">
                                    <input type="search" name="search" class="form-control" placeholder="Search">
                                    <button type="submit"><i class="fa fa-search" aria-hidden="true"></i></button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="newspaper-main-menu" id="stickyMenu">
        <div class="classy-nav-container breakpoint-off">
            <div class="container">
                <!-- Menu -->
                <nav class="classy-navbar justify-content-between" id="newspaperNav">

                    <!-- Logo -->
                    <div class="logo">
                        <a href="index.html"><img src="client/img/core-img/logo.png" alt=""></a>
                    </div>

                    <!-- Navbar Toggler -->
                    <div class="classy-navbar-toggler">
                        <span class="navbarToggler"><span></span><span></span><span></span></span>
                    </div>

                    <!-- Menu -->
                    <div class="classy-menu">

                        <!-- close btn -->
                        <div class="classycloseIcon">
                            <div class="cross-wrap"><span class="top"></span><span class="bottom"></span></div>
                        </div>

                        <!-- Nav Start -->
                        <div class="classynav">
                            <ul>
                                <li class="active"><a href="/home"><i class="fas fa-fw fa-home"></i>  Trang Chủ</a></li>
                                <li><a href="#" style="color:black"><i class="fab fa-gg-circle">  Danh Mục</i></a>
                                    <ul class="dropdown">
                                    	<% NewDAO newDAO = new NewDAO();
                                    		List<Category> listcc = newDAO.getCate();
                                    		for(Category c: listcc){
                                    	%>
                                        <li><a href="?category=<%=c.getId()%>"><%=c.getName() %></a></li>
                                        <%} %>
                                    </ul>
                                </li>
                                <%
                                	Boolean notifi = (Boolean)request.getAttribute("notification");
                                if(notifi == true){
                                	List<Comment> list = (ArrayList<Comment>) request.getAttribute("listC");
                                %>
                                <li><a href="#"><i class="fas fa-bell" style="font-size: 17px; color:red"></i><span style="color: red"> <%=list.size() %></span></a>
                                    <ul class="dropdown" style="width:844px">
                                    	<%for(Comment com:list){ %>
                                        <li ><a href="/detail?id=<%=com.getNewId()%>"><%=com.getName()%> đã bình luận <%=com.getTitle()%></a></li>
                                        <%} %>
                                    </ul>
                                </li>
                                <% }%>
                            </ul>
                        </div>
                        <!-- Nav End -->
                    </div>
                </nav>
            </div>
        </div>
    </div>
</header>
<div class="hero-area">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-12 col-lg-8">
                <!-- Breaking News Widget -->
                <div class="breaking-news-area d-flex align-items-center">
                    <div class="news-title">
                        <p>TIN HOT</p>
                    </div>
                    <div id="breakingNewsTicker" class="ticker">
                        <ul>
                            <%
                                List<New> hots = (List<New>) request.getAttribute("hots");
                                for(New n: hots){
                            %>
                            <li><a href="/detail?id=<%=n.getID()%>" style="color: red"> <%=n.getName()%> </a></li>
                            <%
                                }
                            %>
                        </ul>
                    </div>
                </div>

                <!-- Breaking News Widget -->
                <div class="breaking-news-area d-flex align-items-center mt-15">
                    <div class="news-title title2">
                        <p>GIỚI THIỆU</p>
                    </div>
                    <div id="internationalTicker" class="ticker">
                        <ul>
                            <li><a href="#"><marquee style="color: blue"> News 360 luôn cập nhật những tin nhanh nhất hot nhất trong nước và quốc tế mỗi ngày!</marquee></a></li>
                        </ul>
                    </div>
                </div>
            </div>

            <!-- Hero Add -->
            <div class="col-12 col-lg-4">
                <div class="hero-add">
                    <a href="#"><img src="client/img/bg-img/hero-add.gif" alt=""></a>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Nội dung chính ở đây -->
<div class="popular-news-area section-padding-80-50">
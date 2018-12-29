<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>ADMIN</title>

<!-- Bootstrap core CSS-->
<link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.ckeditor.com/4.9.2/standard/ckeditor.js"></script>
<!-- Custom fonts for this template-->
<link href="../vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">

<!-- Page level plugin CSS-->
<link href="../vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="../css/sb-admin.css" rel="stylesheet">

</head>

<body id="page-top">

	<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

		<a class="navbar-brand mr-1" href="/home"">
			<img src="./client/img/core-img/logo.png" alt="Tin tức 360"
			style="height: 30px; width: 182px">
		</a>

		<button class="btn btn-link btn-sm text-white order-1 order-sm-0"
			id="sidebarToggle" href="#">
			<i class="fas fa-bars"></i>
		</button>

		<form
			class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0"
			action="view?action=search" method="post">
			<div class="input-group">
				<input type="text" class="form-control" name="pid" id="pid"
					placeholder="Search for..." autocomplete="off" aria-label="Search"
					aria-describedby="basic-addon2">

				<div class="input-group-append">
					<button class="btn btn-primary" type="button">
						<i class="fas fa-search"></i>
					</button>
				</div>
			</div>
		</form>

		<!-- Navbar -->
		<ul class="navbar-nav ml-auto ml-md-0">
			<li class="nav-item dropdown no-arrow mx-1"><a
				class="nav-link dropdown-toggle" href="#" id="alertsDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-bell fa-fw"></i> <span
					class="badge badge-danger"></span>
			</a></li>
			<li class="nav-item dropdown no-arrow mx-1"><a
				class="nav-link dropdown-toggle" href="#" id="messagesDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-envelope fa-fw"></i> <span
					class="badge badge-danger"></span>
			</a></li>
			<li class="nav-item dropdown no-arrow"><a
				class="nav-link dropdown-toggle" href="#" id="userDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-user-circle fa-fw"></i>
			</a>
				<div class="dropdown-menu dropdown-menu-right"
					aria-labelledby="userDropdown">
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="/login?action=logout"
						data-target="#logoutModal">Logout</a>
				</div></li>
		</ul>

	</nav>

	<div id="wrapper">

		<!-- Sidebar -->
		<ul class="sidebar navbar-nav">
			<li class="nav-item"><a class="nav-link"
				href="/view"
				style="text-decoration: none;"> <i
					class="fas fa-fw fa-home"></i> <span>Home</span>
			</a></li>
			<li class="nav-item dropdown">
			<li class="nav-item"><a class="nav-link" href="/view"> <i
				class="fas fa-fw fa-table"></i> <span>News Management</span></a></li>
			<li class="nav-item"><a class="nav-link" href="/api"> <i
					class="fas fa-fw fa-folder"></i> <span>API News</span></a></li>
			<!-- <li class="nav-item"><a class="nav-link" href="/comment"> <i
					class="fas fa-fw fa-comment"></i> <span>Comment News</span></a></li> -->
		</ul>
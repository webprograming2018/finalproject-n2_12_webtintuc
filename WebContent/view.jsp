<%@ page import="java.util.*"%>
<%@ page import="com.model.New"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="layout/header.jsp"%>
<link rel="stylesheet" href="//cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
<div id="content-wrapper">
		<center><h3 style="color: red">Danh sách tin tức</h3></center>
		<a href="/create?id=nulll" style="color: white;"><button type="button" class="xoa btn btn-primary"
		style="margin-left: 16px;"><i class="fas fa-plus-circle"></i>  Thêm mới</button></a>
	<br>
	<br>
	<div class="container-fluid">
		<div class="card mb-3">
			<div class="card-header">
				<i class="fas fa-table"></i> Danh sách Bài Viết
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="myTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>ID</th>
								<th style="width: 230px"><center>Tên</center></th>
								<th style="width: 100px;"><center>Danh mục</center></th>
								<th><center>Nội dung ngắn</center></th>
								<th style="width: 120px"><center>Tác giả</center></th>
								<th style="width: 90px;"><center>Hành Động</center></th>
							</tr>
						</thead>
						<%
							int count = 0;
							String color = "#99FF99";
							if (request.getAttribute("piList") != null) {
								ArrayList<New> al = (ArrayList) request.getAttribute("piList");
								for (New pList : al) {
									if ((count % 2) == 0) {
										color = "#CCFFFF";
									}
									count++;
						%>
						<form action="view?action=edit" method="post">
							<tr style="background-color:<%=color%>;35px;" class="edit_sp">
								<td><%=pList.getID()%></td>
								<td><%=pList.getName()%></td>
								<td><%=pList.getName_cate()%></td>
								<td><%=pList.getShort_content()%></td>
								<td><%=pList.getAuth()%></td>
								<td>
									<a href="/create?id=<%=pList.getID()%>" idsp=""
											style="color: white"><button type="button" class="xoa btn btn-warning"><i class="far fa-edit"></i></button></a>
									<button type="button" idsp=<%=pList.getID()%>
										class="delete btn btn-danger"><i class="fas fa-trash-alt"></i></button>
								</td>
							</tr>
						</form>
						<%
							}
							}
							if (count == 0) {
						%>
						<tr>
							<td colspan=5 align="center"
								style="background-color: #eeffee; color: red"><b>Không
									tìm thấy thông tin đã đăng nhập!</b></td>
						</tr>
						<%
							}
						%>

					</table>
				</div>
			</div>
			<!-- <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div> -->
		</div>
	</div>


</div>
<!-- /#wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top"> <i
	class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<div class="modal-body">Select "Logout" below if you are ready
				to end your current session.</div>
			<div class="modal-footer">
				<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
				<a class="btn btn-primary" href="login.html">Logout</a>
			</div>
		</div>
	</div>
</div>

<%@include file="layout/footer.jsp"%>
<script src="//cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script !src="">
    $(document).ready( function () {
        $('#myTable').DataTable({
        	"ordering": false
        });
    } );
</script>


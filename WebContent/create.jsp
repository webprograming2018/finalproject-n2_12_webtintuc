<%@page import="com.model.Category"%>
<%@ page import="java.util.*"%>
<%@ page import="com.model.New"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="layout/header.jsp"%>
<div class="container">
	<div class="card card-register mx-auto mt-5">
		<div class="card-header">
			<center>
				<h3 style="color:red">Bài Viết</h3>
			</center>
		</div>
		<div class="card-body">
			<form action="/create?action=update" method="POST" enctype="multipart/form-data">
				<input type="hidden" name="id" value="${news.ID}">
				<div class="form-group">
					<div class="form-row">
						<div class="col-md-6">
							<div class="form-label">
								<input type="text" id="name" name="name" class="form-control"
									placeholder="Tên bài viết" autocomplete="off"
									required="required" value="${news.name}" autofocus="autofocus">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-label">
								<input type="text" id="author" name="auth" class="form-control"
									placeholder="Tên Tác Giả" required="required"
									value="${news.auth}">
								
							</div>
						</div>

						<div class="col-md-6">
							<div class="form-label-group" id="input">
								<select name="type_of_news" class="form-control">
									<%
										New newss = null;
										if (request.getAttribute("news") != null) {
											newss = (New) request.getAttribute("news");
										}
											if (newss != null && newss.getTypeOfNew() == 1) {
									%>

										<option selected="selected" value="1"> Tin hot </option>
										<option value="0"> Tin thường</option>
									<%
										} else {
									%>
										<option value="1"> Tin hot </option>
										<option selected="selected" value="0"> Tin thường</option>
									<%

										}
									%>
								</select>
							</div>
						</div>


						<div class="col-md-6">
							<div class="form-label" id="input">
								<input type="date" id="datefield" name="exp"  min='1899-01-01' max='2019-12-12' class="form-control"
									placeholder="Ngày hết hạn" required="required"
									value="${news.exp}">

							</div>
						</div>

					</div>
				</div>
				<div class="form-group">
					<div class="form-label">
						<input type="text" id="short_content" name="short_content"
							class="form-control" autocomplete="off"
							placeholder="Nội dung ngắn" required="required"
							value="${news.short_content}">
					</div>
				</div>
				<div class="form-group">
					<div class="form-label-group">
						<h5>Nội Dung Chính</h5>
						<textarea name="content" {{('${news.content}')}}></textarea>
					</div>
				</div>
				<div class="form-group">
					<div class="form-row">
						<div class="col-md-6">
							<div class="form-label">
								<input type="file" name="image" value="${news.image}"
									class="form-control" placeholder="Ðường dẫn ảnh"
									style="height: 38px;">
									<span>${news.image}</span>
								<!-- <label for="Auth">File ?nh</label> -->
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-label-group">
								<select name="category_id" id="pet-select" class="form-control">
									<%
										ArrayList<Category> list = (ArrayList<Category>) request.getAttribute("cates");
										for (Category c : list) {

											if (newss != null && c.getId() == newss.getCategory_id()) {
									%>

									<option selected="selected" value="<%=c.getId()%>">
										<%=c.getName()%></option>
									<%
										} else {
									%>
									<option value="<%=c.getId()%>">
										<%=c.getName()%></option>
									<%
										}
										}
									%>
								</select>
							</div>
						</div>
					</div>
				</div>
				<input type="submit" value="Lưu"
					class="btn btn-primary btn-block">
			</form>
		</div>
	</div>
</div>
<script type="text/javascript">
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1; //January is 0!
	var yyyy = today.getFullYear();
	 if(dd<10){
	        dd='0'+dd
	    } 
	    if(mm<10){
	        mm='0'+mm
	    } 

	today = yyyy+'-'+mm+'-'+dd;
	document.getElementById("datefield").setAttribute("min", today);
</script>
<%@include file="layout/footer.jsp"%>

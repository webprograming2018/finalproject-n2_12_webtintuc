<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
        <div class="container">
            <div class="row">
                <div class="col-12 col-lg-8">
                    <div class="blog-posts-area">
                        <!-- Single Featured Post -->
                        <%List<Comment> listc = (ArrayList<Comment>)request.getAttribute("listcom"); %>
                        <div class="single-blog-post featured-post single-post">
                        	<div class="post-data">
                                    <h1>${news.name}</h1>
                        	</div>
                            <div class="post-thumb">
                                <a href="#"><img style="width: 750px;height: 350px;" src="image?name=${news.image}" alt=""></a>
                            </div>
                            <div class="post-data">        
                                <div class="post-meta">                           
                                    <p>${news.content}</p>
                                    <p class="post-author" style ="margin-top: -32px;color: blue; ">Theo <spam>${news.auth}</spam> (<spam>${news.createAt}</spam>)</p>
                                    <div class="newspaper-post-like d-flex align-items-center justify-content-between"  style = "margin-top: -52px;">
                                        <!-- Tags -->
                                        <div class="newspaper-tags d-flex">
                                            <!-- <span>Tags:</span>
                                            <ul class="d-flex">
                                                <li><a href="#">finacial,</a></li>
                                                <li><a href="#">politics,</a></li>
                                                <li><a href="#">stock market</a></li>
                                            </ul> -->
                                        </div>

                                        <!-- Post Like & Post Comment -->
                                        <div class="d-flex align-items-center post-like--comments">
                                            <a href="https://www.google.com.vn/" class="post-like"><img src="client/img/core-img/like.png" alt=""> <span>    </span></a>
                                            <a href="https://www.google.com.vn/" class="post-comment" id="click_coment"><img src="client/img/core-img/chat.png" alt=""> <span><%=listc.size() %></span></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="post-a-comment-area section-padding-80-0">
                            <h4>Comment</h4>
                            <!-- Reply Form -->
                            <div class="contact-form-area">
                                <form action="/detail?action=add-comment" method="post">
                                    <div class="row">
                                    	<div class="col-12">
                                            <input type="hidden" value="<%=request.getParameter("id") %>" class="form-control" id="news_id" required="" name="id-new"  placeholder="">
                                        </div>
                                        <div class="col-12">
                                            <input type="text" class="form-control" id="name" required="" name="name" placeholder="Name (*)">
                                        </div>
                                        <div class="col-12">
                                            <textarea name="content" class="form-control" id="message" cols="10" rows="3" placeholder="Message"></textarea>
                                        </div>
                                        <div class="col-12 text-center">
                                            <button class="btn newspaper-btn mt-30 w-100" type="submit">Submit Comment</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <!-- Comment Area Start -->
                        <div class="comment_area clearfix" id="coment">
                            <ol>
                                <!-- Single Comment Area -->
                                <li class="single_comment_area">
                                    <!-- Comment Content -->
                                    <%
                                    	
                                    if(listc != null){
                                    for(Comment com:listc){
                                    %>
                                    <div class="comment-content d-flex">
                                        <!-- Comment Author -->
                                        <div class="comment-author">
                                            <img src="client/img/bg-img/icon.jpg" alt="author">
                                        </div>
                                        <div class="comment-meta">
                                            <h3 class="post-author" style="color: blue"><%=com.getName() %></h3>
                                            <p class="post-date" style= "margin-left: 550px;"><%=com.getCreateAt() %></p>
                                            <p style="color: black"><%=com.getContent() %>.</p>
                                        </div>
                                    </div>
                                    <%} }%>
                                </li>
                            </ol>
                        </div>            
                    </div>
                </div>

<%@include file="footer.jsp"%>
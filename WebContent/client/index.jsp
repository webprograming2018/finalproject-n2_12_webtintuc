<%@ page import="java.util.List" %>
<%@ page import="com.model.New" %>
<%@ page import="com.model.ApiNew" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
        <div class="container">
            <div class="row">
                <div class="col-12 col-lg-8">
                    <div class="row">
                        <%
                            List<New> list = (List<New>) request.getAttribute("list");
                            for (New news : list){
                        %>
                        <div class="col-12 col-md-6 ">
                            <div class="single-blog-post style-3">
                                <div class="post-thumb post_thumb">
                                    <a href="/detail?id=<%=news.getID()%>"><img style="width: 300px;height: 260px;" src="/image?name=<%=news.getImage()%>" alt=""></a>
                                </div>
                                <div class="post-data">
                                    <a href="/detail?id=<%=news.getID()%>" class="post-catagory"><%=news.getName()%></a>
                                        <p style="color: black"><%=news.getShort_content()%></p>                                 
                                </div>
                            </div>
                        </div>
                        <%
                            }
                        %>
                    </div>
                    <ul class="pagination" style="margin-left: 300px">
                        <%
                            Integer size = (Integer) request.getAttribute("size");
                            Integer this_page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page"));
                            for(int i=1; i<=Math.ceil(size/6);i++){
                                if(this_page == i){
                        %>
                            <li class="active"><a href="/home?page=<%=i%>"><%=i%></a></li>
                        <%
                                }else{
                        %>
                            <li><a href="/home?page=<%=i%>"><%=i%></a></li>
                        <%        }
                            }
                        %>
                    </ul>
                </div>

<%@include file="footer.jsp"%>
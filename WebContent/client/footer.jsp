<%@ page import="java.util.List" %>
<%@ page import="com.model.ApiNew" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-12 col-lg-4">
    <div class="popular-news-widget mb-30">
        <%
            List<ApiNew> api = (List<ApiNew>) request.getAttribute("api");
            for (ApiNew n : api) {
        %>
        <div class="single-blog-post small-featured-post d-flex">
            <div class="post-thumb">
                <a href="#"><img style="width: 90px;height: 97px;" src="<%=n.getImage()%>" alt=""></a>
            </div>
            <div class="post-data">
                <a href="<%=n.getUrl()%>" class="post-catagory"><%=n.getTitle()%>
                </a>
                <div class="post-meta">
                    <a href="#" class="post-title">
                        <h6><%=n.getShort_content()%>
                        </h6>
                    </a>
                </div>
            </div>
        </div>
        <%
            }
        %>

    </div>

    <!-- Newsletter Widget -->
    <div class="newsletter-widget">
        <iframe src="https://www.facebook.com/plugins/page.php?href=https%3A%2F%2Fwww.facebook.com%2FNews-360-601668583600066%2F%3Fmodal%3Dadmin_todo_tour&tabs=timeline&width=335&height=500&small_header=false&adapt_container_width=true&hide_cover=false&show_facepile=true&appId" width="330" height="500" style="border:none;overflow:hidden" scrolling="no" frameborder="0" allowTransparency="true" allow="encrypted-media"></iframe>
    </div>
</div>
</div>
</div>
<div class="video-post-area bg-img bg-overlay" style="background-image: url(client/img/bg-img/bg1.jpg);">
    <div class="container">
        <div class="row justify-content-center">
            <!-- Single Video Post -->
            <div class="col-12 col-sm-6 col-md-4">
                <div class="single-video-post">
                    <img src="client/img/bg-img/video1.jpg" alt="">
                    <!-- Video Button -->
                    <div class="videobtn">
                        <iframe width="560" height="315" src="https://www.youtube.com/embed/VBH841FH0SM" frameborder="0"
                                allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
                                allowfullscreen></iframe>
                    </div>
                </div>
            </div>

            <!-- Single Video Post -->
            <div class="col-12 col-sm-6 col-md-4">
                <div class="single-video-post">
                    <img src="client/img/bg-img/video2.jpg" alt="">
                    <!-- Video Button -->
                    <div class="videobtn">
                        <iframe width="560" height="315" src="https://www.youtube.com/embed/MiCNblocTtA" frameborder="0"
                                allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
                                allowfullscreen></iframe>
                    </div>
                </div>
            </div>

            <!-- Single Video Post -->
            <div class="col-12 col-sm-6 col-md-4">
                <div class="single-video-post">
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3725.2820885935935!2d105.78529261432317!3d20.981326586024053!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135accdcf7b0bd1%3A0xc1cf5dd00247628a!2zSOG7jWMgVmnhu4duIEPDtG5nIG5naOG7hyBCxrB1IENow61uaCBWaeG7hW4gVGjDtG5n!5e0!3m2!1svi!2s!4v1545667939999"
                            width="350" height="250" frameborder="0" style="border:0" allowfullscreen></iframe>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

<!-- Nội dung 2 năm ơ đây -->


<!-- footer ơ đây -->
<div class="footer-add-area">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="footer-add">
                    <a href="#"><img src="client/img/bg-img/footer-add.gif" alt=""></a>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- ##### Footer Add Area End ##### -->

<!-- ##### Footer Area Start ##### -->
<footer class="footer-area">

    <!-- Main Footer Area -->
    <div class="main-footer-area">
        <div class="container">
            <div class="row">

                <!-- Footer Widget Area -->
                <div class="col-12 col-sm-6 col-lg-4">
                    <div class="footer-widget-area mt-80">
                        <!-- Footer Logo -->
                        <div class="footer-logo">
                            <a href="/home"><img src="client/img/core-img/logo.png" alt=""></a>
                        </div>
                        <!-- List -->
                        <ul class="list">
                            <li><a href="#">news360@youremail.com</a></li>
                            <li><a href="#">+98 9876400</a></li>
                            <li><a href="/home">www.news360.com.vn</a></li>
                        </ul>
                    </div>
                </div>

                <!-- Footer Widget Area -->
                <div class="col-12 col-sm-6 col-lg-2">
                    <div class="footer-widget-area mt-80">
                        <!-- Title -->
                        <h4 class="widget-title">Chính trị</h4>
                        <!-- List -->
                        <ul class="list">
                            <li><a href="#">Việt Nam</a></li>
                            <li><a href="#">Mỹ</a></li>
                            <li><a href="#">Nga</a></li>
                            <li><a href="#">Iran</a></li>
                        </ul>
                    </div>
                </div>

                <!-- Footer Widget Area -->
                <div class="col-12 col-sm-4 col-lg-2">
                    <div class="footer-widget-area mt-80">
                        <!-- Title -->
                        <h4 class="widget-title">Nội bật</h4>
                        <!-- List -->
                        <ul class="list">
                            <li><a href="#">Bóng Dá</a></li>
                            <li><a href="#">Showbiz</a></li>
                            <li><a href="#">Tennis</a></li>
                            <li><a href="#">Điện ảnh</a></li>
                        </ul>
                    </div>
                </div>

                <!-- Footer Widget Area -->
                <div class="col-12 col-sm-4 col-lg-2">
                    <div class="footer-widget-area mt-80">
                        <!-- Title -->
                        <h4 class="widget-title">Văn hóa</h4>
                        <!-- List -->
                        <ul class="list">
                            <li><a href="#">Việt Nam</a></li>
                            <li><a href="#">Dân tộc</a></li>
                            <li><a href="#">Thái Lan</a></li>
                            <li><a href="#">Ấn Độ</a></li>
                        </ul>
                    </div>
                </div>

                <!-- Footer Widget Area -->
                <div class="col-12 col-sm-4 col-lg-2">
                    <div class="footer-widget-area mt-80">
                        <!-- Title -->
                        <h4 class="widget-title">Lịch sử</h4>
                        <!-- List -->
                        <ul class="list">
                            <li><a href="#">Việt Nam</a></li>
                            <li><a href="#">Thế Giới</a></li>
                            
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bottom Footer Area -->
    <div class="bottom-footer-area">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <!-- Copywrite -->
                    <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        Bản quyền thuộc News360.com.vn
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- ##### Footer Area Start ##### -->

<!-- ##### All Javascript Files ##### -->
<!-- jQuery-2.2.4 js -->
<script src="client/js/jquery/jquery-2.2.4.min.js"></script>
<!-- Popper js -->
<script src="client/js/bootstrap/popper.min.js"></script>
<!-- Bootstrap js -->
<script src="client/js/bootstrap/bootstrap.min.js"></script>
<!-- All Plugins js -->
<script src="client/js/plugins/plugins.js"></script>
<!-- Active js -->
<script src="client/js/active.js"></script>
<script src="client/js/home.js"></script>
</body>

</html>
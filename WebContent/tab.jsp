<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="layout/header.jsp"%>
<style>
    body {font-family: Arial;}

    /* Style the tab */
    .tab {
        overflow: hidden;
        border: 1px solid #ccc;
        background-color: #f1f1f1;
    }

    /* Style the buttons inside the tab */
    .tab button {
        background-color: inherit;
        float: left;
        border: none;
        outline: none;
        cursor: pointer;
        padding: 14px 16px;
        transition: 0.3s;
        font-size: 17px;
    }

    /* Change background color of buttons on hover */
    .tab button:hover {
        background-color: #ddd;
    }

    /* Create an active/current tablink class */
    .tab button.active {
        background-color: #ccc;
    }

    /* Style the tab content */
    .tabcontent {
        display: none;
        padding: 6px 12px;
        border: 1px solid #ccc;
        border-top: none;
    }
    .tabcontent a {
        text-decoration: none;
        color: black;
        font-size: 17px;
    }
    .tabcontent a:hover{
        color: blue;
    }
    .tabcontent form{
        display: flex;
    }
</style>
<div class="container">
    <div class="tab">
        <button rel="tab1" class="tablinks">Bài viết đã chọn</button>
        <button rel="tab2" class="tablinks">Bài viết chờ duyệt</button>
    </div>

    <div id="tab1" class="tabcontent">
        <h3>Đã chọn</h3>
    </div>
    <!-- <center><h3>Lựa chọn bài viết phù hợp</h3></center> -->
    <section>
    	
        <center><div id="result"></div></center>
        <div id="tab2" class="tabcontent" name="tab2">
        </div>
    </section>
</div>

<%@include file="layout/footer.jsp"%>
<script>
    $(document).ready(function() {
        $('.tablinks').on('click', function () {
            $('.active').removeClass("active");
            $('.tabcontent').hide();
            $(this).addClass("active");
            var rel = $(this).attr("rel");
            $('#'+rel).show();
            if(rel === "tab2"){
                showData();
            }else {
                loadSelected();
            }
        });
        $('button[rel="tab1"]').addClass("active");
        $('#tab1').show();
        function showData() {
            var url = "https://api.nytimes.com/svc/topstories/v2/home.json";
            url += '?' + $.param({
                'api-key': "cc452b029ca94fa7ad1beacee2d026b8"
            });
            $.ajax({
                url: url,
                method: 'GET',
            }).done(function(result) {
                console.log(result);
                $('#tab2').children().remove();
                result.results.forEach(function(item){
                    if(item.multimedia.length > 0){
                        $('#tab2').append('<form class="add-api">'+
                            '<div id="tab2_content"'+
                            '<div class="col-md-2">'+'</div>'+
                            '<div class="col-md-7">'+
                            '<a href="'+item.short_url+'">'+item.title+'</a>'+
                            '<input type="hidden" name="title" value="'+item.title+'" class="form-control">'+
                            '<input type="hidden" name="abstract" value="'+item.abstract+'" class="form-control">'+
                            '<input type="hidden" name="short-url" value="'+item.short_url+'" class="form-control">'+
                            '<input type="hidden" name="image" value="'+item.multimedia[2].url+'" class="form-control">'+
                            '</div>'+
                            '<div class="col-md-3">'+
                            '<button type="submit" class="btn btn-primary">Thêm</button>'+
                            '</div>'+
                            '</div>'+
                            '</form>')
                    }
                })
            }).fail(function(err) {
                throw err;
            });
        }

        $(document).on('submit', '.add-api', function (e) {
            e.preventDefault();
            console.log("ads")
            var form = $(this).serialize();
            $.ajax({
                url : '/api?action=add',
                type : 'POST',
                data: form,
                cache   : false,
                success : function (res) {
                    console.log(res)
                    if(res === "true"){
                        $("#result").html('Successfully! Thêm bài thành công!');
                        $("#result").addClass("alert alert-success");
                    }else {
                        if(res === "false"){
                            $("#result").html('Error! Thêm bài thất bại!');
                            $("#result").addClass("alert alert-danger");
                        }else{
                            $("#result").html('Bài chọn đã tồn tại');
                            $("#result").addClass("alert alert-danger");
                        }
                    }
                    setTimeout(function () {
                        $("#result").html('');
                        $("#result").removeClass("alert alert-danger");
                    }, 5000)
                },
                error : function (fail) {

                }
            })
        })
        function loadSelected() {
            $.ajax({
                url: '/api?action=load',
                method: 'POST',
                dataType: 'json',
                contentType: 'application/json',
            }).done(function(result) {
                console.log(result);
                if(result.length > 0){
                    $('#tab1').children().remove();
                    result.forEach(function(item){
                        $('#tab1').append('<form class="cancel-api">'+
                            '<div id="tab2_content"'+
                            '<div class="col-md-2">'+'</div>'+
                            '<div class="col-md-7">'+
                            '<a href="'+item.short_url+'">'+item.title+'</a>'+
                            '<input type="hidden" name="id" value="'+item.id+'" class="form-control">'+
                            '</div>'+
                            '<div class="col-md-3">'+
                            '<button type="submit" class="btn btn-danger">Hủy</button>'+
                            '</div>'+
                            '</div>'+
                            '</form>')
                    })
                }
            }).fail(function(err) {
                throw err;
            });
        }
        loadSelected();
        $(document).on('submit', '.cancel-api', function (e) {
            e.preventDefault();
            var form = $(this).serialize();
            $.ajax({
                url : '/api?action=cancel',
                type : 'POST',
                data: form,
                cache   : false,
                success : function (res) {
                    console.log(res)
                    if(res === "true"){
                        loadSelected();
                    }else {
                        alert("lỗi")
                    }
                },
                error : function (fail) {

                }
            })
        })
    });
</script>
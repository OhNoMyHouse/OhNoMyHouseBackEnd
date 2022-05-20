<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>나는 집이 없어 행복하지 않아요.</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta content="" name="keywords"/>
    <meta content="" name="description"/>

    <!-- Favicons -->
    <link href="../img/favicon.png" rel="icon"/>
    <link href="../img/apple-touch-icon.png" rel="apple-touch-icon"/>

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Montserrat:300,400,500,700"
          rel="stylesheet"/>

    <!-- Bootstrap CSS File -->
    <link href="../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>

    <!-- Libraries CSS Files -->
    <link href="../lib/font-awesome/css/font-awesome.min.css" rel="stylesheet"/>
    <link href="../lib/animate/animate.min.css" rel="stylesheet"/>
    <link href="../lib/ionicons/css/ionicons.min.css" rel="stylesheet"/>
    <link href="../lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet"/>
    <link href="../lib/lightbox/css/lightbox.min.css" rel="stylesheet"/>

    <!-- Main Stylesheet File -->
    <link href="../css/style.css" rel="stylesheet"/>
</head>
<body>
<!--==========================
  Header
============================-->
<header id="header" style="background: rgba(0, 0, 0, 0.9); padding: 20px 0; height: 72px; transition: all 0.5s">
    <div class="container-fluid">
        <div id="logo" class="pull-left">
            <h1><a href="${root}/index.jsp" class="scrollto">OhNoMyHouse</a></h1>
        </div>
    </div>
</header>
<!-- #header -->
<!--==========================
  Main
============================-->
<div style="margin-top: 300px;">
    <h1> 실행 시 문제가 발생하였습니다. <br/> ${errorMsg} </h1>
    <%-- 홈으로 돌아가는 버튼 --%>
    <a href="${root}/index.jsp">메인으로 이동</a>
</div>
<!--==========================
Footer
============================-->
<footer id="footer">
    <div class="footer-top">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 footer-contact">
                    <h4>Find Us</h4>
                    <p>
                        (SSAFY) 서울시 강남구 테헤란로 멀티스퀘어<br/>
                        <strong>Phone:</strong> +1 1544 9001<br/>
                        <strong>Email:</strong> admin@ssafy.com<br/>
                    </p>
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- #footer -->
<!-- JavaScript Libraries -->
<script src="lib/jquery/jquery.min.js"></script>
<script src="lib/jquery/jquery-migrate.min.js"></script>
<script src="lib/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="lib/easing/easing.min.js"></script>
<script src="lib/superfish/hoverIntent.js"></script>
<script src="lib/superfish/superfish.min.js"></script>
<script src="lib/wow/wow.min.js"></script>
<script src="lib/waypoints/waypoints.min.js"></script>
<script src="lib/counterup/counterup.min.js"></script>
<script src="lib/owlcarousel/owl.carousel.min.js"></script>
<script src="lib/isotope/isotope.pkgd.min.js"></script>
<script src="lib/lightbox/js/lightbox.min.js"></script>
<script src="lib/touchSwipe/jquery.touchSwipe.min.js"></script>

<!-- Template Main Javascript File -->
<script src="./js/main.js"></script>
</body>
</html>
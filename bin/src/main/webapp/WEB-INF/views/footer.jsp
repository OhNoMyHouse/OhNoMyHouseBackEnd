<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>

<!-- JavaScript Libraries -->
<script src="${root}/lib/jquery/jquery.min.js"></script>
<script src="${root}/lib/jquery/jquery-migrate.min.js"></script>
<script src="${root}/lib/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="${root}/lib/easing/easing.min.js"></script>
<script src="${root}/lib/superfish/hoverIntent.js"></script>
<script src="${root}/lib/superfish/superfish.min.js"></script>
<script src="${root}/lib/wow/wow.min.js"></script>
<script src="${root}/lib/waypoints/waypoints.min.js"></script>
<script src="${root}/lib/counterup/counterup.min.js"></script>
<script src="${root}/lib/owlcarousel/owl.carousel.min.js"></script>
<script src="${root}/lib/isotope/isotope.pkgd.min.js"></script>
<script src="${root}/lib/lightbox/js/lightbox.min.js"></script>
<script src="${root}/lib/touchSwipe/jquery.touchSwipe.min.js"></script>

<!-- Template Main Javascript File -->
<script src="${root}/js/main.js"></script>
<script>
    var container1 = document.getElementById('map1');
    var container2 = document.getElementById('map2');
    var container3 = document.getElementById('map3');
    var container4 = document.getElementById('map4');
    var container5 = document.getElementById('map5');
    var container6 = document.getElementById('map6');
    var options = {
        center: new kakao.maps.LatLng(33.450701, 126.570667),
        level: 3,
    };

    var map1 = new kakao.maps.Map(container1, options);
    var map2 = new kakao.maps.Map(container2, options);
    var map3 = new kakao.maps.Map(container3, options);
    var map4 = new kakao.maps.Map(container4, options);
    var map5 = new kakao.maps.Map(container5, options);
    var map6 = new kakao.maps.Map(container6, options);
</script>
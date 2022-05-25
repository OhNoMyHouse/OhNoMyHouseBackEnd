<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="/WEB-INF/views/head.jsp"></jsp:include>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

<!--==========================
  Intro Section
============================-->
<section id="intro">
    <div class="intro-container">
        <div id="introCarousel" class="carousel slide carousel-fade" data-ride="carousel">
            <ol class="carousel-indicators"></ol>
            <div class="carousel-inner" role="listbox">
                <div class="carousel-item active" style="background-image: url('/img/intro-carousel/1.jpg')">
                    <div class="carousel-container">
                        <div class="carousel-content">
                            <h2>나는 집이 없어 행복하지 않아요.</h2>
                            <p></p>
                            <a href="#featured-services" class="btn-get-started scrollto">나에게 맞는 집 찾기</a>
                        </div>
                    </div>
                </div>
                <div class="carousel-item" style="background-image: url('/img/intro-carousel/2.jpg')">
                    <div class="carousel-container">
                        <div class="carousel-content">
                            <h2>서울에서 나의 집을 찾고 싶다고요?</h2>
                            <p></p>
                            <a href="#featured-services" class="btn-get-started scrollto">나에게 맞는 집 찾기</a>
                        </div>
                    </div>
                </div>

                <div class="carousel-item" style="background-image: url('/img/intro-carousel/3.jpg')">
                    <div class="carousel-container">
                        <div class="carousel-content">
                            <h2>우리가 당신을 도와드립니다.</h2>
                            <p></p>
                            <a href="#featured-services" class="btn-get-started scrollto">나에게 맞는 집 찾기</a>
                        </div>
                    </div>
                </div>

                <div class="carousel-item" style="background-image: url('/img/intro-carousel/4.jpg')">
                    <div class="carousel-container">
                        <div class="carousel-content">
                            <h2>내 집 마련이 고민이라고요?</h2>
                            <p></p>
                            <a href="#featured-services" class="btn-get-started scrollto">나에게 맞는 집 찾기</a>
                        </div>
                    </div>
                </div>

                <div class="carousel-item" style="background-image: url('/img/intro-carousel/5.jpg')">
                    <div class="carousel-container">
                        <div class="carousel-content">
                            <h2>내 연봉으로 집을 살 수 있을까 고민이라고요?</h2>
                            <p></p>
                            <a href="#featured-services" class="btn-get-started scrollto">나에게 맞는 집 찾기</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- #intro -->

<!-- Stack part -->
<section id="info">
    <div class="container">
        <header class="section-header wow fadeInUp">
            <h3>공지사항</h3>
        </header>
        <table id="table" class="table w-75 mt-5 mx-auto">
            <thead>
            <tr>
                <th scope="col">번 호</th>
                <th scope="col">제 목</th>
                <th scope="col">내 용</th>
                <th scope="col">
                    <a href="${root}/board/makepoll_form.do">추가</a>
                </th>
            </tr>
            </thead>
            <tbody>
            <c:choose>
                <c:when test="${not empty boardList}">
                    <c:forEach items="${boardList}" var="board">
                        <tr>
                            <th><a href="${root}/board/update_form.do?idx=${board.idx}">${board.idx}</a></th>
                            <td>${board.title}</td>
                            <td colspan="2">${board.content}</td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr>
                        <th></th>
                        <td></td>
                        <td colspan="2"></td>
                    </tr>
                </c:otherwise>
            </c:choose>
            </tbody>
        </table>
    </div>
</section>
<!------------------->
<!--==========================
  Services Section
============================-->
<section id="services">
    <div class="container">
        <header class="section-header wow fadeInUp">
            <h3>지혜롭게 내 집 마련하기</h3>
            <p></p>
        </header>
        <div class="row">
            <div class="col-lg-4 col-md-6 box wow bounceInUp" data-wow-duration="1.4s">
                <div class="icon"><i class="ion-ios-analytics-outline"></i></div>
                <h4 class="title"><a href="">가용자금 확인 및 대출 계획</a></h4>
                <p class="description"></p>
            </div>
            <div class="col-lg-4 col-md-6 box wow bounceInUp" data-wow-duration="1.4s">
                <div class="icon"><i class="ion-ios-bookmarks-outline"></i></div>
                <h4 class="title"><a href="">집 종류 및 지역 선택</a></h4>
                <p class="description"></p>
            </div>
            <div class="col-lg-4 col-md-6 box wow bounceInUp" data-wow-duration="1.4s">
                <div class="icon"><i class="ion-ios-paper-outline"></i></div>
                <h4 class="title"><a href="">정보수집 & 시세 파악</a></h4>
                <p class="description"></p>
            </div>
            <div class="col-lg-4 col-md-6 box wow bounceInUp" data-wow-delay="0.1s" data-wow-duration="1.4s">
                <div class="icon"><i class="ion-ios-speedometer-outline"></i></div>
                <h4 class="title"><a href="">부동산 방문 & 집구경</a></h4>
                <p class="description"></p>
            </div>
            <div class="col-lg-4 col-md-6 box wow bounceInUp" data-wow-delay="0.1s" data-wow-duration="1.4s">
                <div class="icon"><i class="ion-ios-barcode-outline"></i></div>
                <h4 class="title"><a href="">계약 및 잔금 치르기</a></h4>
                <p class="description"></p>
            </div>
            <div class="col-lg-4 col-md-6 box wow bounceInUp" data-wow-delay="0.1s" data-wow-duration="1.4s">
                <div class="icon"><i class="ion-ios-people-outline"></i></div>
                <h4 class="title"><a href="">소유권 이전등기</a></h4>
                <p class="description"></p>
            </div>
        </div>
    </div>
</section>
<!-- #services -->
<main id="main">
    <!--==========================
      아파트 조회 Us Section
    ============================-->
    <section class="about" id="1">
        <div class="container">
            <header class="section-header">
                <h3>아파트 조회</h3>
                <div class="row about-cols flex">
                    <div class="box form-inline justify-content-center">
                        <select class="form-control" id="sido">
                            <option value="*">시/도</option>
                        </select>
                        <select class="form-control" id="gugun">
                            <option value="*">구/군</option>
                        </select>
                        <select class="form-control" id="dong">
                            <option value="*">동</option>
                        </select>
                    </div>
                </div>
                <p>원하는 지역의 아파트를 조회할 수 있습니다.</p>
                <div class="row about-cols">
                    <div class="box flex">
                        <input type="text" id="word"/>
                    </div>
                </div>
                <p>원하는 아파트 이름으로 실거래가를 조회할 수 있습니다.</p>
            </header>

            <div class="row about-cols">
                <div>
                    <h5>거래 정보</h5>
                    <div style="overflow:auto; width:200px; height: 450px" id="aptInfoByDongCode">
                    </div>
                </div>
                <div id="map1" style="width: 380px; height: 450px;"></div>
            </div>
        </div>
    </section>
    <!-- #about -->

    <!--==========================
      관심 지역 등록 Us Section
    ============================-->
    <section class="about" id="4">
        <div class="container">
            <header class="section-header">
                <h3>관심 지역 등록</h3>
                <p>내가 관심 있는 지역을 등록할 수 있습니다.</p>
            </header>

            <div class="row about-cols">
                <!-- Map Position -->
                <div>
                    <!-- 실거래 정보 출력 -->
                    <div>
                        <h5>거래 정보</h5>
                    </div>
                </div>
                <div id="map4" style="width: 380px; height: 450px"></div>

                <!-- <div>
                  <a href="https://placeholder.com"><img src="http://via.placeholder.com/380x450"></a>
                </div> -->
            </div>
        </div>
    </section>
    <!-- #about -->

    <!--==========================
      Site Map
    ============================-->
    <section class="about" id="7">
        <div class="container">
            <header class="section-header">
                <h3>Site Map</h3>
                <p>해당 사이트의 맵을 볼 수 있습니다.</p>
            </header>

            <div class="row about-cols">
                <!-- Map Position -->
                <div>
                    <img src="${root}/img/sitemap.jpg" style="width: 1000px; height: 800px" alt="">
                </div>
            </div>
        </div>
    </section>
    <!-- #about -->
</main>

<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>

</html>
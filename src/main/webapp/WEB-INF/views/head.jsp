<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>

    <meta charset="utf-8"/>
    <title>나는 집이 없어 행복하지 않아요.</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta content="" name="keywords"/>
    <meta content="" name="description"/>
    <link href="${root}/img/favicon.png" rel="icon"/>
    <link href="${root}/img/favicon.png" rel="icon"/>

    <!-- Favicons -->
    <link href="${root}/img/favicon.png" rel="icon"/>
    <link href="${root}/img/apple-touch-icon.png" rel="apple-touch-icon"/>

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Montserrat:300,400,500,700"
          rel="stylesheet"/>

    <!-- Bootstrap CSS File -->
    <link href="${root}/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>

    <!-- Main Stylesheet File -->
    <link href="${root}/css/style.css" rel="stylesheet"/>

    <!-- Libraries CSS Files -->
    <link href="${root}/lib/font-awesome/css/font-awesome.min.css"
          rel="stylesheet"/>
    <link href="${root}/lib/animate/animate.min.css" rel="stylesheet"/>
    <link href="${root}/lib/ionicons/css/ionicons.min.css" rel="stylesheet"/>
    <link href="${root}/lib/owlcarousel/assets/owl.carousel.min.css"
          rel="stylesheet"/>
    <link href="${root}/lib/lightbox/css/lightbox.min.css" rel="stylesheet"/>

    <!-- Main Stylesheet File -->
    <link href="${root}/css/style.css" rel="stylesheet"/>

    <style>
        .about-cols {
            display: flex;
            flex-direction: row;
            justify-content: space-evenly;
        }
    </style>
    <script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="${root}/js/main.js"></script>
    <script type="text/javascript"
            src="//dapi.kakao.com/v2/maps/sdk.js?appkey=13195c6e1a069f22f4340a26aec44a00&libraries=services"></script>
    <script>
        $(document).ready(function () {
            // 서치
            $('#searchBox-id').keydown(function (e) {
                if (e.keyCode == 13) {
                    console.log($('#searchBox-id').val());
                }
            });

            // 공지사항 버튼 삭제
            let info = document.querySelectorAll("#btn-remove");
            for (let i = 0; i < info.length; i++) {
                info[i].addEventListener("click", function () {
                    info[i].parentElement.parentElement.remove();
                });
            }

            // 아파트 조회 검색
            // $(document).on("click", "#submitAptNameForAptDeal", function () {
            $('#word').keydown(function (e) {
                if (e.keyCode == 13) {
                    $.get(root + "/map/search"
                        , {word: $("#word").val()}
                        , function (data, status) {
                            $("#aptInfoByDongCode").empty();
                            let list = ``;
                            console.log(data);
                            $.each(data, function (index, vo) {
                                list += '<p style="border-bottom: solid gray 1px; font-size: 10px;">' +
                                    vo.aptName + '<br>' +
                                    '동: ' + vo.dongName + '<br>' +
                                    '가격: ' + vo.recentPrice + '</p>';
                            });
                            $("#aptInfoByDongCode").append(list);
                            displayMarkers(data);
                            $('#word').val(null);
                        }
                        , "json"
                    );
                }
            });
        });

        function search() {
            console.log($('#searchBox-id').val());
        }
    </script>

    <script type="text/javascript">
        let colorArr = ['table-primary', 'table-success', 'table-danger'];
        $(document).ready(function () {
            $.get(root + "/map/sido"
                , function (data, status) {
                    $.each(data, function (index, vo) {
                        $("#sido").append("<option value='" + vo.sidoCode + "'>" + vo.sidoName + "</option>");
                    });
                }
                , "json"
            );
        });
        $(document).on("change", "#sido", function () {
            $.get(root + "/map/gugun"
                , {sido: $("#sido").val()}
                , function (data, status) {
                    $("#gugun").empty();
                    $("#gugun").append('<option value="0">구/군</option>');
                    $.each(data, function (index, vo) {
                        $("#gugun").append("<option value='" + vo.gugunCode + "'>" + vo.gugunName + "</option>");
                    });
                }
                , "json"
            );
        });
        $(document).on("change", "#gugun", function () {
            $.get(root + "/map/dong"
                , {gugun: $("#gugun").val()}
                , function (data, status) {
                    $("#dong").empty();
                    $("#dong").append('<option value="0">동</option>');
                    $.each(data, function (index, vo) {
                        $("#dong").append("<option value='" + vo.dongCode + "'>" + vo.dongName + "</option>");
                    });
                }
                , "json"
            );
        });
        $(document).on("change", "#dong", function () {
            $.get(root + "/map/apt"
                , {dong: $("#dong").val()}
                , function (data, status) {
                    $("#aptInfoByDongCode").empty();
                    let list = ``;
                    $.each(data, function (index, vo) {
                        list += '<p style="border-bottom: solid gray 1px; font-size: 10px;">' +
                            vo.aptName + '<br>' +
                            '동: ' + vo.dongName + '<br>' +
                            '가격: ' + vo.recentPrice + '</p>';
                    });
                    $("#aptInfoByDongCode").append(list);
                    displayMarkers(data);
                }
                , "json"
            );
        });
    </script>

    <%--
    <script type="text/javascript">
        $(function () {
            $.ajax({
                url: 'region.do',
                type: 'post',
                data: {
                    act: 'sido'
                },
                dataType: 'json',
                success: function (response) {
                    console.log(response);
                    makeSigugun("sido", response);
                },
                error: function (err) {
                    console.log(err);
                },
            });
        });
        $(document).on("change", "#sido", function () {
            let sidoName = $(this).val();
            $.ajax({
                url: 'region.do',
                type: 'post',
                data: {
                    act: 'gugun',
                    sido: sidoName,
                },
                dataType: 'json',
                success: function (response) {
                    console.log(response);
                    makeSigugun("gugun", response);
                },
                error: function (err) {
                    console.log(err);
                },
            });
        });

        $(document).on("change", "#gugun", function () {
            let sidoName = $('#sido').val();
            let gugunName = $(this).val();
            $.ajax({
                url: 'region.do',
                type: 'post',
                data: {
                    act: 'dong',
                    sido: sidoName,
                    gugun: gugunName,
                },
                dataType: 'json',
                success: function (response) {
                    console.log(response);
                    makeSigugun("dong", response);
                },
                error: function (err) {
                    console.log(err);
                },
            });
        });

        function makeSigugun(type, data) {
            let list = ``;
            let initOption = '';

            switch (type) {
                case "sido":
                    initOption = '<option>시도선택</option>';
                    $("#sido").empty().append(initOption);

                    $.each(data, function (i, v) {
                        list += '<option value="' + v.name + '">' + v.name + '</option>';
                    });
                    $("#sido").append(list);
                    break;
                case "gugun":
                    initOption = '<option>구군선택</option>';
                    $("#gugun").empty().append(initOption);
                    initOption = '<option>동선택</option>';
                    $("#dong").empty().append(initOption);
                    $.each(data, function (i, v) {
                        list += '<option value="' + v.name + '">' + v.name + '</option>';
                    });
                    $("#gugun").append(list);
                    break;
                case "dong":
                    initOption = '<option>동선택</option>';
                    $("#dong").empty().append(initOption);

                    $.each(data, function (i, v) {
                        list += '<option value="' + v.name + '">' + v.name + '</option>';
                    });
                    $("#dong").append(list);
                    break;

                default:
                    break;
            }
        }

        function submitSigundongForAptInfo() {
            let sidoName = $('#sido').val();
            let gugunName = $('#gugun').val();
            let dongName = $('#dong').val();
            $.ajax({
                url: 'search/InfoWithDongCode.do',
                type: 'post',
                data: {
                    sido: sidoName,
                    gugun: gugunName,
                    dong: dongName
                },
                dataType: 'json',
                success: function (response) {
                    console.log(response);
                    $("#aptInfoByDongCode").empty();
                    let list = ``;
                    $.each(response, function (i, v) {
                        list += '<p style="border-bottom: solid gray 1px; font-size: 10px; margin-top: -15px;">' +
                            '<br>' + v.aptName + '<br>' +
                            '동 :' + v.dongName + '<br>' +
                            '건축 년도: ' + v.buildYear + '<br></p>';
                    });
                    $("#aptInfoByDongCode").append(list);
                },
                error: function (err) {
                    console.log(err);
                },
            });
        }
    </script>

    <script type="text/javascript">
        $(function () {
            $.ajax({
                url: 'region.do',
                type: 'post',
                data: {
                    act: 'sido'
                },
                dataType: 'json',
                success: function (response) {
                    console.log(response);
                    makeSigugun1("sido", response);
                },
                error: function (err) {
                    console.log(err);
                },
            });
        });
        $(document).on("change", "#sido1", function () {
            let sidoName = $(this).val();
            $.ajax({
                url: 'region.do',
                type: 'post',
                data: {
                    act: 'gugun',
                    sido: sidoName,
                },
                dataType: 'json',
                success: function (response) {
                    console.log(response);
                    makeSigugun1("gugun", response);
                },
                error: function (err) {
                    console.log(err);
                },
            });
        });

        $(document).on("change", "#gugun1", function () {
            let sidoName = $('#sido1').val();
            let gugunName = $(this).val();
            $.ajax({
                url: 'region.do',
                type: 'post',
                data: {
                    act: 'dong',
                    sido: sidoName,
                    gugun: gugunName,
                },
                dataType: 'json',
                success: function (response) {
                    console.log(response);
                    makeSigugun1("dong", response);
                },
                error: function (err) {
                    console.log(err);
                },
            });
        });

        function makeSigugun1(type, data) {
            let list = ``;
            let initOption = '';

            switch (type) {
                case "sido":
                    initOption = '<option>시도선택</option>';
                    $("#sido1").empty().append(initOption);

                    $.each(data, function (i, v) {
                        list += '<option value="' + v.name + '">' + v.name + '</option>';
                    });
                    $("#sido1").append(list);
                    break;
                case "gugun":
                    initOption = '<option>구군선택</option>';
                    $("#gugun1").empty().append(initOption);
                    initOption = '<option>동선택</option>';
                    $("#dong1").empty().append(initOption);
                    $.each(data, function (i, v) {
                        list += '<option value="' + v.name + '">' + v.name + '</option>';
                    });
                    $("#gugun1").append(list);
                    break;
                case "dong":
                    initOption = '<option>동선택</option>';
                    $("#dong1").empty().append(initOption);

                    $.each(data, function (i, v) {
                        list += '<option value="' + v.name + '">' + v.name + '</option>';
                    });
                    $("#dong1").append(list);
                    break;

                default:
                    break;
            }
        }

        function submitSigundongForAptDeal() {
            let sidoName = $('#sido1').val();
            let gugunName = $('#gugun1').val();
            let dongName = $('#dong1').val();
            $.ajax({
                url: 'search/DealWithDongCode.do',
                type: 'post',
                data: {
                    sido: sidoName,
                    gugun: gugunName,
                    dong: dongName
                },
                dataType: 'json',
                success: function (response) {
                    console.log(response);
                    $("#aptDealByDongCode").empty();
                    let list = ``;
                    $.each(response, function (i, v) {
                        list += '<p style="border-bottom: solid gray 1px; font-size: 10px; margin-top: -15px;">' +
                            '<br>' + v.aptName + '<br>' +
                            '동 :' + v.dongName + '<br>' +
                            '층 :' + v.floor + '<br>' +
                            '거래 날짜 :' + v.dealYear + '/' + v.dealMonth + '/' + v.dealDay + '<br>' +
                            '면적 :' + v.area + '<br>' +
                            '가격: ' + v.dealAmount + '<br></p>';
                    });
                    $("#aptDealByDongCode").append(list);
                },
                error: function (err) {
                    console.log(err);
                },
            });
        }
    </script>



    <script type="text/javascript">
        $(function () {
            $.ajax({
                url: 'region.do',
                type: 'post',
                data: {
                    act: 'sido'
                },
                dataType: 'json',
                success: function (response) {
                    console.log(response);
                    makeSigugun2("sido", response);
                },
                error: function (err) {
                    console.log(err);
                },
            });
        });
        $(document).on("change", "#sido2", function () {
            let sidoName = $(this).val();
            $.ajax({
                url: 'region.do',
                type: 'post',
                data: {
                    act: 'gugun',
                    sido: sidoName,
                },
                dataType: 'json',
                success: function (response) {
                    console.log(response);
                    makeSigugun2("gugun", response);
                },
                error: function (err) {
                    console.log(err);
                },
            });
        });

        $(document).on("change", "#gugun2", function () {
            let sidoName = $('#sido2').val();
            let gugunName = $(this).val();
            $.ajax({
                url: 'region.do',
                type: 'post',
                data: {
                    act: 'dong',
                    sido: sidoName,
                    gugun: gugunName,
                },
                dataType: 'json',
                success: function (response) {
                    console.log(response);
                    makeSigugun2("dong", response);
                },
                error: function (err) {
                    console.log(err);
                },
            });
        });

        function makeSigugun2(type, data) {
            let list = ``;
            let initOption = '';

            switch (type) {
                case "sido":
                    initOption = '<option>시도선택</option>';
                    $("#sido2").empty().append(initOption);

                    $.each(data, function (i, v) {
                        list += '<option value="' + v.name + '">' + v.name + '</option>';
                    });
                    $("#sido2").append(list);
                    break;
                case "gugun":
                    initOption = '<option>구군선택</option>';
                    $("#gugun2").empty().append(initOption);
                    initOption = '<option>동선택</option>';
                    $("#dong2").empty().append(initOption);
                    $.each(data, function (i, v) {
                        list += '<option value="' + v.name + '">' + v.name + '</option>';
                    });
                    $("#gugun2").append(list);
                    break;
                case "dong":
                    initOption = '<option>동선택</option>';
                    $("#dong2").empty().append(initOption);

                    $.each(data, function (i, v) {
                        list += '<option value="' + v.name + '">' + v.name + '</option>';
                    });
                    $("#dong2").append(list);
                    break;

                default:
                    break;
            }
        }

        function submitSigundongForSsgi() {
            let sidoName = $('#sido2').val();
            let gugunName = $('#gugun2').val();
            let dongName = $('#dong2').val();
            $.ajax({
                url: 'search/SsgiWithDongCode.do',
                type: 'post',
                data: {
                    sido: sidoName,
                    gugun: gugunName,
                    dong: dongName
                },
                dataType: 'json',
                success: function (response) {
                    console.log(response);
                    $("#SsgiByDongCode").empty();
                    let list = ``;
                    $.each(response, function (i, v) {
                        list += '<p style="border-bottom: solid gray 1px; font-size: 10px; margin-top: -15px;">' +
                            '<br>' + v.name + '<br>' +
                            '상가분류 :' + v.storeType + '<br>' +
                            '주소: ' + v.address + '<br></p>';
                    });
                    $("#SsgiByDongCode").append(list);
                },
                error: function (err) {
                    console.log(err);
                },
            });
        }
    </script>--%>

</head>

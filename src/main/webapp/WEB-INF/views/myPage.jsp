<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>

    <link rel="stylesheet" href="<c:url value="/resources/css/index.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/header.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/footer.css"/>">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>




<%--    <link rel="preconnect" href="https://fonts.googleapis.com">--%>
<%--    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>--%>
<%--    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">--%>
<%--    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>--%>


    <title>My Page</title>

    <style>
        .myPageH {
            font-size: 17px;
            margin: auto;
            margin-top: 40px;
            margin-bottom: 50px;
            text-align: center;
            color: black;
        }

        .sp {
            font-size: 16px;
            margin: 40px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .oneone {
            display: flex;
            justify-content: center;
            margin-top: -15px;/
        }

        .boxbox {
            margin: auto;
            box-shadow: 0 2px 8px 0 rgba(0, 0, 0, 0.2);
            width: 850px;
        }

        .ma {
            margin-bottom: 10px;
        }

        .ma2 {
            font-size: 11px;
        }

        #oneMonth {
            font-size: 12px;
            display: flex;
            justify-content: center;
            font-weight: bold;
        }

        #oneMonth2 {
            font-size: 12px;
            display: flex;
            justify-content: center;
            font-weight: bold;
        }

        #oneMonth3 {
            font-size: 12px;
            display: flex;
            justify-content: center;
            font-weight: bold;
        }

        #tong {
            margin-top: 50px;
        }
    </style>

</head>

<body>

<header id="top">
<jsp:include page="header.jsp"/></header>

<jsp:include page="myPageHeader.jsp"/>

<p class="myPageH">주문 내역<br></p>
<div id="tong">
    <div class="boxbox">
        <br>
        <p id="oneMonth">나의 주문처리 현황 (최근 1개월 기준)</p>

        <div class="oneone">
            <div class="sp">
                <span class="ma">입금전</span>
                <span class="ma2">0</span>
            </div>
            <div class="sp">
                <span class="ma">결제 완료</span>
                <span class="ma2">0</span>
            </div>
            <div class="sp">
                <span class="ma">배송 준비중</span>
                <span class="ma2">0</span>
            </div>

            <div class="sp">
                <span class="ma">배송중</span>
                <span class="ma2">0</span>
            </div>
            <div class="sp">
                <span class="ma">배송완료</span>
                <span class="ma2">0</span>
            </div>
        </div>
    </div>
</div>

<p class="myPageH">리뷰 내역<br></p>
<div class="boxbox"><br>
    <p id="oneMonth2">나의 리뷰처리 현황 (최근 1개월 기준)</p>

    <div class="oneone">
        <div class="sp">
            <span class="ma">일반 리뷰</span>
            <span class="ma2">0</span>
        </div>
        <div class="sp">
            <span class="ma">사진 리뷰</span>
            <span class="ma2">0</span>
        </div>

        <div class="sp">
            <span class="ma">작성 가능한 리뷰</span>
            <span class="ma2">0</span>
        </div>
        <div class="sp">
            <span class="ma">승인 대기</span>
            <span class="ma2">0</span>
        </div>
        <div class="sp">
            <span class="ma">승인 완료</span>
            <span class="ma2">0</span>
        </div>
    </div>
</div>



<p class="myPageH">문의 내역<br></p>
<div class="boxbox"><br>
    <p id="oneMonth3">나의 문의처리 현황 (최근 1개월 기준)</p>

    <div class="oneone">

        <div class="sp">
            <span class="ma">1:1 문의</span>
            <span class="ma2">0</span>
        </div>

        <div class="sp">
            <span class="ma">상품 문의</span>
            <span class="ma2">0</span>
        </div>
        <div class="sp">
            <span class="ma">SNS 문의</span>
            <span class="ma2">0</span>
        </div>
        <div class="sp">
            <span class="ma">문의 답변</span>
            <span class="ma2">0</span>
        </div>
    </div>
</div><br><br>

<footer>
<jsp:include page="footer.jsp" flush="false" />
</footer>
<script>
    function test(){
        alert("테스트중입니다")
    }
</script>

</body>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<head>
    <title>Green Salt</title>
    <link rel="icon" type="image/x-icon" href="https://cdn-icons-png.flaticon.com/128/15439/15439306.png">
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="/resources/css/index.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/header.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/footer.css"/>">
    <style>
        #Communitysection {
            max-width: 1000px;
            margin-top: 70px;
            margin-left: 75px;

        }

        #Communitytitle {
            margin-top: 20px;
            font-size: 20px;
            font-family: 'IBM Plex Sans', sans-serif;
            display: inline-block;
        }

        .writeColor {
            color: grey;
            font-size: 15px;
            font-weight: bold;
            margin-left: 20px;
            cursor: pointer;
        }

        table {
            width: 100%;
            margin-bottom: 20px;
        }

        th {
            font-size: 14px;
            text-align: center;
            font-weight: bold;

        }

        #mid {
            max-width: 1130px;
            margin: 0 auto;
            margin-bottom: 400px;
        }
    </style>
</head>

<script>
    let msg = "${msg}"
    if(msg=="WRT_OK") alert("등록되었습니다.");
    // if(msg=="WRT_ERR") alert("등록에 실패했습니다.");
    if(msg=="DEL_OK") alert("삭제되었습니다.");
    if(msg=="DEL_ERR") alert("삭제에 실패했습니다.");
</script>

<body>
<header id="top">
    <jsp:include page="header.jsp"/>
</header>

<div id="mid">
<h1 id="Communitytitle">Community</h1>
<a id="writeBtn" class="writeColor" onclick="location.href='<c:url value="/board/write"/>'">글쓰기</a>
<a href="#" class="writeColor">검색</a>

<section id="Communitysection" style="text-align: center">
    <table border="1">
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>글쓴이</th>
            <th>등록일</th>
            <th>조회수</th>
        </tr>
        <c:forEach var="boardDto" items="${list}">
        <tr>
            <td>${boardDto.bno}</td>
            <td><a href="<c:url value='/board/read?bno=${boardDto.bno}&page=${page}&pageSize=${pageSize}'/>">${boardDto.title}</a></td>
            <td>${boardDto.writer}</td>
            <td>${boardDto.reg_date}</td>
            <td>${boardDto.view_cnt}</td>
        </tr>
        </c:forEach>
    </table>
    <br>
    <div>
        <c:if test="${ph.showPrev}">
            <a href="<c:url value='/board/list?page=${ph.beginPage-1}&pageSize=${ph.pageSize}'/>">&lt;</a>
        </c:if>

        <c:forEach var ="i" begin="${ph.beginPage}" end="${ph.endPage}">
            <a href="<c:url value='/board/list?page=${i}&pageSize=${ph.pageSize}'/>">${i}</a>
        </c:forEach>

        <c:if test="${ph.showNext}">
            <a href="<c:url value='/board/list?page=${ph.endPage+1}&pageSize=${ph.pageSize}'/>">&gt;</a>
        </c:if>
    </div>

</section>
</div>
<footer>
    <jsp:include page="footer.jsp"/>
</footer>
</body>

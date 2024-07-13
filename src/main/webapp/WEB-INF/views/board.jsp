
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Green Salt</title>
    <link rel="icon" type="image/x-icon" href="../../icon_img/applegreen.png">
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <style>

<%--        <%@ include file="/resources/css/default.css" %>--%>
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
            margin-bottom: 420px;
        }
    </style>
</head>

<body>

<header id="top">
    <%@ include file="header.jsp" %>
</header>

<div id="mid">
<h1 id="Communitytitle">Community</h1>
<a href="#" class="writeColor">글쓰기</a>
<a href="#" class="writeColor">검색</a>

<section id="Communitysection" style="text-align: center">

    <h2>게시물 읽기</h2>

    <form action="" id="form">
        <input type="text" name="bno" value="${boardDto.bno}" readonly="readonly">
        <input type="text" name="title" value="${boardDto.title}" readonly="readonly">
        <textarea name="content" id="" cols="30" rows="10" readonly="readonly">${boardDto.content}</textarea>
        <button type="button" id="writeBtn" class="btn">등록</button>
        <button type="button" id="modifyBtn" class="btn">수정</button>
        <button type="button" id="removeBtn" class="btn">삭제</button>
        <button type="button" id="listBtn" class="btn">목록</button>

    </form>

</section>
</div>
<footer>
    <%@ include file="footer.jsp" %>
</footer>

<script>
    $(document).ready(function(){
        $('#listBtn').on("click", function(){
            location.href = "<c:url value='/community/list'/>?page=${page}&pageSize=${pageSize}";
        });
        $('#removeBtn').on("click", function(){
            if(!confirm("정말로 삭제하시겠습니까?")) return;
        let form = $('#form');
        form.attr("action", "<c:url value='/community/remove'/>?page=${page}&pageSize=${pageSize}");
        form.attr("method", "post");
        form.submit();
        });
    });



</script>
</body>

</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <title>Green Salt</title>
    <link rel="icon" type="image/x-icon" href="https://cdn-icons-png.flaticon.com/128/15439/15439306.png">
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/index.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/header.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/footer.css"/>">

    <style>
        #Communitysection {
            max-width: 1000px;
            margin-top: 70px;
            margin-left: 75px;

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
    <jsp:include page="header.jsp"/>
</header>

<div id="mid">
<section id="Communitysection" style="text-align: center">

    <h2 id="boardTitle">게시물 ${mode=="new" ? "글쓰기" : "읽기"}</h2>
    <form action="" id="form">
        <input type="hidden" name="bno" value="${boardDto.bno}">
        <input type="text" name="title" value="${boardDto.title}" ${ mode=="new" ? '' : 'readonly="readonly"'}>
        <textarea name="content" id="" cols="30" rows="10"  ${ mode=="new" ? '' : 'readonly="readonly"'}>${boardDto.content}</textarea>
        <button type="button" id="writeBtn" class="btn">글쓰기</button>
        <button type="button" id="modifyBtn" class="btn">수정</button>
        <button type="button" id="removeBtn" class="btn">삭제</button>
        <button type="button" id="listBtn" class="btn">목록</button>
    </form>

</section>
</div>
<footer>
    <jsp:include page="footer.jsp"/>
</footer>

<script>
    let msg = "${msg}"
    if(msg=="WRT_ERR") alert("게시물 등록에 실패했습니다.");

    $(document).ready(function(){
        $('#listBtn').on("click", function(){
            location.href = "<c:url value='/board/list'/>?page=${page}&pageSize=${pageSize}";
        });

        $('#writeBtn').on("click", function(){
            let form = $('#form');
            form.attr("action", "<c:url value='/board/write'/>?page=${page}&pageSize=${pageSize}");
            form.attr("method", "post");
            form.submit();
        });

        $('#modifyBtn').on("click", function(){
            // 1. 읽기 상태이면 수정 상태로 변경
            let form = $('#form');
            let isReadOnly = $("input[name=title]").attr('readonly');

            if(isReadOnly=='readonly') {
                $("input[name=title]").attr('readonly', false);
                $("textarea").attr('readonly', false);
                $("#modifyBtn").html("등록");
                $("#boardTitle").html("게시물 수정");
                return;
            }

            // 2. 수정 상태이면, 수정된 내용을 서버로 전송
            form.attr("action", "<c:url value='/board/modify'/>");
            form.attr("method", "post");
            form.submit();
        });

        $('#removeBtn').on("click", function(){
            if(!confirm("정말로 삭제하시겠습니까?")) return;
        let form = $('#form');
        form.attr("action", "<c:url value='/board/remove'/>?page=${page}&pageSize=${pageSize}");
        form.attr("method", "post");
        form.submit();
        });
    });
</script>
</body>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="true"%>
<head>
    <title>Green Salt</title>
    <link rel="icon" type="image/x-icon" href="https://cdn-icons-png.flaticon.com/128/15439/15439306.png">
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/index.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/header.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/footer.css"/>">

<%--    <style>--%>
<%--        #Communitysection {--%>
<%--            max-width: 1000px;--%>
<%--            margin-top: 70px;--%>
<%--            margin-left: 75px;--%>

<%--        }--%>
<%--        table {--%>
<%--            width: 100%;--%>
<%--            margin-bottom: 20px;--%>
<%--        }--%>

<%--        th {--%>
<%--            font-size: 14px;--%>
<%--            text-align: center;--%>
<%--            font-weight: bold;--%>

<%--        }--%>

<%--        #mid {--%>
<%--            max-width: 1130px;--%>
<%--            margin: 0 auto;--%>
<%--            margin-bottom: 420px;--%>
<%--        }--%>
<%--    </style>--%>

    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            /*font-family: "Noto Sans KR", sans-serif;*/
        }

        .container {
            width : 50%;
            margin : auto;
        }

        .writing-header {
            position: relative;
            margin: 20px 0 0 0;
            padding-bottom: 10px;
            border-bottom: 1px solid #323232;
        }

        input {
            width: 100%;
            height: 35px;
            margin: 5px 0px 10px 0px;
            border: 1px solid #e9e8e8;
            padding: 8px;
            background: #f8f8f8;
            outline-color: #e6e6e6;
        }

        textarea {
            width: 100%;
            background: #f8f8f8;
            margin: 5px 0px 10px 0px;
            border: 1px solid #e9e8e8;
            resize: none;
            padding: 8px;
            outline-color: #e6e6e6;
        }

        .frm {
            width:100%;
        }
        .btn {
            background-color: rgb(236, 236, 236); /* Blue background */
            border: none; /* Remove borders */
            color: black; /* White text */
            padding: 6px 12px; /* Some padding */
            font-size: 16px; /* Set a font size */
            cursor: pointer; /* Mouse pointer on hover */
            border-radius: 5px;
        }

        .btn:hover {
            text-decoration: underline;
        }
    </style>
</head>

<body>

<header id="top">
    <jsp:include page="header.jsp"/>
</header>

<%--<div id="mid">--%>
<%--<section id="Communitysection" style="text-align: center">--%>

<%--    <h2 id="boardTitle">게시물 ${mode=="new" ? "글쓰기" : "읽기"}</h2>--%>
<%--    <form action="" id="form">--%>
<%--        <input type="hidden" name="bno" value="${boardDto.bno}">--%>
<%--        <input type="text" name="title" value="${boardDto.title}" ${ mode=="new" ? '' : 'readonly="readonly"'}>--%>
<%--        <textarea name="content" id="" cols="30" rows="10"  ${ mode=="new" ? '' : 'readonly="readonly"'}>${boardDto.content}</textarea>--%>
<%--        <button type="button" id="writeBtn" class="btn">글쓰기</button>--%>
<%--        <button type="button" id="modifyBtn" class="btn">수정</button>--%>
<%--        <button type="button" id="removeBtn" class="btn">삭제</button>--%>
<%--        <button type="button" id="listBtn" class="btn">목록</button>--%>
<%--    </form>--%>

<%--</section>--%>
<%--</div>--%>
<%--<footer>--%>
<%--    <jsp:include page="footer.jsp"/>--%>
<%--</footer>--%>

<%--<script>--%>
<%--    let msg = "${msg}"--%>
<%--    if(msg=="WRT_ERR") alert("게시물 등록에 실패했습니다.");--%>

<%--    $(document).ready(function(){--%>
<%--        $('#listBtn').on("click", function(){--%>
<%--            location.href = "<c:url value='/board/list'/>?page=${page}&pageSize=${pageSize}";--%>
<%--        });--%>

<%--        $('#writeBtn').on("click", function(){--%>
<%--            let form = $('#form');--%>
<%--            form.attr("action", "<c:url value='/board/write'/>?page=${page}&pageSize=${pageSize}");--%>
<%--            form.attr("method", "post");--%>
<%--            form.submit();--%>
<%--        });--%>

<%--        $('#modifyBtn').on("click", function(){--%>
<%--            // 1. 읽기 상태이면 수정 상태로 변경--%>
<%--            let form = $('#form');--%>
<%--            let isReadOnly = $("input[name=title]").attr('readonly');--%>

<%--            if(isReadOnly=='readonly') {--%>
<%--                $("input[name=title]").attr('readonly', false);--%>
<%--                $("textarea").attr('readonly', false);--%>
<%--                $("#modifyBtn").html("등록");--%>
<%--                $("#boardTitle").html("게시물 수정");--%>
<%--                return;--%>
<%--            }--%>

<%--            // 2. 수정 상태이면, 수정된 내용을 서버로 전송--%>
<%--            form.attr("action", "<c:url value='/board/modify'/>");--%>
<%--            form.attr("method", "post");--%>
<%--            form.submit();--%>
<%--        });--%>

<%--        $('#removeBtn').on("click", function(){--%>
<%--            if(!confirm("정말로 삭제하시겠습니까?")) return;--%>
<%--        let form = $('#form');--%>
<%--        form.attr("action", "<c:url value='/board/remove'/>?page=${page}&pageSize=${pageSize}");--%>
<%--        form.attr("method", "post");--%>
<%--        form.submit();--%>
<%--        });--%>
<%--    });--%>
<%--</script>--%>

<script>
    let msg = "${msg}";
    if(msg=="WRT_ERR") alert("게시물 등록에 실패하였습니다. 다시 시도해 주세요.");
    if(msg=="MOD_ERR") alert("게시물 수정에 실패하였습니다. 다시 시도해 주세요.");
</script>
<div class="container">
    <h2 class="writing-header">게시판 ${mode=="new" ? "글쓰기" : "읽기"}</h2>
    <form id="form" class="frm" action="" method="post">
        <input type="hidden" name="bno" value="${boardDto.bno}">

        <input name="title" type="text" value="<c:out value = '${boardDto.title}'/>" placeholder="  제목을 입력해 주세요." ${mode=="new" ? "" : "readonly='readonly'"}><br>
        <textarea name="content" rows="20" placeholder=" 내용을 입력해 주세요." ${mode=="new" ? "" : "readonly='readonly'"}><c:out value ="${boardDto.content}"/></textarea><br>

        <c:if test="${mode eq 'new'}">
            <button type="button" id="writeBtn" class="btn btn-write"><i class="fa fa-pencil"></i> 등록</button>
        </c:if>
        <c:if test="${mode ne 'new'}">
            <button type="button" id="writeNewBtn" class="btn btn-write"><i class="fa fa-pencil"></i> 글쓰기</button>
        </c:if>
        <c:if test="${boardDto.writer eq c_id}">
            <button type="button" id="modifyBtn" class="btn btn-modify"><i class="fa fa-edit"></i> 수정</button>
            <button type="button" id="removeBtn" class="btn btn-remove"><i class="fa fa-trash"></i> 삭제</button>
        </c:if>
        <button type="button" id="listBtn" class="btn btn-list"><i class="fa fa-bars"></i> 목록</button>
    </form>
</div>

<footer>
    <jsp:include page="footer.jsp"/>
</footer>
<script>
    $(document).ready(function(){
        let formCheck = function() {
            let form = document.getElementById("form");
            if(form.title.value=="") {
                alert("제목을 입력해 주세요.");
                form.title.focus();
                return false;
            }

            if(form.content.value=="") {
                alert("내용을 입력해 주세요.");
                form.content.focus();
                return false;
            }
            return true;
        }

        $("#writeNewBtn").on("click", function(){
            location.href="<c:url value='/board/write'/>";
        });

        $("#writeBtn").on("click", function(){
            let form = $("#form");
            form.attr("action", "<c:url value='/board/write'/>");
            form.attr("method", "post");

            if(formCheck())
                form.submit();
        });

        $("#modifyBtn").on("click", function(){
            let form = $("#form");
            let isReadonly = $("input[name=title]").attr('readonly');

            // 1. 읽기 상태이면, 수정 상태로 변경
            if(isReadonly=='readonly') {
                $(".writing-header").html("게시판 수정");
                $("input[name=title]").attr('readonly', false);
                $("textarea").attr('readonly', false);
                $("#modifyBtn").html("<i class='fa fa-pencil'></i> 등록");
                return;
            }

            // 2. 수정 상태이면, 수정된 내용을 서버로 전송
            form.attr("action", "<c:url value='/board/modify${searchCondition.queryString}'/>");
            form.attr("method", "post");
            if(formCheck())
                form.submit();
        });

        <%--// 2. 수정 상태이면, 수정된 내용을 서버로 전송&ndash;%&gt;--%>
        <%--            form.attr("action", "<c:url value='/board/modify'/>");--%>
        <%--            form.attr("method", "post");--%>
        <%--            form.submit();--%>
        <%--        });--%>


        $("#removeBtn").on("click", function(){
            if(!confirm("정말로 삭제하시겠습니까?")) return;

            let form = $("#form");
            form.attr("action", "<c:url value='/board/remove${searchCondition.queryString}'/>");
            form.attr("method", "post");
            form.submit();
        });

        $("#listBtn").on("click", function(){
            location.href="<c:url value='/board/list${searchCondition.queryString}'/>";
        });
    });
</script>
</body>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Green Salt</title>
    <link rel="icon" type="image/x-icon" href="../../icon_img/applegreen.png">
    <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans&display=swap" rel="stylesheet">
    <style>

        .container {
            width: 300px;
            margin: 0 auto;
            text-align: left;
        }

        .special-class {
            width: 100%;
            padding: 10px;
            margin-bottom: 7px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        button {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
            background-color: darkgreen;
            color: whitesmoke;
        }

        /*.container .subBtn {*/
        /*    width: 49%;*/
        /*    margin-bottom: 10px;*/
        /*}*/

        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            font-size: 13px;
            color: gray;
        }

        #loginTitle {
            text-align: center;
            font-size: 20px;
            margin-bottom: 40px;
            font-family: 'IBM Plex Sans', sans-serif;
        }

        #myform {
            max-width: 1130px;
            text-align: center;
            border: 3px solid #f1f1f1;
            border-radius: 10px;
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
            padding: 2%;
            margin: 0 auto;
            margin-top: 50px;
            margin-bottom: 150px;
        }

        #msg {
            height: 30px;
            text-align:center;
            font-size:14px;
            margin-bottom: 20px;
            font-weight: bold;
        }

        span{
            color: gray;
        }

    </style>


</head>

<body>

<header id="top">
    <%@ include file="header.jsp" %>
</header>

<div id="myform">
    <form action ="<c:url value="/register/add"/>" method="POST" onsubmit="return formCheck(this)">
<%--<form:form modelAttribute="user">--%>


    <div id="msg"><form:errors path="id" />
            <form:errors path="pwd" />
            <form:errors path="name" /></div>
    <h1 id="loginTitle">Sign Up</h1>
    <div class="container">
        <label>아이디</label>
        <input class="special-class" type="text" name="id" placeholder="영문 (6자 이상 12자 이하)">
        <label>비밀번호</label>
        <input class="special-class" type="text" name="pwd" placeholder="영문/숫자 조합 (6자 이상)">
        <label>이름</label>
        <input class="special-class" type="text" name="name" placeholder="이름">
        <label>이메일</label>
        <input class="special-class" type="text" name="email" placeholder="green@salt.com">
        <label>전화번호</label>
        <input class="special-class" type="text" name="tel" placeholder="휴대폰 (-제외)">
        <label>생년월일</label>
        <input class="special-class"  type="text" name="birth" placeholder="생년월일 8자리"><br><br>
        <button>가입하기</button><br><br>
    </div>
<%--</form:form>--%>
</form>
</div>


<footer>
    <%@ include file="footer.jsp" %>
</footer>



<%--<script>--%>
<%--        let msg = "${sf}"--%>
<%--        if(msg==="SF_OK") {--%>
<%--            alert("회원가입이 되셨습니다.");--%>
<%--        }--%>
<%--</script>--%>

</body>

</html>
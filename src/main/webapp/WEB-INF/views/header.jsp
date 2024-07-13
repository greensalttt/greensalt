<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<meta charset="UTF-8">--%>

<c:set var="loginOutLink" value="${sessionScope.userID==null ? '/login' : '/logout'}"/>
<c:set var="loginOut" value="${sessionScope.userID==null ? 'Sign In' : 'Logout'}"/>

<script>
    window.onload = function() {
        if("${sessionScope.userID}" !== "") {
            document.getElementById('logoutLink').addEventListener('click', function(event) {
                event.preventDefault();
                if (confirm('정말로 로그아웃을 하시겠습니까?')) {
                    window.location.href = event.target.href;
                    alert('로그아웃이 되셨습니다.');
                }
            });
        }
    };
</script>

    <div id="title1">
        <h1><a href="<c:url value='/'/>">Green Salt !</a></h1>
        <h2 id="appleGreen"><img src=/icon_img/applegreen.png></h2>
    </div>

    <nav id="title2">
        <ul>
        <li><a id="logoutLink" href="<c:url value='${loginOutLink}'/>">${loginOut}</a></li>
        </ul>
    </nav>

    <input id="search" type="text" placeholder="Search.." onkeydown="handleKeyPress(event)">

    <nav id="title3">
        <ul>
            <li><a href="#">Store</a></li>
            <li><a href="#">Video</a></li>
            <li><a href="#">Interview</a></li>
            <li><a href="#">Performance</a></li>
            <li><a href="<c:url value='/community/list'/>">Community</a></li>
            <li><a href="#">Help</a></li>
        </ul>
    </nav>

<style>
    * {
        margin: 0;
        padding: 0;
        color: black;
        box-sizing: border-box;
    }

    body {
        background-color: whitesmoke;
        margin: 0 auto;
        height: 100vh;
        overflow-x: hidden;
    }

    li {
        list-style: none;
    }

    a {
        text-decoration: none;
    }

    #top {
        height: 160px;
        position: relative;
        overflow: hidden;
        color: #000;
    }

    #top>h1 {
        color: #000;
    }

    #top>#title1 {
        display: flex;
        position: absolute;
        width: 500px;
        height: 200px;
        top: 53px;
        font-family: 'IBM Plex Sans', sans-serif;
        font-size: 13px;
        left: 53px;
    }

    #top>#title1>#appleGreen {
        display: flex;
        position: relative;
        right: 190px;
        width: 50px;
        height: 50px;
        bottom: 10px;
    }

    #top>#title2 {
        position: relative;
        display: flex;
        width: -100%;
        float: right;
        top: 10px;
    }

    #top>#title2>ul>li>a {
        display: flex;
        font-weight: bold;
        overflow: hidden;
        padding: 5px 16px;
        width: 75px;
        height: 30px;
        border: 1px solid darkgreen;
        background-color: darkgreen;
        color: #f2f2f2;
        font-size: 12px;
        border-radius: 8px;
    }

    #top>#title3 {
        display: flex;
        position: relative;
        left: 263px;
        top: 100px;
    }

    #top>#title3>ul {
        list-style: none;
        display: flex;
        margin: 0;
        padding: 0;
    }

    #top>#title3>ul>li>a {
        display: flex;
        float: left;
        padding: 5px 27px;
        color: gray;
        font-size: 12px;
        font-weight: bold;
    }

    #search {
        position: absolute;
        bottom: 60px;
        left: 290px;
        width: 550px;
        height: 40px;
        box-sizing: border-box;
        border: 2px solid #ccc;
        border-radius: 4px;
        font-size: 14px;
        background-color: white;
        background-image: url("/icon_img/searchIcon.png");
        background-size: 14px 14px;
        background-position: 10px 10px;
        background-repeat: no-repeat;
        padding: 12px 20px 12px 40px;
    }

    header {
        max-width: 1130px;
        margin: 0 auto;
    }

</style>
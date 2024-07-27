<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="loginOutLink" value="${sessionScope.c_id==null ? '/login' : '/logout'}"/>
<c:set var="loginOut" value="${sessionScope.c_id==null ? 'Sign In' : 'Sign Out'}"/>

<link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans&display=swap" rel="stylesheet">

<script>
    window.onload = function () {
        if ("${sessionScope.c_id}" !== "") {
            document.getElementById('logoutLink').addEventListener('click', function (event) {
                event.preventDefault();
                if (confirm('정말로 로그아웃을 하시겠습니까?')) {
                    alert('로그아웃이 되어 메인페이지로 이동합니다.');
                    window.location.href = event.target.href;
                }
            });
        }
    };
</script>

    <div id="title1">
        <h1><a href="<c:url value='/'/>">Green Salt !</a></h1>
        <h2 id="appleGreen"><img src=/icon_img/applegreen.png></h2>
    </div>

<div id="custIcon">
    <img id="custIconImg" src="https://cdn-icons-png.flaticon.com/128/3462/3462172.png" alt="User Icon">
    <div id="links">
        <a id="logoutLink" href="<c:url value='${loginOutLink}'/>">${loginOut}</a>
        <a href="/mypage/list">My Page</a>
    </div>
</div>


    <input id="search" type="text" placeholder="Search.." onkeydown="handleKeyPress(event)">

    <nav id="title3">
        <ul>
            <li><a href="#">Store</a></li>
            <li><a href="#">Video</a></li>
            <li><a href="#">Interview</a></li>
            <li><a href="#">Performance</a></li>
            <li><a href="<c:url value='/board/list'/>">Community</a></li>
            <li><a href="#">Help</a></li>
        </ul>
    </nav>

<script>
    document.getElementById('custIconImg').addEventListener('click', function () {
        var links = document.getElementById('links');
        if (links.classList.contains('show')) {
            links.classList.remove('show');
        } else {
            links.classList.add('show');
        }
    });
</script>
<%--
  Created by IntelliJ IDEA.
  User: danawacomputer
  Date: 2017-06-13
  Time: 오후 1:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="/asset/css/bootstrap.css"/>

</head>
<body>
<h1>전체보기 페이지 입니다.</h1>

<c:forEach var="amigo" items="${list}">
    <ul>
        <li>친구 이름:${amigo.amigoId}<a href="/amigo/${amigo.amigoName}">${amigo.amigoName}</a>
            (${amigo.cp})</li>
    </ul>
</c:forEach>


<a href="/amigo/regist">쓰기</a>
<script src="/asset/js/jquery-3.2.1.js"></script>
<script src="/asset/js/bootstrap.js"></script>
</body>
</html>

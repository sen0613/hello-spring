<%--
  Created by IntelliJ IDEA.
  User: danawacomputer
  Date: 2017-06-12
  Time: 오후 4:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<h1>${amigoName}님이 조회되었습니다.</h1>
<ul>
    <li>${amigo.amigoName}</li>
    <li>${amigo.cp}</li>
    <li>${amigo.email}</li>
</ul>
<a href="/amigo">전체보기</a>
<a href="/amigo/regist">글쓰기</a>
</body>
</html>

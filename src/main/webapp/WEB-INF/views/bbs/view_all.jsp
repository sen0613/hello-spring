<%--
  Created by IntelliJ IDEA.
  User: danawacomputer
  Date: 2017-06-12
  Time: 오전 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%--&lt;%&ndash;<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorig in="anonymous">--%>
    <link rel="stylesheet" href="/client/css/bootstrap.css"/>

</head>
<body>
<h1>전체보기 페이지 입니다.</h1>

<c:forEach var="article" items="${list}">
    <ul>
        <li>글번호: ${article.articleId}</li>
        <li>제목:
            <a href="/bbs/${article.articleId}">${article.title}</a>
            (${article.author})
        </li>
    </ul>
</c:forEach>
<a href="/bbs/write">글쓰기</a>
<script src="/client/js/jquery-3.2.1.js"></script>
<script src="/client/js/bootstrap.js"></script>
</body>
</html>


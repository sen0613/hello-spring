<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Team Member Information</title>

    <!-- Bootstrap core CSS -->
    <link href="/asset/css/bootstrap.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="/asset/css/dashboard.css" rel="stylesheet">

    <style>
        body {
            font: 20px Montserrat;
        }
        .navbar {
            /*!*padding-top: 5px;*!*/
            /*!*padding-bottom: 15px;*!*/
            /*border: 0;*/
            /*border-radius: 0;*/
            /*margin-bottom: 0;*/
            font-size: 12px;
            letter-spacing: 5px;
        }
        .bg-1{
            background-color: transparent;
            color: #c9302c ;
        }
        .bg-2 {
            background-color: ivory;
            color: #5bc0de ;
        }
        .bg-4 {
            background-color: #c0a16b ;
            color: #fff;
        }
        .container-fluid {
            padding-top: 10px;
            padding-bottom: 10px;
        }
    </style>
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid bg-1">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Big Data Programming</a>
            <br>
            <a href="/bbs/bs-sample"><img src="/asset/img/hygge.jpg" width="500" height="100"/></a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Hygge Team</a></li>
                <li><a href="#">Lucy Team</a></li>
                <li><a href="#">Bong Team</a></li>
            </ul>
            <form class="navbar-form navbar-right" action="/bbs/bs_sample_detail">
                <input type="text" name="search" class="form-control" placeholder="Search...">
                <input type="submit" value="submit" class="btn btn-success" role="button">
            </form>
        </div>
    </div>
</nav>

<div class="container-fluid bg-2">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">Overview <span class="sr-only">(current)</span></a></li>
                <li><a href="#"><span class="glyphicon glyphicon-align-left" aria-hidden="true"></span>Reports</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>Analytics</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-search" aria-hidden="true"></span>Export</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href=""><span class="glyphicon glyphicon-heart" aria-hidden="true"></span>Hadoop</a></li>
                <li><a href=""><span class="glyphicon glyphicon-star" aria-hidden="true"></span>MongoDB</a></li>
                <li><a href=""><span class="glyphicon glyphicon-minus" aria-hidden="true"></span>TensorFlow</a></li>
                <li><a href=""><span class="glyphicon glyphicon-cloud" aria-hidden="true"></span>HTML/CSS/Javascript</a></li>
                <li><a href=""><span class="glyphicon glyphicon-signal" aria-hidden="true"></span>Spring</a></li>
            </ul>
        </div>
        <ul class="nav nav-sidebar">
            <li><a href=""><span class="glyphicon glyphicon-time" aria-hidden="true"></span>Project Book</a></li>
            <li><a href=""><span class="glyphicon glyphicon-road" aria-hidden="true"></span>Work Flow</a></li>
            <li><a href=""><span class="glyphicon glyphicon-flag" aria-hidden="true"></span>Source Code</a></li>
        </ul>
    </div>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        <h1 class="page-header">Hygge Team</h1>

        <div class="row placeholders">
            <div class="col-xs-6 col-sm-3 placeholder">

                <img src="/asset/img/min.jpg" width="200" height="200" class="img-circle" alt="Generic placeholder thumbnail">
                <h4>MIN HEO</h4>
                <span class="text-muted">Project Manager</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
                <img src="/asset/img/sewon.jpg" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
                <h4>SEWON KIM</h4>
                <span class="text-muted">Hadoop Engineer</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
                <img src="/asset/img/soonsung.jpg" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
                <h4>SOONSUNG HWANG</h4>
                <span class="text-muted">UI/UX Developer</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
                <img src="/asset/img/taejoon.jpg" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
                <h4>TAEJOON KIM</h4>
                <span class="text-muted">Hadoop Engineer</span>
            </div>
        </div>

        <h2 class="sub-header">Hygge Team Member</h2>

        <div class="table-responsive">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>PhoneNumber</th>
                    <th>EmailAdress</th>
                </thead>

                <c:forEach var="amigo" items="${list}">
                    <tbody>
                    <tr>
                        <td>${amigo.name}</td>
                        <td>${amigo.phone}</td>
                        <td>${amigo.email}</td>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
        </div>

        <footer class="container-fluid bg-4 text-center">
            <p>Bootstrap Theme Made By  hygge </p>
        </footer>
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="/asset/js/jquery-3.2.1.js"></script>
        <script src="/asset/js/bootstrap.js"></script>
        <script src="/asset/js/holder.js"></script>
</body>
</html>
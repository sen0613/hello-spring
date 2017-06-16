<%--
  Created by IntelliJ IDEA.
  User: danawacomputer
  Date: 2017-06-16
  Time: 오후 3:03
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

<div class="container">
    <div class="header clearfix">
        <nav>
            <ul class="nav nav-pills pull-right">
                <li role="presentation" class="active"><a href="#">Home</a></li>
                <li role="presentation"><a href="#">About</a></li>
                <li role="presentation"><a href="#">Contact</a></li>
            </ul>
        </nav>
        <h3 class="text-muted">글쓰기 화면입니다.</h3>
    </div>

    <div class="jumbotron">
        <form action="/post/write" method="post">

            <div class="input-group">
                <span class="input-group-addon">
                    <i class="glyphicon glyphicon-tags"></i> 멤버순서
                </span>
                <input type="text" name="memberSeq" class="form-control" placeholder="멤버순서">
            </div>
            <br>

            <div class="input-group">
                <span class="input-group-addon">
                    <i class="glyphicon glyphicon-th-large"></i> ID
                </span>
                <input type="text" name="userId" class="form-control" placeholder="ID">
            </div>
            <br>

            <div class="input-group">
                <span class="input-group-addon">
                    <i class="glyphicon glyphicon-user"></i> PW
                </span>
                <input type="text" name="password" class="form-control" placeholder="PASSWORD">
            </div>
            <br>

            <div class="input-group">
                <span class="input-group-addon">
                    <i class="glyphicon glyphicon-pencil"></i> EMAIL
                </span>
                <input type="text" name="email" class="form-control" placeholder="E-MAIL">
            </div>
            <br>

            <div class="input-group">
                <span class="input-group-addon">
                    <i class="glyphicon glyphicon-tags"></i> POINT
                </span>
                <input type="text" name="point" class="form-control" placeholder="POINT">
            </div>
            <br>

            <div class="input-group">
                <span class="input-group-addon">
                    <i class="glyphicon glyphicon-tags"></i> 가입일
                </span>
                <input type="text" name="joinDate" class="form-control" placeholder="가입일">
            </div>
            <br>

            <p><input type="submit" value="등록하기" class="btn btn-lg btn-success"></p>
        </form>
    </div>

    <div class="row marketing">
        <div class="col-lg-6">
            <h4>Subheading</h4>
            <p>Donec id elit non mi porta gravida at eget metus. Maecenas faucibus mollis interdum.</p>

            <h4>Subheading</h4>
            <p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Cras mattis consectetur purus sit amet
                fermentum.</p>

            <h4>Subheading</h4>
            <p>Maecenas sed diam eget risus varius blandit sit amet non magna.</p>
        </div>

        <div class="col-lg-6">
            <h4>Subheading</h4>
            <p>Donec id elit non mi porta gravida at eget metus. Maecenas faucibus mollis interdum.</p>

            <h4>Subheading</h4>
            <p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Cras mattis consectetur purus sit amet
                fermentum.</p>

            <h4>Subheading</h4>
            <p>Maecenas sed diam eget risus varius blandit sit amet non magna.</p>
        </div>
    </div>

    <footer class="footer">
        <p>&copy; 2016 Company, Inc.</p>
    </footer>

</div> <!-- /container -->


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>


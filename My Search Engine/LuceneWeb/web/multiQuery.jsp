<%-- 
    Document   : multiQuery
    Created on : 18 Aug, 2017, 9:08:48 PM
    Author     : parak
--%>

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Toogle</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            .container {
                margin: auto;
                width: 50%;
                padding: 70px 0;
                vertical-align: central;
            }
            .font{
                font-family: Sans-Serif, Arial, Sans-Serif;
                color: #00bfff;
                font-style: normal;
                font-size: 95px;
            }
            .well{
                opacity: 0.5;
            }
            body{
                background-image: url("Untitlednew.png");
                -webkit-background-size: cover;
                -moz-background-size: cover;
                -o-background-size: cover;
                background-size: cover;
            }
            .parakh{
                opacity: 0.6;
            }
            footer {
                position: fixed;
                bottom: 0px;
                left: 0px;
                right: 0px;
                margin-bottom: 0px;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-default parakh">
            <div class="container-fluid">
                <!--                <div class="navbar-header">
                                    <a class="navbar-brand" href="#">WebSiteName</a>
                                </div>-->
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="index.html">Single Query</a></li>
                    <li><a href="#">Tmail</a></li>
                    <li><a href="#">Images</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-th" style="font-size: 18px;"></span></a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-bell" style="font-size: 18px;"></span></a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-user" style="font-size: 18px;"></span></a></li>
                </ul>
            </div>
        </nav>


        <div class="container">
            <center>
                <h1><b class="font">T</b><b style="color: red;font-size: 95px;">o</b><b style="color: yellow;font-size: 95px;">g</b><b class="font">g</b><b style="color: green;font-size: 95px;">l</b><b style="color: red;font-size: 95px;">e</b></h1><br/>
                <div>
                    <form action ="SearchText" method="get">
                        <div class="input-group col-xs-8" style="opacity: 0.7;">
                            <input type="text" class="form-control" placeholder="Search" name="wordSearch" required="required"><br><br>
                        </div>
                        <div class="input-group col-xs-8" style="opacity: 0.7;">
                            <input type="text" class="form-control" placeholder="Search" name="wordSearch1" required="required">   
                        </div>
                        <br>
                        <label class="radio-inline">
                            <input type="radio" name="optradio" value="conjunction" checked="checked"><b style="color: white;">CONJUNCTION</b>
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="optradio" value="disjunction"><b style="color: white;">DISJUNCTION</b>
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="optradio" value="negation"><b style="color: white;">NEGATION</b>
                        </label>
                        <br>
                        <br>
                        <button type="submit" class="btn btn-default" style="opacity: 0.7;">Toggle Search</button>
                    </form>
                </div>
            </center>

        </div>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>

        <p></p>
        <p></p>

        <footer>
            <nav class="navbar navbar-default parakh">
                <div class="container-fluid">
                    <!--    <div class="navbar-header">
                          <a class="navbar-brand" href="#">WebSiteName</a>
                        </div>-->
                    <ul class="nav navbar-nav">
                        <li><a href="#">Advertising</a></li>
                        <li><a href="#">Business</a></li>
                        <li><a href="#">About</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#">Privacy</a></li>
                        <li><a href="#">Terms</a></li>
                        <li><a href="#">Settings</a></li>
                    </ul>
                </div>
            </nav>
        </footer>
    </body>
</html>


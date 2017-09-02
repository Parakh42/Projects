<%-- 
    Document   : noResult
    Created on : 18 Aug, 2017, 8:39:46 PM
    Author     : parak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                font-size: 40px;
            }
            .well{
                opacity: 0.5;
            }
            body{
                max-width: 100%;
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
                <div class="navbar-header">
                    <a class="navbar-brand" href="index.html" style="padding-top: 25px;"><b class="font">T</b><b style="color: red;font-size: 40px;">o</b><b style="color: yellow;font-size: 40px;">g</b><b class="font">g</b><b style="color: yellow;font-size: 40px;">l</b><b style="color: red;font-size: 40px;">e</b></a>&nbsp;&nbsp;
                    <form action ="SearchText" method="get">
                        <div class="input-group col-xs-3" style="padding-bottom: 20px">
                            <input type="text" class="form-control" placeholder="Search" name="wordSearch">
                            <div class="input-group-btn">
                                <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                            </div>
                        </div>
                    </form>
                </div>

                <ul class="nav navbar-nav">
                    <li class="active" style="color: blue;"><a href="#">All</a></li>
                    <li><a href="#">Videos</a></li>
                    <li><a href="#">News</a></li>
                    <li><a href="#">Images</a></li>
                    <li><a href="#">Shopping</a></li>
                    <li><a href="#">More</a></li>
                    <li><a href="#">Settings</a></li>
                    <li><a href="#">Tools</a></li>
                </ul>

                <ul class="nav navbar-nav navbar-right" style="text-align: center;">
                    <li><a href="#">Precision and Recall</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-th" style="font-size: 18px;"></span></a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-bell" style="font-size: 18px;"></span></a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-user" style="font-size: 18px;"></span></a></li>
                </ul>
            </div>
        </nav>
        <h2 style="padding-left: 25px; color: #808080;"><b> SORRY NO RESULTS FOUND </b></h2> 
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

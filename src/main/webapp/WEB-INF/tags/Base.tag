<%@tag description="Base" pageEncoding="UTF-8"%>
<%@attribute name="title" required="true"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<html>
    <head>
        <title>${title}</title>
        
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- CSS -->
        <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/static/css/custom.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/static/css/font-awesome.min.css" rel="stylesheet">
        
        <link href='https://fonts.googleapis.com/css?family=Roboto+Slab|Montserrat|Anton' rel='stylesheet' type='text/css'>

        <!-- JS -->
        <script src="${pageContext.request.contextPath}/static/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
        
    </head>
    <body>
        <!-- Fixed navbar -->
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container" style="font-family: 'Roboto Slab'">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                      <span class="sr-only">Toggle navigation</span>
                      <span class="icon-bar"></span>
                      <span class="icon-bar"></span>
                      <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href=".">My Popcorn</a>
                </div>
                <div id="navbar" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href=".">Now Showing</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">

                    </ul>
                </div>
                <!--/.nav-collapse -->
            </div>
        </nav>
        <jsp:doBody/>
    </body>
</html>
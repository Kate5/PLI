<%@ page import="ua.alf.Config" %>
<%@ page import="ua.alf.model.Language" %>
<!DOCTYPE html>
<html>
<head>
    <title><%= Config.WEB_TITLE %>
    </title>
    <meta charset="utf-8"/>
    <meta name="description" content="<%=Config.WEB_DESCRIPTION%>"/>
    <link rel="stylesheet" href="static/style/style.css"/>
    <script src="static/js/amcharts/amcharts.js" type="text/javascript"></script>
    <script src="static/js/amcharts/serial.js" type="text/javascript"></script>
    <script src="static/js/amcharts/themes/light.js" type="text/javascript"></script>
    <script src="static/js/jquery-2.1.0.min.js" type="text/javascript"></script>
    <script src="static/js/client.js" type="text/javascript"></script>
</head>
<body>
<section>
    <div class="container">
        <div class="status">
            <%
                for (Language l : Language.values()) {
            %>
            <h1><%=l.getName()%> Index</h1>

            <div id="chartdiv_<%=l.name()%>" style="width: 100%; height: 400px;margin: 10px"></div>
            <%
                }
            %>
        </div>
    </div>
</section>
<section class="about">
    <p class="about-author">
        Eugene Chipachenko
    </p>

    <p>
        <a href="http://www.linkedin.com/pub/eugene-chipachenko/5b/55b/485">LinkedIn</a>
        <a href="http://vk.com/echipachenko">VK</a>
        <a href="https://www.facebook.com/eugene.chipachenko">FB</a>
        <a href="https://plus.google.com/+ЕвгенийЧипаченко">Google+</a>
    </p>
    <p>
        2014
    </p>
</section>
</body>
</html>

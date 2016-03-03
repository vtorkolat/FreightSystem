<%@ page language="java" pageEncoding="UTF-8"  session="true"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<form method="POST" action="/authorize">" +
  "<label for=\"email\">Email:</label><br>" +
  "<input type=\"text\" id=\"email\" name=\"email\"/><br><br>" +
  "<label for=\"password\">Email:</label><br>" +
  "<input type=\"password\" id=\"password\" name=\"password\"/><br><br>" +
  "<input type=\"submit\" value=\"Log-in\"/><br><br>" +
  "</form>
</body>
</html>

<%@ page language="java" pageEncoding="UTF-8"  session="true"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="${pageContext.ServletContext.contextPath}/registration" method="post">
    <table>
        <tr>
            <td align="right" >Email : </td>
            <td>
                <input type="text" name="email">
            </td>
        </tr>
        <tr>
            <td align="right" >Password : </td>
            <td>
                <input type="text" name="password">
            </td>
        </tr>
        <tr>
            <input type="submit" align="centre" value="submit">
        </tr>
    </table>
</form>
</body>
</html>

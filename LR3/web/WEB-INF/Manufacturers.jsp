<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список производителей</title>
    </head>
    <body>
        <table align="center">
            <tr>
                <td><b>Title</b></td>
                <td></td>
                <td></td>
            </tr>
            <c:forEach items="${manufacturers}" var="man">
                <tr>
                    <td>${man.title}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>


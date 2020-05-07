<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список товаров</title>
    </head>
    <body>
        <table align="center">
            <tr>
                <td><b>Название</b></td>
                <td></td>
            </tr>
            <c:forEach items="${goods}" var="good">
                <tr>
                    <td>${good.title}</td>
                    <td>${good.manufacturer.title}</td>
                    <td>
                        <form action="editGood" method="get">
                            <input type="hidden" name="id" value="${good.id}">
                            <input type="submit" value="Отредактировать товар">                     
                        </form>
                    </td>
                    <td>
                        <form action="Goods" method="post">
                            <input type="hidden" name="id" value="${good.id}">
                            <input type="submit" value="Удалить товар">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <form action = "createGood" method="get">
            <input type="submit" value="Добавить товар">
        </form><br>
    </body>
</html>


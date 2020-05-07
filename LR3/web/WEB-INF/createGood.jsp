<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Добавить товар</title>
    </head>
     <body>
        <form action="createGood" method="post">
            <table align="center">
            <tr>
                <td>Title</td>
                <td><input required type="text" name="title" /></td>
            </tr>
            <tr>
                <td>Поставщик</td>
                <td><select name="manufacturer">
                    <c:forEach items="${ manufacturers}" var="man">
                      <option value="${man.id}"> ${man.title}</option>
                    </c:forEach>
                   </select></td>
            </tr>
            <tr>
                <td>
                    <input required type="submit" value="Добавить"/>
                </td></tr>
            </table>   
        </form>
    </body>
</html>


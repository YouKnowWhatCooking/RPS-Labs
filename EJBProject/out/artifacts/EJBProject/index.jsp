<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Goods</title>
</head>
<body>
<table>
    <tr>
        <th>Title</th>
        <th>Amount</th>
        <th>Description</th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items="${goodList}" var="good">
        <tr>
            <td>${good.getTitle()}</td>
            <td>${good.getAmount()}</td>
            <td>${good.getDescription()}</td>
            <td>
                <form action="updateGood" method="get">
                    <input type="hidden" name="id" value="${good.getId()}">
                    <input type="submit" value="Update">
                </form>
            </td>
            <td>
                <form action="deleteGood" method="post">
                    <input type="hidden" name="id" value="${good.getId()}">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<form action = "index" method="get">
    <input type="submit" value="Show goods">
</form>
<form action = "insertPage" method="get">
    <input type="submit" value="Insert a new good">
</form>
</body>

</html>

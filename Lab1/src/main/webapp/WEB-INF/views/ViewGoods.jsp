<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>List of goods</h1>
<table border="2" width="70%" cellpadding="2">
    <tr><th>Id</th><th>Title</th><th>Amount</th><th>Description</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="good" items="${list}">
        <tr>
            <td>${good.id}</td>
            <td>${good.title}</td>
            <td>${good.amount}</td>
            <td>${good.description}</td>
            <td><a href="EditGood/${good.id}">Edit</a></td>
            <td><a href="DeleteGood/${good.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="GoodAddForm">Add a new good</a>


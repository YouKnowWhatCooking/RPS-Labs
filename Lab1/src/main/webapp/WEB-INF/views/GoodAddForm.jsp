<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1>Add a new good</h1>
<form:form method="post" action="save">
    <table>
        <tr>
            <td>Title :</td>
            <td><form:input path="title"/></td>
        </tr>
        <tr>
            <td>Amount :</td>
            <td><form:input path="amount"/></td>
        </tr>
        <tr>
            <td>Description :</td>
            <td><form:input path="description"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Add"/></td>
        </tr>
    </table>
</form:form>


<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1>Edit good</h1>
<form:form method="POST" action="/SpringMVCLab/editsave">
    <table>
        <tr>
            <td></td>
            <td><form:hidden path="id"/></td>
        </tr>
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
            <td><input type="submit" value="Save edittes"/></td>
        </tr>
    </table>
</form:form>


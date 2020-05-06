<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update an existing good</title>
</head>
<body>

<form action="updatePage" method="post">
    <table>
        <tr>
            <td>Title</td>
            <td><input required type="text" name="title" /></td>
        </tr>
        <tr>
            <td>Amount</td>
            <td><input required type="text" name="amount" /></td>
        </tr>
        <tr>
            <td>Description</td>
            <td><input required type="text" name="description" /></td>
        </tr>
        <tr>
            <td>
                <input required type="submit" value="Update"/>
            </td>
        </tr>
    </table>
</form>
</body>

</html>

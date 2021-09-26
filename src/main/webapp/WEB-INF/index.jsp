<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Languages</title>
</head>
<body>
    <h1>All Books</h1>
    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Creator</th>
                <th>Version</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${languages}" var="lang">
            <tr>
                <td><c:out value="${lang.name}"/></td>
                <td><c:out value="${lang.creator}"/></td>
                <td><c:out value="${lang.version}"/></td>
                <td><a>Edit</a><a>Delete</a></td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    <form action="/languages" method="POST">
        <label for="name">Name:</label>
        <input type="text" name="name" id="name"><br>
        <label for="creator">Creator:</label>
        <input type="text" name="creator" id="creator"><br>
        <label for="version">Version:</label>
        <input type="text" name="version" id="version"><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>  
    <h1>Edit Book</h1>
    <form:form action="/languages/${language.id}" method="post" modelAttribute="language">
        <input type="hidden" name="_method" value="put">
        <p>
            <form:label path="name">Name</form:label>
            <form:errors path="name"/>
            <form:input path="name" type="text"/>
        </p>
        <p>
            <form:label path="creator">Creator</form:label>
            <form:errors path="creator"/>
            <form:textarea path="creator" type="text"/>
        </p>
        <p>
            <form:label path="version">Version</form:label>
            <form:errors path="version"/>
            <form:input path="version" type="text"/>
        </p> 
        <input type="submit" value="Submit" />
    </form:form>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Todo Register</title>
</head>
<body>
    <form action="/todo/register" method="post">
        <div>
            <input type="text" name="title" placeholder="Insert Title">
        </div>
        <div>
            <input type="date" name="dueDate">
        </div>
        <div>
            <button type="reset">Reset</button>
            <button type="submit">Register</button>
        </div>
    </form>

</body>
</html>

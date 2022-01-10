<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="api/users" method="post">
    <label>First Name:
        <input type="text" name="firstname" id="firstname"><br />
    </label>

    <label>Last Name:
        <input type="text" name="lastname" id="lastname"><br />
    </label>

    <label>Email:
        <input type="text" name="email" id="email"><br />
    </label>

    <label>Username:
        <input type="text" name="username" id="username"><br />
    </label>

    <label>Password:
        <input type="password" name="password" id="password"><br />
    </label>

    <button type="submit">Submit</button>
</form>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="view/command/update-user" method="get">
  <label>ID:
    <input type="text" name="id"><br />
  </label>

  <label>Updated First Name:
    <input type="text" name="firstname"><br />
  </label>

  <label>Updated Last Name:
    <input type="text" name="lastname"><br />
  </label>

  <label>Updated Email:
    <input type="text" name="email"><br />
  </label>

  <label>Updated Username:
    <input type="text" name="username"><br />
  </label>

  <label>Updated Password:
    <input type="password" name="password"><br />
  </label>

  <button type="submit">Submit</button>
</form>
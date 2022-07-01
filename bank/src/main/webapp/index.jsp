<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<form action="BankServlet?op=transMoney" method="post">
    转入账号：<input type="text" name="in"><br>
    转出账号：<input type="text" name="out"><br>
    金额：<input type="text" name="money"><br>
    <input type="submit" value="确定">
</form>

</body>
</html>

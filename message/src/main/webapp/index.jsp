<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>留言板</title>
    <link rel="stylesheet" type="text/css" href="style/style.css"/>
    <script type="text/javascript">
        function check() {
            var author = document.forms[0].author.value;
            var message = document.forms[0].message.value;
            var errorMsg = "";
            if (author === "" || author === "请输入您的名字") {
                errorMsg += "作者不能为空";
            }
            if (message === "") {
                errorMsg += "\n内容不能为空";
            }
            if (message.length > 500) {
                errorMsg += "\n内容长度不能大于500";
            }
            if (author.length > 20) {
                errorMsg += "\n作者名长度不能大于20";
            }
            if (errorMsg !== "") {
                alert(errorMsg);
                return false;
            }
        }

        function checkName_mouseOut() {
            if (document.forms[0].author.value === '') {
                document.forms[0].author.value = '请输入您的名字';
                document.forms[0].author.className = 'gray input';
            }
        }

        function checkName_mouseOver() {
            if (document.forms[0].author.value === '请输入您的名字') {
                document.forms[0].author.value = '';
                document.forms[0].author.className = 'input';
            }
        }

        function turnPage(page) {
            location.href = "PageMessageServlet?page=" + page;
        }
    </script>
</head>

<body>
<div align="center">
    <h2>小小留言板</h2>
    <div>
        <c:forEach var="msg" items="${list}" varStatus="vs">
            <div class="t c">
                <div class="t2" align="left">&nbsp;作者：${msg.username}
                </div>
                <div align="right">${(page-1)*5+vs.index+1}#&nbsp;
                </div>
                <div class="t1 tipad" align="left">${msg.content}
                </div>
                <div class="gray" align="right">发表：<f:formatDate value="${msg.time}" pattern="yyyy-MM-dd HH:mm:ss"/>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="tipad" style="width:500px" align="center">
        ${page}/${total}
        <input class="btn1" type="button" value="首页" onclick="turnPage(1)">&nbsp;
        <input class="btn1" type="button" value="上一页" onclick="turnPage(${page-1})">&nbsp;
        <input class="btn1" type="button" value="下一页" onclick="turnPage(${page+1})">&nbsp;
        <input class="btn1" type="button" value="尾页" onclick="turnPage(${total})">
    </div>

    <div style="width:500px" align="left">&nbsp;
        <form action="AddMessageServlet" method="post" onSubmit="return check()">
            <div>用 户 名</div>
            <div style="position:relative; left:50px; top:-18px">
                <input type="text" name="author" class="gray input" value="请输入您的名字"
                       onMouseOver="return checkName_mouseOver()" onMouseOut="return checkName_mouseOut()"/>
            </div>
            <div>留言信息
            </div>
            <div style="position:relative; left:50px; top:-18px">
                <textarea name="message" rows="5" cols="55"></textarea>
            </div>
            <div align="center" style="position:relative;left:-50px;width:500px"><input type="submit" value="提 交"
                                                                                        class="btn"/>
            </div>
        </form>
    </div>
</div>
</body>
</html>
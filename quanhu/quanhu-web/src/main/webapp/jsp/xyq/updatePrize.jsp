<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/taglib.jsp"%>
<html>
<head>
    <title>修改物价</title>

    

    <script type="text/javascript">
        $(function () {
            
        })
    </script>
</head>
<body>
    <form action="${ctx}/xyq/add" method="post">
        <input type="text" name="id" value="${entity.id}" hidden="hidden"/><br>
        宝石名称:<input type="text" name="name" value="${entity.name}"/><br>
        价格：<input type="text" name="prize" value="${entity.prize}"/><br>
        <input type="submit" value="提交">
        <input type="reset" value="重置"/>${message}
    </form>
</body>
</html>

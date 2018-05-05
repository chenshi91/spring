<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/taglib.jsp"%>
<html>
<head>
    <title>梦幻宝石物价</title>
    <script type="text/javascript" >
        function deletePrize(id) {
            // alert(id);
            $.ajax({
                type: 'put',
                url: "${ctx}/xyq/delete/"+id,
                dataType: "json",
                success: function (data){
                    alert(data.responseText);
                    <%--response.sendRedirect("${ctx}/xyq");--%>
                    if (data.responseText=="deleteOk"&&data.status==200){
                        window.location.reload();
                    }else {

                    }
                },
                error: function (data) {
                    alert(data.responseText);
                    response.sendRedirect("${ctx}/xyq");
                    if (data.responseText=="deleteOk"&&data.status==200){
                        window.location.reload();
                    }else {

                    }
                }

            });

        }

        function outExcel() {
            // alert("asd");
            $.ajax({
                type: 'post',
                url: "${ctx}/xyq/outExcel",
                dataType: "json",
                success: function (data){
                    alert(data.responseText);
                    <%--response.sendRedirect("${ctx}/xyq");--%>
                    if (data.responseText=="deleteOk"&&data.status==200){
                        window.location.reload();
                    }else {

                    }
                }

            })
        }

    </script>
</head>
<body>
    <font color="#a52a2a">${message}</font>
    <table bgcolor="#d2691e" border="20" >
        <tr>
            <th>name</th>
            <td>prize-1</td>
            <td>prize-2</td>
            <td>prize-3</td>
            <td>prize-4</td>
            <td>prize-5</td>
            <td>prize-6</td>
            <td>prize-7</td>
            <td>prize-8</td>
            <td>prize-9</td>
            <td>prize-10</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${list}" var="xyq">
            <tr>
                <td>${xyq.name}</td>
                <td>${xyq.prize}W</td>
                <td>${xyq.prize*2}W</td>
                <td>${xyq.prize*2*2}W</td>
                <td>${xyq.prize*2*2*2}W</td>
                <td>${xyq.prize*2*2*2*2}W</td>
                <td>${xyq.prize*2*2*2*2*2}W</td>
                <td>${xyq.prize*2*2*2*2*2*2}W</td>
                <td>${xyq.prize*2*2*2*2*2*2*2}W</td>
                <td>${xyq.prize*2*2*2*2*2*2*2*2}W</td>
                <td>${xyq.prize*2*2*2*2*2*2*2*2*2}W</td>
                <td> <a href="${ctx}/xyq/toUpdate/${xyq.id}">
                    <input value="修改" type="button" /></a>
                <input type="button" value="删除" onclick="deletePrize(${xyq.id})"/>
                <a href="${ctx}/jsp/xyq/updatePrize.jsp">添加</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <input type="button" value="导出Excel" onclick="outExcel()"/>

</body>

</html>

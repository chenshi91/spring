<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/taglib.jsp"%>
<html>
<head>
    <title>数据表格</title>

    <script type="text/javascript">
        $(function(){
        	$('#dg').datagrid({    
        	    url:'${ctx}/v1/admin/topic/json',
        	    method:"get",
        	    columns:[[    
        	        {field:'title',title:'话题标题',width:100},    
        	        {field:'content',title:'话题内容',width:100},    
        	        {field:'imgUrl',title:'话题图片',width:100,align:'right'}    
        	    ]],
        	    pagination:true,
        	    pageSize:10,
        	    sortName:"title",
        	    sortOrder:"desc",
        	    
        	}); 
        })
        
       
    </script>
</head>
<body>
    <table class="easyui-datagrid" id="dg">   
	    <!-- <thead>   
	        <tr>   
	            <th data-options="field:'code'">编码</th>   
	            <th data-options="field:'name'">名称</th>   
	            <th data-options="field:'price'">价格</th>   
	        </tr>   
	    </thead>   
	    <tbody>   
	        <tr>   
	            <td>001</td><td>name1</td><td>2323</td>   
	        </tr>   
	        <tr>   
	            <td>002</td><td>name2</td><td>4612</td>   
	        </tr>   
	    </tbody> -->   
	</table>
		  
</body>
</html>

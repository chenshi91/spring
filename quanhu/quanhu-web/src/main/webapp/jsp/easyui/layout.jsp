<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/taglib.jsp"%>
<html>
<head>
    <title>布局</title>

    <script type="text/javascript">
        $(function(){
        	
        })
        
       
    </script>
</head>
<body>
    <div id="cc" class="easyui-layout" data-options="fit:true">   
    <div data-options="region:'north',title:'XXXX后台管理系统',split:true,border:false" style="height:100px;">
    	<font color="blue" size="14">XXXX后台管理系统</font>
    </div>   
    <div data-options="region:'west',title:'菜单栏',split:true" style="width:100px;">
    	<div class="easyui-menu" data-options="fit:true">
    		<div>文章</div>
    		<div>sdf</div>
    	</div>
    </div>   
    <div data-options="region:'center',title:'主体内容'" style="padding:5px;background:#eee;"></div>   
</div>  
</body>
</html>

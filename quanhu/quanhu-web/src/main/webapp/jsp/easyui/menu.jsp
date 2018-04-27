<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/taglib.jsp"%>
<html>
<head>
    <title>菜单</title>

    <script type="text/javascript">
        $(function(){
        	$("#mm").menu("show",{
        		left:100,
        		top:100,
            });
        	
        	$("#mm").menu({
				hideOnUnhover:false,
				
				onClick:function(){
					var wenzhang=$("#mm").menu("findItem","文章");
					$("#mm").menu("setText",{
						target:wenzhang.target,
						text:"wenzhang",
					})
				},
        		
        		onHide:function(){
        			//alert("显示惨淡了 ");
        			var itemEl = $('#mm')[0];  // 获取菜单项
        			console.log(itemEl);
        			$("#mm").menu("showItem",itemEl);
        		},
        	})
        	
        	
        })
        
       
    </script>
</head>
<body>
    <div id="mm" class="easyui-menu" style="width:200px;height: 800px">   
	    <div data-options="iconCls:'icon-tip'">文章</div>   
	    <div>   
	        <span>话题</span>   
	        <div style="width:150px;">   
	            <div  ><b>话题列表</b></div>   
	            <div>帖子列表</div>   
	            <div>话题详情</div>   
	        </div>   
	    </div>   
	    <div data-options="iconCls:'icon-save'">活动</div>   
	    <div class="menu-sep"></div>   
	    <div >问答</div>   
	</div>  
</body>
</html>

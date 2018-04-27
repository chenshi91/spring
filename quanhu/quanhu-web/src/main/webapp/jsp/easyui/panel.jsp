<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/include/taglib.jsp"%>
<html>
<head>
    <title>panel</title>

    <script type="text/javascript">
        $(function(){
        	$("#panel").panel({
            	width:300,
            	height:200, 
            	title:"mianban面板标题",
            	content:"昨天吃了吗？",
            	collapsible:true,
            	minimizable:true,
            	maximizable:true,
            	href:"${ctx}/chi",
            	extractor:function(data){
            		return	"梦想是什么？"+data;
            	},
            	loadingMessage:"自定义的我在加载...",
            	openAnimation:"fade",
            	
            	onOpen:function(){
            		/* var body=$("#panle").panle("body"); */
            		alert("hello");
            	},
            	onMaximize:function(){
            		alert("sdsdsd");
            		$("#panel").panel("setTitle","给信水电费水电费");
            		$("#panel").panel("clear");
            	},
            	onRestore:function(){
            		$("#panel").panel("setTitle","onRestore宣传部");
            		$("#panel").panel("resize",{
            			width:500,
            			height:400,
            		});
            	}
            	
            })
        })
    </script>
</head>
<body>
    <div    id="panel" >
        问题我也跳舞因特网没下次不能相比出现拿不出 ----撒大声地所多1111###$%$%%%$%$%$%$%$
    </div>
</body>
</html>

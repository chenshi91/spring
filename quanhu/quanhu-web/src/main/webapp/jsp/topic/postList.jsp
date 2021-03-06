<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>后台管理系统</h1>
	<div	style="color: red">帖子管理</div>
	<div>
		<table	border="1" style="table-layout:fixed;">
			<tr>
				<th></th>
				<th>id</th>
				<th>话题标题</th>
				<th>帖子内容</th>
				<th>帖子图片</th>
				<th>是否推荐</th>
				<th>上下架状态</th>
				<th>热度</th>
				<th>创建人id</th>
				<th>创建时间</th>
				<th>上次更新时间</th>
				<th>操作</th>
			</tr>
			<c:if test="${list.isEmpty() }">
				<tr>
					<th>暂无话题相关帖子信息!</th>
				</tr>
			</c:if>
			<c:forEach	items="${list }"	var="entity">
				<tr	bgcolor="${entity.commonEnum.color }">
					<td	style="  "	align="center"><input	type="checkbox"/></td>
					<td	style="  "	align="center">${entity.id }</td>
					<td	style="  "	align="center">${entity.topicTitle }</td>
					<td	style="  "	align="center">${entity.content.length()>30?entity.content.substring(0,30):entity.content }</td>
					<td	style="  "	align="center"><%-- ${entity.imgUrl } --%></td>
					<td	style="  "	align="center">${entity.recommend==0?'不推荐':'推荐' }</td>
					<td	style="  "	align="center">${entity.commonEnum.key }</td>
					<td	style="  "	align="center"><%-- ${entity.heat } --%></td>
					<td	style="  "	align="center">${entity.createUserId }</td>
					<td	style="  "	align="center">${entity.createDate }</td>
					<td	style="  "	align="center">${entity.lastUpdateDate }</td>
					<td	style="  "	align="center"><input	type="button"	value="添加"><input	type="button"	value="修改"></td>
				</tr>
			</c:forEach>
		</table>
		
	</div>
</body>
</html>
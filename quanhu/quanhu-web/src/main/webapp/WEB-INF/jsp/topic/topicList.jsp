<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>话题列表</title>
</head>
<body>
	<h1>springMVC成功!</h1>
	<div	style="color: red">斗鱼tv</div>
	<div>
		<table>
			<tr>
				<th>id</th>
				<th>标题</th>
				<th>内容</th>
				<th>图片</th>
				<th>是否推荐</th>
				<th>上下架状态</th>
				<th>热度</th>
				<th>创建人id</th>
				<th>创建时间</th>
				<th>上次更新时间</th>
			</tr>
			<c:if test="${list.isEmpty() }">
				<tr>
					<th>暂无话题信息!</th>
				</tr>
			</c:if>
			<c:forEach	items="${list }"	var="entity">
				<tr	bgcolor="green">
					<td	style="  "	align="center">${entity.id }</td>
					<td	style="  "	align="center">${entity.title }</td>
					<td	style="  "	align="center">${entity.content.length()>30?entity.content.substring(0,30):entity.content }</td>
					<td	style="  "	align="center"><%-- ${entity.imgUrl } --%></td>
					<td	style="  "	align="center">${entity.recommend }</td>
					<td	style="  "	align="center">${entity.shelveFlag }</td>
					<td	style="  "	align="center"><%-- ${entity.heat } --%></td>
					<td	style="  "	align="center">${entity.createUserId }</td>
					<td	style="  "	align="center">${entity.createDate }</td>
					<td	style="  "	align="center">${entity.lastUpdateDate }</td>
				</tr>
			</c:forEach>
		</table>
		
	</div>
</body>
</html>
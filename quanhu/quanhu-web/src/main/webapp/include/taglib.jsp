<%-- <%@ taglib prefix="shiro" uri="/WEB-INF/tlds/shiros.tld" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>
<%@ taglib prefix="fnc" uri="/WEB-INF/tlds/fnc.tld" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<%@ taglib prefix="act" tagdir="/WEB-INF/tags/act" %>
<%@ taglib prefix="cms" tagdir="/WEB-INF/tags/cms" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/static"/>
<%-- <c:set var="ctxServer" value="${fns:getConfig('mannger.fileUPpath')}"/>
<c:set var="ctxAppServer" value="${fns:getConfig('mannger.appUPpath')}"/>
<c:set var="ctxFileServer" value="${fns:getConfig('uploadUrl')}"/>
<c:set var="ctxFrontServer" value="${fns:getConfig('front.server.url')}" /> --%>


	<script type="text/javascript" src="${ctx}/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${ctx}/easyui/easyui-lang-zh_CN.js"></script>
    <link rel="stylesheet" type="text/css" href="${ctx}/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/easyui/themes/icon.css">
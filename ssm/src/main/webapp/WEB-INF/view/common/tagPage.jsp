<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%
    response.setHeader("cache-control", "max-age=5,public,must-revalidate"); //one day
    response.setDateHeader("expires", -1);
    String cdntime = String.valueOf(System.currentTimeMillis());
    request.setAttribute("cdntime",cdntime); //在更新静态资源的时候 可以防止浏览器缓存
%>
<%--<c:set value="${pageContext.request.contextPath}" var="webRoot" />--%>
<%
//    域名+端口+应用名

    String webRoot = "http://" + request.getServerName() + ":" + request.getServerPort()+request.getContextPath();
    request.setAttribute("webRoot",webRoot);
%>
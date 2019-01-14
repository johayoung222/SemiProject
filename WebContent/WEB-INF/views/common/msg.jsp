<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String msg = (String)request.getAttribute("msg");
    String loc = (String)request.getAttribute("loc");
    String script = (String)request.getAttribute("script");
    boolean history = request.getAttribute("history")==null?false:true;

%>
<script>
<% if(history){ %>
	alert("히스토리 없어져라!!");
	console.log(history);
<% }else{ %>
location.replace('<%=request.getContextPath()+loc %>');
alert("<%=msg %>");
<%=script!=null?script:" " %>
<% } %>
</script>
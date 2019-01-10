<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String msg = (String)request.getAttribute("msg");
    String loc = (String)request.getAttribute("loc");
    String script = (String)request.getAttribute("script");

%>
<script>
alert("<%=msg %>");

<%=script!=null?script:""%>
location.href = "<%=loc%>";
</script>
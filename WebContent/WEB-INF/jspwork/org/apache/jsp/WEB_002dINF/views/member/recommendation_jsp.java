/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.35
 * Generated at: 2019-01-13 15:44:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class recommendation_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>온도에 따른 추천 의상, 여행지</title>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/js/jquery-3.3.1.js\"></script>\r\n");
      out.write("\r\n");

	String temp = request.getParameter("temp");
	
	System.out.println("시험하는곳 temp = "+temp);

      out.write("\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("div.container{\r\n");
      out.write("\tfloat: left;\r\n");
      out.write("\twidth: 29%;\r\n");
      out.write("\theight:300px;\r\n");
      out.write("    margin: 10px;\r\n");
      out.write("    padding: 10px;\r\n");
      out.write("\tbackground:lightgrey;\r\n");
      out.write("\ttext-align:center;\r\n");
      out.write("}\r\n");
      out.write("table {\r\n");
      out.write("\tborder:1px solid;\r\n");
      out.write("\tmargin:auto;\r\n");
      out.write("}\r\n");
      out.write("td,th {\r\n");
      out.write("\tborder:1px solid;\r\n");
      out.write("}\r\n");
      out.write("span#time{\r\n");
      out.write("\ttext-decoration:underline;\r\n");
      out.write("\tmargin: 15px;\r\n");
      out.write("    display: block;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h1>온도에 따른 추천 의상, 여행지 </h1>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\t<h2>추천 의상</h2>\r\n");
      out.write("\t<div id=\"order-list\"></div>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</div>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("function printTime() {\r\n");
      out.write("      var time = document.getElementById(\"time\");            // 출력할 장소 선택\r\n");
      out.write("      var now = new Date();                                                  // 현재시간\r\n");
      out.write("      var nowTime = now.getFullYear() + \"년 \" + (now.getMonth()+1) + \"월 \" + now.getDate() + \"일 \" + now.getHours() + \"시 \" + now.getMinutes() + \"분 \" + now.getSeconds() + \"초\";\r\n");
      out.write("\r\n");
      out.write("      time.innerHTML = nowTime;           // 현재시간을 출력\r\n");
      out.write("\r\n");
      out.write("      setTimeout(\"printTime()\",1000);         // setTimeout(“실행할함수”,시간) 시간은1초의 경우 1000\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\t<h2>추천 여행지</h2>\r\n");
      out.write("\t<h4 id=\"time\"></h4>\r\n");
      out.write("\t<div id=\"rank-list\"></div>\r\n");
      out.write("</div>\r\n");
      out.write("\t   \r\n");
      out.write("\t<script>\r\n");
      out.write("\twindow.onload =function(){\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl: \"");
      out.print(request.getContextPath());
      out.write("/temperature/recdress.do\",\r\n");
      out.write("\t\t\ttype: \"get\",\r\n");
      out.write("\t\t\tdataType: \"json\",\r\n");
      out.write("\t\t\tdata: \"temp=\"+");
      out.print(temp);
      out.write(",\r\n");
      out.write("\t\t\tsuccess: function (data) {\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tconsole.log(data); //data는 이미 javascript배열객체\r\n");
      out.write("\t\t\t\t//json <----> javascript\r\n");
      out.write("\t\t\t\t//\t   <--- JSON.stringgify()\r\n");
      out.write("\t\t\t\t//\t  \t---> JSON.parse()\r\n");
      out.write("\t\t\t\tvar table = $(\"<table></table>\");\r\n");
      out.write("\t\t\t\tvar html = \"<tr><th>온도</th><th>추천내용</th></tr>\";\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tif(");
      out.print(temp);
      out.write(" <= 5){\r\n");
      out.write("\t\t\t\t\thtml += \"<tr><td>~5도C</td>\";\r\n");
      out.write("\t\t\t\t\thtml += \"<td>겨울 옷 (야상, 패딩, 목도리 등등 다)</td></tr>\";\r\n");
      out.write("\t\t\t\t}else if((");
      out.print(temp);
      out.write(" > 5)&&(");
      out.print(temp);
      out.write(" <= 9)){\r\n");
      out.write("\t\t\t\t\thtml += \"<tr><td>6도C~9도C</td>\";\r\n");
      out.write("\t\t\t\t\thtml += \"<td>코트, 가죽자켓</td></tr>\";\r\n");
      out.write("\t\t\t\t}else if((");
      out.print(temp);
      out.write(" > 9)&&(");
      out.print(temp);
      out.write(" <= 11)){\r\n");
      out.write("\t\t\t\t\thtml += \"<tr><td>10도C~11도C</td>\";\r\n");
      out.write("\t\t\t\t\thtml += \"<td>트렌치코트, 간절기 야상, 여러겹 껴입기</td></tr>\";\r\n");
      out.write("\t\t\t\t}else if((");
      out.print(temp);
      out.write(" > 11)&&(");
      out.print(temp);
      out.write(" <= 16)){\r\n");
      out.write("\t\t\t\t\thtml += \"<tr><td>12도C~16도C</td>\";\r\n");
      out.write("\t\t\t\t\thtml += \"<td>자켓,셔츠,가디건,간절기 야상</td></tr>\";\r\n");
      out.write("\t\t\t\t}else if((");
      out.print(temp);
      out.write(" > 16)&&(");
      out.print(temp);
      out.write(" <= 19)){\r\n");
      out.write("\t\t\t\t\thtml += \"<tr><td>17도C~19도C</td>\";\r\n");
      out.write("\t\t\t\t\thtml += \"<td>니트,가디건,후드티,면바지,슬랙스,스키니</td></tr>\";\r\n");
      out.write("\t\t\t\t}else if((");
      out.print(temp);
      out.write(" > 19)&&(");
      out.print(temp);
      out.write(" <= 22)){\r\n");
      out.write("\t\t\t\t\thtml += \"<tr><td>20도C~22도C</td>\";\r\n");
      out.write("\t\t\t\t\thtml += \"<td>긴팔티, 가디건, 후드티, 면바지, 슬랙스</td></tr>\";\r\n");
      out.write("\t\t\t\t}else if(");
      out.print(temp);
      out.write(" > 22){\r\n");
      out.write("\t\t\t\t\thtml += \"<tr><td>10도C~11도C</td>\";\r\n");
      out.write("\t\t\t\t\thtml += \"<td>반팔,얇은셔츠,얇은긴팔,반바지</td></tr>\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\ttable.append(html);\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t$(\"#order-list\").html(table);\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terror: function (jqxhr, textStatus, errorThrown) {\r\n");
      out.write("\t\t\t\tconsole.log(\"ajax처리실패!\");\r\n");
      out.write("\t\t\t\tconsole.log(jqxhr);\r\n");
      out.write("\t\t\t\tconsole.log(textStatus);\r\n");
      out.write("\t\t\t\tconsole.log(errorThrown);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl: \"");
      out.print(request.getContextPath());
      out.write("/temperature/rectour.do\",\r\n");
      out.write("\t\t\ttype: \"get\",\r\n");
      out.write("\t\t\tdataType: \"json\",\r\n");
      out.write("\t\t\tdata: \"temp=\"+");
      out.print(temp);
      out.write(",\r\n");
      out.write("\t\t\tsuccess: function (data) {\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tconsole.log(data); //data는 이미 javascript배열객체\r\n");
      out.write("\t\t\t\t//json <----> javascript\r\n");
      out.write("\t\t\t\t//\t   <--- JSON.stringgify()\r\n");
      out.write("\t\t\t\t//\t  \t---> JSON.parse()\r\n");
      out.write("\t\t\t\tvar table = $(\"<table></table>\");\r\n");
      out.write("\t\t\t\tvar html = \"<tr><th>온도</th><th>추천내용</th></tr>\";\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tif(");
      out.print(temp);
      out.write(" <= 10){\r\n");
      out.write("\t\t\t\t\thtml += \"<tr><td>~5도C</td>\";\r\n");
      out.write("\t\t\t\t\thtml += \"<td>실내에서 노시는게 좋을겁니다^^</td></tr>\";\r\n");
      out.write("\t\t\t\t}else if(");
      out.print(temp);
      out.write(" > 10)\r\n");
      out.write("\t\t\t\t{\r\n");
      out.write("\t\t\t\t\thtml += \"<tr><td>~5도C</td>\";\r\n");
      out.write("\t\t\t\t\thtml += \"<td>밖에서 노시죠^^</td></tr>\";\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\ttable.append(html);\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t$(\"#rank-list\").html(table);\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terror: function (jqxhr, textStatus, errorThrown) {\r\n");
      out.write("\t\t\t\tconsole.log(\"ajax처리실패!\");\r\n");
      out.write("\t\t\t\tconsole.log(jqxhr);\r\n");
      out.write("\t\t\t\tconsole.log(textStatus);\r\n");
      out.write("\t\t\t\tconsole.log(errorThrown);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.35
 * Generated at: 2019-01-13 07:01:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.schedule;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.kh.schedule.model.vo.*;
import com.kh.member.model.vo.*;

public final class oneDay_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1547209527671L));
    _jspx_dependants.put("/WEB-INF/views/common/side.jsp", Long.valueOf(1547209570217L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("com.kh.schedule.model.vo");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("com.kh.member.model.vo");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");

	Member memberLoggedIn = (Member)session.getAttribute("memberLoggedIn");  


      out.write("\r\n");
      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("  <meta charset=\"utf-8\">\r\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("  <link href=\"https://fonts.googleapis.com/css?family=Alfa+Slab+One|Staatliches|Noto+Sans+KR|Abril+Fatface\" rel=\"stylesheet\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/header.css\">\r\n");
      out.write("  <link rel=\"shortcut icon\" href=\"");
      out.print(request.getContextPath() );
      out.write("/images/logo(favicon).png\" type=\"image/png\" sizes=\"128x128\">\r\n");
      out.write("  <script src=\"");
      out.print(request.getContextPath() );
      out.write("/js/jquery-3.3.1.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<style>\r\n");
      out.write("#logged-in{\r\n");
      out.write("\twidth: 250px;\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\tright: 0px;\r\n");
      out.write("\ttop: 5px;\t\t\t\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<body oncontextmenu=\"return false;\">\r\n");
      out.write("  <nav class=\"header\">\r\n");
      out.write("    <div class=\"logo\">\r\n");
      out.write("      <img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/logo.png\" width=\"50px\" height=\"50px\" >\r\n");
      out.write("      <span class=\"logofont\">7' Scheduler\r\n");
      out.write("      </span>\r\n");
      out.write("    </div>  \r\n");
      out.write("   ");
if(memberLoggedIn != null){ 
      out.write("\r\n");
      out.write("  <table id=\"logged-in\" >\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t ");
      out.print(memberLoggedIn.getMemberName() );
      out.write("님,\t안녕하세요 :)\t\t \r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t\t<input type=\"button\" value=\"내정보\" onclick='location.href=\"");
      out.print(request.getContextPath());
      out.write("/member/MemberView?memberId=");
      out.print(memberLoggedIn.getMemberId());
      out.write("\";'/>\r\n");
      out.write("\t\t\t&nbsp;\r\n");
      out.write("\t\t\t<input type=\"button\" value=\"로그아웃\" onclick=\"logout();\"/>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t</table>\t\r\n");
      out.write("\t");
}else{ 
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\r\n");
      out.write("\t");
} 
      out.write("\r\n");
      out.write("    \r\n");
      out.write("  </nav>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("$(\".logo\").click(function(){\r\n");
      out.write("\tlocation.href = \"");
      out.print(request.getContextPath() );
      out.write("\";\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("function logout(){\r\n");
      out.write("\tlocation.href = \"");
      out.print(request.getContextPath() );
      out.write("/member/logout\";\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("<!DOCTYPE html >\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css?family=Alfa+Slab+One|Staatliches|Noto+Sans+KR|Abril+Fatface\" rel=\"stylesheet\">\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/js/jquery-3.3.1.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/side.css\" />\r\n");
      out.write("<style>\r\n");
      out.write("#friends{\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\tbackground:gray;\r\n");
      out.write("\ttop:-80px;\r\n");
      out.write("\tleft:200px;\r\n");
      out.write("\twidth: 350px;\r\n");
      out.write("\theight:300px;\r\n");
      out.write("\tborder: 1px solid red;\r\n");
      out.write("\tdisplay: none;\r\n");
      out.write("\tz-index: 2;\r\n");
      out.write("\toverflow: scroll;\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("ul#autoComplete{\r\n");
      out.write("\tmin-width: 159px;\r\n");
      out.write("\tborder: 1px solid gray;\r\n");
      out.write("\tdisplay: none;\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul#autoComplete li{\r\n");
      out.write("\tpadding: 0 10px;\r\n");
      out.write("\tlist-style: none;\r\n");
      out.write("\tcursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul#autoComplete li.selected{\r\n");
      out.write("\tbackground: lightseagreen;\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("span.srchVal{\r\n");
      out.write("\tcolor: red;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script>\r\n");
      out.write("  function showPopup(temp) {\r\n");
      out.write("\t  var windowW = 800;  // 창의 가로 길이\r\n");
      out.write("      var windowH = 500;  // 창의 세로 길이\r\n");
      out.write("      var left = Math.ceil((window.screen.width - windowW)/2);\r\n");
      out.write("      var top = Math.ceil((window.screen.height - windowH)/2);\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t  window.open(\"");
      out.print(request.getContextPath() );
      out.write("/member/recommendation?temp=\"+temp, \"a\",\"l top=\"+top+\", left=\"+left+\", height=\"+windowH+\", width=\"+windowW); \r\n");
      out.write("\t  \r\n");
      out.write("\t  \r\n");
      out.write("  }\r\n");
      out.write("  function addfriend(){\r\n");
      out.write("\t$(\"#friends\").css('display','inline-block');\t  \r\n");
      out.write("  }\r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("  \r\n");
      out.write("  </script>\r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  <script>\r\n");
      out.write("  \r\n");
      out.write("  window.onload =function(){\r\n");
      out.write("\tvar apiURI = \"http://api.openweathermap.org/data/2.5/weather?q=Seoul&appid=c95231fca9f07b22a6540efdcce37587\";\r\n");
      out.write("    $.ajax({\r\n");
      out.write("        url: apiURI,\r\n");
      out.write("        dataType: \"json\",\r\n");
      out.write("        type: \"GET\",\r\n");
      out.write("        async: \"false\",\r\n");
      out.write("        success: function(resp) {\r\n");
      out.write("        \tvar myDiv = document.getElementById(\"myDiv\"); \r\n");
      out.write("        \tvar table = $(\"<table></table>\");\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar html = \"<br><br>현재온도 : \"+(resp.main.temp- 273.15)+\"<br>\";\r\n");
      out.write("\t\t\thtml += \"상세날씨 설명 : \"+resp.main.humidity+\"<br>\";\r\n");
      out.write("\t\t\thtml += \"날씨 : \"+resp.weather[0].description+\"<br>\";\r\n");
      out.write("\t\t\thtml += \"나라 : \"+resp.sys.country+\"<br>\";\r\n");
      out.write("\t\t\thtml += \"도시 이름 : \"+resp.name+\"<br>\";\r\n");
      out.write("\t\t\thtml += \"구름 : \"+(resp.clouds.all)+\"%<br>\";\r\n");
      out.write("\t\t\thtml += \"<input type='button' value='추천 여행,의상 보기' onclick= 'showPopup(\"+(resp.main.temp- 273.15)+\");'/>\";\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tmyDiv.innerHTML = html;\r\n");
      out.write("\t\t\t\r\n");
      out.write("            //console.log(resp);\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("            /* console.log(\"현재온도 : \"+ (resp.main.temp- 273.15) );\r\n");
      out.write("            console.log(\"현재습도 : \"+ resp.main.humidity);\r\n");
      out.write("            console.log(\"날씨 : \"+ resp.weather[0].main );\r\n");
      out.write("            console.log(\"상세날씨설명 : \"+ resp.weather[0].description );\r\n");
      out.write("            console.log(\"날씨 이미지 : \"+ resp.weather[0].icon );\r\n");
      out.write("            console.log(\"바람   : \"+ resp.wind.speed );\r\n");
      out.write("            console.log(\"나라   : \"+ resp.sys.country );\r\n");
      out.write("            console.log(\"도시이름  : \"+ resp.name );\r\n");
      out.write("            console.log(\"구름  : \"+ (resp.clouds.all) +\"%\" );   */              \r\n");
      out.write("        \t}\r\n");
      out.write("    \t})\r\n");
      out.write("\t};\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"side\">\r\n");
      out.write("\t\t<br />\r\n");
      out.write("\t\t<br />\r\n");
      out.write("\t\t<br />\r\n");
      out.write("\t\t<br />\r\n");
      out.write("\t\t<a href=\"");
      out.print(request.getContextPath());
      out.write("/schedule/schedulelist\">스케줄 찾기</a><br />\r\n");
      out.write("\t\t<a href=\"##\">년간 달력5</a><br />\r\n");
      out.write("\t\t<a href=\"##\">년간 달력6</a><br />\r\n");
      out.write("\t\t<a href=\"##\">년간 달력7</a><br />\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div id=\"myDiv\">\r\n");
      out.write("\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"friend\">\r\n");
      out.write("\t\t\t<p>친구들</p>\r\n");
      out.write("\t\t\t<button id=\"addfriend\" onclick=\"addfriend();\">친구 +</button><br />\r\n");
      out.write("\t\t\t<span>친구1</span><br />\r\n");
      out.write("\t\t\t<span>친구2</span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"friends\">\r\n");
      out.write("\t\t<form class=\"insertFriendFrm\" name=\"insertFriendFrm\"\r\n");
      out.write("\t\t\taction=\"");
      out.print(request.getContextPath());
      out.write("/friend/insertFriend\" \r\n");
      out.write("\t\t\tmethod=\"post\">\r\n");
      out.write("\t\t\t\t<label for=\"srchId\">아이디 : </label>\r\n");
      out.write("\t\t\t\t<input type=\"text\"  id=\"srchId\" autocomplete=\"off\" />\r\n");
      out.write("\t\t\t\t<button type=\"submit\">친구찾기</button>\r\n");
      out.write("\t\t\t\t\t<ul id=\"autoComplete\">\r\n");
      out.write("\t\t\t\t\t\t<li>1</li>\r\n");
      out.write("\t\t\t\t\t\t<li>2</li>\r\n");
      out.write("\t\t\t\t\t\t<li>3</li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<hr />\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("$(\"#srchId\").on(\"keyup\" , function(e){\r\n");
      out.write("\tconsole.log(e.key);\r\n");
      out.write("\tvar selected = $(\".selected\");\r\n");
      out.write("\tvar li = $(\"#autoComplete li\");\r\n");
      out.write("\t\r\n");
      out.write("\tif(e.key == \"ArrowDown\") {\r\n");
      out.write("\t\tif(selected.length == 0) {\r\n");
      out.write("\t\t\t$(\"#autoComplete li:first\").addClass(\"selected\");\r\n");
      out.write("\t\t} else if(selected.is(li.last())) {\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tselected.removeClass(\"selected\").next().addClass(\"selected\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t} else if(e.key == \"ArrowUp\") {\r\n");
      out.write("\t\tif(selected.length == 0) {\r\n");
      out.write("\t\t} else if(selected.is(li.first())) {\r\n");
      out.write("\t\t\tselected.removeClass(\"selected\");\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\tselected.removeClass(\"selected\").prev().addClass(\"selected\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t} else if(e.key == \"Enter\") {\r\n");
      out.write("\t\t$(this).val(selected.text());\r\n");
      out.write("\t\t$(\"#autoComplete\").hide().children().remove();\r\n");
      out.write("\t} else {\r\n");
      out.write("\t\tvar srchId = $(this).val().trim();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(srchId.length == 0) {\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl: \"");
      out.print(request.getContextPath());
      out.write("/friend/autoComplete.do\" ,\r\n");
      out.write("\t\t\ttype: \"post\" ,\r\n");
      out.write("\t\t\tdata: {srchId:srchId} ,\r\n");
      out.write("\t\t\tsuccess: function(data) {\r\n");
      out.write("\t\t\t\tconsole.log(data);\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tvar idArr = data.split(\",\");\r\n");
      out.write("\t\t\t\tvar html = \"\";\r\n");
      out.write("\t\t\t\tfor(var i = 0;i < idArr.length;i++) {\r\n");
      out.write("\t\t\t\t\thtml += \"<li>\"+idArr[i].replace(srchId,\"<span class='srchVal'>\"+srchId+\"</span>\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tif(data.length != 0) {\r\n");
      out.write("\t\t\t\t\t$(\"#autoComplete\").html(html).css(\"display\" , \"inline-block\");\t\t\t\t\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("$(\"#autoComplete\").on(\"click\" , \"li\" , function(){\r\n");
      out.write("\t$(\"#srchId\").val($(this).text());\r\n");
      out.write("\t$(\"#autoComplete\").hide().children().remove();\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("$(\"#autoComplete\").on(\"mouseenter\" , \"li\" , function() {\r\n");
      out.write("\t$(this).siblings().removeClass(\"selected\");\r\n");
      out.write("\t$(this).addClass(\"selected\");\r\n");
      out.write("});\r\n");
      out.write("$(\"#autoComplete\").on(\"mouseleave\" , \"li\" , function() {\r\n");
      out.write("\t$(this).removeClass(\"selected\");\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("</script>\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\r\n");

	int year = (int)request.getAttribute("year");
	int month = (int)request.getAttribute("month");
	int day = (int)request.getAttribute("day");
	Member member = (Member)request.getAttribute("member");
	List<Schedule> list = (List<Schedule>)request.getAttribute("list");


      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/oneday1.css\" />\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/js/jquery-3.3.1.js\"></script>\r\n");
      out.write("<!-- \r\n");
      out.write(" <h3>");
      out.print(day );
      out.write("일</h3>\r\n");
      out.write(" -->\r\n");
      out.write("<h4>");
      out.print(year );
      out.write('년');
      out.write(' ');
      out.print(month );
      out.write('월');
      out.write(' ');
      out.print(day );
      out.write('일');
      out.write(' ');
      out.print(member.getMemberName() );
      out.write("님의 Schedule</h4>\r\n");
      out.write("<div id=\"oneday-container\">\r\n");
      out.write("\t<form action=\"");
      out.print(request.getContextPath() );
      out.write("/schedule/insertSchedule\" id=\"boardInfo\" name=\"insertFrm\" method=\"post\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"year\" value=\"");
      out.print(year );
      out.write("\"/>\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"month\" value=\"");
      out.print(month );
      out.write("\"/>\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"day\" value=\"");
      out.print(day );
      out.write("\"/>\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"time\" value=\"100\"/>\r\n");
      out.write("\t</form>\r\n");
      out.write("\r\n");
      out.write("<div id=\"todolist\">\r\n");
      out.write("\t<h2>To do List</h2>\r\n");
      out.write("\t<div id=\"insertBoard\">+</div>\r\n");
      out.write("\t<div id=\"right-click\">\r\n");
      out.write("\t");
 if(!list.isEmpty()){ 
		String s = "";	
		for(int i=0; i<list.size(); i++){ 
	 		s += "<div><h4 id='"+list.get(i).getScheduleNo()+"'>"+list.get(i).getScheduleTitle()+"</h4></div>";
	   } 
      out.write('\r');
      out.write('\n');
      out.write('	');
      out.print(s );
      out.write('\r');
      out.write('\n');
      out.write('	');
 } 
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"middleLine\"></div>\r\n");
      out.write("<style>\r\n");
      out.write("#contextMenu{\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\twidth: 150px;\r\n");
      out.write("    border: 1px solid black;\r\n");
      out.write("    background-color: rgba(211, 211, 211, 0.815);\r\n");
      out.write("    display: none;\r\n");
      out.write("}\r\n");
      out.write("#contextMenu .menu1{\r\n");
      out.write("\theight: 25px;\r\n");
      out.write("\tborder: none;\r\n");
      out.write("}\r\n");
      out.write("#contextMenu div:hover{\r\n");
      out.write("\tbackground-color: #616161d0;\r\n");
      out.write("}\r\n");
      out.write("#right-click{\r\n");
      out.write("\tborder: none;\r\n");
      out.write("\tpadding: 0px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script>\r\n");
      out.write("$(\"#right-click\").contextmenu(function(e) {\r\n");
      out.write("\tthisTarget = e.target;\r\n");
      out.write("\tvar pageX = e.originalEvent.pageX;\r\n");
      out.write("\tvar pageY = e.originalEvent.pageY;\r\n");
      out.write("\t$(\"#contextMenu\").css({\"left\":pageX, \"top\":pageY, \"display\":\"block\"});\r\n");
      out.write("\t\r\n");
      out.write("\t$(\"#contextMenu div\").each(function(idx,item){\r\n");
      out.write("\t\t$(item).click(function(){\r\n");
      out.write("\t\t\t$(this).parent()[0].style.display = 'none';\r\n");
      out.write("\t\t\tvar value = thisTarget.id;\r\n");
      out.write("\t\t\tlocation.href = \"");
      out.print(request.getContextPath() );
      out.write("/schedule/deleteScheduleEnd?scheduleNo=\"+value;\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("$(document).on('click',function(){\r\n");
      out.write("\tif($(\"#contextMenu\").css(\"display\") == 'block'){\r\n");
      out.write("\t\t$(\"#contextMenu\").css(\"display\",\"none\");\r\n");
      out.write("\t}\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<div id=\"timeline\">\r\n");
      out.write("\t<h3>TimeLine</h3>\r\n");
      out.write("\t<div id=\"scroll-box\">\r\n");
      out.write("\t\t<div id=\"0\">00시 \r\n");
      out.write("\t\t\t");
for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 0){
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.print(list.get(i).getScheduleTitle() );
      out.write("\t\r\n");
      out.write("\t\t\t");
}
			}
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"1\">01시\r\n");
      out.write("\t\t\t");
for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 1){
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.print(list.get(i).getScheduleTitle() );
      out.write("\t\r\n");
      out.write("\t\t\t");
}
			}
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("        <div id=\"2\">02시\r\n");
      out.write("        \t");
for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 2){
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.print(list.get(i).getScheduleTitle() );
      out.write("\t\r\n");
      out.write("\t\t\t");
}
			}
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"3\">03시\r\n");
      out.write("        \t");
for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 3){
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.print(list.get(i).getScheduleTitle() );
      out.write("\t\r\n");
      out.write("\t\t\t");
}
			}
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"4\">04시\r\n");
      out.write("        \t");
for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 4){
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.print(list.get(i).getScheduleTitle() );
      out.write("\t\r\n");
      out.write("\t\t\t");
}
			}
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"5\">05시\r\n");
      out.write("        \t");
for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 5){
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.print(list.get(i).getScheduleTitle() );
      out.write("\t\r\n");
      out.write("\t\t\t");
}
			}
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"6\">06시\r\n");
      out.write("        \t");
for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 6){
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.print(list.get(i).getScheduleTitle() );
      out.write("\t\r\n");
      out.write("\t\t\t");
}
			}
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"7\">07시\r\n");
      out.write("        \t");
for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 7){
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.print(list.get(i).getScheduleTitle() );
      out.write("\t\r\n");
      out.write("\t\t\t");
}
			}
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"8\">08시\r\n");
      out.write("        \t");
for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 8){
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.print(list.get(i).getScheduleTitle() );
      out.write("\t\r\n");
      out.write("\t\t\t");
}
			}
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"9\">09시\r\n");
      out.write("        \t");
for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 9){
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.print(list.get(i).getScheduleTitle() );
      out.write("\t\r\n");
      out.write("\t\t\t");
}
			}
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"10\">10시\r\n");
      out.write("        \t");
for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 10){
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.print(list.get(i).getScheduleTitle() );
      out.write("\t\r\n");
      out.write("\t\t\t");
}
			}
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"11\">11시\r\n");
      out.write("        \t");
for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 11){
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.print(list.get(i).getScheduleTitle() );
      out.write("\t\r\n");
      out.write("\t\t\t");
}
			}
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"12\">12시\r\n");
      out.write("        \t");
for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 12){
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.print(list.get(i).getScheduleTitle() );
      out.write("\t\r\n");
      out.write("\t\t\t");
}
			}
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"13\">13시\r\n");
      out.write("        \t");
for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 13){
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.print(list.get(i).getScheduleTitle() );
      out.write("\t\r\n");
      out.write("\t\t\t");
}
			}
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"14\">14시\r\n");
      out.write("        \t");
for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 14){
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.print(list.get(i).getScheduleTitle() );
      out.write("\t\r\n");
      out.write("\t\t\t");
}
			}
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"15\">15시\r\n");
      out.write("        \t");
for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 15){
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.print(list.get(i).getScheduleTitle() );
      out.write("\t\r\n");
      out.write("\t\t\t");
}
			}
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"16\">16시\r\n");
      out.write("        \t");
for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 16){
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.print(list.get(i).getScheduleTitle() );
      out.write("\t\r\n");
      out.write("\t\t\t");
}
			}
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"17\">17시\r\n");
      out.write("        \t");
for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 17){
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.print(list.get(i).getScheduleTitle() );
      out.write("\t\r\n");
      out.write("\t\t\t");
}
			}
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"18\">18시\r\n");
      out.write("        \t");
for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 18){
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.print(list.get(i).getScheduleTitle() );
      out.write("\t\r\n");
      out.write("\t\t\t");
}
			}
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"19\">19시\r\n");
      out.write("        \t");
for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 19){
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.print(list.get(i).getScheduleTitle() );
      out.write("\t\r\n");
      out.write("\t\t\t");
}
			}
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"20\">20시\r\n");
      out.write("        \t");
for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 20){
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.print(list.get(i).getScheduleTitle() );
      out.write("\t\r\n");
      out.write("\t\t\t");
}
			}
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"21\">21시\r\n");
      out.write("        \t");
for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 21){
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.print(list.get(i).getScheduleTitle() );
      out.write("\t\r\n");
      out.write("\t\t\t");
}
			}
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"22\">22시\r\n");
      out.write("        \t");
for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 22){
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.print(list.get(i).getScheduleTitle() );
      out.write("\t\r\n");
      out.write("\t\t\t");
}
			}
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"23\">23시\r\n");
      out.write("        \t");
for(int i = 0; i<list.size(); i++) {
				if(list.get(i).getScheduleTimeline() == 23){
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.print(list.get(i).getScheduleTitle() );
      out.write("\t\r\n");
      out.write("\t\t\t");
}
			}
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"contextMenu\">\r\n");
      out.write("\t<div class=\"menu1\">삭제하기</div>\r\n");
      out.write("</div>\r\n");
      out.write("<script>\r\n");
      out.write("$(\"#insertBoard\").click(function(){\r\n");
      out.write("\tinsertFrm.submit();\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("$(\"#todolist div#insertBoard\").nextAll().click(function(e){\r\n");
      out.write("\tvar target = e.target;\r\n");
      out.write("\tvar boardNo = target.id;\r\n");
      out.write("\tlocation.href = \"");
      out.print(request.getContextPath() );
      out.write("/schedule/selectOne?scheduleNo=\"+boardNo;\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("$(\"#scroll-box div\").each(function(idx, item){\r\n");
      out.write("\t$(item).click(function(){\r\n");
      out.write("\t\tvar time = $(this).attr(\"id\");\r\n");
      out.write("\t\tinsertFrm.time.value = time;\r\n");
      out.write("\t\tinsertFrm.submit();\r\n");
      out.write("\t});\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
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

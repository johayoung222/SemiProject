/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.35
 * Generated at: 2019-01-11 07:25:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.schedule;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kh.schedule.model.vo.*;
import com.kh.member.model.vo.*;

public final class scheduleInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1547191445409L));
    _jspx_dependants.put("/WEB-INF/views/common/side.jsp", Long.valueOf(1547123415564L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("com.kh.schedule.model.vo");
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
      out.write("<body>\r\n");
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
      out.write("        }\r\n");
      out.write("    })\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("};\r\n");
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
      out.write("\t<div id=\"myDiv\">\r\n");
      out.write("\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write('\r');
      out.write('\n');

	Schedule s = (Schedule)request.getAttribute("schedule");

      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/scheduleInfo.css\" />\r\n");
      out.write("<div id=\"scheduleInfo-container\">\r\n");
      out.write("\t<form class=\"insertFrm\" name=\"insertform\"\r\n");
      out.write("\t\t\taction=\"");
      out.print(request.getContextPath());
      out.write("/schedule/insertScheduleEnd\" \r\n");
      out.write("\t\t\tmethod=\"post\"\r\n");
      out.write("\t\t\tenctype=\"multipart/form-data\">\r\n");
      out.write("    <div id=\"inner-container\">\r\n");
      out.write("        <label for=\"title\">스케줄 제목</label>\r\n");
      out.write("        <input type=\"text\" id=\"title\" value=\"");
      out.print(s.getScheduleTitle() );
      out.write("\">\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"func\">\r\n");
      out.write("            <label for=\"dday\">D-day</label>\r\n");
      out.write("            <input type=\"checkbox\" name=\"dday\" id=\"dday\">\r\n");
      out.write("            <label for=\"scheduleStartDay\">일시</label>\r\n");
      out.write("\t\t\t\t<input type=\"date\" name=\"scheduleStartDay\" id=\"scheduleStartDay\"\r\n");
      out.write("\t\t\t\t\tdata-placeholder=\"스케줄 시작날을 설정하세요.\" required aria-required=\"true\">\r\n");
      out.write("\t\t\t\t&nbsp; - &nbsp;\r\n");
      out.write("\t\t\t\t<input type=\"date\" name=\"scheduleEndDay\" id=\"scheduleEndDay\"\r\n");
      out.write("\t\t\t\t\tdata-placeholder=\"스케줄 끝날을 설정하세요.\" required aria-required=\"true\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<input type=\"checkbox\" id=\"scheduleRepeatCheck\" name=\"scheduleRepeatCheck\" />\r\n");
      out.write("\t\t\t\t<label for=\"scheduleRepeatCheck\">스케줄 반복여부 설정</label>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"content\">\r\n");
      out.write("            <label for=\"content\">스케줄 내용</label>\r\n");
      out.write("            <textarea name=\"content\" id=\"content\" cols=\"70\" rows=\"30\">");
      out.print(s.getScheduleContent() );
      out.write("</textarea>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"addfile\">\r\n");
      out.write("            <label for=\"up_file\">파일</label>\r\n");
      out.write("\t\t\t\t<input type=\"file\" name=\"up_file\" placeholder=\"이미지/파일선택\" id=\"file\">\r\n");
      out.write("            <div class=\"filelist\">\r\n");
      out.write("            \t<span>");
      out.print(s.getScheduleOriginalfilename() );
      out.write("</span>\r\n");
      out.write("            \t<img src=\"");
      out.print(request.getContextPath() );
      out.write("/upload/schedule/");
      out.print(s.getScheduleRenamefilename() );
      out.write("\" width=\"20px\" height=\"20px\"/>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    </form>\r\n");
      out.write("</div>\r\n");
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

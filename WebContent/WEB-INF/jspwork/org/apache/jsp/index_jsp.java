/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.35
 * Generated at: 2019-01-14 12:13:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import com.kh.member.model.vo.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1547394663640L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("com.kh.member.model.vo");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
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
      out.write("    \r\n");
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
      out.write(" <link href=\"https://fonts.googleapis.com/css?family=Black+Han+Sans\" rel=\"stylesheet\">\r\n");
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
      out.write("    <div id=\"pic\">\r\n");
      out.write("    \t<img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/day.png\" width=\"50px\" height=\"50px\" >\r\n");
      out.write("    \t<img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/month.png\" width=\"50px\" height=\"50px\" \r\n");
      out.write("    \tclass=\"picture\">\r\n");
      out.write("    \t<img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/year.png\" width=\"50px\" height=\"50px\">\r\n");
      out.write("    </div>\r\n");
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

	int popupbool;
	List<String> popup = null;
	boolean checkrequest = false;
	if(memberLoggedIn == null) {
		popupbool = 0;
		popup = null;
	} else {
		try {
			popup = (List)request.getAttribute("popup");
			System.out.println("111111111111111111");
			System.out.println("뜨냐?" + popup);
			popupbool = (int)request.getAttribute("popupbool");	
			System.out.println("2222222222222222222");
			
			/* 친구요청을 받았는지에 대한 여부조사 */
			for(int i = 0;i < popup.size();i++) {
				System.out.println("popup.get("+i+")확인 : "+popup.get(i));
					checkrequest = true;
			}
			System.out.println("333333333333333333");
			System.out.println("popupsize : "+popup.size());
			String[] popupArr = popup.toArray(new String[popup.size()]);
			for(int i = 0;i < popupArr.length;i++) {
				System.out.println(popupArr[i]);
			}
		} catch(NullPointerException e) {
			popupbool = 0;
		}
	}
	

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/login.css\">\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css?family=Alfa+Slab+One%7CStaatliches%7CNoto+Sans+KR%7CAbril+Fatface\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css?family=Nanum+Pen+Script\" rel=\"stylesheet\">\r\n");
      out.write(" <link href=\"https://fonts.googleapis.com/css?family=Black+Han+Sans\" rel=\"stylesheet\">\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/js/jquery-3.3.1.js\"></script>\r\n");
      out.write("<title>7 Scheduler</title>\r\n");
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write("#back {\r\n");
      out.write("float: right;\r\n");
      out.write("margin-right: 450px;\r\n");
      out.write("}\r\n");
      out.write("#login_box{\r\n");
      out.write("\tmargin-left: 60%;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("function back(){\r\n");
      out.write("\tbackFrm.submit();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function CheckLogin(){\r\n");
      out.write("\tif($(\"#memberId\").val().trim().length == 0){\r\n");
      out.write("\t\talert(\"아이디를 입력하세요.\");\r\n");
      out.write("\t\t$(\"#memberId\").focus();\r\n");
      out.write("\t\treturn false;//폼 전송방지\r\n");
      out.write("\t}\r\n");
      out.write("\tif($(\"#memberPwd\").val().trim().length == 0){\r\n");
      out.write("\t\talert(\"비밀번호를 입력하세요.\");\r\n");
      out.write("\t\t$(\"#memberPwd\").focus();\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\t\r\n");
      out.write("\treturn true;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function searchIdPwd(){     \r\n");
      out.write("\t   var url = \"");
      out.print(request.getContextPath());
      out.write("/member/searchIdPwd\";\r\n");
      out.write("\t   var title = \"searchIdPwd\";\r\n");
      out.write("\t   var status = \"left=300px, top=100px, width=800px, height=300px\";\r\n");
      out.write("\t   \r\n");
      out.write("\t  open(url, title, status);\r\n");
      out.write("   \r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write(" \r\n");
      out.write(" <div class=\"content\">\r\n");
      out.write("   <section>\r\n");
      out.write("   \r\n");
      out.write("     <div id=\"slideshow\">\r\n");
      out.write("       <div>\r\n");
      out.write("         <img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/flower1.PNG\" class=\"conimg\" id=\"conimg1\">\r\n");
      out.write("       </div>\r\n");
      out.write("       <div>\r\n");
      out.write("          <img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/flower2.PNG\" class=\"conimg\" id=\"conimg2\">\r\n");
      out.write("       </div>\r\n");
      out.write("       <div>\r\n");
      out.write("              <img src=\"");
      out.print(request.getContextPath() );
      out.write("/images/flower3.PNG\" class=\"conimg\" id=\"conimg3\">\r\n");
      out.write("       </div>\r\n");
      out.write("     </div>\r\n");
      out.write("     ");
if(memberLoggedIn == null){ 
      out.write("\r\n");
      out.write("     <!-- login form -->\r\n");
      out.write("     <form class=\"loginFrm\" name=\"loginform\" action=\"");
      out.print(request.getContextPath());
      out.write("/member/login\" method=\"post\" onsubmit=\"return CheckLogin();\">\r\n");
      out.write("       <div class=\"login_box\">\r\n");
      out.write("         <div class=\"input_login\">\r\n");
      out.write("           <input type=\"text\" name=\"memberId\" id=\"memberId\" placeholder=\"아이디를 입력하세요.\" >\r\n");
      out.write("         </div>\r\n");
      out.write("         <div class=\"input_login\">\r\n");
      out.write("           <input type=\"password\" name=\"memberPwd\" id=\"memberPwd\" placeholder=\"비밀번호를 입력하세요\">\r\n");
      out.write("         </div>\r\n");
      out.write("         <br>\r\n");
      out.write("         <br>\r\n");
      out.write("         <div class=\"login\">\r\n");
      out.write("         \r\n");
      out.write("         <!-- login 유효성 검사 -->\r\n");
      out.write("           <input type=\"submit\" value=\"로그인\">\r\n");
      out.write("         </div>\r\n");
      out.write("         <hr>\r\n");
      out.write("         <span>또는</span>\r\n");
      out.write("         <div class=\"sns\">\r\n");
      out.write("          <input type=\"button\" value=\"FaceBook으로 로그인\">\r\n");
      out.write("         </div>\r\n");
      out.write("         <span id=\"search_\" onclick=\"searchIdPwd();\">비밀번호를 잊으셨나요?</span>\r\n");
      out.write("       </div>\r\n");
      out.write("       <div class=\"signup_box\">\r\n");
      out.write("         <span>계정이 없으신가요?<a href=\"");
      out.print(request.getContextPath() );
      out.write("/member/moveEnroll\">회원가입</a></span>\r\n");
      out.write("       </div>\r\n");
      out.write("     </form>\r\n");
      out.write("     ");
 }else{ 
      out.write("\r\n");
      out.write("\r\n");
      out.write("     <div class=\"scheduler_box\" id=\"scheduler_box\">\r\n");
      out.write("\r\n");
      out.write("     \t");
 if(checkrequest == true) { 
      out.write("\r\n");
      out.write("     \t\r\n");
      out.write("     \t<form action=\"");
      out.print(request.getContextPath());
      out.write("/member/checkFriend\"\r\n");
      out.write("      \tmethod=\"post\"\r\n");
      out.write("      \tname=\"checkFriendFrm\">\r\n");
      out.write("      \t");
      out.write("\r\n");
      out.write("      \t</form>\r\n");
      out.write("     \t<script>\r\n");
      out.write("     \tfunction popupOpen(){\r\n");
      out.write("            //팝업창을 target으로 폼전송\r\n");
      out.write("            var target = \"checkFriend\";\r\n");
      out.write("            //첫번째 인자 url은 생략, form의 action값이 이를 대신한다.\r\n");
      out.write("            var popup = open(\"\", target, \"left=400px, top=300px, height=200px, width=500px , resizable=no, scrollbars=no, status=no;\");\r\n");
      out.write("            checkFriendFrm.target = target;\r\n");
      out.write("            checkFriendFrm.submit();\r\n");
      out.write("     \t}\r\n");
      out.write("\t\tpopupOpen();\r\n");
      out.write("     \t</script>\r\n");
      out.write("\t\t\r\n");
      out.write("    \t");
 } 
      out.write("\r\n");
      out.write("     <script>\r\n");
      out.write("     var memberId = \"");
      out.print(memberLoggedIn.getMemberId());
      out.write("\";\r\n");
      out.write("     \t$.ajax({\r\n");
      out.write("\t\t\turl: \"");
      out.print(request.getContextPath());
      out.write("/schedule/daySchedule.do\",\r\n");
      out.write("\t\t\ttype: \"get\",\r\n");
      out.write("\t\t\tdataType: \"json\",\r\n");
      out.write("\t\t\tdata: \"memberId=\"+memberId,\r\n");
      out.write("\t\t\tsuccess: function (data) {\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tfor(var schedule in data){\r\n");
      out.write("\t\t\t\t\tconsole.log(data); //data는 이미 javascript배열객체\r\n");
      out.write("\t\t\t\t\t//json <----> javascript\r\n");
      out.write("\t\t\t\t\t//\t   <--- JSON.stringgify()\r\n");
      out.write("\t\t\t\t\t//\t  \t---> JSON.parse()\r\n");
      out.write("\t\t\t\t\tvar table = $(\"<table id='indexTable' ></table>\");\r\n");
      out.write("\t\t\t\t\tvar html = \"<tr><th>Title:</th></tr>\";\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tfor(var i in data){\r\n");
      out.write("\t\t\t\t\t\tvar user = data[i];\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\thtml += \"<tr><td>\"+user.scheduleTitle+\"</td></tr>\";\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\ttable.append(html);\r\n");
      out.write("\t\t\t\t\tconsole.log(html);\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t$(\"#scheduler_box\").html(table);\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t}\r\n");
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
      out.write("     </script>\r\n");
      out.write("     </div>\r\n");
      out.write("     <div id=\"button\">\r\n");
      out.write("     \t<button id=\"back\" onclick=\"back();\">스케줄러 입장!</button>\r\n");
      out.write("     \t<form action=\"");
      out.print(request.getContextPath() );
      out.write("/member/mainSchedule\" name=\"backFrm\" method=\"post\">\r\n");
      out.write("     \t\t<input type=\"hidden\" name=\"memberId\" value=\"");
      out.print(memberLoggedIn.getMemberId() );
      out.write("\"/>\r\n");
      out.write("     \t\t");
 if(request.getSession().getAttribute("exPwd") != null){
     			String exPwd = (String)request.getSession().getAttribute("exPwd");
      out.write("\r\n");
      out.write("     \t\t<input type=\"hidden\" name=\"memberPwd\" value=\"");
      out.print(exPwd );
      out.write("\"/>\r\n");
      out.write("     \t\t");
} 
      out.write("\r\n");
      out.write("     \t</form>\r\n");
      out.write("     </div>\r\n");
      out.write("     ");
} 
      out.write("\r\n");
      out.write("     \r\n");
      out.write("   </section>\r\n");
      out.write(" </div>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("$(\"#slideshow > div:gt(0)\").hide();\r\n");
      out.write("setInterval(function(){\r\n");
      out.write(" $(\"#slideshow > div:first\").fadeOut(1000).next().fadeIn(1000).end().appendTo(\"#slideshow\");\r\n");
      out.write("} , 3000);\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
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

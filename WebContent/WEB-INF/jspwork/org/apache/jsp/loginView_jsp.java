/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.35
 * Generated at: 2019-01-03 11:12:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class loginView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/header.jsp", Long.valueOf(1546507002433L));
  }

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

      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');

	//세션을 가져와서 로그인 상태일 경우 스케줄을 뿌릴 수 있는 리스트 반환


      out.write("\r\n");
      out.write("    \r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css?family=Alfa+Slab+One|Staatliches\" rel=\"stylesheet\">\r\n");
      out.write("    <title>Semiproject</title>\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/main.css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("  <nav>\r\n");
      out.write("    <div class=\"logo\">\r\n");
      out.write("      <img src=\"images/p3.jpg\" alt=\"\"width=\"30px\" height=\"30px\"> &nbsp;7 Scheduler </div>\r\n");
      out.write("    <div class=\"nav-main\">\r\n");
      out.write("        <ul>  \r\n");
      out.write("        <li id=\"login\">Login</li>\r\n");
      out.write("      </ul>\r\n");
      out.write("      <div class=\"clear\"></div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </nav>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <style media=\"screen\">\r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("    * {\r\n");
      out.write("    box-sizing: border-box;\r\n");
      out.write("    -moz-box-sizing: border-box;\r\n");
      out.write("    -webkit-box-sizing: border-box;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    body {\r\n");
      out.write("    padding: 0;\r\n");
      out.write("    margin: 0;\r\n");
      out.write("    font-family: 'Open Sans', Arial, sans-serif;\r\n");
      out.write("    color: #333;\r\n");
      out.write("    \r\n");
      out.write("    background-color: rgb(248, 248, 248);\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    p {\r\n");
      out.write("    line-height: 1.75;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    section {\r\n");
      out.write("    padding: 40px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .content {\r\n");
      out.write("    margin-top: 80px;\r\n");
      out.write("    background-color: rgb(248, 248, 248);\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .contained {\r\n");
      out.write("  width: 728px;\r\n");
      out.write("  margin: 0 auto;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    @media (max-width: 41em) {\r\n");
      out.write("    .contained {\r\n");
      out.write("      width: 100%;\r\n");
      out.write("    }\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .clear {\r\n");
      out.write("    clear: both;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    nav {\r\n");
      out.write("    position: fixed;\r\n");
      out.write("    top: 0;\r\n");
      out.write("    left: 0;\r\n");
      out.write("    width: 100%;\r\n");
      out.write("    background-color: rgb(75, 0, 126);\r\n");
      out.write("    color:#fff;\r\n");
      out.write("    z-index: 1000;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    nav .nav-main {\r\n");
      out.write("    padding: 5px 20px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    nav .nav-actions {\r\n");
      out.write("      height: 45px;\r\n");
      out.write("      line-height: 40px;\r\n");
      out.write("      padding: 0 20px;\r\n");
      out.write("      background-color: rgb(36, 175, 129);\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    nav .logo {\r\n");
      out.write("    float: left;\r\n");
      out.write("    line-height: 50px;\r\n");
      out.write("    font-size: 1.5em;\r\n");
      out.write("    \r\n");
      out.write("    font-family: 'Staatliches', cursive;\r\n");
      out.write("    padding: 5px;\r\n");
      out.write("    margin: 0 auto;\r\n");
      out.write("   \r\n");
      out.write("    \r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    nav ul {\r\n");
      out.write("    float: right;\r\n");
      out.write("    list-style: none;\r\n");
      out.write("    margin: 0;\r\n");
      out.write("    padding: 0;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    nav ul li {\r\n");
      out.write("    display: inline-block;\r\n");
      out.write("    line-height: 35px;\r\n");
      out.write("    padding: 5px, 10px;\r\n");
      out.write("    font-family: 'Alfa Slab One', cursive;\r\n");
      out.write("    font-size: 30px;\r\n");
      out.write("    transform: translateY(10px);\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    nav ul li:hover{\r\n");
      out.write("      color: lightgray;\r\n");
      out.write("      border: black;\r\n");
      out.write("      \r\n");
      out.write("\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    section>img{\r\n");
      out.write("      z-index: -100;\r\n");
      out.write("      padding: 50px;\r\n");
      out.write("\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write(" /* footer */\r\n");
      out.write("    footer {\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            height: 100px;\r\n");
      out.write("            background-color: #000000da;\r\n");
      out.write("            color: white;\r\n");
      out.write("            font-size: 20px;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            line-height: 50px;\r\n");
      out.write("            padding: 0 ;\r\n");
      out.write("            margin: 0 auto;\r\n");
      out.write("            position: fixed;\r\n");
      out.write("            transform: translateY(200px);\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("/* login */\r\n");
      out.write(".login_box { width:600px; height:500px; padding: 50px 30px 30px 50px; margin: 0 auto; background-color:rgba(255, 255, 255, 0.993); opacity: 0.8; \r\n");
      out.write("\tborder-radius:5px; border: 1px solid rgb(248, 248, 248);; transform: translateX();}\r\n");
      out.write(".login_box .input_login { border-bottom: 2px solid #c4c5c4; padding: 20px 0 9px 0; font:bolder;}\r\n");
      out.write(".login_box .input_login input { width: 100%; color: #828180; font-size: 15px; border:none; font-family: 'Noto Sans KR', sans-seri;}\r\n");
      out.write("\r\n");
      out.write(".login_box .check { color: #000; font-size: 14px; padding: 9px 0 15px 0; font-family: 'Noto Sans KR', sans-seri;}\r\n");
      out.write("\r\n");
      out.write(".login_box  .login input { width:100%; height:55px; background-color:rgb(30, 6, 75); color:rgb(248, 248, 248); font-size:16px; \r\n");
      out.write("          padding:17px 0 16px; border:0; cursor:pointer; font-family: 'Noto Sans KR', sans-seri;}\r\n");
      out.write(".login_box span{font-family: 'Noto Sans KR', sans-seri;  font-size: 18px; padding: 0px 240px}\r\n");
      out.write(".login_box  .sns input {\r\n");
      out.write("  width:100%; height:55px; background-color:rgb(66, 103, 178); color:rgb(248, 248, 248); font-size:16px; \r\n");
      out.write("\t\t\t\t  padding:3px 17px 0 16px; border:0; cursor:pointer; font-family: 'Noto Sans KR', sans-seri; transform: translateY(20px)}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(".login_box .last { width:100%; margin-top:30px; border-top:1px solid #ebebeb; padding-top:20px;}\r\n");
      out.write(".login_box .last .join { float:left;}\r\n");
      out.write(".login_box .last .search { float:right;}\r\n");
      out.write(".login_box .last .join a { color:#00a6de;}\r\n");
      out.write(".login_box .last .search a { color:#626262;} \r\n");
      out.write(".login_box .last { width:100%; margin-top:10px; border-top:1px solid #ebebeb; padding-top:20px; font:bolder; font-size: 30px ;\t font-family: 'Abril Fatface', cursive;}\r\n");
      out.write(".login_box .last .join { float:left;}\r\n");
      out.write(".login_box .last .join a { color:rgb(14, 13, 13); border-radius: 20%; font:bolder;} \r\n");
      out.write(".login_box .last .join a:hover { color:rgb(183, 152, 224); border-radius: 20%; font:bolder;}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("    </style>\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/landing.css\" />\r\n");
      out.write("\r\n");
      out.write("  <div class=\"content\">\r\n");
      out.write("    <section>\r\n");
      out.write("        <span>Login</span>\r\n");
      out.write("        \r\n");
      out.write("    \r\n");
      out.write("        <form name=\"loginform\" action=\"mypage.html\" method=\"post\" onsubmit=\"return CheckLogin();\">\r\n");
      out.write("            <div class=\"login_box\">\r\n");
      out.write("              <div class=\"input_login\">\r\n");
      out.write("                <input type=\"text\" name=\"logckuid\" id=\"logckuid\" placeholder=\"아이디를 입력하세요\">\r\n");
      out.write("              </div>\r\n");
      out.write("              <div class=\"input_login\">\r\n");
      out.write("                <input type=\"password\" name=\"logckpwd\" id=\"logckpwd\" placeholder=\"비밀번호를 입력하세요\">\r\n");
      out.write("              </div>\r\n");
      out.write("              <div class=\"last\">\r\n");
      out.write("              <div class=\"join\"><a href=\"join.html\">☞ go to sign up</a></div>\r\n");
      out.write("              <br>\r\n");
      out.write("              <br>\r\n");
      out.write("              <div class=\"login\">\r\n");
      out.write("                <input type=\"submit\" value=\"LOGIN\">\r\n");
      out.write("              </div>\r\n");
      out.write("              \r\n");
      out.write("              <hr>\r\n");
      out.write("              <span>또는</span>\r\n");
      out.write("              \r\n");
      out.write("              <div class=\"sns\">\r\n");
      out.write("                  <input type=\"submit\" value=\"FaceBook login\" >\r\n");
      out.write("                </div>\r\n");
      out.write("          \r\n");
      out.write("              <br>\r\n");
      out.write("              <br>\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("              \r\n");
      out.write("    \r\n");
      out.write("                </div>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        </form>\r\n");
      out.write("   \r\n");
      out.write("      </div>\r\n");
      out.write("      \r\n");
      out.write("      \r\n");
      out.write("      <footer>\r\n");
      out.write("          <span>Copyrightⓡ windowSide Front Group: semiProject </span>\r\n");
      out.write("              </footer>\r\n");
      out.write("    </section>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  \r\n");
      out.write(" \r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("(function($) {\r\n");
      out.write("  $.fn.semisticky = function(options) {\r\n");
      out.write("  return this.each(function() {\r\n");
      out.write("    new SemiSticky($(this), options);\r\n");
      out.write("  });\r\n");
      out.write("  };\r\n");
      out.write("}(jQuery));\r\n");
      out.write("\r\n");
      out.write("var SemiSticky = function(element, options) {\r\n");
      out.write("  var _this = this;\r\n");
      out.write("  \r\n");
      out.write("  options = $.extend({\r\n");
      out.write("  offsetLimit: element.outerHeight(),\r\n");
      out.write("  scrollThreshold: 50,\r\n");
      out.write("  onScroll: function() {}\r\n");
      out.write("  }, options);\r\n");
      out.write("  \r\n");
      out.write("  this.element = element;\r\n");
      out.write("  this.state = 'fixed';\r\n");
      out.write("  this.currentOffsetAmount = 0;\r\n");
      out.write("  \r\n");
      out.write("  this.init = function() {\r\n");
      out.write("  var oldScrollTop = $(document).scrollTop();\r\n");
      out.write("  var thresholdCounter = 0;\r\n");
      out.write("  \r\n");
      out.write("  $(window).on('scroll.semisticky', function() {\r\n");
      out.write("    var newScrollTop = $(document).scrollTop();\r\n");
      out.write("    var delta = oldScrollTop - newScrollTop;\r\n");
      out.write("    thresholdCounter = Math.min(Math.max(thresholdCounter + delta, -options.scrollThreshold), options.scrollThreshold);\r\n");
      out.write("    var newOffset;\r\n");
      out.write("\r\n");
      out.write("    if (Math.abs(thresholdCounter) >= options.scrollThreshold || _this.state == 'scrolling') {\r\n");
      out.write("    if (delta < 0 && _this.state !== 'hidden') {\r\n");
      out.write("      \r\n");
      out.write("      if (_this.currentOffsetAmount > -options.offsetLimit) {\r\n");
      out.write("      _this.currentOffsetAmount = Math.max(_this.currentOffsetAmount + delta, -options.offsetLimit);\r\n");
      out.write("      _this.element.css('top', _this.currentOffsetAmount);\r\n");
      out.write("      _this.state = 'scrolling';\r\n");
      out.write("      } else {\r\n");
      out.write("      _this.state = 'hidden';\r\n");
      out.write("      thresholdCounter = 0;\r\n");
      out.write("      }\r\n");
      out.write("      \r\n");
      out.write("    } else if (delta > 0 && _this.state !== 'fixed') {\r\n");
      out.write("      \r\n");
      out.write("      if (_this.currentOffsetAmount < 0) {\r\n");
      out.write("      _this.currentOffsetAmount = Math.min(_this.currentOffsetAmount + delta, 0);\r\n");
      out.write("      _this.element.css('top', _this.currentOffsetAmount);\r\n");
      out.write("      _this.state = 'scrolling';\r\n");
      out.write("      } else {\r\n");
      out.write("      _this.state = 'fixed';\r\n");
      out.write("      thresholdCounter = 0;\r\n");
      out.write("      }\r\n");
      out.write("      \r\n");
      out.write("    }\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    options.onScroll.call(_this, delta);\r\n");
      out.write("    \r\n");
      out.write("    oldScrollTop = newScrollTop;\r\n");
      out.write("  });\r\n");
      out.write("  };\r\n");
      out.write("  \r\n");
      out.write("  this.die = function() {\r\n");
      out.write("  $(window).off('scroll.semisticky');\r\n");
      out.write("  };\r\n");
      out.write("  \r\n");
      out.write("  this.init();\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("  \r\n");
      out.write("  <script>\r\n");
      out.write("    $('nav').semisticky({\r\n");
      out.write("      offsetLimit: $('.nav-actions').outerHeight(),\r\n");
      out.write("    })\r\n");
      out.write("  </script>\r\n");
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
package com.kh.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kh.member.model.vo.Member;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(servletNames = { "MemberViewServlet" })
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest)request).getSession();
		Member memberLoggedIn = (Member)session.getAttribute("memberLoggedIn");
		
		String reqmemberId = request.getParameter("memberId");
		

		
		
	

         if( memberLoggedIn == null || reqmemberId == null ||  !(reqmemberId.equals(memberLoggedIn.getMemberId()) || 
        		 "admin".equals(memberLoggedIn.getMemberId()))) {
		
        	 request.setAttribute("msg","잘못된경로로 접근하셨습니다.");
        	 request.setAttribute("loc","/");
        	 request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
        	 
        	 
        	 return;
         
         }else{
        	 
			
	
		
			chain.doFilter(request, response);
	
         }
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

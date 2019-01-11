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

import com.kh.common.wrapper.EncryptWrapper;







/**
 * Servlet Filter implementation class EncrypFilter
 */
@WebFilter({"/member/memberEnroll","/member/login","/member/updatePasswordEnd"})
public class EncrypFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncrypFilter() {
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
		
		HttpServletRequest req = (HttpServletRequest) request;

		String exPwd = req.getParameter("memberPwd");
		//암호화래퍼객체 생성
		EncryptWrapper encRequest = new EncryptWrapper(req);
		System.out.println("EncryptFilter처리 완료!");

		encRequest.setAttribute("exPwd", exPwd);
		
		chain.doFilter(encRequest, response);
		//ServletRequest - HttpServletRequest - HttpServletRequestWrapper - EncryptWrapper
		System.out.println("EncryptFilter Chain.doFilter 처리 완료!");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

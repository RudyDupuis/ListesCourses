package fr.eni.gestionListesCourses.servlets;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


@WebFilter(dispatcherTypes = {
		DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE, DispatcherType.ERROR,
	 }, urlPatterns={"/mes-listes", "/mon-panier", "/cree-liste"})
public class CGUFilter implements Filter {

	public void destroy() {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hsrqt = (HttpServletRequest) request;
		Cookie[] cookies = hsrqt.getCookies();

		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("CGU")) {
					chain.doFilter(request, response);
				}
			}
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/validationCGU");
			rd.forward(request, response);
		}

		
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}

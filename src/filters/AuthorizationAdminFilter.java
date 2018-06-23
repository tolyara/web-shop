package filters;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Account;

/**
 * Servlet Filter implementation class AuthorizationFilter
 */
public class AuthorizationAdminFilter implements Filter {

	private static final String ERROR_ACCESS = "/ErrorAccess.jsp";

	@Override
	public void destroy() {

	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		Account loggedAccount = (Account) req.getSession().getAttribute("LOGGED_ACCOUNT");
		String accountRole = (String) req.getSession().getAttribute("ACCOUNT_ROLE");
		/*
		 * если аккаунт пустой, или не является пользователем
		 */
		if (loggedAccount == null || !accountRole.equals("admin")) {
			resp.sendRedirect(String.format("%s%s", req.getContextPath(), ERROR_ACCESS));
		} else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// Get init parameter
		String testParam = fConfig.getInitParameter("test-param");
		// Print the init parameter
		System.out.println("Test Param: " + testParam);
	}
}

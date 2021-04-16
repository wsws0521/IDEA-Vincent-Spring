package com.tortuousroad.site.web.site.interceptor;

import com.tortuousroad.site.web.base.objects.WebUser;
import com.tortuousroad.site.web.utils.CookieUtil;
import com.tortuousroad.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
	@Autowired
	private UserService userService;

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception ex)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object obj, ModelAndView modelAndView)
			throws Exception {
	}


	@Override
	public boolean preHandle(HttpServletRequest request,
							 HttpServletResponse response, Object handler) throws Exception {
		WebUser webUser = CookieUtil.getLoginUser(request);
		if (null == webUser) {
			String basePath = request.getScheme() + "//:" + request.getServerName() + ":" + request.getServerPort();
			response.sendRedirect(basePath + "/login");
			return false;
		}
		return true;
	}

}
package com.zyf.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Configuration
public class LogHandlerInterceptor implements HandlerInterceptor {
	protected static Log LOG = LogFactory.getLog(LogHandlerInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// 开始时间
		request.setAttribute("startTime", System.currentTimeMillis());
		System.out
				.println(">>>MyInterceptor1>>>>>>> Controller方法调用之前 request:");

		return true;// 只有返回true才会继续向下执行，返回false取消当前请求
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		accessLog(request, response.getStatus());
		System.out.println("access.log（Controller方法调用之后）response:" + response);
	}

	/**
	 * 记录日志
	 * 
	 * @param servletRequest
	 * @param status
	 */
	public void accessLog(HttpServletRequest servletRequest, int status) {
		long timestamp = (Long) servletRequest.getAttribute("startTime");
		long cost = System.currentTimeMillis() - timestamp;
		String passportId = servletRequest.getHeader("passportId");
		// 格式：REQUIRE_TIME|SSOID|IP|METHOD|PATH|STATUS|COST_TIME
		// 请求时间戳|ssoid|请求ip|get/post|请求路径|状态|耗时ms
		LOG.info((passportId != null ? passportId : "")
				+ "|"
				+ getIpAddress(servletRequest)
				+ "|"
				+ servletRequest.getMethod()
				+ "|"
				+ servletRequest.getRequestURI()
				+ (servletRequest.getMethod().equals("GET") ? "?"
						+ servletRequest.getQueryString() : "") + "|" + status
				+ "|" + cost);
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out
				.println(">>>MyInterceptor1>>>>>>>trace.log 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
	}

	/**
	 * 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址,
	 * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，究竟哪个才是真正的用户端的真实IP呢？
	 * 答案是取X-Forwarded-For中第一个非unknown的有效IP字符串。 如：X-Forwarded-For：192.168.1.110,
	 * 192.168.1.120, 192.168.1.130, 192.168.1.100 用户真实IP为： 192.168.1.110
	 * 
	 * @param request
	 * @return
	 */
	private static String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}

/**
 * 
 */
package com.imooc.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description 自定义拦截器
 * @author Mr. Zhang
 * @date 2019-03-26 15:58
 * @website https://www.zhangguimin.cn
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {

	/**
	 * 请求调用前执行，如果为false则不执行postHandle
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle");
		
		System.out.println(((HandlerMethod)handler).getBean().getClass().getName());
		System.out.println(((HandlerMethod)handler).getMethod().getName());
		
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}

	/**
	 * 请求方法执行时执行
	 * @param request
	 * @param response
	 * @param handler
	 * @param modelAndView
	 * @throws Exception
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle");
		Long start = (Long) request.getAttribute("startTime");
		System.out.println("time interceptor 耗时:"+ (System.currentTimeMillis() - start));

	}

	/**
	 * 请求方法执行完后执行，不管preHandle是否为true和false
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @throws Exception
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion");
		Long start = (Long) request.getAttribute("startTime");
		System.out.println("time interceptor 耗时:"+ (System.currentTimeMillis() - start));
		System.out.println("ex is "+ex);

	}

}

package pms.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
/*2019.6.16
*@Author 16202133朱天翔
*拦截器
*
*/
public class AuthInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//拿到session 继续
		HttpSession session = request.getSession();
		if( session.getAttribute("manager")==null&&
				session.getAttribute("owner")==null&&
				session.getAttribute("security")==null) {
			response.sendRedirect("/");//点任何链接 无用 如css
			return false;
		}else
			return true;
	}

}
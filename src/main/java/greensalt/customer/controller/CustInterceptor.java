package greensalt.customer.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class CustInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();

        String requestURL = request.getRequestURI();
        session.setAttribute("toURL", requestURL);

        if(session.getAttribute("c_id") == null) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}




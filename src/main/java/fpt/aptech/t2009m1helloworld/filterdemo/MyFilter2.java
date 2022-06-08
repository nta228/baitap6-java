package fpt.aptech.t2009m1helloworld.filterdemo;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFilter2 implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Hi, filter2.");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        System.out.println("Lấy thông tin từ trong filter trước đưa vào.");
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        System.out.println("Đẩy");
        chain.doFilter(request, response);
    }
}

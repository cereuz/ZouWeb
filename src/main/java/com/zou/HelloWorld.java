package com.zou;

/**
 * @author : zw
 * @email : zsky@live.com,
 * @date : 2019/4/11 16:50.
 * @motto : To be, or not to be.
 */
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloWorld extends HttpServlet {
    private String message;

    @Override
    public void init() throws ServletException {
        message = "Hello world, This message is from servlet!";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应内容类型
        resp.setContentType("text/html");

        //设置逻辑实现
        PrintWriter out = resp.getWriter();
        out.println("<h1>" + message + "</h1>");
        out.println("<h2>" + message + "</h2>");
        out.println("<h3>" + message + "</h3>");
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}

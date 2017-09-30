package servlet;

import bean.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateServlet extends HttpServlet {
    public static List<User> ipList;

    @Override
    public void init() throws ServletException {
        super.init();
        ipList = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ip = req.getParameter("ip");
        String port = req.getParameter("port");
        String name = req.getParameter("name");
        User u = new User(ip,port,name);
        System.out.println(ip + "  " + port + "  " + name);
        if (ip!=null) {
            ipList.add(u);
        }
        resp.getWriter().println("ok");
    }
}

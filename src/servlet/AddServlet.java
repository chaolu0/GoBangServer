package servlet;

import bean.HttpResBean;
import bean.User;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> list = CreateServlet.ipList;
        if (list == null||list.size() == 0){
            HttpResBean httpResBean = new HttpResBean(0,new User());
            resp.getWriter().println(new Gson().toJson(httpResBean));
//            resp.getWriter().println(0 + "#" + "");
        }else{
            HttpResBean httpResBean = new HttpResBean(1,list.get(list.size()-1));
            resp.getWriter().println(new Gson().toJson(httpResBean));
//            resp.getWriter().println(1 + "#" +list.get(list.size()-1));
            list.remove(list.size()-1);
        }

    }
}

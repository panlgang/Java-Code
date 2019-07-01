import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ContextDemo extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        ServletContext context = super.getServletContext();
        Integer count = (Integer) context.getAttribute("count");
        if(count == null){
           count = 1;
        }else{
            count++;
        }
        context.setAttribute("count",count);
        response.getWriter().print("<p>");
        response.getWriter().print("本站目前访问人数：" + count);
        response.getWriter().print("</p>");
        response.getWriter().print(context.getContext("/form")==context);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

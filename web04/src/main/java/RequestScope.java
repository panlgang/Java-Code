import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;


public class RequestScope extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("a","a");
        request.setAttribute("b","b");
        request.setAttribute("c","c");
        request.setAttribute("d","d");
        Enumeration<String> en = request.getAttributeNames();
        while(en.hasMoreElements()){
            String s = en.nextElement();
            System.out.println(request.getAttribute(s));
        }
        //response.setStatus(302);
        //response.setHeader("location","/login.html");
        response.setHeader("refresh","1");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

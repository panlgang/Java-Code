import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

public class TestServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        writer.write("<h1>");
        writer.write(request.getMethod());
        writer.write("</h1>");

        writer.write("<hr>");

        writer.write("<h1>");
        writer.write(request.getProtocol());
        writer.write("</h1>");

        writer.write("<hr>");

        writer.write("<h1>");
        Map<String, String[]> map = request.getParameterMap();
        Set<String> set = map.keySet();
        for(String str : set){
            writer.write(str + map.get(str)[0]);
        }
        writer.write("<br>");
        writer.write(request.getContentLength());
        writer.write("</h1>");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

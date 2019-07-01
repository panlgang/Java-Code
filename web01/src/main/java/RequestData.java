import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;


public class RequestData extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        Map<String,String[]> map = request.getParameterMap();
        Iterator<String> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            String name = iterator.next();
            String[] arr = map.get(name);
            if(arr != null){
                writer.write(name + ": 元素个数:" + arr.length + "</br>");
                for(String value : arr){
                    writer.write(value + "</br>");
                }
            }
        }



    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);


    }
}

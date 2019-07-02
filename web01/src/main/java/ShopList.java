import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;


public class ShopList extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        Map<String,Integer> car = (Map<String, Integer>) session.getAttribute("shoppCar");

        if(car != null && car.size() >0){
            writer.print("<h3> 你买的书籍：</h3>");
            for(Map.Entry<String,Integer> entry : car.entrySet()){
                writer.print(entry.getKey() + "==" + entry.getValue() + "</br>");
            }
        }else{
            writer.write("购物车空空如也~~~" + "</br>");
        }
        writer.write("<a href='book.html'>继续购买</a>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

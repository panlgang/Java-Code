import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;


public class ShoppingCarServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        Map<String,Integer> car = (Map<String,Integer>) session.getAttribute("shoppCar");
        if(car == null){
            car = new LinkedHashMap<String, Integer>();
        }
        String[] books = request.getParameterValues("book");
        if(books != null && books.length > 0){
            for(String book : books){
                Integer num = car.get(book);
                if(num != null){
                    car.put(book,num + 1);
                }else{
                    car.put(book,1);
                }
            }
        }
        session.setAttribute("shoppCar",car);
        response.sendRedirect("/ShopList");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

}

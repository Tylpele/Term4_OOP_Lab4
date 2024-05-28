package controller;
import model.Laptop;
import model.Laptops;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/addition"})
public class AdditionServlet extends HttpServlet
{
    private Laptops laptops = new Laptops();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String price = req.getParameter("price");
        String display = req.getParameter("display");
        String model = req.getParameter("model");
        String processor = req.getParameter("processor");
        String storage_drive = req.getParameter("storage_drive");
        String RAM = req.getParameter("RAM");

        Laptop newLaptop = new Laptop(price, display, model, processor,storage_drive, RAM);

        laptops.addLaptop(newLaptop);


        //обновление страницы для отображения новых данных
        updatePage(req, resp);
        }



    private void updatePage(ServletRequest request, ServletResponse response) throws ServletException, IOException {

        // Установка заголовков для предотвращения кеширования
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        httpResponse.setHeader("Pragma", "no-cache");
        httpResponse.setDateHeader("Expires", 0);

        RequestDispatcher view = request.getRequestDispatcher("view/index.html");
        view.forward(request, response);
    }


    }

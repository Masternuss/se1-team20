package com.example.Parkhaus;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet("/ParkhausServlet")
public class ParkhausServlet extends HttpServlet {

    final protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");

        String[] requestParamString = request.getQueryString().split("=");
        String command = requestParamString[0];
        String param = requestParamString[1];

        //calculate total revenue for all cars
        if ("cmd".equals(command) && "total_revenue".equals(param)){
            Double totalRevenue = getTotalRevenue();
            response.setContentType("text/html");
            final PrintWriter OUT = response.getWriter();
            OUT.println(totalRevenue + ",-");
            System.out.println("total_revenue = €" + totalRevenue);

            //calculate average revenue per car
        } else if ("cmd".equals(command) && "average_revenue".equals(param)) {
            Double averageRevenue = getAverageRevenue();
            response.setContentType("text/html");
            final PrintWriter OUT = response.getWriter();
            OUT.println(averageRevenue + ",-");
            System.out.println("average_revenue = €" + averageRevenue);

            //count all cars that leaves the parkhaus
        } else if ("cmd".equals(command) && "total_cars".equals(param)) {
            Long totalCars = getTotalCars();
            response.setContentType("text/html");
            final PrintWriter OUT = response.getWriter();
            OUT.println(totalCars);
            System.out.println("total_cars = " + totalCars);

            //prints the bill when a car leaves
        } else if ("cmd".equals(command) && "get_bill".equals(param)){
            Double bill = getBill();
            response.setContentType("text/html");
            final PrintWriter OUT = response.getWriter();
            OUT.println(bill + ",-");
            System.out.println("your bill = €" + bill);

            //command doesnt match with the specified commands above
        } else {
            System.out.println("invalid Command: " + request.getQueryString());
        }
    }


    final protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        //getting the String containing of: event, nr, begin, duration, price, ticket, color, slot
        String body = getBody(request);
        System.out.println(body);

        String[] params =           body.split(",");
        String event =              params[0];

        //block variables for ServletContexts of buttons, so we can do the math with them
        Double totalRevenue =       getTotalRevenue();
        Double averageRevenue =     getAverageRevenue();
        Long totalCars =            getTotalCars();

        StringBuilder priceString = new StringBuilder();
        Double price  =             0.;

        //when a car leaves the parkhaus the following will happen
        if ("leave".equals(event)){
            priceString.append(params[4]);

            //parsing String
            price    = (!(priceString.equals("_"))) ? Double.parseDouble(priceString.toString()) :  price;

            //formats the price to xx.yy; e.g. makes 1234 to 12.34,-
            price = (price != null) ? price / 100 : price;

            //doing the math for the buttons
            totalRevenue += price;
            averageRevenue = totalRevenue / ++totalCars;

            //stores variables in ServletContexts, so they will be returned when hitting the corresponding buttons
            getApplication().setAttribute("total_revenue", totalRevenue);
            getApplication().setAttribute("average_revenue", averageRevenue);
            getApplication().setAttribute("total_cars", totalCars);
            getApplication().setAttribute("get_bill", price);
        }
    }


    final private ServletContext getApplication(){ return getServletConfig().getServletContext();}


    final private Double getTotalRevenue(){
        Double totalRevenue;
        ServletContext application = getApplication();
        totalRevenue = (Double) application.getAttribute("total_revenue");
        totalRevenue = (totalRevenue == null) ? 0.0 : totalRevenue;
        return totalRevenue;
    }


    final private Double getAverageRevenue(){
        Double averageRevenue;
        ServletContext application = getApplication();
        averageRevenue = (Double) application.getAttribute("average_revenue");
        averageRevenue = (averageRevenue == null) ? 0. : averageRevenue;
        return averageRevenue;
    }


    final private Long getTotalCars(){
        Long totalCars;
        ServletContext application = getApplication();
        totalCars = (Long) application.getAttribute("total_cars");
        totalCars = (totalCars == null) ? 0 : totalCars;
        return totalCars;
    }


    final private Double getBill(){
        Double bill;
        ServletContext application = getApplication();
        bill = (Double) application.getAttribute("get_bill");
        bill = (bill == null) ? 0. : bill;
        return bill;
    }


    final private static String getBody(HttpServletRequest request) throws IOException{
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;

        try{
            InputStream inStream = request.getInputStream();

            if (inStream != null){
                bufferedReader = new BufferedReader(new InputStreamReader(inStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0){
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("");
            }
        } finally {
            if (bufferedReader != null){
                bufferedReader.close();
            }
        }
        return stringBuilder.toString();
    }

    final public void destroy(){/*do nothing*/}

}



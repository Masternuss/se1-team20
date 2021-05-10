package com.example.Parkhaus;

public class ParkhausServletDummy {

    //getBill()-Surrogates for getBill()-Method in ParkhausServlet
    final protected static Double getBill(final String BODY){
        String[] params = BODY.split(",");
        String event =    params[0];

        Double price =    0.;
        Double bill  =    0.;
        if ("leave".equals(event)){
            StringBuilder priceString = new StringBuilder();
            priceString.append(params[4]);
            price = (!priceString.equals("-")) ? Double.parseDouble(priceString.toString()) : 0L;
            bill = price;
        }
        return bill;
        //this method could be a one_liner like the return statement below shows,
        //but to reflect the steps performed in the servlet we did it this way

        //return ("leave".equals(BODY.split(",")[0])) ?  Double.parseDouble(BODY.split(",")[4]) : 0;
    }

    final protected static Long getTotalCars(final String BODY){
        Long totalCars = 0L;
        return ("leave".equals(BODY.split(",")[0])) ? ++totalCars : totalCars;
    }

}

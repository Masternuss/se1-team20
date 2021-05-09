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
            price = Double.parseDouble(priceString.toString());
            bill = price;
        }
        return bill;
        //this method could be a one_liner like the return statement below,
        //but to reflect the steps performed in servlet we did it this way

        //return Double.parseDouble(BODY.split(",")[4]);
    }

    final protected static Long getTotalCars(final String BODY){
        return 0L;
    }

}

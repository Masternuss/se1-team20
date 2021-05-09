package com.example.Parkhaus;

public class ParkhausServletDummy {

    final protected static Double getBill(final String BODY){
        String[] params = BODY.split(",");
        StringBuilder priceString = new StringBuilder();
        priceString.append(params[4]);
        Double price = Double.parseDouble(priceString.toString());
        Double bill = price;
        return bill;
        //this method could be a one_liner like the return statement below,
        //but to reflect the steps performed in servlet we did it this way

        //return Double.parseDouble(BODY.split(",")[4]);
    }

}

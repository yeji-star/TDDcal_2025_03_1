package org.example;

public class Calc {

    public static int run(String exp) {

        String[] bits = exp.split(" ");

        int a = Integer.parseInt(bits[0]);
        int b = Integer.parseInt(bits[2]);


        if (bits[1].equals("+")) {
            return a + b;
        } else if (bits[1].equals("-")) {
            return a - b;
        }


        return a + b;
    }

}

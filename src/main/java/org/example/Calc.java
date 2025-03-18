package org.example;



public class Calc {

    public static int run(String exp) {

        String[] bits = null;
        System.out.println("exp : " + exp);

        int sum = 0;

        for (int i = 0; i < bits.length; i++) {
            sum+= Integer.parseInt(bits[i]);
        }

        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;


        exp = exp.replace("- ", "+ -");

        System.out.println("exp2 : " + exp);


        boolean NumPlus = exp.contains("+");
        boolean NumPlus2 = exp.contains("*");


        if (NumPlus) {
            bits = exp.split(" \\+ ");
        } else if (NumPlus2) {
            bits = exp.split(" \\* ");
        }


        if (bits.length > 2) {
            a = Integer.parseInt(bits[0]);
            b = Integer.parseInt(bits[1]);
            c = Integer.parseInt(bits[2]);
            d = Integer.parseInt(bits[3]);
        }

        if (NumPlus) {
            return sum;
        } else if (NumPlus2) {
            return a * b * c;
        }

        throw new RuntimeException("해석 불가 : 올바른 계산식이 아닙니다");

    }

}

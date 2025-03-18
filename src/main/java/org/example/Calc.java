package org.example;



public class Calc {

    public static int run(String exp) {

        String[] bits = null;

        System.out.println("exp : " + exp);

        exp = exp.replace("- ", "+ -");

        System.out.println("exp2 : " + exp);

        boolean NumPlus = exp.contains("+");
        boolean NumPlus2 = exp.contains("*");


        if (NumPlus) {
            bits = exp.split(" \\+ ");
        } else if (NumPlus2) {
            bits = exp.split(" \\* ");
        }

        int a = Integer.parseInt(bits[0]);
        int b = Integer.parseInt(bits[1]);
        int c = 0;

        if (bits.length > 2) {
            c = Integer.parseInt(bits[2]);
        }
        
        if (NumPlus) {
            return a + b + c;
        } else if (NumPlus2) {
            return a * b * c;
        }

        throw new RuntimeException("해석 불가 : 올바른 계산식이 아닙니다");

    }

}

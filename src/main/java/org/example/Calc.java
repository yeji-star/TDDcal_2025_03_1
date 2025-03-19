package org.example;


import java.util.Arrays;
import java.util.stream.Collectors;

public class Calc {

    public static int run(String exp) {

        if (!exp.contains(" ")) {
            return Integer.parseInt(exp);
        }

        exp = exp.replace("- ", "+ -");
        exp = exp.replace("((", "");
        exp = exp.replace("))", "");

        boolean plus = exp.contains("+");
        boolean multi = exp.contains("*");

        boolean com = plus && multi;

        if (com) {
            String[] bits = exp.split(" \\+ ");

            String newExp = Arrays.stream(bits)
                    .mapToInt(Calc::run)
                    .mapToObj( e -> e + "")
                    .collect(Collectors.joining(" + "));

            return run(newExp);

//            if (bits.length == 3) {
//                if (bits[0].contains("*")) {
//                    return run(bits[0]) + Integer.parseInt(bits[1]) + run(bits[2]);
//                } else {
//                    return Integer.parseInt(bits[0]) + Integer.parseInt(bits[1]) + run(bits[2]);
//                }
//
//            }
//            return Integer.parseInt(bits[0]) + run(bits[1]);
        }

        // boolean Plus = exp.contains("+"); // contain : 감싸다

        if (plus) {

            String[] bits = exp.split(" \\+ ");
            int sum = 0;

            for (int i = 0; i < bits.length; i++) {
                // bits의 길이가 i보다 클떄까지 i가 1씩 늘어나는 걸 반복
                sum += Integer.parseInt(bits[i]);
                // 그래서 그 배열만큼 sum에 추가

            }

            return sum;

        } else if (multi) {

            String[] bits = exp.split(" \\* ");

            int sum = 1;

            for (int i = 0; i < bits.length; i++) {
                sum *= Integer.parseInt(bits[i]);
            }

            return sum;
        }

        throw new RuntimeException("실행 불가");
    }
}



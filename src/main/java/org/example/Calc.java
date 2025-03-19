package org.example;

public class Calc {

    public static int run(String exp) {

        boolean plus = exp.contains("+");
        boolean multi = exp.contains("*");

        exp = exp.replace("- ", "+ -");

        // boolean Plus = exp.contains("+"); // contain : 감싸다
        if (plus) {

            String[] bits = exp.split(" \\+ ");


            for (int i = 0; i < bits.length; i++) {
                // bits의 길이가 i보다 클떄까지 i가 1씩 늘어나는 걸 반복

                int sum = 0;

                sum = Integer.parseInt(bits[i]);
                // 그래서 그 배열만큼 sum에 추가
                if (plus) {
                    sum += Integer.parseInt(bits[i]);
                } else if (multi) {
                    sum *= Integer.parseInt(bits[i]);
                }

                return sum;
            }


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
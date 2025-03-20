package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Calc {

    public static int run(String exp) {

        exp = exp.trim(); // 양 옆의 쓸데없는 공백 제거
        exp = stripOuterBrackets(exp); // 괄호 제거
        //단일항 들어오면 리턴
        if (!exp.contains(" ")) {
            return Integer.parseInt(exp);
        }

        boolean plus = exp.contains(" + ") || exp.contains(" - ");
        boolean multi = exp.contains(" * ");
        boolean Split = exp.contains("(") | exp.contains(")");
        boolean com = plus && multi;


            if (Split) {

                int splitPointIndex = findSplitPointIndex(exp); // 어디서 잘라야 되는가 하청을 맡김

                String firstExp = exp.substring(0, splitPointIndex);
                String secondExp = exp.substring(splitPointIndex + 1);

                char operator = exp.charAt(splitPointIndex); // 내가 방금 전에 자른 자리

                exp = Calc.run(firstExp) + " " +operator + " " + Calc.run(secondExp);
                // 수식이 아직 해결되지 않았기 때문에 Calc.run

                return Calc.run(exp);

            } else if (com) {
                String[] bits = exp.split(" \\+ ");

            String newExp = Arrays.stream(bits)
                    .mapToInt(Calc::run)
                    .mapToObj( e -> e + "")
                    .collect(Collectors.joining(" + "));

            return run(newExp);

//                if (bits.length == 3) {
//                    if (bits[0].contains("*")) {
//                        return run(bits[0]) + Integer.parseInt(bits[1]) + run(bits[2]);
//                    } else {
//                        return Integer.parseInt(bits[0]) + Integer.parseInt(bits[1]) + run(bits[2]);
//                    }
//
//                }
//                return Integer.parseInt(bits[0]) + run(bits[1]);
            }

            if (plus) {

                exp = exp.replace("- ", "+ -");

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

    private static int findSplitPointIndex(String exp) {
        int index = findSplitPointIndexBy(exp, '+'); // 하청 맡김 "쪼갤 수 있는 더하기 찾아주셈요"

        if (index >= 0) return index;

        return findSplitPointIndexBy(exp, '*'); // 못찾았으면 쪼갤 수 있는 곱하기 찾아
    }

    private static int findSplitPointIndexBy(String exp, char findChar) {
        int barcketsCount = 0;


        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (c == '(') {
                barcketsCount++;
            } else if (c == ')') {
                barcketsCount--;
            } else if (c == findChar) {
                if (barcketsCount == 0) return i;
            }
        }
        return -1;
    }

    private static String stripOuterBrackets(String exp) {

            int outerBracketsCount = 0;

            while (exp.charAt(outerBracketsCount) == '(' && exp.charAt(exp.length() - 1 - outerBracketsCount) == ')') {
                outerBracketsCount++;
            }

            if (outerBracketsCount == 0) return exp;

            return exp.substring(outerBracketsCount, exp.length() - outerBracketsCount);
        }
    }






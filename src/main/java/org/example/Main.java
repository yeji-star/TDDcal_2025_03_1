package org.example;

public class Main {
    public static void main(String[] args) {

        String exp = "5 + -(9 + 1) * -(8 + 2) + 5";

        int StartPos = 4;
        int EndPos = 11;

        String head = exp.substring(0, StartPos);
        String body = "(" + exp.substring(StartPos + 1, EndPos + 1) + " * -1)";
        String tail = exp.substring(EndPos + 1);

        System.out.println("exp: " + exp);
        System.out.println("head: " + head);
        System.out.println("body: " + body);
        System.out.println("tail: " + tail);

        System.out.println("exp: " + exp);
        System.out.printf("exp : ");
        System.out.printf(head);
        System.out.printf(body);
        System.out.printf(tail);
    }
}

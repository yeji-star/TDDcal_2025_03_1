# 목표

3 * 1 + (1 - (4 * 1 - (1 - 1)))

---

1) 10 + 20 + 30
   10/ + /20/ + /30

2) 10 - 20 + 30 == 20
   "- " -> "+ -"

-> '마이너스 공백' 문자열을 '플러스 공백 마이너스 문자열'로 바꿔야함
-> 문자열 바꾸기

replace 특정 문자열 변경

println문으로 입력된 숫자의 값이 어떻게 바뀌었는지 (문자열이 제대로 바뀌었는지) 확인할 수 있다.

3) 10 - 10 - 10 - 10 + 10 + 10 - 10

10 + (-10) + (-10) + (-10) + 10 + 10 + (-10)



4) 10 * 10 * 10
   10을 10번 서로 더한 것
   10 + 10 + 10 + 10 + 10 + 10 + 10 + 10 + 10 + 10
   -> 이 방법은 너무 무식함

전에 +와 -를 출력한 형태 그대로, boolean 자료형을 써서 +일 때 true인 변수 하나, *일 때 true인 변수 하나를 만든다.
그렇게 해서 아래에 if문으로 " + "를 자르는 것과 " * "를 자르는 걸 넣고, 또 아래에 if문으로 곱할 때 true인 변수가 true일 때 a와 b, 그리고 c를 서로 곱하는 값을 return 시킨다.

이러면 맨 바깥에 있는 static int run에게 return 값이 사라지기 때문에 주석처리를 했던 throw를 다시 붙여 넣는다.

5) 10 + 5 * 2

5 * 2 먼저 처리가 되어야 함
그 뒤에 10을 더하는 것이다.
return a + (b * c);


6) 10 - 10 - 10 - 10

10 + -10 + -10 + -10

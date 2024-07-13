package com.example.green;

public class test {
            public static void main(String[] args) throws Exception {
                // 예외를 던지는 메서드 호출
                divide2(10, 0);
            }

            public static void divide2(int num1, int num2) throws Exception {
                // 0으로 나누는 경우 예외를 던짐
                if (num2 == 0) {
                    throw new Exception("0으로 나눌 수 없습니다.");
                }

                // 나눗셈 결과 출력
                System.out.println("나눗셈 결과: " + (num1 / num2));
            }
        }

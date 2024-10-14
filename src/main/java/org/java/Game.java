package org.java;

import java.util.Scanner;

public class Game {
    public static boolean hasDuplication(int num) {
        int[] ch = new int[10];
        while (num > 0) {
            ch[num % 10]++;
            num /= 10;
        }
        for (int i = 1; i <= 9; i++) {
            if(ch[i] > 1) return true;
        }
        return false;
    }
    public static int getUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요: ");
        try {
            int num = sc.nextInt();
            if(!(num < 1000 && num >= 100)) {
                throw new IllegalArgumentException();
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
    public static void run() {
        Computer com = new Computer();
        System.out.println(com.answer);
        while (true) {
            int num = getUserInput();
            if(hasDuplication(num)) throw new IllegalArgumentException();
            String hint = com.giveUserHint(String.valueOf(num));
            System.out.println(hint);
            if (hint.equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }
}
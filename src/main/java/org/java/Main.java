package org.java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void getUserInput() {
        Scanner sc = new Scanner(System.in);
        try {
            int menu = sc.nextInt();
            if (menu != 1 && menu != 2) throw new IllegalArgumentException();
            else if (menu == 1) Game.run();
            else throw new IllegalArgumentException();
        } catch (InputMismatchException e1) {
            throw new IllegalArgumentException();
        }
    }
    public static void main(String[] args) {
        // 게임 시작 1, 게임 종료 2
        System.out.println("숫자 야구 게임을 시작합니다.");
        try {
            Game.run();
        } catch (IllegalArgumentException e) {
            return;
        }
        while (true) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            try {
                getUserInput();
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 입력. 프로그램 종료");
                return;
            }
        }
    }
}
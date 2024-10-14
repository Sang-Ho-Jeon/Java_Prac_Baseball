package org.java;

public class Computer {
    String answer = "";
    public Computer() {
        int[] ch = new int[10];
        int cnt = 0;
        while (true) {
            int tmp = (int)(Math.random() * 9) + 1;
            if (ch[tmp] == 0) {
                ch[tmp] = 1;
                answer += tmp;
                cnt++;
            }
            if(cnt == 3) break;
        }
    }

    public String makeHint(int strike, int ball) {
        String tmp = "";
        if(ball == 0) return "낫싱";
        else if (strike == 0 && ball != 0) {
            return ball + "볼";
        } else if (strike == ball) {
            return strike + "스트라이크";
        } else {
            return (ball - strike) + "볼 " + strike + "스트라이크";
        }
    }

    public String giveUserHint(String user_answer) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            if(answer.charAt(i) == user_answer.charAt(i)) strike++;
            if(answer.contains(String.valueOf(user_answer.charAt(i)))) ball++;
        }
        return makeHint(strike, ball);
    }
}
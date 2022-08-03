package Tests.UITests.interviewQuestions_1;

import org.junit.jupiter.api.Test;

public class Codility {
    @Test
    public void binaryGap() {
        int ex1 = 1001;
        int ex2 = 1000010001;
        int ex3 = 10100;
        int ex4 = 1111;
        int ex5 = 100000;
    }

    @Test
    void ae() {
        int N = 1001;
        int length = (int) (Math.log10(N) + 1);
        int digit = 2;
        int max = 0;
        for (int i = 0; i < length; i++) {
            int kalan = N % 10;
            digit = kalan;

            System.out.println(kalan);
            N = N - kalan;
            N /= 10;
        }

    }


    void ss(String str) {
        String[] split = str.split("");
        int max = 0;

        int count = 1;
        for (int i = 0; i < split.length - 1; i++) {
            if (split[i].equals(split[i + 1])) {
                count++;
            } else {
                System.out.println(split[i] + " : " + count);
                max = Math.max(max, count);
                count = 1;
            }

        }
        System.out.println(count + " " + max);
    }
}

package Tests.UITests.interviewQuestions_1;


import io.qameta.allure.Issue;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TechnicalQuestions {
    @Test
    public void smallestPositiveFirstArray() {
//        int[] A = {-7, -1, -3};
        int[] A = {7, 1, 3, 6, 4, 1, 2};


        int ans = 1;
        for (int i = 0; i < A.length; i++) {

            int finalAns = ans;
            if (Arrays.stream(A).anyMatch(t -> t == finalAns)) {
                ans++;
            } else {
                break;
            }
        }
        System.out.println(ans);
    }

    boolean emailCheck(String S) {
        boolean flag = true;
        long count = Arrays.stream(S.split("")).filter(t -> t.equals(".")).count();

        if (count > 1) {
            StringBuilder stringBuilder = new StringBuilder(S);

            for (int i = 0; i < count - 1; i++) {
                S = String.valueOf(stringBuilder.deleteCharAt(S.indexOf(".")));

            }
        }

        if (!S.contains("@")) {
            System.out.println("doesnt have @");
            flag = false;
        } else {
            if (S.indexOf("@") == 0) {
                System.out.println("doesnt have letter before @");
                flag = false;
            }
            if (S.indexOf("@") > S.indexOf(".")) {
                System.out.println("@ and . they are not in correct please");
                flag = false;
            }
        }
        if (!S.contains(".")) {
            System.out.println("doesnt have .");
            flag = false;
        }
        return flag;
    }

    @Test
    public void primeNumber() {
        int prime = 24;
        boolean flag = false;
        for (int i = 2; i < prime / 2; i++) {
            if (prime % i == 0) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("it is not a prime");
        } else {
            System.out.println("it is prime");
        }
    }

    @Nested
    class Codility {
        @Test
        public void binaryGap() {
            int N = 51712;
            int count = 0;
            int max = 0;
            int for_one = 2; //32 gibi sayilar icin
            while (N != 0) {

                int kalan = N % 2;
                N = N / 2;

                System.out.println(kalan);
                if (kalan == 0) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 0;
                }
                for_one = for_one - kalan;
            }
            if (max == 1 || for_one > 0) {
                max = 0;
            }
            System.out.println(max);
        }

        @Test
        public void cyclicRotation() {
            int[] A = {3, 8, 9, 7, 6};
            int K = 3;
            int sizeA = A.length;
            int[] N_A = new int[sizeA];
            for (int i = 0; i < K; i++) {

                for (int j = 0; j < sizeA - 1; j++) {
                    N_A[0] = A[sizeA - 1];
                    N_A[j + 1] = A[j];
                }

                A = Arrays.copyOf(N_A, sizeA);
            }
            System.out.println(" : " + Arrays.toString(N_A));

        }

        @Test
        public void oddOccurrencesInArray() {
            int[] A = {9, 3, 9, 3, 9, 7, 9};
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < A.length; i++) {
//                if (Map.of().containsValue(A[i])) {


                }
            }

        }
    }

    @Nested
    class Techpro {
        @Nested
        class Prep_1 {
            @Test
            public void letterToDigit() {
                String str = "aaaabbbccccccdda";
                int count = 0;
                Map<String, Integer> map = new HashMap<>();
                List<String> collect = Arrays.stream(str.split("")).distinct().collect(Collectors.toList());
                for (int i = 0; i < collect.size(); i++) {

                    for (int s = 0; s < str.length(); s++) {
                        if (String.valueOf(str.charAt(s)).equals(collect.get(i))) {
                            count++;
                        }
                    }
                    map.put(collect.get(i), count);
                    count = 0;
                }
                System.out.println(map);


            }

            @Test
            public void letterToDigit2() {
                String str = "aaaabbbccccccdda";
                int count = 1;
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < str.length() - 1; i++) {
                    if (str.charAt(i) == str.charAt(i + 1)) {
                        count++;
                    } else {
                        result.append(str.charAt(i)).append(count);
                        count = 1;
                    }
                }
                System.out.println(result.append(str.charAt(str.length() - 1)));
            }

            @Test
            public void fibonacci() {
                int f = 1123581119;
                int no = 5;
                int a = 0;
                int b = 1;

                for (int i = 0; i < no; i++) {
                    int c = a + b;
                    a = b;
                    b = c;
                    System.out.println(c);
                }

            }

            @Test
            public void sumOfDigit() {
                int nu = 125;
                int answer = 0;

                while (nu > 0) {
                    answer += nu % 10;
                    nu = nu / 10;
                    System.out.println(answer);
                }
                System.out.println(" : " + answer);

            }
        }

        @Nested
        class Prep_2 {
            @Test
            public void largestNumberInArray() {
                int[] array = {2, 3, 4, 50, 6, 7, 8, 9};
                int answer = 0;
                for (int i = 0; i < array.length; i++) {
                    if (array[i] > answer) {
                        answer = array[i];
                    }
                }
                System.out.println(answer);
            }

            @Test
            public void reverseNumber() {
                int number = 257;
                int length = (int) Math.log10(number);
                int kalan = 0;
                int result = 0;
                while (number > 0) {
                    kalan = number % 10;
                    number /= 10;
                    System.out.println(kalan);
                    result += kalan * Math.pow(10, length);
                    length--;
                }
                System.out.println(result);
            }

            @Test
            public void twoMaxInArray() {
                int[] array = {2, 3, 4, 5, 66, 7, 3, 1, 2};
                Arrays.sort(array);
                System.out.println(Arrays.toString(array));
            }


        }

        @Nested
        class Prep_3 {
            @Test
            public void swapTwoNumbers() {
                int a = 2;
                int b = 3;
//                a= a^b^(b=a);

                System.out.println(a + " " + b);
                a += b - (b = a);

                System.out.println(a + " " + b);
//                System.out.println(6>3);
//                System.out.println(5>>3);
//                System.out.println(5>>>3);
            }

            @Test
            public void LasrgestArray() {
                int[] arr = {2, 5, 7, 1};
                Arrays.sort(arr);
                System.out.println(arr[arr.length - 1]);
            }

            @Test
            public void Paindrome() {
                String str = "malam";

                StringBuilder stringBuilder = new StringBuilder(str);
                System.out.println(stringBuilder.reverse().toString().equals(str));
            }

            @Test
            public void Paindrome2() {
                String str = "kalam";
                StringBuilder stringBuilder = new StringBuilder(str);
                for (int i = 0; i < str.length() - 1; i++) {
                    StringBuilder stringBos = new StringBuilder();
                    str = str.substring(i);
                    System.out.println(str);
                    System.out.println("**********");
                    for (int j = i; j < str.length(); j++) {
                        stringBos.append(str.charAt(j));
                        System.out.println(i + " : " + j);
                        if (stringBos.reverse().toString().equals(str)) {
                            System.out.println(stringBos.toString());
                        }
                    }

                }
            }


        }

        @Nested
        class Prep_4 {

        }

        @Nested
        class Prep_5 {
            @Issue("test")
            @Test
            public void uniqeWorld() {
                String str = "tteedsfsdflkgjfdklskffdgdfgsdfsf";
                String reduce = Arrays.
                        stream(str.split("")).
                        distinct().
                        reduce("name: ", (x, t) -> x.toUpperCase() + t);
                System.out.println(reduce);
            }

        }

        @Nested
        class Prep_6 {
            @Test
            public void buffer() {

            String  string= "Omer";
            StringBuffer stringBuffer = new StringBuffer(string);
            stringBuffer.trimToSize();
                System.out.println(stringBuffer);
            }

        }

        @Nested
        class Prep_7 {

        }

        @Nested
        class Prep_8 {

        }

        @Nested
        class Prep_9 {

        }

        @Nested
        class Prep_10 {

        }

        @Nested
        class Prep_11 {

        }

        @Nested
        class Prep_Bonus {

        }


    @Test
    public void fgfgf() {
        int[] A = {2, 4, 5, 4, 2};
        for (int i = 0; i < A.length - 1; i++) {
            int finalI = A[i];

            if (Arrays.stream(A).skip(i + 1).noneMatch(t -> t == finalI)) {
                System.out.println(finalI);
            }
        }
    }


    @Test
    public void ssadae() {

        int[] A = {2, 4, 5, 4, 2};
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
//            if (!list.contains(A[i])) {
//                list.add(A[i]);
//            } else {
            System.out.println(A[i]);
//            }

        }
    }


    @Test
    public void ddd() {
        int[] A = {2, 4, 5, 4, 2};
        boolean flag = false;
        int[] ints = Arrays.stream(A).sorted().toArray();
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == ints[i + 1]) {
                flag = true;
            }
        }

    }

//    @Test
//    public void sdsf() {
//
//        int[] A = {2, 4, 5, 4, 2};
//        for (int i = 0; i < A.length; i++) {
//            for (int j = 0; j < A.length; j++) {
//                if(A[])
//            }
//        }
//    }


    @Test
    public void eeee() {
        String email = ("example.test@gmail.com");
//        System.out.println(emailCheck(email));
    }


    @Test
    public void array_pair() {
        System.out.println("**");
    }
}

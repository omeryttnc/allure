package Tests.UITests.interviewQuestions_1;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;
import java.util.stream.Stream;

public class Codility {

    @Test
    public void fibonacci() {

        int a = 1;
        int b = 1;
        int c = 1;

        int n = 4;
        System.out.println(1);
        for (int i = 0; i < n; i++) {
            System.out.println(c);
            c = a + b;  // c=a+b -> 2 3 5 8
            b = a;     // b=a   -> 1 2 3 5
            a = c;     // a=c   -> 2 3 5 8

        }

    }

    @Test
    void reverseNumber() {
        int number = 123;
        int length = (int) Math.log10(number);
        int reversedNumber = 0;
        while (number > 0) {
            System.out.println(number % 10);
            reversedNumber += number % 10 * Math.pow(10, length);
            number /= 10;
            length--;
        }
        System.out.println(reversedNumber);
    }

    @ParameterizedTest
    @ValueSource(ints = {9, 529, 20, 15, 32})
        // %100 basari
    void lesson1_iterations(int N) {
        System.out.println(lesson1_iteration_solution(N));
    }

    int lesson1_iteration_solution(int N) {
        int count = 0;
        int max0 = 0;
        boolean isStarted = false;
        while (N > 0) {
            if (N % 2 == 0) {
                count++;
            }
            if (N % 2 == 1) {
                if (isStarted) {
                    max0 = Math.max(max0, count);
                }

                isStarted = true;
                count = 0;

            }
            N = N / 2;
        }
        return max0;
    }


    @Test
    void lesson_2_arrays_cyclicRotation() {  // %67 basari
        int[] A = {1, 2, 3, 4};
        int K = 4;
        System.out.println(Arrays.toString(lesson_2_arrays_cyclicRotation_solution(A, K)));
    }

    int[] lesson_2_arrays_cyclicRotation_solution(int[] A, int K) {
        int[] B = new int[A.length];
        for (int i = 0; i < K; i++) {
            B = new int[A.length];
            for (int j = 0; j < A.length - 1; j++) {
                B[j + 1] = A[j];
            }
            B[0] = A[A.length - 1];
            A = B;
        }
        return B;
    }

    @Test
    void lesson_2_array_OddOccurencesInArray() {  //100
        int[] A = {1, 2, 3, 4, 5, 4, 3, 2, 1};

        System.out.println(lesson_2_array_OddOccurencesInArray(A));
    }

    int lesson_2_array_OddOccurencesInArray(int[] A) {
        boolean flag = false;
        int result = 0;
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                System.out.println(A[i] + " : " + A[j]);
                if (A[i] == A[j]) {
                    flag = true;
                    i++;
                    break;
                }
            }
            if (!flag) {
                result = A[i];
            }
            flag = false;
        }
        return result;
    }

    @Test
    void name() {
        int[] a = {2, 3, 4};
        int[] b = {1, 5, 6};
        int[] c = ArrayUtils.addAll(a, b);
        System.out.println(Arrays.toString(c));
        ArrayUtils.reverse(c);
        System.out.println(Arrays.toString(c));

        System.out.println(Arrays.toString(ArrayUtils.remove(c, 0)));
        System.out.println(Arrays.toString(c));
    }

    @Test
    void s() {
        Integer[] arrayInt = {1, 2, 5, 4, 5, 4, 3, 2, 1};

        List<Integer> ints = Arrays.asList(arrayInt);

//        ints.remove(1);

//        System.out.println(ints);

        String[] array = {"a", "b", "c", "d", "e"};

//        //Method 1
//        List<String> list = Arrays.asList(array);
//        System.out.println(list);

        Integer[] numbers = new Integer[]{1, 2, 3};
        List<Integer> list = Arrays.asList(numbers);
    }

    @Test
    void sss() {

        List<Integer> aList = new ArrayList<Integer>();
        Integer[] arrayInt = {1, 2, 5, 4, 5, 4, 3, 2, 1};
        for (int i = 0; i < arrayInt.length; i++) {
            int a = arrayInt[i];
            if (aList.contains(a)) {
                aList.remove(Integer.valueOf(a));
            } else {
                aList.add(a);
            }
        }
        System.out.println(aList);

    }

    @Test
    void smallestPositive() {
        int[] arrayInt = {1, 2, 3, 4, 5, 4, 2, 1};
        System.out.println(smallestPositive2(arrayInt));
    }

    int smallestPositive(int[] A) {
        Arrays.sort(A);
        int result = 1;

        for (int i = 0; i < A.length; i++) {
            int finalResult = result;
            if (Arrays.stream(A).anyMatch(t -> t == finalResult)) {
                result++;
            } else {
                break;
            }

        }
        return result;
    }

    int smallestPositive2(int[] A) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < A.length; i++) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], i);
            } else {
                map.remove(A[i]);
            }
        }
        System.out.println(map);
        return 0;
    }


    @Test
    void dSetWotk() {
        Set<Integer> s = new HashSet<>();
        s.add(10);
        s.add(20);
        s.add(30);
        s.add(40);
        s.add(50);
        s.add(60);
        Stream<Integer> sorted = s.stream().sorted();
        System.out.println(sorted.iterator().next());
        Map<Integer,Integer>map = new TreeMap<>();
        map.put(1,2);
        map.put(2,7);
        map.put(3,9);
        map.put(4,5);

        System.out.println("map = " + map);
        Integer integer = map.putIfAbsent(1, 9);
        System.out.println("map = " + map);
        System.out.println("integer = " + integer);
    }
}

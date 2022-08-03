package Tests.UITests.interviewQuestions_1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Easy {
    @Test
    public void TwoSum() {
        /*
        Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
         */
        int[] nu = {10, 12, 14, 16};
        int tar = 26;
        System.out.println("twoSum(nu,tar) = " + Arrays.toString(twoSum2(nu, tar)));

    }


    int[] twoSum2(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }


    @Test
    public void dd() {
        Map<Integer, Integer> map = new HashMap<>();

        int tar = 26;
        int[] nu = {10, 12, 14, 16};
        for (int i = 0; i < nu.length; i++) {
            int diff = tar - nu[i];
            int finalI = i;
            if (Arrays.stream(nu).anyMatch(t -> nu[finalI] == diff)) {

                System.out.println(finalI + " : " + diff + " : " + tar);

            }
        }


    }

    @Test
    @DisplayName("3. Longest Substring Without Repeating Characters")
    public void longestSubstring() {
        String str = "pwwkew";
        System.out.println(Arrays.stream(str.split("")).collect(Collectors.toSet()).size());
    }

    @Test
    @DisplayName("4. Median of Two Sorted Arrays")
    public void medianArray() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        List<Integer> list = new ArrayList<>();

        for (int k : nums1) {
            list.add(k);
        }
        for (int j : nums2) {
            list.add(j);
        }

        List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
        int size = collect.size();
        double av;


        if (size % 2 == 0) {
            av = (collect.get(size / 2) + collect.get(size / 2 - 1)) * 0.5;
        } else {
            av = collect.get(size / 2);
        }

        System.out.println(av);


    }

    @Test
    @DisplayName("6. Zigzag Conversion")
    public void zigzag() {

        String answer = "";
        String str = "P   A   H   N\n" +
                "A P L S I I G\n" +
                "Y   I   R";
        int row = (int) Arrays.stream(str.split("")).filter(t -> t.contains("\n")).count();
        for (int i = 0; i < row; i++) {

            answer = str.replace("\n", "");
        }
        System.out.println(answer.replaceAll(" ", "").trim());

    }

    public String convert(String s, int numRows) {
        String answer = "";


        for (int i = 0; i < numRows - 1; i++) {

            answer = s.replace("\n", "");
        }
        System.out.println(answer.replaceAll(" ", "").trim());

        return answer;
    }


//    public int reverse(int x) {
//
//    }

    @Test
    public void reverse_number() {


        int x = 900000;
        Map<Integer, Integer> map = new HashMap<>();

        int lastdigit;
        for (int j = 1; j < Integer.MAX_VALUE; j++) {
            lastdigit = x % (10);
            map.put(j, lastdigit);
            x = (x - lastdigit) / 10;
            if (x == 0) break;

        }
        System.out.println(map);
        int answ = 0;
        int power = map.size() - 1;
        for (int i = 0; i < map.size(); i++) {
            answ += map.get(i + 1) * Math.pow(10, power);
            power--;
        }
        //   return(answ);
        System.out.println(answ);
    }

    @Test
    public void ss() {
        int a = 2;
        System.out.println(Math.pow(a, 2));
    }

//    public int lengthOfLongestSubstring(String s) {
////        return ;
//    }

    @Test
    public void sdsad() {
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        String s = "";
        String answer = "";
        String[] split = s.split("");

        for (int i = 0; i < split.length; i++) {
            map.put(split[i], i);
        }
        System.out.println(map + "  : " + map.size());
    }


    @Test
    public void dddd() {
        int max = 0;
        String s = "";
        String[] split = s.split("");
        Set<String> stringSet = new HashSet<>();

        for (int i = 0; i < split.length - 1; i++) {
            for (int j = i + 1; j < split.length - 1; j++) {
                stringSet.add(split[j]);
                stringSet.add(split[i]);
              //  max = Math.max(max, stringSet.size());
                if (split[i].equals(split[j]) || stringSet.contains(split[j + 1])) {
                    max = Math.max(max, stringSet.size());
                    System.out.println(stringSet);
                    stringSet.clear();
                    break;
                }
            }
        }
        if(split.length<=2 &&split.length!=0){
            for (int i = 0; i < split.length; i++) {

            stringSet.add(split[i]);
            }
            max=stringSet.size();
        }


        if (max == 0) {max = s.length();
        System.out.println(max);

    }}


    @Test
    public void lengthOfLongestSubstringTest() {
        int max = 0;
        String s = "dwda";
        String answer = "";
        String[] split = s.split("");

        for (int i = 0; i < split.length; i++) {

            if (answer.contains(split[i])) {
                answer = split[i];
            } else {
                answer += split[i];
            }

            max = Math.max(max, answer.length());
        }
        if (max == 0) {
            max = s.length();
        }
        System.out.println(max);

    }

    @Test
    public void sss() {
        int max = 0;
        String s = "dwda";
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            System.out.println("s.charAt(i) = " + s.charAt(i));
            if (str.contains(String.valueOf(s.charAt(i)))) {
                str = str.replace(String.valueOf(s.charAt(i)), "");
            } else {
                str += String.valueOf(s.charAt(i));
            }


        }
        System.out.println(str);

    }

    @Test
    public void sssss() {
        int max = 0;
        String s = "abcabcbb";
        List<String> list = new ArrayList<>();
        String ilkharf = String.valueOf(s.charAt(0));
        s = s.replace(ilkharf, "");

        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {

                max = Math.max(max, list.size());
                if (list.contains(String.valueOf(s.charAt(j)))) {
                    break;
                }
                if (!list.contains(String.valueOf(s.charAt(j)))) {
                    list.add(String.valueOf(s.charAt(j)));
                }
                max = Math.max(max, list.size());
            }
        }
        if (max == 0) {
            max = s.length();
        }
        System.out.println(list + " : " + list.size() + " : " + max);


    }

    @Test
    public void ssss() {
        String str = "hasan? kazim.";

        System.out.println(str.replaceAll("[^? ]", ""));
    }

    @Test
    public void primernumber() {

        int number = 24;
        boolean flag = true;
        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {

                flag = false;
                break;
            }
        }

        if (flag) {
            System.out.println("prime");
        } else {
            System.out.println("prime degil");
        }
//        for (int i = 0; i < ; i++) {
//
//        }

    }

}


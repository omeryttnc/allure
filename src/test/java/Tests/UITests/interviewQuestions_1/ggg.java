package Tests.UITests.interviewQuestions_1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ggg {
    static {
        System.out.println("I am static block");
    }

    @Test
    public void ssadae() {
        int[] A = {2, 4, 5, 4, 2};
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (!list.contains(A[i])) {
                list.add(A[i]);
            } else {
                System.out.println(A[i]);
            }
        }
    }

    @Test
    public  void sss() {
        System.out.println("normal test");
    }

    @Test
    public void sss2() {
        sss();

    }


}

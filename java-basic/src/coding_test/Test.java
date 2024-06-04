package coding_test;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {

    public int solution(String my_string) {
        char[] charArr = my_string.toCharArray();
        int i = 0;
        for (char c : charArr) {
            System.out.println("c = " + c);
            String s = String.valueOf(c);
            try {
                if
                int i1 = Integer.parseInt(s);
                i += i1;
            } catch (IllegalArgumentException e) {

            }
        }

        return i;
    }
}

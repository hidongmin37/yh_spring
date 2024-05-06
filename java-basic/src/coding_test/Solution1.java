package coding_test;

import java.util.*;

class Solution1 {
    public String[] solution(String[] todo_list, boolean[] finished) {

        System.out.println(Arrays.toString(finished));
        System.out.println(Arrays.toString(todo_list));

        for (int i = 0; i < todo_list.length; i++) {
            if (finished[i]) {
                todo_list[i] = "1";
            }
        }
        List<String> s_list = new ArrayList<>(Arrays.asList(todo_list));

        for (int i = 0; i < todo_list.length; i++) {
            if (finished[i]) {
                s_list.remove("1");
            }
        }
        Object[] array = s_list.toArray();

        return Arrays.copyOf(array, array.length, String[].class);
    }


}
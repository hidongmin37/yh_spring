package coding_test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Test {

    public int[] solution(int[] num_list, int n) {
        int[] answer = {num_list[n]};

        int[] arr1 = Arrays.copyOfRange(num_list, 0, n);
        int[] arr2 = Arrays.copyOfRange(num_list, n+1, num_list.length-1);
        List<Integer> intLista = new ArrayList<>(Arrays.stream(answer).boxed().toList());
        List<Integer> intList1 = new ArrayList<>(Arrays.stream(arr1).boxed().toList());
        List<Integer> intList2 = new ArrayList<>(Arrays.stream(arr2).boxed().toList());

        intLista.addAll(intList1);
        intLista.addAll(intList2);

        return intLista.stream()
                .mapToInt(Integer::intValue)
                .toArray();

    }
}

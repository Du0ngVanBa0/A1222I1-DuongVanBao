package ss11_stack_queue.bai_tap.count_element_using_map;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        String str = "Duong nhu anh chieu nay anh co nhu la dUong khoNg co duong nhu";
        String[] wordLowerArr = splitLowerWord(str);
        for (String e : wordLowerArr) {
            if (!map.containsKey(e)) {
                map.put(e, 1);
            } else {
                int time = map.get(e);
                map.put(e, time + 1);
            }
        }
        for (String e:map.keySet()){
            System.out.println(e + ": " + map.get(e));
        }
    }

    public static String[] splitLowerWord(String str) {
        int count = 0;
        String[] arr = str.split(" ");
        for (String e : arr) {
            if (!e.equals("")) {
                count++;
            }
        }
        String[] wArray = new String[count];
        int index = 0;
        for (String e : arr) {
            if (!e.equals("")) {
                wArray[index] = e.toLowerCase();
                index++;
            }
        }
        return wArray;
    }
}

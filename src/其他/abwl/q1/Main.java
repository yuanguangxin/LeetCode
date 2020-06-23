package 其他.abwl.q1;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        if (s.length < 1) {
            return;
        }
        int k = Integer.parseInt(s[0]);
        if (k == 0) {
            return;
        }
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i < s.length; i++) {
            nums.add(Integer.parseInt(s[i]));
        }
        in.close();

        int sp = nums.size() / k;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            if (map.containsKey(nums.get(i))) {
                int total = map.get(nums.get(i)) + 1;
                if (total > sp) {
                    System.out.print(nums.get(i));
                    return;
                }
                map.put(nums.get(i), total);
            } else {
                map.put(nums.get(i), 1);
            }
        }
    }
}

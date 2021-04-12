package list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: fengsihan
 * @time: 2021-03-23 17:46
 */
public class Test1 {

  public static void main(String[] args) {
    int[] aa = new int[]{170, 170, 171, 171, 172, 172, 173};

    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < aa.length; i++) {
      if (!map.containsKey(aa[i])) {
        map.put(aa[i], 1);
      } else {
        map.put(aa[i], map.get(aa[i]) + 1);
      }
    }

    int result = 0;

    ArrayList<Integer> integers = new ArrayList<>(map.keySet());

    for (int i = 0; i < integers.size(); i++) {
      int tmp = getValue(map, integers.get(i)) + getValue(map, integers.get(i) + 1) + getValue(map,
          integers.get(i) + 2);

      int tmp1 = getValue(map, integers.get(i)) + getValue(map, integers.get(i) - 1) + getValue(map,
          integers.get(i) - 2);
      int tmp2 = getValue(map, integers.get(i)) + getValue(map, integers.get(i) - 1) + getValue(map,
          integers.get(i) + 1);

      int tmp3 = Math.max(Math.max(tmp, tmp1), tmp2);

      if (result < tmp3) {
        result = tmp3;
      }
    }

    System.out.println(result);

  }

  public static int getValue(Map<Integer, Integer> map, Integer key) {
    return map.get(key) == null ? 0 : map.get(key);
  }
}

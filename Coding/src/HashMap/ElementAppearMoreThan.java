package HashMap;

import java.util.HashMap;

public class ElementAppearMoreThan {

  public static void elementMoreThan(int arr[]) {
    HashMap<Integer, Integer> hm = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
    }
    System.out.println(arr.length / 3);
    for (int key : hm.keySet()) {
      if (hm.get(key) > arr.length / 3) {
        System.out.println("key " + key + " value " + hm.get(key));
      }
    }
  }

  public static void main(String[] args) {
    int arr[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
    int arr2[] = { 1, 2 };

    elementMoreThan(arr);

  }

}

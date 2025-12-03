package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {
    ArrayList<Integer> result;
    HashMap<Integer, Integer> map;
    Random rand;

    public RandomizedSet() {
        result = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();

    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        result.add(val);
        map.put(val, result.size() - 1);
        return true;

    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            result.remove(map.get(val));
            map.remove(val);
            return true;
        }
        return false;

    }

    public int getRandom() {
        return result.get(rand.nextInt(result.size()));

    }

    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.insert(1);
        boolean param_2 = obj.remove(2);
        boolean param_3 = obj.insert(2);
        int param_4 = obj.getRandom();
        boolean param_5 = obj.remove(1);
        boolean param_6 = obj.insert(2);
        int param_7 = obj.getRandom();
        System.out.println(param_1);
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
        System.out.println(param_5);
        System.out.println(param_6);
        System.out.println(param_7);

    }

}

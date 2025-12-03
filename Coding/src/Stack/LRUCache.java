package Stack;

public class LRUCache {
    public LRUCache(int capacity) {

    }

    public int get(int key) {

    }

    public void put(int key, int value) {
        LRUCache obj = new LRUCache(capacity);
        int param_1 = obj.get(key);
        obj.put(key, value);
    }
}

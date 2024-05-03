package HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<>();
		map.put("laukesh", 23);
		map.put("mukesh", 24);
		map.put("sachin", 28);
		System.out.println(map.size());
		// int removeValue = map.remove("laukesh");
		// System.out.println(removeValue);
		System.out.println(map.containsKey("laukesh"));
		System.out.println(map);
		System.out.println(map.get("laukes"));
		Set<String> keySet = map.keySet();
		System.out.println("keySet--> " + keySet);
		Set<Map.Entry<String, Integer>> valueSet = map.entrySet();
		System.out.println(valueSet);

		// for Each LoopIteration
		for (String key : keySet) {
			System.out.println("key " + key + " value " + map.get(key));
		}

	}

}

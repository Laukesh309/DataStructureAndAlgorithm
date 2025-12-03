package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class StockSpanner {
    ArrayList<Integer> result;
    Stack<Integer> st;

    public StockSpanner() {
        result = new ArrayList<>();
        st = new Stack<>();

    }

    public int next(int price) {
        while (!st.isEmpty() && result.get(st.peek()) <= price) {
            st.pop();
        }
        result.add(price);
        int finalResult;
        if (st.isEmpty()) {
            finalResult = result.size() + 1;
        } else {
            finalResult = result.size() - st.peek();
        }
        st.push(result.size());
        return finalResult;

    }

}

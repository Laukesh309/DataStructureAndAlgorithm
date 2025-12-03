package StackRevision;

import java.util.ArrayList;

public class Minstack1 {
    ArrayList<Pair> curStack;

    public Minstack1() {
        this.curStack = new ArrayList<>();
    }

    class Pair {
        int currentValue;
        int currentMin;

        Pair(int currentValue, int currentMin) {
            this.currentMin = currentMin;
            this.currentValue = currentValue;
        }
    }

    public void push(int val) {
        Pair newPair = new Pair(val, val);
        if (curStack.isEmpty()) {
            curStack.add(newPair);
            return;
        } else {
            int currentPeekValue = curStack.get(curStack.size() - 1).currentMin;
            if (currentPeekValue > val) {
                newPair.currentMin = val;
            } else {
                newPair.currentMin = currentPeekValue;
            }
        }
        curStack.add(newPair);
    }

    public void pop() {
        curStack.remove(curStack.size() - 1);
    }

    public int top() {
        return curStack.get(curStack.size() - 1).currentValue;
    }

    public int getMin() {
        return curStack.get(curStack.size() - 1).currentMin;
    }

    public static void main(String[] args) {
        MinStack1 obj = new MinStack1();
        obj.push(val);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();

    }

}

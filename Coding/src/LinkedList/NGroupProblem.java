package LinkedList;

public class NGroupProblem {
    static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
        }

        ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }

    ListNode head;

    public void insertElemnt(int data) {
        ListNode tempList = new ListNode(data);
        if (head == null) {
            head = tempList;
            return;
        }
        ListNode tempNode = head;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }
        tempNode.next = tempList;
        return;
    }

    public static void printLL(ListNode head) {
        while (head != null) {
            System.out.print(head.data + " -->");
            head = head.next;
        }
        System.out.println();
    }

    public static int isNextPossible(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public static void reverseLL(ListNode head, int k) {
        ListNode newNode = new ListNode(0, head);
        int totalCount = isNextPossible(head) / k;
        System.out.println(totalCount);
        ListNode tempNewNode = newNode;
        ListNode tempHead = head;
        ListNode prev = newNode;
        ListNode currNode = head;
        for (int i = 0; i < totalCount; i++) {
            int count = k;
            while (count > 0) {
                ListNode tempNextNode = currNode.next;
                currNode.next = prev;
                prev = currNode;
                currNode = tempNextNode;
                count--;
            }
            tempNewNode.next = prev;
            tempNewNode = tempHead;
            tempHead = currNode;
        }
        if (currNode != null) {
            tempNewNode.next = currNode;
        } else {
            tempNewNode.next = null;
        }
        printLL(newNode.next);
    }

    public static void main(String[] args) {
        int tempArray[] = { 1, 2, 3, 4, 5 };
        NGroupProblem ng = new NGroupProblem();
        for (int i = 0; i < tempArray.length; i++) {
            ng.insertElemnt(tempArray[i]);
        }
        printLL(ng.head);
        reverseLL(ng.head, 1);

    }

}

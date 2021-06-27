class ListNodeInst {
    int value = 0;
    ListNodeInst next;

    ListNodeInst(int value) {
        this.value = value;
    }
}

class LinkedListCycle {
    public static boolean hasCycle(ListNodeInst head) {
        ListNodeInst slow = head;
        ListNodeInst fast = head;
        while (fast != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)
              return true; // found the cycle
        }
        return false;
    }

    public static void main(String[] args) {
        ListNodeInst head = new ListNodeInst(1);
        head.next = new ListNodeInst(2);
        head.next.next = new ListNodeInst(3);
        head.next.next.next = new ListNodeInst(4);
        head.next.next.next.next = new ListNodeInst(5);
        head.next.next.next.next.next = new ListNodeInst(6);

        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));
    }
}
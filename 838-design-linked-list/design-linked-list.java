class MyLinkedList {

    class Node {
        int val;
        Node next;
        Node(int v) { val = v; }
    }

    Node head;
    int size = 0;

    public MyLinkedList() {}

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node cur = head;
        for (int i = 0; i < index; i++) cur = cur.next;
        return cur.val;
    }

    public void addAtHead(int val) {
        Node n = new Node(val);
        n.next = head;
        head = n;
        size++;
    }

    public void addAtTail(int val) {
        Node n = new Node(val);
        if (head == null) head = n;
        else {
            Node cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = n;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        if (index == 0) { addAtHead(val); return; }

        Node cur = head;
        for (int i = 0; i < index - 1; i++) cur = cur.next;

        Node n = new Node(val);
        n.next = cur.next;
        cur.next = n;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;

        if (index == 0) head = head.next;
        else {
            Node cur = head;
            for (int i = 0; i < index - 1; i++) cur = cur.next;
            cur.next = cur.next.next;
        }
        size--;
    }
}
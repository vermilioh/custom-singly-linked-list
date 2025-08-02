package linkedlist;

public class MyLinkedList {
    private ListNode head;
    private int size = 0;


    private static class ListNode {
        private int value;
        private ListNode next;


        ListNode(int val) {
            this.value = val;
            this.next = null;
        }

    }

    public void add(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

    }


    public boolean remove(int val) {
        if (head == null) {
            return false;
        } else if (head.value == val) {
            head = head.next;
            return true;
        } else {
            ListNode current = head;
            while (current.next != null) {
                if (current.next.value == val) {
                    current.next = current.next.next;
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }


    public void print() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            ListNode current = head;
            while (current != null) {
                System.out.print(current.value + " ");
                current = current.next;
            }

        }

    }


    public boolean contains(int val) {
        if (head == null) {
            return false;
        } else {
            ListNode current = head;
            while (current != null) {
                if (current.value == val) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    public void clear() {
        head = null;
    }

    public int size() {
        int size = 0;
        ListNode current = head;

        while (current != null) {
            size += 1;
            current = current.next;
        }
        return size;
    }

    public int get(int index){
        ListNode current = head;
        int i = 0;
        while(i != index ){
            current = current.next;
            i++;
        }
        return current.value;
    }

}

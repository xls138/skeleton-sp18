public class LinkedListDeque<T> {
    private class IntNode {
        private IntNode prev;
        private T item;
        private IntNode next;

        private IntNode(IntNode p, T i, IntNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private int size;
    private IntNode sentinel;

    public LinkedListDeque() {
        size = 0;
        sentinel = new IntNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }
    /*
    public LinkedListDeque(T item){
        sentinel = new IntNode(null,null,null);
        sentinel.next = new IntNode(sentinel,item,sentinel);
        sentinel.prev = sentinel.next;
        size = size + 1;
    }
     */

    public void addFirst(T item) {
        sentinel.next.prev = new IntNode(sentinel, item, sentinel.next);
        sentinel.next = sentinel.next.prev;
        size = size + 1;
    }

    public void addLast(T item) {
        sentinel.prev.next = new IntNode(sentinel.prev, item, sentinel);
        sentinel.prev = sentinel.prev.next;
        size = size + 1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        IntNode p = sentinel.next;
        for (int i = 0; i < size; i++) {
            System.out.println(p.item);
            p = p.next;
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T a = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size = size - 1;
        return a;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T a = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size = size - 1;
        return a;
    }

    public T get(int index) {
        if (size == 0) {
            return null;
        }
        IntNode p = sentinel;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.next.item;
    }

    public T getRecursive(int index) {
        if (size == 0) {
            return null;
        }
        //if(index==0){
        //    return sentinel.next.item;
        //}
        //return getRecursive();
        return getR(sentinel, index);
    }

    private T getR(IntNode s, int i) { //helper
        if (i == 0) {
            return s.next.item;
        } else {
            return getR(s.next, i - 1);
        }
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> l = new LinkedListDeque<>();
        l.addFirst(0);
        l.addFirst(1);
        int a = l.removeFirst();
        System.out.println(a);
    }
}

public class LinkedListDeque<Item> implements Deque<Item>{
    private class IntNode {
        private IntNode prev;
        private Item item;
        private IntNode next;

        private IntNode(IntNode p, Item i, IntNode n) {
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

    @Override
    public void addFirst(Item item) {
        sentinel.next.prev = new IntNode(sentinel, item, sentinel.next);
        sentinel.next = sentinel.next.prev;
        size = size + 1;
    }

    @Override
    public void addLast(Item item) {
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

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        IntNode p = sentinel.next;
        for (int i = 0; i < size; i++) {
            System.out.println(p.item);
            p = p.next;
        }
    }

    @Override
    public Item removeFirst() {
        if (size == 0) {
            return null;
        }
        Item a = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size = size - 1;
        return a;
    }

    @Override
    public Item removeLast() {
        if (size == 0) {
            return null;
        }
        Item a = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size = size - 1;
        return a;
    }

    public Item get(int index) {
        if (size == 0) {
            return null;
        }
        IntNode p = sentinel;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.next.item;
    }

    @Override
    public Item getRecursive(int index) {
        if (size == 0) {
            return null;
        }
        //if(index==0){
        //    return sentinel.next.item;
        //}
        //return getRecursive();
        return getR(sentinel, index);
    }

    private Item getR(IntNode s, int i) { //helper
        if (i == 0) {
            return s.next.item;
        } else {
            return getR(s.next, i - 1);
        }
    }

}

public class LinkedListDeque<T> {
    public class IntNode{
        public IntNode prev;
        public T item;
        public IntNode next;
        public IntNode(IntNode p,T i,IntNode n){
            prev = p;
            item = i;
            next = n;
        }
    }
    public int size;
    public IntNode sentinel;

    public LinkedListDeque(){
        size = 0;
        sentinel = new IntNode(null,null,null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public LinkedListDeque(T item){
        sentinel = new IntNode(null,null,null);
        sentinel.next = new IntNode(sentinel,item,sentinel);
        sentinel.prev = sentinel.next;
        size = size + 1;
    }

    public void addFirst(T item){
        sentinel.next.prev = new IntNode(sentinel,item,sentinel.next);
        sentinel.next = sentinel.next.prev;
        size = size + 1;
    }

    public void addLast(T item){
        sentinel.prev.next = new IntNode(sentinel.prev,item,sentinel);
        sentinel.prev = sentinel.prev.next;
        size = size + 1;
    }

    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        IntNode p = sentinel.next;
        for (int i = 0; i < size; i++) {
            System.out.println(p.item);
            p = p.next;
        }
    }

    public T removeFirst(){
        if(size==0){
            return null;
        }
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size = size -1;
        return sentinel.next.item;
    }

    public T removeLast(){
        if(size==0){
            return null;
        }
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size = size - 1;
        return sentinel.prev.item;
    }

    public T get(int index){
        if(size==0){
            return null;
        }
        IntNode p = sentinel;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.next.item;
    }

    public T getRecursive(int index){
        if(size==0){
            return null;
        }
        //if(index==0){
        //    return sentinel.next.item;
        //}
        //return getRecursive();
        return getR(sentinel,index);
    }

    public T getR(IntNode s,int i){ //helper
        if(i==0){
            return s.next.item;
        }else {
            return getR(s.next,i-1);
        }
    }

    public static void main(String[] args) {
        //LinkedListDeque l = new LinkedListDeque();
        LinkedListDeque<Integer> l = new LinkedListDeque<>(5);
        l.addFirst(4);
        l.addLast(6);
        //l.removeFirst();
        //l.removeLast();
        //int a = l.getRecursive(2);
        //System.out.println(a);
        l.printDeque();
    }
}

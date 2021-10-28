public class ArrayDeque<T> {
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] array;

    //T[] a = (T[]) new Object[1000];
    public ArrayDeque() {
        //array = new int[8];
        array = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    public void addLast(T item) {
        array[nextLast] = item;
        nextLast += 1;
        if (nextLast == 8) {
            nextLast = 0;
        }
        size = size + 1;
    }

    public void addFirst(T item) {
        array[nextFirst] = item;
        nextFirst -= 1;
        if (nextFirst == -1) {
            nextFirst = 7;
        }
        size = size + 1;
    }

    public T get(int i) {
        return array[i];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public void printDeque() {
        for (int i = 0; i < 8; i++) {
            System.out.println(array[i]);
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T a = array[nextFirst];
        nextFirst = nextFirst + 1;
        if (nextFirst == 8) {
            nextFirst = 0;
        }
        array[nextFirst] = null;
        return a;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T a = array[nextLast];
        nextLast = nextLast - 1;
        if (nextLast == -1) {
            nextLast = 7;
        }
        array[nextLast] = null;
        return a;
    }
}

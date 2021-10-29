public class ArrayDeque<T> {
    private int size;
    private int nextFirst;
    private int nextLast;
    private T[] array;
    private int capacity;

    //T[] a = (T[]) new Object[1000];
    public ArrayDeque() {
        //array = new int[8];
        array = (T[]) new Object[8];
        this.capacity = array.length;
        size = 0;
        nextFirst = capacity - 1;
        nextLast = 0;
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        for (int i = 1; i <= size; i++) {
            a[i] = array[(++nextFirst) % this.capacity];
            this.capacity = capacity;
            nextFirst = 0;//i=1;
            nextLast = size + 1;
            array = a;
        }
    }

    public void addLast(T item) {
        if (size == capacity)
            resize(capacity * 2);
        array[nextLast] = item;
        size = size++;
        nextLast = (nextLast + 1) % capacity;
    }

    public void addFirst(T item) {
        if (size == capacity)
            resize(capacity * 2);
        array[nextFirst] = item;
        size++;
        nextFirst = nextFirst == 0 ? capacity - 1 : nextFirst - 1;//nextFirst=capacity-1;
    }

    public T get(int i) {
        if (i >= size)
            return null;
        return array[(nextFirst + 1 + i) % capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        for (int i = (nextFirst + 1) % capacity; i != nextLast - 1; i = (i + 1) % capacity)
            System.out.print(array[i] + " ");
        System.out.print(array[nextLast - 1]);
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        nextFirst = (nextFirst + 1) % capacity;
        T a = array[nextFirst];
        array[nextFirst] = null;
        size = size - 1;
        if (capacity >= 16 && size < capacity / 4)
            resize(capacity / 2);
        return a;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        nextLast = nextLast == 0 ? capacity - 1 : nextLast - 1;
        T a = array[nextLast];
        array[nextLast] = null;
        size = size - 1;
        if (capacity >= 16 && size < capacity / 4)
            resize(capacity / 2);
        return a;
    }


}

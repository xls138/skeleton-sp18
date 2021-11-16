public interface Deque<Item> {

    public void printDeque();
    public Item getRecursive(int index);
    public Item removeFirst();
    public Item removeLast();
    public void addFirst(Item item);
    public void addLast(Item item);
    public int size();
}

import java.util.Iterator;

/**
 * Deque implementation for Week2.
 *
 * @param <Item> item type
 */
public class Deque<Item> implements Iterable<Item> {

  private Node first;

  private Node last;

  private int size;

  private class Node {

    private Item item;
    private Node previous;
    private Node next;

    public Node(Item item) {
      this.item = item;
    }
  }

  public Deque() {
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  /**
   * Adds the item at the beginning of the queue.
   *
   * @param item an item to be added
   * @throws IllegalArgumentException if the item is null
   */
  public void addFirst(Item item) {
    if (item == null) {
      throw new IllegalArgumentException();
    }
    Node newNode = new Node(item);
    if (isEmpty()) {
      last = newNode;
    } else {
      newNode.next = first;
      first.previous = newNode;
    }
    first = newNode;
    size++;
  }

  /**
   * Adds the item at the end of the queue.
   *
   * @param item an item to be added
   * @throws IllegalArgumentException if the item is null
   */
  public void addLast(Item item) {
    if (item == null) {
      throw new IllegalArgumentException();
    }
    Node newNode = new Node(item);
    if (isEmpty()) {
      first = newNode;
    } else {
      newNode.previous = last;
      last.next = newNode;
    }
    last = newNode;
    size++;
  }

  /**
   * Returns and deletes the first item.
   *
   * @return the first item
   */
  public Item removeFirst() {
    if (isEmpty()) {
      throw new java.util.NoSuchElementException();
    }
    final Item item = first.item;
    size--;
    if (isEmpty()) {
      last = null;
      first = null;
    } else {
      first = first.next;
      first.previous = null;
    }
    return item;
  }

  /**
   * Returns and deletes the last item.
   *
   * @return the last item
   */
  public Item removeLast() {
    if (isEmpty()) {
      throw new java.util.NoSuchElementException();
    }
    final Item item = last.item;
    size--;
    if (isEmpty()) {
      first = null;
      last = null;
    } else {
      last = last.previous;
      last.next = null;
    }
    return item;
  }

  private class DequeIterator implements Iterator<Item> {

    private Node current;

    public DequeIterator(Node current) {
      this.current = current;
    }

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public Item next() {
      if (!hasNext()) {
        throw new java.util.NoSuchElementException();
      }
      Item item = current.item;
      current = current.next;
      return item;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }

  @Override
  public Iterator<Item> iterator() {
    return new DequeIterator(first);
  }

  public static void main(String[] args) {
    Deque<Integer> deque = new Deque<>();
    deque.addFirst(1);
    deque.removeFirst();
    deque.addFirst(3);
  }
}

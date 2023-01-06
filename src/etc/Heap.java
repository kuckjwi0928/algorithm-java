package etc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Heap<T> {
  private static final int DEFAULT_CAPACITY = 10;

  private Object[] elements;

  private final Comparator<? super T> comparator;

  private int size = 0;

  public Heap(Comparator<T> comparator) {
    this.elements = new Object[DEFAULT_CAPACITY];
    this.comparator = comparator;
  }

  public void add(T value) {
    int i = this.size + 1;
    if (i == this.elements.length) {
      grow();
    }
    while (i > 1 && comparator.compare(value, (T) elements[i >>> 1]) < 0) {
      int parentIndex = getParentIndex(i);
      swap(parentIndex, i);
      i = parentIndex;
    }
    this.elements[i] = value;
    size++;
  }

  public T remove() {
    if (Objects.isNull(this.elements[1])) {
      throw new NoSuchElementException();
    }

    T root = this.peek();

    swap(1, size);

    this.elements[size] = null;
    this.size--;

    int parentIndex = 1;
    int childIndex = parentIndex * 2;

    while (childIndex + 1 <= size) {
      if (comparator.compare((T) elements[childIndex + 1], (T) elements[childIndex]) < 0) {
        childIndex = childIndex + 1;
      }

      if (comparator.compare((T) elements[childIndex], (T) elements[parentIndex]) >= 0) {
        break;
      }

      swap(parentIndex, childIndex);

      parentIndex = childIndex;
      childIndex = parentIndex * 2;
    }

    if (elements.length > DEFAULT_CAPACITY && size < elements.length / 4) {
      reduce();
    }

    return root;
  }

  public T peek() {
    return (T) this.elements[1];
  }

  public T getLeft(int index) {
    return (T) this.elements[(index + 1) * 2];
  }

  public T getRight(int index) {
    return (T) this.elements[(index + 1) * 2 + 1];
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public int size() {
    return this.size;
  }

  @Override
  public String toString() {
    return Arrays.toString(elements);
  }

  private int getParentIndex(int index) {
    return index >>> 1;
  }

  private void swap(int from, int to) {
    Object temp = this.elements[from];
    this.elements[from] = this.elements[to];
    this.elements[to] = temp;
  }

  private void grow() {
    int oldCapacity = this.elements.length;
    int newCapacity = oldCapacity * 2;
    this.elements = Arrays.copyOf(this.elements, newCapacity);
  }

  private void reduce() {
    int oldCapacity = this.elements.length;
    int newCapacity = oldCapacity / 2;
    this.elements = Arrays.copyOf(this.elements, newCapacity);
  }

  public static void main(String[] args) {
    Heap<Integer> heap = new Heap<>(Integer::compareTo);
    for (int i = 1; i <= 10; i++) {
      heap.add(i);
    }
    for (int i = 1; i <= 10; i++) {
      heap.remove();
      System.out.println(heap);
    }
  }
}

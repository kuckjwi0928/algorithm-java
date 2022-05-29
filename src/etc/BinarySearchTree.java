package etc;

import java.util.*;

public class BinarySearchTree<T> {
  private final Comparator<? super T> comparator;
  private Node<T> root;

  @SuppressWarnings("unchecked")
  public BinarySearchTree() {
    this.comparator = (e1, e2) -> ((Comparable<? super T>) e1).compareTo(e2);
  }

  public BinarySearchTree(Comparator<? super T> comparator) {
    this.comparator = comparator;
  }

  private static class Node<T> {
    private Node<T> left;
    private Node<T> right;
    private final T value;

    public Node(T value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return "Node{value=" + value + "}";
    }
  }

  public void add(T value) {
    if (Objects.isNull(root)) {
      this.root = new Node<>(value);
    } else {
      Queue<Node<T>> queue = new LinkedList<>();
      queue.offer(root);
      while (!queue.isEmpty()) {
        Node<T> node = queue.poll();
        if (this.comparator.compare(node.value, value) > 0) {
          if (Objects.nonNull(node.left)) {
            queue.offer(node.left);
            continue;
          }
          node.left = new Node<>(value);
        } else {
          if (Objects.nonNull(node.right)) {
            queue.offer(node.right);
            continue;
          }
          node.right = new Node<>(value);
        }
      }
    }
  }

  public void inOrder() {
    inOrder(this.root);
  }

  private void inOrder(Node<T> node) {
    if (Objects.isNull(node)) {
      return;
    }
    inOrder(node.left);
    System.out.println(node.value);
    inOrder(node.right);
  }

  public void addAll(Collection<T> collection) {
    for (T value : collection) {
      this.add(value);
    }
  }

  public static void main(String[] args) {
    BinarySearchTree<Integer> tree = new BinarySearchTree<>();
    tree.addAll(List.of(50,25,75,15,30,70,85,2,18,26,32));
    tree.inOrder();
  }
}

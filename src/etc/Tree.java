package etc;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
  private static class Node {
    private Node left;

    private Node right;

    private int value;

    public Node(int value) {
      this.value = value;
    }
  }

  private Node root;

  public void addNode(int value) {
    if (root == null) {
      root = new Node(value);
    } else {
      Queue<Node> nodeQueue = new LinkedList<>();
      nodeQueue.add(root);

      while (!nodeQueue.isEmpty()) {
        Node node = nodeQueue.poll();

        if (node.left == null) {
          node.left = new Node(value);
          break;
        } else {
          nodeQueue.offer(node.left);
        }

        if (node.right == null) {
          node.right = new Node(value);
          break;
        } else {
          nodeQueue.offer(node.right);
        }
      }
    }
  }

  public void preOrder(Node node) {
    if (node == null) {
      return;
    }
    System.out.print(node.value + " ");
    preOrder(node.left);
    preOrder(node.right);
  }

  public void inOrder(Node node) {
    if (node == null) {
      return;
    }
    preOrder(node.left);
    System.out.print(node.value + " ");
    preOrder(node.right);
  }

  public void postOrder(Node node) {
    if (node == null) {
      return;
    }
    postOrder(node.left);
    postOrder(node.right);
    System.out.print(node.value + " ");
  }

  public static void main(String[] args) {
    Tree tree = new Tree();
    for (int i = 1; i <= 6; i++) {
      tree.addNode(i);
    }
    tree.preOrder(tree.root);
    System.out.println();
    tree.inOrder(tree.root);
    System.out.println();
    tree.postOrder(tree.root);
  }
}

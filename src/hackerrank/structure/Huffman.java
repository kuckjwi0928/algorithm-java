package hackerrank.structure;

import java.util.*;

public class Huffman {
  private Node root;

  private final Map<Character, String> codeMap = new HashMap<>();

  public static void main(String[] args) {
    Huffman huffman = new Huffman();
    System.out.println(huffman.encode("kuckjwi"));
    System.out.println(huffman.decode(huffman.encode("kuckjwi")));
    System.out.println(huffman.encode("isis"));
    System.out.println(huffman.decode(huffman.encode("isis")));
  }

  public String encode(String s) {
    Map<Character, Integer> counterMap = new HashMap<>();
    PriorityQueue<Node> queue = new PriorityQueue<>();

    for (char c : s.toCharArray()) {
      counterMap.put(c, counterMap.getOrDefault(c, 0) + 1);
    }

    for (Map.Entry<Character, Integer> entry : counterMap.entrySet()) {
      queue.offer(new Node(entry.getKey(), entry.getValue()));
    }

    this.root = buildTree(queue);

    makeCodeMap(this.root, "");

    StringBuilder builder = new StringBuilder();
    for (char c : s.toCharArray()) {
      builder.append(codeMap.get(c));
    }
    return builder.toString();
  }

  private Node buildTree(PriorityQueue<Node> queue) {
    if (queue.size() == 1) {
      return queue.poll();
    } else {
      Node left = queue.poll();
      Node right = queue.poll();
      queue.offer(new Node(left, right, left.frequency + right.frequency));
      return buildTree(queue);
    }
  }

  private void makeCodeMap(Node node, String code) {
    if (Objects.isNull(node)) {
      return;
    }

    if (node.data != Character.MIN_VALUE && !node.hanChildNodes()) {
      codeMap.put(node.data, code);
      return;
    }

    makeCodeMap(node.left, code + '0');
    makeCodeMap(node.right, code + '1');
  }

  public String decode(String s) {
    Node node = root;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '0') {
        node = node.left;
      } else {
        node = node.right;
      }
      if (!node.hanChildNodes()) {
        sb.append(node.data);
        node = root;
      }
    }
    return sb.toString();
  }

  private static class Node implements Comparable<Node> {
    private Node left;

    private Node right;

    private final int frequency;

    private final char data;

    public Node(char data, int frequency) {
      this.data = data;
      this.frequency = frequency;
    }

    public Node(Node left, Node right, int frequency) {
      this.left = left;
      this.right = right;
      this.data = Character.MIN_VALUE;
      this.frequency = frequency;
    }

    public boolean hanChildNodes() {
      return Objects.nonNull(left) && Objects.nonNull(right);
    }

    @Override
    public String toString() {
      return "Node{" +
              "left=" + left +
              ", right=" + right +
              ", frequency=" + frequency +
              ", data=" + data +
              '}';
    }

    @Override
    public int compareTo(Node o) {
      return Integer.compare(frequency, o.frequency);
    }
  }
}

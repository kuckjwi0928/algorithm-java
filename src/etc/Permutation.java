package etc;

public class Permutation {
  public static void main(String[] args) {
    int[] arr = new int[]{1,2,3};
    boolean[] visited = new boolean[arr.length];
    new Permutation().permutation(arr, visited, new int[arr.length], 0);
  }

  private void permutation(int[] arr, boolean[] visited, int[] output, int index) {
    if (index == output.length) {
      for (int j : output) {
        System.out.print(j + " ");
      }
      System.out.println();
      return;
    }
    for(int i = 0; i < arr.length; i++) {
      if (visited[i]) {
        continue;
      }
      visited[i] = true;
      output[index] = arr[i];
      permutation(arr, visited, output, index + 1);
      visited[i] = false;
    }
  }
}

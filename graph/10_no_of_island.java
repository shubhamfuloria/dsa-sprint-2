class Program {

  public static void dfs(int[][] array, boolean[][] visited, int row, int col) {

    if (row < 0 || col < 0 || row == array.length || col == array[0].length || array[row][col] == 1
        || visited[row][col] == true) {
      return;
    }

    visited[row][col] = true;
    dfs(array, visited, row - 1, col);
    dfs(array, visited, row, col + 1);
    dfs(array, visited, row + 1, col);
    dfs(array, visited, row, col - 1);
  }

  public static int getNoOfIsland(int[][] array) {

    int row = array.length;
    int col = array[0].length;

    boolean[][] visited = new boolean[row][col];
    int count = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (visited[i][j] == false && array[i][j] == 0) {
          dfs(array, visited, i, j);
          count++;
        }
      }
    }

    return count;
  }

  public static void main(String[] args) {

    int[][] array = { { 0, 0, 1, 0 },
        { 0, 0, 1, 0 },
        { 1, 1, 0, 0 },
        { 1, 0, 1, 0 },
        { 1, 0, 0, 1 } };

    int n = getNoOfIsland(array);
    System.out.println("Number of islands are: " + n);
  }
}
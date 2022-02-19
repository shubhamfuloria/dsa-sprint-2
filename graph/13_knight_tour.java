class Program {

  public static void displayBoard(int[][] chess) {
    for (int[] array : chess) {
      for (int el : array) {
        System.out.print(el + " ");
      }
      System.out.println();
    }
  }

  static int count = 0;

  public static void printKnightTour(int[][] chess, int row, int col, int move) {

    if (row < 0 || col < 0 || row >= chess.length || col >= chess.length || chess[row][col] != 0) {
      return;
    }

    if (move == chess.length * chess.length) {
      chess[row][col] = move;
      displayBoard(chess);
      count++;
      chess[row][col] = 0;
      System.out.println("------------------");
      return;
    }

    chess[row][col] = move;

    printKnightTour(chess, row - 2, col + 1, move + 1);
    printKnightTour(chess, row - 1, col + 2, move + 1);
    printKnightTour(chess, row + 1, col + 2, move + 1);
    printKnightTour(chess, row + 2, col + 1, move + 1);
    printKnightTour(chess, row + 2, col - 1, move + 1);
    printKnightTour(chess, row + 1, col - 2, move + 1);
    printKnightTour(chess, row - 1, col - 2, move + 1);
    printKnightTour(chess, row - 2, col - 1, move + 1);

    chess[row][col] = 0;
  }

  public static void main(String[] args) {
    int n = 5;
    int[][] chess = new int[n][n];
    int row = 0, col = 0;
    printKnightTour(chess, row, col, 1);
    System.out.println();
  }
}
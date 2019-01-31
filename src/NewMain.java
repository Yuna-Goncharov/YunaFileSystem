public class NewMain {

    private static final int BOARD_SIZE = 8;

    public static void main(String[] args) {


        boolean[][] board = findValidCombination();

        StringBuilder sb = new StringBuilder();

        if (board == null) {
            sb.append("No valid solution");
        } else {
            for (boolean[] line : board) {
                for (boolean cell : line) {
                    sb.append(cell ? "Q" : "X");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    private static boolean[][] findValidCombination() {

        boolean[][] board = new boolean[BOARD_SIZE][BOARD_SIZE];

        boolean result = findValidCombination(board, 0, 0);

        if (!result) {
            board = null;
        }

        return board;
    }

    private static boolean findValidCombination(boolean[][] board, int row, int col) {

        boolean result = false;

        if (isValid(board) && isCompleted(board)) {
            result = true;
        } else if (col == BOARD_SIZE) {
            result = false;
        } else if (row == BOARD_SIZE) {
            result = false;
        } else {
            board[row][col] = true;
            if (isValid(board)) {
                findValidCombination(board, row + 1, 0);
            } else {
                board[row][col] = false;
                findValidCombination(board, row, col + 1);
            }
        }

        return result;
    }

    private static boolean isCompleted(boolean[][] board) {

        int counter = 0;

        for (boolean[] line : board) {
            for (boolean cell : line) {
                if (cell) {
                    counter++;
                }
            }
        }

        return counter == BOARD_SIZE;
    }

    private static boolean isValid(boolean[][] board) {

        boolean result;
    }

    private static boolean isRowValid(boolean[][] board) {

        return true;
    }

    private static boolean isColValid(boolean[][] board) {

        return true;
    }

    private static boolean isXValid(boolean[][] board) {

        return true;
    }
}

public class Board {
    private final int width;
    private final int height;
    private int mineCount;
    private Cell[][] board;

    public Board(int width, int height, int mines) {
        this.width = width;
        this.height = height;
        this.mineCount = mines;

        // initiate Cell objects
        for (int x = 0; x < this.height; x++) {
            for (int y = 0; y < this.width; y++) {
                board[x][y] = new Cell();
            }
        }

    }
}
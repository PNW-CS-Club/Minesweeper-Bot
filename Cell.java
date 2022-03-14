public class Cell {
    private char contents;
    private Cell[] adjacentCells;
    private int x;
    private int y;
    private boolean visited;
    private int index;

    /**
     * Default constructor.
     * Constructs Cell object with default content of 'U'.
     */
    public Cell() {
        this('U');
    }

    /**
     * Constructor.
     * Constructs Cell object with specified contents <code>x</code>
     * 
     * @param x char, contents of Cell
     */
    public Cell(char x) {
        this.contents = x;
        this.visited = false;
        this.adjacentCells = new Cell[8];
    }

    /**
     * Get the Cell's content
     * 
     * @return
     */
    public char getContents() {
        return this.contents;
    }

    /**
     * Get index of cell from overall Board position.
     * 
     * @return int, index
     */
    public int getIndex() {
        return this.index;
    }

    /**
     * Returns the adjacentCells object
     * 
     * @return Cell array containing the cell's adjacent cells.
     */
    public Cell[] getAdjacent() {
        return this.adjacentCells;
    }

    /**
     * Get number of of adjacent, unclicked cells
     * 
     * @return int, number of adjacent, unclicked cells
     */
    public int getNumUnlickedAdj() {
        int count = 0;
        for (int i = 0; i < adjacentCells.length; ++i) {
            if (adjacentCells[i] == null)
                continue;

            if (adjacentCells[i].getContents() == 'U')
                count++;
        }
        return count;
    }

    /**
     * Get x-coordinate of Cell
     * 
     * @return int, x-coordinate
     */
    public int getXCoord() {
        return this.x;
    }

    /**
     * Get y-coordinate of Cell
     * 
     * @return int, y-coordinate
     */
    public int getYCoord() {
        return this.y;
    }

    /**
     * Get number of adjacent flags
     * 
     * @return int, number of adjacent flags
     */
    public int getNumAdjFlags() {
        int count = 0;
        for (int i = 0; i < adjacentCells.length; ++i) {
            if (adjacentCells[i] == null || adjacentCells[i].getContents() == 'U'
                    || adjacentCells[i].getContents() == 'E')
                continue;

            if (adjacentCells[i].getContents() == 'F')
                count++;
        }
        return count;
    }

    /**
     * Set contents variable.
     * 
     * @param newContents char, new Cell contents
     */
    public void setContents(char newContents) {
        this.contents = newContents;
    }

    /**
     * Set index of cell from the Board object.
     * 
     * @param index
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * Set screen x and y coordinate of cell.
     * 
     * @param x int, x coordinate
     * @param y int, y coordinate
     */
    public void setCoords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Sets every adjacent cell. Null = edge cases.
     * 
     * @param x Cell array, cells to be set as adjacents.
     */
    public void setAdjacent(Cell[] x) {
        for (int i = 0; i < x.length; ++i) {
            this.adjacentCells[i] = x[i];
        }
    }

    /**
     * Mark cell as visited on the board.
     */
    public void visit() {
        this.visited = true;
    }

    /**
     * Returns if the cell has been visited yet during the solving loop.
     * 
     * @return boolean, true if cell has been visited
     */
    public boolean isVisited() {
        return this.visited;
    }

    /**
     * Resets visited boolean to false.
     */
    public void resetVisited() {
        this.visited = false;
    }

    /**
     * Returns the contents of the cell.
     */
    @Override
    public String toString() {
        return Character.toString(this.contents);
    }
}
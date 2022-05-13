import org.openqa.selenium.WebElement;

public class Cell {
  private char contents;
  private Cell[] adjacentCells;
  private boolean visited;
  private int index;
  private WebElement div;

  /**
   * Constructor.
   * Constructs Cell object with specified contents <code>x</code>
   * 
   * @param x char, contents of Cell
   */
  public Cell(WebElement div) {
    // this.contents = x;
    this.visited = false;
    this.adjacentCells = new Cell[8];
    this.div = div;

    String[] divClass = div.getAttribute("class").split(" ");
    if (divClass[divClass.length - 1].contains("hd_closed"))
      this.contents = 'U';
    else {
      String str = divClass[divClass.length - 1];
      this.contents = str.charAt(str.length() - 1);
    }
  }

  public void updateCellContents(WebElement div) {
    String[] divClass = div.getAttribute("class").split(" ");
    if (divClass[divClass.length - 1].contains("hd_closed"))
      this.contents = 'U';
    else {
      String str = divClass[divClass.length - 1];
      this.contents = str.charAt(str.length() - 1);
    }
  }

  public WebElement getDiv() {
    return this.div;
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
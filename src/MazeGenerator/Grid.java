package MazeGenerator;

import acm.graphics.GCompound;
import acm.graphics.GLine;
import acm.graphics.GRect;

/**
 * Created by DucLe on 11/20/16.
 */
public class Grid extends GCompound {
    //    The arrays to contains the walls in vertical and horizontal directions
    private GLine[][] arrLines_ver, arrLines_hor;
    //    The arrays to hold all the cells of the grid
    private GRect[][] arrCells;
    //    Size of each cell (length of wall), size of the grid (number of cells per edge), coordinate of the grid
    private int cellSize;
    private int size;
    private double x;
    private double y;

    /**
     * The constructor for Grid
     *
     * @param cellSize the size of each cell in grid, i.e., the length of a wall
     * @param size     the size of the the grid (number of cells per edge)
     * @param x        upper-left x-coordinate of the grid
     * @param y        upper-left y-coordinate of the grid
     */
    public Grid(int cellSize, int size, double x, double y) {
        this.cellSize = cellSize;
        this.size = size;
        this.x = x;
        this.y = y;
//      We need to have 10 row of vertical wall, each row has 9 walls
        arrLines_ver = new GLine[size][size - 1];
//      We need to have 9 row of horizontal wall, each row has 10 walls
        arrLines_hor = new GLine[size - 1][size];
        generateLines();
    }

    private void generateLines() {
//         This loop will loop through the grid row by row, so x will be changed, y will be same
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j < size - 1) {
                    arrLines_ver[i][j] = new GLine(x + cellSize + cellSize * j, y + cellSize * i, x + cellSize + cellSize * j, y + cellSize * i + cellSize);
                    add(arrLines_ver[i][j]);
                }
                if (i < size - 1) {
                    arrLines_hor[i][j] = new GLine(x + cellSize * j, y + cellSize + cellSize * i, x + cellSize * j + cellSize, y + cellSize + cellSize * i);
                    add(arrLines_hor[i][j]);
                }
            }
        }
    }
}

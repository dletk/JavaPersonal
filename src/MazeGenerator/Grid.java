package MazeGenerator;

import acm.graphics.*;
import java.util.ArrayList;

/**
 * Created by DucLe on 11/20/16.
 */
public class Grid extends GCompound{

    private GLine[][] arrLines;
    private GRect[][] arrCells;
    private int cellSize;
    private int size;
    private double x;
    private double y;

    public Grid(int cellSize, int size, double x, double y) {
        this.cellSize = cellSize;
        this.size = size;
        this.x = x;
        this.y = y;
        generateLines();
    }

    private void generateLines() {
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                arrLines[i][j] = new GLine(x+5*i,y+5*j,x+5*i,y+5*j+cellSize);
                add(arrLines[i][j]);
            }
        }
    }
}

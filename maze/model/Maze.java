package maze.model;

import java.util.ArrayList;

public class Maze {
  private int height;
  private int width;
  private ArrayList<String> schema;
  private int startX = -1;
  private int startY = -1;

  public Maze(int height, int width, ArrayList<String> schema) {
    this.height = height;
    this.width = width;
    this.schema = schema;
  }

  public int getHeight() {
    return this.height;
  }

  public int getWidth() {
    return this.width;
  }

  public int getStartX() {
    if (this.startX == -1) {
      this.findStart();
    }

    return this.startX;
  }

  public int getStartY() {
    if (this.startY == -1) {
      this.findStart();
    }

    return this.startY;
  }

  public char getPoint(int x, int y) {

    return this.schema.get(x).charAt(y);
  }

  private void findStart() {

    for (int i = 0; i < this.schema.size(); i++) {
      String currentRow = this.schema.get(i);

      if (currentRow.indexOf("$") != -1) {
        this.startX = i;
        this.startY = currentRow.indexOf("$");
      }
    }
  }
}

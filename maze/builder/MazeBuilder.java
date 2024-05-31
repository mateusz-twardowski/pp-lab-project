package maze.builder;

import java.util.ArrayList;

import maze.model.Maze;

public class MazeBuilder {

  public static Maze buildFromStringList(ArrayList<String> list) {

    int[] dimensions = MazeBuilder.getMazeDimensions(list.remove(0));

    return new Maze(dimensions[0], dimensions[1], list);
  }

  public static int[] getMazeDimensions(String row) {

    String[] dimensions = row.split(" ");

    return new int[] { Integer.parseInt(dimensions[0]), Integer.parseInt(dimensions[1]) };
  }
}

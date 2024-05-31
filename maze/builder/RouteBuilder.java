package maze.builder;

import maze.model.Maze;
import maze.model.Route;
import maze.model.Step;

public class RouteBuilder {

  public static Route buildRouteWithStartPoint(Maze maze) {

    return new Route(new Step(maze.getStartX(), maze.getStartY(), "S"));
  }

  public static Route copyRoute(Route route) {

    Route copy = new Route();
    for (Step s : route.getSteps()) {
      copy.addStep(new Step(s));
    }

    return copy;
  }
}

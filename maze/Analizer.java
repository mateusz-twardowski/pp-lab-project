package maze;

import java.util.ArrayList;

import maze.builder.MazeBuilder;
import maze.builder.RouteBuilder;
import maze.model.Maze;
import maze.model.Route;
import maze.model.Step;

public class Analizer {
  private Maze maze;
  private ArrayList<Route> routes;

  public Analizer(ArrayList<String> data) {

    this.maze = MazeBuilder.buildFromStringList(data);
    this.routes = new ArrayList<Route>();
    this.routes.add(RouteBuilder.buildRouteWithStartPoint(maze));
  }

  public String getShortestSuccessRoute() {

    Route route = null;

    for (int i = 0; i < this.routes.size(); i++) {
      if (this.routes.get(i).toString().endsWith("K")
          && (route == null || this.routes.get(i).getSize() < route.getSize())) {
        route = this.routes.get(i);
      }
    }

    return route.toString();
  }

  public void analize() {

    Boolean analizing = true;

    while (analizing) {
      Boolean hasRoutesToAnalize = false;
      for (int i = 0; i < this.routes.size(); i++) {
        Route currentRoute = routes.get(i);
        Step lastPoint = currentRoute.getLastStep();

        if (lastPoint.getStep() == "C" || lastPoint.getStep() == "B" || lastPoint.getStep() == "K") {
          continue;
        }

        hasRoutesToAnalize = true;
        ArrayList<Step> avaliableSteps = new ArrayList<Step>();

        // analize up
        if (lastPoint.getX() > 0 && lastPoint.getStep() != "D") {
          char mazeChar = maze.getPoint(lastPoint.getX() - 1, lastPoint.getY());
          if (mazeChar == '.' || mazeChar == '@') {
            avaliableSteps.add(new Step(lastPoint.getX() - 1, lastPoint.getY(), "G", mazeChar == '@' ? true : false));
          }
        }

        // analize right
        if (lastPoint.getY() < (maze.getWidth() - 1) && lastPoint.getStep() != "L") {
          char mazeChar = maze.getPoint(lastPoint.getX(), lastPoint.getY() + 1);
          if (mazeChar == '.' || mazeChar == '@') {
            avaliableSteps.add(new Step(lastPoint.getX(), lastPoint.getY() + 1, "P", mazeChar == '@' ? true : false));
          }
        }

        // analize down
        if (lastPoint.getX() < (maze.getHeight() - 1) && lastPoint.getStep() != "G") {
          char mazeChar = maze.getPoint(lastPoint.getX() + 1, lastPoint.getY());
          if (mazeChar == '.' || mazeChar == '@') {
            avaliableSteps.add(new Step(lastPoint.getX() + 1, lastPoint.getY(), "D", mazeChar == '@' ? true : false));
          }
        }

        // analize left
        if (lastPoint.getY() > 0 && lastPoint.getStep() != "P") {
          char mazeChar = maze.getPoint(lastPoint.getX(), lastPoint.getY() - 1);
          if (mazeChar == '.' || mazeChar == '@') {
            avaliableSteps.add(new Step(lastPoint.getX(), lastPoint.getY() - 1, "L", mazeChar == '@' ? true : false));
          }
        }

        if (avaliableSteps.isEmpty()) {
          currentRoute.addStep(new Step(lastPoint.getX(), lastPoint.getY(), "B"));
          continue;
        }

        Route currentRouteCopy = RouteBuilder.copyRoute(currentRoute);

        avaliableSteps.forEach((step) -> {
          if (currentRoute.alreadyBeenAt(step)) {
            if (currentRoute.getSize() == currentRouteCopy.getSize()) {
              currentRoute.addStep(new Step(step.getX(), step.getY(), "C"));
            } else {
              Route conflictRoute = RouteBuilder.copyRoute(currentRouteCopy);

              conflictRoute.addStep(new Step(step.getX(), step.getY(), "C"));
              this.routes.add(conflictRoute);
            }
          } else {
            if (currentRoute.getSize() == currentRouteCopy.getSize()) {
              currentRoute.addStep(step);
              if (step.isEnd()) {
                currentRoute.addStep(new Step(step.getX(), step.getY(), "K"));
              }
            } else {
              Route newRoute = RouteBuilder.copyRoute(currentRouteCopy);

              newRoute.addStep(step);

              if (step.isEnd()) {
                newRoute.addStep(new Step(step.getX(), step.getY(), "K"));
              }

              this.routes.add(newRoute);
            }
          }
        });
      }

      if (!hasRoutesToAnalize) {
        analizing = false;
      }
    }
  }
}

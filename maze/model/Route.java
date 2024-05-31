package maze.model;

import java.util.ArrayList;

public class Route {
  private ArrayList<Step> steps;

  public Route() {

    this.steps = new ArrayList<Step>();
  }

  public Route(Step step) {

    this.steps = new ArrayList<Step>();
    this.steps.add(step);
  }

  public ArrayList<Step> getSteps() {

    return this.steps;
  }

  public int getSize() {

    return this.steps.size();
  }

  public Step getLastStep() {

    return this.steps.get(this.steps.size() - 1);
  }

  public boolean alreadyBeenAt(Step step) {

    return this.steps.indexOf(step) != -1;
  }

  public void addStep(Step step) {

    this.steps.add(step);
  }

  public String toString() {

    StringBuilder builder = new StringBuilder();
    this.steps.forEach(builder::append);

    return builder.toString();
  }
}

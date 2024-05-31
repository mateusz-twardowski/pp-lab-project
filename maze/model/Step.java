package maze.model;

public class Step {
  private int x;
  private int y;
  private String step;
  private Boolean isEnd;

  public Step(int x, int y, String step) {
    this.x = x;
    this.y = y;
    this.step = step;
    this.isEnd = false;
  }

  public Step(int x, int y, String step, Boolean isEnd) {
    this.x = x;
    this.y = y;
    this.step = step;
    this.isEnd = isEnd;
  }

  public Step(Step s) {
    this.x = s.getX();
    this.y = s.getY();
    this.step = s.getStep();
  }

  public String getStep() {
    return this.step;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public Boolean isEnd() {
    return this.isEnd;
  }

  public boolean equals(Object o) {
    if (!(o instanceof Step)) {
      return false;
    }

    return this.getX() == ((Step) o).getX() && this.getY() == ((Step) o).getY();
  }

  public String toString() {

    return this.step;
  }
}

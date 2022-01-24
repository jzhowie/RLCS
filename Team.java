public class Team {
  private String name;
  private int points, wins, losses;
  public Team(String n, int i) {
    name = n;
    points = i;
    wins = 0;
    losses = 0;
  }

  public String getName() {
    return name;
  }

  public int getPoints() {
    return points;
  }

  public int getWins() {
    return wins;
  }

  public int getLosses() {
    return losses;
  }
}

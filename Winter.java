import java.util.*;

public class Winter {
  public static void main(String[] args) {
    ArrayList<int[]> group_A = new ArrayList<int[]>();
    ArrayList<int[]> group_B = new ArrayList<int[]>();
    ArrayList<int[]> group_C = new ArrayList<int[]>();
    ArrayList<int[]> group_D = new ArrayList<int[]>();

    populate_groups(group_A, group_B, group_C, group_D);
    play_group(group_A, group_B, group_C, group_D);
    sort_group(group_A, group_B, group_C, group_D);
    print_groups(group_A, group_B, group_C, group_D);
    System.out.println();
    bracket(group_A, group_B, group_C, group_D);
  }

  public static void populate_groups(ArrayList<int[]> a, ArrayList<int[]> b, ArrayList<int[]> c, ArrayList<int[]> d) {
    for (int i = 0; i < 4; i++) {
      a.add(new int[4]);
      b.add(new int[4]);
      c.add(new int[4]);
      d.add(new int[4]);
    }
    a.get(0)[0] = 1;
    b.get(0)[0] = 2;
    c.get(0)[0] = 3;
    d.get(0)[0] = 4;

    d.get(1)[0] = 5;
    c.get(1)[0] = 6;
    b.get(1)[0] = 7;
    a.get(1)[0] = 8;

    b.get(2)[0] = 9;
    a.get(2)[0] = 10;
    d.get(2)[0] = 11;
    c.get(2)[0] = 12;

    c.get(3)[0] = 13;
    d.get(3)[0] = 14;
    a.get(3)[0] = 15;
    b.get(3)[0] = 16;
  }

  public static void print_groups(ArrayList<int[]> a, ArrayList<int[]> b, ArrayList<int[]> c, ArrayList<int[]> d) {
    System.out.println("Seed\tW-L GD\tSeed\tW-L GD\tSeed\tW-L GD\tSeed\tW-L GD");
    for (int i = 0; i < 4; i++) {
      System.out.println(a.get(i)[0] + "\t" + a.get(i)[1] + "-" + a.get(i)[2] + " " + a.get(i)[3] + "\t" + b.get(i)[0] + "\t" + b.get(i)[1] + "-" + b.get(i)[2] + " " + b.get(i)[3] + "\t" + c.get(i)[0] + "\t" + c.get(i)[1] + "-" + c.get(i)[2] + " " + c.get(i)[3] + "\t" + d.get(i)[0] + "\t" + d.get(i)[1] + "-" + d.get(i)[2] + " " + d.get(i)[3]);
    }
  }

  public static void play_group(ArrayList<int[]> a, ArrayList<int[]> b, ArrayList<int[]> c, ArrayList<int[]> d) {
    play_group(a);
    play_group(b);
    play_group(c);
    play_group(d);
  }

  public static void play_group(ArrayList<int[]> g) {
    int[][] matches = new int[6][2];
    for (int i = 0; i < 3; i++) {
      matches[i][0] = g.get(0)[0];
      matches[i+2][1] = g.get(1)[0];
      matches[1+2*i][(i+1)%2] = g.get(2)[0];
    }

    matches[0][1] = g.get(3)[0];
    matches[4][0] = g.get(3)[0];
    matches[5][0] = g.get(3)[0];

    for (int i = 0; i < 6; i++) {
      play_match(matches[i], g);
    }
  }

  public static void play_match(int[] t, ArrayList<int[]> g) {
    int a_index = -1;
    int b_index = -1;

    int games = (int) (Math.random() * 3) + 1;
    boolean win = Math.random() >= (float) (Math.abs(t[0] - t[1]) * -2) / 130 + 0.515;

    for (int i = 0; i < 4; i++) {
      if (g.get(i)[0] == t[0]) {
        a_index = i;
      }
      if (g.get(i)[0] == t[1]) {
        b_index = i;
      }
    }

    if (win) {
      g.get(Math.min(a_index, b_index))[1]++;
      g.get(Math.min(a_index, b_index))[3] = g.get(Math.min(a_index, b_index))[3] + games;
      g.get(Math.max(a_index, b_index))[2]++;
      g.get(Math.max(a_index, b_index))[3] = g.get(Math.max(a_index, b_index))[3] - games;
    }
    else {
      g.get(Math.min(a_index, b_index))[2]++;
      g.get(Math.min(a_index, b_index))[3] = g.get(Math.min(a_index, b_index))[3] - games;
      g.get(Math.max(a_index, b_index))[1]++;
      g.get(Math.max(a_index, b_index))[3] = g.get(Math.max(a_index, b_index))[3] + games;
    }
  }

  public static void sort_group(ArrayList<int[]> a, ArrayList<int[]> b, ArrayList<int[]> c, ArrayList<int[]> d) {
    sort_group(a);
    sort_group(b);
    sort_group(c);
    sort_group(d);
  }

  public static void sort_group(ArrayList<int[]> g) {
    for (int j = 0; j < 3; j++) {
      for (int i = 0; i < 3; i++) {
        if (g.get(i)[1] < g.get(i+1)[1]) {
          int temp[] = g.get(i);
          g.set(i, g.get(i+1));
          g.set(i+1, temp);
        }
      }
    }


    for (int j = 0; j < 3; j++) {
      for (int i = 0; i < 3; i++) {
        if (g.get(i)[1] == g.get(i+1)[1]) {
          if (g.get(i)[3] < g.get(i+1)[3]) {
            int temp[] = g.get(i);
            g.set(i, g.get(i+1));
            g.set(i+1, temp);
          }
        }
      }
    }


    // needs work
    for (int i = 0; i < 3; i++) {
      if (g.get(i)[1] == g.get(i+1)[1]) {
        boolean win = Math.random() >= (float) (Math.abs(g.get(i)[0] - g.get(i+1)[0]) * -2) / 130 + 0.515;
        if (!win) {
          int temp[] = g.get(i);
          g.set(i, g.get(i+1));
          g.set(i+1, temp);
        }
      }
      i++;
    }
  }

  public static void bracket(ArrayList<int[]> a, ArrayList<int[]> b, ArrayList<int[]> c, ArrayList<int[]> d) {
    ArrayList<Integer> winners = new ArrayList<Integer>();
    winners.add(a.get(0)[0]);
    winners.add(d.get(0)[0]);
    winners.add(b.get(0)[0]);
    winners.add(c.get(0)[0]);

    ArrayList<Integer> losers = new ArrayList<Integer>();
    losers.add(b.get(1)[0]);
    losers.add(a.get(2)[0]);
    losers.add(c.get(1)[0]);
    losers.add(d.get(2)[0]);
    losers.add(a.get(1)[0]);
    losers.add(b.get(2)[0]);
    losers.add(d.get(1)[0]);
    losers.add(c.get(2)[0]);

    ArrayList<Integer> rank = new ArrayList<Integer>();
    rank.add(a.get(3)[0]);
    rank.add(b.get(3)[0]);
    rank.add(c.get(3)[0]);
    rank.add(d.get(3)[0]);

    //int size = winners.size();

    //size = losers.size();

    //LOSER'S ROUND 1 & 2
    for (int j = 0; j < 2; j++) {
      for (int i = 0; i < losers.size(); i++) {
        boolean win = Math.random() >= (float) (Math.abs(losers.get(i) - losers.get(i+1)) * -2) / 130 + 0.515;
        if (win) {
          int temp = Math.max(losers.get(i), losers.get(i+1));
          losers.remove(Math.max(losers.get(i), losers.get(i+1)));
          rank.add(0, temp);
        }
        else {
          int temp = Math.min(losers.get(i), losers.get(i+1));
          losers.remove(Math.min(losers.get(i), losers.get(i+1)));
          rank.add(0, temp);
        }
      }
    }

    // WINNER'S QF
    for (int i = 0; i < winners.size(); i++) {
      boolean win = Math.random() >= (float) (Math.abs(winners.get(i) - winners.get(i+1)) * -2) / 130 + 0.5;
      if (win) {
        int temp = winners.get(i+1);
        winners.remove(winners.get(i+1));
        losers.add(temp);
      }
      else {
        int temp = winners.get(i);
        winners.remove(winners.get(i));
        losers.add(temp);
      }
    }

    // LOSER'S QF

    int swap = losers.get(1);
    losers.remove(1);
    losers.add(swap);

    for (int i = 0; i < losers.size(); i++) {
      boolean win = Math.random() >= (float) (Math.abs(losers.get(i) - losers.get(i+1)) * -2) / 130 + 0.515;
      if (win) {
        int temp = losers.get(i+1);
        losers.remove(losers.get(i+1));
        rank.add(0, temp);
      }
      else {
        int temp = losers.get(i);
        losers.remove(losers.get(i));
        rank.add(0, temp);
      }
    }

    // LOSER'S PRESEMIFINAL
    boolean win = Math.random() >= (float) (Math.abs(losers.get(0) - losers.get(1)) * -2) / 130 + 0.515;
    if (win) {
      int temp = losers.get(1);
      losers.remove(losers.get(1));
      rank.add(0, temp);
    }
    else {
      int temp = losers.get(0);
      losers.remove(losers.get(0));
      rank.add(0, temp);
    }

    // WINNER'S SEMIFINALS
    win = Math.random() >= (float) (Math.abs(winners.get(0) - winners.get(1)) * -2) / 130 + 0.5;
    if (win) {
      int temp = winners.get(1);
      winners.remove(winners.get(1));
      losers.add(temp);
    }
    else {
      int temp = winners.get(0);
      winners.remove(winners.get(0));
      losers.add(temp);
    }

    // LOSER'S SEMIFINALS
    win = Math.random() >= (float) (Math.abs(losers.get(0) - losers.get(1)) * -2) / 130 + 0.515;
    if (win) {
      int temp = losers.get(1);
      losers.remove(losers.get(1));
      rank.add(0, temp);
    }
    else {
      int temp = losers.get(0);
      losers.remove(losers.get(0));
      rank.add(0, temp);
    }

    // GRAND FINALS

    for (int i = 0; i < winners.size(); i++) {
      System.out.println(winners.get(i));
    }
    System.out.println();
    for (int i = 0; i < losers.size(); i++) {
      System.out.println(losers.get(i));
    }
    System.out.println();
    for (int i = 0; i < rank.size(); i++) {
      System.out.println(rank.get(i));
    }
  }
}

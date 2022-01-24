import java.util.*;

public class Winter {
  public static void main(String[] args) {
    ArrayList<int[]> group_A = new ArrayList<int[]>();
    ArrayList<int[]> group_B = new ArrayList<int[]>();
    ArrayList<int[]> group_C = new ArrayList<int[]>();
    ArrayList<int[]> group_D = new ArrayList<int[]>();

    populate_groups(group_A, group_B, group_C, group_D);
    print_groups(group_A, group_B, group_C, group_D);
    play_group(group_A);
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

  public static void play_group(ArrayList<int[]> g) {
    int[][] matches = new int[6][2];
    for (int i = 0; i < 6; i++) {
      System.out.println(Arrays.toString(matches[i]));
    }
  }
}

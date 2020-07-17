package exercises;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

/**
 * 2.3.5 Give a code fragment that sorts an array that is known to consist of items having
 * just two distinct keys.
 */
public class QuickTwoDistinctKeys {
  private static int cost;

  private static Comparable small;
  private static Comparable large;

  @Test
  public void sort_twoKeysArray4_isSorted() {
    sortArrayFromFile("array4.txt");
  }

  @Test
  public void sort_twoKeysArray5_isSorted() {
    sortArrayFromFile("array5.txt");
  }

  @Test
  public void sort_twoKeysArray6_isSorted() {
    sortArrayFromFile("array6.txt");
  }

  @Test
  public void sort_twoKeysArray7_isSorted() {
    sortArrayFromFile("array7.txt");
  }

  @Test
  public void sort_twoKeysArray8_isSorted() {
    sortArrayFromFile("array8.txt");
  }

  @Test
  public void sort_twoKeysArray9_isSorted() {
    sortArrayFromFile("array9.txt");
  }

  @Test
  public void sort_twoKeysArray10_isSorted() {
    sortArrayFromFile("array10.txt");
  }

  private void sortArrayFromFile(String s) {
    In in = new In(s);
    String[] a = in.readAllStrings();
    sort((Comparable[]) a);
    show(a);
    assert isSorted(a);
    StdOut.println("Cost for sort is: " + cost);
  }

  private static void sort(Comparable[] a) {
    cost = 0;
    Comparable differentThanTheFirstOne;
    int i = 0;
    while (a[0].equals(a[++i]));
    differentThanTheFirstOne = a[i];
    if (less(a[0], differentThanTheFirstOne) ) {
      small = a[0];
      large = differentThanTheFirstOne;
    } else {
      small = differentThanTheFirstOne;
      large = a[0];
    }
    sort(a, 0, a.length - 1);
  }

  private static void sort(Comparable[] a, int lo, int hi) {
    if (lo >= hi) {
      return;
    }

    if ( less(a[hi], a[lo]) ) {
      exch(a, hi--, lo++);
    } else if ( equals(a[hi], a[lo]) && a[lo].equals(small)) {
      lo++;
    } else if ( equals(a[hi], a[lo]) && a[lo].equals(large)) {
      hi--;
    } else {
      lo++;
      hi--;
    }

    sort(a, lo, hi);
  }

  private static void exch(Comparable[] a, int i, int j) {
    cost++;
    Comparable t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  private static boolean less(Comparable v, Comparable w) {
    cost++;
    return v.compareTo(w) < 0;
  }

  private static boolean equals(Comparable v, Comparable w) {
    cost++;
    return v.compareTo(w) == 0;
  }

  private static void show(Comparable[] a) {
    for (int i = 0; i < a.length; i++) {
      StdOut.print(a[i] + " ");
    }
    StdOut.println();
  }

  private static boolean isSorted(Comparable[] a) {
    for (int i = 1; i < a.length; i++) {
      if (less(a[i], a[i-1])) {
        return false;
      }
    }
    return true;
  }

}

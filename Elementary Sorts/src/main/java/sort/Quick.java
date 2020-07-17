package sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 2.3.1 Show, in the style of the trace given with partition() , how that method
 * partitions the array E A S Y Q U E S T I O N .
 *
 *                               00 01 02 03 04 05 06 07 08 09 10 11
 * initial values           0 11  E  A  S  Y  Q  U  E  S  T  I  O  N
 * exchange 02 and 07       0 11  E  A  E  Y  Q  U  S  S  T  I  O  N
 * exchange 00 and 02       0 11  E  A  E  Y  Q  U  S  S  T  I  O  N
 * return position of j                 -
 *
 * 2.3.2 Show, in the style of the quicksort trace given in this section, how quicksort sorts
 * the array E A S Y Q U E S T I O N (for the purposes of this exercise, ignore the
 * initial shuffle).
 *
 * lo   j   hi                   00 01 02 03 04 05 06 07 08 09 10 11
 *                          0 11  E  A  S  Y  Q  U  E  S  T  I  O  N
 * 00  02   11              0 11  E  A  E  Y  Q  U  S  S  T  I  O  N
 * 00  01   01              0 11  A  E  E  Y  Q  U  S  S  T  I  O  N
 * 03  11   11              0 11  A  E  E  Q  U  S  S  T  I  O  N  Y
 * 03  06   10              0 11  A  E  E  I  N  O  Q  T  S  S  U  Y
 * 03  03   05              0 11  A  E  E  I  N  O  Q  T  S  S  U  Y
 * 07  09   11              0 11  A  E  E  I  N  O  Q  S  S  T  U  Y
 *
 * 2.3.3 What is the maximum number of times during the execution of Quick.sort()
 * that the largest item can be exchanged, for an array of length N ?
 *
 * Answer: N - 1
 *
 */
public class Quick {

  public static int cost;

  public static void sort(Comparable[] a) {
    StdRandom.shuffle(a);
    sort(a, 0, a.length - 1);
  }

  public static void sortWithoutShuffle(Comparable[] a) {
    cost = 0;
    sort(a, 0, a.length - 1);
  }

  private static void sort(Comparable[] a, int lo, int hi) {
    if (hi <= lo) {
      return;
    }
    int j = partition(a, lo, hi);
    sort(a, lo, j - 1);
    sort(a, j + 1, hi);
  }

  private static int partition(Comparable[] a, int lo, int hi) {
    int i = lo;
    int j = hi + 1;
    Comparable v = a[lo];

    while(true) {
      while (less(a[++i], v)) {
        if (i == hi) break;
      }

      while (less(v, a[--j])) {
        if (j == lo) break;
      }

      if (i >= j) break;
      exch(a, i, j);
    }
    exch(a, lo, j);
    return j;
  }

  private static void exch(Comparable[] a, int i, int j) {
    cost++;
    Comparable t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  private static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  public static void show(Comparable[] a) {
    for (int i = 0; i < a.length; i++) {
      StdOut.print(a[i] + " ");
    }
    StdOut.println();
  }

  public static boolean isSorted(Comparable[] a) {
    for (int i = 1; i < a.length; i++) {
      if (less(a[i], a[i-1])) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    In in = new In("tiny.txt");
    String[] a = in.readAllStrings();
    sort(a);
    assert isSorted(a);
    show(a);
  }
}

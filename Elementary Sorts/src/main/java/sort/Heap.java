package sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Heap {
  public static int costForExchange;
  public static int costForCompare;

  public static void sort(Comparable[] a) {
    int N = a.length - 1;

    for (int k = N/2; k >= 1; k--) {
      sink(a, k, N);
    }
    while (N > 1) {
      exch(a, 1, N--);
      sink(a, 1, N);
    }
  }

  private static void sink(Comparable[] a, int k, int n) {
    while (k*2 <= n) {
      int j = 2*k;
      if (j < n && less(a[j], a[j+1])) j++;
      if (!less(a[k], a[j])) break;
      exch(a, k, j);
      k = j;
    }
  }

  private static void exch(Comparable[] a, int i, int j) {
    costForExchange++;
    Comparable t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  private static boolean less(Comparable v, Comparable w) {
    costForCompare++;
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
    String zero = "";
    String[] input = in.readAllStrings();
    String[] a = new String[input.length + 1];
    a[0] = zero;
    for (int i = 1; i < input.length + 1; i++) {
      a[i] = input[i-1];
    }
    sort(a);
    assert isSorted(a);
    show(a);
  }
}

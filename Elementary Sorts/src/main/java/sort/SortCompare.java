package sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {
  public static double time(String alg, Double[] a) {
    Stopwatch stopwatch = new Stopwatch();
    if (alg.equals("Selection")) {
      Selection.sort(a);
      assert Selection.isSorted(a);
    } else if (alg.equals("Insertion")) {
      Insertion.sort(a);
      assert Insertion.isSorted(a);
    } else if (alg.equals("Shell")) {
      Shell.sort(a);
      assert Shell.isSorted(a);
    } else if (alg.equals("Merge")) {
      Merge.sort(a);
      assert Merge.isSorted(a);
    } else if (alg.equals("MergeBU")) {
      MergeBU.sort(a);
      assert MergeBU.isSorted(a);
    } else if (alg.equals("Quick")) {
      Quick.sort(a);
      assert Quick.isSorted(a);
    } else {
      throw new RuntimeException("Algorhithm " + alg + " not suported!");
    }
  return stopwatch.elapsedTime();
  }

  public static double timeRandomInput(String alg, int N, int T) {
    double total = 0.0;
    Double[] a = new Double[N];

    for (int t = 0; t < T; t++) {
      for (int i = 0; i < N; i++) {
        a[i] = StdRandom.uniform();
      }
      total += time(alg, a);
    }
    return total;
  }

  private static void show(Comparable[] a) {
    for (int i = 0; i < a.length; i++) {
      StdOut.print(a[i] + " ");
    }
    StdOut.println();
  }

  public static void main(String[] args) {
    String alg1 = args[0];
    String alg2 = args[1];
    int N = Integer.parseInt(args[2]);
    int T = Integer.parseInt(args[3]);
    double t1 = timeRandomInput(alg1, N, T);
    double t2 = timeRandomInput(alg2, N, T);
    StdOut.printf("For %d random Doubles %s is", N, alg1);
    StdOut.printf(" %.1f times faster than %s\n", t2/t1, alg2);
  }
}

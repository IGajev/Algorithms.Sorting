package exercises;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;
import sort.Quick;

/**
 * 2.3.4 Suppose that the initial random shuffle is omitted. Give six arrays of ten elements
 * for which Quick.sort() uses the worst-case number of compares.
 *
 * Answer:  00 01 02 03 04 05 06 07 08 09 10
 *           K  K  K  K  K  K  K  K  K  K  K
 */
public class QuickTest {

  @Test
  public void sortWithoutShuffle_quickSortTest1() {
    sortArrayFromFile("array1.txt");
  }

  @Test
  public void sortWithoutShuffle_quickSortTest2() {
    sortArrayFromFile("array2.txt");
  }

  @Test
  public void sortWithoutShuffle_quickSortTest3() {
    sortArrayFromFile("array3.txt");
  }

  private void sortArrayFromFile(String s) {
    In in = new In(s);
    String[] a = in.readAllStrings();
    Quick.sortWithoutShuffle(a);
    Quick.show(a);
    assert Quick.isSorted(a);
    StdOut.println("Cost for exchange is: " + Quick.costForExchange);
    StdOut.println("Cost for compare  is: " + Quick.costForCompare);
  }
}

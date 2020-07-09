package exercises;

import edu.princeton.cs.algs4.In;
import org.junit.Test;
import sort.Insertion;
import sort.Selection;
import sort.Shell;

public class SortingTest {

  @Test
  public void sort_selectionSortTest() {
    In in = new In("tiny.txt");
    String[] a = in.readAllStrings();
    Selection.sort(a);
    assert Selection.isSorted(a);
  }

  @Test
  public void sort_insertionSortTest() {
    In in = new In("tiny.txt");
    String[] a = in.readAllStrings();
    Insertion.sort(a);
    assert Insertion.isSorted(a);
  }

  @Test
  public void sort_shellSortTest() {
    In in = new In("tiny.txt");
    String[] a = in.readAllStrings();
    Shell.sort(a);
    assert Shell.isSorted(a);
  }
}

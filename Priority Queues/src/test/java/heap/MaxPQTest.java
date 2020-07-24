package heap;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Transaction;
import org.junit.Test;

public class MaxPQTest {
  @Test
  public void test() {
    In in = new In("tinyBatch.txt");
    int M = 5;
    MaxPQ<Transaction> maxPq = new MaxPQ(M + 1);

    while(!in.isEmpty()){
      maxPq.insert(new Transaction(in.readLine()));
      if (maxPq.size() > M) {
        maxPq.delMax();
      }
    }
    for (int i = 0; i < M; i++) {
      System.out.println(maxPq.delMax());
    }
  }
}

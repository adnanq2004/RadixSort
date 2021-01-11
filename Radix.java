import java.util.*;

public class Radix{

  public static int nth(int n, int col) {
    if (col == 0) {
      return n % 10;
    }
    else {
      double div = Math.pow(10,col+1);
      double f = n % div;
      double e = n % Math.pow(10,col -1);
      f -= e;
      f = f / Math.pow(10, col);
      int val = (int)f;
      return val;
    }
  }

  public static int length(int n) {
    double rough = Math.log10(n);
    int val = (int)rough;
    return val;
  }

}

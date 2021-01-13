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
    val++;
    return val;
  }

	public static void merge(MyLinkedList original, MyLinkedList[]buckets) {
		for (int i = 0; i < buckets.length; i++) {
			original.extend(buckets[i]);
		}
	}

	public static void merge(SortableLinkedList original, SortableLinkedList[] buckets) {
		for (int i = 0; i < buckets.length; i++) {
			original.extend(buckets[i]);
		}
	}

	public static void radixSortSimple(SortableLinkedList data) {
	
		SortableLinkedList bucket0 = new SortableLinkedList();
		SortableLinkedList bucket1 = new SortableLinkedList();
		SortableLinkedList bucket2 = new SortableLinkedList();
		SortableLinkedList bucket3 = new SortableLinkedList();
		SortableLinkedList bucket4 = new SortableLinkedList();
		SortableLinkedList bucket5 = new SortableLinkedList();
		SortableLinkedList bucket6 = new SortableLinkedList();
		SortableLinkedList bucket7 = new SortableLinkedList();
		SortableLinkedList bucket8 = new SortableLinkedList();
		SortableLinkedList bucket9 = new SortableLinkedList();

		SortableLinkedList[] buckets= new SortableLinkedList[10];
		buckets[0] = bucket0;
		buckets[1] = bucket1;
		buckets[2] = bucket2;
		buckets[3] = bucket3;
		buckets[4] = bucket4;
		buckets[5] = bucket5;
		buckets[6] = bucket6;
		buckets[7] = bucket7;
		buckets[8] = bucket8;
		buckets[9] = bucket9;
		
		SortableLinkedList main = new SortableLinkedList();

		int max = greatestdig(data);
		for(int i = 0; i < max; i++) {
			for (int j = 0; j < data.size(); j++) {
				int column = nth(data.get(j), i);
				buckets[column].add(data.get(j));
			}
			main.extend(data);
			merge(data, buckets);
		}
		System.out.println(data);
	}

	private static int greatestdig(SortableLinkedList list) {
		int greatest = 0;
		for (int i = 0; i < list.size(); i++) {
			if (length(list.get(i)) > greatest) {
				greatest = length(list.get(i));
			}
		}
		return greatest;
	}

}

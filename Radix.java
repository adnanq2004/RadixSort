import java.util.*;

public class Radix{

  public static int nth(int n, int col) {
    if (col > length(n)) {
    	// throw new IndexOutOfBoundsException("Index Out Of Bounds");
      return 0;
    }
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

	/*public static void merge(MyLinkedList original, MyLinkedList[]buckets) {
		for (int i = 0; i < buckets.length; i++) {
			original.extend(buckets[i]);
		}
	}*/

	public static void merge(SortableLinkedList original, SortableLinkedList[] buckets) {
		for (int i = 0; i < buckets.length; i++) {
			original.extend(buckets[i]);
		}
	}

	public static void radixSortSimple(SortableLinkedList data) {

		SortableLinkedList[] buckets= new SortableLinkedList[10];
    for (int i = 0; i < 10; i++) {
      SortableLinkedList temp = new SortableLinkedList();
      buckets[i] = temp;
    }

		SortableLinkedList main = new SortableLinkedList();

		int max = greatestdig(data);
		for(int i = 0; i < max; i++) {
			// for (int j = 0; j < data.size(); j++) {
			// 	int column = nth(data.get(j), i);
			// 	buckets[column].add(data.get(j));
			// }
      while (data.size() > 0) {
        int temp = data.remove(0);
        int column = nth(temp, i);
        buckets[column].add(temp);
      }
			// main.extend(data);
			merge(data, buckets);
      // for (int n = 0; n < buckets.length; n++) {
      //   main.extend(buckets[n]);
      // }
		}
	}

	public static void radixSort(SortableLinkedList data) {
		SortableLinkedList bucketnegative = new SortableLinkedList();
		SortableLinkedList bucketnonnegative = new SortableLinkedList();
		SortableLinkedList[] buckets2 = new SortableLinkedList[2];
		buckets2[0] = bucketnegative;
		buckets2[1] = bucketnonnegative;

		while (data.size() > 0){
			// if (data.get(i) < 0) {
			// 	buckets2[0].add(data.get(i));
			// }
			// else {
			// 	buckets2[1].add(data.get(i));
			// }
      int temp = data.remove(0);
      if (temp < 0) {
        buckets2[0].add(temp);
      }
      else {
        buckets2[1].add(temp);
      }
		}

		radixSortSimple(buckets2[1]);

    SortableLinkedList[] buckets= new SortableLinkedList[10];

    for (int i = 0; i < 10; i++) {
      SortableLinkedList temp = new SortableLinkedList();
      buckets[i] = temp;
    }

		SortableLinkedList trash = new SortableLinkedList();

		int max2 = greatestdig(buckets2[0]);
		for (int i = 0; i < max2; i++) {
			// for (int j = 0; j < buckets2[0].size(); j++) {
      while (buckets2[0].size() > 0) {
				int temp = buckets2[0].remove(0);
				int column = nth( Math.abs(temp), i);
				buckets[column].add(temp);
			}
			// trash.extend(buckets2[0]);
			reversemerge(buckets2[0], buckets);
			// for (int n = 0; n < buckets.length; n++) {
			// 	trash.extend(buckets[n]);
			// }
		}

		// trash.extend(data);
		merge(data, buckets2);

	}

	private static void reversemerge(SortableLinkedList original, SortableLinkedList[] buckets) {
		for (int i = buckets.length -1; i >= 0; i--) {
                        original.extend(buckets[i]);
                }
	}

	private static int greatestdig(SortableLinkedList list) {
		int greatest = 0;
		// for (int i = 0; i < list.size(); i++) {
		// 	if (length(list.get(i)) > greatest) {
		// 		greatest = length(list.get(i));
		// 	}
		// }
    for (int i = 0; i < list.size(); i++) {
      int temp = list.remove(0);
      if (length(temp) > greatest) {
        greatest = length(temp);
      }
      list.add(temp);
    }
		return greatest;
	}

}

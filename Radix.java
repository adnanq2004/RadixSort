import java.util.*;

public class Radix{

  public static int nth(int n, int col) {
    if (col > length(n)) {
    	throw new IndexOutOfBoundsException("Index Out Of Bounds");
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
	}

	private static SortableLinkedList thing(SortableLinkedList data) {

		
                /*SortableLinkedList bucket0 = new SortableLinkedList();
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
                }*/
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
                        merge(data,buckets);
                        for (int n = 0; n < buckets.length; n++) {
                                main.extend(buckets[n]);
			}
		}
		return data;
	}

	public static void radixSort(SortableLinkedList data) {
		
		/*SortableLinkedList bucket0 = new SortableLinkedList();
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
			merge(data,buckets)
			for (int n = 0; n < buckets.length; n++) 
				main.extend(buckets[n]);
			{
                }*/

		//radixSortSimple(data);

		

		SortableLinkedList bucketnegative = new SortableLinkedList();
		SortableLinkedList bucketnonnegative = new SortableLinkedList();
		SortableLinkedList[] buckets2 = new SortableLinkedList[2];
		buckets2[0] = bucketnegative;
		buckets2[1] = bucketnonnegative;

		for (int i = 0; i < data.size(); i++) {
			if (data.get(i) < 0) {
				buckets2[0].add(data.get(i));
			}
			else {
				buckets2[1].add(data.get(i));
			}
		}

		radixSortSimple(buckets2[1]);

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

		/*buckets[0] = bucket9;
		buckets[1] = bucket8;
		buckets[2] = bucket7;
		buckets[3] = bucket6;
		buckets[4] = bucket5;
		buckets[5] = bucket4;
		buckets[6] = bucket3;
		buckets[7] = bucket2;
		buckets[8] = bucket1;
		buckets[9] = bucket0;*/

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
		
		SortableLinkedList trash = new SortableLinkedList();

		int max2 = greatestdig(buckets2[0]);
		for (int i = 0; i < max2; i++) {
			for (int j = 0; j < buckets2[0].size(); j++) {
				int temp = Math.abs(buckets2[0].get(j));
				int column = nth(temp, i);
				buckets[column].add(buckets2[0].get(j));
			}
			trash.extend(buckets2[0]);
			reversemerge(buckets2[0], buckets);
			for (int n = 0; n < buckets.length; n++) {
				trash.extend(buckets[n]);
			}
		}

		trash.extend(data);
		merge(data, buckets2);

	}

	private static void reversemerge(SortableLinkedList original, SortableLinkedList[] buckets) {
		for (int i = buckets.length -1; i >= 0; i--) {
                        original.extend(buckets[i]);
                }
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

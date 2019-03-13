import java.util.*;

public class Quick {

  public static int partition (int [] data, int start, int end) {
   // generate random pivot index
   int pivot = (int)(Math.random() * (end - start + 1)) + start;
  // System.out.println("Pivot: " +pivot);
   // bring pivot element to index 0
   int temp = data[start];
   if (pivot != start) {
     data[start] = data[pivot];
     data[pivot] = temp;
     // variables
     pivot = start;
     start += 1;
   }
  // System.out.println("O: " + Arrays.toString(data));
   while (start != end) {
     if (data[start] > data[pivot]) {
       // switch start and end
       int t = data[end];
       data[end] = data[start];
       data[start] = t;
       end -= 1;
     } else {
       start += 1;
     }
    // System.out.println("A:"+Arrays.toString(data)+ " "+ start+", "+ end);
   }
   // switching pivot to the right place
   if (data[start] <= data[pivot]) {
     //System.out.println("blah");
     int t = data[start];
     data[start] = data[pivot];
     data[pivot] = t;
     pivot = start;
   } else {
    // System.out.println("lah");
     int t = data[start-1];
     data[start-1] = data[pivot];
     data[pivot] = t;
     pivot = start-1;
   }
  // System.out.println(Arrays.toString(data));
   return pivot;
 }

 /*return the value that is the kth smallest value of the array.
 */
 public static int quickselect (int[] data, int k){
   int start = 0;
   int end = data.length - 1;
   int pivot = partition(data, start, end);
   while (pivot != k) {
    // System.out.println(Arrays.toString(data)+": "+start+","+end);
     if (pivot > k) {
       end = pivot - 1;
     } else {
       start = pivot + 1;
     }
     //System.out.println(start+","+end);
    // System.out.println("Data: "+Arrays.toString(data));
     pivot = partition(data, start, end);
   }
   return data[pivot];
 }

 private static int[] partitionDutch(int[] data, int lo, int hi){
   int lt = lo;
   int gt = hi;
   int i = lt + 1;
   int pivot = lo;
   while (i <= gt) {
     if (data[i] < data[pivot]) {
       int t = data[lt];
       data[lt] = data[i]; // switches lt and i
       data[i] = t;
       lt++; // lt moves up one, since element switched to lt not equal to pivot
       i++; // move up the current element
       pivot++; // pivot moved
     } else if (data[i] == data[pivot]) {
       i++; // just move up the current element, this one can stay where it is
     } else { // data[i] > data[pivot]
       int t = data[gt];
       data[gt] = data[i]; // swap end of sequence of numbers same as pivot
       data[i] = t;
       gt--; // gt moves down one, since element switched to gt not equal to pivot
     }
   }
   return new int[] { lt, gt };
 }

 public static void quicksort(int[] data, int lo, int hi) {
   if (lo >= hi) {
     return;
   }
   int p = partition(data, lo, hi);
   quicksort(data, lo, p-1);
   quicksort(data, p+1, hi);
 }

 public static void main(String[] args) {
   int[] test = new int[] { 2, 3, 4, 6, 1, 8, 9, 5, 7 };
   int[] t = new int[] { 5, 3, 4, 5, 1, 2, 5, 7, 5, 6 };
   // sorted { 1, 2, 3, 4, 5, 6, 7, 8, 9 }
   // sorted { 1, 2, 3, 4, 5, 5, 5, 5, 6, 7 }
   System.out.println(Arrays.toString(Quick.partitionDutch(t, 0, 9)));
  /* for (int i = 0; i < 9; i++) {
     System.out.println(Quick.quickselect(t,i));
     System.out.println(Arrays.toString(t));
   }
   System.out.println(Arrays.toString(t)); */
 }
}

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
   //int pivot = partition(data, start, end);
   int[] pivots = partitionDutch(data,start,end);
//   System.out.println(Arrays.toString(pivots));
   while (!(pivots[0] <= k && pivots[1] > k) && start != end) {
  //   System.out.println(Arrays.toString(data)+": "+start+","+end);
     if (pivots[0] > k) {
       end = pivots[0] - 1;
     } else {
       start = pivots[1];
     }
     //System.out.println(start+","+end);
    // System.out.println("Data: "+Arrays.toString(data));
     pivots = partitionDutch(data, start, end);
   }
  // System.out.println(Arrays.toString(data)+": "+start+","+end);
   return data[pivots[0]];
 // return quickH(data,k,0,data.length-1);
 }

 private static int[] partitionDutch(int[] data, int lo, int hi){
   
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
   for (int i = 0; i < 9; i++) {
     System.out.println(Quick.quickselect(t,i));
     System.out.println(Arrays.toString(t));
   }
  /* System.out.println(Quick.quickselect(t, 0));
   System.out.println(Quick.quickselect(t, 1));
   System.out.println(Quick.quickselect(t, 2));
   System.out.println(Quick.quickselect(t, 3));
   System.out.println(Quick.quickselect(t, 4));
   System.out.println(Quick.quickselect(t, 5));
   System.out.println(Quick.quickselect(t, 6));
   System.out.println(Quick.quickselect(t, 7));
   System.out.println(Quick.quickselect(t, 8));
  //  System.out.println(Quick.partition(test, 3, 8));
//  System.out.println(Arrays.toString(Quick.partitionDutch(t, 0, 9)));
//  Quick.quicksort(t,0,9);
  System.out.println(Arrays.toString(t)); */
 }
}

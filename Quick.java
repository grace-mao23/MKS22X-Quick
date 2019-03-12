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
 // return quickH(data,k,0,data.length-1);
 }
 /*
 public static int quickH(int[] data, int k, int start, int end) {
   int pivot = partition(data,start,end);
   if (pivot == k) {
     return data[pivot];
   }
   if (pivot < k) {
     return quickH(data, k, pivot + 1, end);
   }
   return quickH(data, k, start, pivot - 1);
 }*/

 private int[] partitionDutch(int[] data, int lo, int hi){
   // generate random pivot index
   int pivot = (int)(Math.random() * (hi - lo + 1)) + lo;
   // swtiched pivot to start
   int temp = data[lo];
   if (pivot != lo) {
     data[lo] = data[pivot];
     data[pivot] = temp;
     pivot = lo;
     lo += 1;
   }
   int same = pivot;
   while (lo != hi) {
     if (data[lo] < data[pivot]) {
       lo++;
     } else if (data[lo] == data[pivot]) {
       same = lo;
       lo++;
     } else {
       int t = data[lo];
       data[lo] = data[hi];
       data[hi] = t;
       hi--;
     }
   }
   return new int[2];
     //your code
     //return an array [lt,gt]
 }

 public static void main(String[] args) {
   int[] test = new int[] { 2, 3, 4, 6, 1, 8, 9, 5, 7 };
   // sorted { 1, 2, 3, 4, 5, 6, 7, 8, 9 }
   System.out.println(Quick.quickselect(test, 0));
   System.out.println(Quick.quickselect(test, 1));
   System.out.println(Quick.quickselect(test, 2));
   System.out.println(Quick.quickselect(test, 3));
   System.out.println(Quick.quickselect(test, 4));
   System.out.println(Quick.quickselect(test, 5));
   System.out.println(Quick.quickselect(test, 6));
   System.out.println(Quick.quickselect(test, 7));
   System.out.println(Quick.quickselect(test, 8));
  //  System.out.println(Quick.partition(test, 3, 8));
 }
}

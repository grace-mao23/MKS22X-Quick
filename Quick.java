import java.util.*;

public class Quick {
  // testing stuff
  private static final int INCREASE = 0;
  private static final int DECREASE = 1;
  private static final int STANDARD = 2;
  private static final int SMALL_RANGE = 3;
  // end of testing stuff

  public static int partition (int[] data, int start, int end) {
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
   while (!(pivots[0] <= k && pivots[1] > k)) {
     System.out.println(Arrays.toString(data)+": "+start+","+end);
     if (pivots[0] > k) {
       end = pivots[0] - 1;
     } else {
       start = pivots[1];
     }
     //System.out.println(start+","+end);
    // System.out.println("Data: "+Arrays.toString(data));
     pivots = partitionDutch(data, start, end);
   }
   System.out.println(Arrays.toString(data)+": "+start+","+end);
   return data[pivots[0]];
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

 private static int[] partitionDutch(int[] data, int lo, int hi){
   // generate random pivot index
   int pivot = (int)(Math.random() * (hi - lo + 1)) + lo;
//   System.out.println(pivot);
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
  //   System.out.println("A: "+Arrays.toString(data) + ","+same);
     if (data[lo] < data[pivot]) {
       if (same != 0) {
         int t = data[same];
         data[same] = data[lo];
         data[lo] = t;
         same++;
       }
       lo++;
     } else if (data[lo] == data[pivot]) {
       if (same == 0) same = lo;
       lo++;
     } else {
       int t = data[lo];
       data[lo] = data[hi];
       data[hi] = t;
       hi--;
     }
   }
   int[] result = new int[2];
  // System.out.println(Arrays.toString(data) + lo+","+same+","+hi);
   if (same != 0) {
     if (data[lo] == data[pivot]) {
       hi++;
       lo = pivot;
       int t = data[same-1];
       data[same-1] = data[pivot];
       data[pivot] = t;
       result[0] = same-1;
       result[1] = hi;
     } else if (data[lo] < data[pivot]) {
       int t = data[lo];
       data[lo] = data[pivot];
       data[pivot] = t;
       result[0] = same;
       result[1] = pivot;
     } else {
       int t = data[same-1];
       data[same-1] = data[pivot];
       data[pivot] = t;
       result[0] = pivot;
       result[1] = hi;
     }
   } else {
     if (data[lo] <= data[pivot]) {
       //System.out.println("blah");
       int t = data[lo];
       data[lo] = data[pivot];
       data[pivot] = t;
       pivot = lo;
     } else {
      // System.out.println("lah");
       int t = data[lo-1];
       data[lo-1] = data[pivot];
       data[pivot] = t;
       pivot = lo-1;
       result[0] = pivot;
       result[1] = pivot+1;
     }
   }
  // System.out.println(Arrays.toString(data));
   return result;
     //your code
     //return an array [lt,gt]
 }

 private static void insertionSort(int[] data, int lo, int hi) {
   for (int i = lo+1; i <= hi; i++) {
     int current = data[i];
     int j = i-1;
     while (j >= lo && data[j] > current) {
       data[j+1] = data[j];
       j--;
     }
     data[j+1] = current;
   }
 }

 public static void quicksort(int[] data, int lo, int hi) {
   if (lo >= hi) {
     return;
   }
   if ((hi-lo+1) < 10) {
     insertionSort(data,lo,hi);
   } else {
     int p = partition(data, lo, hi);
     quicksort(data, lo, p-1);
     quicksort(data, p+1, hi);
   }
  // int p = partition(data, lo, hi);
  // quicksort(data, lo, p-1);
  // quicksort(data, p+1, hi);
 }

 public static void quicksort(int[] data) {
   quicksort(data, 0, data.length-1);
 }

 /*public static void main(String[] args) {
   int[] test = new int[] { 2, 3, 4, 6, 1, 8, 9, 5, 7 };
   int[] t = new int[] { 5, 3, 4, 5, 1, 2, 5, 7, 5, 6 };
  // Quick.insertionSort(test, 1, 5);
   // sorted { 1, 2, 3, 4, 5, 6, 7, 8, 9 }
   // sorted { 1, 2, 3, 4, 5, 5, 5, 5, 6, 7 }
  // System.out.println(Quick.quickselect(t, 0));
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
  System.out.println(Arrays.toString(test));
}*/
  private static String name(int i){
    if(i==INCREASE)return "Increassing";
    if(i==DECREASE)return "Decreassing";
    if(i==STANDARD)return "Normal Random";
    if(i==SMALL_RANGE)return "Random with Few Values";
    return "Error categorizing array";

  }

  private static int create(int min, int max){
    return min + (int)(Math.random()*(max-min));
  }

  private static int[] makeArray(int size,int type){
    int[] ans = new int[size];
    if(type == STANDARD){
      for(int i = 0; i < size; i++){
        ans[i]= create(-1000000,1000000);
      }
    } else if(type == INCREASE){
      int current = -5 * size;
      for(int i = 0; i < size; i++){
        ans[i]= create(current,current + 10);
        current += 10;
      }
    } else if(type == DECREASE){
      int current = 5 * size;
      for(int i = 0; i < size; i++){
        ans[i]= create(current,current + 10);
        current -= 10;
      }
    } else if(type == SMALL_RANGE){
      for(int i = 0; i < size; i++){
        ans[i]= create(-5,5);
      }
    } else {
      ans = new int[0];//empty is default
    }
    return ans;
  }

  public static void main(String[]args){
    if(args.length < 2)return;

    int size =  Integer.parseInt(args[0]);
    int type =   Integer.parseInt(args[1]);

    int[] start = makeArray(size,type);
    int[] result = Arrays.copyOf(start,start.length);
    Arrays.sort(result);

    long startTime = System.currentTimeMillis();
    /*
     * Test your sort here //yoursort(start);
     * Add code to switch which sort is tested by changing one of the args!
     */
    Quick.quicksort(start);
    long elapsedTime = System.currentTimeMillis() - startTime;
    if(Arrays.equals(start,result)){
      System.out.println("PASS Case "+name(type)+"\t array, size:"+start.length+"\t"+elapsedTime/1000.0+"sec ");
    } else{
      System.out.println("FAIL ! ERROR ! "+name(type)+" array, size:"+size+"  ERROR!");
    }
  }
}

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
   if ((hi-lo+1) < 100) {
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


 /*public static void main(String[]args){
   System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
   int[]MAX_LIST = {1000000000,500,10};
   for(int MAX : MAX_LIST) {
      for(int size = 31250; size < 2000001; size*=2) {
        long qtime=0;
        long btime=0;
        //average of 5 sorts.
        for(int trial = 0 ; trial <=5; trial++){
          int []data1 = new int[size];
          int []data2 = new int[size];
          for(int i = 0; i < data1.length; i++) {
            data1[i] = (int)(Math.random()*MAX);
            data2[i] = data1[i];
          }
          long t1,t2;
          t1 = System.currentTimeMillis();
          Quick.quicksort(data2);
          t2 = System.currentTimeMillis();
          qtime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)) {
            System.out.println("FAIL TO SORT!");
            System.exit(0);
          }
        }
        System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
      }
      System.out.println();
    }
  }*/
}

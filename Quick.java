public class Quick {


  public static int partition (int [] data, int start, int end) {
   // generate random pivot index
   int pivot = (int)(Math.random() * (end - start + 1)) + start;
   // bring pivot element to index 0
   int temp = data[start];
   if (pivot != start) {
     data[start] = data[pivot];
     data[pivot] = temp;
     // variables
     pivot = 0;
     start += 1;
   }
   //  System.out.println("O: " + Arrays.toString(data));
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
   //  System.out.println(Arrays.toString(data));
   }
   // switching pivot to the right place
   if (data[start] <= data[pivot]) {
     int t = data[start];
     data[start] = data[pivot];
     data[pivot] = t;
     pivot = start;
   } else {
     int t = data[start-1];
     data[start-1] = data[pivot];
     data[pivot] = t;
     pivot = start-1;
   }
   //    System.out.println(Arrays.toString(data));
   return pivot;
 }

 /*return the value that is the kth smallest value of the array.
 */
 public static int quickselect (int[] data, int k){
   return -1;
 }

 public static void main(String[] args) {
   int[] test = new int[] { 99,99,99,1,99,99,99 };
   System.out.println(Quick.partition(test, 3,3));
 }

}

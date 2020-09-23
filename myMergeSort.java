
public class myMergeSort {

  public static void main(String[] args) {
    double[] myArray = {3.2, -1.0, 5.0, -2.1};
    for(int i=0; i<myArray.length; i++)
      System.out.print(myArray[i] + "\t");
    System.out.println();
    mergeSort(myArray);
    for(int i=0; i<myArray.length; i++)
      System.out.print(myArray[i] + "\t");
    System.out.println();

  }
  
  public static void mergeSort(double[] inArray) {
    if(inArray.length <= 1) return; 
    
    int left_size = inArray.length / 2;
    if(inArray.length % 2 == 1) {
      // we want to put the bigger "half" in the left
      left_size ++;
    }
    
    double[] left = new double[left_size];
    double[] right = new double[inArray.length - left_size];
    
    // left gets the values from inArray index 0...left_size-1
    for(int i=0; i<left_size; i++) {
      left[i] = inArray[i];
    }
    
    // right gets the values from inArray index left_size...inArray.length-1
    for(int j=left_size; j<inArray.length; j++) {
      right[j-left_size] = inArray[j];
    }
    
    //make recursive calls to mergeSort
    mergeSort(left);
    mergeSort(right);
    
    // merge
    int left_compare = 0;
    int right_compare = 0;
    int insert_index = 0;
    
    // take the minimum of the left and right arrays at _compare and put in inArray
    while(left_compare < left.length && right_compare < right.length){
      if(left[left_compare] < right[right_compare]) {
        inArray[insert_index] = left[left_compare];
        left_compare++;
        insert_index++;
      }else {
        inArray[insert_index] = right[right_compare];
        right_compare++;
        insert_index++;
      }
    }
    while(left_compare < left.length) {
      inArray[insert_index] = left[left_compare];
      left_compare++;
      insert_index++;
    }
    while(right_compare < right.length) {
      inArray[insert_index] = right[right_compare];
      right_compare++;
      insert_index++;
    }
  }

}

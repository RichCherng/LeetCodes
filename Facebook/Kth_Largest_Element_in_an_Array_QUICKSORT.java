/**
 * Quick Sort Solution N
 */
class Solution {
  public int findKthLargest(int[] nums, int k) {
      shuffle(nums);
      return quickSort(nums, 0, nums.length - 1, nums.length - k);
  }
  
  private int quickSort(int[] arr, int low, int high, int k) {
      int pivot = partition(arr, low, high);
      if(pivot == k) return arr[pivot];
      
      if(k < pivot) return quickSort(arr, low, pivot -1, k);
      else return quickSort(arr, pivot + 1, high, k);
  }
  
  private int partition(int[] arr, int low, int high) {
      int temp;
      int pivot = arr[high];
      int i = low - 1;
      for(int j = low; j < high; j++){
          if(arr[j] < pivot) {
              i++;
              temp = arr[i];
              arr[i] = arr[j];
              arr[j] = temp;
          }
      }
      
      arr[high] = arr[i+1];
      arr[i+1] = pivot;
      
      return i+1;
  }
  
  private void shuffle(int arr[]) {

      final Random random = new Random();
      for(int i = 1; i < arr.length; i++) {
          int r = random.nextInt(i + 1);
          int temp = arr[r];
          arr[r] = arr[i];
          arr[i] = temp;
      }
  }
}
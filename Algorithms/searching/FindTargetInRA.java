package Algorithms.searching;

public class FindTargetInRA {
    public static void main(String[] args) {
        int[] arr = {3,4,5};
        int target = 3;
        int res = findTarget(arr, target);
        System.out.println("Index of the target element is " + res);
    }

    public static int findTarget(int[] arr, int target){
        int pivot = findPivot(arr);
        System.out.println("PIVOT : " + pivot);
        if(pivot == -1){
          return BS(arr, target, 0, arr.length-1);
        }

        if(arr[pivot] == target) return pivot;
        else if(target >= arr[0]){
            return BS(arr, target, 0, pivot);
        }
            return BS(arr, target, pivot + 1, arr.length-1);

    }

    public static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while (start <= end){
            int mid = start + (end-start)/2;

            if(mid < end && arr[mid] > arr[mid+1]) return mid;
            else if(mid > start && arr[mid] < arr[mid-1]) return mid-1;
            else if(arr[start] >= arr[mid]) end = mid-1;
            else if(arr[start] <= arr[mid]) start = mid+1;
        }

        return -1;
    }

    public static int BS(int[] arr, int target, int start, int end){
        while (start <= end){
            int mid = start + (end - start)/2;

            if(arr[mid] == target) return mid;
            if(target > arr[mid]) start = mid+1;
            else end = mid-1;
        }
        return -1;
    }
}

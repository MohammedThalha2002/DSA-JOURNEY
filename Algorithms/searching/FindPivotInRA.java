package Algorithms.searching;

public class FindPivotInRA {
    public static void main(String[] args) {
        // find the pivot element in the rotated sorted array
        int[] arr = {1,3};
        int pivot = findPivot(arr);
        System.out.println(arr[pivot]);
    }

    static int findPivot(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end- start)/2;

            if(mid < end && arr[mid] > arr[mid+1]) return mid;
            else if(mid > start && arr[mid] < arr[mid-1]) return mid+1;
            else if(arr[start] >= arr[mid]) end = mid-1;
            else if(arr[start] <= arr[mid]) start = mid+1;
        }

        return -1;
    }
}

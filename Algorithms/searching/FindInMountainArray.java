package Algorithms.searching;

public class FindInMountainArray {
    public static void main(String[] args) {
        int[] arr = { 1,2,4,5,3,2,1 };
        int target = 1;
        int res = findInMountain(arr, target);
        System.out.println(res);
    }

    public static int findInMountain(int[] arr, int target) {
        int peak = findPeakIndex(arr);
        int b1= binarySearchAsc(arr, target, 0, peak);
        int b2= binarySearchDesc(arr, target, peak+1, arr.length-1);

        if(b1 == -1 || b2 == -1)
            return Math.max(b1,b2);
        else
            return Math.min(b1,b2);
    }

    public static  int binarySearchAsc(int[] arr, int target, int start, int end){

        while (start <= end){
            int mid = start + (end-start)/2;

            if(arr[mid] == target) return mid;
            else if (target > arr[mid]) start = mid+1;
            else end = mid-1;
        }
        return -1;
    }

    public static  int binarySearchDesc(int[] arr, int target, int start, int end){

        while (start <= end){
            int mid = start + (end-start)/2;

            if(arr[mid] == target) return mid;
            else if (target < arr[mid]) start = mid+1;
            else end = mid-1;
        }
        return -1;
    }

    public static int findPeakIndex(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while (start != end){
            int mid = start + (end - start)/2;

            if(arr[mid] < arr[mid + 1])  start = mid+1;
            else end = mid;
        }

        return start;
    }
}

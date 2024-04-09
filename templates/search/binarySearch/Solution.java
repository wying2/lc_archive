class Solution {
    int binarySearchLeft(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int ind = 0; // arr[ind] is always <= target
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
                ind = mid; // thus, update when before shrinking to right
            }
        }
        return arr[ind];
    }
    
    int binarySearchRight(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int ind = right; // arr[ind] >= target
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
                ind = mid;
            }
        }
        return arr[ind];
    }
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int x_right_ind = binarySearchLeft(arr, x);
        int left = x_right_ind-1;
        int right = x_right_ind;
        // System.out.println("left = " + left + " right = " + right);
        List<Integer> res = new LinkedList();
        while (right - left - 1 < k) {
            // System.out.println("left = " + left + " right = " + right);
            if (left <= -1) {
                right ++;
                continue;
            }
            if (right >= arr.length) {
                left --;
                continue;
            }
            if (x - arr[left] <= arr[right] - x) {
                left --;
            } else {
                right ++;
            }
        }
        // System.out.println("left = " + left + " right = " + right);
        for (int i = left + 1; i < right; i ++) {
            res.add(arr[i]);
        }
        // res.sort();
        return res;
    }
    
    // bs to find the closest left integer to x
    private int binarySearchLeft (int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int ind = right; // arr[ind] <= target
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                ind = mid;
                right = mid - 1;
            }
        }
        return ind;
    }
}

// arr k x

// x < arr[0] return first k
// x > arr[len-1] return last k
// else arr[i] or not
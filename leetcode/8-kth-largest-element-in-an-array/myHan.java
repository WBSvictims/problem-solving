class Solution {
    private static int split(int[] nums, int front, int back, int pivot) {
        int tmp = nums[front];
        nums[front] = nums[pivot];
        nums[pivot] = tmp;
        pivot = front;
        front += 1;
        
        while(front + 1 < back) {
            if(nums[pivot] < nums[front]) {
                tmp = nums[front];
                nums[front] = nums[back-1];
                nums[back-1] = tmp;
                back--;
            }
            else{
                front++;
            }
        }
        if(nums[pivot] < nums[front]) {
            front--;
            back--;
        }
        
        tmp = nums[front];
        nums[front] = nums[pivot];
        nums[pivot] = tmp;
        
        return front;
    }
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int front = 0, back = nums.length;
        while(front + 1 < back) {
            int pivot = (int)(Math.random() * (back - front)) + front;
            int mid = split(nums, front, back, pivot);
            if(k == mid) break;
            else if(k < mid) back = mid;
            else front = mid + 1;
        }
        return nums[k];
    }
}
class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i=arr.length - 1; i >0  ; i--){
            int maxIndex = findMaxIndex(arr, i);
            if(maxIndex != i){
                flip(arr, maxIndex);
                flip(arr,  i);
                res.add(maxIndex + 1);
                res.add(i + 1);
            }
            
        }
        return res;
    }
    
    public void flip(int[] arr, int index){
        int i=0, j=index;
        while(i < j){
            int temp= arr[i];
            arr[i]= arr[j];
            arr[j]= temp;
            i++; j--;
        }
    }
    
    
    public int findMaxIndex(int[] arr, int idx){
        int index = 0;
        for(int i=idx;i>=0;i--){
            if(arr[index] < arr[i]){
                index = i;
            }
        }
        return index;
    }
}
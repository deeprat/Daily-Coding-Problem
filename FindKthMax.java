class Solution{
	public static void swap(int[] nums, int i, int j){
		int temp = nums[i]; 
		nums[i] = nums[j]; 
		nums[j] = temp;
	}

	public static int pivot(int[] nums, int start, int end){
		if(start == end) return start;
		//TODO: choose random number to pivot around
		// Chosing the first number for now
		int random = start;
		swap(nums, random, end);
		int j = start - 1; 
		for(int i = start;  i < end; i++){
			if(nums[i] > nums[end]){
				swap(nums,i, ++j); 
			}
		}
		//Error ++j and not j++
		swap(nums, end, ++j);
		return j;
	}

	public static int findKthLargest(int[] nums, int k){
		int start = 0; 
		int end = nums.length - 1; 

		//Erorr 1
		while(start <= end){
			int chosenPivot = pivot(nums, start, end);
			if(chosenPivot == k - 1) return nums[chosenPivot];
			if(chosenPivot > k - 1) end = chosenPivot -1 ; 
			if(chosenPivot < k - 1) start = chosenPivot + 1; 
		}
		return -1;
	}

	public static void main(String[] args){
		int[] nums = {3, 2, 1, 5, 6, 4};
		int k = 2;
		int result = findKthLargest(nums, k);
		System.out.println(result);
	}
}

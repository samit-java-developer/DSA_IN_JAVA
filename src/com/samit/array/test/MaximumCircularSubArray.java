package com.samit.array.test;

public class MaximumCircularSubArray {

	public static void main(String[] args) {
		int[] arr = {-4, -2, -1, -2, -6};
		//printCirculerSubArray(arr);
		int x=circlarSubArray(arr);
		System.out.println(x);
	}

	static void printCirculerSubArray(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < n; j++) {
				int k = i;
				while (true) {
					System.out.print(arr[k] + " ");
					if (k == (i + j) % n) {
						break;
					}
					k = (k + 1) % n;
				}
				System.out.println();
			}
			System.out.println();
		}
	}

	static int circlarSubArray(int[] arr){
		int curr_max_sum=arr[0];
		int curr_min_sum=arr[0];
		int max_sum=arr[0];
		int min_sum=arr[0];
		int total_sum=arr[0];
		for (int i=1;i<arr.length;i++){
			curr_max_sum=Math.max(curr_max_sum+arr[i],arr[i]);
			curr_min_sum=Math.min(curr_min_sum+arr[i],arr[i]);
			max_sum=Math.max(max_sum,curr_max_sum);
			min_sum=Math.min(min_sum,curr_min_sum);
			total_sum+=arr[i];
		}
		if (max_sum<0){
			return max_sum;
		}else{
			return Math.max(max_sum,total_sum-min_sum);
		}
	}
}

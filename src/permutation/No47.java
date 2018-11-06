package permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
	Given a collection of numbers that might contain duplicates, return all possible unique permutations.
	
	Example:
	
	Input: [1,1,2]
	Output:
	[
	  [1,1,2],
	  [1,2,1],
	  [2,1,1]
	]
 * 
 * **/



public class No47 {
	public List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(List<Integer> one, int[] nums) {
//    	System.out.println("one: "+one);
//    	System.out.print("nums: ");
//    	for (int i = 0; i < nums.length; i++) {
//    		System.out.print(nums[i]);
//		}
//    	System.out.println();

    	if (nums.length == 1) {
        	List<Integer> two = new ArrayList<Integer>();
            for (Integer integer : one) {
            	two.add(new Integer(integer));
            }
    		two.add(nums[0]);
			res.add(two);
//			System.out.println(two);
			return null;
		}
		List<Integer> dup = new ArrayList<Integer>();
    	for (int i = 0; i < nums.length; i++) {
    		
    		if(dup.contains(nums[i])){
//    			System.out.println("dup: "+ nums[i]);
    			continue;
    		}
    		dup.add(nums[i]);
//    		System.out.println(dup);
        	List<Integer> two = new ArrayList<Integer>();
            for (Integer integer : one) {
            	two.add(new Integer(integer));
            }
    		int[] another = Arrays.copyOfRange(nums, 0, nums.length);
//        	System.out.print("another: ");
//        	for (int j = 0; j < another.length; j++) {
//        		System.out.print(another[j]);
//    		}
//        	System.out.println();
        	two.add(another[i]);
    		int temp = another[i];

    		another[i] = another[0];
    		another[0] = temp;
			permute(two, Arrays.copyOfRange(another, 1, another.length));
		}
    	return res;
    }
	
	
	public static void main(String[] args) {
		No47 problem = new No47();
		int[] nums = {1,1,2,2};
//		System.out.println("nums's length: "+nums.length);
		List<Integer> one = new ArrayList<Integer>();

		problem.permute(one, nums);
		System.out.println("-------");
		for (int i = 0; i < problem.res.size(); i++) {
			List<Integer> one1 = problem.res.get(i);
			System.out.println(one1);
			
		}
		System.out.println(problem.res.size());
		int size = 1;
		for (int i = 1; i <= nums.length; i++) {
			size*=i;
		}
		System.out.println(size);
	}
}

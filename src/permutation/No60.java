package permutation;

import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
 * 
 * **/



public class No60 {
	public List<List<Character>> res = new ArrayList<List<Character>>();

    public List<List<Character>> permute(List<Character> one, char[] nums) {
//    	System.out.println("one: "+one);
//    	System.out.print("nums: ");
//    	for (int i = 0; i < nums.length; i++) {
//    		System.out.print(nums[i]);
//		}
//    	System.out.println();

    	if (nums.length == 1) {
        	List<Character> two = new ArrayList<Character>();
            for (Character integer : one) {
            	two.add(new Character(integer));
            }
    		two.add(nums[0]);
			res.add(two);
//			System.out.println(two);
			return null;
		}
    	for (int i = 0; i < nums.length; i++) {
        	List<Character> two = new ArrayList<Character>();
            for (Character integer : one) {
            	two.add(new Character(integer));
            }
    		char[] another = Arrays.copyOfRange(nums, 0, nums.length);
//        	System.out.print("another: ");
//        	for (int j = 0; j < another.length; j++) {
//        		System.out.print(another[j]);
//    		}
//        	System.out.println();
        	two.add(another[i]);
        	char temp = another[i];

    		another[i] = another[0];
    		another[0] = temp;
			permute(two, Arrays.copyOfRange(another, 1, another.length));
		}
    	return res;
    }
	
	
	public static void main(String[] args) {
		No60 problem = new No60();
		int n = 4;
		int k = 9;
		char[] nums = new char[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = (char)('1'+i);
//			System.out.println(nums[i]);
		}
		List<Character> one = new ArrayList<Character>();
		problem.permute(one, nums);
		System.out.println("-------");
		for (int i = 0; i < problem.res.size(); i++) {
			List<Character> one1 = problem.res.get(i);
			System.out.println(one1);
			
		}
		System.out.println(problem.res.size());
		int size = 1;
		for (int i = 1; i <= nums.length; i++) {
			size*=i;
		}
		System.out.println(problem.res.get(k-1));
	}
}

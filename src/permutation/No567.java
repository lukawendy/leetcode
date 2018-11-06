package permutation;

import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**

Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
Example 1:
Input:s1 = "ab" s2 = "eidbaooo"
Output:True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:
Input:s1= "ab" s2 = "eidboaoo"
Output: False
Note:
The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].
 * 
 * **/



public class No567 {
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
		No567 problem = new No567();
		String s1 = 'ab';
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

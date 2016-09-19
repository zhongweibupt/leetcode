/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
* <p>Title: Solution.java</p>
* <p>Description: 15. 3Sum</p>
* <p>Tags: Array, Sort, Combination<p>
* <p>Copyright: Copyright (c) 2007</p>
* <p>Company: Zhongwei</p>
* @author Zhongwei
* @date 2016年9月18日
* @version 1.0
*/
public class Solution {
	private static final int TARGET = 0;
	
	public List<List<Integer>> threeSum(int[] nums) {
		qsort(nums, 0, nums.length - 1);
        
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        
        if(nums.length < 3) {
        	return result;
        }
        
        for(int i = 0; i < nums.length; i++) {
        	int first = i + 1;
        	int last = nums.length - 1;
        	while(first < last) {
        		int sum = nums[i] + nums[first] + nums[last];
        		if(TARGET == sum) {
        			List<Integer> tmp = new LinkedList<Integer>();
        			tmp.add(nums[i]);
        			tmp.add(nums[first]);
        			tmp.add(nums[last]);
        			result.add(tmp);
        			first++;
        			last--;
        		} else if(TARGET > sum) {
        			first++;
        		} else {
        			last--;
        		}
        	}
        }
        result = new LinkedList<List<Integer>>(new HashSet<List<Integer>>(result));
        
        return result;
    }
	
	private void qsort(int[] nums, int first, int last) {
		int i = first, j = last;
		if(i > j)
			return;
		int temp = nums[first];
		while(i < j) {
			if(nums[i] == temp) {
				if(nums[j] < temp) {
					int t = nums[i];
					nums[i] = nums[j];
					nums[j] = t;
					i++;
				} else {
					j--;
				}
			} else {
				if(nums[i] > temp) {
					int t = nums[i];
					nums[i] = nums[j];
					nums[j] = t;
					j--;
				} else {
					i++;
				}
			}
		}
		
		qsort(nums, first, i - 1);
		qsort(nums, i + 1, last);
	}

	public static void main(String args[]) {
		int[] nums = {-1,-4,2,5,7,1};
		
		Solution s = new Solution();
		System.out.println(s.threeSum(nums));
	}
}

/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
* <p>Title: Solution.java</p>
* <p>Description: 16. 3Sum Closest</p>
* <p>Tags: Array, Sort, Combination<p>
* <p>Copyright: Copyright (c) 2007</p>
* <p>Company: Zhongwei</p>
* @author Zhongwei
* @date 2016年9月18日
* @version 1.0
*/
public class Solution {	
	public int threeSumClosest(int[] nums, int target) {
		qsort(nums, 0, nums.length - 1);
        
		double min = Double.MAX_VALUE;
        int result = 0;
		
		
        for(int i = 0; i < nums.length; i++) {
        	int first = i + 1;
        	int last = nums.length - 1;
        	while(first < last) {
        		int sum = nums[i] + nums[first] + nums[last];
        		if(Math.abs(sum - target) < min) {
        			min = Math.abs(sum - target);
        			result = sum;
        		}
        		
        		if(target == sum) {
        			return target;
        		} else if(target > sum) {
        			first++;
        		} else {
        			last--;
        		}
        	}
        }
        
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
}

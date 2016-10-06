/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
* <p>Title: Solution.java</p>
* <p>Description: 31. Next Permutation</p>
* <p>Tags: ArrayList<p>
* <p>Copyright: Copyright (c) 2007</p>
* <p>Company: Zhongwei</p>
* @author Zhongwei
* @date 2016年9月18日
* @version 1.0
*/

/*
class ListNode {
	 int val;
	 ListNode next;
	 ListNode(int x) { val = x; }
}
 */

public class Solution {
    public void nextPermutation(int[] nums) {
		if(nums.length == 1)
            return;
		int last = nums.length - 1;
		int i = last;
		for(last = nums.length - 1; last > 0; last--) {
			if(nums[last] > nums[last - 1]) {
				break;
			}
		}
		if(last == 0) {
			qsort(nums, 0, nums.length - 1);
			return;
		}
		
		for(i = nums.length-1; i > last; i--) {
			if(nums[i] > nums[last - 1]) {
				break;
			}
	 	}
		swap(nums, i, last - 1);
		qsort(nums, last, nums.length - 1);
	}
	
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
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
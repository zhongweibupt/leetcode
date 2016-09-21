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
* <p>Description: 18. 4Sum</p>
* <p>Tags: Array, Sort, Combination<p>
* <p>Copyright: Copyright (c) 2007</p>
* <p>Company: Zhongwei</p>
* @author Zhongwei
* @date 2016年9月18日
* @version 1.0
*/
public class Solution {	
	public List<List<Integer>> fourSum(int[] nums, int target) {
		qsort(nums, 0, nums.length - 1);
        
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if(nums.length < 4) {
			return result;
		}
		
		HashMap<Integer, List<List<Integer>>> valueMap = new HashMap<Integer, List<List<Integer>>>();
		
		for(int i = 0; i < nums.length - 1; i++) {
        	for(int j = i + 1; j < nums.length; j++) {
        		List<Integer> pair = new ArrayList<Integer>();
        		pair.add(i);
        		pair.add(j);
        		
        		int sum = nums[i] + nums[j];
        		List<List<Integer>> pairList = valueMap.containsKey(sum) ?
        				valueMap.get(sum) : new LinkedList<List<Integer>>();
        		pairList.add(pair);
        		
        		valueMap.put(sum, pairList);
        	}
        }
		
		for(int i = 0; i < nums.length - 1; i++) {
        	for(int j = i + 1; j < nums.length; j++) {
        		int key = target - nums[i] - nums[j];
        		if(valueMap.containsKey(key)) {
        			for(List<Integer> pair : valueMap.get(key)) {
        				if(i > pair.get(1)) {
        					List<Integer> tmp = new ArrayList<Integer>(pair);
        					tmp.add(i);
        					tmp.add(j);
        					result.add(tmp);
        				}
        			}
        		}
        	}
        }
        
        for(int i = 0; i < result.size(); i++) {
        	for(int j = 0; j < result.get(i).size(); j++) {
        		result.get(i).set(j, nums[result.get(i).get(j)]);
        	}
        }
        
        result = new LinkedList<List<Integer>>(new HashSet<List<Integer>>(result));
        Collections.sort(result, new MyComparator());
        return result;
    }
	
	private class MyComparator implements Comparator<List<Integer>> {
		@Override
		public int compare(List<Integer> o1, List<Integer> o2) {
			for(int i = 0; i < o1.size(); i++) {
				if(o1.get(i) > o2.get(i)) {
					return 1;
				} else if(o1.get(i) < o2.get(i)) {
					return -1;
				} else {
					continue;
				}
			}
			return 0;
		}
	}
	
	private List<List<Integer>> cross(List<List<Integer>> a, List<List<Integer>> b) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		
		for(int i = 0; i < a.size(); i++) {
        	for(int j = 0; j < b.size(); j++) {
        		List<Integer> tmp = new ArrayList<Integer>(a.get(i));
        		tmp.addAll(b.get(j));
        		Collections.sort(tmp);
        		
        		if(isOk(tmp))
        			result.add(tmp);
        	}
		}
		return result;
	}
	
	private boolean isOk(List<Integer> nums) {
		int pre = nums.get(0) - 1;
		for(int num : nums) {
			if(num == pre) {
				return false;
			}
			pre = num;
		}
		return true;
	}
	
	private void qsort(int[] nums, int first, int last) {
		int i = first, j = last;
		if(i > j)
			return;
		int temp = nums[first];
		while(i < j) {
			if(nums[i] == temp) {
				if(nums[j] < temp) {
					swap(nums, i, j);
					i++;
				} else {
					j--;
				}
			} else {
				if(nums[i] > temp) {
					swap(nums, i, j);
					j--;
				} else {
					i++;
				}
			}
		}
		
		qsort(nums, first, i - 1);
		qsort(nums, i + 1, last);
	}
	
	private void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}
}

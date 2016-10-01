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
* <p>Description: 347. Top K Frequent Elements</p>
* <p>Tags: Sort, HashMap<p>
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
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> result = new ArrayList<Integer>();
		
		HashMap<Integer, Integer> frequentMap = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {
			int tmp = 0;
			if(frequentMap.containsKey(nums[i])) {
				tmp = frequentMap.get(nums[i]);
			}
			frequentMap.put(nums[i], ++tmp);
		}
		
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for(Map.Entry<Integer, Integer> entry : frequentMap.entrySet()) {
			List<Integer> tmp = new ArrayList<Integer>();
			if(map.containsKey(entry.getValue())) {
				tmp = map.get(entry.getValue());
			}
			tmp.add(entry.getKey());
			map.put(entry.getValue(), tmp);
		}
		
		for(int j = nums.length; j>=1; j--){
	        if(map.containsKey(j)){
	            for(int a: map.get(j)){
	                result.add(a);
	                if(result.size()>=k)
	    	            break;
	            }
	        }
	 
	        if(result.size()>=k)
	            break;
	    }
		
		return result;
    }
}

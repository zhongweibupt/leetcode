/**
 * 
 */
package leetcode;

import java.util.HashMap;

/**
* <p>Title: Solution.java</p>
* <p>Description: 1. Two Sum</p>
* <p>Tags: Array, Hash<p>
* <p>Copyright: Copyright (c) 2007</p>
* <p>Company: Zhongwei</p>
* @author Zhongwei
* @date 2016年9月18日
* @version 1.0
*/
public class Solution {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(target - nums[i])) {
				return new int[]{map.get(target - nums[i]), i};
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No Solution.");
    }
}

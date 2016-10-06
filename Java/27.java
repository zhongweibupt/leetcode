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
* <p>Description: 27. Remove Element</p>
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
	public int removeElement(int[] nums, int val) {
		int index = 0;
		for(int i = 0; i < nums.length; i++) {
			if(val != nums[i]) {
				nums[index++] = nums[i];
			}
		}
		return index;
	}
}

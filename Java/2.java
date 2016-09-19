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
* <p>Description: 2. Add Two Numbers</p>
* <p>Tags: LinkedList<p>
* <p>Copyright: Copyright (c) 2007</p>
* <p>Company: Zhongwei</p>
* @author Zhongwei
* @date 2016年9月18日
* @version 1.0
*/
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}

public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = null;
		ListNode last = null; 
		
		int carry = 0;
		int flag = 0;
		while(l2 != null || l1 != null || carry > 0) {
			int a = l1 != null ? l1.val : 0;
			int b = l2 != null ? l2.val : 0;
			
			ListNode node = new ListNode((a + b + carry)%10);
			node.next = null;
			
			if(flag == 0) {
				result = node;
				last = node;
			} else {
				last.next = node;
				last = last.next;
			}
			flag++;
			
			carry = (a + b + carry) > 9 ? 1 : 0;
			
			l2 = l2 != null ? l2.next : null;
			l1 = l1 != null ? l1.next : null;
		}
		
		return result;
	}

	public static void main(String args[]) {
		int[] nums = {-1,-4,2,5,7,1};
		
		Solution s = new Solution();
		System.out.println(s.addTwoNumbers());
	}
}

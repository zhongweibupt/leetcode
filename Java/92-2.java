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
* <p>Description: 92. Reverse Linked List II</p>
* <p>Tags: LinkedList, Reverse<p>
* <p>Copyright: Copyright (c) 2007</p>
* <p>Company: Zhongwei</p>
* @author Zhongwei
* @date 2016年9月18日
* @version 1.0
*/
class ListNode {
	 int val;
	 ListNode next;
	 ListNode(int x) { val = x; }
}

public class Solution {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode result = new ListNode(-1);
        result.next = head;
        
        ListNode p = result;
        ListNode pre = result;
        for(int i = 1; i <= n; i++) {
        	if(i == m) {
        		pre = p;
        	}
        	
        	if(i <= n && i > m) {
        		p.next = head.next;
        		head.next = pre.next;
        		pre.next = head;
        		head = p;
        	}
        	
        	p = head;
        	head = head.next;
        }
        
        return result.next;
    }
	
	public static void main(String args[]) {
		ListNode a = new ListNode(0);
		ListNode p = a;
		for(int i = 1; i < 7; i++) {
			p.next = new ListNode(i);
			p = p.next;
		}
		p.next = null;
		
		Solution s = new Solution();
		ListNode test = s.reverseBetween(a, 1, 1);
		while(test != null) {
			System.out.println(test.val);
			test = test.next;
		}
	}
}

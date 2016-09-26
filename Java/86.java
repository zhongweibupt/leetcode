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
* <p>Description: 86. Partition List</p>
* <p>Tags: LinkedList, Delete<p>
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
	public ListNode partition(ListNode head, int x) {
        ListNode result = new ListNode(-1);
        result.next = head;
        
        ListNode part = new ListNode(-1);
        ListNode p = part;
        ListNode pre = result;
        while(head != null) {
        	if(head.val < x) {
        		p.next = head;
        		p = p.next;
        		pre.next = head.next;
        	} else {
        		pre = pre.next;
        	}
        	head = head.next;
        }
        p.next = result.next;
        
        return part.next;
    }
	
	public static void main(String args[]) {
		ListNode a = new ListNode(0);
		ListNode p = a;
		for(int i = 7; i > 0; i--) {
			p.next = new ListNode(i);
			p = p.next;
		}
		p.next = null;
		
		Solution s = new Solution();
		ListNode test = s.partition(a.next, 3);
		while(test != null) {
			System.out.println(test.val);
			test = test.next;
		}
	}
}

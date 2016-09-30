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
* <p>Description: 82. Remove Duplicates from Sorted List II</p>
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
	public ListNode rotateRight(ListNode head, int k) {
        ListNode result = new ListNode(Integer.MAX_VALUE);
        result.next = head;
        
        ListNode pre = result;
        ListNode p = result;
        
        int len = 0;
        while(head != null) {
            head = head.next;
            len++;
        }
        if(len == 0) {
            return result.next;
        }
        k %= len;
        
        head = result.next;
        int count = 0;
        while(head != null) {
        	if(count >= k) {
        		pre = pre.next;
        	}
        	p = p.next;
        	head = head.next;
        	count++;
        }
        if(count > k) p.next = result.next;
        result.next = pre.next;
        if(count > k) pre.next = null;
        return result.next;
    }
}

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
* <p>Description: 83. Remove Duplicates from Sorted List</p>
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
	public ListNode deleteDuplicates(ListNode head) {
        ListNode result = new ListNode(-1);
        result.next = head;
        
        ListNode pre = head;
        while(head != null) {
        	if(pre.val == head.val) {
        		pre.next = head.next;
        	} else {
        		pre = pre.next;
        	}
        	head = head.next;
        }
        
        return result.next;
    }
}

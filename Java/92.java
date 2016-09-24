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

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode result = head;
        
        ListNode first = null;
        ListNode last = null;
        
        ListNode first_pre = null;
        ListNode last_next = null;
        
        int length = 0;
        ListNode p = head;
        while(p != null) {
            p = p != null ? p.next : null;
            length++;
        }
        
        int i = 0;
        p = head;
        ListNode pre = head;
        while(i <= n) {
            if(m == 1 && i == 0) {
                first_pre = p;
            } else {
                if(i == m - 2) {
                    first_pre = p;
                }
            }
            
            if(n == length && i == length - 1) {
                last_next = p;
            } else {
                if(i == n) {
                    last_next = p;
                }
            }
            
            if(i == m - 1) {
                first = p;
            }
            
            if(i == n - 1) {
                last = p;
            }
            
            ListNode tmp = p;
            p = p != null ? p.next : null;;
            if(i < n && i > m - 1) {
                tmp.next = pre;
            }
            
            if(i != 0) {
                pre = tmp;
            }
            i++;
        }
        
        if(m != 1 && n != length) {
            first_pre.next = last;
            first.next = last_next;
        } else if(m == 1) {
            result = last;
            first.next = last_next;
        } else if(n == length) {
            first_pre.next = last;
            first.next = null;
        }
        
        ListNode a = result;
        while(a != null) {
            a = a != null ? a.next : null;
        }
        
        return result;
    }
}
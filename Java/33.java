/**
 * 
 */
package leetcode;

/**
* <p>Title: Solution.java</p>
* <p>Description: 33. Search in Rotated Sorted Array</p>
* <p>Tags: Array, Binary search<p>
* <p>Copyright: Copyright (c) 2007</p>
* <p>Company: Zhongwei</p>
* @author Zhongwei
* @date 2016年9月18日
* @version 1.0
*/
public class Solution {
	public int search(int[] nums, int target) {
        if(0 == nums.length) {
        	return -1;
        }
        
		int first = 0, last = nums.length;
        while(first != last) {
        	int mid = (first + last)/2;
        	if (nums[mid] == target)
        		return mid;
        	
        	if (nums[first] <= nums[mid]) {
        		if (nums[first] <= target && target < nums[mid])
        			last = mid;
        		else
        			first = mid + 1;
        	} else {
        		if (nums[mid] < target && target <= nums[last-1])
        			first = mid + 1;
        		else
        			last = mid;
        	}
        }
        
		return -1;
    }
}

int BinarySearch(int a[], int key, int n) {
    int left = 0;
    int right = n -1;
    while(left <= right) {
        int middle = (left + right)/2;
        if(key == a[middle])
            return middle;
        if(key > a[middle])
            left = middle + 1;
        else
            right = middle - 1;
    }
    return -1;
}
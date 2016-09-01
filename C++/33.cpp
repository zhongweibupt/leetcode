class Solution {
public:
    int search(vector<int>& nums, int target) {
		int n = nums.size();
		if (n == 0)
			return -1;

		int index = 0;
		for(index = 0; index < n; index++) {
		    if(nums.at(index) == target) {
		        return index;
		    }
		}

		return -1;
	}
};
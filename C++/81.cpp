class Solution {
public:
    bool search(vector<int>& nums, int target) {
		int n = nums.size();
		if (n == 0)
			return false;

		int index = 0;
		for(index = 0; index < n; index++) {
		    if(nums.at(index) == target) {
		        return true;
		    }
		}

		return false;
	}
};
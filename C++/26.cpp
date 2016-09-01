class Solution {
public:
	int removeDuplicates(vector<int>& nums) {
		int n = nums.size();

		if (n == 0)
			return 0;

		int index = 0;
		for (int i = 1; i < nums.size(); i++) {
			if (nums.at(index) != nums.at(i)) {
				nums.at(++index) = nums.at(i);
			}
		}
		return index + 1;
	}
};
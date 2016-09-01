class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int n = nums.size();
		int count = 1;

		if (n == 0)
			return 0;

		int index = 0;
		for (int i = 1; i < nums.size(); i++) {
			if (nums.at(index) != nums.at(i)) {
				nums.at(++index) = nums.at(i);
				count = 0;
			}
			else if(count < 2){
				nums.at(++index) = nums.at(i);
			}
			count++;
		}
		return index + 1;
    }
};
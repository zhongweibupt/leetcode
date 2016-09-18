class Solution {
public:
	int longestConsecutive(vector<int>& nums) {
		if (nums.size() == 0) {
			return 0;
		}
		
		map<int, int> table;
		for (int i = 0; i < nums.size(); i++) {
			int tmp = table.count(nums[i]) > 0 ? int(table[nums[i]]) : 0;
			table[nums[i]] = ++tmp;
		}

		cout << table.size() << endl;
		int max_count = 0;
		while (table.size() > 0) {
			int begin = table.begin()->first;
			int tmp = begin;
			int tmp_count = 0;

			while (table.count(tmp) > 0) {
				tmp_count++;
				table.erase(tmp);
				tmp++;
			}

			tmp = begin - 1;
			while (table.count(tmp) > 0) {
				tmp_count++;
				table.erase(tmp);
				tmp--;
			}
			
			if (tmp_count > max_count) {
				max_count = tmp_count;
			}
		}
		return max_count;
	}
};
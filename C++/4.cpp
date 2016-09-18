class Solution {
public:
	double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
		int m = nums1.size();
		int n = nums2.size();
		
		int *A = &nums1[0];
		int *B = &nums2[0];

		int total = m + n;
		if (total & 0x1)
			return find_kth(A, m, B, n, total / 2 + 1);
		else
			return (find_kth(A, m, B, n, total / 2)
			+ find_kth(A, m, B, n, total / 2 + 1)) / 2;
	}
private:
	static double find_kth(int A[], int m, int B[], int n, int k) {

		if (m > n) return find_kth(B, n, A, m, k);
		if (m == 0) return B[k - 1];
		if (k == 1) return min(A[0], B[0]);

		int pa = min(k / 2, m), pb = k - pa;
		if (A[pa - 1] < B[pb - 1])
			return find_kth(A + pa, m - pa, B, n, k - pa);
		else if (A[pa - 1] > B[pb - 1])
			return find_kth(A, m, B + pb, n - pb, k - pb);
		else
			return A[pa - 1];
	}
};
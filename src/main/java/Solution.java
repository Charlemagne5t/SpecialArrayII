class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] s = new int[n];
        s[0] = 0;

        for (int i = 1; i < n; i++) {
            s[i] = ((nums[i - 1] + nums[i]) % 2 == 1 ? 1 : 0);
        }

        int[] ps = new int[n];
        ps[0] = 1;
        for (int i = 1; i < n; i++) {
            ps[i] = ps[i - 1] + s[i];
        }

        boolean[] res = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (ps[queries[i][1]] - ps[queries[i][0]] == queries[i][1] - queries[i][0]) {
                res[i] = true;
            }
        }


        return res;
    }
}
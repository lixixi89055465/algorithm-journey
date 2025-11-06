package class078;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;

public class Test07 {
    public static int ans;

    // 不要提交这个类
    private static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }


    public static int pathSum(TreeNode root, int sum) {
        HashMap<Long, Integer> presum = new HashMap<>();
        presum.put(0L, 1);
        ans = 0;
        f(root, sum, 0, presum);
        return ans;
    }

    private static void f(TreeNode x, int target, long sum, HashMap<Long, Integer> presum) {
        if (x != null) {
            sum += x.val;
            ans += presum.getOrDefault(sum - target, 0);
            presum.put(sum, presum.getOrDefault(sum, 0) + 1);
            f(x.left, target, sum, presum);
            f(x.right, target, sum, presum);
            presum.put(sum, presum.getOrDefault(sum, 0) - 1);
        }
    }
}
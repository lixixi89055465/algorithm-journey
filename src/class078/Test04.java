package class078;

// 在二叉树中分配硬币
// 给你一个有 n 个结点的二叉树的根结点 root
// 其中树中每个结点 node 都对应有 node.val 枚硬币
// 整棵树上一共有 n 枚硬币
// 在一次移动中，我们可以选择两个相邻的结点，然后将一枚硬币从其中一个结点移动到另一个结点
// 移动可以是从父结点到子结点，或者从子结点移动到父结点
// 返回使每个结点上 只有 一枚硬币所需的 最少 移动次数
// 测试链接 : https://leetcode.cn/problems/distribute-coins-in-binary-tree/
public class Test04 {
    // 不要提交这个类
    private static class TreeNode {
        public int val;
        TreeNode left;
        TreeNode right;
    }

    private static class Info {
        public int cnt;
        public int sum;
        public int move;

        public Info(int a, int b, int c) {
            cnt = a;
            sum = b;
            move = c;
        }
    }

    public static int distributeCoins(TreeNode x) {
        return f(x).move;
    }

    public static Info f(TreeNode x) {
        if (x == null) {
            return new Info(0, 0, 0);
        }
        Info infoL = f(x.left);
        Info infoR = f(x.right);
        int cnt = infoL.cnt + infoR.cnt + 1;
        int sums = infoL.sum + infoR.sum + x.val;
        int moves = infoL.move + infoR.move + Math.abs(infoL.cnt - infoL.sum)
                + Math.abs(infoR.cnt - infoR.sum);
        return new Info(cnt, sums, moves);
    }
}
package class078;

/**
 * 创建人: @author lixiang
 * 创建时间: 2025年11月07日 15:04
 * 项目名称: algorithm-journey
 * 文件名称: Test02
 * 文件描述: @Description:
 * site:
 */
public class Test02 {
    // 不要提交这个类
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static int maxSumBST(TreeNode root) {
        return f(root).maxBstSum;
    }

    private static class Info {
        public int max;
        public int min;
        public int sum;
        public boolean isBst;
        public int maxBstSum;

        public Info(int max, int min, int sum, boolean isBst, int maxBstSum) {
            this.max = max;
            this.min = min;
            this.sum = sum;
            this.isBst = isBst;
            this.maxBstSum = maxBstSum;
        }
    }

    public static Info f(TreeNode x) {
        if (x == null) {
            return new Info(Integer.MIN_VALUE,
                    Integer.MAX_VALUE,
                    0, true,
                    0);
        }
        Info infoL = f(x.left);
        Info infoR = f(x.right);
        int max = Math.max(x.val, Math.max(infoL.max, infoR.max));
        int min = Math.min(x.val, Math.min(infoL.min, infoR.min));
        int sum = infoR.sum + infoR.sum + x.val;
        boolean isBst = infoL.isBst && infoR.isBst & infoL.max < x.val && x.val < infoR.max;
        int maxBstSum = Math.max(infoL.maxBstSum, infoR.maxBstSum);
        if (isBst) {
            maxBstSum = Math.max(maxBstSum, sum);
        }
        return new Info(max, min, sum, isBst, maxBstSum);

    }


}

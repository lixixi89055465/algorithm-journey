package class078;

/**
 * 创建人: @author lixiang
 * 创建时间: 2025年11月07日 16:19
 * 项目名称: algorithm-journey
 * 文件名称: Test01
 * 文件描述: @Description:
 * site:
 */
public class Test01 {
    // 不要提交这个类
    private static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    // 提交如下的方法
    public static int largestBSTSubtree(TreeNode root) {
        return f(root).maxBstSize;
    }

    public static Info f(TreeNode x) {
        if (x == null) {
            return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE, true, 0);
        }
        Info infoL = f(x.left);
        Info infoR = f(x.right);
        long max = Math.max(x.val, Math.max(infoL.max, infoR.max));
        long min = Math.min(x.val, Math.min(infoL.max, infoR.max));
        boolean isBst = infoL.isBst && infoR.isBst && infoL.max < x.val && infoR.min > x.val;
        int maxBSTSize;
        if (isBst) {
            maxBSTSize = infoL.maxBstSize + infoR.maxBstSize + 1;
        } else {
            maxBSTSize = Math.max(infoL.maxBstSize, infoR.maxBstSize);
        }
        return new Info(max,min,isBst,maxBSTSize);

    }

    private static class Info {
        public long max;
        public long min;
        public boolean isBst;
        public int maxBstSize;

        public Info(long max, long min, boolean isBst, int maxBstSize) {
            this.max = max;
            this.min = min;
            this.isBst = isBst;
            this.maxBstSize = maxBstSize;
        }
    }


    public static void main(String[] args) {

    }
}

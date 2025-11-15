package class078;

/**
 * 创建人: @author lixiang
 * 创建时间: 2025年11月07日 14:47
 * 项目名称: algorithm-journey
 * 文件名称: Test03
 * 文件描述: @Description:
 * site:
 */
public class Test03 {

    public static class Info {
        public int diameter;
        public int height;

        public Info(int a, int b) {
            diameter = a;
            height = b;
        }
    }

    // 不要提交这个类
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    // 提交如下的方法
    public static int diameterOfBinaryTree(TreeNode root) {
        return f(root).diameter;
    }

    public static Info f(TreeNode x) {
        if (x == null) {
            return new Info(0, 0);
        }
        Info leftInfo = f(x.left);
        Info rightInfo = f(x.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        int diameter = Math.max(leftInfo.diameter, rightInfo.diameter);
        diameter = Math.max(
                diameter,
                leftInfo.height + rightInfo.height + 1
        );
        return new Info(diameter, height);
    }

}

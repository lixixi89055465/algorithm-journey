package class078;

public class Test06 {
    // 遍历过程中一旦需要放置相机，ans++
    public static int ans;

    // 不要提交这个类
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    // 提交如下的方法
    public int minCameraCover(TreeNode root) {
        ans = 0;
        if (f(root) == 0) {
            ans++;
        }
        return ans;
    }

    // 递归含义
    // 假设x上方一定有父亲的情况下，这个假设很重要
    // x为头的整棵树，最终想都覆盖，
    // 并且想使用最少的摄像头，x应该是什么样的状态
    // 返回值含义
    // 0: x是无覆盖的状态，x下方的节点都已经被覆盖
    // 1: x是覆盖状态，x上没摄像头，x下方的节点都已经被覆盖
    // 2: x是覆盖状态，x上有摄像头，x下方的节点都已经被覆盖
    private int f(TreeNode x) {
        if (x == null) {
            return 1;
        }
        int left=f(x.left);
        int right=f(x.right);
        if (left == 0 || right == 0) {
            ans++;
            return 2;
        }
        if (left == 1 && right == 1) {
            return 0;
        }
        return 1;
    }

}
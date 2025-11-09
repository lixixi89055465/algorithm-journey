package class079;

import java.io.*;
import java.util.Arrays;

/**
 * 创建人: @author lixiang
 * 创建时间: 2025年11月08日 21:54
 * 项目名称: algorithm-journey
 * 文件名称: Test051
 * 文件描述: @Description:
 * site:
 */
public class Test051 {

    public static int MAXN = 301;

    public static int[] nums = new int[MAXN];

    // 链式前向星建图
    public static int edgeCnt;

    public static int[] head = new int[MAXN];

    public static int[] next = new int[MAXN];

    public static int[] to = new int[MAXN];

    // dfn的计数
    public static int dfnCnt;

    // 下标为dfn序号
    public static int[] val = new int[MAXN + 1];

    // 下标为dfn序号
    public static int[] size = new int[MAXN + 1];

    // 动态规划表
    public static int[][] dp = new int[MAXN + 2][MAXN];


    public static int n, m;

    public static void build(int n, int m) {
        edgeCnt = 1;
        dfnCnt = 0;
        Arrays.fill(head, 0, n + 1, 0);
        Arrays.fill(dp[n + 2], 0, m + 1, 0);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            in.nextToken();
            m = (int) in.nval;
            build(n, m);
            for (int i = 1; i <= n; i++) {
                in.nextToken();
                addEdge((int) in.nval, i);
                in.nextToken();
                nums[i] = (int) in.nval;
            }
            out.println(compute());
        }
        out.flush();
        ;
        out.close();
        br.close();
    }

    public static void addEdge(int u, int v) {
        next[edgeCnt] = head[u];
        to[edgeCnt] = v;
        head[u] = edgeCnt++;
    }

    public static int compute() {
        f(0);
        for (int i = n + 1; i >= 2; i--) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(
                        dp[i + size[i]][j],
                        val[i] + dp[i + 1][j - 1]
                );
            }
        }
        return nums[0] + dp[2][m];
    }

    public static int f(int u) {
        int i = ++dfnCnt;
        val[i] = nums[u];
        size[i] = 1;
        for (int ei = head[u], v; ei > 0; ei++) {
            v = to[ei];
            size[i] += f(v);
        }
        return size[i];
    }

}
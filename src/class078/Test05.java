package class078;

import java.io.*;
import java.util.Arrays;

/**
 * 创建人: @author lixiang
 * 创建时间: 2025年11月07日 11:16
 * 项目名称: algorithm-journey
 * 文件名称: Test05
 * 文件描述: @Description:
 * site:
 */
public class Test05 {
    public static int MAXN = 6001;
    public static int[] nums = new int[MAXN];
    public static int n, h;
    public static boolean[] boss = new boolean[MAXN];
    // 链式前向星建图
    public static int[] head = new int[MAXN];
    public static int[] next = new int[MAXN];
    public static int[] to = new int[MAXN];
    //动态规划表
    //no[i] : i 为头的整棵树，在i 不来的情况下，整个树能得到的最大快乐值
    public static int[] no = new int[MAXN];
    public static int[] yes = new int[MAXN];

    public static int cnt;


    public static void build(int n) {
        Arrays.fill(boss, 1, n + 1, true);
        Arrays.fill(head, 1, n + 1, 0);
        cnt = 1;

    }

    public static void addEdge(int u, int v) {
        next[cnt] = head[u];
        to[cnt] = v;
        head[u] = cnt++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            build(n);
            for (int i = 1; i <= n; i++) {
                in.nextToken();
                nums[i] = (int) in.nval;
            }
            for (int i = 1, low, high; i < n; i++) {
                in.nextToken();
                low = (int) in.nval;
                in.nextToken();
                high = (int) in.nval;
                addEdge(high, low);
                boss[low] = false;
            }
            for (int i = 1; i <= n; i++) {
                if (boss[i]) {
                    h = i;
                    break;
                }
            }
            f(h);
            out.println(Math.max(no[h], yes[h]));
        }
        out.flush();
        ;
        out.close();
        br.close();
    }


    public static void f(int u) {
        no[u] = 0;
        yes[u] = nums[u];
        for (int ei = head[u], v; ei > 0; ei = next[ei]) {
            v = to[ei];
            f(v);
            no[u] += Math.max(no[v], yes[v]);
            yes[u] += no[v];
        }
    }
}

// 好路径的数目
// 并查集 + 按最大值排序边 + 合并统计
function numberOfGoodPaths(vals: number[], edges: number[][]): number {
    const n = vals.length;
    // 初始化并查集
    const father = new Array(n);
    const maxcnt = new Array(n); // 集合中最大值出现的次数
    build(n, father, maxcnt);

    let ans = n; // 单个节点都是好路径

    // 核心排序：按边两端节点的最大值从小到大排序
    edges.sort((e1, e2) => {
        const max1 = Math.max(vals[e1[0]], vals[e1[1]]);
        const max2 = Math.max(vals[e2[0]], vals[e2[1]]);
        return max1 - max2;
    });

    // 依次合并每条边，统计新增好路径
    for (const edge of edges) {
        ans += union(edge[0], edge[1], vals, father, maxcnt);
    }

    return ans;
}

// 并查集初始化
function build(n: number, father: number[], maxcnt: number[]): void {
    for (let i = 0; i < n; i++) {
        father[i] = i;
        maxcnt[i] = 1;
    }
}

// 查找父节点（路径压缩）
function find(i: number, father: number[]): number {
    if (i !== father[i]) {
        father[i] = find(father[i], father);
    }
    return father[i];
}

// 合并两个节点，返回新增的好路径数量
function union(
    x: number,
    y: number,
    vals: number[],
    father: number[],
    maxcnt: number[]
): number {
    const fx = find(x, father);
    const fy = find(y, father);

    let path = 0;

    // 谁的值大，谁做代表节点
    if (vals[fx] > vals[fy]) {
        father[fy] = fx;
    } else if (vals[fx] < vals[fy]) {
        father[fx] = fy;
    } else {
        // 两个集合最大值相等，产生新的好路径：数量相乘
        path = maxcnt[fx] * maxcnt[fy];
        father[fy] = fx;
        maxcnt[fx] += maxcnt[fy];
    }

    return path;
}

// ==================== 测试 ====================
// 测试例子1
const vals1 = [2, 1, 1, 2, 2, 1, 1, 2];
const edges1 = [
    [0, 1],
    [0, 2],
    [1, 3],
    [2, 4],
    [2, 5],
    [5, 6],
    [6, 7]
];
console.log(numberOfGoodPaths(vals1, edges1)); // 输出 12

// 测试例子2
const vals2 = [1, 2, 2, 3, 1, 2, 2, 1, 1, 3, 3, 3, 3];
const edges2 = [
    [0, 1],
    [0, 2],
    [0, 3],
    [1, 4],
    [4, 7],
    [4, 8],
    [3, 5],
    [3, 6],
    [6, 9],
    [6, 10],
    [6, 11],
    [9, 12]
];
console.log(numberOfGoodPaths(vals2, edges2)); // 输出 24
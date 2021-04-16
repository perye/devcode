# leetcode

个人leetcode刷题笔记

## 位运算
```
num<<1          ==> num*2
num>>1          ==> num/2
num&1==1    	==> num为奇数
num&1==0    	==> num为偶数
num&-2          ==> 奇数减1, 即将末位1变为0, 和0xfffffffe(-2)取&即可;   997 & -2 = 996
n>0且n&(n-1)==0 ==>n=2^x ,满足n为2的幂
位置0（&0），位不变（&1）

0x80000000 = Integer.MIN_VALUE = -2^31
0x7fffffff = Integer.MAX_VALUE = 2^31-1
0xaaaaaaaa = 10101010101010101010101010101010 (偶数位为1，奇数位为0）
0x55555555 = 01010101010101010101010101010101 (偶数位为0，奇数位为1）
0x33333333 = 00110011001100110011001100110011 (1和0每隔两位交替出现)
0xcccccccc = 11001100110011001100110011001100 (0和1每隔两位交替出现)
0x0f0f0f0f = 00001111000011110000111100001111 (1和0每隔四位交替出现)
0xf0f0f0f0 = 11110000111100001111000011110000 (0和1每隔四位交替出现)

m = n * 2^k = n << k
m = n / 2^k = n >> k
m = n mod 2^k = n&((1<<k)-1)   ==>模运算,负数不能算

计算掩码->{
一个截取低n位的掩码 ==> (1 << n) - 1
}

子集->{ 枚举出一个集合的子集。设原集合为mask，则下面的代码就可以列出它的所有子集：
for (i = mask ; i ; i = (i - 1) & mask);
}


两个数的交换->{
a = a^b;
b = a^b = a^b^b = a;
a = a^b = a^b^a = b;
}

将整数n的最后一位为1的位变成0 ==> n & (n - 1)
平均数 ==> x = (a+b) >> 1;
取int绝对值 x^(x>>31) - (x>>31)

```
## 回溯

### 回溯模板
```
private void backtrack("原始参数") {
    //终止条件(递归必须要有终止条件)
    if ("终止条件") {
        //一些逻辑操作（可有可无，视情况而定）
        return;
    }
    for (int i = "for循环开始的参数"; i < "for循环结束的参数"; i++) {
        //一些逻辑操作（可有可无，视情况而定）
        //做出选择
        //递归
        backtrack("新的参数");
        //一些逻辑操作（可有可无，视情况而定）
        //撤销选择
    }
}
```
## 二分查找

### 二分查找的应用
1. 在半有序（旋转有序或者是山脉）数组里查找元素；
2. 确定一个有范围的整数；
3. 需要查找的目标元素满足某个特定的性质。

### 二分查找模板

#### 模板一

> 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。

**思路:**
- 在一个有序数组里查找元素，特别像以前电视「猜价格」上的猜价格游戏：运气好，一下子猜中，如果主持人说猜高了，下一步就应该往低了猜，如果主持人说猜低了，下一步就应该就往高了猜；

我们把待搜索区间的左边界下标设置为 `left`，右边界下标设置为 `right` 。

这个思路把待搜索区间 `[left, right]` 分为 3 个部分:
- `mid` 位置（只有 1 个元素）；
- `[left, mid - 1]` 里的所有元素；
- `[mid + 1, right]` 里的所有元素；

于是，二分查找就是不断地在区间` [left, right]` 里根据 `left` 和 `right` 的中间位置 `mid = (left + right) / 2` 的元素大小，也就是看 `nums[mid]` 与 `target` 的大小关系：
- 如果 `nums[mid] == target` ，返回 `mid`；
- 如果 `nums[mid] > target` ，由于数组有序，`mid` 以及 `mid` 右边的所有元素都大于 `target`，目标元素一定在区间 `[left, mid - 1]` 里，因此设置 `right = mid - 1`；
- 如果 `nums[mid] < target` ，由于数组有序，`mid` 以及 `mid` 左边的所有元素都小于 `target`，目标元素一定在区间 `[mid + 1, right]` 里，因此设置 `left = mid + 1`。

```java
class Solution {

    public int search(int[] nums, int target) {
        // 特殊用例判断
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        // 在 [left, right] 区间里查找 target
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            // 为了防止 left + right 整形溢出，写成如下形式
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                // 下一轮搜索区间：[left, mid - 1]
                right = mid - 1;
            } else {
                // 此时：nums[mid] < target
                // 下一轮搜索区间：[mid + 1, right]
                left = mid + 1;
            }
        }
        return -1;
    }
}

```

> `int mid = (left + right) / 2;` 在 `left + right` 整形溢出的时候，`mid` 会变成负数，回避这个问题的办法是写成 `int mid = left + (right - left) / 2;`。

#### 模板二

版本一
```java
class Solution {
    public int search(int[] nums, int left, int right, int target) {
        while (left < right) {
            // 选择中位数时下取整
            int mid = left + (right - left) / 2;
            if (check(mid)) {
                // 下一轮搜索区间是 [mid + 1, right]
                left = mid + 1;
            } else {
                // 下一轮搜索区间是 [left, mid]
                right = mid;
            }
        }
        // 退出循环的时候，程序只剩下一个元素没有看到。
        // 视情况，是否需要单独判断 left（或者 right）这个下标的元素是否符合题意
    }   
}
```
版本二
```java
class Solution{
    public int search(int[] nums, int left, int right, int target) {
        while (left < right) {
            // 选择中位数时上取整
            int mid = left + (right - left + 1) / 2;
            if (check(mid)) {
                // 下一轮搜索区间是 [left, mid - 1]
                right = mid - 1;
            } else {
                // 下一轮搜索区间是 [mid, right]
                left = mid;
            }
        }
        // 退出循环的时候，程序只剩下一个元素没有看到。
        // 视情况，是否需要单独判断 left（或者 right）这个下标的元素是否符合题意
    }
}
```

注意事项：
- 先写分支，再决定中间数是否上取整；
- 只要看到 `left = mid` ，它对应的取中位数的取法一定是 `int mid = left + (right - left + 1) / 2;`。


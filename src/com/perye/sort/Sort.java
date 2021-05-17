package com.perye.sort;

import java.util.Arrays;

/**
 * 排序
 *
 * @author honggd
 */
public class Sort {


    /**
     * 交换元素-引入第三个中间变量
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 交换元素-加法(可能溢出)
     */
    private static void swap2(int[] arr, int i, int j) {
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

    /**
     * 交换元素-异或(防止溢出)
     */
    private static void swap3(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }


    /**
     * 将两个有序数组合并为一个有序数组
     */
    private static int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int index1 = 0, index2 = 0;
        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] <= arr2[index2]) {
                result[index1 + index2] = arr1[index1];
                index1++;
            } else {
                result[index1 + index2] = arr2[index2];
                index2++;
            }
        }
        // 将剩余数字补到结果数组之后
        while (index1 < arr1.length) {
            result[index1 + index2] = arr1[index1];
            index1++;
        }
        while (index2 < arr2.length) {
            result[index1 + index2] = arr2[index2];
            index2++;
        }
        return result;
    }


    // ========================冒泡排序 begin========================

    /**
     * 冒泡排序
     * 最外层的 for 循环每经过一轮，剩余数字中的最大值就会被移动到当前轮次的最后一位，中途也会有一些相邻的数字经过交换变得有序。
     * 总共比较次数是 (n-1)+(n-2)+(n-3)+…+1
     * <p>
     * 时间复杂度O(n^2)
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 如果左边的数大于右边的数，则交换，保证右边的数字最大
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 冒泡排序
     * 最外层的 for 循环每经过一轮，剩余数字中的最大值仍然是被移动到当前轮次的最后一位
     * 如果一轮比较中没有发生过交换，则立即停止排序，因为此时剩余数字一定已经有序了。
     * <p>
     * 时间复杂度O(n^2)
     */
    public static void bubbleSort2(int[] arr) {
        // 初始时 swapped 为 true，否则排序过程无法启动
        boolean swapped = true;
        for (int i = 0; i < arr.length - 1; i++) {
            // 如果没有发生过交换，说明剩余部分已经有序，排序完成
            if (!swapped) {
                break;
            }
            // 设置 swapped 为 false，如果发生交换，则将其置为 true
            swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 如果左边的数大于右边的数，则交换，保证右边的数字最大
                    swap(arr, j, j + 1);
                    // 表示发生了交换
                    swapped = true;
                }
            }
        }
    }

    /**
     * 冒泡排序
     * 最外层的 while 循环每经过一轮，剩余数字中的最大值仍然是被移动到当前轮次的最后一位。
     * 在下一轮比较时，只需比较到上一轮比较中，最后一次发生交换的位置即可。因为后面的所有元素都没有发生过交换，必然已经有序了。
     * 当一轮比较中从头到尾都没有发生过交换，则表示整个列表已经有序，排序完成。
     * <p>
     * 时间复杂度O(n^2)
     */
    public static void bubbleSort3(int[] arr) {
        boolean swapped = true;
        // 最后一个没有经过排序的元素的下标
        int indexOfLastUnsortedElement = arr.length - 1;
        // 上次发生交换的位置
        int swappedIndex = -1;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < indexOfLastUnsortedElement; i++) {
                if (arr[i] > arr[i + 1]) {
                    // 如果左边的数大于右边的数，则交换，保证右边的数字最大
                    swap(arr, i, i + 1);
                    // 表示发生了交换
                    swapped = true;
                    // 更新交换的位置
                    swappedIndex = i;
                }
            }
            // 最后一个没有经过排序的元素的下标就是最后一次发生交换的位置
            indexOfLastUnsortedElement = swappedIndex;
        }
    }

    // ========================冒泡排序 end========================

    // ========================选择排序 begin========================

    /**
     * 选择排序
     * 双重循环遍历数组，每经过一轮比较，找到最小元素的下标，将其交换至首位。
     * <p>
     * 时间复杂度O(n^2)
     */
    public static void selectionSort(int[] arr) {
        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    // 记录最小值的下标
                    minIndex = j;
                }
            }
            // 将最小元素交换至首位
            swap(arr, i, minIndex);
        }
    }

    /**
     * 二元选择排序
     * 使用二元选择排序，每轮选择时记录最小值和最大值，可以把数组需要遍历的范围缩小一倍。
     * <p>
     * 时间复杂度O(n^2)
     */
    public static void selectionSort2(int[] arr) {
        int minIndex, maxIndex;
        // i只需遍历一半
        for (int i = 0; i < arr.length / 2; i++) {
            minIndex = i;
            maxIndex = i;
            for (int j = i + 1; j < arr.length - i; j++) {
                if (arr[minIndex] > arr[j]) {
                    // 记录最小值的下标
                    minIndex = j;
                }
                if (arr[maxIndex] < arr[j]) {
                    // 记录最大值的下标
                    maxIndex = j;
                }
            }
            // 如果 minIndex 和 maxIndex 都相等，那么他们必定都等于 i，且后面的所有数字都与 arr[i] 相等，此时已经排序完成
            if (minIndex == maxIndex) {
                break;
            }
            // 将最小元素交换至首位
            swap(arr, i, minIndex);
            // 如果最大值的下标刚好是 i，由于 arr[i] 和 arr[minIndex] 已经交换了，所以这里要更新 maxIndex 的值。
            if (maxIndex == i) {
                maxIndex = minIndex;
            }
            // 将最大元素交换至末尾
            swap(arr, arr.length - 1 - i, maxIndex);
        }
    }

    // ========================选择排序 end========================

    // ========================插入排序 begin========================

    /**
     * 插入排序(交换法)
     * 在新数字插入过程中，不断与前面的数字交换，直到找到自己合适的位置。
     * <p>
     * 时间复杂度O(n^2)
     */
    public static void insertSort(int[] arr) {
        // 从第二个数开始，往前插入数字
        for (int i = 1; i < arr.length; i++) {
            // j 记录当前数字下标
            int j = i;
            // 当前数字比前一个数字小，则将当前数字与前一个数字交换
            while (j >= 1 && arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
                // 更新当前数字下标
                j--;
            }
        }
    }

    /**
     * 插入排序(移动法)
     * 在新数字插入过程中，与前面的数字不断比较，前面的数字不断向后挪出位置，当新数字找到自己的位置后，插入一次即可。
     * <p>
     * 时间复杂度O(n^2)
     */
    public static void insertSort2(int[] arr) {
        // 从第二个数开始，往前插入数字
        for (int i = 1; i < arr.length; i++) {
            int currentNumber = arr[i];
            int j = i - 1;
            // 寻找插入位置的过程中，不断地将比 currentNumber 大的数字向后挪
            while (j >= 0 && currentNumber < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            // 两种情况会跳出循环：1. 遇到一个小于或等于 currentNumber 的数字，跳出循环，currentNumber 就坐到它后面。
            // 2. 已经走到数列头部，仍然没有遇到小于或等于 currentNumber 的数字，也会跳出循环，此时 j 等于 -1，currentNumber 就坐到数列头部。
            arr[j + 1] = currentNumber;
        }
    }

    // ========================插入排序 end========================

    // ========================希尔排序 begin========================

    /**
     * 希尔排序
     * <p>
     * 时间复杂度O(n*log(n))
     */
    public static void shellSort(int[] arr) {
        // 间隔序列，在希尔排序中我们称之为增量序列
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从 gap 开始，按照顺序将每个元素依次向前插入自己所在的组
            for (int i = gap; i < arr.length; i++) {
                // currentNumber 站起来，开始找位置
                int currentNumber = arr[i];
                // 该组前一个数字的索引
                int preIndex = i - gap;
                while (preIndex >= 0 && currentNumber < arr[preIndex]) {
                    // 向后挪位置
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                // currentNumber 找到了自己的位置，坐下
                arr[preIndex + gap] = currentNumber;
            }
        }
    }

    /**
     * 希尔排序(Knuth 序列)
     * <p>
     * 时间复杂度O(n*log(n))
     */
    public static void shellSort2(int[] arr) {
        // 找到当前数组需要用到的 Knuth 序列中的最大值
        int maxKnuthNumber = 1;
        while (maxKnuthNumber <= arr.length / 3) {
            maxKnuthNumber = maxKnuthNumber * 3 + 1;
        }
        // 增量按照 Knuth 序列规则依次递减
        for (int gap = maxKnuthNumber; gap > 0; gap = (gap - 1) / 3) {
            // 从 gap 开始，按照顺序将每个元素依次向前插入自己所在的组
            for (int i = gap; i < arr.length; i++) {
                // currentNumber 站起来，开始找位置
                int currentNumber = arr[i];
                // 该组前一个数字的索引
                int preIndex = i - gap;
                while (preIndex >= 0 && currentNumber < arr[preIndex]) {
                    // 向后挪位置
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                // currentNumber 找到了自己的位置，坐下
                arr[preIndex + gap] = currentNumber;
            }
        }
    }

    // ========================希尔排序 end========================


    // ========================堆排序 begin========================

    /**
     * 堆排序
     * <p>
     * 时间复杂度O(n*log(n))
     */
    public static void heapSort(int[] arr) {
        // 构建初始大顶堆
        buildMaxHeap(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            // 将最大值交换到数组最后
            swap(arr, 0, i);
            // 调整剩余数组，使其满足大顶堆
            maxHeapify(arr, 0, i);
        }
    }

    // 大顶堆

    /**
     * 构建初始大顶堆
     *
     * @param arr
     */
    public static void buildMaxHeap(int[] arr) {
        // 从最后一个非叶子结点开始调整大顶堆，最后一个非叶子结点的下标就是 arr.length / 2-1
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, i, arr.length);
        }
    }

    /**
     * 调整大顶堆
     *
     * @param arr
     * @param i
     * @param heapSize 剩余未排序的数字的数量，也就是剩余堆的大小
     */
    public static void maxHeapify(int[] arr, int i, int heapSize) {
        // 左子结点下标
        int l = 2 * i + 1;
        // 右子结点下标
        int r = l + 1;
        // 记录根结点、左子树结点、右子树结点三者中的最大值下标
        int largest = i;
        // 与左子树结点比较
        if (l < heapSize && arr[l] > arr[largest]) {
            largest = l;
        }
        // 与右子树结点比较
        if (r < heapSize && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            // 将最大值交换为根结点
            swap(arr, i, largest);
            // 再次调整交换数字后的大顶堆
            maxHeapify(arr, largest, heapSize);
        }
    }

    // 小顶堆

    /**
     * 构建初始小顶堆
     *
     * @param arr
     */
    private static void buildMinHeap(int[] arr) {
        // 从最后一个非叶子结点开始调整小顶堆，最后一个非叶子结点的下标就是 arr.length / 2-1
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            minHeapify(arr, i, arr.length);
        }
    }

    /**
     * 调整小顶堆
     *
     * @param arr
     * @param i
     * @param heapSize 剩余未排序的数字的数量，也就是剩余堆的大小
     */
    private static void minHeapify(int[] arr, int i, int heapSize) {
        // 左子结点下标
        int l = 2 * i + 1;
        // 右子结点下标
        int r = l + 1;
        // 记录根结点、左子树结点、右子树结点三者中的最小值下标
        int smallest = i;
        // 与左子树结点比较
        if (l < heapSize && arr[l] < arr[smallest]) {
            smallest = l;
        }
        // 与右子树结点比较
        if (r < heapSize && arr[r] < arr[smallest]) {
            smallest = r;
        }
        if (smallest != i) {
            // 将最小值交换为根结点
            swap(arr, i, smallest);
            // 再次调整交换数字后的小顶堆
            minHeapify(arr, smallest, heapSize);
        }
    }


    // ========================堆排序 end========================


    // ========================快速排序 begin========================

    /**
     * 快速排序
     * <p>
     * 时间复杂度O(n*log(n))
     */
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int start, int end) {
        // 如果区域内的数字少于 2 个，退出递归
        if (start >= end) {
            return;
        }
        // 将数组分区，并获得中间值的下标
        int middle = partition(arr, start, end);
        // 对左边区域快速排序
        quickSort(arr, start, middle - 1);
        // 对右边区域快速排序
        quickSort(arr, middle + 1, end);
    }

    /**
     * 分区算法
     * 从 left 开始，遇到比基数大的数，就交换到数组最后，并将 right 减一，直到 left 和 right 相遇，此时数组就被分成了左右两个区域。
     * 再将基数和中间的数交换，返回中间值的下标即可。
     * <p>
     * 将 arr 从 start 到 end 分区，左边区域比基数小，右边区域比基数大，然后返回中间值的下标
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public static int partition(int[] arr, int start, int end) {
        // 取第一个数为基数
        int pivot = arr[start];
        // 从第二个数开始分区
        int left = start + 1;
        // 右边界
        int right = end;
        // left、right 相遇时退出循环
        while (left < right) {
            // 找到第一个大于基数的位置
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            // 交换这两个数，使得左边分区都小于或等于基数，右边分区大于或等于基数
            if (left != right) {
                swap(arr, left, right);
                right--;
            }
        }
        // 如果 left 和 right 相等，单独比较 arr[right] 和 pivot
        if (left == right && arr[right] > pivot) {
            right--;
        }
        // 将基数和中间数交换
        if (right != start) {
            swap(arr, start, right);
        }
        // 返回中间值的下标
        return right;
    }

    /**
     * 双指针分区算法
     * 从 left 开始，遇到比基数大的数，记录其下标；再从 right 往前遍历，找到第一个比基数小的数，记录其下标；然后交换这两个数。
     * 继续遍历，直到 left 和 right 相遇。然后就和刚才的算法一样了，交换基数和中间值，并返回中间值的下标。
     * <p>
     * 将 arr 从 start 到 end 分区，左边区域比基数小，右边区域比基数大，然后返回中间值的下标
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public static int partition2(int[] arr, int start, int end) {
        // 取第一个数为基数
        int pivot = arr[start];
        // 从第二个数开始分区
        int left = start + 1;
        // 右边界
        int right = end;
        while (left < right) {
            // 找到第一个大于基数的位置
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            // 找到第一个小于基数的位置
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            // 交换这两个数，使得左边分区都小于或等于基数，右边分区大于或等于基数
            if (left < right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        // 如果 left 和 right 相等，单独比较 arr[right] 和 pivot
        if (left == right && arr[right] > pivot) {
            right--;
        }
        // 将基数和轴交换
        swap(arr, start, right);
        return right;
    }

    // ========================快速排序 end========================


    // ========================归并排序 begin========================

    /**
     * 归并排序
     * <p>
     * 时间复杂度O(n*log(n))
     */
    public static void mergeSort(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        int[] result = mergeSort(arr, 0, arr.length - 1);
        // 将结果拷贝到 arr 数组中
        for (int i = 0; i < result.length; i++) {
            arr[i] = result[i];
        }
    }


    /**
     * 对 arr 的 [start, end] 区间归并排序
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private static int[] mergeSort(int[] arr, int start, int end) {
        // 只剩下一个数字，停止拆分，返回单个数字组成的数组
        if (start == end) {
            return new int[]{arr[start]};
        }
        int middle = (start + end) / 2;
        // 拆分左边区域
        int[] left = mergeSort(arr, start, middle);
        // 拆分右边区域
        int[] right = mergeSort(arr, middle + 1, end);
        // 合并左右区域
        return merge(left, right);
    }

    // ========================归并排序 end========================

    // ========================计数排序 begin========================

    /**
     * 计数排序
     * <p>
     * 时间复杂度O(n)
     *
     * @param arr
     */
    public static void countingSort(int[] arr) {
        // 判空及防止数组越界
        if (arr == null || arr.length <= 1) {
            return;
        }
        // 找到最大值，最小值
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }
        // 确定计数范围
        int range = max - min + 1;
        // 建立长度为 range 的数组，下标 0~range-1 对应数字 min~max
        int[] counting = new int[range];
        // 遍历 arr 中的每个元素
        for (int element : arr) {
            // 将每个整数出现的次数统计到计数数组中对应下标的位置，这里需要将每个元素减去 min，才能映射到 0～range-1 范围内
            counting[element - min]++;
        }
        // 记录前面比自己小的数字的总数
        int preCounts = 0;
        for (int i = 0; i < range; i++) {
            // 当前的数字比下一个数字小，累计到 preCounts 中
            preCounts += counting[i];
            // 将 counting 计算成当前数字在结果中的起始下标位置。位置 = 前面比自己小的数字的总数。
            counting[i] = preCounts - counting[i];
        }
        int[] result = new int[arr.length];
        for (int element : arr) {
            // counting[element - min] 表示此元素在结果数组中的下标
            result[counting[element - min]] = element;
            // 更新 counting[element - min]，指向此元素的下一个下标
            counting[element - min]++;
        }
        // 将结果赋值回 arr
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result[i];
        }
    }

    /**
     * 倒序遍历的计数排序
     * <p>
     * 时间复杂度O(n)
     *
     * @param arr
     */
    public static void countingSort2(int[] arr) {
        // 防止数组越界
        if (arr == null || arr.length <= 1) {
            return;
        }
        // 找到最大值，最小值
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }
        // 确定计数范围
        int range = max - min + 1;
        // 建立长度为 range 的数组，下标 0~range-1 对应数字 min~max
        int[] counting = new int[range];
        // 遍历 arr 中的每个元素
        for (int element : arr) {
            // 将每个整数出现的次数统计到计数数组中对应下标的位置，这里需要将每个元素减去 min，才能映射到 0～range-1 范围内
            counting[element - min]++;
        }
        // 每个元素在结果数组中的最后一个下标位置 = 前面比自己小的数字的总数 + 自己的数量 - 1。我们将 counting[0] 先减去 1，后续 counting 直接累加即可
        counting[0]--;
        for (int i = 1; i < range; i++) {
            // 将 counting 计算成当前数字在结果中的最后一个下标位置。位置 = 前面比自己小的数字的总数 + 自己的数量 - 1
            // 由于 counting[0] 已经减了 1，所以后续的减 1 可以省略。
            counting[i] += counting[i - 1];
        }
        int[] result = new int[arr.length];
        // 从后往前遍历数组，通过 counting 中记录的下标位置，将 arr 中的元素放到 result 数组中
        for (int i = arr.length - 1; i >= 0; i--) {
            // counting[arr[i] - min] 表示此元素在结果数组中的下标
            result[counting[arr[i] - min]] = arr[i];
            // 更新 counting[arr[i] - min]，指向此元素的前一个下标
            counting[arr[i] - min]--;
        }
        // 将结果赋值回 arr
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result[i];
        }
    }


    // ========================计数排序 end========================

    // ========================基数排序 begin========================

    /**
     * 基数排序(最低位优先法LSD)
     * <p>
     * 时间复杂度O(n)
     */
    public static void radixSort(int[] arr) {
        if (arr == null) {
            return;
        }
        // 找出最长的数
        int max = 0;
        for (int value : arr) {
            if (Math.abs(value) > max) {
                max = Math.abs(value);
            }
        }
        // 计算最长数字的长度
        int maxDigitLength = 0;
        while (max != 0) {
            maxDigitLength++;
            max /= 10;
        }
        // 使用计数排序算法对基数进行排序，下标 [0, 18] 对应基数 [-9, 9]
        int[] counting = new int[19];
        int[] result = new int[arr.length];
        int dev = 1;
        for (int i = 0; i < maxDigitLength; i++) {
            for (int value : arr) {
                // 下标调整
                int radix = value / dev % 10 + 9;
                counting[radix]++;
            }
            for (int j = 1; j < counting.length; j++) {
                counting[j] += counting[j - 1];
            }
            // 使用倒序遍历的方式完成计数排序
            for (int j = arr.length - 1; j >= 0; j--) {
                // 下标调整
                int radix = arr[j] / dev % 10 + 9;
                result[--counting[radix]] = arr[j];
            }
            // 计数排序完成后，将结果拷贝回 arr 数组
            System.arraycopy(result, 0, arr, 0, arr.length);
            // 将计数数组重置为 0
            Arrays.fill(counting, 0);
            dev *= 10;
        }
    }

    // ========================基数排序 end========================


}

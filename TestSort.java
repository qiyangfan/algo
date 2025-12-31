import com.flyingcode.sort.QuickSort;
import com.flyingcode.leetcode.Leet0912SortAnArray;

public class TestSort {
    public static void main(String[] args) {
        // 测试数组
        int[] testArray = {5, 2, 9, 1, 5, 6, 3, 8, 7, 4};
        
        // 测试 QuickSort 类
        System.out.println("测试 QuickSort 类：");
        QuickSort quickSort = new QuickSort();
        int[] result1 = quickSort.sort(testArray.clone());
        printArray(result1);
        
        // 测试 Leet0912SortAnArray 类
        System.out.println("\n测试 Leet0912SortAnArray 类：");
        Leet0912SortAnArray leetSort = new Leet0912SortAnArray();
        int[] result2 = leetSort.solution(testArray.clone());
        printArray(result2);
        
        // 测试传统快排
        System.out.println("\n测试传统快排：");
        int[] result3 = quickSort.sortWithTraditionalQuickSort(testArray.clone());
        printArray(result3);
        
        System.out.println("\n所有测试完成！");
    }
    
    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
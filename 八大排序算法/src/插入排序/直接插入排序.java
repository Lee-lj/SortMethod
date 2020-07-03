package 插入排序;

import java.util.Arrays;

public class 直接插入排序 {

public static void main(String[]args){
        int[]arr=new int[]{6,5,9,4,1,7,2,8,3,0};
        insertSort(arr);

        }

//直接插入排序简单来说是冒泡排序的升级版，前一个数和后一个数字比较，如果后一个数小于前一个数，将后一个数字前移，继续和前一个数的前一个数比较(冒泡是两个数比较，直接插入是两个数比较之后将小的数继续向前比较，知道没有比它更小的数为止)，
//直到这个数大于或等于了前一个数字，再取后面的数
public static void insertSort(int[]arr){
        //从第二个数开始遍历所有的数字
	for(int i=1;i<arr.length;i++){
		//如果当前的数比前一个数小
		if(arr[i]<arr[i-1]){
			int number=arr[i];//取出当前的数
			//定义前面的数的下标
			int j;
			for(j=i-1;j>=0&&number<arr[j];j--){//依次将当前的i数与前一位比较，若i还是小于这个数，就继续向前一位比较
				arr[j+1]=arr[j];//因为这个j目前的数比i大，将i传到前面去，将j的下标向后移动一位
			}
			//把临时变量(当前取出的数)（外层for循环的当前元素）赋给不满足条件的后一个元素。因为比较的时候是跟j=i-1下标的数比较，所以前面的数不再大于当前的数的话，将让前面数的后一位作为i的位置
			arr[j+1]=number;
		}
		System.out.println(Arrays.toString(arr));
	}
}

}

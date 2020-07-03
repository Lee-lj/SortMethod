package 交换排序;

import java.util.Arrays;

public class 快速排序 {

public static void main(String[]args){
        //快速排序就是找一个基准数，定义一个尺子，一般第一个数作为尺子，，定义开始的下标，结束的下标，从结束的下标开始，如果这个数比尺子大，那这个最大下标就向前移动一位，指向新的位置。
	    //如果这个数比尺子小，就将这个数替换掉此时最小的下标的数据（开始位置为尺子），然后最大的下标保持不动。最小的下标+1，跟尺子作比较，如果比尺子小，下标加一指向新的数，如果比尺子大，
	    //将这个比尺子大的数复制，替换掉刚才停止了的最大下标指向的数(刚才这个最大下标数比尺子小，用它覆盖了最小下标的数)，然后最大下标减去1，继续跟尺子比较，大了，下标减一，小了覆盖最小下标	    
	    //如此往复，直到最大小标重合，将尺子的值粘贴到这个位置。然后根据尺子的位置就将数组分为了两部分，再按照第一轮的方式无限的递归下去就实现了排序
        int[]arr=new int[]{2,9,5,7,8,1,0,4,3,6};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        }

/**
 * @param arr 输入数组
 * @param start  输入起始的最小下标
 * @param end  输入起始的最大下标
 */
public static void quickSort(int[]arr,int start,int end){
	if(start<end){
		//定义这个循环的条件
		int compare=arr[start];
		//把数组中的第0个数字做为尺子
		int low=start;
		int high=end;
		//记录需要排序的下标
		while(low<high){//定义右边大于左边
			while(low<high&&compare<=arr[high]){//当最小下标小于最大下标，尺子小于等于最大下标所指的数时
				high--;//最大下标减去1，指向新的数
			}
			//如果右边的数比尺子小，将最大下标的数替换掉
			arr[low]=arr[high];
			//从最小下标开始，最小下标小于尺子的话，下标后移一位
			while(low<high&&arr[low]<=compare){
				low++;
			}
			arr[high]=arr[low];//如果最小下标的数比尺子大，将最小下标的数粘贴给最大下标，然后又从最大下标开始
		}
		//当最大下标最小下标重合的时候，将尺子粘贴在这个位置ֵ
		arr[low]=compare;
		//此时的数组变为了[0, 1, 2, 7, 8, 5, 9, 4, 3, 6]  
		//处理比尺子小或者等于尺子的小的数组
		quickSort(arr,start,low);
		//处理比尺子大的数组
		quickSort(arr,low+1,end);
		//Exception in thread "main" java.lang.StackOverflowError
		System.out.println(Arrays.toString(arr));
	}
}

}

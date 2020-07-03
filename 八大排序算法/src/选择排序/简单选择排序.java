package 选择排序;

import java.util.Arrays;

public class  简单选择排序 {

//简单选择排序可以说是反向的冒泡排序，第一个数作为开始，从前往后找到比它小的数，然后又向后找比这个数更小的数，然后最小的数和第一个数调换位置，然后从第二个数开始，从前往后找到比他小的数，再找比他小的数更小的数，替换最小的数和第二个数的位置，如此往复
public static void main(String[]args){
        int[]arr=new int[]{6,8,2,4,7,5,0,1,3};
        selectSort(arr);
        // System.out.println(Arrays.toString(arr));
        }

public static void selectSort(int[]arr){
        //遍历所有的数
	for(int i=0;i<arr.length;i++){
		int minIndex=i;//认为刚开始的数就是最小的数
		//把当前遍历的数和后面所有的数依次进行比较，并记录下最小的数的下标
		for(int j=i+1;j<arr.length;j++){
			if(arr[minIndex]>arr[j]){
				//依次跟后面的数比较，如果这个minIndex下标的数右比他更小的数，那么更小的数的下标就成为了新的minIndex
				minIndex=j;
			}
		}
		//如果最小的数和当前遍历数（i）的下标不一致,说明下标为minIndex的数比当前遍历的数更小。将他们两个就调换了位置
		if(i!=minIndex){
			int temp=arr[i];
			arr[i]=arr[minIndex];
			arr[minIndex]=temp;
		}
		System.out.println(Arrays.toString(arr));
	}
}

}

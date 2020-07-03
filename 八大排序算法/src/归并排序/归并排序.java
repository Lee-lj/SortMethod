package 归并排序;

import java.util.Arrays;

public class  归并排序 {

//归并排序是稳定的，用空间换取时间
//归并排序先将一个大的数组分为两个数组，再将两个继续拆分，直到拆分为单个的数，然后将两个数比较大小，然后组成一个新的数组，这个两个数的新的数组将和另一个两个数的新的数组，从第一个数开始相互比较，
//小的先放入重新建立的临时数组，然后继续比较，继续放入，这样就实现了小数组的有序化，然后这个数组继续和其他的相同长度的数组再进行第一个数的比较(因为此时数组中已经完成了由小到大的排列)
public static void main(String[]args){
	int[]arr=new int[]{2,8,0,3,4,6,1,4,2};
	System.out.println(Arrays.toString(arr));
	mergeSort(arr,0,arr.length-1);
	System.out.println(Arrays.toString(arr));
}

//将数组拆分
public static void mergeSort(int[]arr,int low,int end){
	int middle=(low+end)/2;
	if(low<end){
		//处理左边的数组
		mergeSort(arr,low,middle);
		//处理右边的数组
		mergeSort(arr,middle+1,end);
		//将两个数组归并
		merge(arr,low,middle,end);
	}
}

//两个数组归并的方法
public static void merge(int[]arr,int low,int middle,int end){
	//用于存储归并后的临时数组。数组长度是下标相减然后加一
	int[] a=new int[end-low+1];
	//记录第一个数组中需要遍历的下标
	int i=low;
	//记录第二个数组中需要遍历的下标
	int j=middle+1;
	//用于记录在临时数组中存放的下标
	int index=0;
	//遍历两个数组取出小的数字，放入临时数组中
	while(i<=middle&&j<=end){////第一个数组的数据更小ֹ
		if(arr[i]<=arr[j]){
			//把小的数据放入临时数组中
			a[index]=arr[i];
			//让临时数组下标向后移一位
			i++;
		}else{
			a[index]=arr[j];
			j++;
		}
		index++;
	}

	//如果左边的数组都放入了新数组，但是右边的数只放入了一部分，但是此时左面的数都放入了，没有跟右面比较的数，所以这个while将剩余的右面数组全部放入临时数组中
	while(j<=end){
		a[index]=arr[j];
		j++;
		index++;
	}

	//如果右边的数组都放入了新数组，但是左边的数只放入了一部分，但是此时右面的数都放入了，没有跟左面比较的数，所以这个while将剩余的左面数组全部放入临时数组中
	while(i<=middle){
		a[index]=arr[i];
		i++;
		index++;
	}

	//把临时数组中的数据重新存入原数组
	for(int z=0;z<a.length;z++){
		arr[z+low]=a[z];
	}
}

}

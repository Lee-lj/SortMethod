package 选择排序;

import java.util.Arrays;

public class  堆排序{

	/* 堆排序是将数据看成是完全二叉树、根据完全二叉树的特性来进行排序的一种算法
	 * 堆排序分为大堆顶排序和小堆顶排序
	 * 大堆顶要求节点的元素都要不小于其孩子，小堆顶要求节点元素都不大于其左右孩子
	 * 升序排序用大堆顶，降序排序用小堆顶(大堆顶的根最大，排序后根会排到最后，所以就完成了升序排序)
	 * 堆:对于任何一颗子树而言，父节点都大于他的子节点  例如对数组:9 6 1 8 2 3 4 0 7先将他转换为树，然后将树转换为大顶堆或小顶堆,转换成堆后的到如下的树:
	 *           9
	 *       8         7
	 *   6      4   3     2
	 * 1    0                       父节点都大于子节点 ，这个结构叫做大顶堆
	 * 
	 * 
	 * 大堆顶是将根节点和最后一个节点更换位置，然后取出最后一个节点保存的此时 的最大数，然后从最后一个叶子节点的父节点开始，将此时的树中的子节点跟父节点比较，再组成一个大堆顶，再交换最后一个和根节点位置，无限递归下去，直到结束
	 */
public static void main(String[]args){
        int[] arr=new int[] {9,7,2,6,4,1,3,5,10};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));//排序结果为[1, 2, 3, 4, 5, 6, 7, 9, 10]，完成
        
       
        }

//大顶堆排序            循环将这个数组调整为大顶堆。开始位置是最后一个非叶子节点位置，即最后一个节点的父节点
public static void heapSort(int[] arr) {
	//左后一个节点刚好是数组的长度，取他的父节点，就是开始位置
    int first=(arr.length-1)/2;
    //从开始位置向前将树调整为大顶堆
    for(int i=first;i>=0;i--) {
    	maxHeap(arr, arr.length, i);
    }
    //System.out.print(Arrays.toString(arr));//得到的大顶堆结果:[10, 9, 3, 7, 4, 1, 2, 5, 6]
    
    //先将数组中的第0个和最后一个数交换位置，交换之后继续调整为大堆顶
    for(int i=arr.length-1;i>0;i--) {
    	int temp=arr[0];//取出此时是数组中最大的根节点
    	arr[0]=arr[i];//将最小的节点转换为根节点
    	arr[i]=temp;//将最大的节点调整到最后
    	maxHeap(arr, i, 0);//又将这个树调整为大顶堆
    }
}

//此方法将数组组成的树转换为大顶堆   arr就是传入数组，time定义了这个大顶堆排序多少次，也就是数组的长度，因为每次都将排在最后的节点取出,index下标
public static void maxHeap(int[] arr,int time,int index) {
	//找到左子节点
	int leftNode=index*2+1;
	//找到右子节点
	int rightNode=index*2+2;
	
	//和两个子节点分别对比，找出最大的节点，作为父节点
	int max=index;
	if(leftNode<time&&arr[leftNode]>arr[max]) {
		max=leftNode;//左儿子节点如果大于父节点，那么左儿子节点就是最大的节点，在下面进行交换
	}
	if(rightNode<time&&arr[rightNode]>arr[max]) {
		max=rightNode;//右儿子节点如果大于父节点，那么右儿子节点就是最大的节点，在下面进行交换
	}
	//交换节点，如果最大的仍是index，那就不用交换
	if(max!=index) {
		int small=arr[index];
		arr[index]=arr[max];
		arr[max]=small;
		//交换位置之后，如果交换后的子节点还有子节点，并且比这个交换之后的子节点还大，就得再次排列成一个大顶堆(因为此时子节点比父节点大，已经不满足大顶堆结构),直接递归调用
		maxHeap(arr, time, max);
	}
	
}
}

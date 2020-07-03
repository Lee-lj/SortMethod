package 基数排序;

public class Myqueue {
    //���к�ջ��װ���ӵ��෴���Ƚ��ȳ����ײ���Ȼʹ��������ʵ��
    int[] elements;

    public Myqueue() {
        elements = new int[0];
    }

    //���
    public void addIn(int element) {//��ӣ������ݴ������
        int[] arr = new int[elements.length + 1];
        for (int i = 0; i < elements.length; i++) {
            arr[i] = elements[i];
        }
        arr[elements.length] = element;
        elements = arr;
    }

    //从队列中取出数据
    public int poll() {
        //���еĳ������Ƚ��ȳ���һ������һ����ڣ��ӵ�һλȡ����
        boolean flag = havaData();
        if (flag = true) {
            int element = elements[0];
            int[] arr = new int[elements.length - 1];
            for (int i = 0; i < arr.length - 1; i++) {
                arr[i] = elements[i + 1];
            }
            elements = arr;
            return element;
        } else {
            throw new NullPointerException("数据为空");
        }
    }

    //判断队列中是否还有数据
    public boolean havaData() {
        return elements.length == 0 ? true : false;
    }

}

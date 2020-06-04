package arr_copy;

/**
 * 数组的拷贝
 * @author Harlan
 */
public class ArrCopy {

    public static void main(String[] args) {
        String[] str1 = {"aa", "bb", "cc", "dd", "ee"};
        String[] str2 = new String[10];

        //cong str1 的 srcPos号元素 拷贝length长度  到 str2 5号元素开始
        System.arraycopy(str1, 0, str2, 5, 5);

        for (int i = 0; i < str2.length; i++) {
            System.out.println(i + " -- " + str2[i]);
        }

        System.out.println("====================");

        //从字符串数组中删除指定所引的元素,并将素组返回(本质上还是数组的拷贝)
        String[] str3;
        str3 = delArray(str1,4);
        for (int i = 0; i < str3.length; i++) {
            System.out.println(i + " -- " + str3[i]);
        }


        String[] strText = {"aa", "bb", "cc", "dd", "ee"};
        System.out.println("=====================");
        String[] str4 = extendArray(strText,"hello",5);
        for (int i = 0; i < str4.length; i++) {
            System.out.println(i + " -- " + str4[i]);
        }
    }

    /**
     * 从字符串数组中删除指定所引的元素,并将素组返回(本质上还是数组的拷贝)
     * @param str 原数组
     * @param index 索引小标
     * @return 新数组
     */
    public static String[] delArray(String[] str,int index){
        //减去容量
        String[] dStrArr = new String[str.length -1];
        if (index == 0){
            System.arraycopy(str,1,dStrArr,0,str.length-1);
        }else {
            //index 前部分
            System.arraycopy(str,0,dStrArr,0,index);
            //index + 1 部分(index 没拷贝 = 删除)
            System.arraycopy(str,index + 1,dStrArr,index,str.length - index -1);
        }
        return dStrArr;
    }


    /**
     * 数组的插入本质也是数组的拷贝 - 先扩容 - 再拷贝
     * @param strArr 原数组
     * @param str   插入元素
     * @param index  下标
     * @return  新数组
     */
    public static String[] extendArray(String[] strArr,String str,int index){
        //扩容
        String[] eStrArr = new String[strArr.length + 1];
        if (index == strArr.length){
            System.arraycopy(strArr,0,eStrArr,0,strArr.length);
        }else {
            //拷贝 index 前部分
            System.arraycopy(strArr,0,eStrArr,0,index + 1);
            //拷贝 index 后部分
            System.arraycopy(strArr,index,eStrArr,index + 1,strArr.length - index);
            //在index 插入
        }
        eStrArr[index] = str;
        return eStrArr;
    }
}

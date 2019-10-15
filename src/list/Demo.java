package list;

import java.util.LinkedHashMap;

/**
 * @author fengsihan
 * @date 2019/9/28 18:50
 * @desc
 */
public class Demo {
    public static void main(String[] args) {
        LinkedListNode<String> list = new LinkedListNode<>();

        list.add("aa");
//        System.out.println(list.get(0));
//        list.add(0,"bb");
//        list.add(2,"cc");
//        list.add(3,"dd");
//        list.add(0,"ee");
//        System.out.println(list);
//        System.out.println(list.get(1));
//        list.delete(4);
//        System.out.println(list);
//        System.out.println(list.reverseGet(1));
        list.add("aa");
        list.add("bb");
        list.add("bb");
        list.add("cc");
        list.add("cc");
        list.add("dd");
        list.add("ee");
        System.out.println(list);
        list.deleteDuplicaiton();

        System.out.println(list);


    }
}

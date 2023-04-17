package ss10_dsa_danh_sach.bai_tap.deployment_arraylist;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> ml = new MyList<Integer>();
        ml.add(1);
        ml.add(2);
        ml.add(3);
        ml.add(4);
        ml.add(5);
        MyList<Integer> copyList;
        copyList = (MyList<Integer>) ml.clone();
        for (int i = 0; i < copyList.size(); i++) {
            System.out.println(copyList.get(i));
        }
    }
}

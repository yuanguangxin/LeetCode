package etc.ali.q4;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    private static List<Info1> list1 = new ArrayList<>();
    private static List<Info2> list2 = new ArrayList<>();
    private static List<Info3> list3 = new ArrayList<>();

    static {
        Info1 info1 = new Info1();
        info1.setUserId(1L);
        info1.setGoodsId(1L);
        info1.setBuyTime(new Date());
        info1.setCost(20.00);
        list1.add(info1);

        Info2 info2 = new Info2();
        info2.setUserId(1L);
        info2.setGoodsId(1L);
        info2.setAddress("测试");
        list2.add(info2);
    }

    public void merge(){
        for (int i = 0; i < list1.size(); i++) {
            Long userId = list1.get(i).getUserId();
            Long goodsId = list1.get(i).getGoodsId();
            for (int j = 0; j < list2.size(); j++) {
                if (userId.equals(list2.get(j).getUserId()) && goodsId.equals(list2.get(j).getGoodsId())) {
                    Info3 info3 = new Info3(list1.get(i),list2.get(j));
                    list3.add(info3);
                }
            }
        }
    }

    public static void main(String[] args) {
        new Main().merge();
        for (int i = 0;i<list3.size();i++){
            System.out.println(list3.get(i).getUserId());
            System.out.println(list3.get(i).getGoodsId());
            System.out.println(list3.get(i).getBuyTime());
            System.out.println(list3.get(i).getCost());
            System.out.println(list3.get(i).getAddress());
        }
    }
}

package Builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildImpl implements Build {
    ComboOrder comboOrder = new ComboOrder();

    @Override
    public void createDrink(String name) {
        System.out.println("- Drink: " + name);
        comboOrder.Drink = name;
    }

    @Override
    public void createSnack(String name) {
        System.out.println("- Snack: " + name);
        comboOrder.Snack = name;
    }

    @Override
    public void createHamburger(String name) {
        System.out.println("- Hamburger: " + name);
        comboOrder.Hamburger = name;
    }

    @Override
    public ComboOrder composite(Map<Integer, String> pack) {
        if (pack != null) {
            createDrink(pack.get(0));
            createSnack(pack.get(1));
            createHamburger(pack.get(2));
        }
        return comboOrder;
    }

    @Override
    public Map<Integer, String> genPackage(String id) {
        if (!packageValidation(id)) {
            return null;
        }
        ;
        Map pack = new HashMap<Integer, String>();

        if (id.equalsIgnoreCase("0")) {
            pack.put(0, "雪碧");
            pack.put(1, "炸鸡翅");
            pack.put(2, "奥尔良鸡腿堡");
        }

        if (id.equalsIgnoreCase("1")) {
            pack.put(3, "可乐");
            pack.put(4, "薯条");
            pack.put(5, "香辣鸡腿堡");
        }

        return pack;

    }

    private boolean packageValidation(String id) {
        if (!id.equalsIgnoreCase("0") && !id.equalsIgnoreCase("1")) {
            System.out.println("Package is invalid.");
            return false;
        }
        String packageName = (id == "0") ? "奥尔良套餐" : "鸡腿堡套餐";
        System.out.println("Package is : " + packageName);
        return true;
    }

    @Override
    public Map<Integer, String> genNonComboOrder(List<Integer> orderList) {
        Map<Integer, String> order = new HashMap<Integer, String>();

        for (Integer i : orderList) {
            if (!nonComboOrderItemValidation(i)) {
                return null;
            }
            switch (i) {
                case 0:
                    order.put(i, "雪碧");
                    break;
                case 1:
                    order.put(i, "炸鸡翅");
                    break;
                case 2:
                    order.put(i, "奥尔良鸡腿堡");
                    break;
                case 3:
                    order.put(i, "可乐");
                    break;
                case 4:
                    order.put(i, "薯条");
                    break;
                case 5:
                    order.put(i, "香辣鸡腿堡");
                    break;
                default:
                    break;
            }
        }
        return order;
    }

    public void printNonComboOrder(NonComboOrder nonComboOrder){

        Build build = new BuildImpl();

        Map<Integer, String> order = nonComboOrder.getOrder();

        if(order == null){
            System.out.println("Please order again.");
            return;
        }

        for(Integer i : order.keySet()){

            String product = order.get(i);
            if( i == 0 || i == 3){
                build.createDrink(product);
            }
            if( i == 1 || i == 4 ){
                build.createSnack(product);
            }
            if( i == 2 || i == 5 ){
                build.createHamburger(product);
            }
        }
    }

    private boolean nonComboOrderItemValidation(Integer prodId) {

        if (prodId != 0 && prodId != 1 && prodId != 2 && prodId != 3 && prodId != 4 && prodId != 5) {
            String warning = String.format("Product (%s) is invalid.", prodId);
            System.out.println(warning);
            return false;
        }
        return true;
    }
}

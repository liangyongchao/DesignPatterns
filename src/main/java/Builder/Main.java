package Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static List<Integer> orderList = new ArrayList<Integer>();

    public static void main(String[]args){

        getInput();

    }

    public static void getInput(){
        System.out.println("Do you want combo pack? (Y | N )");
        Scanner scanner=new Scanner(System.in);

        String isComboPack = "";

        if (scanner.hasNext()) {
            String temp = scanner.next();
            isComboPack = (temp.equalsIgnoreCase("Y") || temp.equalsIgnoreCase("N")) ? temp : "";
        }

        if (isComboPack.equalsIgnoreCase("")){
            getInput();
        }else{
            Director(isComboPack);
        }
    }

    private static void Director(String isComboPack){
        Build build = new BuildImpl();
        if(isComboPack.equalsIgnoreCase("Y")){
            comboOrder(build);
        }

        if(isComboPack.equalsIgnoreCase("N")){
            orderList = new ArrayList<Integer>();
            System.out.println("Please input what you want (0 - 5). End with #");
            nonComboOrder(build);
        }
    }

    private static void comboOrder(Build build){
        System.out.println("Please input Package type id (0 as 奥尔良套餐 | 1 as 鸡腿堡套餐) : ");
        Scanner scanner=new Scanner(System.in);
        if (scanner.hasNext()) {
            String id = scanner.next();
            ComboOrder comboOrder = build.composite(build.genPackage(id));
        }
    }

    private static void nonComboOrder(Build build){

        Scanner scanner=new Scanner(System.in);

        if (scanner.hasNext()) {
            String prodId = scanner.next();
            if(prodId.equalsIgnoreCase("#")){
                NonComboOrder myOrder = new NonComboOrder();
                Map list = build.genNonComboOrder(orderList);
                myOrder.setOrder(list);
                build.printNonComboOrder(myOrder);
            }else{
                orderList.add(Integer.valueOf(prodId));
                nonComboOrder(build);
            }
        }
    }
}



package Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    /**
     * 定义：
     *
     *         将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。生成器模式利用一个导演者对象和具体建造者对象一个一个地建造出所有的零件，从而建造出完整的对象。
     *
     * 四个要素：
     *
     *         Builder：生成器接口，定义创建一个Product对象所需要的各个部件的操作。
     *         ConcreteBuilder：具体的生成器实现，实现各个部件的创建，并负责组装Product对象的各个部件，同时还提供一个让用户获取组装完成后的产品对象的方法。
     *         Director：指导者，也被称导向者，主要用来使用Builder接口，以一个统一的过程来构建所需要的Product对象。
     *         Product：产品，表示被生成器构建的复杂对象，包含多个部件。
     */
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
        scanner.close();
    }

    private static void nonComboOrder(Build build){

        Scanner scanner=new Scanner(System.in);
        String prodId = "";
        try{
            if (scanner.hasNext()) {
                prodId = scanner.next();
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
        }catch (Exception e){
            String warning = String.format("Input ( %s ) is invalid.", prodId);
            System.out.println(warning);
        }

        scanner.close();
    }
}



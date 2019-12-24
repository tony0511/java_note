package com.vince.ui;

import com.vince.bean.Clothes;
import com.vince.bean.Order;
import com.vince.bean.OrderItem;
import com.vince.service.ClothesService;
import com.vince.service.OrderService;
import com.vince.service.impl.ClothesServiceImpl;
import com.vince.service.impl.OrderServiceImpl;
import com.vince.utils.BusinessException;
import com.vince.utils.ConsoleTable;
import com.vince.utils.DateUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by vince on 2017/7/20.
 */
public class HomeClass extends BaseClass {

    private OrderService orderService;
    private ClothesService clothesService;

    public HomeClass(){
        orderService = (OrderService)beanFactory.getBean("orderService");
        clothesService = (ClothesService)beanFactory.getBean("clothesService");
    }

    public void show() {
        showProducts();
        println("welcome:" + currUser.getUsername());
        menu();
    }

    private void menu() {
        boolean flag = true;
        while (flag) {
            println(getString("home.function"));
            println(getString("info.select"));
            String select = input.nextLine();
            switch (select) {
                case "1": //1、查询全部订单
                    findOrderList();
                    flag = false;
                    break;
                case "2": //2、查找订单
                    findOrderById();
                    flag = false;
                    break;
                case "3": //3、购买
                    try {
                        buyProducts();
                        flag = false;
                    } catch (BusinessException e) {
                        println(e.getMessage());
                    }
                    break;
                case "4": //显示商品
                    show();
                    break;
                case "0": //0、退出
                    flag = false;
                    println(getString("info.exit"));
                    System.exit(0);
                    break;
                default:
                    println(getString("input.error"));
                    break;
            }
        }
    }

    /**
     * 购买商品
     *
     * @throws BusinessException
     */
    private void buyProducts() throws BusinessException {
        //生成订单
        boolean flag = true;
        int count = 1;
        float sum = 0.0f; //订单总金额
        Order order = new Order(); //生成的订单
        while (flag) {
            println(getString("product.input.id"));
            String id = input.nextLine();
            println(getString("product.input.shoppingNum"));
            String shoppingNum = input.nextLine();
            OrderItem orderItem = new OrderItem();
            Clothes clothes = clothesService.findById(id);

            int num = Integer.parseInt(shoppingNum);
            if (num > clothes.getNum()) {
                throw new BusinessException("product.num.error");
            }
            //一条订单明细
            clothes.setNum(clothes.getNum() - num);//减去库存
            orderItem.setClothes(clothes);
            orderItem.setShoppingNum(num);
            orderItem.setSum(clothes.getPrice() * num);
            sum += orderItem.getSum();
            orderItem.setItemId(count++);
            order.getOrderItemList().add(orderItem);

            println(getString("product.buy.continue"));
            String isBuy = input.nextLine();
            switch (isBuy) {
                case "1":
                    flag = true;
                    break;
                case "2":
                    flag = false;
                    break;
                default:
                    flag = false;
                    break;
            }
        }
        order.setCreateDate(DateUtils.toDate(new Date()));
        order.setUserId(currUser.getId());
        order.setSum(sum);
        order.setOrderId(orderService.list().size() + 1);
        orderService.buyProduct(order);
        clothesService.update();
        show();
    }

    private void findOrderById() {
        println(getString("product.order.input.oid"));
        String oid = input.nextLine();
        Order order = orderService.findById(Integer.parseInt(oid));
        if (order!=null){
            showOrder(order);
        }else{
            println(getString("product.order.error"));
        }
        menu();

    }

    //查询订单列表
    private void findOrderList() {
        List<Order> list = orderService.list();
        for (Order o : list) {
            showOrder(o);
        }
        menu();
    }

    private void showOrder(Order o) {
        print(getString("product.order.oid") + o.getOrderId());
        print("\t"+getString("product.order.createDate") + o.getCreateDate());
        println("\t"+getString("product.order.sum") + o.getSum());
        ConsoleTable t = new ConsoleTable(9, true);
        t.appendRow();
        t.appendColumn("itemId")
                .appendColumn("brand")
                .appendColumn("style")
                .appendColumn("color")
                .appendColumn("size")
                .appendColumn("price")
                .appendColumn("description")
                .appendColumn("shoppingNum")
                .appendColumn("sum");

        for (OrderItem item : o.getOrderItemList()) {
            t.appendRow();
            t.appendColumn(item.getItemId())
                    .appendColumn(item.getClothes().getBrand())
                    .appendColumn(item.getClothes().getStyle())
                    .appendColumn(item.getClothes().getColor())
                    .appendColumn(item.getClothes().getSize())
                    .appendColumn(item.getClothes().getPrice())
                    .appendColumn(item.getClothes().getDescription())
                    .appendColumn(item.getShoppingNum())
                    .appendColumn(item.getSum());
        }
        println(t.toString());
    }

    private void showProducts() {
        List<Clothes> list = clothesService.list();
        ConsoleTable t = new ConsoleTable(8, true);
        t.appendRow();
        t.appendColumn("id")
                .appendColumn("brand")
                .appendColumn("style")
                .appendColumn("color")
                .appendColumn("size")
                .appendColumn("num")
                .appendColumn("price")
                .appendColumn("description");
        for (Clothes c : list) {
            t.appendRow();
            t.appendColumn(c.getId())
                    .appendColumn(c.getBrand())
                    .appendColumn(c.getStyle())
                    .appendColumn(c.getColor())
                    .appendColumn(c.getSize())
                    .appendColumn(c.getNum())
                    .appendColumn(c.getPrice())
                    .appendColumn(c.getDescription());
        }
        println(t.toString());
    }
}

package com.boss.order.dao;

import com.boss.order.entity.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :覃玉锦
 * @create :2020-07-30 18:00:00
 * 不连数据库，模拟一些商品清单
 */
public class ItemDao {
    private ItemDao() {
    }

    private static List<Item> itemList = getItemListInstance();

    public static boolean isLogin = false;

    private static List<Item> getItemListInstance() {
        Item i1 = new Item("苹果", 3);
        Item i2 = new Item("香蕉", 4);
        Item i3 = new Item("榴莲", 5);
        Item i4 = new Item("火龙果", 10);
        Item i5 = new Item("六月瓜", 7);

        List<Item> itemList = new ArrayList<>();

        itemList.add(i1);
        itemList.add(i2);
        itemList.add(i3);
        itemList.add(i4);
        itemList.add(i5);

        return itemList;
    }

    public static List<Item> getItemList() {
        return itemList;
    }
}

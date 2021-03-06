package com.jzli.map;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * =======================================================
 *
 * @Company 产品技术部
 * @Date ：2018/4/2
 * @Author ：李金钊
 * @Version ：0.0.1
 * @Description ：
 * ========================================================
 */
public class MapTest {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int i = 1; i < 100001; i++) {
            map1.put(i, i);
        }
        map1.clear();
        System.out.println(map1.size());

        HashMap<TestBean, String> map = new HashMap<>();
        for (int i = 1; i < 101; i++) {
            map.put(new TestBean(i + "", i + ""), i + "");
        }
        String s = map.get(new TestBean(1 + "", 1 + ""));
        Map<TestBean, String> synchronizedMap = Collections.synchronizedMap(map);
        s = synchronizedMap.get(new TestBean(1 + "", 1 + ""));

        HashMap<String, String> hashMap = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            hashMap.put(i + "", i + "");
        }

        //使用迭代器遍历时，不能修改集合本身
        Iterator<String> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            iterator.remove();
            String s1 = hashMap.get(next);
            System.out.println(s1);
            String remove = hashMap.remove(next);
            System.out.println(remove);
        }
        System.out.println(hashMap);

        HashSet<TestBean> set = new HashSet<>();
        for (int i = 1; i < 101; i++) {
            set.add(new TestBean(i + "", i + ""));
        }
        TreeMap<Object, Object> objectObjectTreeMap = new TreeMap<>();

        Hashtable<TestBean, String> table = new Hashtable<>();
        for (int i = 1; i < 101; i++) {
            table.put(new TestBean(i + "", i + ""), i + "");
        }

        ConcurrentHashMap<TestBean, String> concurrentHashMap = new ConcurrentHashMap<>();
        for (int i = 1; i < 101; i++) {
            concurrentHashMap.put(new TestBean(i + "", i + ""), i + "");
        }

        //使用LinkedHashMap中的accessOrder可以维护顺序
        //（1）false，所有的Entry按照插入的顺序排列
        //（2）true，所有的Entry按照访问的顺序排列
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        for (int i = 1; i < 101; i++) {
            linkedHashMap.put(i, i + "");
        }
        linkedHashMap.get(10);
        Set<Map.Entry<Integer, String>> entries = linkedHashMap.entrySet();
        for (Map.Entry<Integer, String> entity : entries) {
            System.out.println(entity.getKey() + " = " + entity.getValue());
        }

        WeakHashMap<Integer, String> weakHashMap = new WeakHashMap();
        for (int i = 1; i < 101; i++) {
            weakHashMap.put(i, i + "");
        }
    }
}

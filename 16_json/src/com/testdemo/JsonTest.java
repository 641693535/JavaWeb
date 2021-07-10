package com.testdemo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.json.PersonListType;
import com.json.PersonMapType;
import com.pojo.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @version 1.0
 * @Description TODO
 * @Date 2021-07-02 20:30
 */
public class JsonTest {

    /**
     * JavaBean和Json互相转换
     */
    @Test
    public void test1(){
        Person pydm = new Person(1001, "捧鱼的猫");

        Gson gson = new Gson();
        //toJson()可以把Java对象转换成为Json字符串
        String personJsonStr = gson.toJson(pydm);
        System.out.println(personJsonStr);
        //fromJson()可以把Json字符串转换成Java对象
        Person person = gson.fromJson(personJsonStr, Person.class);
        System.out.println(person.toString());
    }

    /**
     * List和Json互相转换
     */
    @Test
    public void test2(){
        ArrayList<Person> personList = new ArrayList<Person>();
        personList.add(new Person(1002,"Jarry"));
        personList.add(new Person(1003,"Marry"));

        Gson gson = new Gson();
        //将List转换为Json字符串
        String personLi = gson.toJson(personList);
        System.out.println(personLi);

        //错误的！！！将Json转换为List对象
//        ArrayList fromPersonList = gson.fromJson(personLi, personList.getClass());
//        System.out.println(fromPersonList);
//
//        //将Json转换成对象后，转换成原来的类型并输出
//        Person personJ = (Person) fromPersonList.get(0);
//        System.out.println(personJ.toString());//报错！！因为fromJson的形参问题

        //正确的！！！使用Type类型的方法则可以避免 原本是集合 再从Json转换成对象的异常
        ArrayList fromPersonList = gson.fromJson(personLi, new PersonListType().getType());
        System.out.println(fromPersonList);

        //将Json转换成对象后，转换成原来的类型并输出
        Person personJ = (Person) fromPersonList.get(0);
        System.out.println(personJ.toString());
    }

    /**
     * Map和Json互相转换
     */
    @Test
    public void test3(){
        Map<String, Person> personMap = new HashMap<String, Person>();
        personMap.put("1", new Person(1005, "Jack"));
        personMap.put("2", new Person(1006, "Tom"));

        Gson gson = new Gson();
        //将map转换成json字符串
        String mapJson = gson.toJson(personMap);
        System.out.println(mapJson);

        //错误的！！！将Json字符串再转换成Map
//        Map<String, Person> map = gson.fromJson(mapJson, Map.class);
//        Person person = map.get("1");
//        System.out.println(person);

        //正确的！！！使用Type形参来转换类型
//        Map<String,Person> jsonMap = gson.fromJson(mapJson, new PersonMapType().getType());
        //使用匿名内部类来正确引导Json转换成Map对象
        Map<String, Person> jsonMap = gson.fromJson(mapJson, new TypeToken<Map<String, Person>>(){}.getType());
        Person person = jsonMap.get("1");
        System.out.println(person.toString());

    }

}

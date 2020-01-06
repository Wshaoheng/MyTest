package com.ygjx.wyq;

import com.ygjx.wyq.entity.FundType;
import org.aspectj.weaver.ast.Var;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {
        /*int count = 0;
        for (int i = 100; i <= 200; i++) {
            if(i%2 != 0 && i%3 != 0 && i%5 != 0 && i%7 != 0){
                count++;
                System.out.println(i);
            }
        }
        System.out.println(count);*/
        /*int a = 2019;
        if((a%4==0 && a%100==0) || (a%400==0)){
            System.out.println(a+"是闰年");
        }else{
            System.out.println(a+"不是闰年");
        }*/

        /*int year = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个年份:");
        if(scanner.hasNext()){
            String next = scanner.next();
            try {
                year = Integer.parseInt(next);
            }catch (NumberFormatException e){
                System.out.println("你输入的不是数字");
                e.printStackTrace();
            }
            if((year%4==0 && year%100==0) || (year%400==0)){
                System.out.println(year+"年是闰年");
            }else {
                System.out.println(year+"年不是闰年");
            }
        }
        scanner.close();*/


       /* Date date = new Date();
        System.out.println(date);
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        System.out.println(format);
        int x = 0;
        for (int i = 0; i <= 100; i++) {
            x+=i;
        }
        System.out.println(x);*/

        /*String filePath = "C:/Users/Administrator/Desktop/新建文本文档 (4).txt"; *//*GBK*//*  *//*UTF-8*//*
        File file = new File(filePath);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"GBK"));
        String re = null;
        while((re = bufferedReader.readLine()) != null){
            System.out.println(re);
        }*/

        /*File file = new File("C:/Users/Administrator/Desktop/新建文本文档 (4).txt");
        FileInputStream f = new FileInputStream(file);
        int i = 0;
        while((i = f.read()) != -1){
            System.out.println(i);
        }*/

       /* FileWriter file = new FileWriter("D:/aaa.txt");
        file.write("ajax异步提交");
        file.flush();*/

        /*File file = new File("D:/aaa.txt");
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(reader);
        StringBuffer buffer = new StringBuffer();
        String line = "";
        while ((line = br.readLine()) != null){
            buffer.append(line+";");
            System.out.println(buffer);
        }*/

       /* File file = new File("D:/a.txt");
        file.createNewFile();
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write("sssssssss");
        bw.flush();
        bw.close();*/

        File file = new File("D:/b.txt");
        FundType fundType = new FundType();
        /*FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        fundType.setTypeId(1);
        fundType.setTypeName("阿娇");
        fundType.setTypeId(2);
        fundType.setTypeName("天上白玉京");
        fundType.setTypeId(3);
        fundType.setTypeName("真皮皮");
        oos.writeObject(fundType);
        oos.flush();
        oos.close();*/

        FileInputStream fis = new FileInputStream("D:/b.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        FundType fundType1= (FundType) ois.readObject();
        System.out.println(fundType1.getTypeId());
        System.out.println(fundType1.getTypeName());
        ois.close();
    }
}

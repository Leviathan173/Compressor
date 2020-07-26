package org.Leviathan;

import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        App app = new App();
        File f = new File("TestMusic.flac");
        FileReader reader = null;
        Map<Integer, List<Integer>> resultMap = new HashMap<>();


        System.out.println(f.getName() + ";" + f.length() / 1024 / 1024 + "MB");
        try {
            reader = new FileReader(f);
            int data;
            int count = 0;
            while (true) {
                data = reader.read();
                if (data == -1) break;
                if (resultMap.get(data) == null) {
                    resultMap.put(data,new ArrayList<Integer>());
                }else {
                    resultMap.get(data).add(count);
                }
                System.out.println(count);
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
                //app.WriteResult(resultMap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for(List<Integer> list : resultMap.values()){
            // TODO 对数组进行压缩操作
            // 或许可以让数组变成String类型
            // 然后再处理
        }


    }



    void WriteResult(Map<Integer,List<Integer>> resultMap) throws IOException {
        File out = new File("out.cmp");
        out.createNewFile();
        FileWriter writer = new FileWriter(out);
        writer.write(resultMap.toString());
        writer.close();
    }
}

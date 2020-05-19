package cn.neyzoter.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试OOM<br/>
 * vm options设置为-Xmx20m -Xms5m -Xmn10m
 * @author Charles Song
 * @date 2020-5-19
 */
public class TestOom {
    public static void main (String[] args) {
        listAddManyObject();
    }

    public static void listAddManyObject () {
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < Integer.MAX_VALUE; i ++) {
            list.add(new Student("Jack" + i, i));
        }
        while (true){
            try {
                Thread.sleep(1000);
                for (Student s : list) {
                    if (s.id == 1) {
                        System.out.println(s.id);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}

class Student implements Comparable<Student>{
    public String name;
    public int id;
    public int age;
    public int weight;
    public int high;
    public boolean male;
    Student (String name, int id) {
        this.name = name;
        this.id = id;
        this.age = 10;
        this.weight = 100;
        this.high = 150;
        this.male = true;
    }

    @Override
    public int compareTo (Student s) {
        return this.id - s.id;
    }
}

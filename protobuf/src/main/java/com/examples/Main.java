package com.examples;

import com.example.tutorial.protos.Person;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        // 创建 Person 对象
        Person person = Person.newBuilder()
                .setName("Alice")
                .setEmail("alice@example.com")
                .build();

        // 序列化到文件
        try (FileOutputStream output = new FileOutputStream("person.bin")) {
            person.writeTo(output);
            System.out.println("序列化成功: " + person);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 从文件反序列化
        try (FileInputStream input = new FileInputStream("person.bin")) {
            Person deserializedPerson = Person.parseFrom(input);
            System.out.println("反序列化成功: " + deserializedPerson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
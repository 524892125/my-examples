package org.examples.controller;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;

import java.io.*;

public class WordTemplateGenerator {

    public static void main(String[] args) {
        try {
            File file = new File("word/src/main/resources/templates/wordList.docx");
            if (!file.exists()) {
                System.out.println("File not found: " + file.getAbsolutePath());
                return;
            }
            // 加载模板文档
            FileInputStream fis = new FileInputStream("word/src/main/resources/templates/wordList.docx");
            XWPFDocument document = new XWPFDocument(fis);

            // 替换文本
            for (XWPFParagraph p : document.getParagraphs()) {
                for (XWPFRun r : p.getRuns()) {
                    if (r.getText(0) != null && r.getText(0).contains("{{NAME}}")) {
                        r.setText(r.getText(0).replace("{{NAME}}", "John Doe"), 0);
                    }
                }
            }

            // 保存文档
            FileOutputStream out = new FileOutputStream("output.docx");
            document.write(out);
            out.close();
            document.close();

            System.out.println("Word文档已生成。");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.examples.word.controller;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileOutputStream;
import java.io.IOException;

public class WordGenerator {

    public static void main(String[] args) {
        try {
            // 创建一个新的 Word 文档
            XWPFDocument document = new XWPFDocument();

            // 添加一个段落
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            run.setText("Hello, World!");
            run.setFontFamily("Arial");
            run.setFontSize(12);

            // 将文档保存到磁盘
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

package com.examples.word.readExcel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

    public static void main(String[] args) {
        try {
            //创建工作簿对象
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream("user_create.xlsx"));
            //获取工作簿下sheet的个数
            int sheetNum = xssfWorkbook.getNumberOfSheets();
            System.out.println("该excel文件中总共有："+sheetNum+"个sheet");
            //遍历工作簿中的所有数据
            for(int i = 0;i<sheetNum;i++) {
                //读取第i个工作表
                System.out.println("读取第"+(i+1)+"个sheet");
                XSSFSheet sheet = xssfWorkbook.getSheetAt(i);
                //获取最后一行的num，即总行数。此处从0开始
                int maxRow = sheet.getLastRowNum();
                for (int row = 0; row <= maxRow; row++) {
                    //获取最后单元格num，即总单元格数 ***注意：此处从1开始计数***
                    int maxRol = sheet.getRow(row).getLastCellNum();
                    System.out.println("--------第" + row + "行的数据如下--------");
                    for (int rol = 0; rol < maxRol; rol++){
                        System.out.print(sheet.getRow(row).getCell(rol) + "  ");

                        // 颜色转化为rgb
                        XSSFColor bgColor = sheet.getRow(row).getCell(rol).getCellStyle().getFillForegroundColorColor();
                        if (bgColor != null) {
                            System.out.print(convertXSSFColorToRGBString(bgColor) + "  ");
                        }
                    }
                    System.out.println();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 转化为rgb字符串
     */
    public static String convertXSSFColorToRGBString(XSSFColor color) {
        if (color == null) {
            return null;
        }

        byte[] rgbBytes = color.getRGB();
        if (rgbBytes == null) {
            return null;
        }

        int red = rgbBytes[0] & 0xFF;
        int green = rgbBytes[1] & 0xFF;
        int blue = rgbBytes[2] & 0xFF;

        return String.format("#%02X%02X%02X", red, green, blue);
    }
}

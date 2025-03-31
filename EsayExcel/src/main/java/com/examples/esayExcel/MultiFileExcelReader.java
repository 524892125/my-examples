package com.examples.esayExcel;

import com.alibaba.excel.EasyExcel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiFileExcelReader {
    private static final Logger log = LogManager.getLogger(MultiFileExcelReader.class);

    public static void main(String[] args) {
        String fileName = "D:\\Download\\KIIF_Ase_Design3.0\\KIIF_Ase_Design3.0\\Prop.xlsx";
        // 读取 Excel
        // 读取 Excel 数据为 Map
        List<Map<Integer, String>> dataList = EasyExcel.read(fileName)
                .sheet() // 默认读取第一个 sheet
                .doReadSync(); // 以同步方式读取

        // 遍历打印数据
        for (Map<Integer, String> row : dataList) {
            System.out.println(row);
        }
    }
}

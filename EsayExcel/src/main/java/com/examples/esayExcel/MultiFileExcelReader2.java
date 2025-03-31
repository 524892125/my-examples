package com.examples.esayExcel;

import com.alibaba.excel.EasyExcel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

public class MultiFileExcelReader2 {
    private static final Logger log = LogManager.getLogger(MultiFileExcelReader2.class);

    public static void main(String[] args) {
        String fileName = "D:\\Download\\KIIF_Ase_Design3.0\\KIIF_Ase_Design3.0\\Prop.xlsx";

        ExcelMapListener excelMapListener = new ExcelMapListener();
        EasyExcel.read(fileName, excelMapListener).sheet().doRead();

        System.out.println("读取到数据：" + excelMapListener.getDataList());
//        log.info("读取到数据123：{}", excelMapListener.getDataList());
    }
}

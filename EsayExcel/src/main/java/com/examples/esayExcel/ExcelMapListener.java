package com.examples.esayExcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExcelMapListener extends AnalysisEventListener<Map<Integer, String>> {
    ArrayList<Map<Integer, String>> dataList = new ArrayList<>();

    public List<Map<Integer, String>> getDataList() {
        return dataList;
    }

    @Override
    public void invoke(Map<Integer, String> data, AnalysisContext context) {
        dataList.add(data);
        System.out.println("读取到一行数据：" + data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        System.out.println("所有数据读取完毕");
    }
}

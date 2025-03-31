package com.examples.esayExcel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class UserData {
    @ExcelProperty("Id")
    private String name;

    @ExcelProperty("Name")
    private Integer age;
}

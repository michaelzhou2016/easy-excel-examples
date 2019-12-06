package ai.guiji.easyexcel.examples.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemoExcelTemp {

    @ExcelProperty(value = "客户所属单位", index = 0)
    private String custCompany;

    @ExcelProperty(value = "客户名称", index = 1)
    private String custName;

    @ExcelProperty(value = "手机号码", index = 2)
    private String phone;
}

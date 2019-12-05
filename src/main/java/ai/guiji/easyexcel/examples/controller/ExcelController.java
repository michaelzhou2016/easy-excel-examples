package ai.guiji.easyexcel.examples.controller;

import ai.guiji.easyexcel.examples.dto.DemoExcelTemp;
import ai.guiji.easyexcel.examples.listener.DemoExcelListener;
import ai.guiji.easyexcel.examples.service.PhoneService;
import com.alibaba.excel.EasyExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * author: zhouliliang
 * Date: 2019/12/5 15:04
 * Description:
 */
@RestController
public class ExcelController {
    @Autowired
    private PhoneService phoneService;

    @PostMapping("/excel/read")
    public void readExcel(@RequestParam("file") MultipartFile file) {
        try {
            DemoExcelListener excelListener = new DemoExcelListener(new StopWatch(UUID.randomUUID().toString()));
            excelListener.setPhoneService(phoneService);
            EasyExcel.read(file.getInputStream(), DemoExcelTemp.class, excelListener)
                    .sheet()
                    .headRowNumber(1)
                    .doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

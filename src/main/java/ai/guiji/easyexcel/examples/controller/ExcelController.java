package ai.guiji.easyexcel.examples.controller;

import ai.guiji.easyexcel.examples.dto.DemoExcelTemp;
import ai.guiji.easyexcel.examples.entity.PlanCallPhone;
import ai.guiji.easyexcel.examples.listener.DemoExcelListener;
import ai.guiji.easyexcel.examples.service.PhoneService;
import ai.guiji.easyexcel.examples.utils.DownloadUtil;
import com.alibaba.excel.EasyExcel;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections4.CollectionUtils;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * author: zhouliliang
 * Date: 2019/12/5 15:04
 * Description:
 */
@RestController
public class ExcelController {
    @Autowired
    private PhoneService phoneService;
    @Autowired
    private RedissonClient redissonClient;

    @PostMapping("/excel/read")
    public void readExcel(@RequestParam("file") MultipartFile file) {
        try {
            DemoExcelListener excelListener = new DemoExcelListener(new StopWatch(UUID.randomUUID().toString()));
            excelListener.setPhoneService(phoneService);
            excelListener.setRedissonClient(redissonClient);
            EasyExcel.read(file.getInputStream(), DemoExcelTemp.class, excelListener)
                    .sheet()
                    .headRowNumber(1)
                    .doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/excel/download")
    public void download(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize,
                         HttpServletRequest request, HttpServletResponse response) {
        try {
            PageInfo<PlanCallPhone> page = phoneService.selectPage(pageNo, pageSize);
            if (Objects.nonNull(page) && CollectionUtils.isNotEmpty(page.getList())) {
                List<DemoExcelTemp> demoExcelTempList = page.getList().stream()
                        .map(phone -> new DemoExcelTemp(phone.getCustCompany(), phone.getCustName(), phone.getPhone()))
                        .collect(Collectors.toList());
                DownloadUtil.createExcelStreamMutilByEaysExcel(request, response, "客户电话", demoExcelTempList, DemoExcelTemp.class);
            }
        } catch (Exception ex) {

        }
    }
}

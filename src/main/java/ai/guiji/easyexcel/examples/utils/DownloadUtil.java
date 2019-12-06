package ai.guiji.easyexcel.examples.utils;

import com.alibaba.excel.EasyExcel;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * author: zhouliliang
 * Date: 2019/12/5 21:05
 * Description:
 */
public class DownloadUtil {

    public static void createExcelStreamMutilByEaysExcel(HttpServletRequest request, HttpServletResponse response, String name, List<?> exportList, Class clazz) {
        try {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Pragma", "public");
            response.setHeader("Cache-Control", "no-store");
            response.addHeader("Cache-Control", "max-age=0");

            //firefox与其他浏览器不同，会是乱码。chrome不是乱码
            String agent = request.getHeader("USER-AGENT").toLowerCase();
            String newFileName = URLEncoder.encode(name, "UTF-8");
            if (agent.contains("firefox")) {
                newFileName = URLEncoder.encode(new String(name.getBytes("UTF-8"), "ISO8859-1"), "ISO8859-1");
            }

            response.setHeader("Content-disposition", "attachment;filename=" + newFileName + ".xlsx");
            ServletOutputStream out = response.getOutputStream();

            EasyExcel.write(out, clazz).sheet(name).doWrite(exportList);

            out.flush();
        } catch (IOException e) {

        }

    }

}

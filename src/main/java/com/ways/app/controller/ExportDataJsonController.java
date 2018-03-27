package com.ways.app.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;


import com.ways.app.domain.AllData;
import com.ways.app.service.ExportDataJsonService;
import com.ways.app.utils.JsonFormatTool;
import com.ways.app.utils.JsonUtil;

@Controller
public class ExportDataJsonController {
	
	@Autowired
	ExportDataJsonService exportDataJsonService;
	
	
	
//	@Scheduled(cron = "0 15 2 ? * *")//每天上午2:15触发 
	@Scheduled(fixedDelay = 10000000)
	public void reportCurrentTime() throws InterruptedException, IOException {
		
		 
		HashMap map = new HashMap<>();
		
		
		
		String path="C:\\Users\\huangkaisheng\\Desktop\\text.json";
		// 保证创建一个新文件
        File file = new File(path);
        if (!file.getParentFile().exists()) { // 如果父目录不存在，创建父目录
            file.getParentFile().mkdirs();
        }
        if (file.exists()) { // 如果已存在,删除旧文件
            file.delete();
        }
        file.createNewFile();

		System.err.println(new Date());
		
		List<AllData> List = exportDataJsonService.ExportDataJson(map);
		List.get(0).setWholeSalePredict("212");
		List.get(0).setRetailSalePredict("173");
		String jsonString = JsonUtil.toJsonString(List.get(0));
		
		jsonString = JsonFormatTool.formatJson(jsonString);
		
		Writer write = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
        write.write(jsonString);
        write.flush();
        write.close();

	}
}

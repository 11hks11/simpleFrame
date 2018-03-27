package com.ways.app.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ways.app.domain.AllData;
import com.ways.app.service.ExportDataJsonService;
import com.ways.app.utils.JsonUtil;

@Controller
public class hello {

	@Autowired
	ExportDataJsonService exportDataJsonService;
	
	 @RequestMapping("/")
	    String home() throws IOException {
		 
		 
		 
		 HashMap map = new HashMap<>();
		 List<AllData> List = exportDataJsonService.ExportDataJson(map);
		 System.out.println(List.size()+">>>>>>>>>>>>>>>>>>");
		 
		 AllData allData =new AllData();
		 JsonUtil.toJsonString(List.get(0));
		 
		 System.out.println(JsonUtil.toJsonString(List.get(0)));
	        return "hello";
	    }

}

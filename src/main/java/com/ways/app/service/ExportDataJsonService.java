package com.ways.app.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ways.app.domain.AllData;


public interface ExportDataJsonService {
	
	List<AllData> ExportDataJson(Map map);
	
	
}

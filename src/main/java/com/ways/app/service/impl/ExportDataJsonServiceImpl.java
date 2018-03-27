package com.ways.app.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ways.app.dao.ExportDataMapper;
import com.ways.app.domain.AllData;
import com.ways.app.service.ExportDataJsonService;


@Service
public class ExportDataJsonServiceImpl implements ExportDataJsonService{

	
	@Autowired
	ExportDataMapper exportDataMapper; 
	
	@Override
	public List<AllData> ExportDataJson(Map map) {
		
		List<AllData> list = exportDataMapper.ExportData(map);
		
		return list;
	}

	
	
}

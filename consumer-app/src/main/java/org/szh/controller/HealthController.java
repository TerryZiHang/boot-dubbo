package org.szh.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.szh.beans.HealthData;
import org.szh.result.Result;
import org.szh.service.HealthService;

import com.alibaba.dubbo.config.annotation.Reference;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "health")
public class HealthController {
	
	@Reference
	private HealthService healthService;
	
	@ApiOperation(value = "添加信息",notes = "添加信息")
	@RequestMapping(value = "/add",method= RequestMethod.POST)
	public Result<?> add(@RequestBody HealthData data) {
		healthService.addData(data);
		return new Result<>();
	}
	
	@ApiOperation(value = "获取所有信息列表",notes = "获取所有信息列表")
	@RequestMapping(value = "/list",method= RequestMethod.POST)
	public Result<?> list() {
		return new Result<>(healthService.getAllData());
	}
	
}

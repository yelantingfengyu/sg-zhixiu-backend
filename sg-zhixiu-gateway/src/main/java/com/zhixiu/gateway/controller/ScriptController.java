package com.zhixiu.gateway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zhixiu.gateway.model.Script;
import com.zhixiu.gateway.page.PageRequest;
import com.zhixiu.gateway.service.ScriptService;
import com.zhixiu.util.vo.ResponseData;

/**
 * script控制器
 * 
 * @author administrator
 * @date 2020年2月18日 16:00:23
 */
@RestController
@RequestMapping("script")
public class ScriptController {

	@Autowired
	private ScriptService scriptService;

	@PreAuthorize("hasAuthority('record:script:add') AND hasAuthority('record:script:edit')")
	@PostMapping(value = "/save")
	public ResponseData save(@RequestBody Script record) {
		System.out.println(record);
		return ResponseData.getSuccessResult(scriptService.save(record));
	}

	@PreAuthorize("hasAuthority('record:script:delete')")
	@PostMapping(value = "/delete")
	public ResponseData delete(@RequestBody List<Script> records) {
		return ResponseData.getSuccessResult(scriptService.delete(records));
	}

	@PreAuthorize("hasAuthority('record:script:view')")
	@PostMapping(value = "/findPage")
	public ResponseData findPage(@RequestBody PageRequest pageRequest) {
		return ResponseData
		        .getSuccessResult(scriptService.findPage(pageRequest));
	}

	@PreAuthorize("hasAuthority('record:script:view')")
	@GetMapping(value = "/findAll")
	public ResponseData findAll() {
		return ResponseData.getSuccessResult(scriptService.findAll());
	}

	@PreAuthorize("hasAuthority('record:script:view')")
	@GetMapping(value = "/findByScriptName")
	public ResponseData findByScriptName(
	        @RequestParam("scriptName") String scriptName) {
		return ResponseData
		        .getSuccessResult(scriptService.findByScriptName(scriptName));
	}

	@PreAuthorize("hasAuthority('record:script:view')")
	@GetMapping(value = "/findByPackageName")
	public ResponseData findByPackageName(
	        @RequestParam("packageName") String packageName) {
		return ResponseData
		        .getSuccessResult(scriptService.findByPackageName(packageName));
	}

	@PreAuthorize("hasAuthority('record:script:view')")
	@PostMapping(value = "/findPageByAppId")
	public ResponseData findPageByAppId(@RequestBody PageRequest pageRequest) {
		return ResponseData
		        .getSuccessResult(scriptService.findPageByAppId(pageRequest));
	}
}

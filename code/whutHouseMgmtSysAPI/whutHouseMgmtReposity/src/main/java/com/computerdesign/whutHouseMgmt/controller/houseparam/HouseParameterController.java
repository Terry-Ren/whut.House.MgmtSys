package com.computerdesign.whutHouseMgmt.controller.houseparam;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.houseparam.HouseParameter;
import com.computerdesign.whutHouseMgmt.service.houseparam.HouseParamService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping("/houseParam/")
@Controller
public class HouseParameterController {

	@Autowired
	private HouseParamService houseParamService;
	
	/**
	 * 获取全部的houseParamId
	 * @param paramTypeId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getHouseParamId/{paramTypeId}" , method = RequestMethod.GET)
	public Msg getHouseTypePar(@PathVariable("paramTypeId") Integer paramTypeId){
		List<Integer> houseParamIds= houseParamService.getHouseParamId(paramTypeId);
		return Msg.success().add("data", houseParamIds);
	}
	
	/**
	 * @param paramTypeId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getWithoutPage/{paramTypeId}", method = RequestMethod.GET)

	public Msg getHouseParameter(@PathVariable("paramTypeId") Integer paramTypeId) {
		List<HouseParameter> houseParams = houseParamService.getAll(paramTypeId);
		//

		if (houseParams != null) {
			return Msg.success().add("data", houseParams);
		} else {
			return Msg.error();
		}
	}
	
	/**
	 * paramTypeId：
	 * 1-住房类型
	 * 2-户型
	 * 3-使用状态
	 * 4-住房结构
	 * @param paramTypeId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "get/{paramTypeId}", method = RequestMethod.GET)

	public Msg getHouseParameter(@PathVariable("paramTypeId") Integer paramTypeId,
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size) {
		PageHelper.startPage(page, size);
		List<HouseParameter> houseParams = houseParamService.getAll(paramTypeId);
		//
		PageInfo pageInfo = new PageInfo(houseParams);

		if (houseParams != null) {
			return Msg.success().add("data", pageInfo);
		} else {
			return Msg.error();
		}
	}

	/**
	 * @param houseParameter
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Msg addHouseParameter(@RequestBody HouseParameter houseParameter) {
		List<HouseParameter> listHouseParameter = houseParamService.getAll(houseParameter.getParamTypeId());
		if (houseParameter.getHouseParamName() != null) {
			for (HouseParameter houseParamAlready : listHouseParameter) {
				if (houseParameter.getHouseParamName().equals(houseParamAlready.getHouseParamName())) {
					return Msg.error("该名称已存在，无法添加");
				}
			}
			if (houseParameter.getParamTypeId() != null) {
				
				houseParamService.add(houseParameter);
				
				return Msg.success().add("data", houseParameter);
			} else {
				return Msg.error("必要信息不完整，添加失败");
			}
		} else {
			return Msg.error("必要信息不完整，添加失败");
		}
	}


	/**
	 * @param houseParamId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "delete/{houseParamId}", method = RequestMethod.DELETE)
	public Msg deleteHouseParam(@PathVariable("houseParamId") Integer houseParamId) {
		HouseParameter houseParameter = houseParamService.get(houseParamId);
		if (houseParameter != null) {
			try {
				houseParameter.setIsDelete(true);
				//更新操作，且不可逆
				houseParamService.update(houseParameter);
				return Msg.success().add("data", houseParameter);
			} catch (Exception e) {
				// TODO: handle exception
				return Msg.error();
			}
		} else {
			return Msg.error("找不到该id，删除出错");
		}
	}

	/**
	 * @param houseParameter
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "modify", method = RequestMethod.PUT)
	public Msg modifyHouseParam(@RequestBody HouseParameter houseParameter) {
		try {
			houseParamService.update(houseParameter);
			return Msg.success().add("data", houseParameter);
		} catch (Exception e) {
			// TODO: handle exception
			return Msg.error("数据库中没有找到此条记录，修改失败 ");
		}
	}
}

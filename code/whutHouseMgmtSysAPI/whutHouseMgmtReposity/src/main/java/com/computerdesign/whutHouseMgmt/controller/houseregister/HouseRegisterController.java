package com.computerdesign.whutHouseMgmt.controller.houseregister;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.house.House;
import com.computerdesign.whutHouseMgmt.bean.houseManagement.house.ViewHouse;
import com.computerdesign.whutHouseMgmt.bean.houseregister.HouseAllSelectModel;
import com.computerdesign.whutHouseMgmt.bean.houseregister.HouseAllShowModel;
import com.computerdesign.whutHouseMgmt.bean.houseregister.HouseSelectModel;
import com.computerdesign.whutHouseMgmt.bean.houseregister.HouseShowModel;
import com.computerdesign.whutHouseMgmt.bean.houseregister.OutSchoolHouse;
import com.computerdesign.whutHouseMgmt.bean.houseregister.OutSchoolHouseRelShow;
import com.computerdesign.whutHouseMgmt.bean.houseregister.OutSchoolHouseVw;
import com.computerdesign.whutHouseMgmt.bean.houseregister.Resident;
import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentHistory;
import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentRegister;
import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentVw;
import com.computerdesign.whutHouseMgmt.bean.houseregister.StaffHouseRel;
import com.computerdesign.whutHouseMgmt.bean.param.houseparam.HouseParameter;
import com.computerdesign.whutHouseMgmt.bean.staffhomepage.houseinfo.ResidentHouse;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.Staff;
import com.computerdesign.whutHouseMgmt.service.house.HouseService;
import com.computerdesign.whutHouseMgmt.service.houseparam.HouseParamService;
import com.computerdesign.whutHouseMgmt.service.houseregister.HouseRegisterSelectService;
import com.computerdesign.whutHouseMgmt.service.houseregister.OutSchoolHouseService;
import com.computerdesign.whutHouseMgmt.service.houseregister.RegisterService;
import com.computerdesign.whutHouseMgmt.service.houseregister.StaffHouseRelService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.StaffService;
import com.computerdesign.whutHouseMgmt.utils.ResponseUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping(value = "/houseRegister/")
@Controller
public class HouseRegisterController {

	@Autowired
	private HouseRegisterSelectService houseRegisterSelectService;

	@Autowired
	private StaffHouseRelService staffHouseRelService;

	@Autowired
	private RegisterService registerService;

	@Autowired
	private HouseService houseService;

	@Autowired
	private HouseParamService houseParamService;

	@Autowired
	private OutSchoolHouseService outSchoolHouseService;

	@Autowired
	private StaffService staffService;
	
	/**
	 * 根据住房号获取所有的住房关系历史数据
	 * @param houseId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="getAllResidentDataByHouseId/{houseId}", method = RequestMethod.GET)
	public Msg getAllResidentDataByHouseId(@PathVariable("houseId") Integer houseId){
		List<ResidentHouse> residentHouses = staffHouseRelService.getAllResidentByHouseId(houseId);
		
		String[] fileds = { "residentId" ,"staffId", "staffNo", "houseRelName", "usedArea", "bookTime", "expireTime"};
		List<Map<String, Object>> response = ResponseUtil.getResultMap(residentHouses, fileds);
		
		return Msg.success().add("data", response);
	}
	
	/**
	 * 根据职工号获取所有的住房关系数据，包括历史数据  添加缴费方式（通过view_hs_residentHouse表实现，根据isDelete字段判断是否删除）
	 * @param residentId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getAllResidentDataByStaffId/{staffId}", method = RequestMethod.GET)
	public Msg getAllResidentDataByStaffId(@PathVariable("staffId") Integer staffId){
		List<ResidentHouse> residentHouses = staffHouseRelService.getAllResidentByStaffId(staffId);
		
		String[] fileds = { "residentId" ,"houseId" ,"houseNo", "houseTypeName", "houseRelName", "usedArea", "bookTime", "expireTime", "address", "payType" };
		List<Map<String, Object>> response = ResponseUtil.getResultMap(residentHouses, fileds);
		
		return Msg.success().add("data", response);
	}
	
	/**
	 * 解除住房关系，即删除住房关系，但是保存住房登记历史记录
	 * 
	 * @return
	 */
	@RequestMapping(value = "relieveHouseRel/{residentId}", method = RequestMethod.DELETE)
	@ResponseBody
	public Msg relieveHouseRel(@PathVariable("residentId") Integer residentId) {
		// 获取该住房登记记录
		Resident resident = registerService.getResident(residentId);
		if (resident == null) {
			return Msg.error("无该id的记录");
		}
		// 删除，即设置isDelete字段为1
		resident.setIsDelete(true);
		
		//20190726 添加
		resident.setExpireTime(new Date());
		House house = houseService.get(resident.getHouseId());
		
		//状态修改为空闲，空闲在pm_housetype表中的值为24
		house.setStatus(24);
		houseService.update(house);
				
		registerService.deleteResident(resident);

		return Msg.success("解除成功");
	}

	/**
	 * 20190729修改 删除住房历史租赁信息，在租金核算过程中租赁天数也会被删除
	 * 删除住房关系，即删除住房关系和住房登记历史记录
	 * 
	 * @return
	 */
	@RequestMapping(value = "deleteHouseRel/{residentId}", method = RequestMethod.DELETE)
	@ResponseBody
	public Msg deleteHouseRel(@PathVariable("residentId") Integer residentId) {
		// 获取该住房登记记录
//		Resident resident = registerService.getResident(residentId);
//		if (resident == null) {
//			return Msg.error("无该id的记录");
//		}
		// 删除，即设置isDelete字段为1
//		resident.setIsDelete(true);
//		registerService.deleteResident(resident);

		//若该住房正在被租赁，则需将该住房的状态设置为空闲
			// 获取该住房登记记录
		Resident resident = registerService.getResident(residentId);
			// 获取房屋信息
		House house = houseService.get(resident.getHouseId());
		house.setStatus(24);
		houseService.update(house);
		
		//从数据库删除住房记录
		registerService.delete(residentId);
		
		
		// 删除住房登记历史记录
		try {
			registerService.deleteResidentHistory(residentId);
		} catch (Exception e) {
			System.out.println("住房登记历史记录表中没有该数据");
		}
		
		return Msg.success("删除成功").add("data", resident);
	}

	/**
	 * 登记关系设置，提交修改的登记关系
	 * 
	 * @return
	 */
	@RequestMapping(value = "updateRegisterRel", method = RequestMethod.POST)
	@ResponseBody
	@Transactional
	public Msg updateRegisterRel(@RequestBody HouseParameter[] houseParameters) {
		// if(houseParameters == null){
		// return Msg.error("数据封装错误");
		// }

		if (houseParameters.length == 0) {
			return Msg.error("您没有做任何修改");
		}

		for (HouseParameter houseParameter : houseParameters) {
			if (houseParameter.getHouseParamId() == null) {
				return Msg.error("需要传递id");
			}
			// 可能需要加事务处理优化
			registerService.updateRegisterRel(houseParameter);
			// System.out.println(houseParameter);
		}

		// 显示HouseParamName和修改后的HouseParamRel
		return Msg.success("设置成功");
	}

	/**
	 * 登记关系设置，获取所有登记关系，使用pm_housetype表，paramTypeId为1
	 * 
	 * @return
	 */
	@RequestMapping(value = "getRegisterRel", method = RequestMethod.GET)
	@ResponseBody
	public Msg getRegisterRel() {
		List<HouseParameter> houseParameters = registerService.getRegisterRel();
		if (houseParameters == null) {
			return Msg.error("数据库中无数据或被删除");
		}
		return Msg.success().add("data", houseParameters);
	}

	/**
	 * 判断该住房是否已有人登记居住
	 * 
	 * @param resident
	 * @return
	 */
	@RequestMapping(value = "isRegistered", method = RequestMethod.POST)
	@ResponseBody
	public Msg isRegistered(@RequestBody Resident resident) {
		if (registerService.getCountByHouseId(resident.getHouseId()) > 0) {
			List<ResidentVw> residentVws = registerService.getResidentVwByHouseId(resident.getHouseId());
			String message = "";
			for (ResidentVw residentVw : residentVws) {
				String name = residentVw.getStaffName();
				String dept = residentVw.getStaffDeptName();
				String sex = residentVw.getStaffSex();
				message = message + "姓名：" + name + "," + "单位：" + dept + ",性别" + sex + ";";
			}
			return Msg.success("该住房已经有人入住," + message + ",您确定继续登记吗?");
		}
		return null;
	}

	/**
	 * 住房登记
	 * 
	 * @param resident
	 * @return
	 */
	@RequestMapping(value = "register", method = RequestMethod.PUT)
	@ResponseBody
	public Msg register(@RequestBody ResidentRegister residentRegister) {
		// System.out.println(resident.getStaffId());
		// System.out.println(registerService.getCount());
		// 根据数据库中的记录数+1
		// resident.setId(registerService.getCount()+1);
		try {
//			System.out.println(residentRegister.getHouse());
			Integer houseId = Integer.parseInt(residentRegister.getHouse());
//			System.out.println(houseId);
			Resident resident = new Resident();
			resident.setStaffId(residentRegister.getStaffId());
			resident.setHouseId(houseId);
			resident.setHouseRel(residentRegister.getHouseRel());
			resident.setBookTime(residentRegister.getBookTime());
			resident.setIsDelete(false);
			
			//如果住房登记选择是购房，则添加一个购房款
			if(resident.getHouseRel() == 26){
				Staff staff = staffService.get(residentRegister.getStaffId());
				Long buyAccount = null; 
				try {
					buyAccount = (long) residentRegister.getBuyAccount();
				} catch (Exception e) {
					return Msg.error("输入正确格式的购房款");
				}
				staff.setBuyAccount(buyAccount);
				staff.setIsOwnPriHouse(true);
				staffService.update(staff);
			}
			
			//设置缴费方式
			if(residentRegister.getPayType() != null){				
				resident.setPayType(residentRegister.getPayType());
			}else{
				return Msg.error("请选择缴费方式");
			}
			
			if (resident.getStaffId() == null) {
				return Msg.error("请选择一个员工");
			}
			if (resident.getHouseId() == null) {
				return Msg.error("请选择住房");
			}
			// 若没有选择住房关系，则默认为全部，返回0，错误提示
			if (resident.getHouseRel() == 0) {
				return Msg.error("住房关系不能选择全部");
			}

			resident.setFamilyCode(resident.getStaffId().toString());
			// 具体可能要见Rent表，如果是租赁，则设置为工资
			String houseParamName = houseParamService.get(resident.getHouseRel()).getHouseParamName();
			if (houseParamName.equals("租赁")) {
				resident.setRentType("工资");
			}

			if (registerService.getCountByHouseId(resident.getHouseId()) > 0) {

				return Msg.error("该住房已有人入住，请您核对......");
				// List<Resident> residents =
				// registerService.getResidentByHouseId(resident.getHouseId());
				// if(residents.contains(resident)){
				// return Msg.error("该职工与该住房已进行过登记,请您核对……");
				// }
			}
			if (registerService.getCountByStaffId(resident.getStaffId()) > 0) {
				List<Resident> residents = registerService.getResidentsByStaffId(resident.getStaffId());
				// System.out.println(residents);
				// System.out.println(resident);
				if (residents.contains(resident)) {
					return Msg.error("该职工已购买或租赁一套住房");
				}
			}

			registerService.register(resident);
			House house = houseService.get(resident.getHouseId());
			// 改变房屋状态
			house.setStatus(resident.getHouseRel());
			houseService.update(house);

			Resident residentHaveId = registerService.getByAllField(resident);

			ResidentHistory residentHistory = new ResidentHistory();
			residentHistory.setResidentId(residentHaveId.getId());
			residentHistory.setStaffId(resident.getStaffId());
			residentHistory.setHouseId(resident.getHouseId());
			residentHistory.setHouseRelation(resident.getHouseRel());
			// 先默认是初始登记，待修改
			residentHistory.setIsBook(true);
			residentHistory.setBookTime(resident.getBookTime());
			residentHistory.setSysTime(new Date());
			registerService.registerHistory(residentHistory);

			return Msg.success().add("data", resident);
		} catch (NumberFormatException e) {
			// 当传入的houseId为字符串时，插入到校外房表即hs_outschoolhouse
			// System.out.println(houseParamService.get(residentRegister.getHouseRel()).getHouseParamName());
			if (houseParamService.get(residentRegister.getHouseRel()).getHouseParamName().equals("私有")) {
				OutSchoolHouse outSchoolHouse = new OutSchoolHouse();
				outSchoolHouse.setStaffId(residentRegister.getStaffId());
				outSchoolHouse.setAddress(residentRegister.getHouse());
				outSchoolHouse.setHouseRel(residentRegister.getHouseRel());
				outSchoolHouse.setBookTime(residentRegister.getBookTime());
				outSchoolHouseService.outSchoolHouseRegister(outSchoolHouse);
				return Msg.success("登记成功").add("data", outSchoolHouse);
			} else {
				return Msg.error("住房关系有误，只能为私有");
			}

		}

	}

	/**
	 * 职工房屋关系查询
	 * 
	 * @param staffId
	 * @return
	 */
	@RequestMapping(value = "getStaffHouseRel/{staffId}", method = RequestMethod.GET)
	@ResponseBody
	public Msg getStaffHouseRel(@PathVariable("staffId") Integer staffId) {
		if (staffId != null) {
			// 获取校内房住房关系
			List<StaffHouseRel> staffHouseRels = staffHouseRelService.selectByStaffId(staffId);

			// 获取校外房住房关系
			List<OutSchoolHouseVw> outSchoolHouseVws = outSchoolHouseService.getOutSchoolHouseVwByStaffId(staffId);
			List<OutSchoolHouseRelShow> outSchoolHouseRelShows = new ArrayList<OutSchoolHouseRelShow>();
			for (OutSchoolHouseVw outSchoolHouseVw : outSchoolHouseVws) {
				OutSchoolHouseRelShow oshrw = new OutSchoolHouseRelShow();
				oshrw.setStaffName(outSchoolHouseVw.getStaffName());
				oshrw.setHouseRel(outSchoolHouseVw.getHouseRelName());
				oshrw.setAddress(outSchoolHouseVw.getAddress());
				outSchoolHouseRelShows.add(oshrw);
			}
			return Msg.success().add("data", staffHouseRels).add("outSchoolHouse", outSchoolHouseRelShows);
		}
		return Msg.error();
	}

	/**
	 * 全面多条件查询
	 * 
	 * @param houseSelectModel
	 * @return
	 */
	@RequestMapping(value = "getByAllMultiCondition", method = RequestMethod.POST)
	@ResponseBody
	public Msg getByAllMultiCondition(@RequestBody HouseAllSelectModel houseAllSelectModel,
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "5") Integer size) {
		PageHelper.startPage(page, size);
		// 查询出所有符合条件的视图所有数据
		List<ViewHouse> viewHouses = houseRegisterSelectService.getByAllMultiConditionQuery(houseAllSelectModel);

		// 声明一个list，用于封装需要的数据
		List<HouseAllShowModel> houseAllShowModels = new ArrayList<HouseAllShowModel>();

		// 给需要返回显示的数据赋值
		for (ViewHouse viewHouse : viewHouses) {
			HouseAllShowModel houseAllShowModel = new HouseAllShowModel();
			houseAllShowModel.setHouseId(viewHouse.getId());
			houseAllShowModel.setHouseNo(viewHouse.getNo());
			houseAllShowModel.setHouseSort(viewHouse.getTypeName());
			houseAllShowModel.setHouseType(viewHouse.getLayoutName());
			houseAllShowModel.setUseStatus(viewHouse.getStatusName());
			houseAllShowModel.setBuildArea(viewHouse.getBuildArea());
			houseAllShowModel.setUsedArea(viewHouse.getUsedArea());
			houseAllShowModel.setBasementArea(viewHouse.getBasementArea());
			houseAllShowModel.setAddress(viewHouse.getAddress());
			houseAllShowModel.setFinishTime(viewHouse.getFinishTime());
			houseAllShowModel.setCampusName(viewHouse.getCampusName());
			houseAllShowModel.setBuildingName(viewHouse.getBuildingName());
			houseAllShowModel.setStructName(viewHouse.getStructName());
			houseAllShowModels.add(houseAllShowModel);
		}
		PageInfo pageInfo = new PageInfo(viewHouses);
		pageInfo.setList(houseAllShowModels);
		// System.out.println(houseAllShowModels);

		return Msg.success().add("data", pageInfo);
	}

	/**
	 * 多条件查询
	 * 
	 * @param houseSelectModel
	 * @return
	 */
	@RequestMapping(value = "getByMultiCondition", method = RequestMethod.POST)
	@ResponseBody
	public Msg getByMultiCondition(@RequestBody HouseSelectModel houseSelectModel,
			@RequestParam("page")Integer page,@RequestParam("size")Integer size) {
		PageHelper.startPage(page, size);
		// 查询出所有符合条件的视图所有数据
		List<ViewHouse> viewHouses = houseRegisterSelectService.getByMultiConditionQuery(houseSelectModel);
		System.out.println(houseSelectModel == null); //false

		// 声明一个list，用于封装需要的数据
		List<HouseShowModel> houseShowModels = new ArrayList<HouseShowModel>();

		// 给需要返回显示的数据赋值
		for (ViewHouse viewHouse : viewHouses) {
			HouseShowModel houseShowModel = new HouseShowModel();
			if(viewHouse.getId() != null){
				houseShowModel.setHouseId(viewHouse.getId());
			}
			if(viewHouse.getNo() != null){
				houseShowModel.setHouseNo(viewHouse.getNo());
			}
			if(viewHouse.getTypeName() != null){
				houseShowModel.setHouseSort(viewHouse.getTypeName());
			}
			if(viewHouse.getLayoutName() != null){
				houseShowModel.setHouseType(viewHouse.getLayoutName());
			}
			if(viewHouse.getStatusName() != null){
				houseShowModel.setUseStatus(viewHouse.getStatusName());
			}
			if(viewHouse.getUsedArea() != null){
				houseShowModel.setUsedArea(viewHouse.getUsedArea());
			}
			if(viewHouse.getAddress() != null){
				houseShowModel.setAddress(viewHouse.getAddress());
			}
			if(viewHouse.getCampusName() != null){
				houseShowModel.setCampusName(viewHouse.getCampusName());
			}
			if(viewHouse.getRegionName() != null){
				houseShowModel.setZoneName(viewHouse.getRegionName());
			}
			if(viewHouse.getBuildingName() != null){
				houseShowModel.setBuildingName(viewHouse.getBuildingName());
			}
			houseShowModels.add(houseShowModel);
		}

		PageInfo pageInfo = new PageInfo(viewHouses);
		pageInfo.setList(houseShowModels);
		System.out.println(houseShowModels);

		return Msg.success().add("data", pageInfo);
	}

}

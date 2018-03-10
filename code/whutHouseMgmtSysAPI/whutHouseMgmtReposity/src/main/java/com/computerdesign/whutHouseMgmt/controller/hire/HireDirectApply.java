package com.computerdesign.whutHouseMgmt.controller.hire;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.computerdesign.whutHouseMgmt.bean.Msg;
import com.computerdesign.whutHouseMgmt.bean.hire.common.Hire;
import com.computerdesign.whutHouseMgmt.bean.hire.directapply.HireAddDirectApply;
import com.computerdesign.whutHouseMgmt.bean.hire.directapply.HireGetDirectApply;
import com.computerdesign.whutHouseMgmt.bean.hire.directapply.HireHouseGetDirectApply;
import com.computerdesign.whutHouseMgmt.bean.house.ViewHouse;
import com.computerdesign.whutHouseMgmt.bean.houseregister.ResidentVw;
import com.computerdesign.whutHouseMgmt.bean.staffmanagement.ViewStaff;
import com.computerdesign.whutHouseMgmt.service.hire.HireService;
import com.computerdesign.whutHouseMgmt.service.hire.StaffHouseService;
import com.computerdesign.whutHouseMgmt.service.hire.ViewHireService;
import com.computerdesign.whutHouseMgmt.service.house.HouseService;
import com.computerdesign.whutHouseMgmt.service.house.ViewHouseService;
import com.computerdesign.whutHouseMgmt.service.houseregister.RegisterService;
import com.computerdesign.whutHouseMgmt.service.staffmanagement.ViewStaffService;

/**
 *
 * @author wanhaoran
 * @date 2018年3月10日 下午3:42:09
 * 
 */
public class HireDirectApply {

	@Autowired
	private HireService hireService;

	@Autowired
	private ViewHireService viewHireService;

	@Autowired
	private StaffHouseService staffHouseService;

	@Autowired
	private ViewStaffService viewStaffService;

	@Autowired
	private RegisterService registerService;

	@Autowired
	private ViewHouseService viewHouseService;
	
	@Autowired
	private HouseService houseService;
	
	/**
	 * 获取房屋直批页面
	 * 
	 * @param staffId
	 * @return
	 */
	@RequestMapping(value = "getDirectApply/{staffId}", method = RequestMethod.GET)
	@ResponseBody
	public Msg HireGetDirectApply(@PathVariable("staffId") Integer staffId) {
		// 获取员工信息，并将信息封装
		ViewStaff viewStaff = viewStaffService.getByStaffId(staffId).get(0);
		HireGetDirectApply hireGetDirectApply = new HireGetDirectApply(viewStaff);

		// 根据员工信息获取该员工所有的房屋信息
		List<ResidentVw> listResidentVw = registerService.getResidentVwByStaffId(staffId);
		// 用来存放该员工所有房屋信息的封装集合
		List<HireHouseGetDirectApply> listHouseGetDirectApply = new ArrayList<HireHouseGetDirectApply>();

		// 该员工有房屋
		if (!listResidentVw.isEmpty()) {
			// 遍历每一个房屋
			for (ResidentVw residentVw : listResidentVw) {

				HireHouseGetDirectApply houseGetDirectApply = new HireHouseGetDirectApply();
				if (viewHouseService.get(residentVw.getHouseId()).isEmpty()) {
					// TODO 不可能的错误
				} else {
					// 获取房屋信息
					ViewHouse viewHouse = viewHouseService.get(residentVw.getHouseId()).get(0);

					houseGetDirectApply.setBookTime(residentVw.getBookTime());
					houseGetDirectApply.setHouseRel(residentVw.getHouseRel());

					houseGetDirectApply.setAddress(residentVw.getAddress());
					houseGetDirectApply.setHouseId(residentVw.getHouseId());
					houseGetDirectApply.setLayoutName(viewHouse.getLayoutName());
					houseGetDirectApply.setTypeName(viewHouse.getTypeName());
					houseGetDirectApply.setUsedArea(viewHouse.getUsedArea());
					// 将封装好的房屋信息加入集合中
					listHouseGetDirectApply.add(houseGetDirectApply);
				}
			}
			hireGetDirectApply.setListHouseGetDirectApply(listHouseGetDirectApply);
		} else {
			hireGetDirectApply.setListHouseGetDirectApply(null);
		}

		return Msg.success("房屋直批页面").add("data", hireGetDirectApply);
	}

	/**
	 * 房屋直批
	 * 
	 * @param hireAddDirectApply
	 * @return
	 */
	@RequestMapping(value = "addDirectApply", method = RequestMethod.POST)
	@ResponseBody
	public Msg HireAddDirectApply(@RequestBody HireAddDirectApply hireAddDirectApply) {
		Hire hire = new Hire();

		hire.setStaffId(hireAddDirectApply.getId());
		hire.setHouseId(hireAddDirectApply.getHouseId());

		// 通过reason来判断是否为直批
		hire.setReason("直批");

		hire.setApplyTime(new Date());
		hire.setHireState("已审批");

		hire.setAcceptMan(hireAddDirectApply.getDirectApplyMan());
		hire.setAcceptNote(hireAddDirectApply.getDirectApplyNote());
		hire.setAcceptState("通过");
		hire.setAcceptTime(new Date());

		hire.setAgreeMan(hireAddDirectApply.getDirectApplyMan());
		hire.setAgreeNote(hireAddDirectApply.getDirectApplyNote());
		hire.setAgreeState("通过");
		hire.setAgreeTime(new Date());

		hire.setApproveMan(hireAddDirectApply.getDirectApplyMan());
		hire.setApproveNote(hireAddDirectApply.getDirectApplyNote());
		hire.setApproveState("通过");
		hire.setApproveTime(new Date());

		hire.setIsOver(false);

		hireService.add(hire);
		registerService.registerByHire(hire);
		//TODO 78为当前数据库租赁对于的id
		houseService.updateHouseStatus(hire.getHouseId(), 78);
		return Msg.success("房屋直批");
	}
}

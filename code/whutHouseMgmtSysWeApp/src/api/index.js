import fly from "@/utils/request";
// 首次登录使用
export function postLoginWX(data) {
  return fly.post("/userLogin/loginWX", { ...data
  })

}
// 微信id登录使用
export function postLoginByUnionID(data) {
  return fly.post("/userLogin/loginByUnionId", { ...data
  })
}
// 根据token获取信息
export function getTokenLogin(token) {
  return fly.get(`/userLogin/tokenLogin?token=${token}`, )
}

// 向服务器发送code
export function getWXCode(code) {
  return fly.get(`/userLogin/code?code=${code}`, )
}

// 向服务器解密信息
export function getdecodeInfo(data) {
  return fly.post(`/userLogin/decodeUserInfo`, { ...data
  })
}

// 获取职工个人信息及已有住房
export function getStaffInfo(staffID) {
  return fly.get(`/fix/getApply/${staffID}`, )
}

// 维修参数获取
export function getFixParam(params, paramClass) {
  return fly.get(`/fixParam/get/${paramClass}`,{...params})
}
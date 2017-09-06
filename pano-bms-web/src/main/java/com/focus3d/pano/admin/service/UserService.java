package com.focus3d.pano.admin.service;

import java.util.HashMap;
import java.util.List;

import com.focus3d.pano.admin.utils.Page;
import com.focus3d.pano.model.User;


public interface UserService {
	public void saveUser(String nick_name,String name,String mobile,String email,String cert_no,int sex,long adder_sn,long role_sn,String password,String adder_name,int status,String add_time);
	public List<User> getUserList();
	public long selectUserSnById(String cert_no);
	public long selectSnByRole_Name(String role_name);
	public void saveUSn_RSnToU_R(long user_sn,long role_sn);
	public User selectUserByCert_no(Long user_sn);
	public void updateUserByCert_no(Long userSn,String password,String nick_name,String name,String mobile,String email,String cert_no,long role_sn,int sex);
	public void updateRole_snByUser_sn(long role_sn,long user_sn);
	public void saveLogin(
String login_name,String password,int status,
long user_sn,long adder_sn,String adder_name,String add_time,String cert_no);
	public void updateStatus(String cert_no,int status);
	public List<User> selectUserByMsg(String nick_name,String mobile,int startIndex,int pagesize);
	public List<User> selectUserByMsg2(String nick_name,String mobile);
	public int selectUserCount();
	public List<User> limit(Page page);
	public List<HashMap<String,Object>> selectRole_name();
	public User selectUsersnByCert_no(String cert_no);
	public void deleteUser(Long UserSn);
	/**
	 * *
	 * @param user
	 */
	public void updateAllocateSpace(User user);
}

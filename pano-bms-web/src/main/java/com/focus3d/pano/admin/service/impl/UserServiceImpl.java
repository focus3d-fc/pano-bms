package com.focus3d.pano.admin.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.focus3d.pano.admin.dao.UserDao;
import com.focus3d.pano.admin.service.UserService;
import com.focus3d.pano.model.Login;
import com.focus3d.pano.model.User;
import com.focus3d.pano.model.User_Role;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDao;
	
	
	@Override
	public void saveUser(String nick_name,String name,
			String city,String mobile,String email,
			String cert_no,int sex,long adder_sn) {
		User user=new User();
		user.setNick_name(nick_name);
		user.setName(name);
		user.setCity(city);
		user.setMobile(mobile);
		user.setEmail(email);
		user.setCert_no(cert_no);
		user.setSex(sex);
		user.setAdder_sn(adder_sn);
		userDao.saveUser(user);
		System.out.println("进入：ServiceImpl");
	}


	@Override
	public List<User> getUserList() {
		
		return userDao.getUserList();
	}


	@Override
	public long selectUserSnById(String cert_no) {
		return userDao.selectUserSnById(cert_no);
	}


	@Override
	public long selectSnByRole_Name(String role_name) {
		
		return userDao.selectSnByRole_Name(role_name);
	}


	@Override
	public void saveUSn_RSnToU_R(long user_sn, long role_sn) {
		User_Role user_role=new User_Role();
		user_role.setUser_sn(user_sn);
		user_role.setRole_sn(role_sn);
		userDao.saveUSn_RSnToU_R(user_role);
		
	}


	@Override
	public User selectUserByCert_no(String cert_no) {
		
		return userDao.selectUserByCert_no(cert_no);
	}


	@Override
	public void updateUserByCert_no(String nick_name,String city,String mobile,String email,String cert_no) {
		User user=new User();
		user.setNick_name(nick_name);
		user.setCity(city);
		user.setMobile(mobile);
		user.setEmail(email);
		user.setEmail(email);
		user.setCert_no(cert_no);
		userDao.updateUserByCert_no(user);
	}


	@Override
	public void updateRole_snByUser_sn(long role_sn, long user_sn) {
		User_Role user_role=new User_Role();
		user_role.setRole_sn(role_sn);
		user_role.setUser_sn(user_sn);
		userDao.updateRole_snByUser_sn(user_role);
	}


	@Override
	public void saveLogin(String login_name, String password, int status,
			long user_sn, long adder_sn, String adder_name, String add_time,String cert_no) {
		Login login=new Login();
		login.setLogin_name(login_name);
		login.setPassword(password);
		login.setStatus(status);
		login.setUser_sn(user_sn);
		login.setAdder_sn(adder_sn);
		login.setAdder_name(adder_name);
		login.setAdd_time(add_time);
		login.setCert_no(cert_no);
		userDao.saveLogin(login);
	}


	@Override
	public void updateStatus(String cert_no,int status) {
		Login login=new Login();
		login.setCert_no(cert_no);
		login.setStatus(status);
		userDao.updateStatus(login);
	}



	
	
	
	
	
	
}

package com.focus3d.pano.admin.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.focus3d.pano.admin.dao.UserDao;
import com.focus3d.pano.admin.utils.Page;
import com.focus3d.pano.model.Login;
import com.focus3d.pano.model.User;
import com.focus3d.pano.model.User_Role;
@Repository
public class UserDaoImpl extends BaseDao implements UserDao{

	@Override
	public void saveUser(User user) {
		getSqlMapClientTemplate().insert("saveUser",user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserList() {
		List<User> list=(List<User>) getSqlMapClientTemplate().queryForList("getUserList");
		return list;
	}

	@Override
	public long selectUserSnById(String cert_no) {
		long sn=(Long) getSqlMapClientTemplate().queryForObject("selectUserSnById",cert_no);
		return sn;
	}

	@Override
	public long selectSnByRole_Name(String role_name) {
		long sn=(Long)getSqlMapClientTemplate().queryForObject("selectSnByRole_Name",role_name);
		return sn;
	}

	@Override
	public void saveUSn_RSnToU_R(User_Role user_role) {
		getSqlMapClientTemplate().insert("saveUSn_RSnToU_R",user_role);
		
	}

	@Override
	public User selectUserByCert_no(String cert_no) {
		
		User user=(User)getSqlMapClientTemplate().queryForObject("selectUserByCert_no",cert_no);
		return user;
	}

	@Override
	public void updateUserByCert_no(User user) {
		getSqlMapClientTemplate().update("updateUserByCert_no",user);
		
	}

	@Override
	public void updateRole_snByUser_sn(User_Role user_role) {
		getSqlMapClientTemplate().update("updateRole_snByUser_sn",user_role);
		
	}

	@Override
	public void saveLogin(Login login) {
		System.out.println("A.DAOImpl:");
		getSqlMapClientTemplate().insert("saveLogin",login);
		System.out.println("B.DAOImpl:");
	}

	@Override
	public void updateStatus(User user) {
		getSqlMapClientTemplate().update("updateStatus",user);
		
	}

	@Override
	public List<User> selectUserByMsg(User user) {
		List<User> userList=(List<User>) getSqlMapClientTemplate().queryForList("selectUserByMsg",user);		
		return userList;
	}
	@Override
	public List<User> selectUserByMsg2(User user) {
		List<User> userList=(List<User>) getSqlMapClientTemplate().queryForList("selectUserByMsg2",user);		
		return userList;
	}
	@Override
	public int selectUserCount() {
		int count=(Integer) getSqlMapClientTemplate().queryForObject("selectUserCount");
		return count;
	}

	@Override
	public List<User> limit(Page page) {
		List<User> userList=(List<User>) getSqlMapClientTemplate().queryForList("limit",page);
		return userList;
	}

	@Override
	public List<String> selectRole_name() {
		List<String> role_nameList=(List<String>) getSqlMapClientTemplate().queryForList("selectRole_name");
		return role_nameList;
	}

	@Override
	public User selectUsersnByCert_no(String cert_no) {
		User user=(User)getSqlMapClientTemplate().queryForObject("selectUsersnByCert_no",cert_no);
		return user;
	}

	@Override
	public void updateAllocateSpace(User user) {
		getSqlMapClientTemplate().update("update_allocateSpace", user);
	}
}


















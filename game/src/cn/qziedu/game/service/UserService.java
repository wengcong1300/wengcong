package cn.qziedu.game.service;

import java.util.List;

import cn.qziedu.game.pojo.User;

public interface UserService {
	//根据用户名权限用户名密码查询用户(登录用的)
	List<User> findUser(String quanxian,String email,String password);
	
	//根据用户名和权限查询用户（判断该权限的邮箱是否被注册）
	List<User> findUserByEmail(String quanxian,String email);
	
	//注册用户
	int insertUser(User user);
	
	//修改密码
	int updUserPassword(int id,String password);
	
	//查询所有的用户
	List<User> findAllUser();
	
	//根据id查询用户
	User findUserById(int id);
	
	//更新用户状态
	int updateUserByZhuangtai(int id,User user);
	
	//根据邮箱号查询用户
	List<User> selectUserByEmail(String email);
	

	

}

package cn.qziedu.game.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.qziedu.game.mapper.UserMapper;
import cn.qziedu.game.pojo.User;
import cn.qziedu.game.pojo.UserExample;
import cn.qziedu.game.pojo.UserExample.Criteria;
import cn.qziedu.game.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	//根据用户名权限用户名密码查询用户
	@Override
	public List<User> findUser(String quanxian,String email,String password) {
		UserExample example=new UserExample();
		Criteria criteria=example.createCriteria();
		criteria.andQuanxianEqualTo(quanxian);
		criteria.andEmailEqualTo(email);
		criteria.andPasswordEqualTo(password);
		return userMapper.selectByExample(example);
	}
	
	//根据用户名和权限查询用户
	@Override
	public List<User> findUserByEmail(String quanxian, String email) {
		UserExample example=new UserExample();
		Criteria criteria=example.createCriteria();
		criteria.andQuanxianEqualTo(quanxian);
		criteria.andEmailEqualTo(email);
		return userMapper.selectByExample(example);
	}
	
	//注册用户
	@Override
	public int insertUser(User user) {
		
		return userMapper.insert(user);
	}

	/**
	 * 修改密码
	 * user:要修改的信息（对查找的对象信息进行修改）
	 * example:要对哪个具体对象信息操作（查找出哪个对象）
	 * updateByExampleSelective（要修改的内容，对象为null不需要修改保留原来的）
	 */
	@Override
	public int updUserPassword(int id,String password) {
		UserExample example=new UserExample();
		Criteria criteria=example.createCriteria();
		criteria.andIdEqualTo(id);
		User user=new User();
		user.setPassword(password);
		return userMapper.updateByExampleSelective(user, example);
	}
	//查询所有的用户
	@Override
	public List<User> findAllUser() {
		UserExample example=new UserExample();
		return userMapper.selectByExample(example);
	}

	//根据id查询用户
	@Override
	public User findUserById(int id) {
		
		return userMapper.selectByPrimaryKey(id);
	}

	//更新用户状态
	@Override
	public int updateUserByZhuangtai(int id, User user) {
		UserExample example=new UserExample();
		Criteria criteria=example.createCriteria();
		criteria.andIdEqualTo(id);
		return userMapper.updateByExampleSelective(user, example);
	}

	//根据邮箱号查询用户
	@Override
	public List<User> selectUserByEmail(String email) {
		UserExample example=new UserExample();
		Criteria criteria=example.createCriteria();
		criteria.andEmailEqualTo(email);
		return userMapper.selectByExample(example);
	}



	

}

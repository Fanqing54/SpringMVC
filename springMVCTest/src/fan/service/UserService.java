package fan.service;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;

import fan.dao.LoginMapper;
import fan.model.User;
import fan.model.UserException;




@Service("userService")
public class UserService implements IUserService {
    @Resource
	private LoginMapper userDao;
	/*
	  private IUserDao userDao
	public IUserDao getUserDao() {
		return userDao;
	}

	@Resource
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}*/

	@Override
	public void add(User user){
		User u = userDao.loadByUsername(user.getUsername());
		if(u!=null) throw new UserException("要添加的用户已经存在");
		userDao.add(user);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
	}
	@Override
	public int count() {
		return userDao.count();
	}
	@Override
	public User load(int id) {
		return userDao.load(id);
	}

	@Override
	public List<User> list() {
		return userDao.list();
	}

	@Override
	public List<User> find(int size,int offset) {
		return userDao.find(size,offset);
	}

	@Override
	public User login(String username, String password) {
		User u = userDao.loadByUsername(username);
		if(u==null) throw new UserException("登录用户不存在");
		if(!u.getPassword().equals(password)) throw new UserException("用户密码不正确");
		return u;
	}

}

package fan.service;

import java.util.List;

import fan.model.User;


//import zttc.itat.model.Pager;



public interface IUserService {
	public void add(User user);
	public int count();
	public void update(User user);
	public void delete(int id);
	public User load(int id);
	public List<User> list();
	public List<User> find(int size,int offset);
	public User login(String username,String password);
}

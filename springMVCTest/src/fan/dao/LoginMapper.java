package fan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import fan.model.User;



public interface LoginMapper {
	public void add(User user);
	public void update(User user);
	public int count();
	public void delete(int id);
	public User load(int id);
	public List<User> list();
	public List<User> find(@Param("size") int size,@Param("offset") int offset);
	public User loadByUsername(String username);
}


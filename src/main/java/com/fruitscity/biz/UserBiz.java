package com.fruitscity.biz;

import java.util.List;

import com.fruitscity.entity.Admin;
import com.fruitscity.entity.Users;

public interface UserBiz {
	//�û���¼��֤
	public List login(Users condition);
	
	//����û�
	public void addUsers(Users users);
	
	//����Ա��¼��֤
	public List login(Admin condition);
	
	//�޸ĸ�����Ϣ
	public void modifyUsers(Users users);
}

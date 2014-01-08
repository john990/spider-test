package com.spider.dao;

import com.base.db.DBManager;
import com.base.db.QueryHelper;
import com.spider.bean.User;

import org.apache.commons.dbutils.QueryRunner;

/**
 * Created by kai.wang on 1/7/14.
 */
public class UserDao {

	/**
	 * 添加唯一用户（用户名唯一，如果已经存在不添加）
	 * @param user
	 * @return
	 */
	public static int saveUniqueUser(User user){
		QueryRunner runner = new QueryRunner(DBManager.getDataSource());
		int count = 0;
		if(QueryHelper.queryCount(runner,SQL.FIND_USER_BY_NAME,user.getName()) == 0){
			count = QueryHelper.update(runner,null,SQL.SAVE_USER,user.getName(),user.getPassword(),user.getAvatar(),user.getEmail());
		}
		return count;
	}
}

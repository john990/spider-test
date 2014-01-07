package com.spider.dao;

import com.base.io.Read;

/**
 * Created by kai.wang on 1/7/14.
 */
public class SQL {

	/** save user */
	public static final String SAVE_USER = Read.readSql("save_user.sql");

	/** find user by name */
	public static final String FIND_USER_BY_NAME = Read.readSql("find_user_by_name.sql");
}

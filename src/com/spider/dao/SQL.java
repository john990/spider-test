package com.spider.dao;

import com.base.io.Read;

/**
 * Created by kai.wang on 1/7/14.
 */
class SQL {

	/** save user */
	public static final String SAVE_USER = Read.readSql("save_user.sql");

	/** find user by name */
	public static final String FIND_USER_BY_NAME = Read.readSql("find_user_by_name.sql");

	/** xinli001.com save post */
	public static final String XINLI001_SAVE_POST = Read.readSql("xinli001_save_post.sql");

	/** find_xinli001post_all */
	public static final String FIND_XINLI001POST_ALL = Read.readSql("find_xinli001post_all.sql");

}

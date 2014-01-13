package com.spider.dao;

import com.base.db.DBManager;
import com.base.db.QueryHelper;
import com.spider.bean.Xinli001Post;

import org.apache.commons.dbutils.QueryRunner;

import java.util.List;

/**
 * Created by kai.wang on 1/13/14.
 */
public class Xinli001Dao {

	public static List<Xinli001Post> findAllPost(){
		QueryRunner runner = new QueryRunner(DBManager.getDataSource());
		return QueryHelper.queryBeanList(runner,Xinli001Post.class, SQL.FIND_XINLI001POST_ALL);
	}
}

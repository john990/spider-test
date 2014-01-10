package com.spider.dao;

import com.base.db.DBManager;
import com.base.db.QueryHelper;
import com.spider.bean.Post;

import org.apache.commons.dbutils.QueryRunner;

/**
 * Created by kai.wang on 1/10/14.
 */
public class PostDao {

	public static int saveXinli001Post(Post post){
		QueryRunner runner = new QueryRunner(DBManager.getDataSource());
		return QueryHelper.update(runner,null,SQL.XINLI001_SAVE_POST,
				post.getTitle(),
				post.getContent(),
				post.getCreateAt(),
				post.getTag(),
				post.getImages(),
				post.getFromName(),
				post.getFromLink()
				);
	}
}

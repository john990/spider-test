package com.data.trans;

import com.spider.bean.Xinli001Post;
import com.spider.dao.Xinli001Dao;

import java.util.List;

/**
 * Created by kai.wang on 1/10/14.
 */
public class Xinli001Post2Post {
    public static void main(String[] args) {
        List<Xinli001Post> fromPosts = Xinli001Dao.findAllPost();
        for (Xinli001Post post : fromPosts) {

        }
    }
}

package com.spider.capture;

import com.spider.bean.User;

import java.util.ArrayList;
import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created by kai.wang on 1/7/14.
 */
public class UserV2EX implements PageProcessor {
	private Site site = Site.me().setDomain("v2ex.com").addStartUrl("http://v2ex.com/t/9000");
	private static List<String> links = new ArrayList<String>();
	@Override
	public void process(Page page) {
		page.addTargetRequests(links);
		User user = new User();
		user.setName(page.getHtml().xpath("//div[@class='header']/small[@class='gray']/a/text()").toString());
		String avatar = page.getHtml().xpath("//div[@class='header']//img[@class='avatar']/@src").toString();
		user.setAvatar(avatar.substring(0,avatar.lastIndexOf("?")));
		user.setPassword("666777dfd");
		user.setEmail("robot@gmail.com");
		System.out.println(user.toString());
	}

	@Override
	public Site getSite() {
		return site;

	}

	public static void main(String[] args) {
		for(int i=9000;i<10000;i++){
			links.add("http://v2ex.com/t/"+i);
		}
		Spider.create(new UserV2EX()).run();
	}
}

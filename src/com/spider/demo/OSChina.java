package com.spider.demo;

import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.processor.example.OschinaBlogPageProcesser;

/**
 * Created by kai.wang on 12/26/13.
 */
public class OSChina implements PageProcessor {
	private Site site = Site.me().setDomain("my.oschina.net");

	@Override
	public void process(Page page) {
		List<String> links = page.getHtml().links().regex("http://my\\.oschina\\.net/flashsword/blog/\\d+").all();
		page.addTargetRequests(links);
		page.putField("title", page.getHtml().xpath("//div[@class='BlogEntity']/div[@class='BlogTitle']/h1/text()").toString());
		if (page.getResultItems().get("title") == null) {
			//skip this page
			page.setSkip(true);
		}
		page.putField("content", page.getHtml().smartContent().toString());
		page.putField("tags", page.getHtml().xpath("//div[@class='BlogTags']/a/text()").all());
	}

	@Override
	public Site getSite() {
		return site;

	}

	public static void main(String[] args) {
		Spider.create(new OschinaBlogPageProcesser()).addUrl("http://my.oschina.net/flashsword/blog").thread(2).run();
	}
}

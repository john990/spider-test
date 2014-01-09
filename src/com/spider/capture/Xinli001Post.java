package com.spider.capture;

import com.spider.bean.Post;

import java.util.ArrayList;
import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

/**
 * Created by kai.wang on 1/9/14.
 * xinli001.com
 */
public class Xinli001Post implements PageProcessor {
	private Site site = Site.me().setDomain("xinli001.com").addStartUrl("http://www.xinli001.com/info/1");

	private static List<String> links = new ArrayList<String>();
	@Override
	public void process(Page page) {
		page.addTargetRequests(links);
		String title = page.getHtml().xpath("//div[@class='tinfo fl']/h2/text()").toString();
		String content = page.getHtml().xpath("//div[@class='show_contents']/html()").toString();
		// 3-23
		String createAt = page.getHtml().xpath("//div[@class='tinfo fl']/span").toString();
		String tag = page.getHtml().xpath("//div[@class='tags']/a/text()").toString();
		String images = page.getHtml().xpath("//div[@class='show_contents']//img/@src").toString();
		String fromName = page.getHtml().xpath("//p[@class='xh-heightlight']/a").toString();
		String fromLink = page.getHtml().xpath("//p[@class='xh-heightlight']/a/@href").toString();

		Post post = new Post();
		post.setTitle(title);
		post.setContent(content);
		post.setCreateAt(createAt);
		post.setTag(tag);
		post.setImages(images);
		post.setFromName(fromName);
		post.setFromLink(fromLink);
		System.out.println(post.toString());
	}

	@Override
	public Site getSite() {
		return site;
	}

	public static void main(String[] args){
		for(int i=1;i<11000;i++){
			links.add("http://www.xinli001.com/info/"+i);
		}
		Spider.create(new Xinli001Post()).run();
	}
}

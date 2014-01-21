package com.spider.capture;

import com.base.utils.StringUtils;
import com.spider.bean.Post;
import com.spider.dao.PostDao;

import java.util.ArrayList;
import java.util.List;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created by kai.wang on 1/9/14.
 * xinli001.com
 */
public class Xinli001Post implements PageProcessor {
    private Site site = Site.me().setDomain("xinli001.com").addStartUrl("http://www.xinli001.com/info/3127/");

    private static List<String> links = new ArrayList<String>();

    @Override
    public void process(Page page) {
        page.addTargetRequests(links);
        String title = page.getHtml().xpath("//div[@class='tinfo fl']/h2/text()").toString();
        if (title == null) return;
        String content = page.getHtml().xpath("//div[@class='show_contents']/html()").toString();
        content = content.replaceAll("壹心理", "");
        content = content.replaceAll("www.xinli001.com", "");
        // 3-23
        String createAt = page.getHtml().xpath("//div[@class='tinfo fl']/span[1]/text()").toString();
        createAt = createAt.substring(3, 22);
        String tag = page.getHtml().xpath("//div[@class='tags']/a/text()").all().toString();
        String images = page.getHtml().xpath("//div[@class='show_contents']//img/@src").all().toString();
//		String fromName = page.getHtml().xpath("//div[@class='show_contents']/p[contains(text(),'来源')]/a/text()").toString();
//		String fromLink = page.getHtml().xpath("//div[@class='show_contents']/p[contains(text(),'来源')]/a/@href").all().toString();


        tag = StringUtils.cleanBracket(tag);
        images = StringUtils.cleanBracket(images);


        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setCreateAt(createAt);
        post.setTag(tag);
        post.setImages(images);
        post.setFromName("壹心理");
        post.setFromLink(page.getUrl().toString());

        PostDao.saveXinli001Post(post);

//		System.out.println(post.toString());
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        for (int i = 3128; i < 11000; i++) {
            links.add("http://www.xinli001.com/info/" + i);
        }
        Spider.create(new Xinli001Post()).thread(10).run();
    }
}

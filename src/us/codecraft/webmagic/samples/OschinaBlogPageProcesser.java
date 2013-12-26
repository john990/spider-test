package us.codecraft.webmagic.samples;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.FileCache;
import us.codecraft.webmagic.model.AfterExtractor;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author code4crafter@gmail.com <br>
 */
public class OschinaBlogPageProcesser implements PageProcessor {

    private Site site = Site.me().setDomain("my.oschina.net").addStartUrl("http://my.oschina.net/flashsword/blog");

    @Override
    public void process(Page page) {
//        List<String> links = page.getHtml().links().regex("http://my\\.oschina\\.net/flashsword/blog/\\d+").all();
	    List<String> links = new ArrayList<String>();
	    links.add("http://my.oschina.net/flashsword/blog/145796");
        page.addTargetRequests(links);
        page.putField("title", page.getHtml().xpath("//div[@class='BlogEntity']/div[@class='BlogTitle']/h1/text()").toString());
        page.putField("content", page.getHtml().xpath("//div[@class='BlogContent']/tidyText()").toString());
        page.putField("tags",page.getHtml().xpath("//div[@class='BlogTags']/a/text()").all());
	    // 抓取图片
	    page.putField("images",page.getHtml().xpath("//div[@class='BlogContent']//img[not(contains(@src,'img_proxy'))]/@src").all());
	    FileCache fileCache = new FileCache("","","");
    }

    @Override
    public Site getSite() {
        return site;

    }

    public static void main(String[] args) {
        Spider.create(new OschinaBlogPageProcesser()).run();
    }
}

package com.geccocrawler.gecco.demo.meishij;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

@Gecco(matchUrl="https://www.meishij.net/chufang/diy/", pipelines={"consolePipeline", "rootPipeline"})
public class RootList implements HtmlBean {

    @Request
    private HttpRequest request;

    //菜谱
    @HtmlField(cssPath="div.nav")
    private List<com.geccocrawler.gecco.demo.meishij.Category> caipu;

//    //家用电器
//    @HtmlField(cssPath=".category-items > div:nth-child(1) > div:nth-child(3) > div.mc > div.items > dl")
//    private List<com.geccocrawler.gecco.demo.jd.Category> domestic;
//
//    //母婴
//    @HtmlField(cssPath=".category-items > div:nth-child(2) > div:nth-child(2) > div.mc > div.items > dl")
//    private List<Category> baby;


    public List<Category> getCaipu() {
        return caipu;
    }

    public void setCaipu(List<Category> caipu) {
        this.caipu = caipu;
    }

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    public static void main(String[] args) {
        //先获取分类列表
        HttpGetRequest start = new HttpGetRequest("https://www.meishij.net/chufang/diy/");
        start.setCharset("GBK");
        GeccoEngine.create()
                .classpath("com.geccocrawler.gecco.demo.meishij")
                //开始抓取的页面地址
                .start(start)
                //开启几个爬虫线程
                .thread(1)
                //单个爬虫每次抓取完一个请求后的间隔时间
                .interval(2000)
                .run();

        //分类列表下的商品列表采用3线程抓取
        GeccoEngine.create()
                .classpath("com.geccocrawler.gecco.demo.meishij")
                //开始抓取的页面地址
                .start(RootPipeline.sortRequests)
                //开启几个爬虫线程
                .thread(1)
                //单个爬虫每次抓取完一个请求后的间隔时间
                .interval(2000)
                .start();

    }
}

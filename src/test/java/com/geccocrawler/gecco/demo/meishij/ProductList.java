package com.geccocrawler.gecco.demo.meishij;

import com.geccocrawler.gecco.annotation.*;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

@Gecco(matchUrl="https://www.meishij.net/{cat:.*}", pipelines={"consolePipeline", "productListPipelines"})
public class ProductList implements HtmlBean {
	
	private static final long serialVersionUID = 4369792078959596706L;
	
	@Request
	private HttpRequest request;
	
	/**
	 * 抓取列表项的详细内容，包括titile，价格，详情页地址等
	 */
	@HtmlField(cssPath="#listtyle1_list > .listtyle1")
	private List<ProductBrief> details;
	/**
	 * 获得商品列表的当前页
	 */
//	@Text
	@Attr("value")
	@HtmlField(cssPath="div.listtyle1_page > div.listtyle1_page_w > span > input.text")
	private int currPage;
	/**
	 * 获得商品列表的总页数
	 */
//	@Text
	@Attr("value")
	@HtmlField(cssPath="div.listtyle1_page > div.listtyle1_page_w > span > input.text")
	private int totalPage;
	
	public List<ProductBrief> getDetails() {
		return details;
	}

	public void setDetails(List<ProductBrief> details) {
		this.details = details;
	}

	public int getCurrPage() {
		return currPage-1;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getTotalPage() {
		return 100;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public HttpRequest getRequest() {
		return request;
	}

	public void setRequest(HttpRequest request) {
		this.request = request;
	}
	
}

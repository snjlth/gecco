package com.geccocrawler.gecco.demo.meishij;

import com.geccocrawler.gecco.annotation.*;
import com.geccocrawler.gecco.spider.HtmlBean;

public class ProductBrief implements HtmlBean {

	private static final long serialVersionUID = -377053120283382723L;

	@Attr("title")
	@HtmlField(cssPath=".listtyle1 > a")
	private String code;

	@Attr("title")
	@HtmlField(cssPath=".info1> a > title")
	private String title;
	
	@Image({"img", "src"})
	@HtmlField(cssPath=".img")
	private String preview;
	
	@Href(click=true)
	@HtmlField(cssPath=".listtyle1 > a")
	private String detailUrl;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	public String getDetailUrl() {
		return detailUrl;
	}

	public void setDetailUrl(String detailUrl) {
		this.detailUrl = detailUrl;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}

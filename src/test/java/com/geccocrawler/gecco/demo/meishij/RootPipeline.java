package com.geccocrawler.gecco.demo.meishij;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HrefBean;

import java.util.ArrayList;
import java.util.List;

@PipelineName("rootPipeline")
public class RootPipeline implements Pipeline<RootList> {

	public static List<HttpRequest> sortRequests = new ArrayList<HttpRequest>();

	@Override
	public void process(RootList rootList) {
		List<Category> caiPu = rootList.getCaipu();
		process(rootList, caiPu);
	}

	private void process(RootList rootList, List<Category> categorys) {
		if(categorys == null) {
			return;
		}
		for(Category category : categorys) {
			List<HrefBean> hrefs = category.getCategorys();
			for(HrefBean href : hrefs) {
				System.out.println(href.getUrl());
				String url = href.getUrl();
				HttpRequest currRequest = rootList.getRequest();
				//SchedulerContext.into(currRequest.subRequest(url));
				//将分类的商品列表地址暂存起来
				sortRequests.add(currRequest.subRequest(url));
			}
		}
	}

}
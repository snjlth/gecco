package com.geccocrawler.gecco.demo.meishij;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;
import org.apache.commons.lang3.StringUtils;

@PipelineName("productListPipelines")
public class ProductListPipeline implements Pipeline<ProductList> {

	@Override
	public void process(ProductList productList) {
		HttpRequest currRequest = productList.getRequest();
		//下一页继续抓取
		int currPage = productList.getCurrPage();
		int nextPage = currPage + 1;
		int totalPage = productList.getTotalPage();
		if(nextPage <= totalPage) {
			String nextUrl = "";
			String currUrl = currRequest.getUrl();
//			if(currUrl.indexOf("page=") != -1) {
//				nextUrl = StringUtils.replaceOnce(currUrl, "page=" + currPage, "page=" + nextPage);
//			} else {
//				nextUrl = currUrl + "&" + "page=" + nextPage;
//			}

			System.out.println("nextUrl:"+currUrl);
			SchedulerContext.into(currRequest.subRequest(currUrl));
		}
	}

}

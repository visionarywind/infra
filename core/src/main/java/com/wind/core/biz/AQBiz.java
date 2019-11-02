package com.wind.core.biz;

import java.util.Random;
import java.util.concurrent.Future;

import com.wind.core.aqservice.AQServiceManager;
import com.wind.core.entity.AnswerRep;
import com.wind.core.entity.QuestionReq;
import com.wind.core.filter.PlainFuture;
import com.wind.core.filter.Service;
import com.wind.core.filter.SimpleFilter;

/*
* 整个biz是个U型的filter-chain，需要扩展时，通过增加新的filter就好
* 这里不同于常规的filter-chain实现，借鉴finagle核心抽象Filter
*
* req    ErrorHandlerFilter    rep  负责错误处理
*  |                            |
* req    ContentRenderFilter   rep  负责不同终端的内容输出
*  |                            |
* req      UserHintFilter      rep  负责添加提示信息
*  |                            |
 * req   UltraOperationFilter  rep  负责额外的其他操作
*  |                            |
* req        RetryFilter       rep  负责服务重试
*  |                            |
*      ->     aqservice    ->       处理结果
*
*  实际的层级可以根据应用场景加以拆分，这里仅针对题中的要求"硬"编码实现
* */
public final class AQBiz implements Service<QuestionReq, AnswerRep> {
	private Service<QuestionReq, AnswerRep> service;
	private AQServiceManager aqServiceManager;

	public AQBiz() {
		aqServiceManager = AQServiceManager.getInstance();
		SimpleFilter<QuestionReq, AnswerRep> errorFilter = new ErrorHandleFilter();
		SimpleFilter<QuestionReq, AnswerRep> contentRenderFilter = new ContentRenderFilter();
		SimpleFilter<QuestionReq, AnswerRep> userHintFilter = new UserHintFilter();
		SimpleFilter<QuestionReq, AnswerRep> ultraOperationFilter = new ExtraOperationFilter();
		SimpleFilter<QuestionReq, AnswerRep> retryFilter = new RetryFilter();

		Service<QuestionReq, AnswerRep> aqService = req -> {
			if (new Random().nextInt(10) < 1) {
				throw new RuntimeException("彩蛋");
			}
			return PlainFuture.<AnswerRep>valueOf(aqServiceManager.answer(req));
		};
		service = errorFilter
				.andThen(contentRenderFilter)
				.andThen(userHintFilter)
				.andThen(ultraOperationFilter)
				.andThen(retryFilter)
				.then(aqService);
	}

	@Override
	public Future<AnswerRep> apply(QuestionReq questionReq) {
		return service.apply(questionReq);
	}
}

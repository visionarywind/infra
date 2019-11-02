package com.wind.core.biz;

import java.util.concurrent.Future;

import lombok.extern.log4j.Log4j2;

import com.wind.core.entity.AnswerRep;
import com.wind.core.entity.QuestionReq;
import com.wind.core.filter.PlainFuture;
import com.wind.core.filter.Service;
import com.wind.core.filter.SimpleFilter;
import com.wind.core.render.Render;
import com.wind.core.render.RenderManager;
import com.wind.core.util.Futures;

@Log4j2
public class ContentRenderFilter extends SimpleFilter<QuestionReq, AnswerRep> {
	private RenderManager renderManager = RenderManager.getInstance();

	@Override
	public Future<AnswerRep> apply(QuestionReq questionReq, Service<QuestionReq, AnswerRep> service) {
		Future<AnswerRep> answerRepFuture = service.apply(questionReq);
		AnswerRep answerRep = Futures.get(answerRepFuture);
		Render.RenderType type = Render.RenderType.valueOf(questionReq.getDeviceType());
		AnswerRep rep = renderManager.render(type, answerRep);

		return PlainFuture.<AnswerRep>valueOf(rep);
	}
}
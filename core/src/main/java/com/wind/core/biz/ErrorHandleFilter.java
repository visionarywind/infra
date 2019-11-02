package com.wind.core.biz;

import java.util.concurrent.Future;

import lombok.extern.log4j.Log4j2;

import com.wind.core.entity.AnswerRep;
import com.wind.core.entity.QuestionReq;
import com.wind.core.filter.PlainFuture;
import com.wind.core.filter.Service;
import com.wind.core.filter.SimpleFilter;
import com.wind.core.util.Common;

@Log4j2
public class ErrorHandleFilter extends SimpleFilter<QuestionReq, AnswerRep> {
	private static AnswerRep SERVER_ERROR_ANSWER_REP = new AnswerRep()
			.setHelp(Common.SERVER_INNER_ERROR);
	@Override
	public Future<AnswerRep> apply(QuestionReq questionReq, Service<QuestionReq, AnswerRep> service) {
		try {
			return service.apply(questionReq);
		} catch (Throwable e) {
			log.error("[ErrorHandleFilter] occurs", e);
			return PlainFuture.<AnswerRep>valueOf(SERVER_ERROR_ANSWER_REP);
		}
	}
}

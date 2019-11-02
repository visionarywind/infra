package com.wind.core.biz;

import java.util.concurrent.Future;

import lombok.extern.log4j.Log4j2;

import com.wind.core.entity.AnswerRep;
import com.wind.core.entity.QuestionReq;
import com.wind.core.filter.Service;
import com.wind.core.filter.SimpleFilter;

@Log4j2
public class RetryFilter extends SimpleFilter<QuestionReq, AnswerRep> {
	Future<AnswerRep> dispatch(QuestionReq questionReq, Service<QuestionReq, AnswerRep> service, int count) {
		if (count > 0) {
			try {
				return service.apply(questionReq);
			} catch (Throwable t) {
				log.warn("[RetryFilter] dispatch failed", t);
				return dispatch(questionReq, service, count - 1);
			}
		} else {
			throw new IllegalStateException("[RetryFilter] retry failed");
		}
	}

	@Override
	public Future<AnswerRep> apply(QuestionReq questionReq, Service<QuestionReq, AnswerRep> service) {
		return dispatch(questionReq, service, 2);
	}
}

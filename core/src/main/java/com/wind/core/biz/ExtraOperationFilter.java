package com.wind.core.biz;

import java.util.concurrent.Future;

import lombok.extern.log4j.Log4j2;

import com.wind.core.entity.AnswerRep;
import com.wind.core.entity.QuestionReq;
import com.wind.core.filter.PlainFuture;
import com.wind.core.filter.Service;
import com.wind.core.filter.SimpleFilter;
import com.wind.core.security.AccountFrozenValidator;
import com.wind.core.security.Validator;
import com.wind.core.util.Common;
import com.wind.core.util.Futures;

@Log4j2
public class ExtraOperationFilter extends SimpleFilter<QuestionReq, AnswerRep> {
	private static final String ACCOUNT_IS_FROZEN = Common.ACCOUNT_IS_FROZEN;
	private final Validator validator = new AccountFrozenValidator();

	@Override
	public Future<AnswerRep> apply(QuestionReq questionReq, Service<QuestionReq, AnswerRep> service) {
		if (ACCOUNT_IS_FROZEN.equals(questionReq.getQuestion())) {
			AnswerRep answerRep = Futures.get(service.apply(questionReq));
			answerRep.setExt(validator.validate(questionReq.getUserInfo()));
			return PlainFuture.<AnswerRep>valueOf(answerRep);
		} else {
			return service.apply(questionReq);
		}
	}
}

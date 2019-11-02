package com.wind.core.aqservice;

import java.io.IOException;
import java.util.Random;

import com.wind.core.entity.AnswerRep;
import com.wind.core.entity.QuestionReq;
import com.wind.core.entity.UserIdentity;
import com.wind.core.util.Common;

public class SearchEngineAQService extends AbstractAQService {
	@Override
	public AnswerRep answer(QuestionReq req) throws IOException {
		boolean randomFailed = new Random().nextInt(100) < 50;
		if (randomFailed) {
			return next.answer(req);
		} else {
			return new AnswerRep()
					.setUserInfo(UserIdentity.from(req.getUserInfo()).setDesc(Common.USER_STATE_LEGAL))
					.setAnswer(Common.AQ_SEARCH_ENGINE_ANSWER)
					.setExt("SearchEngineAQService");
		}
	}
}

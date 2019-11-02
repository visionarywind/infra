package com.wind.core.aqservice;

import com.wind.core.entity.AnswerRep;
import com.wind.core.entity.QuestionReq;
import com.wind.core.entity.UserIdentity;
import com.wind.core.util.Common;

public class DefaultAQService extends AbstractAQService {
	@Override
	public AnswerRep answer(QuestionReq req) {
		return new AnswerRep()
				.setUserInfo(UserIdentity.from(req.getUserInfo()).setDesc(Common.USER_STATE_LEGAL))
				.setAnswer(Common.AQ_DEFAULT_ANSWER)
				.setExt("DefaultAQService");
	}
}

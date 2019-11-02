package com.wind.core.biz;

import com.wind.core.entity.AnswerRep;
import com.wind.core.entity.QuestionReq;
import com.wind.core.filter.RepSimpleFilter;

public class UserHintFilter extends RepSimpleFilter<QuestionReq, AnswerRep> {
	private static final String USER_HELP = "如果以上答案未解决您的问题，请拨打123456人工客服热线";

	@Override
	public AnswerRep after(AnswerRep answerRep) {
		answerRep.setHelp(USER_HELP);
		return answerRep;
	}
}

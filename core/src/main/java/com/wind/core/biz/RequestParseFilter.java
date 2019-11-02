package com.wind.core.biz;

import com.wind.core.render.Render;
import lombok.extern.log4j.Log4j2;

import com.wind.core.entity.AnswerRep;
import com.wind.core.entity.QuestionReq;
import com.wind.core.filter.ReqSimpleFilter;

@Log4j2
public class RequestParseFilter extends ReqSimpleFilter<QuestionReq, AnswerRep> {
	@Override
	public QuestionReq before(QuestionReq questionReq) {
		Render.RenderType type;
		try {
			type = Render.RenderType.valueOf(questionReq.getDeviceType());
		} catch (Exception e) {
			log.error("[RequestParseFilter] failed to parse device type", e);
			type = Render.RenderType.API;
		}
		questionReq.setDeviceType(type.getSrc());
		return questionReq;
	}
}

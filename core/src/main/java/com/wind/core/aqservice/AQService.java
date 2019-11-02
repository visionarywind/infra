package com.wind.core.aqservice;

import java.io.IOException;

import com.wind.core.entity.AnswerRep;
import com.wind.core.entity.QuestionReq;

public interface AQService {
	AnswerRep answer(QuestionReq req) throws IOException;
}

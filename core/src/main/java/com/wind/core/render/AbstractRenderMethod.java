package com.wind.core.render;

import com.wind.core.entity.AnswerRep;

public abstract class AbstractRenderMethod implements Render {
	@Override
	public String parse(String plainAnswer) {
		return plainAnswer;
	}

	@Override
	public String intercept(String plainAnswer) {
		return plainAnswer;
	}

	@Override
	public String format(String plainAnswer) {
		return plainAnswer;
	}

	public AnswerRep render(AnswerRep answer) {
		String plainAnswer = answer.getAnswer();
		String parsedAnswer = parse(plainAnswer);
		String interceptedAnswer = intercept(parsedAnswer);
		String formattedAnswer = format(interceptedAnswer);
		answer.setAnswer(formattedAnswer);
		return answer;
	}
}

package com.wind.core.aqservice;

import java.io.IOException;

import lombok.extern.log4j.Log4j2;

import com.wind.core.entity.AnswerRep;
import com.wind.core.entity.QuestionReq;

@Log4j2
public class AQServiceManager {
	private AQService chain;
	private DefaultAQService defaultService;

	private AQServiceManager() {
		AbstractAQService innerKnowledgeAQService = new InnerKnowledgeAQService();
		AbstractAQService searchEngineAQService = new SearchEngineAQService();
		DefaultAQService defaultAQService = new DefaultAQService();

		innerKnowledgeAQService.setNext(searchEngineAQService);
		searchEngineAQService.setNext(defaultAQService);
		chain = innerKnowledgeAQService;

		defaultService = defaultAQService;
	}

	public static AQServiceManager getInstance() {
		return AQServiceManager.AQNodeManagerHolder.instance;
	}

	private static class AQNodeManagerHolder {
		private static AQServiceManager instance = new AQServiceManager();
	}

	public AnswerRep answer(QuestionReq req) {
		try {
			return chain.answer(req);
		} catch (IOException io) {
			log.error("[AQServiceManager] call chain failed", io);
			return defaultService.answer(req);
		}
	}
}

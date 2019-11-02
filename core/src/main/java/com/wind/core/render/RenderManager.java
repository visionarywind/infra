package com.wind.core.render;

import java.util.HashMap;
import java.util.Map;

import com.wind.core.entity.AnswerRep;

public class RenderManager {
	public static RenderManager getInstance() {
		return RenderManagerHolder.instance;
	}

	private static class RenderManagerHolder {
		private static RenderManager instance = new RenderManager();
	}

	private RenderManager() {
		strategies = new HashMap<>();
		strategies.put(Render.RenderType.WEB, new WebContentRender());
		strategies.put(Render.RenderType.H5, new H5ContentRender());
		strategies.put(Render.RenderType.ANDROID, new AndroidContentRender());
		strategies.put(Render.RenderType.IOS, new IosContentRender());
		strategies.put(Render.RenderType.API, new ApiContentRender());
	}

	private Map<Render.RenderType, AbstractRenderMethod> strategies;

	public AnswerRep render(Render.RenderType type, AnswerRep answerRep) {
		return strategies.get(type).render(answerRep);
	}
}

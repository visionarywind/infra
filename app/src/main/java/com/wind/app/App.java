package com.wind.app;

import java.util.Random;
import java.util.stream.IntStream;

import com.wind.core.biz.AQBiz;
import com.wind.core.entity.AnswerRep;
import com.wind.core.entity.QuestionReq;
import com.wind.core.entity.UserIdentity;
import com.wind.core.render.Render;
import com.wind.core.util.Common;
import com.wind.core.util.Futures;

class App {
	public static void main(String[] args) {
		int tries = 100;
		IntStream.range(0, tries).forEach(e -> doExecute(e));
	}

	private static void doExecute(int startCount) {
		System.out.println("------------------开始第" + startCount + "次测试------------------");
		AQBiz aqBiz = new AQBiz();
		Render.RenderType[] arr = Render.RenderType.values();

		QuestionReq req = new QuestionReq()
				.setUserInfo(new UserIdentity().setUid(Math.abs(new Random().nextInt())))
				.setDeviceType(arr[startCount % arr.length].getSrc())
				.setQuestion(((startCount & 1) == 1) ? Common.ACCOUNT_IS_FROZEN : "");
		AnswerRep rep = Futures.get(aqBiz.apply(req));
		System.out.println(rep.toString());
		System.out.println("-----------------------------------------------------");
	}
}

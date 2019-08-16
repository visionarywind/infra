package com.wind.core.filter;

import java.util.concurrent.Future;

import org.junit.Assert;
import org.junit.Test;


public class TestFilter {
	@Test
	public void testFilter() throws Exception {
		Service<StringBuilder, StringBuilder> srv = input -> PlainFuture.valueOf(input);
		Filter<StringBuilder, StringBuilder, StringBuilder, StringBuilder> fFilter= (input, service) -> {
			input.append("fAppendBefore_");
			Future<StringBuilder> result = service.apply(input);
			try {
				StringBuilder sb = result.get();
				sb.append("fAppendAfter");
			} catch (Exception e) {  }
			return result;
		};

		Filter<StringBuilder, StringBuilder, StringBuilder, StringBuilder> eFilter= (input, service) -> {
			input.append("eAppendBefore_");
			Future<StringBuilder> result = service.apply(input);
			try {
				StringBuilder sb = result.get();
				sb.append("_eAppendAfter_");
			} catch (Exception e) {  }
			return result;
		};

		Service<StringBuilder, StringBuilder> realSrv = fFilter.andThen(eFilter).andThen(srv);
		StringBuilder expected = realSrv.apply(new StringBuilder("")).get();
		Assert.assertEquals("fAppendBefore_eAppendBefore__eAppendAfter_fAppendAfter", expected.toString());
	}
}
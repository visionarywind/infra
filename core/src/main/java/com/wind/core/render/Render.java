package com.wind.core.render;

public interface Render {
	enum RenderType {
		WEB("WEB"), H5("H5"), ANDROID("ANDROID"), IOS("IOS"), API("API");

		private String src;

		RenderType(String src) {
			this.src = src;
		}
		public String getSrc() {
			return this.src;
		}
	}

	String parse(String plainAnswer);
	String intercept(String parsedAnswer);
	String format(String interceptedAnswer);
}

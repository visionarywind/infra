package com.wind.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Accessors(chain = true)
@NoArgsConstructor
@Data
public final class QuestionReq {
	private UserIdentity userInfo;
	private String question;
	private String deviceType;
	private Object ext;
}

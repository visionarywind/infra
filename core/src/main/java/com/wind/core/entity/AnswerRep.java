package com.wind.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Accessors(chain = true)
@NoArgsConstructor
@Data
public final class AnswerRep {
	private UserIdentity userInfo;
	private String answer;
	private String help;
	private Object ext;
}

package com.wind.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Accessors(chain = true)
@NoArgsConstructor
@Data
public final class UserIdentity {
	private long uid;
	private int accountState;
	private String desc;

	public static UserIdentity from(UserIdentity other) {
		return new UserIdentity()
				.setUid(other.uid)
				.setAccountState(other.accountState)
				.setDesc(other.desc);
	}
}

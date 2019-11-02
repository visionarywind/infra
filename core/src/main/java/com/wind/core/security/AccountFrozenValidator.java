package com.wind.core.security;

import java.util.Random;

import com.wind.core.entity.UserIdentity;

public class AccountFrozenValidator implements Validator {
	@Override
	public boolean validate(UserIdentity identity) {
		return new Random().nextBoolean();
	}
}

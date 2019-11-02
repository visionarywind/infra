package com.wind.core.security;

import com.wind.core.entity.UserIdentity;

public interface Validator {
	boolean validate(UserIdentity identity);
}

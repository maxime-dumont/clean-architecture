package org.example.adapters.sha256;

import org.apache.commons.codec.digest.DigestUtils;
import org.example.interactors.ports.PasswordEncoder;

public class Sha256PasswordEncoder implements PasswordEncoder {
	@Override
	public String encode(final String str) {
		return DigestUtils.sha256Hex(str);
	}
}
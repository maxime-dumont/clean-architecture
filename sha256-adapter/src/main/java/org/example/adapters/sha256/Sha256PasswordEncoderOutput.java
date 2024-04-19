package org.example.adapters.sha256;

import org.apache.commons.codec.digest.DigestUtils;
import org.example.archi.utils.annotation.OutputAdapter;
import org.example.interactors.usecase.user.register.api.ports.output.encoder.PasswordEncoderOutput;

@OutputAdapter
public class Sha256PasswordEncoderOutput implements PasswordEncoderOutput {
	@Override
	public String encode(final String str) {
		return DigestUtils.sha256Hex(str);
	}
}
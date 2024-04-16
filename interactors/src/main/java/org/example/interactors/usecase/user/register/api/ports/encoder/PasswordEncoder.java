package org.example.interactors.usecase.user.register.api.ports.encoder;

public interface PasswordEncoder {

	String encode(String str);
}
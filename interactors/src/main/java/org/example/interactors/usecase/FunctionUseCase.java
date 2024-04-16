package org.example.interactors.usecase;

public interface FunctionUseCase<T extends Request, R extends Response> extends UseCase {
	R execute(T request);
}
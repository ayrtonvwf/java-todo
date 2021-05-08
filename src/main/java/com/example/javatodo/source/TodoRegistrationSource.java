package com.example.javatodo.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface TodoRegistrationSource {
	@Output("todoRegistrationChannel")
	MessageChannel todoRegistration();
}

package com.example.javatodo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.javatodo.model.Todo;
import com.example.javatodo.source.TodoRegistrationSource;

@RestController
@EnableBinding(TodoRegistrationSource.class)
public class TodoRegistrationController {

	@Autowired
	TodoRegistrationSource TodoRegistrationSource;

	@RequestMapping("/register")
	@ResponseBody
	public String registerTodo(@RequestBody Todo Todo) {
		TodoRegistrationSource.todoRegistration().send(MessageBuilder.withPayload(Todo).build());
		System.out.println(Todo.toString());
		return "Todo Registered";
	}
}
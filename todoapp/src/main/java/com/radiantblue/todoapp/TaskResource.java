package com.radiantblue.todoapp;

import static spark.Spark.get;
import static spark.Spark.post;

public class TaskResource {

	// private static final String API_CONTEXT = "/api";

	private final TaskService taskService;

	public TaskResource(TaskService taskService) {
		this.taskService = taskService;

		setupEndpoints();
	}

	private void setupEndpoints() {
		post("/add/:item", (request, response) -> {
			taskService.createTask(request.params(":item"));
			response.status(200);
			return response;
		});

		get("/list", (request, response) -> {
			return taskService.getList();
		});

	}
}
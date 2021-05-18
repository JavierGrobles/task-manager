package com.jgr.taskmanager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import com.jgr.taskmanager.repository.TaskRepository;
import static org.mockito.Mockito.mock;

@SpringBootTest
class TaskManagerApplicationTests {
@MockBean private TaskRepository taskRepository;
	@Test
	void contextLoads() {
	}
	 @Configuration
	static class TestConfig {
		@Bean
		TaskRepository taskRepository() {
		  return mock(TaskRepository.class);
		}
	}
}

package insa.project.personalassistanceapp;

import insa.project.personalassistanceapp.controller.UserController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonalAssistanceAppApplicationTests {

	@Autowired
	UserController userController;

	@Test
	void contextLoads() {
		Assertions.assertThat(userController).isNot(null);
	}

}

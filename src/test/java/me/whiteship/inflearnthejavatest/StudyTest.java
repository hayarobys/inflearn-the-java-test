package me.whiteship.inflearnthejavatest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

	@Test
	@EnabledOnOs({OS.MAC, OS.LINUX})
	@EnabledOnJre({JRE.JAVA_8, JRE.JAVA_11})
	@EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "LOCAL")
	@Tag("fast")
	void create_new_study() {
		String test_env = System.getenv("TEST_ENV");
		assumeTrue("LOCAL".equalsIgnoreCase(test_env));
		
		Study actual = new Study(10);
		assertThat(actual.getLimit()).isGreaterThan(0);
		
		Study study = new Study();
		assertNotNull(study);
		System.out.println("Create");
		
		assumingThat("LOCAL".equalsIgnoreCase(test_env), () -> {
			
		});
	}
	
	@Test
	@DisplayName("스터디 다시 만들기")
	@DisabledOnOs(OS.MAC)
	@Tag("slow")
	void create_new_study_again() {
		System.out.println("Create1");
	}
	
	@Test
	@Disabled
	void create_disabled_study() {
		System.out.println("Create2");
	}
	
	@BeforeAll
	static void beforeAll() {
		System.out.println("Before All");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("After All");
	}
	
	@BeforeEach
	void beforeEach() {
		System.out.println("Before Each");
	}
	
	@AfterEach
	void afterEach() {
		System.out.println("After Each");
	}
}

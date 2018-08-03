package com.artolia.admin;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElementAdminApplicationTests {

	@Test
	public void contextLoads() {
		Stream.of(
			Arrays.asList(1),
			Arrays.asList(2, 3),
			Arrays.asList(4, 5, 6)
		).forEach(System.out::println);
		Stream<List<Integer>> inputStream = Stream.of(
			Arrays.asList(1),
			Arrays.asList(2, 3),
			Arrays.asList(4, 5, 6)
		);
		Stream<Integer> ouputStream = inputStream
				.flatMap(childList -> childList.stream());
		ouputStream.forEach(System.out::println);
	}

}

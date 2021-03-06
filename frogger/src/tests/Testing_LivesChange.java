package tests;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import frogger.*;

public class Testing_LivesChange {
	@ParameterizedTest
	@MethodSource("inputStream")
	void LevelChanges(int hitCount, int expected) {
		PlayFrogger froggerPlay = new PlayFrogger();
		FroggerComponent comp = new FroggerComponent();
		comp.engine.state = FroggerState.HIT;
		
		try {
			while(hitCount > 0) {
				comp.update();
				comp.engine.state = FroggerState.HIT;
				hitCount--;
			}
			
			assertEquals(expected, comp.life);
		} catch (InterruptedException e) {
			fail("Test failed: InterruptedException");
			e.printStackTrace();
		}
	}
	
	private static Stream<Arguments> inputStream(){
		return Stream.of(
			Arguments.of(0, 5),
			Arguments.of(1, 4),
			Arguments.of(2, 3),
			Arguments.of(3, 2),
			Arguments.of(4, 1),
			Arguments.of(5, 0),
			Arguments.of(6, 5),
			Arguments.of(7, 4)
		);
	}
}

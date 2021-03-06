package tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import frogger.*;

public class Testing_LevelChanges {
	
	@ParameterizedTest
	@MethodSource("inputStream")
	void LevelChanges(int victoryCount, int expected) {
		PlayFrogger froggerPlay = new PlayFrogger();
		FroggerComponent comp = new FroggerComponent();
		comp.engine.state = FroggerState.WON;
		
		
		try {
			while(victoryCount > 0) {
				comp.update();
				comp.engine.state = FroggerState.WON;
				victoryCount--;
			}
			assertEquals(expected, comp.level);
			
		} catch (InterruptedException e) {
			fail("Test failed: InterruptedException");
			e.printStackTrace();
		}
	}
	
	private static Stream<Arguments> inputStream(){
		return Stream.of(
			Arguments.of(0, 0),
			Arguments.of(1, 1),
			Arguments.of(2, 2),
			Arguments.of(3, 3),
			Arguments.of(4, 4),
			Arguments.of(5, 5),
			Arguments.of(6, 6),
			Arguments.of(7, 7),
			Arguments.of(8, 8),
			Arguments.of(9, 9)
		);
	}
}

package tests;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import frogger.*;

public class Testing_FrogDies {
	@ParameterizedTest
	@MethodSource("inputStream")
	void LevelChanges(int victory, int expected) {
		PlayFrogger froggerPlay = new PlayFrogger();
		FroggerComponent comp = new FroggerComponent();
		comp.engine.state = FroggerState.WON;
		
		//need to reach further level from 1
		try {
			while(comp.level != victory) {
				comp.update();
				comp.engine.state = FroggerState.WON;
			}
					
		} catch (InterruptedException e) {
			fail("Test failed: InterruptedException");
			e.printStackTrace();
		}
		
		comp.engine.state = FroggerState.HIT;
		comp.life = 0;
		try {
			
			comp.update();
			assertEquals(expected, comp.level);
		} catch (InterruptedException e) {
			fail("Test failed: InterruptedException");
			e.printStackTrace();
		}
	}
	
	private static Stream<Arguments> inputStream(){
		return Stream.of(
			Arguments.of(1, 0),
			Arguments.of(2, 0),
			Arguments.of(3, 0),
			Arguments.of(4, 0),
			Arguments.of(5, 0),
			Arguments.of(6, 0),
			Arguments.of(7, 0),
			Arguments.of(8, 0)
		);
	}
}

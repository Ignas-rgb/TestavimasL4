package tests;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import frogger.FroggerComponent;
import frogger.FroggerState;
import frogger.PlayFrogger;


public class Index {

	private PlayFrogger froggerPlay = null;
	private FroggerComponent comp = null;
	
		@Before
	public void setup() {
		this.froggerPlay =  new PlayFrogger();
		this.comp = new FroggerComponent();
	}
	
	@Test
	public void onVictory(){
		//PlayFrogger froggerPlay =  new PlayFrogger(); 
		//FroggerComponent comp = new FroggerComponent();
		comp.engine.state = FroggerState.WON;

		try {
			while(comp.level <= 9) {
				comp.update();
				comp.engine.state = FroggerState.WON;
				//System.out.println(comp.level +" "+ comp.levels.size());
			}
			
			assertEquals(1, comp.endGameAfterVicotory);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			fail("Test failed: InterruptedException");
		}
	}
	
	@After
	public void tearDown() {
		comp = null;
		froggerPlay = null;
	}
	
	
	
}

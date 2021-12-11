package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import frogger.FroggerComponent;
import frogger.FroggerState;

public class Testing_FrogMovement {
	public FroggerComponent comp = null;
	
	@Before
	public void setup() {
		this.comp = new FroggerComponent();
	}
	@Test
	public void Frog_MoveDown(){
		comp.engine.state = FroggerState.MOVING;
		int expectedX = comp.engine.frog.GetX();
		int expectedY = comp.engine.frog.GetY();
		
		comp.engine.moveDown();
		assertEquals(expectedX, comp.engine.frog.GetX());
		assertEquals(expectedY, comp.engine.frog.GetY());
	}
	@After
	public void close() {
		comp = null;
	}
	
	@Before
	public void setup2() {
		this.comp = new FroggerComponent();
	}
	
	@Test
	public void Frog_MoveUp() {
		comp.engine.state = FroggerState.MOVING;
		int expectedX = comp.engine.frog.GetX();
		int expectedY = comp.engine.frog.GetY() - 4;
		
		comp.engine.moveUp();
		
		assertEquals(expectedX, comp.engine.frog.GetX());
		assertEquals(expectedY, comp.engine.frog.GetY());
	}
	@After
	public void close2() {
		comp = null;
	}
	
	@Before
	public void setup3() {
		this.comp = new FroggerComponent();
	}
	
	@Test
	public void Frog_MoveLeft() {
		comp.engine.state = FroggerState.MOVING;
		int expectedX = comp.engine.frog.GetX() - 4;
		int expectedY = comp.engine.frog.GetY();
		
		comp.engine.moveLeft();
		
		assertEquals(expectedX, comp.engine.frog.GetX());
		assertEquals(expectedY, comp.engine.frog.GetY());
	}
	
	@After
	public void close3() {
		comp = null;
	}
	
	@Before
	public void setup4() {
		this.comp = new FroggerComponent();
	}
	
	@Test
	public void Frog_MoveRight() {
		comp.engine.state = FroggerState.MOVING;
		int expectedX = comp.engine.frog.GetX() + 4;
		int expectedY = comp.engine.frog.GetY();
		
		comp.engine.moveRight();;
		
		assertEquals(expectedX, comp.engine.frog.GetX());
		assertEquals(expectedY, comp.engine.frog.GetY());
	}
	
	@After
	public void close4() {
		comp = null;
	}
	
}

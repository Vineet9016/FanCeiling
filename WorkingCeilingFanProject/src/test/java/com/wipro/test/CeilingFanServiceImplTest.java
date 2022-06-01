package com.wipro.test;

import  static com.wipro.Enum.Direction.BACKWARD;
import  static com.wipro.Enum.Direction.FORWARD;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.wipro.Enum.Direction;
import com.wipro.model.Fan;
import com.wipro.service.CeilingFanServiceImpl;
;

public class CeilingFanServiceImplTest {

	private Fan fan ; 
	CeilingFanServiceImpl s =  new CeilingFanServiceImpl();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		fan = new Fan();
	}
	
	@Test
	void testSpeedUp() throws Exception  {
		assertEquals(FORWARD, fan.getDirection());
		assertEquals(0, fan.getSpeed());

		s.speedup(1);
		assertEquals(1, fan.getSpeed());
		assertEquals(FORWARD, fan.getDirection());
		System.out.println(fan.toString());

		s.speedup(2);
		assertEquals(2, fan.getSpeed());
		assertEquals(FORWARD, fan.getDirection());

		s.speedup(3);
		assertEquals(3, fan.getSpeed());
		assertEquals(FORWARD, fan.getDirection());

		s.speedup(0);
		assertEquals(0, fan.getSpeed());
		assertEquals(FORWARD, fan.getDirection());
	}
	
	@Test
	void testReverseSpeedupDirection() throws Exception {
		assertEquals(0, fan.getSpeed());
		assertEquals(FORWARD, fan.getDirection());

		s.reverseDirection(Direction.FORWARD);
		assertEquals(0, fan.getSpeed());
		assertEquals(BACKWARD, fan.getDirection());

		s.speedup(0);
		assertEquals(1, fan.getSpeed());
		assertEquals(BACKWARD, fan.getDirection());

		s.reverseDirection(Direction.BACKWARD);
		assertEquals(1, fan.getSpeed());
		assertEquals(FORWARD, fan.getDirection());

		s.speedup(1);
		assertEquals(2, fan.getSpeed());
		assertEquals(FORWARD, fan.getDirection());

		s.reverseDirection(Direction.FORWARD);
		assertEquals(2, fan.getSpeed());
		assertEquals(BACKWARD, fan.getDirection());

		s.speedup(2);
		assertEquals(3, fan.getSpeed());
		assertEquals(BACKWARD, fan.getDirection());

		s.reverseDirection(Direction.BACKWARD);
		assertEquals(3, fan.getSpeed());
		assertEquals(FORWARD, fan.getDirection());

		s.speedup(3);
		assertEquals(0, fan.getSpeed());
		assertEquals(FORWARD, fan.getDirection());

		s.reverseDirection(Direction.FORWARD);
		assertEquals(0, fan.getSpeed());
		assertEquals(BACKWARD, fan.getDirection());

	}

	
	
}

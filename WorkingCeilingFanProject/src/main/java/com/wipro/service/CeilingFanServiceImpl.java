package com.wipro.service;
import com.wipro.model.*;
import  com.wipro.Enum.*;
import  static com.wipro.Enum.Direction.BACKWARD;
import  static com.wipro.Enum.Direction.FORWARD;

import java.io.IOException;
import java.util.InputMismatchException;

import org.springframework.stereotype.Component;

@Component
public class CeilingFanServiceImpl implements ICeilingFanService{
		Fan f =  new Fan();
	@Override
	public int speedup(int speed) throws IOException{
		if(speed>3)
		{
			speed = 0 ; 
		} else 
			speed ++ ; 
		
		return speed ; 
		
	}

	@Override
	public Direction reverseDirection(Direction direction) throws IOException {
		
		
		direction = (direction == FORWARD) ? BACKWARD : FORWARD;
		return direction ; 
	}


}

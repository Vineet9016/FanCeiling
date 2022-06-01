package com.wipro.service;

import java.io.IOException;

import com.wipro.Enum.Direction;

public interface ICeilingFanService {
	
	public int speedup(int speed) throws IOException;
	public Direction reverseDirection(Direction direction) throws IOException;

}

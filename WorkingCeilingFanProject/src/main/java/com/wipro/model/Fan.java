package com.wipro.model;

import com.wipro.Enum.Direction;
import static com.wipro.Enum.Direction.FORWARD;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Fan {

	public static final int OFF = 0;

	public  Integer speed = OFF;

	public Direction direction = FORWARD;
	
}

package com.wipro.Enum;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@JsonFormat(shape=Shape.STRING)
public enum Direction {
	
	FORWARD("forward"),
	BACKWARD("backward");

	private String value ; 
	public String getValue()
	{
		return value ; 
	}
}

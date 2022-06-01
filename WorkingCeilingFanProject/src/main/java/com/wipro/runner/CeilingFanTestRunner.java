package com.wipro.runner;

import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.wipro.Enum.Direction;
import com.wipro.service.ICeilingFanService;

@Component
public class CeilingFanTestRunner implements CommandLineRunner {
	int speedup = 0 ; 
	int dir = 1 ; 
	Direction direction = null ; 
	 
	Scanner s = new Scanner(System.in) ; // taking the inputs from the client interactively
	boolean d =  true ; 
	
	@Autowired
	private ICeilingFanService service ; 
	
	@Override
	public void run(String... args) throws IllegalStateException, IOException {
		
		try{
		System.out.println("pleease provide the current speed for your fan");
		 speedup = s.nextInt() ;
		 
		System.out.println("pleease provide the current direction of your fan. 1=> forward, any other no=> backward");
		 dir= s.nextInt() ;
		 if(dir==1)
		 {
			 direction = Direction.FORWARD ;
		 }else  
			 direction = Direction.BACKWARD ;
		 
		 while(d) {
			 			test();
		 			}
		}catch (java.util.InputMismatchException e) 
			{
				e.printStackTrace();
			}
	}
	// functionality to provide option to the client to either speed up the fan or chang the direction of the fan
	public void test() throws IOException 
	{
		
		if(speedup>3)
		{
			speedup=0 ; 
		}
		if((speedup <=3 ||  speedup >=0) && (direction==Direction.FORWARD  || direction==Direction.BACKWARD))
		{
			System.out.println("current speeed of your fan is "+ speedup) ; 
			System.out.println("current direction of your fan is "+ direction) ; 
			System.out.println("There are 2 pull cords");
			System.out.println("1.cord-1 is for speeding up the fan\n2.cord-2 is for changing the direction of the fan from the current state");
			
			System.out.println("please enter the choice out of above 2 options => 1 or 2");
			int choice = s.nextInt();
			if(choice==1 || choice==2) {
			callswitch(choice,speedup,direction);
			}else
				test();
		
				
			System.out.println("if you want to continue , press 1.=> yes,  and 2 => no");
		
			int choice2 = s.nextInt();
			if(choice2==1)
			{
				test();
			}
		else 
			System.out.println("thank you for your time");
			d=false;
			
			
		
	}}
	
	public void  callswitch(int choice,int f_speed , Direction f_direction) throws IOException 
	{
		switch(choice)
		{
		case 1:
			
			//System.out.println("creease the speed");
			 speedup = service.speedup(f_speed);
			 if(speedup > 3)
			 {
				 speedup = 0;
					System.out.println("currently the fan is OFF as you have pulled the chord over speed 3 which turns off the fan" );
			 }else
					System.out.println("Thee new speed for your fan is "+ speedup );
		
			break ; 
		case 2:
			//System.out.println("current direction for your fan is  = > "+ direction);
			 direction = service.reverseDirection(f_direction);
			System.out.println("New direction for your fan is  == > "+ direction);
			break ;
			
		default:
			System.out.println("invalid choice, please enter the choice again");
			break ; 
		}	
		
	}

}

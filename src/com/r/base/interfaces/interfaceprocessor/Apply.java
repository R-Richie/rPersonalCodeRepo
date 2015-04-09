package com.r.base.interfaces.interfaceprocessor;
import static com.r.util.Print.*;
public class Apply {
	public static void process(Processor p,Object s){
		print("Using Processor "+ p.name());
		print(p.process(s));
	}
}

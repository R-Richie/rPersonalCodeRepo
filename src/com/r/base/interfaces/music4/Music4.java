package com.r.base.interfaces.music4;

import static com.r.util.Print.print;

import com.r.base.polymorphism.music.Note;
abstract class Instrument {
	private int i;//Storage allocated for each
	public abstract void play(Note n);
	public String what(){return "Instrument";}
	public abstract void adjust();
}

class Wind extends Instrument{
	public void play(Note n){
		print("Wind.play() "+n);
	}

	public String what(){return "Wind";}
	public void adjust() {}
}

class Percussion extends Instrument{
	public void play(Note n){
		print("Percussion,play() "+ n);
	}
	public String what(){return "Percussion";}
	public void adjust(){}
}
class Stringed extends Instrument{
	public void play(Note n){
		print("Stringed.play() "+n);
	}
	public String what(){ return "Stringed";}
	public void adjust(){}
}
class Brass extends Wind {
	public void play(Note n){
		print("Brass.play() "+ n);
	}
	public void adjust() { print("Brass.adjust()");}
}

class Woodwind extends Wind{
	public void play(Note n){
		print("WoodWind.play() "+ n);
	}
	public void adjust(){ print("Woodwind");}
}


public class Music4 {
	static void tune(Instrument i){
		i.play(Note.MIDDLE_C);
	}
	static void tuneAll(Instrument[] e){
		for(Instrument i : e)
			tune(i);
	}
	public static void main(String[] args){
		Instrument[] orchestra = {
				new Wind(),
				new Percussion(),
				new Stringed(),
				new Brass(),
				new Woodwind(),
		};
		tuneAll(orchestra);
	}
}

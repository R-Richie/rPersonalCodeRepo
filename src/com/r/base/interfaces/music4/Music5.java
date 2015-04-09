package com.r.base.interfaces.music4;

import com.r.base.polymorphism.music.Note;
import static com.r.util.Print.*;
interface Instrument2 {
	int VALUE = 5;
	void play(Note n);
	void adjust();
}

class Wind2 implements Instrument2{

	@Override
	public void play(Note n) {
		print(this + ".paly() " + n);
	}
	@Override
	public void adjust() {
		print(this + ".adjust()");
	}
	public String toString(){ return "Wind";}
	
}
class Percussion2 implements Instrument2{

	@Override
	public void play(Note n) {
		print(this + ".play() " + n);
	}
	@Override
	public void adjust() {
		print(this + ".adjust()");
	}
	public String toString(){ return "Percussion";}
	
}
class Stringed2 implements Instrument2{

	@Override
	public void play(Note n) {
		print(this + ".play() " + n);
	}
	@Override
	public void adjust() {
		print(this + ".adjust()");
	}
	public String toString(){ return "Stringed2";}
	
}
class Brass2 extends Wind2{
	public String toString() { return "Brass"; }
}
class Woodwind2 extends Wind2{
	public String toString() { return "Woodwind"; }
}
public class Music5 {
	static void tune(Instrument i){
		i.play(Note.MIDDLE_C);
	}
	static void tuneAll(Instrument[] e){
		for(Instrument i : e)
			tune(i);
	}
	public static void main(String[] args) {
		Instrument[] orchestra = {
				new Wind(),
				new Percussion(),
				new Stringed(),
				new Brass(),
				new Woodwind()
		};
		tuneAll(orchestra);
	}

}

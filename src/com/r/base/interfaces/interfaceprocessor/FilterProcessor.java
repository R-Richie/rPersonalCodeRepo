package com.r.base.interfaces.interfaceprocessor;

import com.r.base.interfaces.filters.BandPass;
import com.r.base.interfaces.filters.Filter;
import com.r.base.interfaces.filters.HighPass;
import com.r.base.interfaces.filters.LowPass;
import com.r.base.interfaces.filters.Waveform;

class FilterAdapter implements Processor {
	Filter filter;
	public FilterAdapter(Filter filter){
		this.filter = filter;
	}
	@Override
	public String name() {
		return filter.name();
	}

	@Override
	public Object process(Object input) {
		return filter.process((Waveform)input);
	}
	
}
public class FilterProcessor {
	public static void main(String[] args){
		Waveform w = new Waveform();
		Apply.process(new FilterAdapter(new LowPass(1.0)), w);
		Apply.process(new FilterAdapter(new HighPass(1.0)), w);
		Apply.process(new FilterAdapter(new BandPass(3.0,4.0)), w);
	}
}

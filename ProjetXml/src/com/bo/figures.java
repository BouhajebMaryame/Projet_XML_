package com.bo;

public class figures 
{
	private figure [] figs;

	figures(int max)
	{
		figs = new figure[max];
	}
	public figure[] getFigs() {
		return figs;
	}

	public void setFigs(figure[] figs) {
		this.figs = figs;
	}
	
	
}

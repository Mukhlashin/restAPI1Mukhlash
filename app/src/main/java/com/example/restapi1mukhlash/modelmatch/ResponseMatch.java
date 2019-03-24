package com.example.restapi1mukhlash.modelmatch;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseMatch{

	@SerializedName("events")
	private List<EventsItem> events;

	public void setEvents(List<EventsItem> events){
		this.events = events;
	}

	public List<EventsItem> getEvents(){
		return events;
	}

	@Override
 	public String toString(){
		return 
			"ResponseMatch{" + 
			"events = '" + events + '\'' + 
			"}";
		}
}
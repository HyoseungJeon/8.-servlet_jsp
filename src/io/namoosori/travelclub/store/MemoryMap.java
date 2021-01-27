package io.namoosori.travelclub.store;

import java.util.HashMap;
import java.util.Map;

import io.namoosori.travelclub.entity.ClubMember;
import io.namoosori.travelclub.entity.TravelClub;

public class MemoryMap {
	
	private Map<String, TravelClub> clubMap;
	private Map<String, ClubMember> memberMap;
	
	private static MemoryMap uniqueInstance;
	
	private MemoryMap() {
		this.clubMap = new HashMap<String, TravelClub>();
		this.memberMap = new HashMap<String, ClubMember>();
	}
	
	public static MemoryMap getUniqueInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new MemoryMap();
		}
		return uniqueInstance;
	}
	
	public Map<String, TravelClub> getClubMap(){
		return this.clubMap;
	}
	
	public Map<String, ClubMember> getMemberMap(){
		return this.memberMap;
	}

}

package io.namoosori.travelclub.store;

import java.util.List;

import io.namoosori.travelclub.entity.TravelClub;

public interface ClubStore {
	
	String create(TravelClub newClub);
	TravelClub retrieve(String name);
	List<TravelClub> retrieveAll();
	
	List<TravelClub> retrieveByName(String name);
	
	void update(TravelClub newClub);
	void delete(String name);
	
	boolean existByName(String name);

}

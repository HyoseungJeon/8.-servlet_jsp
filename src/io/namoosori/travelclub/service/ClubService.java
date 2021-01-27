package io.namoosori.travelclub.service;

import java.util.List;

import io.namoosori.travelclub.entity.TravelClub;

public interface ClubService {
	
	String register(TravelClub newClub);
	TravelClub find(String name);
	List<TravelClub> findByName(String name);
	List<TravelClub> findAll();
	
	void modify(TravelClub newClub);
	void delete(String name);

}

package io.namoosori.travelclub.service.logic;

import java.util.List;

import io.namoosori.travelclub.entity.TravelClub;
import io.namoosori.travelclub.service.ClubService;
import io.namoosori.travelclub.store.ClubStore;
import io.namoosori.travelclub.store.logic.ClubStoreLogic;

public class ClubServiceLogic implements ClubService{
	
	private ClubStore clubStore;
	
	public ClubServiceLogic() {
		this.clubStore = new ClubStoreLogic();
	}
	
	@Override
	public String register(TravelClub newClub) {
		
		return clubStore.create(newClub);
	}

	@Override
	public TravelClub find(String name) {
		
		return clubStore.retrieve(name);
	}

	@Override
	public List<TravelClub> findAll() {
		
		return clubStore.retrieveAll();
	}

	@Override
	public void modify(TravelClub newClub) {
		
		clubStore.update(newClub);
		
	}

	@Override
	public void delete(String name) {
		
		clubStore.delete(name);
	}

	@Override
	public List<TravelClub> findByName(String name) {
		return clubStore.retrieveByName(name);
	}
}

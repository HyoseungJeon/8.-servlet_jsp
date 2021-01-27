package io.namoosori.travelclub.store.logic;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import io.namoosori.travelclub.entity.TravelClub;
import io.namoosori.travelclub.store.ClubStore;
import io.namoosori.travelclub.store.MemoryMap;
import io.namoosori.travelclub.util.exception.ClubDuplicationException;

public class ClubStoreLogic implements ClubStore{
	
	private Map<String, TravelClub> clubMap;
	
	public ClubStoreLogic() {
		this.clubMap = MemoryMap.getUniqueInstance().getClubMap();
	}

	@Override
	public String create(TravelClub newClub) {
		
		Optional.ofNullable(clubMap.get(newClub.getName()))
		.ifPresent(targetClub -> {
			throw new ClubDuplicationException("Club already exists with name: " + targetClub.getName());
		});
		
		clubMap.put(newClub.getName(), newClub);

		return newClub.getName();
	}

	@Override
	public TravelClub retrieve(String name) {
		
		return clubMap.get(name);
	}

	@Override
	public List<TravelClub> retrieveAll() {
		
		return clubMap.values().stream().collect(Collectors.toList());
	}

	@Override
	public void update(TravelClub newClub) {
		
		clubMap.put(newClub.getName(), newClub);
	}

	@Override
	public void delete(String name) {
		clubMap.remove(name);
		
	}

	@Override
	public boolean existByName(String name) {
		
		return Optional.ofNullable(clubMap.get(name)).isPresent();
	}

	@Override
	public List<TravelClub> retrieveByName(String name) {
		return clubMap.values().stream().filter(club -> club.getName().toLowerCase().indexOf(name.toLowerCase()) != -1)
				.collect(Collectors.toList());
	}

}

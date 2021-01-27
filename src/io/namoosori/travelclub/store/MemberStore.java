package io.namoosori.travelclub.store;

import java.util.List;

import io.namoosori.travelclub.entity.ClubMember;

public interface MemberStore {
	
	String creact(ClubMember newMember);
	ClubMember retrieve(String email);
	List<ClubMember> retrieveByName(String name);
	
	void update(ClubMember newMember);
	void delete(String email);
	
	boolean exits(String email);

}

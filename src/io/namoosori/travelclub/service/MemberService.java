package io.namoosori.travelclub.service;

import java.util.List;

import io.namoosori.travelclub.entity.ClubMember;

public interface MemberService {
	
	String register(ClubMember newMember);
	ClubMember find(String email);
	List<ClubMember> findByName(String name);
	
	void modify(ClubMember newMember);
	void remove(String email);

}

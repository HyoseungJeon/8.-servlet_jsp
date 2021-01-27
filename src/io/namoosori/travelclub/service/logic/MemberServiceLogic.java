package io.namoosori.travelclub.service.logic;

import java.util.List;

import io.namoosori.travelclub.entity.ClubMember;
import io.namoosori.travelclub.service.MemberService;
import io.namoosori.travelclub.store.MemberStore;
import io.namoosori.travelclub.store.logic.MemberStoreLogic;

public class MemberServiceLogic implements MemberService{
	
	private MemberStore memberStore;
	
	public MemberServiceLogic() {
		this.memberStore = new MemberStoreLogic();
	}

	@Override
	public String register(ClubMember newMember) {
		
		return memberStore.creact(newMember);
	}

	@Override
	public ClubMember find(String email) {
		
		return memberStore.retrieve(email);
	}

	@Override
	public List<ClubMember> findByName(String name) {
		
		return memberStore.retrieveByName(name);
	}

	@Override
	public void modify(ClubMember newMember) {
		
		memberStore.update(newMember);
		
	}

	@Override
	public void remove(String email) {
		
		memberStore.delete(email);
	}
}

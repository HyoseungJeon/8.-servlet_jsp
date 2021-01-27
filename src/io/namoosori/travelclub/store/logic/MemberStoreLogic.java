package io.namoosori.travelclub.store.logic;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import io.namoosori.travelclub.entity.ClubMember;
import io.namoosori.travelclub.store.MemberStore;
import io.namoosori.travelclub.store.MemoryMap;
import io.namoosori.travelclub.util.exception.MemberDuplicationException;

public class MemberStoreLogic implements MemberStore{
	
	private Map<String, ClubMember> memberMap;
	
	public MemberStoreLogic() {
		this.memberMap = MemoryMap.getUniqueInstance().getMemberMap();
	}

	@Override
	public String creact(ClubMember newMember) {
		Optional.ofNullable(memberMap.get(newMember.getEmail()))
		.ifPresent(targetMember -> {
			throw new MemberDuplicationException("Member already exists with email: " + newMember.getEmail());
		});
		
		memberMap.put(newMember.getEmail(), newMember);

		return newMember.getEmail();
	}

	@Override
	public ClubMember retrieve(String email) {
		
		return memberMap.get(email);
	}

	@Override
	public List<ClubMember> retrieveByName(String name) {
		
		return memberMap.values().stream().filter(member -> member.getName().equals(name)).collect(Collectors.toList());
	}

	@Override
	public void update(ClubMember newMember) {
		
		memberMap.put(newMember.getEmail(), newMember);
		
	}

	@Override
	public void delete(String email) {
		
		memberMap.remove(email);
		
	}

	@Override
	public boolean exits(String email) {
		
		return Optional.ofNullable(memberMap.get(email)).isPresent();
	}

}

package io.namoosori.travelclub.entity;

import java.util.ArrayList;
import java.util.List;

import io.namoosori.travelclub.util.util.DateUtil;

public class TravelClub {
	//
	private static final int MINIMUM_NAME_LENGTH =  3;
	private static final int MINIMUM_INTRO_LENGTH =  10;

	private String name;
	private String intro;
	private long foundationTime;

	private List<ClubMember> members;

	public TravelClub() {
		//
		this.members = new ArrayList<ClubMember>();
	}

	public TravelClub(String name, String intro) {
		//
		this();
		this.setName(name);
		this.setIntro(intro);
		this.foundationTime = System.currentTimeMillis();
	}

	@Override
	public String toString() {
		//
		StringBuilder builder = new StringBuilder();

		builder.append("club name:").append(name);
		builder.append(", intro:").append(intro);
		builder.append(", foundation time:").append(DateUtil.toString(foundationTime));
		builder.append(", members:").append(members.toString());

		return builder.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		//
		checkNameValidation(name);
		this.name = name;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		//
		checkIntroValidation(intro);
		this.intro = intro;
	}

	public long getFoundationTime() {
		return foundationTime;
	}
	
	public void setFoundationTime(long foundationTime) {
		this.foundationTime = foundationTime;
	}

	public List<ClubMember> getMembers() {
		return members;
	}

	public void setMembers(List<ClubMember> members) {
		this.members = members;
	}

	private void checkNameValidation(String name) {
		//
		if (name.length() < TravelClub.MINIMUM_NAME_LENGTH) {
			throw new IllegalArgumentException("\t > Name should be longer than " + TravelClub.MINIMUM_NAME_LENGTH);
		}
	}

	private void checkIntroValidation(String intro) {
		//
		if (intro.length() < TravelClub.MINIMUM_INTRO_LENGTH) {
			throw new IllegalArgumentException("\t > Intro should be longer than " + TravelClub.MINIMUM_INTRO_LENGTH);
		}
	}

	public static TravelClub sample() {
		//
		String name = "JavaTravelClub";
		String intro = "Travel club to the Java island.";

		return new TravelClub(name, intro);
	}

	public static void main(String[] args) {
		//
		System.out.println(sample().toString());
	}
}

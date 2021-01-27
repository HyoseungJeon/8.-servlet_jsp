package io.namoosori.travelclub.entity;

import io.namoosori.travelclub.util.exception.InvalidEmailException;

public class ClubMember {
	private String email;		// key
	private String password;
	private String name;
	private String phoneNumber;
	private String nickname;
	private String birthDay;
	private RoleInClub role;
	
	public ClubMember() {}

	public ClubMember(String email, String name, String phoneNumber) {
		//
		this.setEmail(email);
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.role = RoleInClub.Member;
	}

	@Override
	public String toString() {
		//
		StringBuilder builder = new StringBuilder();

		builder.append("name:").append(name);
		builder.append(", password:").append(password);
		builder.append(", email:").append(email);
		builder.append(", nickname:").append(nickname);
		builder.append(", phone number:").append(phoneNumber);
		builder.append(", birthDay:").append(birthDay);
		builder.append(", role:").append(role);

		return builder.toString();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		//
		checkEmailValidation(email);
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public RoleInClub getRole() {
		return role;
	}

	public void setRole(RoleInClub role) {
		this.role = role;
	}

	private void checkEmailValidation(String email) {
		//
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		boolean valid = m.matches();

		if (!valid) {
			throw new InvalidEmailException("Email is invalid.");
		}
	}

	public static ClubMember sample() {
		//
		ClubMember member = new ClubMember("mymy@nextree.co.kr", "Minsoo Lee", "010-3321-1001");
		member.setBirthDay("2001.09.23");
		return member;
	}

	public static void main(String[] args) {
		//
		System.out.println(sample().toString());
	}
}

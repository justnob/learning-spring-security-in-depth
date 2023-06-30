package com.amarnath.learnspringsecurity.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.amarnath.learnspringsecurity.classes.Profiles;

@Service
public class ProfileRepository {
	
	private static List<Profiles> profiles = new ArrayList<>();
	
	private static Long counter = (long) 0;
	
	static {
		
		profiles.add(new Profiles(++counter, "Amarnath.Sah", "Rajbiraj-3", "Hardware Technician"));
		profiles.add(new Profiles(++counter, "Rahul.Sah", "Kathmandu", "Hardware Technician"));
		profiles.add(new Profiles(++counter, "Deepak.Sah", "Kathmandu", "Student"));
		profiles.add(new Profiles(++counter, "Harshu.sah", "Rajbiraj-3", "Student"));
		profiles.add(new Profiles(++counter, "Ketan.Sah", "Biratnagar", "CEO"));
		profiles.add(new Profiles(++counter, "Niraj.Sah", "Kathmandu", "Civil Eng."));
		profiles.add(new Profiles(++counter, "Ritik.Sah", "Janakpur", "Student"));
		
	}

	public List<Profiles> getAllProfiles() {
		
		return profiles;
	}

	public Profiles getUser(String username) {
		
		Predicate<? super Profiles> predicate = n -> n.getName().equalsIgnoreCase(username);
		Optional<Profiles> findUser = profiles.stream().filter(predicate).findFirst();
		
		return findUser.get();
		
	}

	public void addUser(Profiles body) {

		body.setId(++counter);
		profiles.add(body);
		
	}
	
	
	

}

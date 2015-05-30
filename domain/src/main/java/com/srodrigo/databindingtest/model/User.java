package com.srodrigo.databindingtest.model;

import java.util.Random;

public final class User {
	private final String name;
	private final int age;

	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public boolean isYoung() {
		return age < 30;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public User updateRandomAge() {
		return new User(this.name, generateRandomAge());
	}

	private int generateRandomAge() {
		return new Random().nextInt();
	}
}

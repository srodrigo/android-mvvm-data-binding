/*
 * Copyright (c) 2015 Sergio Rodrigo Royo
 *
 * This software may be modified and distributed under the terms
 * of the MIT license. See the LICENSE file for details.
 */
package me.srodrigo.databindingtest.model;

import java.util.Random;

public final class User {
	private static final int YOUNG_LIMIT = 30;
	private static final int AGE_LIMIT = 100;
	private final String name;
	private final int age;

	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public boolean isYoung() {
		return age < YOUNG_LIMIT;
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
		return new Random().nextInt((AGE_LIMIT - 1) + 1) + 1;
	}
}

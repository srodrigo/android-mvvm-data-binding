/*
 * Copyright (c) 2015 Sergio Rodrigo Royo
 *
 * This software may be modified and distributed under the terms
 * of the MIT license. See the LICENSE file for details.
 */
package me.srodrigo.databindingtest.modules.user;

import android.databinding.Bindable;

import me.srodrigo.databindingtest.model.User;
import me.srodrigo.databindingtest.user.UserBindingView;
import me.srodrigo.databindingtest.common.presentation.BaseBindingView;

public class UserBindingViewImp extends BaseBindingView<User> implements UserBindingView {

	private String name;
	private int age;
	private boolean young;

	@Override
	protected void bindData(User user) {
		this.name = user.getName();
		this.age = user.getAge();
		this.young = user.isYoung();
	}

	@Bindable
	public String getName() {
		return name;
	}

	@Bindable
	public int getAge() {
		return age;
	}

	@Bindable
	public boolean isYoung() {
		return young;
	}

}

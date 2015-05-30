package com.srodrigo.databindingtest.modules.user;

import android.databinding.Bindable;

import com.srodrigo.databindingtest.model.User;
import com.srodrigo.databindingtest.user.UserBindingView;
import com.srodrigo.databindingtest.common.presentation.BaseBindingView;

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

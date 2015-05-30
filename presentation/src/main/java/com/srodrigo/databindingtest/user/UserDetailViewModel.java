package com.srodrigo.databindingtest.user;

import com.srodrigo.databindingtest.model.User;
import com.srodrigo.databindingtest.modules.user.UserProvider;

public class UserDetailViewModel extends com.srodrigo.databindingtest.common.ViewModel<User, com.srodrigo.databindingtest.user.UserDetailView>
		implements UserProvider.Callback {

	private User user;

	private final UserProvider userProvider;

	public UserDetailViewModel(UserBindingView userBindingView, UserProvider userProvider) {
		super(userBindingView);
		this.userProvider = userProvider;
		this.userProvider.setCallback(this);
	}

	public void attachView(com.srodrigo.databindingtest.user.UserDetailView view) {
		super.attachView(view);
		this.getView().initUi();
	}

	public void onRefresh() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				userProvider.provideUser();
			}
		}).start();
	}

	@Override
	public void onUserRetrieved(User user) {
		this.user = user;
		getBindingView().bind(user);
		getView().enableUpdateUserAge();
	}

	public void onUpdateUserAge() {
		user = user.updateRandomAge();
		getBindingView().bind(user);
	}

}

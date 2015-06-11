package me.srodrigo.databindingtest.user;

import me.srodrigo.databindingtest.model.User;
import me.srodrigo.databindingtest.modules.user.UserProvider;

public class UserDetailViewModel extends me.srodrigo.databindingtest.common.ViewModel<User, UserDetailView>
		implements UserProvider.Callback {

	private final UserProvider userProvider;
	private User user;

	public UserDetailViewModel(UserBindingView userBindingView, UserProvider userProvider) {
		super(userBindingView);
		this.userProvider = userProvider;
		this.userProvider.setCallback(this);
	}

	public void attachView(UserDetailView view) {
		super.attachView(view);
		this.getView().disableUpdateUserAge();
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
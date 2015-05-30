package com.srodrigo.databindingtest.modules.user;

import com.srodrigo.databindingtest.model.User;

public final class UserProvider {

	public interface Callback {
		void onUserRetrieved(User user);
	}

	private Callback callback;

	public void provideUser() {
		simulateDelay();
		callback.onUserRetrieved(new User("Sergio", 31));
	}

	private void simulateDelay() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void setCallback(Callback callback) {
		this.callback = callback;
	}

}

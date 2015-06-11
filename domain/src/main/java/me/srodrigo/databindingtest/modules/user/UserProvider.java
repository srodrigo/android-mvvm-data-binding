package me.srodrigo.databindingtest.modules.user;

public final class UserProvider {

	public interface Callback {
		void onUserRetrieved(me.srodrigo.databindingtest.model.User user);
	}

	private Callback callback;

	public void provideUser() {
		simulateDelay();
		callback.onUserRetrieved(new me.srodrigo.databindingtest.model.User("Sergio", 31));
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

package me.srodrigo.databindingtest.common.presentation;

import me.srodrigo.databindingtest.modules.user.UserBindingViewImp;

public class BindingViewFactory {

	public static UserBindingViewImp createUserBindingView() {
		return new UserBindingViewImp();
	}

}

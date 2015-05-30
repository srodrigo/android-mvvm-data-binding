package com.srodrigo.databindingtest.common.presentation;

import com.srodrigo.databindingtest.modules.user.UserBindingViewImp;

public class BindingViewFactory {

	public static UserBindingViewImp createUserBindingView() {
		return new UserBindingViewImp();
	}

}

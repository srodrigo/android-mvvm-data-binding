/*
 * Copyright (c) 2015 Sergio Rodrigo Royo
 *
 * This software may be modified and distributed under the terms
 * of the MIT license. See the LICENSE file for details.
 */
package me.srodrigo.databindingtest.common.presentation;

import me.srodrigo.databindingtest.modules.user.UserBindingViewImp;

public class BindingViewFactory {

	public static UserBindingViewImp createUserBindingView() {
		return new UserBindingViewImp();
	}

}

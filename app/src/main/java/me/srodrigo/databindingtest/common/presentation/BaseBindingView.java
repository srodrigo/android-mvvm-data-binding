/*
 * Copyright (c) 2015 Sergio Rodrigo Royo
 *
 * This software may be modified and distributed under the terms
 * of the MIT license. See the LICENSE file for details.
 */
package me.srodrigo.databindingtest.common.presentation;

import android.databinding.BaseObservable;

import me.srodrigo.databindingtest.common.BindingView;

public abstract class BaseBindingView<T> extends BaseObservable implements BindingView<T> {

	@Override
	public void bind(T model) {
		bindData(model);
		notifyDataChanged();
	}

	protected abstract void bindData(T model);

	private void notifyDataChanged() {
		notifyChange();
	}

}

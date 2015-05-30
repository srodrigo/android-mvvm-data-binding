package com.srodrigo.databindingtest.common.presentation;

import android.databinding.BaseObservable;

import com.srodrigo.databindingtest.common.BindingView;

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

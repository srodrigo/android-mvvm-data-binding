package me.srodrigo.databindingtest.common;

public abstract class ViewModel<E, V> {

	private final BindingView<E> bindingView;
	private V view;

	public ViewModel(BindingView<E> bindingView) {
		this.bindingView = bindingView;
	}

	public void attachView(V view) {
		this.view = view;
	}

	public void detachView() {
		this.view = null;
	}

	protected BindingView<E> getBindingView() {
		return bindingView;
	}

	protected V getView() {
		return view;
	}
}

/*
 * Copyright (c) 2015 Sergio Rodrigo Royo
 *
 * This software may be modified and distributed under the terms
 * of the MIT license. See the LICENSE file for details.
 */
package me.srodrigo.databindingtest.modules.user;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import me.srodrigo.databindingtest.databinding.ActivityUserDetailBinding;

import me.srodrigo.databindingtest.R;
import me.srodrigo.databindingtest.common.presentation.BindingViewFactory;
import me.srodrigo.databindingtest.user.UserDetailView;
import me.srodrigo.databindingtest.user.UserDetailViewModel;

public class UserDetailActivity extends AppCompatActivity implements UserDetailView {

	private UserDetailViewModel userDetailViewModel;

	private Button refreshButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (savedInstanceState == null) {
			final UserBindingViewImp userBindingView = BindingViewFactory.createUserBindingView();

			ActivityUserDetailBinding viewDataBinding = DataBindingUtil.setContentView(this,
					R.layout.activity_user_detail);
			viewDataBinding.setUserBindingView(userBindingView);

			refreshButton = (Button) findViewById(R.id.refresh_button);
			refreshButton.setOnClickListener(new android.view.View.OnClickListener() {
				@Override
				public void onClick(android.view.View v) {
					userDetailViewModel.onUpdateUserAge();
				}
			});

			userDetailViewModel = new UserDetailViewModel(userBindingView, new UserProvider());
			userDetailViewModel.attachView(this);
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		userDetailViewModel.onRefresh();
	}

	@Override
	protected void onDestroy() {
		userDetailViewModel.detachView();
		super.onDestroy();
	}

	@Override
	public void enableUpdateUserAge() {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				refreshButton.setVisibility(View.VISIBLE);
			}
		});
	}

	@Override
	public void disableUpdateUserAge() {
		refreshButton.setVisibility(View.GONE);
	}
}

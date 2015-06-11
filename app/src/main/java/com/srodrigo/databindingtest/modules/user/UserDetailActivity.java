package com.srodrigo.databindingtest.modules.user;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.srodrigo.databindingtest.R;
import com.srodrigo.databindingtest.common.presentation.BindingViewFactory;
import com.srodrigo.databindingtest.databinding.ActivityUserDetailBinding;
import com.srodrigo.databindingtest.user.UserDetailView;
import com.srodrigo.databindingtest.user.UserDetailViewModel;

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

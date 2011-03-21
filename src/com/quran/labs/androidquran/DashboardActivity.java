package com.quran.labs.androidquran;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.quran.labs.androidquran.common.BaseQuranActivity;
import com.quran.labs.androidquran.data.ApplicationConstants;
import com.quran.labs.androidquran.util.QuranSettings;

public class DashboardActivity extends BaseQuranActivity implements OnClickListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard);
		registerListeners();
		
		Intent i = new Intent(this, QuranDataActivity.class);
		this.startActivityForResult(i, ApplicationConstants.DATA_CHECK_CODE);
	}
	
	private void registerListeners() {
		View v;
		// Index Page
		v = findViewById(R.id.btnIndex);
		v.setOnClickListener(this);
		v = findViewById(R.id.txtIndex);
		v.setOnClickListener(this);
		
		// Last Page
		v = findViewById(R.id.btnLastPage);
		v.setOnClickListener(this);
		v = findViewById(R.id.txtLastPage);
		v.setOnClickListener(this);
		
		// Bookmarks
		v = findViewById(R.id.btnBookmarks);
		v.setOnClickListener(this);
		v = findViewById(R.id.txtBookmarks);
		v.setOnClickListener(this);
		
		// Jump
		v = findViewById(R.id.btnJump);
		v.setOnClickListener(this);
		v = findViewById(R.id.txtJump);
		v.setOnClickListener(this);
		
		// Show Translation
		v = findViewById(R.id.btnTranslation);
		v.setOnClickListener(this);
		v = findViewById(R.id.txtTranslation);
		v.setOnClickListener(this);
		
		// Downlaods
		v = findViewById(R.id.btnDownloads);
		v.setOnClickListener(this);
		v = findViewById(R.id.txtDownloads);
		v.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent;
		switch(v.getId()) {
			case R.id.btnIndex:
			case R.id.txtIndex:
				intent = new Intent(getApplicationContext(), QuranActivity.class);
	    	startActivity(intent);
			break;
			
			case R.id.btnLastPage:
			case R.id.txtLastPage:
				jumpTo(QuranSettings.getInstance().getLastPage());
			break;
			
			case R.id.btnBookmarks:
			case R.id.txtBookmarks:
				intent = new Intent(getApplicationContext(), BookmarksActivity.class);
	    	startActivity(intent);
			break;
			
			case R.id.btnJump:
			case R.id.txtJump:
				showDialog(ApplicationConstants.JUMP_DIALOG);
			break;
			
			case R.id.btnTranslation:
			case R.id.txtTranslation:
				intent = new Intent(getApplicationContext(), TranslationActivity.class);
		  	startActivityForResult(intent, ApplicationConstants.TRANSLATION_VIEW_CODE);
			break;
			
			case R.id.btnDownloads:
			case R.id.txtDownloads:
				intent = new Intent(getApplicationContext(), DownloadActivity.class);
				startActivity(intent);
			break;
			
		}
	}

}
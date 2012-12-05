package Stanley.Chen.LotusLake;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IndexMainActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.index_main);
	}

	/**
	 * go IndexQRcodeActivity
	 * */
	public void goQRcodeActivity(View v) {
		Intent it = new Intent();
		it.setClass(this, IndexQRcodeActivity.class);
		startActivity(it);
	}

	/**
	 * go IndexTalkActivity
	 * */
	public void goIndexTalkActivity(View v) {
		Intent it = new Intent();
		it.setClass(this, IndexTalkActivity.class);
		startActivity(it);
	}

	/**
	 * go IndexGuideActivity
	 * */
	public void goIndexGuideActivity(View v) {
		Intent it = new Intent();
		it.setClass(this, IndexGuideActivity.class);
		startActivity(it);
	}

	/**
	 * go IndexSceneActivity
	 * */
	public void goIndexSceneActivity(View v) {
		Intent it = new Intent();
		it.setClass(this, IndexSceneActivity.class);
		startActivity(it);
	}

	/**
	 * go IndexMapActivity
	 * */
	public void goIndexMapActivity(View v) {
		Intent it = new Intent();
		it.setClass(this, IndexMapActivity.class);
		startActivity(it);
	}

	/**
	 * go IndexTrafficActivity
	 * */
	public void goIndexTrafficActivity(View v) {
		Intent it = new Intent();
		it.setClass(this, IndexTrafficActivity.class);
		startActivity(it);
	}
}
package Stanley.Chen.LotusLake;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class QuickMainActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quick_main);

		findViewById();

	}

	/** 
	 * 
	 * */
	private void findViewById() {
		picture = (ImageView) findViewById(R.id.picture);
		title = (TextView) findViewById(R.id.title);
		ench = (TextView) findViewById(R.id.ench);
		ALL = (LinearLayout) findViewById(R.id.ALL);
	}

	/**
	 * go IndexQRcodeActivity
	 * */
	public void goQRcodeActivity(View v) {
		Intent it = new Intent();
		it.setClass(this, IndexQRcodeActivity.class);
		startActivity(it);
	}

	private ImageView picture;
	private TextView title, ench;
	private LinearLayout ALL;
	// private final String imageInSD = "R.drawable.test";
}
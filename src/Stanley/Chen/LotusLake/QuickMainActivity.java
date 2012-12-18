package Stanley.Chen.LotusLake;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class QuickMainActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quick_main);

		findViewById();

		// Bitmap bitmap = BitmapFactory.decodeFile(imageInSD);
		// myMid.setImageBitmap(bitmap);
	}

	/** 
	 * 
	 * */
	private void findViewById() {
		myMid = (ImageView) findViewById(R.id.myMid);
	}

	/**
	 * go IndexQRcodeActivity
	 * */
	public void goQRcodeActivity(View v) {
		Intent it = new Intent();
		it.setClass(this, IndexQRcodeActivity.class);
		startActivity(it);
	}

	private ImageView myMid;
//	private final String imageInSD = "R.drawable.test";
}
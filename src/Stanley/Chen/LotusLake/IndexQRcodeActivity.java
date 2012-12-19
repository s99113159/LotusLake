package Stanley.Chen.LotusLake;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class IndexQRcodeActivity extends Activity {
	/** Called when the activity is first created. */
	private String linksArray[][] = {
			{ "孔廟", "高雄孔子廟",
					"http://en.wikipedia.org/wiki/Confuciustempel_van_Kaohsiung" },
			{ "春秋閣", "春秋閣_(高雄市)",
					"http://en.wikipedia.org/wiki/Spring_and_Autumn_Pavilions" },
			{ "先樹三山宮", "先樹三山宮",
					"http://en.wikipedia.org/wiki/Xian_Ju_Three_Mountain_Palace" },
			{ "鎮福廟", "鎮福廟", "http://en.wikipedia.org/wiki/Zhen_Fu_Temple" },
			{ "城隍廟", "鳳邑舊城城隍廟", "http://en.wikipedia.org/wiki/Cheng_Huang_Temple" },
			{ "慈濟宮", "慈濟宮", "http://en.wikipedia.org/wiki/Cih_Ji_Palace" },
			{ "清水宮", "", "http://en.wikipedia.org/wiki/Qing_shui_Temple" },
			{ "慈德宮", "", "http://en.wikipedia.org/wiki/Cide_Palace" },
			{ "天公廟", "", "http://en.wikipedia.org/wiki/God_Temple" },
			{ "天府宮", "", "http://en.wikipedia.org/wiki/Tianfu_Palace" },
			{ "啟明堂", "", "http://en.wikipedia.org/wiki/Chi_Ming_palace" },
			{ "龍虎塔", "",
					"http://en.wikipedia.org/wiki/Dragon_and_Tiger_Pagodas" } };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.index_qrcode);
		// 監聽camera
		((TextView) findViewById(R.id.qrcode_camera))
				.setOnClickListener(cameraListener);
	}

	private OnClickListener cameraListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			hasInstallZXing();
		}
	};

	/**
	 * 
	 * 打開QRCodeReade - ZXing
	 * 
	 * @author Ali
	 * 
	 * */
	public void openQRCodeReader(View v) {
		Toast.makeText(this, "click", Toast.LENGTH_SHORT).show();
		hasInstallZXing();
	}

	/**
	 * 
	 * 判斷是否有安裝ZXingQRCodeReader
	 * 
	 * 如果有安裝則啟動ZXing，並且掃描成功後自動導向QRCode網址
	 * 
	 * 如果沒安裝則詢問使用者是否安裝ZXing
	 * 
	 * Y - 跳動GooglePlay商店ZXing的頁面
	 * 
	 * N - 則關閉頁面跳回首頁
	 * 
	 * @author Ali
	 * 
	 * */
	private int hasInstallZXing() {
		Intent intent = new Intent("com.google.zxing.client.android.SCAN");
		if (getPackageManager().queryIntentActivities(intent,
				PackageManager.MATCH_DEFAULT_ONLY).size() == 0) {
			// 未安裝Zxing
			AlertDialog.Builder downDg = new AlertDialog.Builder(this);

			downDg.setTitle("安裝Barcode Scanner");
			downDg.setMessage("程式需要ZXing Barcode Scanner,你要安裝嗎?");
			downDg.setPositiveButton("OK",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialogInterface,
								int i) {
							goToLink("market://search?q=pname:com.google.zxing.client.android");
						}
					});
			downDg.setNegativeButton("取消",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialogInterface,
								int i) {
						}
					});
			downDg.show();
		} else {
			// 已安裝Zxing
			Intent zxing = new Intent("com.google.zxing.client.android.SCAN"); // 開啟條碼掃描器
			intent.putExtra("SCAN_MODE", "QR_CODE_MODE"); // 設定QR Code參數
			startActivityForResult(zxing, 1); // 要求回傳1
			return 0;
		}
		return -1;
	}

	/**
	 * 
	 * 取得景點網址
	 * 
	 * @param place
	 *            觀光景點名稱
	 * 
	 * @param language
	 *            語系
	 * 
	 * @author Ali
	 * 
	 * */
	protected void getPlaceUrl(String place, String language) {
		// 尋找到指定的景點
		int i, j;
		String placeUrl;
		for (i = 0; i < linksArray.length; i++)
			if (linksArray[i][0].equals(place))
				break;

		TextView qrId = (TextView) findViewById(R.id.qrId);
		// 中文1 英文2
		if (qrId.getText().toString().equals("QR code")) {
			language = "en";
		} else {
			language = "ch";
		}
		j = language.toLowerCase().equals("ch") ?  1 : 2;
		// 如果此語言的網址為空，則利用另外一個語言的網址代替
		try {
			if (linksArray[i][j].equals("")) {
				placeUrl = j == 1 ? linksArray[i][2] : linksArray[i][1];
				language = j == 1 ? "en" : "ch";
			} else {
				placeUrl = linksArray[i][j];
			}
			goToLink("http://120.119.77.249/~s11113151/LotusLake/addPoint.php?language="
					+ language.toLowerCase()
					+ "&attractions="
					+ place
					+ "&direction=" + placeUrl);
		} catch (Exception e) {
			Toast.makeText(this, "This infomation can not be found.",
					Toast.LENGTH_SHORT).show();
			Log.e("error", e.toString());
		}

	}

	/**
	 * 
	 * 轉向指定字串的網址
	 * 
	 * @param url
	 *            要導向得網址
	 * 
	 * @author Ali
	 * 
	 * */
	protected void goToLink(String url) {
		Uri uri = Uri.parse(url);
		try {
			startActivity(new Intent(Intent.ACTION_VIEW, uri));
		} catch (ActivityNotFoundException e) {
			Toast.makeText(this, "出現錯誤，請稍後再嘗試", Toast.LENGTH_SHORT).show();
			Log.e("error", e.toString());
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == 1) { // startActivityForResult回傳值
			if (resultCode == RESULT_OK) {
				String contents = data.getStringExtra("SCAN_RESULT"); // 取得QR
				// Code內容
				// 以下開始處理資料
				getPlaceUrl(contents.split(" ")[0], contents.split(" ")[1]);
			} else if (resultCode == RESULT_CANCELED) {
				// Handle cancel
			}
		}
	}
}
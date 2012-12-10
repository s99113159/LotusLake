package Stanley.Chen.LotusLake;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class IndexQRcodeActivity extends Activity {
	/** Called when the activity is first created. */
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
				goToLink(contents);
			} else if (resultCode == RESULT_CANCELED) {
				// Handle cancel
			}
		}
	}
}
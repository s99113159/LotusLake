package Stanley.Chen.LotusLake;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class QuickMainActivity extends Activity implements OnGestureListener {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quick_main);

		findViewById();
		detector = new GestureDetector(this);
	}

	public boolean onTouchEvent(MotionEvent event) {
		return this.detector.onTouchEvent(event);
	}

	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		if (e1.getX() - e2.getX() > 100) {
			if (now < 3) {
				now++;
			} else
				now = 0;

			if (title.getText().toString().charAt(0) > 64
					&& title.getText().toString().charAt(0) < 91) {
				title.setText(name[1][now]);
				ench.setText(in[1][now]);
			} else {
				title.setText(name[0][now]);
				ench.setText(in[0][now]);
			}
		} else if (e1.getX() - e2.getX() < -100) {
			if (now > 1) {
				now--;
			} else
				now = 3;

			if (title.getText().toString().charAt(0) > 64
					&& title.getText().toString().charAt(0) < 91) {
				title.setText(name[1][now]);
			} else {
				title.setText(name[0][now]);
				ench.setText(in[0][now]);
			}
		}
		return false;
	}

	public boolean onDown(MotionEvent e) {
		return false;
	}

	public void onLongPress(MotionEvent e) {
	}

	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		return false;
	}

	public void onShowPress(MotionEvent e) {
	}

	public boolean onSingleTapUp(MotionEvent e) {
		return false;
	}

	private GestureDetector detector;

	/**
	 * set findViewById
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
	private int[] image = { R.drawable.v00, R.drawable.v01, R.drawable.v02,
			R.drawable.v03 };
	private String[][] name = {
			{ "龍虎塔", "慈濟宮", "啟明堂", "仙樹三山宮" },
			{ "Dragon and Tiger Pagodas", "Cih Ji Palace", "Chi Ming palace",
					"Xian Ju Three Mountain Palace" } };
	private String[][] in = {
			{
					"塔高七層，潭水上立有龍虎兩孿生閣樓，樓前各有龍虎塑像，遊客可以身為道，由龍口進，虎口出，取其吉祥之意。塔身與岸邊有九曲橋銜接，與潭面相互對應。龍塔內畫有中國的二十四孝子插圖，虎塔則畫有十二賢士及玉皇大帝三十六宮將圖。",
					"主祀保生大帝，每年中元節普渡，家家戶戶以蕹菜把掛在門外致祭，神前桌頂則置蕹菜把、五牲粿、水果等供品，以為祭祀，這種供奉蕹菜把之祭典，至今仍盛傳於民間。民國49年重建慈濟宮，並迎奉保生大帝、虎爺諸神，至今香火鼎盛，成為當地居民守護神。民國63年間，保生大帝降旨指示建造龍虎塔，自龍虎塔建造完成推出後，左營龍虎塔就成最著名的地標之一。",
					"又稱東南帝闕大殿，為蓮池潭畔最雄偉的寺廟。 啟明堂，坐西向東，民國六十二年重建為三樓宮殿式建，雄偉壯觀，主祀文武二聖，也就是文聖孔子和武聖關公。日本的風俗習慣傳至台灣，文化、民俗、宗教等，都受到了限制，使大家都非常擔心，當時啟明堂的開堂先賢，謝知翁、陳旺翁等人，一起到神前擲筊求示，在神的指示下，設置「明德堂」。從此創堂諸先賢，不辭辛勞的為啟明堂貢獻心力，期盼能維繫道統，挽世風於將頹。",
					"位於高雄市左營區左營下路240號，位在蓮潭路新孔廟的斜對面，左營的哈囉市場裏面。主要是祭祀潮州府的巾山、明山、獨山三座山神，是自然山嶽神格與人像化。 仙樹爺公是山嶽人像化的神像。神壇前的左右方分別有文身打扮的護法老爺掌管文書及穿著鋼盔甲冑，武藝高超的舍下老人。仙樹爺公原為潮州府的信仰，後來擴展到客家莊，頗具客家人的原鄉特色。" },
			{
					"The towers is height of seven stores, has set up to stand on the lake. In front of the buildings have their own dragon and tiger statue, the visitors can as the tower’s body as road, entering the dragon’s mouth and coming out from the tiger’s mouth, it means auspicious.",
					"It worships Baosheng Dadi. Every Chungyuan Festival, every household hangs radish on door for memorial service. Putting sacrifice on table before the god such as radish, animal sacrifice, Glutinous rice lump and fruits to offer sacrifices to gods or ancestors. This ceremony of sacrificing radish still was rumored in civil",
					"Also called Southeast of Dili Que hall, Chi Ming palace is the most spectacular temple by Lotus Lake. Located in the west and facing the east, the temple was rebuilt in 1973 as a three-story, palace-style grand architecture. It is mainly for the worship of the two sages, Confucius and Lord Guan. While Taiwanese people were worried about being influenced by the Japanese customs, such as its culture, folklore, and religion, Those who founded Chi Ming Hall, including Xie Zhi Weng and Chen Wang Weng, constructed Ming De Hall under God’s will by tossing divination blocks.",
					"Located at No.240, Zuoying Sia Rd., Zuoying Dist., Kaohsiung City 813, Taiwan. It was situated in opposite with new Confucian Temple of Lotus Lake and situated in Hello Market of Zuoying. It worships three Mountain Spirits for Jin mountain, Ming mountain and Du mountain of Chaozhou prefecture and they are a natural mountain godhead and portrait. Xian Ju Father God is a mountain Portrait statue." } };
	private int now = 0;
	// private final String imageInSD = "R.drawable.test";
}
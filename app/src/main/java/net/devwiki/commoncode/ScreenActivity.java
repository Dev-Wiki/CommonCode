package net.devwiki.commoncode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import net.devwiki.common.util.ScreenUtil;
import net.devwiki.common.util.SizeUtil;
import net.devwiki.log.DevLog;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScreenActivity extends AppCompatActivity {

    @BindView(R.id.result_tv)
    TextView resultTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);
        ButterKnife.bind(this);

        resultTv.append("screenWidth:" + ScreenUtil.getScreenWidth(this) + "\n");
        resultTv.append("screenHeight:" + ScreenUtil.getScreenHeight(this) + "\n");
        resultTv.append("density:" + ScreenUtil.getDensity(this) + "\n");
        resultTv.append("densityDpi:" + ScreenUtil.getDensityDpi(this) + "\n");
        resultTv.append("scaledDensity:" + ScreenUtil.getScaledDensity(this) + "\n");

        DevLog.i("density:" + getResources().getDisplayMetrics().density);
        DevLog.i("densityDpi:" + getResources().getDisplayMetrics().densityDpi);
        DevLog.i("heightPixels:" + getResources().getDisplayMetrics().heightPixels);
        DevLog.i("widthPixels:" + getResources().getDisplayMetrics().widthPixels);
        DevLog.i("scaledDensity:" + getResources().getDisplayMetrics().scaledDensity);
        DevLog.i("xdpi:" + getResources().getDisplayMetrics().xdpi);
        DevLog.i("ydpi:" + getResources().getDisplayMetrics().ydpi);

        resultTv.append("10dp = " + SizeUtil.dp2px(this, 10) + " px\n");
        resultTv.append("10sp = " + SizeUtil.sp2px(this, 10) + " px\n");
        resultTv.append("10px = " + SizeUtil.px2dp(this, 10) + " dp\n");
        resultTv.append("10px = " + SizeUtil.px2sp(this, 10) + " sp\n");
    }
}

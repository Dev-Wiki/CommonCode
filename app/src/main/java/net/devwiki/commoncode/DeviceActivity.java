package net.devwiki.commoncode;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import net.devwiki.common.util.DeviceUtil;
import net.devwiki.common.util.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DeviceActivity extends AppCompatActivity {

    private static final int CODE_PHONE = 0x001;
    private static final int CODE_WIFI = 0x002;

    @BindView(R.id.result_tv)
    TextView resultTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);
        ButterKnife.bind(this);

        resultTv.append("Brand:" + DeviceUtil.getPhoneBrand() + "\n");
        resultTv.append("Model:" + DeviceUtil.getPhoneModel() + "\n");
        resultTv.append("SystemVersion:" + DeviceUtil.getSystemVersionName() + "\n");
        resultTv.append("SystemLevel:" + DeviceUtil.getSystemVersionCode() + "\n");

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)
                == PackageManager.PERMISSION_GRANTED) {
            getPhoneInfo();
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_PHONE_STATE}, CODE_PHONE);
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_WIFI_STATE)
                == PackageManager.PERMISSION_GRANTED) {
            getWifiInfo();
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_WIFI_STATE}, CODE_WIFI);
        }
    }

    private void getWifiInfo() {
        resultTv.append("MacAddress:" + DeviceUtil.getMacAddress(this) + "\n");
    }

    private void getPhoneInfo() {
        resultTv.append("IMEI:" + DeviceUtil.getIMEI(this) + "\n");
        resultTv.append("IMSI:" + DeviceUtil.getIMSI(this) + "\n");
        resultTv.append("Number:" + DeviceUtil.getPhoneNumber(this) + "\n");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == CODE_PHONE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getPhoneInfo();
            } else {
                ToastUtil.showShort(this, "请给与电话权限!");
            }
        }
        if (requestCode == CODE_WIFI) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getWifiInfo();
            } else {
                ToastUtil.showShort(this, "请给与WiFi权限!");
            }
        }
    }
}

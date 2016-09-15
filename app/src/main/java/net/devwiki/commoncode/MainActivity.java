package net.devwiki.commoncode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import net.devwiki.common.util.JsonUtil;
import net.devwiki.log.DevLog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.network_btn, R.id.file_btn, R.id.device_btn, R.id.screen_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.network_btn:
                startActivity(new Intent(this, NetworkActivity.class));
                break;
            case R.id.file_btn:
                startActivity(new Intent(this, FileActivity.class));
                break;
            case R.id.device_btn:
                startActivity(new Intent(this, DeviceActivity.class));
                break;
            case R.id.screen_btn:
                startActivity(new Intent(this, ScreenActivity.class));
                break;
        }
    }
}

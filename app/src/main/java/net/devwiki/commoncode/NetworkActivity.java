package net.devwiki.commoncode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;


import net.devwiki.common.util.NetworkUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NetworkActivity extends AppCompatActivity {

    @BindView(R.id.open_btn)
    Button openBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.open_btn)
    public void onClick() {
        NetworkUtil.openNetworkSettings(this);
    }
}

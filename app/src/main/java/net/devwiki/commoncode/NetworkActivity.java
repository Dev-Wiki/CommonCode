package net.devwiki.commoncode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import net.devwiki.common.util.NetworkUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NetworkActivity extends AppCompatActivity {

    @BindView(R.id.result_tv)
    TextView resultTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);
        ButterKnife.bind(this);
    }

    private void getNetworkInfo() {
        resultTv.append(NetworkUtil.getNetworkOperatorName(this) + "\n");
        resultTv.append(NetworkUtil.getNetWorkTypeName(this) + "\n");
        resultTv.append(NetworkUtil.getNetWorkType(this) + "\n");
        resultTv.append(NetworkUtil.getPhoneType(this) + "\n");
    }

    @OnClick(R.id.open_btn)
    public void onClick() {
        NetworkUtil.openNetworkSettings(this);
    }
}

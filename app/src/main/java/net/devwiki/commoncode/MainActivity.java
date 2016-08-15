package net.devwiki.commoncode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.network_btn)
    Button networkBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.network_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.network_btn:
                startActivity(new Intent(this, NetworkActivity.class));
                break;
        }
    }
}

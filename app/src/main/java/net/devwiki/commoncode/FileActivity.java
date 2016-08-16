package net.devwiki.commoncode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import net.devwiki.common.util.FileUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FileActivity extends AppCompatActivity {

    @BindView(R.id.file_tv)
    TextView fileTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        ButterKnife.bind(this);
    }
}

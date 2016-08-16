package net.devwiki.commoncode;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import net.devwiki.common.util.FileUtil;
import net.devwiki.common.util.ToastUtil;
import net.devwiki.log.DevLog;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FileActivity extends AppCompatActivity {

    private static final int CODE_REQUIRE_PEMISSION = 0x001;

    @BindView(R.id.file_tv)
    TextView fileTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        ButterKnife.bind(this);

        checkPermission();

        DevLog.d(File.separator);
        DevLog.d(File.pathSeparator);
        DevLog.d("root:" + Environment.getRootDirectory().getAbsolutePath());
        DevLog.d("state:" + Environment.getExternalStorageState());
        DevLog.d("external:" + Environment.getExternalStorageDirectory().getAbsolutePath());
        DevLog.d("data:" + Environment.getDataDirectory().getAbsolutePath());
        DevLog.d("download cache:" + Environment.getDownloadCacheDirectory().getAbsolutePath());
        DevLog.d("music:" + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC)
                .getAbsolutePath());
        DevLog.d(getExternalCacheDir().getAbsolutePath());
        DevLog.d(getExternalFilesDir(Environment.DIRECTORY_PODCASTS).getParentFile().getAbsolutePath());
    }

    private void checkPermission() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            String[] permissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};
            ActivityCompat.requestPermissions(this, permissions, CODE_REQUIRE_PEMISSION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == CODE_REQUIRE_PEMISSION) {
            if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                ToastUtil.showShort(getApplicationContext(), "请给予存储权限!");
                finish();
            }
        }
    }
}

package com.anningtex.testphotoalbum.act;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.anningtex.testphotoalbum.R;
import com.hjq.permissions.OnPermissionCallback;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_launch).setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, DesignOrderPicActivity.class));
        });
        findViewById(R.id.btn_two).setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, WaitContainerActivity.class));
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        setPermissions();
    }

    private void setPermissions() {
        List<String> permissions = new ArrayList<>();
        permissions.add(Permission.READ_EXTERNAL_STORAGE);
        permissions.add(Permission.WRITE_EXTERNAL_STORAGE);
        permissions.add(Permission.CAMERA);
        XXPermissions.with(this)
                .permission(permissions)
                .request(new OnPermissionCallback() {
                    @Override
                    public void onGranted(List<String> permissions, boolean all) {
                        if (all) {
                            Log.e("TAG", "获取权限成功");
                        } else {
                            Toast.makeText(MainActivity.this, "获取部分权限成功,但部分权限未正常授予", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onDenied(List<String> permissions, boolean never) {
                        if (never) {
                            Toast.makeText(MainActivity.this, "被永久拒绝授权,请手动授予相关权限", Toast.LENGTH_SHORT).show();
                            XXPermissions.startPermissionActivity(MainActivity.this, permissions);
                        } else {
                            Toast.makeText(MainActivity.this, "获取权限失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == XXPermissions.REQUEST_CODE) {
            if (XXPermissions.isGranted(this, Permission.READ_EXTERNAL_STORAGE) &&
                    XXPermissions.isGranted(this, Permission.WRITE_EXTERNAL_STORAGE)) {
                Toast.makeText(MainActivity.this, "已经在权限设置页授予了权限", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "没有在权限设置页授予权限", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
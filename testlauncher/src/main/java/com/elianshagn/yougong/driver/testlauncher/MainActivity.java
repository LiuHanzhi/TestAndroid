package com.elianshagn.yougong.driver.testlauncher;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MyFragment myFragment = new MyFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main, myFragment).commitAllowingStateLoss();
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityA.launch(myFragment);
            }
        });
//        String laucherPkg = getLauncherPackageName(this);
//        if (null != laucherPkg) {
//            setDefaultLauncher(laucherPkg);
//        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("lhz","MainActivity.onActivityResult()");
    }


    /**
     * 获取正在运行桌面包名（注：存在多个桌面时且未指定默认桌面时，该方法返回Null,使用时需处理这个情况）
     */
    public static String getLauncherPackageName(Context context) {
        final Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        final ResolveInfo res = context.getPackageManager().resolveActivity(intent, 0);
        if (res.activityInfo == null) {
            // should not happen. A home is always installed, isn't it?
            return null;
        }
        if (res.activityInfo.packageName.equals("android")) {
            // 有多个桌面程序存在，且未指定默认项时；
            Log.d("lhz", "有多个桌面程序存在，且未指定默认项");
            return null;
        } else {
            Log.d("lhz", "指定了默认项，pkg：" + res.activityInfo.packageName);
            return res.activityInfo.packageName;
        }
    }

    private void setDefaultLauncher(String defaultLauncherPkg) {
        PackageManager pm = getPackageManager();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.MAIN");
        filter.addCategory("android.intent.category.HOME");
        filter.addCategory("android.intent.category.DEFAULT");
        Context context = getApplicationContext();
        ComponentName component = new ComponentName(context.getPackageName(), MainActivity.class.getName());
        ComponentName[] components = new ComponentName[]{new ComponentName("com.elianshagn.yougong.driver.testlauncher", "com.elianshagn.yougong.driver.testlauncher.Launcher"), component};
        pm.clearPackagePreferredActivities(defaultLauncherPkg);
        //pm.addPreferredActivity(filter, IntentFilter.MATCH_CATEGORY_EMPTY, components, component);
    }

    public void appDetail(View view) {
        startActivity(new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:com.google.android.googlequicksearchbox")));
    }
}

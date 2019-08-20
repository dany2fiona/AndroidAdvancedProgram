package com.dany.advance;

import android.app.Application;
import android.os.Build;
import android.os.StrictMode;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by dan.y on 2019/2/25.
 */

public class MyApp extends Application {

    private boolean DEV_MODE = true;
    @Override
    public void onCreate() {
        if(DEV_MODE){
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectCustomSlowCalls()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork()
                    .penaltyDialog()
                    .penaltyLog()
                    
                    .penaltyFlashScreen()
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectLeakedSqlLiteObjects()
                    .detectLeakedClosableObjects()
                    .penaltyLog()
                    .penaltyDeath()
                    .build());
        }
        super.onCreate();
        if(BuildConfig.DEBUG){
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
    }
}

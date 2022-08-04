package me.wcy.cchat;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;

import me.wcy.cchat.services.ClientService;
import me.wcy.cchat.services.ServerService;

/**
 * Created by hzwangchenyan on 2017/12/26.
 */
public class ChatApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        startService(new Intent(this, ClientService.class));
        startService(new Intent(this, ServerService.class));
    }

    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}

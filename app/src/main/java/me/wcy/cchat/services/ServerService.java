package me.wcy.cchat.services;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import me.wcy.cchat.tools.AppCache;
import me.wcy.cchat.server.NettyServerBootstrap;

public class ServerService extends Service {

    private Handler handler;

    @Override
    public void onCreate() {
        super.onCreate();
        handler = new Handler();
        AppCache.setServerService(this);
        Log.d("ServerService", "onCreate: ");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void startServer(int port) {

        NettyServerBootstrap serverBootstrap = new NettyServerBootstrap(port);
        serverBootstrap.bind();


//        handler.post(() -> {
//            AppCache.setServerService(this);
//            AppCache.setServerCallback(callback);
//            AppCache.getServerService().startServer();
//        });
    }
}

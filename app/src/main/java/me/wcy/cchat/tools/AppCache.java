package me.wcy.cchat.tools;

import me.wcy.cchat.model.LoginInfo;
import me.wcy.cchat.model.ServerInfo;
import me.wcy.cchat.services.ClientService;
import me.wcy.cchat.services.ServerService;

/**
 * Created by hzwangchenyan on 2017/12/26.
 */
public class AppCache {

    private static ClientService clientService;
    private static ServerService serverService;

    private static LoginInfo myInfo;
    private static ServerInfo serverInfo;

    public static ClientService getClientService() {
        return clientService;
    }

    public static void setClientService(ClientService clientService) {
        AppCache.clientService = clientService;
    }

    public static LoginInfo getMyInfo() {
        return myInfo;
    }

    public static void setMyInfo(LoginInfo myInfo) {
        AppCache.myInfo = myInfo;
    }

    public static ServerInfo getServerInfo() {
        return serverInfo;
    }

    public static void setServerInfo(ServerInfo serverInfo) {
        AppCache.serverInfo = serverInfo;
    }

    public static ServerService getServerService() {
        return serverService;
    }

    public static void setServerService(ServerService serverService) {
        AppCache.serverService = serverService;
    }
}

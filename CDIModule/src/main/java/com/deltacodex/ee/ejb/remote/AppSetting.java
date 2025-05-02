package com.deltacodex.ee.ejb.remote;

import jakarta.ejb.Remote;

@Remote
public interface AppSetting {
    String getAppName();
    String getAppVersion();
    String getAppDescription();
}

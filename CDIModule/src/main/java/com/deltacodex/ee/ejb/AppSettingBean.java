package com.deltacodex.ee.ejb;

import com.deltacodex.ee.CDI.Service;
import com.deltacodex.ee.ejb.remote.AppSetting;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class AppSettingBean implements AppSetting {

//    private Service service = new Service();
//    instead of this method use below method
    @Inject
    private Service service;

    /**
     * <h3>This Error will show on Server Log</h3>
     * [2025-05-01 06:16:28,670] Artifact CDIModule:ejb: java.io.IOException: com.sun.enterprise.admin.remote.RemoteFailureException: Error occurred during deployment: Exception while loading the app : CDI deployment failure: WELD-001408: Unsatisfied dependencies for type Service with qualifiers @Default
     *   at injection point [BackedAnnotatedField] @Inject private com.deltacodex.ee.ejb.AppSettingBean.service
     *   at com.deltacodex.ee.ejb.AppSettingBean.service(AppSettingBean.java:0)
     * . Please see server.log for more details.
     */

    @Override
    public String getAppName() {
        service.sayHello();
        return "CDIModule";
    }

    @Override
    public String getAppVersion() {
        return "1.0.0";
    }

    @Override
    public String getAppDescription() {
        return "This is the CDI Module App Settings";
    }
}

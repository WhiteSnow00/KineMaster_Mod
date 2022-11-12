// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.moduleinstall.ModuleInstallClient;
import com.google.android.gms.common.api.GoogleApi;

public final class zay extends GoogleApi implements ModuleInstallClient
{
    private static final Api.ClientKey a;
    private static final Api.AbstractClientBuilder b;
    private static final Api c;
    public static final int d = 0;
    
    static {
        c = new Api("ModuleInstall.API", b = new a(), a = new Api.ClientKey());
    }
}

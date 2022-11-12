// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.common;

import android.content.Context;

class k
{
    private String a;
    
    private static String b(final Context context) {
        String installerPackageName;
        if ((installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName())) == null) {
            installerPackageName = "";
        }
        return installerPackageName;
    }
    
    String a(final Context context) {
        synchronized (this) {
            if (this.a == null) {
                this.a = b(context);
            }
            String a;
            if ("".equals(this.a)) {
                a = null;
            }
            else {
                a = this.a;
            }
            return a;
        }
    }
}

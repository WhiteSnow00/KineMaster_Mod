// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepName;

@KeepName
public final class GooglePlayServicesIncorrectManifestValueException extends GooglePlayServicesManifestException
{
    public GooglePlayServicesIncorrectManifestValueException(final int n) {
        final int a = GoogleApiAvailabilityLight.a;
        final StringBuilder sb = new StringBuilder();
        sb.append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ");
        sb.append(a);
        sb.append(" but found ");
        sb.append(n);
        sb.append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
        super(n, sb.toString());
    }
}

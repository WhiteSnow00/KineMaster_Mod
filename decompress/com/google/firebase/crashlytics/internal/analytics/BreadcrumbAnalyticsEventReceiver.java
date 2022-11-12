// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.analytics;

import com.google.firebase.crashlytics.internal.Logger;
import org.json.JSONException;
import java.util.Iterator;
import org.json.JSONObject;
import android.os.Bundle;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;

public class BreadcrumbAnalyticsEventReceiver implements AnalyticsEventReceiver, BreadcrumbSource
{
    private BreadcrumbHandler a;
    
    private static String b(final String s, final Bundle bundle) throws JSONException {
        final JSONObject jsonObject = new JSONObject();
        final JSONObject jsonObject2 = new JSONObject();
        for (final String s2 : bundle.keySet()) {
            jsonObject2.put(s2, bundle.get(s2));
        }
        jsonObject.put("name", (Object)s);
        jsonObject.put("parameters", (Object)jsonObject2);
        return jsonObject.toString();
    }
    
    @Override
    public void a(final BreadcrumbHandler a) {
        this.a = a;
        Logger.f().b("Registered Firebase Analytics event receiver for breadcrumbs");
    }
    
    @Override
    public void onEvent(final String s, final Bundle bundle) {
        final BreadcrumbHandler a = this.a;
        if (a != null) {
            try {
                final StringBuilder sb = new StringBuilder();
                sb.append("$A$:");
                sb.append(b(s, bundle));
                a.a(sb.toString());
            }
            catch (final JSONException ex) {
                Logger.f().k("Unable to serialize Firebase Analytics event to breadcrumb.");
            }
        }
    }
}

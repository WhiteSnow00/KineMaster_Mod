// 
// Decompiled by Procyon v0.6.0
// 

package com.google.ads.mediation.facebook;

import java.util.Iterator;
import com.google.android.gms.ads.AdError;
import java.util.List;
import android.content.Context;
import java.util.ArrayList;
import com.facebook.ads.AudienceNetworkAds;

class a implements InitListener
{
    private static a d;
    private boolean a;
    private boolean b;
    private final ArrayList<a> c;
    
    private a() {
        this.a = false;
        this.b = false;
        this.c = new ArrayList<a>();
    }
    
    static a a() {
        if (a.d == null) {
            a.d = new a();
        }
        return a.d;
    }
    
    void b(final Context context, final String s, final a a) {
        final ArrayList list = new ArrayList();
        list.add(s);
        a().c(context, list, a);
    }
    
    void c(final Context context, final ArrayList<String> list, final a a) {
        if (this.a) {
            this.c.add(a);
            return;
        }
        if (this.b) {
            a.b();
            return;
        }
        this.a = true;
        a().c.add(a);
        AudienceNetworkAds.buildInitSettings(context).withMediationService("GOOGLE:6.11.0.1").withPlacementIds(list).withInitListener(this).initialize();
    }
    
    @Override
    public void onInitialized(final InitResult initResult) {
        this.a = false;
        this.b = initResult.isSuccess();
        for (final a a : this.c) {
            if (initResult.isSuccess()) {
                a.b();
            }
            else {
                a.a(new AdError(104, initResult.getMessage(), "com.google.ads.mediation.facebook"));
            }
        }
        this.c.clear();
    }
    
    interface a
    {
        void a(final AdError p0);
        
        void b();
    }
}

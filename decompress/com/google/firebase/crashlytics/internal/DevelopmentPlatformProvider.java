// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal;

import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.InputStream;
import java.io.IOException;
import android.content.Context;

public class DevelopmentPlatformProvider
{
    private final Context a;
    private b b;
    
    public DevelopmentPlatformProvider(final Context a) {
        this.a = a;
        this.b = null;
    }
    
    static Context a(final DevelopmentPlatformProvider developmentPlatformProvider) {
        return developmentPlatformProvider.a;
    }
    
    static boolean b(final DevelopmentPlatformProvider developmentPlatformProvider, final String s) {
        return developmentPlatformProvider.c(s);
    }
    
    private boolean c(final String s) {
        if (this.a.getAssets() == null) {
            return false;
        }
        try {
            try (final InputStream open = this.a.getAssets().open(s)) {}
            return true;
        }
        catch (final IOException ex) {
            return false;
        }
    }
    
    private b f() {
        if (this.b == null) {
            this.b = new b(null);
        }
        return this.b;
    }
    
    public String d() {
        return DevelopmentPlatformProvider.b.a(this.f());
    }
    
    public String e() {
        return DevelopmentPlatformProvider.b.b(this.f());
    }
    
    private class b
    {
        private final String a;
        private final String b;
        final DevelopmentPlatformProvider c;
        
        private b(final DevelopmentPlatformProvider c) {
            this.c = c;
            final int q = CommonUtils.q(DevelopmentPlatformProvider.a(c), "com.google.firebase.crashlytics.unity_version", "string");
            if (q != 0) {
                this.a = "Unity";
                final String string = DevelopmentPlatformProvider.a(c).getResources().getString(q);
                this.b = string;
                final Logger f = Logger.f();
                final StringBuilder sb = new StringBuilder();
                sb.append("Unity Editor version is: ");
                sb.append(string);
                f.i(sb.toString());
                return;
            }
            if (DevelopmentPlatformProvider.b(c, "flutter_assets/NOTICES.Z")) {
                this.a = "Flutter";
                this.b = null;
                Logger.f().i("Development platform is: Flutter");
                return;
            }
            this.a = null;
            this.b = null;
        }
        
        b(final DevelopmentPlatformProvider developmentPlatformProvider, final DevelopmentPlatformProvider$a object) {
            this(developmentPlatformProvider);
        }
        
        static String a(final b b) {
            return b.a;
        }
        
        static String b(final b b) {
            return b.b;
        }
    }
}

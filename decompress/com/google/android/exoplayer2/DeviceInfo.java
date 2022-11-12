// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import android.os.Bundle;

public final class DeviceInfo implements Bundleable
{
    public static final DeviceInfo d;
    public static final Creator<DeviceInfo> e;
    public final int a;
    public final int b;
    public final int c;
    
    static {
        d = new DeviceInfo(0, 0, 0);
        e = b.a;
    }
    
    public DeviceInfo(final int a, final int b, final int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public static DeviceInfo a(final Bundle bundle) {
        return c(bundle);
    }
    
    private static String b(final int n) {
        return Integer.toString(n, 36);
    }
    
    private static DeviceInfo c(final Bundle bundle) {
        return new DeviceInfo(bundle.getInt(b(0), 0), bundle.getInt(b(1), 0), bundle.getInt(b(2), 0));
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (!(o instanceof DeviceInfo)) {
            return false;
        }
        final DeviceInfo deviceInfo = (DeviceInfo)o;
        if (this.a != deviceInfo.a || this.b != deviceInfo.b || this.c != deviceInfo.c) {
            b = false;
        }
        return b;
    }
    
    @Override
    public int hashCode() {
        return ((527 + this.a) * 31 + this.b) * 31 + this.c;
    }
    
    @Override
    public Bundle toBundle() {
        final Bundle bundle = new Bundle();
        bundle.putInt(b(0), this.a);
        bundle.putInt(b(1), this.b);
        bundle.putInt(b(2), this.c);
        return bundle;
    }
    
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @Target({ ElementType.TYPE_USE })
    public @interface PlaybackType {
    }
}

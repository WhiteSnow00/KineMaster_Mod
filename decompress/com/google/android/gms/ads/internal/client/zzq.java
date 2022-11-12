// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import android.view.Display;
import android.util.DisplayMetrics;
import com.google.android.gms.internal.ads.zzcfb;
import android.view.WindowManager;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.ads.AdSize;
import android.content.Context;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Class
@Reserved
public final class zzq extends AbstractSafeParcelable
{
    public static final Parcelable$Creator<zzq> CREATOR;
    @Field
    public final String a;
    @Field
    public final int b;
    @Field
    public final int c;
    @Field
    public final boolean d;
    @Field
    public final int e;
    @Field
    public final int f;
    @Field
    public final zzq[] g;
    @Field
    public final boolean h;
    @Field
    public final boolean i;
    @Field
    public boolean j;
    @Field
    public boolean p;
    @Field
    public boolean w;
    @Field
    public boolean x;
    @Field
    public boolean y;
    @Field
    public boolean z;
    
    static {
        CREATOR = (Parcelable$Creator)new zzr();
    }
    
    public zzq() {
        this("interstitial_mb", 0, 0, true, 0, 0, null, false, false, false, false, false, false, false, false);
    }
    
    public zzq(final Context context, final AdSize adSize) {
        this(context, new AdSize[] { adSize });
    }
    
    public zzq(final Context context, final AdSize[] array) {
        final AdSize adSize = array[0];
        this.d = false;
        final boolean e = adSize.e();
        this.i = e;
        this.x = zzb.f(adSize);
        this.y = zzb.g(adSize);
        final boolean h = zzb.h(adSize);
        this.z = h;
        int n;
        if (e) {
            final AdSize i = AdSize.i;
            this.e = i.c();
            n = i.a();
            this.b = n;
        }
        else if (this.y) {
            this.e = adSize.c();
            n = zzb.a(adSize);
            this.b = n;
        }
        else if (h) {
            this.e = adSize.c();
            n = zzb.b(adSize);
            this.b = n;
        }
        else {
            this.e = adSize.c();
            n = adSize.a();
            this.b = n;
        }
        final int e2 = this.e;
        final DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int e3;
        if (e2 == -1) {
            zzaw.b();
            int widthPixels4 = 0;
            Label_0418: {
                if (context.getResources().getConfiguration().orientation == 2) {
                    final DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
                    if ((int)(displayMetrics2.heightPixels / displayMetrics2.density) < 600) {
                        zzaw.b();
                        final DisplayMetrics displayMetrics3 = context.getResources().getDisplayMetrics();
                        final WindowManager windowManager = (WindowManager)context.getSystemService("window");
                        if (windowManager != null) {
                            final Display defaultDisplay = windowManager.getDefaultDisplay();
                            defaultDisplay.getRealMetrics(displayMetrics3);
                            final int heightPixels = displayMetrics3.heightPixels;
                            final int widthPixels = displayMetrics3.widthPixels;
                            defaultDisplay.getMetrics(displayMetrics3);
                            final int heightPixels2 = displayMetrics3.heightPixels;
                            final int widthPixels2 = displayMetrics3.widthPixels;
                            if (heightPixels2 == heightPixels && widthPixels2 == widthPixels) {
                                final int widthPixels3 = displayMetrics.widthPixels;
                                zzaw.b();
                                final int identifier = context.getResources().getIdentifier("navigation_bar_width", "dimen", "android");
                                int dimensionPixelSize;
                                if (identifier > 0) {
                                    dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
                                }
                                else {
                                    dimensionPixelSize = 0;
                                }
                                widthPixels4 = widthPixels3 - dimensionPixelSize;
                                this.f = widthPixels4;
                                break Label_0418;
                            }
                        }
                    }
                }
                widthPixels4 = displayMetrics.widthPixels;
                this.f = widthPixels4;
            }
            final double n2 = widthPixels4 / displayMetrics.density;
            final int n3 = e3 = (int)n2;
            if (n2 - n3 >= 0.01) {
                e3 = n3 + 1;
            }
        }
        else {
            e3 = this.e;
            zzaw.b();
            this.f = zzcfb.zzn(displayMetrics, this.e);
        }
        int n4;
        if (n == -2) {
            n4 = P1(displayMetrics);
        }
        else {
            n4 = this.b;
        }
        zzaw.b();
        this.c = zzcfb.zzn(displayMetrics, n4);
        Label_0695: {
            if (e2 != -1 && n != -2) {
                String string;
                if (!this.y && !this.z) {
                    if (!e) {
                        this.a = adSize.toString();
                        break Label_0695;
                    }
                    string = "320x50_mb";
                }
                else {
                    final int e4 = this.e;
                    final int b = this.b;
                    final StringBuilder sb = new StringBuilder();
                    sb.append(e4);
                    sb.append("x");
                    sb.append(b);
                    sb.append("_as");
                    string = sb.toString();
                }
                this.a = string;
            }
            else {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(e3);
                sb2.append("x");
                sb2.append(n4);
                sb2.append("_as");
                this.a = sb2.toString();
            }
        }
        final int length = array.length;
        if (length > 1) {
            this.g = new zzq[length];
            for (int j = 0; j < array.length; ++j) {
                this.g[j] = new zzq(context, array[j]);
            }
        }
        else {
            this.g = null;
        }
        this.h = false;
        this.j = false;
    }
    
    @Constructor
    zzq(@Param final String a, @Param final int b, @Param final int c, @Param final boolean d, @Param final int e, @Param final int f, @Param final zzq[] g, @Param final boolean h, @Param final boolean i, @Param final boolean j, @Param final boolean p15, @Param final boolean w, @Param final boolean x, @Param final boolean y, @Param final boolean z) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
        this.p = p15;
        this.w = w;
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public static int K1(final DisplayMetrics displayMetrics) {
        return (int)(P1(displayMetrics) * displayMetrics.density);
    }
    
    public static zzq L1() {
        return new zzq("interstitial_mb", 0, 0, false, 0, 0, null, false, false, false, false, true, false, false, false);
    }
    
    public static zzq M1() {
        return new zzq("320x50_mb", 0, 0, false, 0, 0, null, true, false, false, false, false, false, false, false);
    }
    
    public static zzq N1() {
        return new zzq("reward_mb", 0, 0, true, 0, 0, null, false, false, false, false, false, false, false, false);
    }
    
    public static zzq O1() {
        return new zzq("invalid", 0, 0, false, 0, 0, null, false, false, false, true, false, false, false, false);
    }
    
    private static int P1(final DisplayMetrics displayMetrics) {
        final int n = (int)(displayMetrics.heightPixels / displayMetrics.density);
        if (n <= 400) {
            return 32;
        }
        if (n <= 720) {
            return 50;
        }
        return 90;
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.B(parcel, 2, this.a, false);
        SafeParcelWriter.s(parcel, 3, this.b);
        SafeParcelWriter.s(parcel, 4, this.c);
        SafeParcelWriter.g(parcel, 5, this.d);
        SafeParcelWriter.s(parcel, 6, this.e);
        SafeParcelWriter.s(parcel, 7, this.f);
        SafeParcelWriter.E(parcel, 8, this.g, n, false);
        SafeParcelWriter.g(parcel, 9, this.h);
        SafeParcelWriter.g(parcel, 10, this.i);
        SafeParcelWriter.g(parcel, 11, this.j);
        SafeParcelWriter.g(parcel, 12, this.p);
        SafeParcelWriter.g(parcel, 13, this.w);
        SafeParcelWriter.g(parcel, 14, this.x);
        SafeParcelWriter.g(parcel, 15, this.y);
        SafeParcelWriter.g(parcel, 16, this.z);
        SafeParcelWriter.b(parcel, a);
    }
}

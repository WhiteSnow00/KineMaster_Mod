// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads.internal.client;

import android.database.Cursor;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzbts;
import android.content.pm.PackageManager$NameNotFoundException;
import com.google.android.gms.internal.ads.zzcfi;
import com.google.android.gms.common.wrappers.Wrappers;
import android.content.pm.ProviderInfo;
import android.content.Context;
import android.content.ContentProvider;

public final class zzef extends ContentProvider
{
    public final void attachInfo(final Context context, final ProviderInfo providerInfo) {
        Bundle metaData = null;
        try {
            metaData = Wrappers.a(context).c(context.getPackageName(), 128).metaData;
        }
        catch (final PackageManager$NameNotFoundException ex) {
            zzcfi.zzh("Failed to load metadata: Package name not found.", (Throwable)ex);
        }
        catch (final NullPointerException ex2) {
            zzcfi.zzh("Failed to load metadata: Null pointer exception.", (Throwable)ex2);
        }
        final zzbts zza = zzbts.zza();
        Label_0210: {
            if (metaData == null) {
                zzcfi.zzg("Metadata was null.");
                break Label_0210;
            }
            try {
                final String s = (String)metaData.get("com.google.android.gms.ads.APPLICATION_ID");
                try {
                    final Boolean b = (Boolean)metaData.get("com.google.android.gms.ads.AD_MANAGER_APP");
                    try {
                        final Boolean b2 = (Boolean)metaData.get("com.google.android.gms.ads.DELAY_APP_MEASUREMENT_INIT");
                        try {
                            final String s2 = (String)metaData.get("com.google.android.gms.ads.INTEGRATION_MANAGER");
                            if (s != null && !s.matches("^/\\d+~.+$")) {
                                if (!s.matches("^ca-app-pub-[0-9]{16}~[0-9]{10}$")) {
                                    throw new IllegalStateException("\n\n******************************************************************************\n* Invalid application ID. Follow instructions here:                          *\n* https://googlemobileadssdk.page.link/admob-android-update-manifest         *\n* to find your app ID.                                                       *\n******************************************************************************\n\n");
                                }
                                zzcfi.zze("Publisher provided Google AdMob App ID in manifest: ".concat(s));
                                if (b2 == null || !b2) {
                                    zza.zzb(context, s);
                                }
                            }
                            else if (b == null || !b) {
                                if (TextUtils.isEmpty((CharSequence)s2)) {
                                    throw new IllegalStateException("\n\n******************************************************************************\n* The Google Mobile Ads SDK was initialized incorrectly. AdMob publishers    *\n* should follow the instructions here:                                       *\n* https://googlemobileadssdk.page.link/admob-android-update-manifest         *\n* to add a valid App ID inside the AndroidManifest.                          *\n* Google Ad Manager publishers should follow instructions here:              *\n* https://googlemobileadssdk.page.link/ad-manager-android-update-manifest.   *\n******************************************************************************\n\n");
                                }
                                zzcfi.zze("The Google Mobile Ads SDK is integrated by ".concat(String.valueOf(s2)));
                            }
                            super.attachInfo(context, providerInfo);
                        }
                        catch (final ClassCastException ex3) {
                            throw new IllegalStateException("The com.google.android.gms.ads.INTEGRATION_MANAGER metadata must have a String value.", ex3);
                        }
                    }
                    catch (final ClassCastException ex4) {
                        throw new IllegalStateException("The com.google.android.gms.ads.DELAY_APP_MEASUREMENT_INIT metadata must have a boolean value.", ex4);
                    }
                }
                catch (final ClassCastException ex5) {
                    throw new IllegalStateException("The com.google.android.gms.ads.AD_MANAGER_APP metadata must have a boolean value.", ex5);
                }
            }
            catch (final ClassCastException ex6) {
                throw new IllegalStateException("The com.google.android.gms.ads.APPLICATION_ID metadata must have a String value.", ex6);
            }
        }
    }
    
    public final int delete(final Uri uri, final String s, final String[] array) {
        return 0;
    }
    
    public final String getType(final Uri uri) {
        return null;
    }
    
    public final Uri insert(final Uri uri, final ContentValues contentValues) {
        return null;
    }
    
    public final boolean onCreate() {
        return false;
    }
    
    public final Cursor query(final Uri uri, final String[] array, final String s, final String[] array2, final String s2) {
        return null;
    }
    
    public final int update(final Uri uri, final ContentValues contentValues, final String s, final String[] array) {
        return 0;
    }
}

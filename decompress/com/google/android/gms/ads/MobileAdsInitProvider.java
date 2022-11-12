// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.ads;

import android.database.Cursor;
import android.content.ContentValues;
import android.net.Uri;
import android.content.pm.ProviderInfo;
import android.content.Context;
import com.google.android.gms.ads.internal.client.zzef;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import android.content.ContentProvider;

@KeepForSdkWithMembers
public class MobileAdsInitProvider extends ContentProvider
{
    private final zzef a;
    
    public MobileAdsInitProvider() {
        this.a = new zzef();
    }
    
    public void attachInfo(final Context context, final ProviderInfo providerInfo) {
        this.a.attachInfo(context, providerInfo);
    }
    
    public int delete(final Uri uri, final String s, final String[] array) {
        return 0;
    }
    
    public String getType(final Uri uri) {
        return null;
    }
    
    public Uri insert(final Uri uri, final ContentValues contentValues) {
        return null;
    }
    
    public boolean onCreate() {
        return false;
    }
    
    public Cursor query(final Uri uri, final String[] array, final String s, final String[] array2, final String s2) {
        return null;
    }
    
    public int update(final Uri uri, final ContentValues contentValues, final String s, final String[] array) {
        return 0;
    }
}

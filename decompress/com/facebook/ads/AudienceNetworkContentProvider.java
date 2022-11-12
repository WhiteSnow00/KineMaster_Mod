// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads;

import android.database.Cursor;
import android.content.Context;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import android.content.ContentValues;
import android.net.Uri;
import android.content.ContentProvider;

public class AudienceNetworkContentProvider extends ContentProvider
{
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
        final Context context = this.getContext();
        if (context != null) {
            DynamicLoaderFactory.initialize(context, null, null, true);
        }
        return false;
    }
    
    public Cursor query(final Uri uri, final String[] array, final String s, final String[] array2, final String s2) {
        return null;
    }
    
    public int update(final Uri uri, final ContentValues contentValues, final String s, final String[] array) {
        return 0;
    }
}

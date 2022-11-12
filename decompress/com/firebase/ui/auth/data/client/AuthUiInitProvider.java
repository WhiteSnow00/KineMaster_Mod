// 
// Decompiled by Procyon v0.6.0
// 

package com.firebase.ui.auth.data.client;

import android.database.Cursor;
import com.firebase.ui.auth.AuthUI;
import android.content.ContentValues;
import android.net.Uri;
import com.firebase.ui.auth.util.Preconditions;
import android.content.pm.ProviderInfo;
import android.content.Context;
import android.content.ContentProvider;

public class AuthUiInitProvider extends ContentProvider
{
    public void attachInfo(final Context context, final ProviderInfo providerInfo) {
        Preconditions.checkNotNull(providerInfo, "AuthUiInitProvider ProviderInfo cannot be null.", new Object[0]);
        if (!"com.firebase.ui.auth.authuiinitprovider".equals(providerInfo.authority)) {
            super.attachInfo(context, providerInfo);
            return;
        }
        throw new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application's build.gradle.");
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
        AuthUI.setApplicationContext(this.getContext());
        return false;
    }
    
    public Cursor query(final Uri uri, final String[] array, final String s, final String[] array2, final String s2) {
        return null;
    }
    
    public int update(final Uri uri, final ContentValues contentValues, final String s, final String[] array) {
        return 0;
    }
}

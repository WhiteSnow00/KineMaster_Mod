// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.settings;

import java.util.ArrayList;
import java.io.Serializable;
import android.os.Bundle;
import androidx.annotation.Keep;

@Keep
public class MultithreadedBundleWrapper
{
    private final Bundle mBundle;
    
    public MultithreadedBundleWrapper() {
        this.mBundle = new Bundle();
    }
    
    public boolean getBoolean(final String s) {
        synchronized (this) {
            return this.mBundle.getBoolean(s);
        }
    }
    
    public boolean getBoolean(final String s, final boolean b) {
        synchronized (this) {
            return this.mBundle.getBoolean(s, b);
        }
    }
    
    public Integer getInteger(final String s) {
        synchronized (this) {
            Integer value;
            if (this.mBundle.containsKey(s)) {
                value = this.mBundle.getInt(s);
            }
            else {
                value = null;
            }
            return value;
        }
    }
    
    public Serializable getSerializable(final String s) {
        synchronized (this) {
            return this.mBundle.getSerializable(s);
        }
    }
    
    public String getString(String string, final String s) {
        synchronized (this) {
            string = this.mBundle.getString(string, s);
            return string;
        }
    }
    
    public String[] getStringArray(final String s) {
        synchronized (this) {
            return this.mBundle.getStringArray(s);
        }
    }
    
    public ArrayList<String> getStringArrayList(final String s) {
        synchronized (this) {
            return this.mBundle.getStringArrayList(s);
        }
    }
    
    public void putBoolean(final String s, final boolean b) {
        synchronized (this) {
            this.mBundle.putBoolean(s, b);
        }
    }
    
    public void putInteger(final String s, final Integer n) {
        monitorenter(this);
        Label_0021: {
            if (n == null) {
                break Label_0021;
            }
            try {
                this.mBundle.putInt(s, (int)n);
                return;
                this.mBundle.remove(s);
            }
            finally {
                monitorexit(this);
            }
        }
    }
    
    public void putSerializable(final String s, final Serializable s2) {
        synchronized (this) {
            this.mBundle.putSerializable(s, s2);
        }
    }
    
    public void putString(final String s, final String s2) {
        synchronized (this) {
            this.mBundle.putString(s, s2);
        }
    }
    
    public void putStringArray(final String s, final String[] array) {
        synchronized (this) {
            this.mBundle.putStringArray(s, array);
        }
    }
    
    public void putStringArrayList(final String s, final ArrayList<String> list) {
        synchronized (this) {
            this.mBundle.putStringArrayList(s, (ArrayList)list);
        }
    }
    
    public void reset(final Bundle bundle) {
        synchronized (this) {
            this.mBundle.clear();
            this.mBundle.putAll(bundle);
        }
    }
    
    public Bundle toBundle() {
        return new Bundle(this.mBundle);
    }
}

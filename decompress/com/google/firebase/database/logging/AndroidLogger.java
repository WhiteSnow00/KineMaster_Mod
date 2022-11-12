// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.database.logging;

import android.util.Log;
import java.util.List;

public class AndroidLogger extends DefaultLogger
{
    public AndroidLogger(final Level level, final List<String> list) {
        super(level, list);
    }
    
    @Override
    protected String c(final Level level, final String s, final String s2, final long n) {
        return s2;
    }
    
    @Override
    protected void d(final String s, final String s2) {
        Log.d(s, s2);
    }
    
    @Override
    protected void e(final String s, final String s2) {
        Log.e(s, s2);
    }
    
    @Override
    protected void f(final String s, final String s2) {
        Log.i(s, s2);
    }
    
    @Override
    protected void h(final String s, final String s2) {
        Log.w(s, s2);
    }
}

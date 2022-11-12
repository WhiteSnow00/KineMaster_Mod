// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;

public final class c implements a
{
    public static final c a;
    
    static {
        a = new c();
    }
    
    private c() {
    }
    
    @Override
    public final Object a(final JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.c(jsonReader);
    }
}

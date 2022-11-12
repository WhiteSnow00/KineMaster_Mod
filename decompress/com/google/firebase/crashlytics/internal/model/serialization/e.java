// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;

public final class e implements a
{
    public static final e a;
    
    static {
        a = new e();
    }
    
    private e() {
    }
    
    @Override
    public final Object a(final JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.e(jsonReader);
    }
}

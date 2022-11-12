// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;

public final class d implements a
{
    public static final d a;
    
    static {
        a = new d();
    }
    
    private d() {
    }
    
    @Override
    public final Object a(final JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.d(jsonReader);
    }
}

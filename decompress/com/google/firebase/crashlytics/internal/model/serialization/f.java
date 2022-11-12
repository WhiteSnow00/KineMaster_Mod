// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;

public final class f implements a
{
    public static final f a;
    
    static {
        a = new f();
    }
    
    private f() {
    }
    
    @Override
    public final Object a(final JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.f(jsonReader);
    }
}

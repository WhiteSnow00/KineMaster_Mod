// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;

public final class a implements CrashlyticsReportJsonTransform.a
{
    public static final a a;
    
    static {
        a = new a();
    }
    
    private a() {
    }
    
    @Override
    public final Object a(final JsonReader jsonReader) {
        return CrashlyticsReportJsonTransform.a(jsonReader);
    }
}

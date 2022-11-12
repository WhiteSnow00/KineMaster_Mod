// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime;

import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Transport;

final class i<T> implements Transport<T>
{
    private final TransportContext a;
    private final String b;
    private final Encoding c;
    private final Transformer<T, byte[]> d;
    private final j e;
    
    i(final TransportContext a, final String b, final Encoding c, final Transformer<T, byte[]> d, final j e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
    
    public static void c(final Exception ex) {
        d(ex);
    }
    
    private static void d(final Exception ex) {
    }
    
    @Override
    public void a(final Event<T> event, final TransportScheduleCallback transportScheduleCallback) {
        this.e.a(SendRequest.a().e(this.a).c(event).f(this.b).d(this.d).b(this.c).a(), transportScheduleCallback);
    }
    
    @Override
    public void b(final Event<T> event) {
        this.a(event, h.a);
    }
}

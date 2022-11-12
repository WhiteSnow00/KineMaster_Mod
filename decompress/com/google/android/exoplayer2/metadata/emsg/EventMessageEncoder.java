// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.metadata.emsg;

import java.io.IOException;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.ByteArrayOutputStream;

public final class EventMessageEncoder
{
    private final ByteArrayOutputStream a;
    private final DataOutputStream b;
    
    public EventMessageEncoder() {
        final ByteArrayOutputStream a = new ByteArrayOutputStream(512);
        this.a = a;
        this.b = new DataOutputStream(a);
    }
    
    private static void b(final DataOutputStream dataOutputStream, final String s) throws IOException {
        dataOutputStream.writeBytes(s);
        dataOutputStream.writeByte(0);
    }
    
    public byte[] a(final EventMessage eventMessage) {
        this.a.reset();
        try {
            b(this.b, eventMessage.a);
            String b = eventMessage.b;
            if (b == null) {
                b = "";
            }
            b(this.b, b);
            this.b.writeLong(eventMessage.c);
            this.b.writeLong(eventMessage.d);
            this.b.write(eventMessage.e);
            this.b.flush();
            return this.a.toByteArray();
        }
        catch (final IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}

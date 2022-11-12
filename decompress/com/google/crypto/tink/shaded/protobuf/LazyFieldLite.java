// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.shaded.protobuf;

public class LazyFieldLite
{
    private static final ExtensionRegistryLite e;
    private ByteString a;
    private ExtensionRegistryLite b;
    protected volatile MessageLite c;
    private volatile ByteString d;
    
    static {
        e = ExtensionRegistryLite.b();
    }
    
    protected void a(final MessageLite messageLite) {
        if (this.c != null) {
            return;
        }
        synchronized (this) {
            if (this.c != null) {
                return;
            }
            try {
                if (this.a != null) {
                    this.c = (MessageLite)messageLite.getParserForType().b(this.a, this.b);
                    this.d = this.a;
                }
                else {
                    this.c = messageLite;
                    this.d = ByteString.EMPTY;
                }
            }
            catch (final InvalidProtocolBufferException ex) {
                this.c = messageLite;
                this.d = ByteString.EMPTY;
            }
        }
    }
    
    public int b() {
        if (this.d != null) {
            return this.d.size();
        }
        final ByteString a = this.a;
        if (a != null) {
            return a.size();
        }
        if (this.c != null) {
            return this.c.getSerializedSize();
        }
        return 0;
    }
    
    public MessageLite c(final MessageLite messageLite) {
        this.a(messageLite);
        return this.c;
    }
    
    public MessageLite d(final MessageLite c) {
        final MessageLite c2 = this.c;
        this.a = null;
        this.d = null;
        this.c = c;
        return c2;
    }
    
    public ByteString e() {
        if (this.d != null) {
            return this.d;
        }
        final ByteString a = this.a;
        if (a != null) {
            return a;
        }
        synchronized (this) {
            if (this.d != null) {
                return this.d;
            }
            if (this.c == null) {
                this.d = ByteString.EMPTY;
            }
            else {
                this.d = this.c.b();
            }
            return this.d;
        }
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LazyFieldLite)) {
            return false;
        }
        final LazyFieldLite lazyFieldLite = (LazyFieldLite)o;
        final MessageLite c = this.c;
        final MessageLite c2 = lazyFieldLite.c;
        if (c == null && c2 == null) {
            return this.e().equals(lazyFieldLite.e());
        }
        if (c != null && c2 != null) {
            return c.equals(c2);
        }
        if (c != null) {
            return c.equals(lazyFieldLite.c(c.d()));
        }
        return this.c(c2.d()).equals(c2);
    }
    
    @Override
    public int hashCode() {
        return 1;
    }
}

// 
// Decompiled by Procyon v0.6.0
// 

package com.google.crypto.tink.subtle;

import java.io.IOException;
import java.nio.ByteBuffer;
import javax.annotation.concurrent.GuardedBy;
import java.nio.channels.ReadableByteChannel;

public final class RewindableReadableByteChannel implements ReadableByteChannel
{
    @GuardedBy
    final ReadableByteChannel a;
    @GuardedBy
    ByteBuffer b;
    @GuardedBy
    boolean c;
    @GuardedBy
    boolean d;
    
    private void a(final int n) {
        synchronized (this) {
            if (this.b.capacity() < n) {
                final int position = this.b.position();
                final ByteBuffer allocate = ByteBuffer.allocate(Math.max(this.b.capacity() * 2, n));
                this.b.rewind();
                allocate.put(this.b);
                allocate.position(position);
                this.b = allocate;
            }
            this.b.limit(n);
        }
    }
    
    @Override
    public void close() throws IOException {
        synchronized (this) {
            this.c = false;
            this.d = true;
            this.a.close();
        }
    }
    
    @Override
    public boolean isOpen() {
        synchronized (this) {
            return this.a.isOpen();
        }
    }
    
    @Override
    public int read(final ByteBuffer byteBuffer) throws IOException {
        synchronized (this) {
            if (this.d) {
                return this.a.read(byteBuffer);
            }
            final int remaining = byteBuffer.remaining();
            if (remaining == 0) {
                return 0;
            }
            final ByteBuffer b = this.b;
            if (b == null) {
                if (!this.c) {
                    this.d = true;
                    return this.a.read(byteBuffer);
                }
                final ByteBuffer allocate = ByteBuffer.allocate(remaining);
                this.b = allocate;
                final int read = this.a.read(allocate);
                this.b.flip();
                if (read > 0) {
                    byteBuffer.put(this.b);
                }
                return read;
            }
            else {
                if (b.remaining() >= remaining) {
                    final int limit = this.b.limit();
                    final ByteBuffer b2 = this.b;
                    b2.limit(b2.position() + remaining);
                    byteBuffer.put(this.b);
                    this.b.limit(limit);
                    if (!this.c && !this.b.hasRemaining()) {
                        this.b = null;
                        this.d = true;
                    }
                    return remaining;
                }
                final int remaining2 = this.b.remaining();
                final int position = this.b.position();
                final int limit2 = this.b.limit();
                this.a(remaining - remaining2 + limit2);
                this.b.position(limit2);
                final int read2 = this.a.read(this.b);
                this.b.flip();
                this.b.position(position);
                byteBuffer.put(this.b);
                if (remaining2 == 0 && read2 < 0) {
                    return -1;
                }
                final int position2 = this.b.position();
                if (!this.c && !this.b.hasRemaining()) {
                    this.b = null;
                    this.d = true;
                }
                return position2 - position;
            }
        }
    }
}

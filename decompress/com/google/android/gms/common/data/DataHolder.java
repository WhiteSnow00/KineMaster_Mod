// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.common.data;

import java.util.HashMap;
import java.util.ArrayList;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.io.Closeable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@KeepForSdk
@KeepName
@Class
public final class DataHolder extends AbstractSafeParcelable implements Closeable
{
    @KeepForSdk
    public static final Parcelable$Creator<DataHolder> CREATOR;
    private static final Builder p;
    @VersionField
    final int a;
    @Field
    private final String[] b;
    Bundle c;
    @Field
    private final CursorWindow[] d;
    @Field
    private final int e;
    @Field
    private final Bundle f;
    int[] g;
    int h;
    boolean i;
    private boolean j;
    
    static {
        CREATOR = (Parcelable$Creator)new zaf();
        p = (Builder)new a(new String[0], null);
    }
    
    @Constructor
    DataHolder(@Param final int a, @Param final String[] b, @Param final CursorWindow[] d, @Param final int e, @Param final Bundle f) {
        this.i = false;
        this.j = true;
        this.a = a;
        this.b = b;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    private final void Q1(final String s, final int n) {
        final Bundle c = this.c;
        if (c == null || !c.containsKey(s)) {
            throw new IllegalArgumentException("No such column: ".concat(String.valueOf(s)));
        }
        if (this.isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        }
        if (n >= 0 && n < this.h) {
            return;
        }
        throw new CursorIndexOutOfBoundsException(n, this.h);
    }
    
    @KeepForSdk
    public byte[] K1(final String s, final int n, final int n2) {
        this.Q1(s, n);
        return this.d[n2].getBlob(n, this.c.getInt(s));
    }
    
    @KeepForSdk
    public Bundle L1() {
        return this.f;
    }
    
    @KeepForSdk
    public int M1() {
        return this.e;
    }
    
    @KeepForSdk
    public String N1(final String s, final int n, final int n2) {
        this.Q1(s, n);
        return this.d[n2].getString(n, this.c.getInt(s));
    }
    
    @KeepForSdk
    public int O1(int n) {
        int n2 = 0;
        Preconditions.o(n >= 0 && n < this.h);
        int length;
        int n3;
        while (true) {
            final int[] g = this.g;
            length = g.length;
            n3 = n2;
            if (n2 >= length) {
                break;
            }
            if (n < g[n2]) {
                n3 = n2 - 1;
                break;
            }
            ++n2;
        }
        if ((n = n3) == length) {
            n = n3 - 1;
        }
        return n;
    }
    
    public final void P1() {
        this.c = new Bundle();
        int n = 0;
        int n2 = 0;
        while (true) {
            final String[] b = this.b;
            if (n2 >= b.length) {
                break;
            }
            this.c.putInt(b[n2], n2);
            ++n2;
        }
        this.g = new int[this.d.length];
        int h = 0;
        while (true) {
            final CursorWindow[] d = this.d;
            if (n >= d.length) {
                break;
            }
            this.g[n] = h;
            h += this.d[n].getNumRows() - (h - d[n].getStartPosition());
            ++n;
        }
        this.h = h;
    }
    
    @KeepForSdk
    @Override
    public void close() {
        synchronized (this) {
            if (!this.i) {
                this.i = true;
                int n = 0;
                while (true) {
                    final CursorWindow[] d = this.d;
                    if (n >= d.length) {
                        break;
                    }
                    d[n].close();
                    ++n;
                }
            }
        }
    }
    
    @Override
    protected final void finalize() throws Throwable {
        try {
            if (this.j && this.d.length > 0 && !this.isClosed()) {
                this.close();
                final String string = this.toString();
                final StringBuilder sb = new StringBuilder();
                sb.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
                sb.append(string);
                sb.append(")");
                Log.e("DataBuffer", sb.toString());
            }
        }
        finally {
            super.finalize();
        }
    }
    
    @KeepForSdk
    public int getCount() {
        return this.h;
    }
    
    @KeepForSdk
    public boolean isClosed() {
        synchronized (this) {
            return this.i;
        }
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.C(parcel, 1, this.b, false);
        SafeParcelWriter.E(parcel, 2, this.d, n, false);
        SafeParcelWriter.s(parcel, 3, this.M1());
        SafeParcelWriter.j(parcel, 4, this.L1(), false);
        SafeParcelWriter.s(parcel, 1000, this.a);
        SafeParcelWriter.b(parcel, a);
        if ((n & 0x1) != 0x0) {
            this.close();
        }
    }
    
    @KeepForSdk
    public static class Builder
    {
        private final String[] a;
        private final ArrayList b;
        private final HashMap c;
        
        Builder(final String[] array, final String s, final zac zac) {
            this.a = Preconditions.k(array);
            this.b = new ArrayList();
            this.c = new HashMap();
        }
    }
}

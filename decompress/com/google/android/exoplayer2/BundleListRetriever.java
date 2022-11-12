// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2;

import java.util.AbstractCollection;
import com.google.common.collect.ImmutableList$Builder;
import android.os.RemoteException;
import com.google.android.exoplayer2.util.Assertions;
import android.os.Parcel;
import java.util.Collection;
import java.util.List;
import android.os.IBinder;
import com.google.android.exoplayer2.util.Util;
import android.os.Bundle;
import com.google.common.collect.ImmutableList;
import android.os.Binder;

public final class BundleListRetriever extends Binder
{
    private static final int b;
    private final ImmutableList<Bundle> a;
    
    static {
        int suggestedMaxIpcSizeBytes;
        if (Util.a >= 30) {
            suggestedMaxIpcSizeBytes = IBinder.getSuggestedMaxIpcSizeBytes();
        }
        else {
            suggestedMaxIpcSizeBytes = 65536;
        }
        b = suggestedMaxIpcSizeBytes;
    }
    
    public BundleListRetriever(final List<Bundle> list) {
        this.a = (ImmutableList<Bundle>)ImmutableList.copyOf((Collection)list);
    }
    
    public static ImmutableList<Bundle> a(final IBinder binder) {
        final ImmutableList$Builder builder = ImmutableList.builder();
        int n = 0;
        int i = 1;
        while (i != 0) {
            final Parcel obtain = Parcel.obtain();
            final Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInt(n);
                try {
                    binder.transact(1, obtain, obtain2, 0);
                    while (true) {
                        i = obtain2.readInt();
                        if (i != 1) {
                            break;
                        }
                        builder.i((Object)Assertions.e(obtain2.readBundle()));
                        ++n;
                    }
                }
                catch (final RemoteException builder) {
                    throw new RuntimeException((Throwable)builder);
                }
            }
            finally {
                obtain2.recycle();
                obtain.recycle();
            }
            break;
        }
        return (ImmutableList<Bundle>)builder.l();
    }
    
    protected boolean onTransact(int int1, final Parcel parcel, final Parcel parcel2, int n) throws RemoteException {
        if (int1 != 1) {
            return super.onTransact(int1, parcel, parcel2, n);
        }
        n = 0;
        if (parcel2 == null) {
            return false;
        }
        int size;
        for (size = ((AbstractCollection)this.a).size(), int1 = parcel.readInt(); int1 < size && parcel2.dataSize() < BundleListRetriever.b; ++int1) {
            parcel2.writeInt(1);
            parcel2.writeBundle((Bundle)((List<Bundle>)this.a).get(int1));
        }
        if (int1 < size) {
            n = 2;
        }
        parcel2.writeInt(n);
        return true;
    }
}

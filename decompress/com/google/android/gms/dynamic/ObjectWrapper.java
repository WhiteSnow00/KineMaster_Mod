// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.gms.dynamic;

import android.os.IInterface;
import java.lang.reflect.Field;
import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.RetainForClient;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
@RetainForClient
public final class ObjectWrapper<T> extends Stub
{
    private final Object a;
    
    private ObjectWrapper(final Object a) {
        this.a = a;
    }
    
    @KeepForSdk
    public static <T> T p1(final IObjectWrapper objectWrapper) {
        if (objectWrapper instanceof ObjectWrapper) {
            return (T)((ObjectWrapper)objectWrapper).a;
        }
        final IBinder binder = ((IInterface)objectWrapper).asBinder();
        final Field[] declaredFields = binder.getClass().getDeclaredFields();
        final int length = declaredFields.length;
        Field field = null;
        int i = 0;
        int n = 0;
        while (i < length) {
            final Field field2 = declaredFields[i];
            int n2 = n;
            if (!field2.isSynthetic()) {
                n2 = n + 1;
                field = field2;
            }
            ++i;
            n = n2;
        }
        if (n == 1) {
            Preconditions.k(field);
            if (!field.isAccessible()) {
                field.setAccessible(true);
                try {
                    return (T)field.get(binder);
                }
                catch (final IllegalAccessException ex) {
                    throw new IllegalArgumentException("Could not access the field in remoteBinder.", ex);
                }
                catch (final NullPointerException ex2) {
                    throw new IllegalArgumentException("Binder object is null.", ex2);
                }
            }
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        final int length2 = declaredFields.length;
        final StringBuilder sb = new StringBuilder();
        sb.append("Unexpected number of IObjectWrapper declared fields: ");
        sb.append(length2);
        throw new IllegalArgumentException(sb.toString());
    }
    
    @KeepForSdk
    public static <T> IObjectWrapper q1(final T t) {
        return new ObjectWrapper<Object>(t);
    }
}

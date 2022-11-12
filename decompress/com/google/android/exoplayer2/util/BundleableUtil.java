// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.util;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collection;
import android.util.SparseArray;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.collect.ImmutableList;
import java.util.List;
import com.google.android.exoplayer2.Bundleable;
import android.os.Bundle;

public final class BundleableUtil
{
    private BundleableUtil() {
    }
    
    public static void a(final Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader((ClassLoader)Util.j(BundleableUtil.class.getClassLoader()));
        }
    }
    
    public static <T extends Bundleable> ImmutableList<T> b(final Bundleable.Creator<T> creator, final List<Bundle> list) {
        final ImmutableList$Builder builder = ImmutableList.builder();
        for (int i = 0; i < list.size(); ++i) {
            builder.i((Object)creator.a(Assertions.e(list.get(i))));
        }
        return (ImmutableList<T>)builder.l();
    }
    
    public static <T extends Bundleable> SparseArray<T> c(final Bundleable.Creator<T> creator, final SparseArray<Bundle> sparseArray) {
        final SparseArray sparseArray2 = new SparseArray(sparseArray.size());
        for (int i = 0; i < sparseArray.size(); ++i) {
            sparseArray2.put(sparseArray.keyAt(i), (Object)creator.a((Bundle)sparseArray.valueAt(i)));
        }
        return (SparseArray<T>)sparseArray2;
    }
    
    public static <T extends Bundleable> ArrayList<Bundle> d(final Collection<T> collection) {
        final ArrayList list = new ArrayList(collection.size());
        final Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            list.add(((Bundleable)iterator.next()).toBundle());
        }
        return list;
    }
    
    public static <T extends Bundleable> SparseArray<Bundle> e(final SparseArray<T> sparseArray) {
        final SparseArray sparseArray2 = new SparseArray(sparseArray.size());
        for (int i = 0; i < sparseArray.size(); ++i) {
            sparseArray2.put(sparseArray.keyAt(i), (Object)((Bundleable)sparseArray.valueAt(i)).toBundle());
        }
        return (SparseArray<Bundle>)sparseArray2;
    }
}

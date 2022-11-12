// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime.util;

import java.util.Iterator;
import java.util.HashMap;
import com.google.android.datatransport.Priority;
import android.util.SparseArray;

public final class PriorityMapping
{
    private static SparseArray<Priority> a;
    private static HashMap<Priority, Integer> b;
    
    static {
        PriorityMapping.a = (SparseArray<Priority>)new SparseArray();
        (PriorityMapping.b = new HashMap<Priority, Integer>()).put(Priority.DEFAULT, 0);
        PriorityMapping.b.put(Priority.VERY_LOW, 1);
        PriorityMapping.b.put(Priority.HIGHEST, 2);
        for (final Priority priority : PriorityMapping.b.keySet()) {
            PriorityMapping.a.append((int)PriorityMapping.b.get(priority), (Object)priority);
        }
    }
    
    public static int a(final Priority priority) {
        final Integer n = PriorityMapping.b.get(priority);
        if (n != null) {
            return n;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("PriorityMapping is missing known Priority value ");
        sb.append(priority);
        throw new IllegalStateException(sb.toString());
    }
    
    public static Priority b(final int n) {
        final Priority priority = (Priority)PriorityMapping.a.get(n);
        if (priority != null) {
            return priority;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Unknown Priority for value ");
        sb.append(n);
        throw new IllegalArgumentException(sb.toString());
    }
}

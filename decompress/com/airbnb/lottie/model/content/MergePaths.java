// 
// Decompiled by Procyon v0.6.0
// 

package com.airbnb.lottie.model.content;

import q1.l;
import y1.d;
import q1.c;
import com.airbnb.lottie.model.layer.a;
import com.airbnb.lottie.f;
import v1.b;

public class MergePaths implements b
{
    private final String a;
    private final MergePathsMode b;
    private final boolean c;
    
    public MergePaths(final String a, final MergePathsMode b, final boolean c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public c a(final f f, final a a) {
        if (!f.n()) {
            d.c("Animation contains merge paths but they are disabled.");
            return null;
        }
        return new l(this);
    }
    
    public MergePathsMode b() {
        return this.b;
    }
    
    public String c() {
        return this.a;
    }
    
    public boolean d() {
        return this.c;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("MergePaths{mode=");
        sb.append(this.b);
        sb.append('}');
        return sb.toString();
    }
    
    public enum MergePathsMode
    {
        private static final MergePathsMode[] $VALUES;
        
        ADD, 
        EXCLUDE_INTERSECTIONS, 
        INTERSECT, 
        MERGE, 
        SUBTRACT;
        
        public static MergePathsMode forId(final int n) {
            if (n == 1) {
                return MergePathsMode.MERGE;
            }
            if (n == 2) {
                return MergePathsMode.ADD;
            }
            if (n == 3) {
                return MergePathsMode.SUBTRACT;
            }
            if (n == 4) {
                return MergePathsMode.INTERSECT;
            }
            if (n != 5) {
                return MergePathsMode.MERGE;
            }
            return MergePathsMode.EXCLUDE_INTERSECTIONS;
        }
    }
}

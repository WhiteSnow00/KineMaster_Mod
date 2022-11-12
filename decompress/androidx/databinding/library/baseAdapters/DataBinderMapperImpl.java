// 
// Decompiled by Procyon v0.6.0
// 

package androidx.databinding.library.baseAdapters;

import androidx.databinding.ViewDataBinding;
import android.view.View;
import androidx.databinding.f;
import java.util.ArrayList;
import java.util.List;
import android.util.SparseIntArray;
import androidx.databinding.e;

public class DataBinderMapperImpl extends e
{
    private static final SparseIntArray a;
    
    static {
        a = new SparseIntArray(0);
    }
    
    @Override
    public List<e> a() {
        return new ArrayList<e>(0);
    }
    
    @Override
    public ViewDataBinding b(final f f, final View view, final int n) {
        if (DataBinderMapperImpl.a.get(n) > 0 && view.getTag() == null) {
            throw new RuntimeException("view must have a tag");
        }
        return null;
    }
    
    @Override
    public ViewDataBinding c(final f f, final View[] array, final int n) {
        if (array != null) {
            if (array.length != 0) {
                if (DataBinderMapperImpl.a.get(n) > 0) {
                    if (array[0].getTag() == null) {
                        throw new RuntimeException("view must have a tag");
                    }
                }
            }
        }
        return null;
    }
}

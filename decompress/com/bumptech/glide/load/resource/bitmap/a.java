// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.resource.bitmap;

import java.io.IOException;
import com.bumptech.glide.load.engine.s;
import c2.e;
import v2.k;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import c2.f;

public class a<DataType> implements f<DataType, BitmapDrawable>
{
    private final f<DataType, Bitmap> a;
    private final Resources b;
    
    public a(final Resources resources, final f<DataType, Bitmap> f) {
        this.b = k.d(resources);
        this.a = k.d(f);
    }
    
    @Override
    public s<BitmapDrawable> a(final DataType dataType, final int n, final int n2, final e e) throws IOException {
        return t.e(this.b, this.a.a(dataType, n, n2, e));
    }
    
    @Override
    public boolean b(final DataType dataType, final e e) throws IOException {
        return this.a.b(dataType, e);
    }
}

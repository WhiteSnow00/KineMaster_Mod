// 
// Decompiled by Procyon v0.6.0
// 

package h2;

import java.io.InputStream;
import android.os.ParcelFileDescriptor;
import android.content.res.AssetFileDescriptor;
import c2.e;
import android.content.res.Resources$NotFoundException;
import android.util.Log;
import android.content.res.Resources;
import android.net.Uri;

public class s<Data> implements n<Integer, Data>
{
    private final n<Uri, Data> a;
    private final Resources b;
    
    public s(final Resources b, final n<Uri, Data> a) {
        this.b = b;
        this.a = a;
    }
    
    private Uri d(final Integer n) {
        try {
            final StringBuilder sb = new StringBuilder();
            sb.append("android.resource://");
            sb.append(this.b.getResourcePackageName((int)n));
            sb.append('/');
            sb.append(this.b.getResourceTypeName((int)n));
            sb.append('/');
            sb.append(this.b.getResourceEntryName((int)n));
            return Uri.parse(sb.toString());
        }
        catch (final Resources$NotFoundException ex) {
            if (Log.isLoggable("ResourceLoader", 5)) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Received invalid resource id: ");
                sb2.append(n);
                Log.w("ResourceLoader", sb2.toString(), (Throwable)ex);
            }
            return null;
        }
    }
    
    @Override
    public /* bridge */ boolean a(final Object o) {
        return this.e((Integer)o);
    }
    
    @Override
    public /* bridge */ n.a b(final Object o, final int n, final int n2, final e e) {
        return this.c((Integer)o, n, n2, e);
    }
    
    public n.a<Data> c(final Integer n, final int n2, final int n3, final e e) {
        final Uri d = this.d(n);
        Object b;
        if (d == null) {
            b = null;
        }
        else {
            b = this.a.b(d, n2, n3, e);
        }
        return (n.a<Data>)b;
    }
    
    public boolean e(final Integer n) {
        return true;
    }
    
    public static final class a implements o<Integer, AssetFileDescriptor>
    {
        private final Resources a;
        
        public a(final Resources a) {
            this.a = a;
        }
        
        @Override
        public n<Integer, AssetFileDescriptor> b(final r r) {
            return new s<AssetFileDescriptor>(this.a, (n<Uri, AssetFileDescriptor>)r.d(Uri.class, (Class<Data>)AssetFileDescriptor.class));
        }
    }
    
    public static class b implements o<Integer, ParcelFileDescriptor>
    {
        private final Resources a;
        
        public b(final Resources a) {
            this.a = a;
        }
        
        @Override
        public n<Integer, ParcelFileDescriptor> b(final r r) {
            return new s<ParcelFileDescriptor>(this.a, (n<Uri, ParcelFileDescriptor>)r.d(Uri.class, (Class<Data>)ParcelFileDescriptor.class));
        }
    }
    
    public static class c implements o<Integer, InputStream>
    {
        private final Resources a;
        
        public c(final Resources a) {
            this.a = a;
        }
        
        @Override
        public n<Integer, InputStream> b(final r r) {
            return new s<InputStream>(this.a, (n<Uri, InputStream>)r.d(Uri.class, (Class<Data>)InputStream.class));
        }
    }
    
    public static class d implements o<Integer, Uri>
    {
        private final Resources a;
        
        public d(final Resources a) {
            this.a = a;
        }
        
        @Override
        public n<Integer, Uri> b(final r r) {
            return new s<Uri>(this.a, (n<Uri, Uri>)v.c());
        }
    }
}

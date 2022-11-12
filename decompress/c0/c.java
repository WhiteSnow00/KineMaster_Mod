// 
// Decompiled by Procyon v0.6.0
// 

package c0;

import android.database.Cursor;
import android.content.ContentResolver;
import android.util.Log;
import java.util.ArrayList;
import android.provider.DocumentsContract;
import android.net.Uri;
import android.content.Context;

class c extends a
{
    private Context b;
    private Uri c;
    
    c(final a a, final Context b, final Uri c) {
        super(a);
        this.b = b;
        this.c = c;
    }
    
    private static void n(final AutoCloseable autoCloseable) {
        if (autoCloseable == null) {
            goto Label_0016;
        }
        try {
            autoCloseable.close();
            goto Label_0016;
        }
        catch (final RuntimeException ex) {
            throw ex;
        }
        catch (final Exception ex2) {
            goto Label_0016;
        }
    }
    
    private static Uri o(final Context context, final Uri uri, final String s, final String s2) {
        try {
            return DocumentsContract.createDocument(context.getContentResolver(), uri, s, s2);
        }
        catch (final Exception ex) {
            return null;
        }
    }
    
    @Override
    public boolean a() {
        return c0.b.a(this.b, this.c);
    }
    
    @Override
    public a b(final String s, final String s2) {
        final Uri o = o(this.b, this.c, s, s2);
        c c;
        if (o != null) {
            c = new c(this, this.b, o);
        }
        else {
            c = null;
        }
        return c;
    }
    
    @Override
    public boolean c() {
        try {
            return DocumentsContract.deleteDocument(this.b.getContentResolver(), this.c);
        }
        catch (final Exception ex) {
            return false;
        }
    }
    
    @Override
    public boolean d() {
        return c0.b.c(this.b, this.c);
    }
    
    @Override
    public String g() {
        return c0.b.d(this.b, this.c);
    }
    
    @Override
    public Uri i() {
        return this.c;
    }
    
    @Override
    public boolean j() {
        return c0.b.f(this.b, this.c);
    }
    
    @Override
    public boolean k() {
        return c0.b.g(this.b, this.c);
    }
    
    @Override
    public long l() {
        return c0.b.h(this.b, this.c);
    }
    
    @Override
    public a[] m() {
        final ContentResolver contentResolver = this.b.getContentResolver();
        final Uri c = this.c;
        final Uri buildChildDocumentsUriUsingTree = DocumentsContract.buildChildDocumentsUriUsingTree(c, DocumentsContract.getDocumentId(c));
        final ArrayList list = new ArrayList();
        int i = 0;
        Object o = null;
        while (true) {
            try {
                try {
                    final Cursor query = contentResolver.query(buildChildDocumentsUriUsingTree, new String[] { "document_id" }, (String)null, (String[])null, (String)null);
                    AutoCloseable autoCloseable;
                    while (true) {
                        autoCloseable = (AutoCloseable)query;
                        o = query;
                        if (!query.moveToNext()) {
                            break;
                        }
                        o = query;
                        final String string = query.getString(0);
                        o = query;
                        list.add(DocumentsContract.buildDocumentUriUsingTree(this.c, string));
                    }
                    n(autoCloseable);
                }
                finally {}
            }
            catch (final Exception ex) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Failed query: ");
                sb.append(ex);
                final AutoCloseable autoCloseable2;
                o = autoCloseable2;
                Log.w("DocumentFile", sb.toString());
                final AutoCloseable autoCloseable = autoCloseable2;
                continue;
            }
            break;
        }
        final Uri[] array = list.toArray(new Uri[list.size()]);
        final a[] array2 = new a[array.length];
        while (i < array.length) {
            array2[i] = new c(this, this.b, array[i]);
            ++i;
        }
        return array2;
        n((AutoCloseable)o);
    }
}

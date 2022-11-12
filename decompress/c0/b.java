// 
// Decompiled by Procyon v0.6.0
// 

package c0;

import android.database.Cursor;
import android.content.ContentResolver;
import android.util.Log;
import android.text.TextUtils;
import android.net.Uri;
import android.content.Context;

class b
{
    public static boolean a(final Context context, final Uri uri) {
        if (context.checkCallingOrSelfUriPermission(uri, 2) != 0) {
            return false;
        }
        final String e = e(context, uri);
        final int i = i(context, uri, "flags", 0);
        return !TextUtils.isEmpty((CharSequence)e) && ((i & 0x4) != 0x0 || ("vnd.android.document/directory".equals(e) && (i & 0x8) != 0x0) || (!TextUtils.isEmpty((CharSequence)e) && (i & 0x2) != 0x0));
    }
    
    private static void b(final AutoCloseable autoCloseable) {
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
    
    public static boolean c(Context query, final Uri uri) {
        final ContentResolver contentResolver = query.getContentResolver();
        boolean b = false;
        Object o = null;
        query = null;
        try {
            try {
                final Context context = (Context)(o = (query = (Context)contentResolver.query(uri, new String[] { "document_id" }, (String)null, (String[])null, (String)null)));
                if (((Cursor)context).getCount() > 0) {
                    b = true;
                }
                b((AutoCloseable)context);
                return b;
            }
            finally {}
        }
        catch (final Exception ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Failed query: ");
            sb.append(ex);
            Log.w("DocumentFile", sb.toString());
            b((AutoCloseable)o);
            return false;
        }
        b((AutoCloseable)query);
    }
    
    public static String d(final Context context, final Uri uri) {
        return k(context, uri, "_display_name", null);
    }
    
    private static String e(final Context context, final Uri uri) {
        return k(context, uri, "mime_type", null);
    }
    
    public static boolean f(final Context context, final Uri uri) {
        return "vnd.android.document/directory".equals(e(context, uri));
    }
    
    public static boolean g(final Context context, final Uri uri) {
        final String e = e(context, uri);
        return !"vnd.android.document/directory".equals(e) && !TextUtils.isEmpty((CharSequence)e);
    }
    
    public static long h(final Context context, final Uri uri) {
        return j(context, uri, "_size", 0L);
    }
    
    private static int i(final Context context, final Uri uri, final String s, final int n) {
        return (int)j(context, uri, s, n);
    }
    
    private static long j(Context query, final Uri uri, final String s, final long n) {
        final ContentResolver contentResolver = query.getContentResolver();
        Object o = null;
        query = null;
        try {
            try {
                final Object o2 = o = (query = (Context)contentResolver.query(uri, new String[] { s }, (String)null, (String[])null, (String)null));
                if (((Cursor)o2).moveToFirst()) {
                    query = (Context)o2;
                    o = o2;
                    if (!((Cursor)o2).isNull(0)) {
                        query = (Context)o2;
                        o = o2;
                        final long long1 = ((Cursor)o2).getLong(0);
                        b((AutoCloseable)o2);
                        return long1;
                    }
                }
                b((AutoCloseable)o2);
                return n;
            }
            finally {}
        }
        catch (final Exception ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Failed query: ");
            sb.append(ex);
            Log.w("DocumentFile", sb.toString());
            b((AutoCloseable)o);
            return n;
        }
        b((AutoCloseable)query);
    }
    
    private static String k(Context query, final Uri uri, String string, final String s) {
        final ContentResolver contentResolver = query.getContentResolver();
        Object o = null;
        query = null;
        try {
            try {
                final Object o2 = o = (query = (Context)contentResolver.query(uri, new String[] { string }, (String)null, (String[])null, (String)null));
                if (((Cursor)o2).moveToFirst()) {
                    query = (Context)o2;
                    o = o2;
                    if (!((Cursor)o2).isNull(0)) {
                        query = (Context)o2;
                        o = o2;
                        string = ((Cursor)o2).getString(0);
                        b((AutoCloseable)o2);
                        return string;
                    }
                }
                b((AutoCloseable)o2);
                return s;
            }
            finally {}
        }
        catch (final Exception ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Failed query: ");
            sb.append(ex);
            Log.w("DocumentFile", sb.toString());
            b((AutoCloseable)o);
            return s;
        }
        b((AutoCloseable)query);
    }
}

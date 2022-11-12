// 
// Decompiled by Procyon v0.6.0
// 

package f1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.io.File;
import android.content.Context;

public class h
{
    private static final String a;
    private static final String[] b;
    
    static {
        a = e1.h.f("WrkDbPathHelper");
        b = new String[] { "-journal", "-shm", "-wal" };
    }
    
    public static File a(final Context context) {
        return c(context, "androidx.work.workdb");
    }
    
    public static File b(final Context context) {
        return context.getDatabasePath("androidx.work.workdb");
    }
    
    private static File c(final Context context, final String s) {
        return new File(context.getNoBackupFilesDir(), s);
    }
    
    public static String d() {
        return "androidx.work.workdb";
    }
    
    public static void e(final Context context) {
        if (b(context).exists()) {
            e1.h.c().a(h.a, "Migrating WorkDatabase to the no-backup directory", new Throwable[0]);
            final Map<File, File> f = f(context);
            for (final File file : f.keySet()) {
                final File file2 = f.get(file);
                if (file.exists() && file2 != null) {
                    if (file2.exists()) {
                        e1.h.c().h(h.a, String.format("Over-writing contents of %s", file2), new Throwable[0]);
                    }
                    String s;
                    if (file.renameTo(file2)) {
                        s = String.format("Migrated %s to %s", file, file2);
                    }
                    else {
                        s = String.format("Renaming %s to %s failed", file, file2);
                    }
                    e1.h.c().a(h.a, s, new Throwable[0]);
                }
            }
        }
    }
    
    public static Map<File, File> f(final Context context) {
        final HashMap hashMap = new HashMap();
        final File b = b(context);
        final File a = a(context);
        hashMap.put(b, a);
        for (final String s : h.b) {
            final StringBuilder sb = new StringBuilder();
            sb.append(b.getPath());
            sb.append(s);
            final File file = new File(sb.toString());
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(a.getPath());
            sb2.append(s);
            hashMap.put(file, new File(sb2.toString()));
        }
        return hashMap;
    }
}

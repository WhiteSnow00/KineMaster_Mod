// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.persistence;

import java.io.FilenameFilter;
import android.os.Build$VERSION;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import com.google.firebase.crashlytics.internal.Logger;
import android.app.Application;
import android.content.Context;
import java.io.File;

public class FileStore
{
    private final File a;
    private final File b;
    private final File c;
    private final File d;
    private final File e;
    private final File f;
    
    public FileStore(final Context context) {
        final File filesDir = context.getFilesDir();
        this.a = filesDir;
        String string;
        if (v()) {
            final StringBuilder sb = new StringBuilder();
            sb.append(".com.google.firebase.crashlytics.files.v2");
            sb.append(File.pathSeparator);
            sb.append(u(Application.getProcessName()));
            string = sb.toString();
        }
        else {
            string = ".com.google.firebase.crashlytics.files.v1";
        }
        final File q = q(new File(filesDir, string));
        this.b = q;
        this.c = q(new File(q, "open-sessions"));
        this.d = q(new File(q, "reports"));
        this.e = q(new File(q, "priority-reports"));
        this.f = q(new File(q, "native-reports"));
    }
    
    private void a(final File file) {
        if (file.exists() && s(file)) {
            final Logger f = Logger.f();
            final StringBuilder sb = new StringBuilder();
            sb.append("Deleted previous Crashlytics file system: ");
            sb.append(file.getPath());
            f.b(sb.toString());
        }
    }
    
    private File n(final String s) {
        return r(new File(this.c, s));
    }
    
    private static File q(final File file) {
        synchronized (FileStore.class) {
            if (file.exists()) {
                if (file.isDirectory()) {
                    return file;
                }
                final Logger f = Logger.f();
                final StringBuilder sb = new StringBuilder();
                sb.append("Unexpected non-directory file: ");
                sb.append(file);
                sb.append("; deleting file and creating new directory.");
                f.b(sb.toString());
                file.delete();
            }
            if (!file.mkdirs()) {
                final Logger f2 = Logger.f();
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Could not create Crashlytics-specific directory: ");
                sb2.append(file);
                f2.d(sb2.toString());
            }
            return file;
        }
    }
    
    private static File r(final File file) {
        file.mkdirs();
        return file;
    }
    
    static boolean s(final File file) {
        final File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (int length = listFiles.length, i = 0; i < length; ++i) {
                s(listFiles[i]);
            }
        }
        return file.delete();
    }
    
    private static <T> List<T> t(final T[] array) {
        Object o;
        if (array == null) {
            o = Collections.emptyList();
        }
        else {
            o = Arrays.asList(array);
        }
        return (List<T>)o;
    }
    
    static String u(final String s) {
        return s.replaceAll("[^a-zA-Z0-9.]", "_");
    }
    
    private static boolean v() {
        return Build$VERSION.SDK_INT >= 28;
    }
    
    public void b() {
        this.a(new File(this.a, ".com.google.firebase.crashlytics"));
        this.a(new File(this.a, ".com.google.firebase.crashlytics-ndk"));
        if (v()) {
            this.a(new File(this.a, ".com.google.firebase.crashlytics.files.v1"));
        }
    }
    
    public boolean c(final String s) {
        return s(new File(this.c, s));
    }
    
    public List<String> d() {
        return t(this.c.list());
    }
    
    public File e(final String s) {
        return new File(this.b, s);
    }
    
    public List<File> f(final FilenameFilter filenameFilter) {
        return t(this.b.listFiles(filenameFilter));
    }
    
    public File g(final String s) {
        return new File(this.f, s);
    }
    
    public List<File> h() {
        return t(this.f.listFiles());
    }
    
    public File i(final String s) {
        return r(new File(this.n(s), "native"));
    }
    
    public File j(final String s) {
        return new File(this.e, s);
    }
    
    public List<File> k() {
        return t(this.e.listFiles());
    }
    
    public File l(final String s) {
        return new File(this.d, s);
    }
    
    public List<File> m() {
        return t(this.d.listFiles());
    }
    
    public File o(final String s, final String s2) {
        return new File(this.n(s), s2);
    }
    
    public List<File> p(final String s, final FilenameFilter filenameFilter) {
        return t(this.n(s).listFiles(filenameFilter));
    }
}

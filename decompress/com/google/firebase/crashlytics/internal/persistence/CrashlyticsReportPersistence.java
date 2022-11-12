// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.persistence;

import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import java.util.TreeSet;
import java.util.Collection;
import java.util.Locale;
import java.util.SortedSet;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import m4.d;
import m4.a;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import java.util.Iterator;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ByteArrayOutputStream;
import m4.b;
import m4.c;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import java.util.concurrent.atomic.AtomicInteger;
import java.io.FilenameFilter;
import java.io.File;
import java.util.Comparator;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import java.nio.charset.Charset;

public class CrashlyticsReportPersistence
{
    private static final Charset d;
    private static final int e;
    private static final CrashlyticsReportJsonTransform f;
    private static final Comparator<? super File> g;
    private static final FilenameFilter h;
    private final AtomicInteger a;
    private final FileStore b;
    private final SettingsProvider c;
    
    static {
        d = Charset.forName("UTF-8");
        e = 15;
        f = new CrashlyticsReportJsonTransform();
        g = (Comparator)c.a;
        h = (FilenameFilter)b.a;
    }
    
    public CrashlyticsReportPersistence(final FileStore b, final SettingsProvider c) {
        this.a = new AtomicInteger(0);
        this.b = b;
        this.c = c;
    }
    
    private static String A(File file) throws IOException {
        final byte[] array = new byte[8192];
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        file = (File)new FileInputStream(file);
        try {
            while (true) {
                final int read = ((FileInputStream)file).read(array);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(array, 0, read);
            }
            final String s = new String(byteArrayOutputStream.toByteArray(), CrashlyticsReportPersistence.d);
            ((FileInputStream)file).close();
            return s;
        }
        finally {
            try {
                ((FileInputStream)file).close();
            }
            finally {
                final Throwable t;
                final Throwable t2;
                t.addSuppressed(t2);
            }
        }
    }
    
    private void B(final File file, final CrashlyticsReport.FilesPayload filesPayload, final String s) {
        try {
            final CrashlyticsReportJsonTransform f = CrashlyticsReportPersistence.f;
            F(this.b.g(s), f.E(f.D(A(file)).m(filesPayload)));
        }
        catch (final IOException ex) {
            final Logger f2 = Logger.f();
            final StringBuilder sb = new StringBuilder();
            sb.append("Could not synthesize final native report file for ");
            sb.append(file);
            f2.l(sb.toString(), ex);
        }
    }
    
    private void C(final String s, final long n) {
        final List<File> p2 = this.b.p(s, CrashlyticsReportPersistence.h);
        if (p2.isEmpty()) {
            final Logger f = Logger.f();
            final StringBuilder sb = new StringBuilder();
            sb.append("Session ");
            sb.append(s);
            sb.append(" has no events.");
            f.i(sb.toString());
            return;
        }
        Collections.sort((List<Comparable>)p2);
        final ArrayList list = new ArrayList();
        final Iterator<File> iterator = p2.iterator();
        boolean b = false;
    Label_0094:
        while (true) {
            b = false;
            while (iterator.hasNext()) {
                final File file = iterator.next();
                try {
                    list.add(CrashlyticsReportPersistence.f.g(A(file)));
                    if (!b && !s(file.getName())) {
                        continue Label_0094;
                    }
                    b = true;
                }
                catch (final IOException ex) {
                    final Logger f2 = Logger.f();
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Could not add event to report for ");
                    sb2.append(file);
                    f2.l(sb2.toString(), ex);
                }
            }
            break;
        }
        if (list.isEmpty()) {
            final Logger f3 = Logger.f();
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Could not parse event files for session ");
            sb3.append(s);
            f3.k(sb3.toString());
            return;
        }
        this.D(this.b.o(s, "report"), list, n, b, UserMetadata.d(s, this.b));
    }
    
    private void D(final File file, final List<CrashlyticsReport.Session.Event> list, final long n, final boolean b, final String s) {
        try {
            final CrashlyticsReportJsonTransform f = CrashlyticsReportPersistence.f;
            final CrashlyticsReport l = f.D(A(file)).n(n, b, s).l(ImmutableList.a(list));
            final CrashlyticsReport.Session j = l.j();
            if (j == null) {
                return;
            }
            File file2;
            if (b) {
                file2 = this.b.j(j.h());
            }
            else {
                file2 = this.b.l(j.h());
            }
            F(file2, f.E(l));
        }
        catch (final IOException ex) {
            final Logger f2 = Logger.f();
            final StringBuilder sb = new StringBuilder();
            sb.append("Could not synthesize final report file for ");
            sb.append(file);
            f2.l(sb.toString(), ex);
        }
    }
    
    private int E(final String s, final int n) {
        final List<File> p2 = this.b.p(s, (FilenameFilter)m4.a.a);
        Collections.sort((List<Object>)p2, (Comparator<? super Object>)m4.d.a);
        return f(p2, n);
    }
    
    private static void F(final File file, final String s) throws IOException {
        final OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), CrashlyticsReportPersistence.d);
        try {
            outputStreamWriter.write(s);
            outputStreamWriter.close();
        }
        finally {
            try {
                outputStreamWriter.close();
            }
            finally {
                final Throwable t;
                ((Throwable)file).addSuppressed(t);
            }
        }
    }
    
    private static void G(final File file, final String s, final long n) throws IOException {
        final OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), CrashlyticsReportPersistence.d);
        try {
            outputStreamWriter.write(s);
            file.setLastModified(h(n));
            outputStreamWriter.close();
        }
        finally {
            try {
                outputStreamWriter.close();
            }
            finally {
                final Throwable t;
                ((Throwable)file).addSuppressed(t);
            }
        }
    }
    
    public static int a(final File file, final File file2) {
        return u(file, file2);
    }
    
    public static boolean b(final File file, final String s) {
        return t(file, s);
    }
    
    public static int c(final File file, final File file2) {
        return x(file, file2);
    }
    
    public static boolean d(final File file, final String s) {
        return v(file, s);
    }
    
    private SortedSet<String> e(String s) {
        this.b.b();
        final SortedSet<String> p = this.p();
        if (s != null) {
            p.remove(s);
        }
        if (p.size() <= 8) {
            return p;
        }
        while (p.size() > 8) {
            s = p.last();
            final Logger f = Logger.f();
            final StringBuilder sb = new StringBuilder();
            sb.append("Removing session over cap: ");
            sb.append(s);
            f.b(sb.toString());
            this.b.c(s);
            p.remove(s);
        }
        return p;
    }
    
    private static int f(final List<File> list, final int n) {
        int size = list.size();
        for (final File file : list) {
            if (size <= n) {
                return size;
            }
            FileStore.s(file);
            --size;
        }
        return size;
    }
    
    private void g() {
        final int b = this.c.b().a.b;
        final List<File> n = this.n();
        final int size = n.size();
        if (size <= b) {
            return;
        }
        final Iterator iterator = n.subList(b, size).iterator();
        while (iterator.hasNext()) {
            ((File)iterator.next()).delete();
        }
    }
    
    private static long h(final long n) {
        return n * 1000L;
    }
    
    private void j(final List<File> list) {
        final Iterator<File> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next().delete();
        }
    }
    
    private static String m(final int n, final boolean b) {
        final String format = String.format(Locale.US, "%010d", n);
        String s;
        if (b) {
            s = "_";
        }
        else {
            s = "";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("event");
        sb.append(format);
        sb.append(s);
        return sb.toString();
    }
    
    private List<File> n() {
        final ArrayList list = new ArrayList();
        list.addAll(this.b.k());
        list.addAll(this.b.h());
        final Comparator<? super File> g = CrashlyticsReportPersistence.g;
        Collections.sort((List<Object>)list, (Comparator<? super Object>)g);
        final List<File> m = this.b.m();
        Collections.sort((List<Object>)m, (Comparator<? super Object>)g);
        list.addAll(m);
        return list;
    }
    
    private static String o(final String s) {
        return s.substring(0, CrashlyticsReportPersistence.e);
    }
    
    private static boolean s(final String s) {
        return s.startsWith("event") && s.endsWith("_");
    }
    
    private static boolean t(final File file, final String s) {
        return s.startsWith("event") && !s.endsWith("_");
    }
    
    private static int u(final File file, final File file2) {
        return file2.getName().compareTo(file.getName());
    }
    
    private static boolean v(final File file, final String s) {
        return s.startsWith("event");
    }
    
    private static int x(final File file, final File file2) {
        return o(file.getName()).compareTo(o(file2.getName()));
    }
    
    public void i() {
        this.j(this.b.m());
        this.j(this.b.k());
        this.j(this.b.h());
    }
    
    public void k(String s, final long n) {
        final Iterator<Object> iterator = this.e(s).iterator();
        while (iterator.hasNext()) {
            s = iterator.next();
            final Logger f = Logger.f();
            final StringBuilder sb = new StringBuilder();
            sb.append("Finalizing report for session ");
            sb.append(s);
            f.i(sb.toString());
            this.C(s, n);
            this.b.c(s);
        }
        this.g();
    }
    
    public void l(final String s, final CrashlyticsReport.FilesPayload filesPayload) {
        final File o = this.b.o(s, "report");
        final Logger f = Logger.f();
        final StringBuilder sb = new StringBuilder();
        sb.append("Writing native session report for ");
        sb.append(s);
        sb.append(" to file: ");
        sb.append(o);
        f.b(sb.toString());
        this.B(o, filesPayload, s);
    }
    
    public SortedSet<String> p() {
        return new TreeSet(this.b.d()).descendingSet();
    }
    
    public long q(final String s) {
        return this.b.o(s, "start-time").lastModified();
    }
    
    public boolean r() {
        return !this.b.m().isEmpty() || !this.b.k().isEmpty() || !this.b.h().isEmpty();
    }
    
    public List<CrashlyticsReportWithSessionId> w() {
        final List<File> n = this.n();
        final ArrayList list = new ArrayList();
        for (final File file : n) {
            try {
                list.add(CrashlyticsReportWithSessionId.a(CrashlyticsReportPersistence.f.D(A(file)), file.getName(), file));
            }
            catch (final IOException ex) {
                final Logger f = Logger.f();
                final StringBuilder sb = new StringBuilder();
                sb.append("Could not load report file ");
                sb.append(file);
                sb.append("; deleting");
                f.l(sb.toString(), ex);
                file.delete();
            }
        }
        return list;
    }
    
    public void y(final CrashlyticsReport.Session.Event event, final String s, final boolean b) {
        final int a = this.c.b().a.a;
        final String h = CrashlyticsReportPersistence.f.h(event);
        final String m = m(this.a.getAndIncrement(), b);
        try {
            F(this.b.o(s, m), h);
        }
        catch (final IOException ex) {
            final Logger f = Logger.f();
            final StringBuilder sb = new StringBuilder();
            sb.append("Could not persist event for session ");
            sb.append(s);
            f.l(sb.toString(), ex);
        }
        this.E(s, a);
    }
    
    public void z(final CrashlyticsReport crashlyticsReport) {
        final CrashlyticsReport.Session j = crashlyticsReport.j();
        if (j == null) {
            Logger.f().b("Could not get session for report");
            return;
        }
        final String h = j.h();
        try {
            F(this.b.o(h, "report"), CrashlyticsReportPersistence.f.E(crashlyticsReport));
            G(this.b.o(h, "start-time"), "", j.k());
        }
        catch (final IOException ex) {
            final Logger f = Logger.f();
            final StringBuilder sb = new StringBuilder();
            sb.append("Could not persist report for session ");
            sb.append(h);
            f.c(sb.toString(), ex);
        }
    }
}

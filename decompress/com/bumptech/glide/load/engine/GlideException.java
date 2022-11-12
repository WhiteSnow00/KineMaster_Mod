// 
// Decompiled by Procyon v0.6.0
// 

package com.bumptech.glide.load.engine;

import java.io.PrintWriter;
import java.io.PrintStream;
import android.util.Log;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Iterator;
import java.util.Collections;
import c2.b;
import com.bumptech.glide.load.DataSource;
import java.util.List;

public final class GlideException extends Exception
{
    private static final StackTraceElement[] a;
    private static final long serialVersionUID = 1L;
    private final List<Throwable> causes;
    private Class<?> dataClass;
    private DataSource dataSource;
    private String detailMessage;
    private Exception exception;
    private b key;
    
    static {
        a = new StackTraceElement[0];
    }
    
    public GlideException(final String s) {
        this(s, Collections.emptyList());
    }
    
    public GlideException(final String s, final Throwable t) {
        this(s, Collections.singletonList(t));
    }
    
    public GlideException(final String detailMessage, final List<Throwable> causes) {
        this.detailMessage = detailMessage;
        this.setStackTrace(GlideException.a);
        this.causes = causes;
    }
    
    private void a(final Throwable t, final List<Throwable> list) {
        if (t instanceof GlideException) {
            final Iterator<Throwable> iterator = ((GlideException)t).getCauses().iterator();
            while (iterator.hasNext()) {
                this.a(iterator.next(), list);
            }
        }
        else {
            list.add(t);
        }
    }
    
    private static void b(final List<Throwable> list, final Appendable appendable) {
        try {
            c(list, appendable);
        }
        catch (final IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    private static void c(final List<Throwable> list, final Appendable appendable) throws IOException {
        int n;
        for (int size = list.size(), i = 0; i < size; i = n) {
            final Appendable append = appendable.append("Cause (");
            n = i + 1;
            append.append(String.valueOf(n)).append(" of ").append(String.valueOf(size)).append("): ");
            final Throwable t = list.get(i);
            if (t instanceof GlideException) {
                ((GlideException)t).e(appendable);
            }
            else {
                d(t, appendable);
            }
        }
    }
    
    private static void d(final Throwable t, final Appendable appendable) {
        try {
            appendable.append(t.getClass().toString()).append(": ").append(t.getMessage()).append('\n');
        }
        catch (final IOException ex) {
            throw new RuntimeException(t);
        }
    }
    
    private void e(final Appendable appendable) {
        d(this, appendable);
        b(this.getCauses(), new a(appendable));
    }
    
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
    
    public List<Throwable> getCauses() {
        return this.causes;
    }
    
    @Override
    public String getMessage() {
        final StringBuilder sb = new StringBuilder(71);
        sb.append(this.detailMessage);
        final Class<?> dataClass = this.dataClass;
        final String s = "";
        String string;
        if (dataClass != null) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(", ");
            sb2.append(this.dataClass);
            string = sb2.toString();
        }
        else {
            string = "";
        }
        sb.append(string);
        String string2;
        if (this.dataSource != null) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append(", ");
            sb3.append(this.dataSource);
            string2 = sb3.toString();
        }
        else {
            string2 = "";
        }
        sb.append(string2);
        String string3 = s;
        if (this.key != null) {
            final StringBuilder sb4 = new StringBuilder();
            sb4.append(", ");
            sb4.append(this.key);
            string3 = sb4.toString();
        }
        sb.append(string3);
        final List<Throwable> rootCauses = this.getRootCauses();
        if (rootCauses.isEmpty()) {
            return sb.toString();
        }
        if (rootCauses.size() == 1) {
            sb.append("\nThere was 1 root cause:");
        }
        else {
            sb.append("\nThere were ");
            sb.append(rootCauses.size());
            sb.append(" root causes:");
        }
        for (final Throwable t : rootCauses) {
            sb.append('\n');
            sb.append(t.getClass().getName());
            sb.append('(');
            sb.append(t.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }
    
    public Exception getOrigin() {
        return this.exception;
    }
    
    public List<Throwable> getRootCauses() {
        final ArrayList list = new ArrayList();
        this.a(this, list);
        return list;
    }
    
    public void logRootCauses(final String s) {
        final List<Throwable> rootCauses = this.getRootCauses();
        int n;
        for (int size = rootCauses.size(), i = 0; i < size; i = n) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Root cause (");
            n = i + 1;
            sb.append(n);
            sb.append(" of ");
            sb.append(size);
            sb.append(")");
            Log.i(s, sb.toString(), (Throwable)rootCauses.get(i));
        }
    }
    
    @Override
    public void printStackTrace() {
        this.printStackTrace(System.err);
    }
    
    @Override
    public void printStackTrace(final PrintStream printStream) {
        this.e(printStream);
    }
    
    @Override
    public void printStackTrace(final PrintWriter printWriter) {
        this.e(printWriter);
    }
    
    void setLoggingDetails(final b b, final DataSource dataSource) {
        this.setLoggingDetails(b, dataSource, null);
    }
    
    void setLoggingDetails(final b key, final DataSource dataSource, final Class<?> dataClass) {
        this.key = key;
        this.dataSource = dataSource;
        this.dataClass = dataClass;
    }
    
    public void setOrigin(final Exception exception) {
        this.exception = exception;
    }
    
    private static final class a implements Appendable
    {
        private final Appendable a;
        private boolean b;
        
        a(final Appendable a) {
            this.b = true;
            this.a = a;
        }
        
        private CharSequence a(final CharSequence charSequence) {
            CharSequence charSequence2 = charSequence;
            if (charSequence == null) {
                charSequence2 = "";
            }
            return charSequence2;
        }
        
        @Override
        public Appendable append(final char c) throws IOException {
            final boolean b = this.b;
            boolean b2 = false;
            if (b) {
                this.b = false;
                this.a.append("  ");
            }
            if (c == '\n') {
                b2 = true;
            }
            this.b = b2;
            this.a.append(c);
            return this;
        }
        
        @Override
        public Appendable append(CharSequence a) throws IOException {
            a = this.a(a);
            return this.append(a, 0, a.length());
        }
        
        @Override
        public Appendable append(CharSequence a, final int n, final int n2) throws IOException {
            a = this.a(a);
            final boolean b = this.b;
            final boolean b2 = false;
            if (b) {
                this.b = false;
                this.a.append("  ");
            }
            boolean b3 = b2;
            if (a.length() > 0) {
                b3 = b2;
                if (a.charAt(n2 - 1) == '\n') {
                    b3 = true;
                }
            }
            this.b = b3;
            this.a.append(a, n, n2);
            return this;
        }
    }
}

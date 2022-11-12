// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.encoders.annotations.Encodable$Field;
import com.google.firebase.encoders.annotations.Encodable$Ignore;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import com.google.auto.value.AutoValue$Builder;
import java.nio.charset.Charset;
import com.google.auto.value.AutoValue;
import com.google.firebase.encoders.annotations.Encodable;

@Encodable
@AutoValue
public abstract class CrashlyticsReport
{
    private static final Charset a;
    
    static {
        a = Charset.forName("UTF-8");
    }
    
    static Charset a() {
        return CrashlyticsReport.a;
    }
    
    public static Builder b() {
        return (Builder)new a.b();
    }
    
    public abstract String c();
    
    public abstract String d();
    
    public abstract String e();
    
    public abstract String f();
    
    public abstract FilesPayload g();
    
    public abstract int h();
    
    public abstract String i();
    
    public abstract Session j();
    
    protected abstract Builder k();
    
    public CrashlyticsReport l(final ImmutableList<Session.Event> list) {
        if (this.j() != null) {
            return this.k().i(this.j().o(list)).a();
        }
        throw new IllegalStateException("Reports without sessions cannot have events added to them.");
    }
    
    public CrashlyticsReport m(final FilesPayload filesPayload) {
        return this.k().i(null).f(filesPayload).a();
    }
    
    public CrashlyticsReport n(final long n, final boolean b, final String s) {
        final Builder k = this.k();
        if (this.j() != null) {
            k.i(this.j().p(n, b, s));
        }
        return k.a();
    }
    
    @AutoValue
    public abstract static class ApplicationExitInfo
    {
        public static Builder a() {
            return (Builder)new b.b();
        }
        
        public abstract int b();
        
        public abstract int c();
        
        public abstract String d();
        
        public abstract long e();
        
        public abstract int f();
        
        public abstract long g();
        
        public abstract long h();
        
        public abstract String i();
        
        @AutoValue$Builder
        public abstract static class Builder
        {
            public abstract ApplicationExitInfo a();
            
            public abstract Builder b(final int p0);
            
            public abstract Builder c(final int p0);
            
            public abstract Builder d(final String p0);
            
            public abstract Builder e(final long p0);
            
            public abstract Builder f(final int p0);
            
            public abstract Builder g(final long p0);
            
            public abstract Builder h(final long p0);
            
            public abstract Builder i(final String p0);
        }
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public @interface Architecture {
    }
    
    @AutoValue$Builder
    public abstract static class Builder
    {
        public abstract CrashlyticsReport a();
        
        public abstract Builder b(final String p0);
        
        public abstract Builder c(final String p0);
        
        public abstract Builder d(final String p0);
        
        public abstract Builder e(final String p0);
        
        public abstract Builder f(final FilesPayload p0);
        
        public abstract Builder g(final int p0);
        
        public abstract Builder h(final String p0);
        
        public abstract Builder i(final Session p0);
    }
    
    @AutoValue
    public abstract static class CustomAttribute
    {
        public static Builder a() {
            return (Builder)new c.b();
        }
        
        public abstract String b();
        
        public abstract String c();
        
        @AutoValue$Builder
        public abstract static class Builder
        {
            public abstract CustomAttribute a();
            
            public abstract Builder b(final String p0);
            
            public abstract Builder c(final String p0);
        }
    }
    
    @AutoValue
    public abstract static class FilesPayload
    {
        public static Builder a() {
            return (Builder)new d.b();
        }
        
        public abstract ImmutableList<File> b();
        
        public abstract String c();
        
        @AutoValue$Builder
        public abstract static class Builder
        {
            public abstract FilesPayload a();
            
            public abstract Builder b(final ImmutableList<File> p0);
            
            public abstract Builder c(final String p0);
        }
        
        @AutoValue
        public abstract static class File
        {
            public static Builder a() {
                return (Builder)new e.b();
            }
            
            public abstract byte[] b();
            
            public abstract String c();
            
            @AutoValue$Builder
            public abstract static class Builder
            {
                public abstract File a();
                
                public abstract Builder b(final byte[] p0);
                
                public abstract Builder c(final String p0);
            }
        }
    }
    
    @AutoValue
    public abstract static class Session
    {
        public static Builder a() {
            return new f.b().c(false);
        }
        
        public abstract Application b();
        
        public abstract Device c();
        
        public abstract Long d();
        
        public abstract ImmutableList<Event> e();
        
        public abstract String f();
        
        public abstract int g();
        
        @Encodable$Ignore
        public abstract String h();
        
        @Encodable$Field
        public byte[] i() {
            return this.h().getBytes(CrashlyticsReport.a());
        }
        
        public abstract OperatingSystem j();
        
        public abstract long k();
        
        public abstract User l();
        
        public abstract boolean m();
        
        public abstract Builder n();
        
        Session o(final ImmutableList<Event> list) {
            return this.n().f(list).a();
        }
        
        Session p(final long n, final boolean b, final String s) {
            final Builder n2 = this.n();
            n2.e(n);
            n2.c(b);
            if (s != null) {
                n2.m(User.a().b(s).a());
            }
            return n2.a();
        }
        
        @AutoValue
        public abstract static class Application
        {
            public static Builder a() {
                return (Builder)new g.b();
            }
            
            public abstract String b();
            
            public abstract String c();
            
            public abstract String d();
            
            public abstract String e();
            
            public abstract String f();
            
            public abstract Organization g();
            
            public abstract String h();
            
            @AutoValue$Builder
            public abstract static class Builder
            {
                public abstract Application a();
                
                public abstract Builder b(final String p0);
                
                public abstract Builder c(final String p0);
                
                public abstract Builder d(final String p0);
                
                public abstract Builder e(final String p0);
                
                public abstract Builder f(final String p0);
                
                public abstract Builder g(final String p0);
            }
            
            @AutoValue
            public abstract static class Organization
            {
                public abstract String a();
                
                @AutoValue$Builder
                public abstract static class Builder
                {
                }
            }
        }
        
        @AutoValue$Builder
        public abstract static class Builder
        {
            public abstract Session a();
            
            public abstract Builder b(final Application p0);
            
            public abstract Builder c(final boolean p0);
            
            public abstract Builder d(final Device p0);
            
            public abstract Builder e(final Long p0);
            
            public abstract Builder f(final ImmutableList<Event> p0);
            
            public abstract Builder g(final String p0);
            
            public abstract Builder h(final int p0);
            
            public abstract Builder i(final String p0);
            
            public Builder j(final byte[] array) {
                return this.i(new String(array, CrashlyticsReport.a()));
            }
            
            public abstract Builder k(final OperatingSystem p0);
            
            public abstract Builder l(final long p0);
            
            public abstract Builder m(final User p0);
        }
        
        @AutoValue
        public abstract static class Device
        {
            public static Builder a() {
                return (Builder)new i.b();
            }
            
            public abstract int b();
            
            public abstract int c();
            
            public abstract long d();
            
            public abstract String e();
            
            public abstract String f();
            
            public abstract String g();
            
            public abstract long h();
            
            public abstract int i();
            
            public abstract boolean j();
            
            @AutoValue$Builder
            public abstract static class Builder
            {
                public abstract Device a();
                
                public abstract Builder b(final int p0);
                
                public abstract Builder c(final int p0);
                
                public abstract Builder d(final long p0);
                
                public abstract Builder e(final String p0);
                
                public abstract Builder f(final String p0);
                
                public abstract Builder g(final String p0);
                
                public abstract Builder h(final long p0);
                
                public abstract Builder i(final boolean p0);
                
                public abstract Builder j(final int p0);
            }
        }
        
        @AutoValue
        public abstract static class Event
        {
            public static Builder a() {
                return (Builder)new j.b();
            }
            
            public abstract Application b();
            
            public abstract Device c();
            
            public abstract Log d();
            
            public abstract long e();
            
            public abstract String f();
            
            public abstract Builder g();
            
            @AutoValue
            public abstract static class Application
            {
                public static Builder a() {
                    return (Builder)new k.b();
                }
                
                public abstract Boolean b();
                
                public abstract ImmutableList<CustomAttribute> c();
                
                public abstract Execution d();
                
                public abstract ImmutableList<CustomAttribute> e();
                
                public abstract int f();
                
                public abstract Builder g();
                
                @AutoValue$Builder
                public abstract static class Builder
                {
                    public abstract Application a();
                    
                    public abstract Builder b(final Boolean p0);
                    
                    public abstract Builder c(final ImmutableList<CustomAttribute> p0);
                    
                    public abstract Builder d(final Execution p0);
                    
                    public abstract Builder e(final ImmutableList<CustomAttribute> p0);
                    
                    public abstract Builder f(final int p0);
                }
                
                @AutoValue
                public abstract static class Execution
                {
                    public static Builder a() {
                        return (Builder)new l.b();
                    }
                    
                    public abstract ApplicationExitInfo b();
                    
                    public abstract ImmutableList<BinaryImage> c();
                    
                    public abstract Exception d();
                    
                    public abstract Signal e();
                    
                    public abstract ImmutableList<Thread> f();
                    
                    @AutoValue
                    public abstract static class BinaryImage
                    {
                        public static Builder a() {
                            return (Builder)new m.b();
                        }
                        
                        public abstract long b();
                        
                        public abstract String c();
                        
                        public abstract long d();
                        
                        @Encodable$Ignore
                        public abstract String e();
                        
                        @Encodable$Field
                        public byte[] f() {
                            final String e = this.e();
                            byte[] bytes;
                            if (e != null) {
                                bytes = e.getBytes(CrashlyticsReport.a());
                            }
                            else {
                                bytes = null;
                            }
                            return bytes;
                        }
                        
                        @AutoValue$Builder
                        public abstract static class Builder
                        {
                            public abstract BinaryImage a();
                            
                            public abstract Builder b(final long p0);
                            
                            public abstract Builder c(final String p0);
                            
                            public abstract Builder d(final long p0);
                            
                            public abstract Builder e(final String p0);
                            
                            public Builder f(final byte[] array) {
                                return this.e(new String(array, CrashlyticsReport.a()));
                            }
                        }
                    }
                    
                    @AutoValue$Builder
                    public abstract static class Builder
                    {
                        public abstract Execution a();
                        
                        public abstract Builder b(final ApplicationExitInfo p0);
                        
                        public abstract Builder c(final ImmutableList<BinaryImage> p0);
                        
                        public abstract Builder d(final Exception p0);
                        
                        public abstract Builder e(final Signal p0);
                        
                        public abstract Builder f(final ImmutableList<Thread> p0);
                    }
                    
                    @AutoValue
                    public abstract static class Exception
                    {
                        public static Builder a() {
                            return (Builder)new n.b();
                        }
                        
                        public abstract Exception b();
                        
                        public abstract ImmutableList<Thread.Frame> c();
                        
                        public abstract int d();
                        
                        public abstract String e();
                        
                        public abstract String f();
                        
                        @AutoValue$Builder
                        public abstract static class Builder
                        {
                            public abstract Exception a();
                            
                            public abstract Builder b(final Exception p0);
                            
                            public abstract Builder c(final ImmutableList<Thread.Frame> p0);
                            
                            public abstract Builder d(final int p0);
                            
                            public abstract Builder e(final String p0);
                            
                            public abstract Builder f(final String p0);
                        }
                    }
                    
                    @AutoValue
                    public abstract static class Signal
                    {
                        public static Builder a() {
                            return (Builder)new o.b();
                        }
                        
                        public abstract long b();
                        
                        public abstract String c();
                        
                        public abstract String d();
                        
                        @AutoValue$Builder
                        public abstract static class Builder
                        {
                            public abstract Signal a();
                            
                            public abstract Builder b(final long p0);
                            
                            public abstract Builder c(final String p0);
                            
                            public abstract Builder d(final String p0);
                        }
                    }
                    
                    @AutoValue
                    public abstract static class Thread
                    {
                        public static Builder a() {
                            return (Builder)new p.b();
                        }
                        
                        public abstract ImmutableList<Frame> b();
                        
                        public abstract int c();
                        
                        public abstract String d();
                        
                        @AutoValue$Builder
                        public abstract static class Builder
                        {
                            public abstract Thread a();
                            
                            public abstract Builder b(final ImmutableList<Frame> p0);
                            
                            public abstract Builder c(final int p0);
                            
                            public abstract Builder d(final String p0);
                        }
                        
                        @AutoValue
                        public abstract static class Frame
                        {
                            public static Builder a() {
                                return (Builder)new q.b();
                            }
                            
                            public abstract String b();
                            
                            public abstract int c();
                            
                            public abstract long d();
                            
                            public abstract long e();
                            
                            public abstract String f();
                            
                            @AutoValue$Builder
                            public abstract static class Builder
                            {
                                public abstract Frame a();
                                
                                public abstract Builder b(final String p0);
                                
                                public abstract Builder c(final int p0);
                                
                                public abstract Builder d(final long p0);
                                
                                public abstract Builder e(final long p0);
                                
                                public abstract Builder f(final String p0);
                            }
                        }
                    }
                }
            }
            
            @AutoValue$Builder
            public abstract static class Builder
            {
                public abstract Event a();
                
                public abstract Builder b(final Application p0);
                
                public abstract Builder c(final Device p0);
                
                public abstract Builder d(final Log p0);
                
                public abstract Builder e(final long p0);
                
                public abstract Builder f(final String p0);
            }
            
            @AutoValue
            public abstract static class Device
            {
                public static Builder a() {
                    return (Builder)new r.b();
                }
                
                public abstract Double b();
                
                public abstract int c();
                
                public abstract long d();
                
                public abstract int e();
                
                public abstract long f();
                
                public abstract boolean g();
                
                @AutoValue$Builder
                public abstract static class Builder
                {
                    public abstract Device a();
                    
                    public abstract Builder b(final Double p0);
                    
                    public abstract Builder c(final int p0);
                    
                    public abstract Builder d(final long p0);
                    
                    public abstract Builder e(final int p0);
                    
                    public abstract Builder f(final boolean p0);
                    
                    public abstract Builder g(final long p0);
                }
            }
            
            @AutoValue
            public abstract static class Log
            {
                public static Builder a() {
                    return (Builder)new s.b();
                }
                
                public abstract String b();
                
                @AutoValue$Builder
                public abstract static class Builder
                {
                    public abstract Log a();
                    
                    public abstract Builder b(final String p0);
                }
            }
        }
        
        @AutoValue
        public abstract static class OperatingSystem
        {
            public static Builder a() {
                return (Builder)new t.b();
            }
            
            public abstract String b();
            
            public abstract int c();
            
            public abstract String d();
            
            public abstract boolean e();
            
            @AutoValue$Builder
            public abstract static class Builder
            {
                public abstract OperatingSystem a();
                
                public abstract Builder b(final String p0);
                
                public abstract Builder c(final boolean p0);
                
                public abstract Builder d(final int p0);
                
                public abstract Builder e(final String p0);
            }
        }
        
        @AutoValue
        public abstract static class User
        {
            public static Builder a() {
                return (Builder)new u.b();
            }
            
            public abstract String b();
            
            @AutoValue$Builder
            public abstract static class Builder
            {
                public abstract User a();
                
                public abstract Builder b(final String p0);
            }
        }
    }
    
    public enum Type
    {
        private static final Type[] $VALUES;
        
        INCOMPLETE, 
        JAVA, 
        NATIVE;
    }
}

// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.model;

import java.io.IOException;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.encoders.config.Configurator;

public final class AutoCrashlyticsReportEncoder implements Configurator
{
    public static final Configurator a;
    
    static {
        a = (Configurator)new AutoCrashlyticsReportEncoder();
    }
    
    private AutoCrashlyticsReportEncoder() {
    }
    
    public void a(final EncoderConfig<?> encoderConfig) {
        final c a = c.a;
        encoderConfig.a((Class)CrashlyticsReport.class, (ObjectEncoder)a);
        encoderConfig.a((Class)com.google.firebase.crashlytics.internal.model.a.class, (ObjectEncoder)a);
        final i a2 = i.a;
        encoderConfig.a((Class)CrashlyticsReport.Session.class, (ObjectEncoder)a2);
        encoderConfig.a((Class)com.google.firebase.crashlytics.internal.model.f.class, (ObjectEncoder)a2);
        final f a3 = f.a;
        encoderConfig.a((Class)CrashlyticsReport.Session.Application.class, (ObjectEncoder)a3);
        encoderConfig.a((Class)com.google.firebase.crashlytics.internal.model.g.class, (ObjectEncoder)a3);
        final g a4 = g.a;
        encoderConfig.a((Class)CrashlyticsReport.Session.Application.Organization.class, (ObjectEncoder)a4);
        encoderConfig.a((Class)com.google.firebase.crashlytics.internal.model.h.class, (ObjectEncoder)a4);
        final u a5 = u.a;
        encoderConfig.a((Class)CrashlyticsReport.Session.User.class, (ObjectEncoder)a5);
        encoderConfig.a((Class)com.google.firebase.crashlytics.internal.model.u.class, (ObjectEncoder)a5);
        final t a6 = t.a;
        encoderConfig.a((Class)CrashlyticsReport.Session.OperatingSystem.class, (ObjectEncoder)a6);
        encoderConfig.a((Class)com.google.firebase.crashlytics.internal.model.t.class, (ObjectEncoder)a6);
        final h a7 = h.a;
        encoderConfig.a((Class)CrashlyticsReport.Session.Device.class, (ObjectEncoder)a7);
        encoderConfig.a((Class)com.google.firebase.crashlytics.internal.model.i.class, (ObjectEncoder)a7);
        final r a8 = r.a;
        encoderConfig.a((Class)CrashlyticsReport.Session.Event.class, (ObjectEncoder)a8);
        encoderConfig.a((Class)com.google.firebase.crashlytics.internal.model.j.class, (ObjectEncoder)a8);
        final j a9 = j.a;
        encoderConfig.a((Class)CrashlyticsReport.Session.Event.Application.class, (ObjectEncoder)a9);
        encoderConfig.a((Class)com.google.firebase.crashlytics.internal.model.k.class, (ObjectEncoder)a9);
        final l a10 = l.a;
        encoderConfig.a((Class)CrashlyticsReport.Session.Event.Application.Execution.class, (ObjectEncoder)a10);
        encoderConfig.a((Class)com.google.firebase.crashlytics.internal.model.l.class, (ObjectEncoder)a10);
        final o a11 = o.a;
        encoderConfig.a((Class)CrashlyticsReport.Session.Event.Application.Execution.Thread.class, (ObjectEncoder)a11);
        encoderConfig.a((Class)com.google.firebase.crashlytics.internal.model.p.class, (ObjectEncoder)a11);
        final p a12 = p.a;
        encoderConfig.a((Class)CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.class, (ObjectEncoder)a12);
        encoderConfig.a((Class)com.google.firebase.crashlytics.internal.model.q.class, (ObjectEncoder)a12);
        final m a13 = m.a;
        encoderConfig.a((Class)CrashlyticsReport.Session.Event.Application.Execution.Exception.class, (ObjectEncoder)a13);
        encoderConfig.a((Class)com.google.firebase.crashlytics.internal.model.n.class, (ObjectEncoder)a13);
        final a a14 = AutoCrashlyticsReportEncoder.a.a;
        encoderConfig.a((Class)CrashlyticsReport.ApplicationExitInfo.class, (ObjectEncoder)a14);
        encoderConfig.a((Class)com.google.firebase.crashlytics.internal.model.b.class, (ObjectEncoder)a14);
        final n a15 = n.a;
        encoderConfig.a((Class)CrashlyticsReport.Session.Event.Application.Execution.Signal.class, (ObjectEncoder)a15);
        encoderConfig.a((Class)com.google.firebase.crashlytics.internal.model.o.class, (ObjectEncoder)a15);
        final k a16 = k.a;
        encoderConfig.a((Class)CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.class, (ObjectEncoder)a16);
        encoderConfig.a((Class)com.google.firebase.crashlytics.internal.model.m.class, (ObjectEncoder)a16);
        final b a17 = b.a;
        encoderConfig.a((Class)CrashlyticsReport.CustomAttribute.class, (ObjectEncoder)a17);
        encoderConfig.a((Class)com.google.firebase.crashlytics.internal.model.c.class, (ObjectEncoder)a17);
        final q a18 = q.a;
        encoderConfig.a((Class)CrashlyticsReport.Session.Event.Device.class, (ObjectEncoder)a18);
        encoderConfig.a((Class)com.google.firebase.crashlytics.internal.model.r.class, (ObjectEncoder)a18);
        final s a19 = s.a;
        encoderConfig.a((Class)CrashlyticsReport.Session.Event.Log.class, (ObjectEncoder)a19);
        encoderConfig.a((Class)com.google.firebase.crashlytics.internal.model.s.class, (ObjectEncoder)a19);
        final d a20 = d.a;
        encoderConfig.a((Class)CrashlyticsReport.FilesPayload.class, (ObjectEncoder)a20);
        encoderConfig.a((Class)com.google.firebase.crashlytics.internal.model.d.class, (ObjectEncoder)a20);
        final e a21 = e.a;
        encoderConfig.a((Class)CrashlyticsReport.FilesPayload.File.class, (ObjectEncoder)a21);
        encoderConfig.a((Class)com.google.firebase.crashlytics.internal.model.e.class, (ObjectEncoder)a21);
    }
    
    private static final class a implements ObjectEncoder<CrashlyticsReport.ApplicationExitInfo>
    {
        static final a a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        private static final FieldDescriptor d;
        private static final FieldDescriptor e;
        private static final FieldDescriptor f;
        private static final FieldDescriptor g;
        private static final FieldDescriptor h;
        private static final FieldDescriptor i;
        
        static {
            a = new a();
            b = FieldDescriptor.d("pid");
            c = FieldDescriptor.d("processName");
            d = FieldDescriptor.d("reasonCode");
            e = FieldDescriptor.d("importance");
            f = FieldDescriptor.d("pss");
            g = FieldDescriptor.d("rss");
            h = FieldDescriptor.d("timestamp");
            i = FieldDescriptor.d("traceFile");
        }
        
        public /* bridge */ void a(final Object o, final Object o2) throws IOException {
            this.b((CrashlyticsReport.ApplicationExitInfo)o, (ObjectEncoderContext)o2);
        }
        
        public void b(final CrashlyticsReport.ApplicationExitInfo applicationExitInfo, final ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.c(AutoCrashlyticsReportEncoder.a.b, applicationExitInfo.c());
            objectEncoderContext.e(AutoCrashlyticsReportEncoder.a.c, (Object)applicationExitInfo.d());
            objectEncoderContext.c(AutoCrashlyticsReportEncoder.a.d, applicationExitInfo.f());
            objectEncoderContext.c(AutoCrashlyticsReportEncoder.a.e, applicationExitInfo.b());
            objectEncoderContext.b(AutoCrashlyticsReportEncoder.a.f, applicationExitInfo.e());
            objectEncoderContext.b(AutoCrashlyticsReportEncoder.a.g, applicationExitInfo.g());
            objectEncoderContext.b(AutoCrashlyticsReportEncoder.a.h, applicationExitInfo.h());
            objectEncoderContext.e(AutoCrashlyticsReportEncoder.a.i, (Object)applicationExitInfo.i());
        }
    }
    
    private static final class b implements ObjectEncoder<CrashlyticsReport.CustomAttribute>
    {
        static final b a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        
        static {
            a = new b();
            b = FieldDescriptor.d("key");
            c = FieldDescriptor.d("value");
        }
        
        public /* bridge */ void a(final Object o, final Object o2) throws IOException {
            this.b((CrashlyticsReport.CustomAttribute)o, (ObjectEncoderContext)o2);
        }
        
        public void b(final CrashlyticsReport.CustomAttribute customAttribute, final ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.e(AutoCrashlyticsReportEncoder.b.b, (Object)customAttribute.b());
            objectEncoderContext.e(AutoCrashlyticsReportEncoder.b.c, (Object)customAttribute.c());
        }
    }
    
    private static final class c implements ObjectEncoder<CrashlyticsReport>
    {
        static final c a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        private static final FieldDescriptor d;
        private static final FieldDescriptor e;
        private static final FieldDescriptor f;
        private static final FieldDescriptor g;
        private static final FieldDescriptor h;
        private static final FieldDescriptor i;
        
        static {
            a = new c();
            b = FieldDescriptor.d("sdkVersion");
            c = FieldDescriptor.d("gmpAppId");
            d = FieldDescriptor.d("platform");
            e = FieldDescriptor.d("installationUuid");
            f = FieldDescriptor.d("buildVersion");
            g = FieldDescriptor.d("displayVersion");
            h = FieldDescriptor.d("session");
            i = FieldDescriptor.d("ndkPayload");
        }
        
        public /* bridge */ void a(final Object o, final Object o2) throws IOException {
            this.b((CrashlyticsReport)o, (ObjectEncoderContext)o2);
        }
        
        public void b(final CrashlyticsReport crashlyticsReport, final ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.e(AutoCrashlyticsReportEncoder.c.b, (Object)crashlyticsReport.i());
            objectEncoderContext.e(AutoCrashlyticsReportEncoder.c.c, (Object)crashlyticsReport.e());
            objectEncoderContext.c(AutoCrashlyticsReportEncoder.c.d, crashlyticsReport.h());
            objectEncoderContext.e(AutoCrashlyticsReportEncoder.c.e, (Object)crashlyticsReport.f());
            objectEncoderContext.e(AutoCrashlyticsReportEncoder.c.f, (Object)crashlyticsReport.c());
            objectEncoderContext.e(AutoCrashlyticsReportEncoder.c.g, (Object)crashlyticsReport.d());
            objectEncoderContext.e(AutoCrashlyticsReportEncoder.c.h, (Object)crashlyticsReport.j());
            objectEncoderContext.e(AutoCrashlyticsReportEncoder.c.i, (Object)crashlyticsReport.g());
        }
    }
    
    private static final class d implements ObjectEncoder<CrashlyticsReport.FilesPayload>
    {
        static final d a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        
        static {
            a = new d();
            b = FieldDescriptor.d("files");
            c = FieldDescriptor.d("orgId");
        }
        
        public /* bridge */ void a(final Object o, final Object o2) throws IOException {
            this.b((CrashlyticsReport.FilesPayload)o, (ObjectEncoderContext)o2);
        }
        
        public void b(final CrashlyticsReport.FilesPayload filesPayload, final ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.e(d.b, (Object)filesPayload.b());
            objectEncoderContext.e(d.c, (Object)filesPayload.c());
        }
    }
    
    private static final class e implements ObjectEncoder<CrashlyticsReport.FilesPayload.File>
    {
        static final e a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        
        static {
            a = new e();
            b = FieldDescriptor.d("filename");
            c = FieldDescriptor.d("contents");
        }
        
        public /* bridge */ void a(final Object o, final Object o2) throws IOException {
            this.b((CrashlyticsReport.FilesPayload.File)o, (ObjectEncoderContext)o2);
        }
        
        public void b(final CrashlyticsReport.FilesPayload.File file, final ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.e(e.b, (Object)file.c());
            objectEncoderContext.e(e.c, (Object)file.b());
        }
    }
    
    private static final class f implements ObjectEncoder<CrashlyticsReport.Session.Application>
    {
        static final f a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        private static final FieldDescriptor d;
        private static final FieldDescriptor e;
        private static final FieldDescriptor f;
        private static final FieldDescriptor g;
        private static final FieldDescriptor h;
        
        static {
            a = new f();
            b = FieldDescriptor.d("identifier");
            c = FieldDescriptor.d("version");
            d = FieldDescriptor.d("displayVersion");
            e = FieldDescriptor.d("organization");
            f = FieldDescriptor.d("installationUuid");
            g = FieldDescriptor.d("developmentPlatform");
            h = FieldDescriptor.d("developmentPlatformVersion");
        }
        
        public /* bridge */ void a(final Object o, final Object o2) throws IOException {
            this.b((CrashlyticsReport.Session.Application)o, (ObjectEncoderContext)o2);
        }
        
        public void b(final CrashlyticsReport.Session.Application application, final ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.e(AutoCrashlyticsReportEncoder.f.b, (Object)application.e());
            objectEncoderContext.e(AutoCrashlyticsReportEncoder.f.c, (Object)application.h());
            objectEncoderContext.e(AutoCrashlyticsReportEncoder.f.d, (Object)application.d());
            objectEncoderContext.e(AutoCrashlyticsReportEncoder.f.e, (Object)application.g());
            objectEncoderContext.e(AutoCrashlyticsReportEncoder.f.f, (Object)application.f());
            objectEncoderContext.e(AutoCrashlyticsReportEncoder.f.g, (Object)application.b());
            objectEncoderContext.e(AutoCrashlyticsReportEncoder.f.h, (Object)application.c());
        }
    }
    
    private static final class g implements ObjectEncoder<CrashlyticsReport.Session.Application.Organization>
    {
        static final g a;
        private static final FieldDescriptor b;
        
        static {
            a = new g();
            b = FieldDescriptor.d("clsId");
        }
        
        public /* bridge */ void a(final Object o, final Object o2) throws IOException {
            this.b((CrashlyticsReport.Session.Application.Organization)o, (ObjectEncoderContext)o2);
        }
        
        public void b(final CrashlyticsReport.Session.Application.Organization organization, final ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.e(g.b, (Object)organization.a());
        }
    }
    
    private static final class h implements ObjectEncoder<CrashlyticsReport.Session.Device>
    {
        static final h a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        private static final FieldDescriptor d;
        private static final FieldDescriptor e;
        private static final FieldDescriptor f;
        private static final FieldDescriptor g;
        private static final FieldDescriptor h;
        private static final FieldDescriptor i;
        private static final FieldDescriptor j;
        
        static {
            a = new h();
            b = FieldDescriptor.d("arch");
            c = FieldDescriptor.d("model");
            d = FieldDescriptor.d("cores");
            e = FieldDescriptor.d("ram");
            f = FieldDescriptor.d("diskSpace");
            g = FieldDescriptor.d("simulator");
            h = FieldDescriptor.d("state");
            i = FieldDescriptor.d("manufacturer");
            j = FieldDescriptor.d("modelClass");
        }
        
        public /* bridge */ void a(final Object o, final Object o2) throws IOException {
            this.b((CrashlyticsReport.Session.Device)o, (ObjectEncoderContext)o2);
        }
        
        public void b(final CrashlyticsReport.Session.Device device, final ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.c(AutoCrashlyticsReportEncoder.h.b, device.b());
            objectEncoderContext.e(AutoCrashlyticsReportEncoder.h.c, (Object)device.f());
            objectEncoderContext.c(AutoCrashlyticsReportEncoder.h.d, device.c());
            objectEncoderContext.b(AutoCrashlyticsReportEncoder.h.e, device.h());
            objectEncoderContext.b(AutoCrashlyticsReportEncoder.h.f, device.d());
            objectEncoderContext.a(AutoCrashlyticsReportEncoder.h.g, device.j());
            objectEncoderContext.c(AutoCrashlyticsReportEncoder.h.h, device.i());
            objectEncoderContext.e(AutoCrashlyticsReportEncoder.h.i, (Object)device.e());
            objectEncoderContext.e(AutoCrashlyticsReportEncoder.h.j, (Object)device.g());
        }
    }
    
    private static final class i implements ObjectEncoder<CrashlyticsReport.Session>
    {
        static final i a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        private static final FieldDescriptor d;
        private static final FieldDescriptor e;
        private static final FieldDescriptor f;
        private static final FieldDescriptor g;
        private static final FieldDescriptor h;
        private static final FieldDescriptor i;
        private static final FieldDescriptor j;
        private static final FieldDescriptor k;
        private static final FieldDescriptor l;
        
        static {
            a = new i();
            b = FieldDescriptor.d("generator");
            c = FieldDescriptor.d("identifier");
            d = FieldDescriptor.d("startedAt");
            e = FieldDescriptor.d("endedAt");
            f = FieldDescriptor.d("crashed");
            g = FieldDescriptor.d("app");
            h = FieldDescriptor.d("user");
            i = FieldDescriptor.d("os");
            j = FieldDescriptor.d("device");
            k = FieldDescriptor.d("events");
            l = FieldDescriptor.d("generatorType");
        }
        
        public /* bridge */ void a(final Object o, final Object o2) throws IOException {
            this.b((CrashlyticsReport.Session)o, (ObjectEncoderContext)o2);
        }
        
        public void b(final CrashlyticsReport.Session session, final ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.e(AutoCrashlyticsReportEncoder.i.b, (Object)session.f());
            objectEncoderContext.e(AutoCrashlyticsReportEncoder.i.c, (Object)session.i());
            objectEncoderContext.b(AutoCrashlyticsReportEncoder.i.d, session.k());
            objectEncoderContext.e(AutoCrashlyticsReportEncoder.i.e, (Object)session.d());
            objectEncoderContext.a(AutoCrashlyticsReportEncoder.i.f, session.m());
            objectEncoderContext.e(AutoCrashlyticsReportEncoder.i.g, (Object)session.b());
            objectEncoderContext.e(AutoCrashlyticsReportEncoder.i.h, (Object)session.l());
            objectEncoderContext.e(AutoCrashlyticsReportEncoder.i.i, (Object)session.j());
            objectEncoderContext.e(AutoCrashlyticsReportEncoder.i.j, (Object)session.c());
            objectEncoderContext.e(AutoCrashlyticsReportEncoder.i.k, (Object)session.e());
            objectEncoderContext.c(AutoCrashlyticsReportEncoder.i.l, session.g());
        }
    }
    
    private static final class j implements ObjectEncoder<CrashlyticsReport.Session.Event.Application>
    {
        static final j a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        private static final FieldDescriptor d;
        private static final FieldDescriptor e;
        private static final FieldDescriptor f;
        
        static {
            a = new j();
            b = FieldDescriptor.d("execution");
            c = FieldDescriptor.d("customAttributes");
            d = FieldDescriptor.d("internalKeys");
            e = FieldDescriptor.d("background");
            f = FieldDescriptor.d("uiOrientation");
        }
        
        public /* bridge */ void a(final Object o, final Object o2) throws IOException {
            this.b((CrashlyticsReport.Session.Event.Application)o, (ObjectEncoderContext)o2);
        }
        
        public void b(final CrashlyticsReport.Session.Event.Application application, final ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.e(j.b, (Object)application.d());
            objectEncoderContext.e(j.c, (Object)application.c());
            objectEncoderContext.e(j.d, (Object)application.e());
            objectEncoderContext.e(j.e, (Object)application.b());
            objectEncoderContext.c(j.f, application.f());
        }
    }
    
    private static final class k implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage>
    {
        static final k a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        private static final FieldDescriptor d;
        private static final FieldDescriptor e;
        
        static {
            a = new k();
            b = FieldDescriptor.d("baseAddress");
            c = FieldDescriptor.d("size");
            d = FieldDescriptor.d("name");
            e = FieldDescriptor.d("uuid");
        }
        
        public /* bridge */ void a(final Object o, final Object o2) throws IOException {
            this.b((CrashlyticsReport.Session.Event.Application.Execution.BinaryImage)o, (ObjectEncoderContext)o2);
        }
        
        public void b(final CrashlyticsReport.Session.Event.Application.Execution.BinaryImage binaryImage, final ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.b(k.b, binaryImage.b());
            objectEncoderContext.b(k.c, binaryImage.d());
            objectEncoderContext.e(k.d, (Object)binaryImage.c());
            objectEncoderContext.e(k.e, (Object)binaryImage.f());
        }
    }
    
    private static final class l implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution>
    {
        static final l a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        private static final FieldDescriptor d;
        private static final FieldDescriptor e;
        private static final FieldDescriptor f;
        
        static {
            a = new l();
            b = FieldDescriptor.d("threads");
            c = FieldDescriptor.d("exception");
            d = FieldDescriptor.d("appExitInfo");
            e = FieldDescriptor.d("signal");
            f = FieldDescriptor.d("binaries");
        }
        
        public /* bridge */ void a(final Object o, final Object o2) throws IOException {
            this.b((CrashlyticsReport.Session.Event.Application.Execution)o, (ObjectEncoderContext)o2);
        }
        
        public void b(final CrashlyticsReport.Session.Event.Application.Execution execution, final ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.e(l.b, (Object)execution.f());
            objectEncoderContext.e(l.c, (Object)execution.d());
            objectEncoderContext.e(l.d, (Object)execution.b());
            objectEncoderContext.e(l.e, (Object)execution.e());
            objectEncoderContext.e(l.f, (Object)execution.c());
        }
    }
    
    private static final class m implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Exception>
    {
        static final m a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        private static final FieldDescriptor d;
        private static final FieldDescriptor e;
        private static final FieldDescriptor f;
        
        static {
            a = new m();
            b = FieldDescriptor.d("type");
            c = FieldDescriptor.d("reason");
            d = FieldDescriptor.d("frames");
            e = FieldDescriptor.d("causedBy");
            f = FieldDescriptor.d("overflowCount");
        }
        
        public /* bridge */ void a(final Object o, final Object o2) throws IOException {
            this.b((CrashlyticsReport.Session.Event.Application.Execution.Exception)o, (ObjectEncoderContext)o2);
        }
        
        public void b(final CrashlyticsReport.Session.Event.Application.Execution.Exception ex, final ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.e(m.b, (Object)ex.f());
            objectEncoderContext.e(m.c, (Object)ex.e());
            objectEncoderContext.e(m.d, (Object)ex.c());
            objectEncoderContext.e(m.e, (Object)ex.b());
            objectEncoderContext.c(m.f, ex.d());
        }
    }
    
    private static final class n implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Signal>
    {
        static final n a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        private static final FieldDescriptor d;
        
        static {
            a = new n();
            b = FieldDescriptor.d("name");
            c = FieldDescriptor.d("code");
            d = FieldDescriptor.d("address");
        }
        
        public /* bridge */ void a(final Object o, final Object o2) throws IOException {
            this.b((CrashlyticsReport.Session.Event.Application.Execution.Signal)o, (ObjectEncoderContext)o2);
        }
        
        public void b(final CrashlyticsReport.Session.Event.Application.Execution.Signal signal, final ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.e(n.b, (Object)signal.d());
            objectEncoderContext.e(n.c, (Object)signal.c());
            objectEncoderContext.b(n.d, signal.b());
        }
    }
    
    private static final class o implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Thread>
    {
        static final o a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        private static final FieldDescriptor d;
        
        static {
            a = new o();
            b = FieldDescriptor.d("name");
            c = FieldDescriptor.d("importance");
            d = FieldDescriptor.d("frames");
        }
        
        public /* bridge */ void a(final Object o, final Object o2) throws IOException {
            this.b((CrashlyticsReport.Session.Event.Application.Execution.Thread)o, (ObjectEncoderContext)o2);
        }
        
        public void b(final CrashlyticsReport.Session.Event.Application.Execution.Thread thread, final ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.e(o.b, (Object)thread.d());
            objectEncoderContext.c(o.c, thread.c());
            objectEncoderContext.e(o.d, (Object)thread.b());
        }
    }
    
    private static final class p implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame>
    {
        static final p a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        private static final FieldDescriptor d;
        private static final FieldDescriptor e;
        private static final FieldDescriptor f;
        
        static {
            a = new p();
            b = FieldDescriptor.d("pc");
            c = FieldDescriptor.d("symbol");
            d = FieldDescriptor.d("file");
            e = FieldDescriptor.d("offset");
            f = FieldDescriptor.d("importance");
        }
        
        public /* bridge */ void a(final Object o, final Object o2) throws IOException {
            this.b((CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame)o, (ObjectEncoderContext)o2);
        }
        
        public void b(final CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame frame, final ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.b(p.b, frame.e());
            objectEncoderContext.e(p.c, (Object)frame.f());
            objectEncoderContext.e(p.d, (Object)frame.b());
            objectEncoderContext.b(p.e, frame.d());
            objectEncoderContext.c(p.f, frame.c());
        }
    }
    
    private static final class q implements ObjectEncoder<CrashlyticsReport.Session.Event.Device>
    {
        static final q a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        private static final FieldDescriptor d;
        private static final FieldDescriptor e;
        private static final FieldDescriptor f;
        private static final FieldDescriptor g;
        
        static {
            a = new q();
            b = FieldDescriptor.d("batteryLevel");
            c = FieldDescriptor.d("batteryVelocity");
            d = FieldDescriptor.d("proximityOn");
            e = FieldDescriptor.d("orientation");
            f = FieldDescriptor.d("ramUsed");
            g = FieldDescriptor.d("diskUsed");
        }
        
        public /* bridge */ void a(final Object o, final Object o2) throws IOException {
            this.b((CrashlyticsReport.Session.Event.Device)o, (ObjectEncoderContext)o2);
        }
        
        public void b(final CrashlyticsReport.Session.Event.Device device, final ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.e(q.b, (Object)device.b());
            objectEncoderContext.c(q.c, device.c());
            objectEncoderContext.a(q.d, device.g());
            objectEncoderContext.c(q.e, device.e());
            objectEncoderContext.b(q.f, device.f());
            objectEncoderContext.b(q.g, device.d());
        }
    }
    
    private static final class r implements ObjectEncoder<CrashlyticsReport.Session.Event>
    {
        static final r a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        private static final FieldDescriptor d;
        private static final FieldDescriptor e;
        private static final FieldDescriptor f;
        
        static {
            a = new r();
            b = FieldDescriptor.d("timestamp");
            c = FieldDescriptor.d("type");
            d = FieldDescriptor.d("app");
            e = FieldDescriptor.d("device");
            f = FieldDescriptor.d("log");
        }
        
        public /* bridge */ void a(final Object o, final Object o2) throws IOException {
            this.b((CrashlyticsReport.Session.Event)o, (ObjectEncoderContext)o2);
        }
        
        public void b(final CrashlyticsReport.Session.Event event, final ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.b(r.b, event.e());
            objectEncoderContext.e(r.c, (Object)event.f());
            objectEncoderContext.e(r.d, (Object)event.b());
            objectEncoderContext.e(r.e, (Object)event.c());
            objectEncoderContext.e(r.f, (Object)event.d());
        }
    }
    
    private static final class s implements ObjectEncoder<CrashlyticsReport.Session.Event.Log>
    {
        static final s a;
        private static final FieldDescriptor b;
        
        static {
            a = new s();
            b = FieldDescriptor.d("content");
        }
        
        public /* bridge */ void a(final Object o, final Object o2) throws IOException {
            this.b((CrashlyticsReport.Session.Event.Log)o, (ObjectEncoderContext)o2);
        }
        
        public void b(final CrashlyticsReport.Session.Event.Log log, final ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.e(s.b, (Object)log.b());
        }
    }
    
    private static final class t implements ObjectEncoder<CrashlyticsReport.Session.OperatingSystem>
    {
        static final t a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        private static final FieldDescriptor d;
        private static final FieldDescriptor e;
        
        static {
            a = new t();
            b = FieldDescriptor.d("platform");
            c = FieldDescriptor.d("version");
            d = FieldDescriptor.d("buildVersion");
            e = FieldDescriptor.d("jailbroken");
        }
        
        public /* bridge */ void a(final Object o, final Object o2) throws IOException {
            this.b((CrashlyticsReport.Session.OperatingSystem)o, (ObjectEncoderContext)o2);
        }
        
        public void b(final CrashlyticsReport.Session.OperatingSystem operatingSystem, final ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.c(t.b, operatingSystem.c());
            objectEncoderContext.e(t.c, (Object)operatingSystem.d());
            objectEncoderContext.e(t.d, (Object)operatingSystem.b());
            objectEncoderContext.a(t.e, operatingSystem.e());
        }
    }
    
    private static final class u implements ObjectEncoder<CrashlyticsReport.Session.User>
    {
        static final u a;
        private static final FieldDescriptor b;
        
        static {
            a = new u();
            b = FieldDescriptor.d("identifier");
        }
        
        public /* bridge */ void a(final Object o, final Object o2) throws IOException {
            this.b((CrashlyticsReport.Session.User)o, (ObjectEncoderContext)o2);
        }
        
        public void b(final CrashlyticsReport.Session.User user, final ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.e(u.b, (Object)user.b());
        }
    }
}

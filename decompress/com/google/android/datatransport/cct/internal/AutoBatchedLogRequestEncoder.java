// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.cct.internal;

import java.io.IOException;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.encoders.config.Configurator;

public final class AutoBatchedLogRequestEncoder implements Configurator
{
    public static final Configurator a;
    
    static {
        a = (Configurator)new AutoBatchedLogRequestEncoder();
    }
    
    private AutoBatchedLogRequestEncoder() {
    }
    
    public void a(final EncoderConfig<?> encoderConfig) {
        final b a = b.a;
        encoderConfig.a((Class)BatchedLogRequest.class, (ObjectEncoder)a);
        encoderConfig.a((Class)com.google.android.datatransport.cct.internal.b.class, (ObjectEncoder)a);
        final e a2 = e.a;
        encoderConfig.a((Class)LogRequest.class, (ObjectEncoder)a2);
        encoderConfig.a((Class)com.google.android.datatransport.cct.internal.e.class, (ObjectEncoder)a2);
        final c a3 = c.a;
        encoderConfig.a((Class)ClientInfo.class, (ObjectEncoder)a3);
        encoderConfig.a((Class)com.google.android.datatransport.cct.internal.c.class, (ObjectEncoder)a3);
        final a a4 = AutoBatchedLogRequestEncoder.a.a;
        encoderConfig.a((Class)AndroidClientInfo.class, (ObjectEncoder)a4);
        encoderConfig.a((Class)com.google.android.datatransport.cct.internal.a.class, (ObjectEncoder)a4);
        final d a5 = d.a;
        encoderConfig.a((Class)LogEvent.class, (ObjectEncoder)a5);
        encoderConfig.a((Class)com.google.android.datatransport.cct.internal.d.class, (ObjectEncoder)a5);
        final f a6 = f.a;
        encoderConfig.a((Class)NetworkConnectionInfo.class, (ObjectEncoder)a6);
        encoderConfig.a((Class)g.class, (ObjectEncoder)a6);
    }
    
    private static final class a implements ObjectEncoder<AndroidClientInfo>
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
        private static final FieldDescriptor j;
        private static final FieldDescriptor k;
        private static final FieldDescriptor l;
        private static final FieldDescriptor m;
        
        static {
            a = new a();
            b = FieldDescriptor.d("sdkVersion");
            c = FieldDescriptor.d("model");
            d = FieldDescriptor.d("hardware");
            e = FieldDescriptor.d("device");
            f = FieldDescriptor.d("product");
            g = FieldDescriptor.d("osBuild");
            h = FieldDescriptor.d("manufacturer");
            i = FieldDescriptor.d("fingerprint");
            j = FieldDescriptor.d("locale");
            k = FieldDescriptor.d("country");
            l = FieldDescriptor.d("mccMnc");
            m = FieldDescriptor.d("applicationBuild");
        }
        
        public /* bridge */ void a(final Object o, final Object o2) throws IOException {
            this.b((AndroidClientInfo)o, (ObjectEncoderContext)o2);
        }
        
        public void b(final AndroidClientInfo androidClientInfo, final ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.e(AutoBatchedLogRequestEncoder.a.b, (Object)androidClientInfo.m());
            objectEncoderContext.e(AutoBatchedLogRequestEncoder.a.c, (Object)androidClientInfo.j());
            objectEncoderContext.e(AutoBatchedLogRequestEncoder.a.d, (Object)androidClientInfo.f());
            objectEncoderContext.e(AutoBatchedLogRequestEncoder.a.e, (Object)androidClientInfo.d());
            objectEncoderContext.e(AutoBatchedLogRequestEncoder.a.f, (Object)androidClientInfo.l());
            objectEncoderContext.e(AutoBatchedLogRequestEncoder.a.g, (Object)androidClientInfo.k());
            objectEncoderContext.e(AutoBatchedLogRequestEncoder.a.h, (Object)androidClientInfo.h());
            objectEncoderContext.e(AutoBatchedLogRequestEncoder.a.i, (Object)androidClientInfo.e());
            objectEncoderContext.e(AutoBatchedLogRequestEncoder.a.j, (Object)androidClientInfo.g());
            objectEncoderContext.e(AutoBatchedLogRequestEncoder.a.k, (Object)androidClientInfo.c());
            objectEncoderContext.e(AutoBatchedLogRequestEncoder.a.l, (Object)androidClientInfo.i());
            objectEncoderContext.e(AutoBatchedLogRequestEncoder.a.m, (Object)androidClientInfo.b());
        }
    }
    
    private static final class b implements ObjectEncoder<BatchedLogRequest>
    {
        static final b a;
        private static final FieldDescriptor b;
        
        static {
            a = new b();
            b = FieldDescriptor.d("logRequest");
        }
        
        public /* bridge */ void a(final Object o, final Object o2) throws IOException {
            this.b((BatchedLogRequest)o, (ObjectEncoderContext)o2);
        }
        
        public void b(final BatchedLogRequest batchedLogRequest, final ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.e(AutoBatchedLogRequestEncoder.b.b, (Object)batchedLogRequest.c());
        }
    }
    
    private static final class c implements ObjectEncoder<ClientInfo>
    {
        static final c a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        
        static {
            a = new c();
            b = FieldDescriptor.d("clientType");
            c = FieldDescriptor.d("androidClientInfo");
        }
        
        public /* bridge */ void a(final Object o, final Object o2) throws IOException {
            this.b((ClientInfo)o, (ObjectEncoderContext)o2);
        }
        
        public void b(final ClientInfo clientInfo, final ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.e(AutoBatchedLogRequestEncoder.c.b, (Object)clientInfo.c());
            objectEncoderContext.e(AutoBatchedLogRequestEncoder.c.c, (Object)clientInfo.b());
        }
    }
    
    private static final class d implements ObjectEncoder<LogEvent>
    {
        static final d a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        private static final FieldDescriptor d;
        private static final FieldDescriptor e;
        private static final FieldDescriptor f;
        private static final FieldDescriptor g;
        private static final FieldDescriptor h;
        
        static {
            a = new d();
            b = FieldDescriptor.d("eventTimeMs");
            c = FieldDescriptor.d("eventCode");
            d = FieldDescriptor.d("eventUptimeMs");
            e = FieldDescriptor.d("sourceExtension");
            f = FieldDescriptor.d("sourceExtensionJsonProto3");
            g = FieldDescriptor.d("timezoneOffsetSeconds");
            h = FieldDescriptor.d("networkConnectionInfo");
        }
        
        public /* bridge */ void a(final Object o, final Object o2) throws IOException {
            this.b((LogEvent)o, (ObjectEncoderContext)o2);
        }
        
        public void b(final LogEvent logEvent, final ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.b(AutoBatchedLogRequestEncoder.d.b, logEvent.c());
            objectEncoderContext.e(AutoBatchedLogRequestEncoder.d.c, (Object)logEvent.b());
            objectEncoderContext.b(AutoBatchedLogRequestEncoder.d.d, logEvent.d());
            objectEncoderContext.e(AutoBatchedLogRequestEncoder.d.e, (Object)logEvent.f());
            objectEncoderContext.e(AutoBatchedLogRequestEncoder.d.f, (Object)logEvent.g());
            objectEncoderContext.b(AutoBatchedLogRequestEncoder.d.g, logEvent.h());
            objectEncoderContext.e(AutoBatchedLogRequestEncoder.d.h, (Object)logEvent.e());
        }
    }
    
    private static final class e implements ObjectEncoder<LogRequest>
    {
        static final e a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        private static final FieldDescriptor d;
        private static final FieldDescriptor e;
        private static final FieldDescriptor f;
        private static final FieldDescriptor g;
        private static final FieldDescriptor h;
        
        static {
            a = new e();
            b = FieldDescriptor.d("requestTimeMs");
            c = FieldDescriptor.d("requestUptimeMs");
            d = FieldDescriptor.d("clientInfo");
            e = FieldDescriptor.d("logSource");
            f = FieldDescriptor.d("logSourceName");
            g = FieldDescriptor.d("logEvent");
            h = FieldDescriptor.d("qosTier");
        }
        
        public /* bridge */ void a(final Object o, final Object o2) throws IOException {
            this.b((LogRequest)o, (ObjectEncoderContext)o2);
        }
        
        public void b(final LogRequest logRequest, final ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.b(AutoBatchedLogRequestEncoder.e.b, logRequest.g());
            objectEncoderContext.b(AutoBatchedLogRequestEncoder.e.c, logRequest.h());
            objectEncoderContext.e(AutoBatchedLogRequestEncoder.e.d, (Object)logRequest.b());
            objectEncoderContext.e(AutoBatchedLogRequestEncoder.e.e, (Object)logRequest.d());
            objectEncoderContext.e(AutoBatchedLogRequestEncoder.e.f, (Object)logRequest.e());
            objectEncoderContext.e(AutoBatchedLogRequestEncoder.e.g, (Object)logRequest.c());
            objectEncoderContext.e(AutoBatchedLogRequestEncoder.e.h, (Object)logRequest.f());
        }
    }
    
    private static final class f implements ObjectEncoder<NetworkConnectionInfo>
    {
        static final f a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        
        static {
            a = new f();
            b = FieldDescriptor.d("networkType");
            c = FieldDescriptor.d("mobileSubtype");
        }
        
        public /* bridge */ void a(final Object o, final Object o2) throws IOException {
            this.b((NetworkConnectionInfo)o, (ObjectEncoderContext)o2);
        }
        
        public void b(final NetworkConnectionInfo networkConnectionInfo, final ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.e(f.b, (Object)networkConnectionInfo.c());
            objectEncoderContext.e(f.c, (Object)networkConnectionInfo.b());
        }
    }
}

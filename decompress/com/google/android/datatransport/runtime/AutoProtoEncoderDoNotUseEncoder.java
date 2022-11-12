// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.datatransport.runtime;

import java.io.IOException;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.lang.annotation.Annotation;
import com.google.firebase.encoders.proto.AtProtobuf;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.android.datatransport.runtime.firebase.transport.StorageMetrics;
import com.google.android.datatransport.runtime.firebase.transport.GlobalMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.firebase.transport.LogSourceMetrics;
import com.google.android.datatransport.runtime.firebase.transport.TimeWindow;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.encoders.config.Configurator;

public final class AutoProtoEncoderDoNotUseEncoder implements Configurator
{
    public static final Configurator a;
    
    static {
        a = (Configurator)new AutoProtoEncoderDoNotUseEncoder();
    }
    
    private AutoProtoEncoderDoNotUseEncoder() {
    }
    
    public void a(final EncoderConfig<?> encoderConfig) {
        encoderConfig.a((Class)ProtoEncoderDoNotUse.class, (ObjectEncoder)e.a);
        encoderConfig.a((Class)ClientMetrics.class, (ObjectEncoder)AutoProtoEncoderDoNotUseEncoder.a.a);
        encoderConfig.a((Class)TimeWindow.class, (ObjectEncoder)g.a);
        encoderConfig.a((Class)LogSourceMetrics.class, (ObjectEncoder)d.a);
        encoderConfig.a((Class)LogEventDropped.class, (ObjectEncoder)c.a);
        encoderConfig.a((Class)GlobalMetrics.class, (ObjectEncoder)b.a);
        encoderConfig.a((Class)StorageMetrics.class, (ObjectEncoder)f.a);
    }
    
    private static final class a implements ObjectEncoder<ClientMetrics>
    {
        static final a a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        private static final FieldDescriptor d;
        private static final FieldDescriptor e;
        
        static {
            a = new a();
            b = FieldDescriptor.a("window").b((Annotation)AtProtobuf.b().c(1).a()).a();
            c = FieldDescriptor.a("logSourceMetrics").b((Annotation)AtProtobuf.b().c(2).a()).a();
            d = FieldDescriptor.a("globalMetrics").b((Annotation)AtProtobuf.b().c(3).a()).a();
            e = FieldDescriptor.a("appNamespace").b((Annotation)AtProtobuf.b().c(4).a()).a();
        }
        
        public /* bridge */ void a(final Object o, final Object o2) throws IOException {
            this.b((ClientMetrics)o, (ObjectEncoderContext)o2);
        }
        
        public void b(final ClientMetrics clientMetrics, final ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.e(AutoProtoEncoderDoNotUseEncoder.a.b, (Object)clientMetrics.d());
            objectEncoderContext.e(AutoProtoEncoderDoNotUseEncoder.a.c, (Object)clientMetrics.c());
            objectEncoderContext.e(AutoProtoEncoderDoNotUseEncoder.a.d, (Object)clientMetrics.b());
            objectEncoderContext.e(AutoProtoEncoderDoNotUseEncoder.a.e, (Object)clientMetrics.a());
        }
    }
    
    private static final class b implements ObjectEncoder<GlobalMetrics>
    {
        static final b a;
        private static final FieldDescriptor b;
        
        static {
            a = new b();
            b = FieldDescriptor.a("storageMetrics").b((Annotation)AtProtobuf.b().c(1).a()).a();
        }
        
        public /* bridge */ void a(final Object o, final Object o2) throws IOException {
            this.b((GlobalMetrics)o, (ObjectEncoderContext)o2);
        }
        
        public void b(final GlobalMetrics globalMetrics, final ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.e(AutoProtoEncoderDoNotUseEncoder.b.b, (Object)globalMetrics.a());
        }
    }
    
    private static final class c implements ObjectEncoder<LogEventDropped>
    {
        static final c a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        
        static {
            a = new c();
            b = FieldDescriptor.a("eventsDroppedCount").b((Annotation)AtProtobuf.b().c(1).a()).a();
            c = FieldDescriptor.a("reason").b((Annotation)AtProtobuf.b().c(3).a()).a();
        }
        
        public /* bridge */ void a(final Object o, final Object o2) throws IOException {
            this.b((LogEventDropped)o, (ObjectEncoderContext)o2);
        }
        
        public void b(final LogEventDropped logEventDropped, final ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.b(AutoProtoEncoderDoNotUseEncoder.c.b, logEventDropped.a());
            objectEncoderContext.e(AutoProtoEncoderDoNotUseEncoder.c.c, (Object)logEventDropped.b());
        }
    }
    
    private static final class d implements ObjectEncoder<LogSourceMetrics>
    {
        static final d a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        
        static {
            a = new d();
            b = FieldDescriptor.a("logSource").b((Annotation)AtProtobuf.b().c(1).a()).a();
            c = FieldDescriptor.a("logEventDropped").b((Annotation)AtProtobuf.b().c(2).a()).a();
        }
        
        public /* bridge */ void a(final Object o, final Object o2) throws IOException {
            this.b((LogSourceMetrics)o, (ObjectEncoderContext)o2);
        }
        
        public void b(final LogSourceMetrics logSourceMetrics, final ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.e(d.b, (Object)logSourceMetrics.b());
            objectEncoderContext.e(d.c, (Object)logSourceMetrics.a());
        }
    }
    
    private static final class e implements ObjectEncoder<ProtoEncoderDoNotUse>
    {
        static final e a;
        private static final FieldDescriptor b;
        
        static {
            a = new e();
            b = FieldDescriptor.d("clientMetrics");
        }
        
        public /* bridge */ void a(final Object o, final Object o2) throws IOException {
            this.b((ProtoEncoderDoNotUse)o, (ObjectEncoderContext)o2);
        }
        
        public void b(final ProtoEncoderDoNotUse protoEncoderDoNotUse, final ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.e(e.b, (Object)protoEncoderDoNotUse.b());
        }
    }
    
    private static final class f implements ObjectEncoder<StorageMetrics>
    {
        static final f a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        
        static {
            a = new f();
            b = FieldDescriptor.a("currentCacheSizeBytes").b((Annotation)AtProtobuf.b().c(1).a()).a();
            c = FieldDescriptor.a("maxCacheSizeBytes").b((Annotation)AtProtobuf.b().c(2).a()).a();
        }
        
        public /* bridge */ void a(final Object o, final Object o2) throws IOException {
            this.b((StorageMetrics)o, (ObjectEncoderContext)o2);
        }
        
        public void b(final StorageMetrics storageMetrics, final ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.b(f.b, storageMetrics.a());
            objectEncoderContext.b(f.c, storageMetrics.b());
        }
    }
    
    private static final class g implements ObjectEncoder<TimeWindow>
    {
        static final g a;
        private static final FieldDescriptor b;
        private static final FieldDescriptor c;
        
        static {
            a = new g();
            b = FieldDescriptor.a("startMs").b((Annotation)AtProtobuf.b().c(1).a()).a();
            c = FieldDescriptor.a("endMs").b((Annotation)AtProtobuf.b().c(2).a()).a();
        }
        
        public /* bridge */ void a(final Object o, final Object o2) throws IOException {
            this.b((TimeWindow)o, (ObjectEncoderContext)o2);
        }
        
        public void b(final TimeWindow timeWindow, final ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.b(g.b, timeWindow.b());
            objectEncoderContext.b(g.c, timeWindow.a());
        }
    }
}

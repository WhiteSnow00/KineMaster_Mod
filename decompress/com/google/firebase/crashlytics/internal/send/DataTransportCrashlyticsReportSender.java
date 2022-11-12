// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.send;

import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import java.nio.charset.Charset;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.Destination;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.firebase.crashlytics.internal.common.OnDemandCounter;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import android.content.Context;
import n4.a;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.android.datatransport.Transformer;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;

public class DataTransportCrashlyticsReportSender
{
    private static final CrashlyticsReportJsonTransform c;
    private static final String d;
    private static final String e;
    private static final Transformer<CrashlyticsReport, byte[]> f;
    private final b a;
    private final Transformer<CrashlyticsReport, byte[]> b;
    
    static {
        c = new CrashlyticsReportJsonTransform();
        d = e("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");
        e = e("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");
        f = (Transformer)a.a;
    }
    
    DataTransportCrashlyticsReportSender(final b a, final Transformer<CrashlyticsReport, byte[]> b) {
        this.a = a;
        this.b = b;
    }
    
    public static byte[] a(final CrashlyticsReport crashlyticsReport) {
        return d(crashlyticsReport);
    }
    
    public static DataTransportCrashlyticsReportSender b(final Context context, final SettingsProvider settingsProvider, final OnDemandCounter onDemandCounter) {
        TransportRuntime.f(context);
        final TransportFactory g = TransportRuntime.c().g(new CCTDestination(DataTransportCrashlyticsReportSender.d, DataTransportCrashlyticsReportSender.e));
        final Encoding b = Encoding.b("json");
        final Transformer<CrashlyticsReport, byte[]> f = DataTransportCrashlyticsReportSender.f;
        return new DataTransportCrashlyticsReportSender(new b(g.b("FIREBASE_CRASHLYTICS_REPORT", CrashlyticsReport.class, b, f), settingsProvider.b(), onDemandCounter), f);
    }
    
    private static byte[] d(final CrashlyticsReport crashlyticsReport) {
        return DataTransportCrashlyticsReportSender.c.E(crashlyticsReport).getBytes(Charset.forName("UTF-8"));
    }
    
    private static String e(final String s, final String s2) {
        final int n = s.length() - s2.length();
        if (n >= 0 && n <= 1) {
            final StringBuilder sb = new StringBuilder(s.length() + s2.length());
            for (int i = 0; i < s.length(); ++i) {
                sb.append(s.charAt(i));
                if (s2.length() > i) {
                    sb.append(s2.charAt(i));
                }
            }
            return sb.toString();
        }
        throw new IllegalArgumentException("Invalid input received");
    }
    
    public Task<CrashlyticsReportWithSessionId> c(final CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, final boolean b) {
        return (Task<CrashlyticsReportWithSessionId>)this.a.h(crashlyticsReportWithSessionId, b).a();
    }
}

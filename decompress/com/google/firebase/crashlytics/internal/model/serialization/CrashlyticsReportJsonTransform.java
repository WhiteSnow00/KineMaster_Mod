// 
// Decompiled by Procyon v0.6.0
// 

package com.google.firebase.crashlytics.internal.model.serialization;

import java.io.Reader;
import java.io.StringReader;
import java.util.List;
import java.util.ArrayList;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import android.util.Base64;
import java.io.IOException;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import com.google.firebase.encoders.DataEncoder;

public class CrashlyticsReportJsonTransform
{
    private static final DataEncoder a;
    
    static {
        a = new JsonDataEncoderBuilder().j(AutoCrashlyticsReportEncoder.a).k(true).i();
    }
    
    private static CrashlyticsReport A(final JsonReader jsonReader) throws IOException {
        final CrashlyticsReport.Builder b = CrashlyticsReport.b();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            final String nextName = jsonReader.nextName();
            nextName.hashCode();
            int n = -1;
            switch (nextName) {
                case "session": {
                    n = 7;
                    break;
                }
                case "displayVersion": {
                    n = 6;
                    break;
                }
                case "platform": {
                    n = 5;
                    break;
                }
                case "installationUuid": {
                    n = 4;
                    break;
                }
                case "gmpAppId": {
                    n = 3;
                    break;
                }
                case "buildVersion": {
                    n = 2;
                    break;
                }
                case "sdkVersion": {
                    n = 1;
                    break;
                }
                case "ndkPayload": {
                    n = 0;
                    break;
                }
                default:
                    break;
            }
            switch (n) {
                default: {
                    jsonReader.skipValue();
                    continue;
                }
                case 7: {
                    b.i(B(jsonReader));
                    continue;
                }
                case 6: {
                    b.c(jsonReader.nextString());
                    continue;
                }
                case 5: {
                    b.g(jsonReader.nextInt());
                    continue;
                }
                case 4: {
                    b.e(jsonReader.nextString());
                    continue;
                }
                case 3: {
                    b.d(jsonReader.nextString());
                    continue;
                }
                case 2: {
                    b.b(jsonReader.nextString());
                    continue;
                }
                case 1: {
                    b.h(jsonReader.nextString());
                    continue;
                }
                case 0: {
                    b.f(y(jsonReader));
                    continue;
                }
            }
        }
        jsonReader.endObject();
        return b.a();
    }
    
    private static CrashlyticsReport.Session B(final JsonReader jsonReader) throws IOException {
        final CrashlyticsReport.Session.Builder a = CrashlyticsReport.Session.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            final String nextName = jsonReader.nextName();
            nextName.hashCode();
            int n = -1;
            switch (nextName) {
                case "generatorType": {
                    n = 10;
                    break;
                }
                case "crashed": {
                    n = 9;
                    break;
                }
                case "generator": {
                    n = 8;
                    break;
                }
                case "user": {
                    n = 7;
                    break;
                }
                case "app": {
                    n = 6;
                    break;
                }
                case "os": {
                    n = 5;
                    break;
                }
                case "events": {
                    n = 4;
                    break;
                }
                case "device": {
                    n = 3;
                    break;
                }
                case "endedAt": {
                    n = 2;
                    break;
                }
                case "identifier": {
                    n = 1;
                    break;
                }
                case "startedAt": {
                    n = 0;
                    break;
                }
                default:
                    break;
            }
            switch (n) {
                default: {
                    jsonReader.skipValue();
                    continue;
                }
                case 10: {
                    a.h(jsonReader.nextInt());
                    continue;
                }
                case 9: {
                    a.c(jsonReader.nextBoolean());
                    continue;
                }
                case 8: {
                    a.g(jsonReader.nextString());
                    continue;
                }
                case 7: {
                    a.m(C(jsonReader));
                    continue;
                }
                case 6: {
                    a.b(i(jsonReader));
                    continue;
                }
                case 5: {
                    a.k(z(jsonReader));
                    continue;
                }
                case 4: {
                    a.f(k(jsonReader, (a<CrashlyticsReport.Session.Event>)com.google.firebase.crashlytics.internal.model.serialization.a.a));
                    continue;
                }
                case 3: {
                    a.d(m(jsonReader));
                    continue;
                }
                case 2: {
                    a.e(jsonReader.nextLong());
                    continue;
                }
                case 1: {
                    a.j(Base64.decode(jsonReader.nextString(), 2));
                    continue;
                }
                case 0: {
                    a.l(jsonReader.nextLong());
                    continue;
                }
            }
        }
        jsonReader.endObject();
        return a.a();
    }
    
    private static CrashlyticsReport.Session.User C(final JsonReader jsonReader) throws IOException {
        final CrashlyticsReport.Session.User.Builder a = CrashlyticsReport.Session.User.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            final String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (!nextName.equals("identifier")) {
                jsonReader.skipValue();
            }
            else {
                a.b(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return a.a();
    }
    
    public static CrashlyticsReport.Session.Event a(final JsonReader jsonReader) {
        return n(jsonReader);
    }
    
    public static CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame b(final JsonReader jsonReader) {
        return t(jsonReader);
    }
    
    public static CrashlyticsReport.Session.Event.Application.Execution.Thread c(final JsonReader jsonReader) {
        return w(jsonReader);
    }
    
    public static CrashlyticsReport.FilesPayload.File d(final JsonReader jsonReader) {
        return x(jsonReader);
    }
    
    public static CrashlyticsReport.Session.Event.Application.Execution.BinaryImage e(final JsonReader jsonReader) {
        return p(jsonReader);
    }
    
    public static CrashlyticsReport.CustomAttribute f(final JsonReader jsonReader) {
        return l(jsonReader);
    }
    
    private static CrashlyticsReport.Session.Application i(final JsonReader jsonReader) throws IOException {
        final CrashlyticsReport.Session.Application.Builder a = CrashlyticsReport.Session.Application.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            final String nextName = jsonReader.nextName();
            nextName.hashCode();
            int n = -1;
            switch (nextName) {
                case "displayVersion": {
                    n = 5;
                    break;
                }
                case "installationUuid": {
                    n = 4;
                    break;
                }
                case "version": {
                    n = 3;
                    break;
                }
                case "developmentPlatformVersion": {
                    n = 2;
                    break;
                }
                case "developmentPlatform": {
                    n = 1;
                    break;
                }
                case "identifier": {
                    n = 0;
                    break;
                }
                default:
                    break;
            }
            switch (n) {
                default: {
                    jsonReader.skipValue();
                    continue;
                }
                case 5: {
                    a.d(jsonReader.nextString());
                    continue;
                }
                case 4: {
                    a.f(jsonReader.nextString());
                    continue;
                }
                case 3: {
                    a.g(jsonReader.nextString());
                    continue;
                }
                case 2: {
                    a.c(jsonReader.nextString());
                    continue;
                }
                case 1: {
                    a.b(jsonReader.nextString());
                    continue;
                }
                case 0: {
                    a.e(jsonReader.nextString());
                    continue;
                }
            }
        }
        jsonReader.endObject();
        return a.a();
    }
    
    private static CrashlyticsReport.ApplicationExitInfo j(final JsonReader jsonReader) throws IOException {
        final CrashlyticsReport.ApplicationExitInfo.Builder a = CrashlyticsReport.ApplicationExitInfo.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            final String nextName = jsonReader.nextName();
            nextName.hashCode();
            int n = -1;
            switch (nextName) {
                case "importance": {
                    n = 7;
                    break;
                }
                case "traceFile": {
                    n = 6;
                    break;
                }
                case "reasonCode": {
                    n = 5;
                    break;
                }
                case "processName": {
                    n = 4;
                    break;
                }
                case "timestamp": {
                    n = 3;
                    break;
                }
                case "rss": {
                    n = 2;
                    break;
                }
                case "pss": {
                    n = 1;
                    break;
                }
                case "pid": {
                    n = 0;
                    break;
                }
                default:
                    break;
            }
            switch (n) {
                default: {
                    jsonReader.skipValue();
                    continue;
                }
                case 7: {
                    a.b(jsonReader.nextInt());
                    continue;
                }
                case 6: {
                    a.i(jsonReader.nextString());
                    continue;
                }
                case 5: {
                    a.f(jsonReader.nextInt());
                    continue;
                }
                case 4: {
                    a.d(jsonReader.nextString());
                    continue;
                }
                case 3: {
                    a.h(jsonReader.nextLong());
                    continue;
                }
                case 2: {
                    a.g(jsonReader.nextLong());
                    continue;
                }
                case 1: {
                    a.e(jsonReader.nextLong());
                    continue;
                }
                case 0: {
                    a.c(jsonReader.nextInt());
                    continue;
                }
            }
        }
        jsonReader.endObject();
        return a.a();
    }
    
    private static <T> ImmutableList<T> k(final JsonReader jsonReader, final a<T> a) throws IOException {
        final ArrayList list = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            list.add(a.a(jsonReader));
        }
        jsonReader.endArray();
        return ImmutableList.a((List<T>)list);
    }
    
    private static CrashlyticsReport.CustomAttribute l(final JsonReader jsonReader) throws IOException {
        final CrashlyticsReport.CustomAttribute.Builder a = CrashlyticsReport.CustomAttribute.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            final String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (!nextName.equals("key")) {
                if (!nextName.equals("value")) {
                    jsonReader.skipValue();
                }
                else {
                    a.c(jsonReader.nextString());
                }
            }
            else {
                a.b(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return a.a();
    }
    
    private static CrashlyticsReport.Session.Device m(final JsonReader jsonReader) throws IOException {
        final CrashlyticsReport.Session.Device.Builder a = CrashlyticsReport.Session.Device.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            final String nextName = jsonReader.nextName();
            nextName.hashCode();
            int n = -1;
            switch (nextName) {
                case "modelClass": {
                    n = 8;
                    break;
                }
                case "state": {
                    n = 7;
                    break;
                }
                case "model": {
                    n = 6;
                    break;
                }
                case "cores": {
                    n = 5;
                    break;
                }
                case "diskSpace": {
                    n = 4;
                    break;
                }
                case "arch": {
                    n = 3;
                    break;
                }
                case "ram": {
                    n = 2;
                    break;
                }
                case "manufacturer": {
                    n = 1;
                    break;
                }
                case "simulator": {
                    n = 0;
                    break;
                }
                default:
                    break;
            }
            switch (n) {
                default: {
                    jsonReader.skipValue();
                    continue;
                }
                case 8: {
                    a.g(jsonReader.nextString());
                    continue;
                }
                case 7: {
                    a.j(jsonReader.nextInt());
                    continue;
                }
                case 6: {
                    a.f(jsonReader.nextString());
                    continue;
                }
                case 5: {
                    a.c(jsonReader.nextInt());
                    continue;
                }
                case 4: {
                    a.d(jsonReader.nextLong());
                    continue;
                }
                case 3: {
                    a.b(jsonReader.nextInt());
                    continue;
                }
                case 2: {
                    a.h(jsonReader.nextLong());
                    continue;
                }
                case 1: {
                    a.e(jsonReader.nextString());
                    continue;
                }
                case 0: {
                    a.i(jsonReader.nextBoolean());
                    continue;
                }
            }
        }
        jsonReader.endObject();
        return a.a();
    }
    
    private static CrashlyticsReport.Session.Event n(final JsonReader jsonReader) throws IOException {
        final CrashlyticsReport.Session.Event.Builder a = CrashlyticsReport.Session.Event.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            final String nextName = jsonReader.nextName();
            nextName.hashCode();
            int n = -1;
            switch (nextName) {
                case "timestamp": {
                    n = 4;
                    break;
                }
                case "type": {
                    n = 3;
                    break;
                }
                case "log": {
                    n = 2;
                    break;
                }
                case "app": {
                    n = 1;
                    break;
                }
                case "device": {
                    n = 0;
                    break;
                }
                default:
                    break;
            }
            switch (n) {
                default: {
                    jsonReader.skipValue();
                    continue;
                }
                case 4: {
                    a.e(jsonReader.nextLong());
                    continue;
                }
                case 3: {
                    a.f(jsonReader.nextString());
                    continue;
                }
                case 2: {
                    a.d(u(jsonReader));
                    continue;
                }
                case 1: {
                    a.b(o(jsonReader));
                    continue;
                }
                case 0: {
                    a.c(q(jsonReader));
                    continue;
                }
            }
        }
        jsonReader.endObject();
        return a.a();
    }
    
    private static CrashlyticsReport.Session.Event.Application o(final JsonReader jsonReader) throws IOException {
        final CrashlyticsReport.Session.Event.Application.Builder a = CrashlyticsReport.Session.Event.Application.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            final String nextName = jsonReader.nextName();
            nextName.hashCode();
            int n = -1;
            switch (nextName) {
                case "uiOrientation": {
                    n = 4;
                    break;
                }
                case "customAttributes": {
                    n = 3;
                    break;
                }
                case "internalKeys": {
                    n = 2;
                    break;
                }
                case "execution": {
                    n = 1;
                    break;
                }
                case "background": {
                    n = 0;
                    break;
                }
                default:
                    break;
            }
            switch (n) {
                default: {
                    jsonReader.skipValue();
                    continue;
                }
                case 4: {
                    a.f(jsonReader.nextInt());
                    continue;
                }
                case 3: {
                    a.c(k(jsonReader, (a<CrashlyticsReport.CustomAttribute>)f.a));
                    continue;
                }
                case 2: {
                    a.e(k(jsonReader, (a<CrashlyticsReport.CustomAttribute>)f.a));
                    continue;
                }
                case 1: {
                    a.d(r(jsonReader));
                    continue;
                }
                case 0: {
                    a.b(jsonReader.nextBoolean());
                    continue;
                }
            }
        }
        jsonReader.endObject();
        return a.a();
    }
    
    private static CrashlyticsReport.Session.Event.Application.Execution.BinaryImage p(final JsonReader jsonReader) throws IOException {
        final CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder a = CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            final String nextName = jsonReader.nextName();
            nextName.hashCode();
            int n = -1;
            switch (nextName) {
                case "baseAddress": {
                    n = 3;
                    break;
                }
                case "uuid": {
                    n = 2;
                    break;
                }
                case "size": {
                    n = 1;
                    break;
                }
                case "name": {
                    n = 0;
                    break;
                }
                default:
                    break;
            }
            switch (n) {
                default: {
                    jsonReader.skipValue();
                    continue;
                }
                case 3: {
                    a.b(jsonReader.nextLong());
                    continue;
                }
                case 2: {
                    a.f(Base64.decode(jsonReader.nextString(), 2));
                    continue;
                }
                case 1: {
                    a.d(jsonReader.nextLong());
                    continue;
                }
                case 0: {
                    a.c(jsonReader.nextString());
                    continue;
                }
            }
        }
        jsonReader.endObject();
        return a.a();
    }
    
    private static CrashlyticsReport.Session.Event.Device q(final JsonReader jsonReader) throws IOException {
        final CrashlyticsReport.Session.Event.Device.Builder a = CrashlyticsReport.Session.Event.Device.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            final String nextName = jsonReader.nextName();
            nextName.hashCode();
            int n = -1;
            switch (nextName) {
                case "proximityOn": {
                    n = 5;
                    break;
                }
                case "ramUsed": {
                    n = 4;
                    break;
                }
                case "diskUsed": {
                    n = 3;
                    break;
                }
                case "orientation": {
                    n = 2;
                    break;
                }
                case "batteryVelocity": {
                    n = 1;
                    break;
                }
                case "batteryLevel": {
                    n = 0;
                    break;
                }
                default:
                    break;
            }
            switch (n) {
                default: {
                    jsonReader.skipValue();
                    continue;
                }
                case 5: {
                    a.f(jsonReader.nextBoolean());
                    continue;
                }
                case 4: {
                    a.g(jsonReader.nextLong());
                    continue;
                }
                case 3: {
                    a.d(jsonReader.nextLong());
                    continue;
                }
                case 2: {
                    a.e(jsonReader.nextInt());
                    continue;
                }
                case 1: {
                    a.c(jsonReader.nextInt());
                    continue;
                }
                case 0: {
                    a.b(jsonReader.nextDouble());
                    continue;
                }
            }
        }
        jsonReader.endObject();
        return a.a();
    }
    
    private static CrashlyticsReport.Session.Event.Application.Execution r(final JsonReader jsonReader) throws IOException {
        final CrashlyticsReport.Session.Event.Application.Execution.Builder a = CrashlyticsReport.Session.Event.Application.Execution.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            final String nextName = jsonReader.nextName();
            nextName.hashCode();
            int n = -1;
            switch (nextName) {
                case "exception": {
                    n = 4;
                    break;
                }
                case "binaries": {
                    n = 3;
                    break;
                }
                case "signal": {
                    n = 2;
                    break;
                }
                case "threads": {
                    n = 1;
                    break;
                }
                case "appExitInfo": {
                    n = 0;
                    break;
                }
                default:
                    break;
            }
            switch (n) {
                default: {
                    jsonReader.skipValue();
                    continue;
                }
                case 4: {
                    a.d(s(jsonReader));
                    continue;
                }
                case 3: {
                    a.c(k(jsonReader, (a<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage>)e.a));
                    continue;
                }
                case 2: {
                    a.e(v(jsonReader));
                    continue;
                }
                case 1: {
                    a.f(k(jsonReader, (a<CrashlyticsReport.Session.Event.Application.Execution.Thread>)c.a));
                    continue;
                }
                case 0: {
                    a.b(j(jsonReader));
                    continue;
                }
            }
        }
        jsonReader.endObject();
        return a.a();
    }
    
    private static CrashlyticsReport.Session.Event.Application.Execution.Exception s(final JsonReader jsonReader) throws IOException {
        final CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder a = CrashlyticsReport.Session.Event.Application.Execution.Exception.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            final String nextName = jsonReader.nextName();
            nextName.hashCode();
            int n = -1;
            switch (nextName) {
                case "overflowCount": {
                    n = 4;
                    break;
                }
                case "causedBy": {
                    n = 3;
                    break;
                }
                case "type": {
                    n = 2;
                    break;
                }
                case "reason": {
                    n = 1;
                    break;
                }
                case "frames": {
                    n = 0;
                    break;
                }
                default:
                    break;
            }
            switch (n) {
                default: {
                    jsonReader.skipValue();
                    continue;
                }
                case 4: {
                    a.d(jsonReader.nextInt());
                    continue;
                }
                case 3: {
                    a.b(s(jsonReader));
                    continue;
                }
                case 2: {
                    a.f(jsonReader.nextString());
                    continue;
                }
                case 1: {
                    a.e(jsonReader.nextString());
                    continue;
                }
                case 0: {
                    a.c(k(jsonReader, (a<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame>)b.a));
                    continue;
                }
            }
        }
        jsonReader.endObject();
        return a.a();
    }
    
    private static CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame t(final JsonReader jsonReader) throws IOException {
        final CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder a = CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            final String nextName = jsonReader.nextName();
            nextName.hashCode();
            int n = -1;
            switch (nextName) {
                case "importance": {
                    n = 4;
                    break;
                }
                case "file": {
                    n = 3;
                    break;
                }
                case "pc": {
                    n = 2;
                    break;
                }
                case "symbol": {
                    n = 1;
                    break;
                }
                case "offset": {
                    n = 0;
                    break;
                }
                default:
                    break;
            }
            switch (n) {
                default: {
                    jsonReader.skipValue();
                    continue;
                }
                case 4: {
                    a.c(jsonReader.nextInt());
                    continue;
                }
                case 3: {
                    a.b(jsonReader.nextString());
                    continue;
                }
                case 2: {
                    a.e(jsonReader.nextLong());
                    continue;
                }
                case 1: {
                    a.f(jsonReader.nextString());
                    continue;
                }
                case 0: {
                    a.d(jsonReader.nextLong());
                    continue;
                }
            }
        }
        jsonReader.endObject();
        return a.a();
    }
    
    private static CrashlyticsReport.Session.Event.Log u(final JsonReader jsonReader) throws IOException {
        final CrashlyticsReport.Session.Event.Log.Builder a = CrashlyticsReport.Session.Event.Log.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            final String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (!nextName.equals("content")) {
                jsonReader.skipValue();
            }
            else {
                a.b(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return a.a();
    }
    
    private static CrashlyticsReport.Session.Event.Application.Execution.Signal v(final JsonReader jsonReader) throws IOException {
        final CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder a = CrashlyticsReport.Session.Event.Application.Execution.Signal.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            final String nextName = jsonReader.nextName();
            nextName.hashCode();
            int n = -1;
            switch (nextName) {
                case "name": {
                    n = 2;
                    break;
                }
                case "code": {
                    n = 1;
                    break;
                }
                case "address": {
                    n = 0;
                    break;
                }
                default:
                    break;
            }
            switch (n) {
                default: {
                    jsonReader.skipValue();
                    continue;
                }
                case 2: {
                    a.d(jsonReader.nextString());
                    continue;
                }
                case 1: {
                    a.c(jsonReader.nextString());
                    continue;
                }
                case 0: {
                    a.b(jsonReader.nextLong());
                    continue;
                }
            }
        }
        jsonReader.endObject();
        return a.a();
    }
    
    private static CrashlyticsReport.Session.Event.Application.Execution.Thread w(final JsonReader jsonReader) throws IOException {
        final CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder a = CrashlyticsReport.Session.Event.Application.Execution.Thread.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            final String nextName = jsonReader.nextName();
            nextName.hashCode();
            int n = -1;
            switch (nextName) {
                case "importance": {
                    n = 2;
                    break;
                }
                case "name": {
                    n = 1;
                    break;
                }
                case "frames": {
                    n = 0;
                    break;
                }
                default:
                    break;
            }
            switch (n) {
                default: {
                    jsonReader.skipValue();
                    continue;
                }
                case 2: {
                    a.c(jsonReader.nextInt());
                    continue;
                }
                case 1: {
                    a.d(jsonReader.nextString());
                    continue;
                }
                case 0: {
                    a.b(k(jsonReader, (a<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame>)b.a));
                    continue;
                }
            }
        }
        jsonReader.endObject();
        return a.a();
    }
    
    private static CrashlyticsReport.FilesPayload.File x(final JsonReader jsonReader) throws IOException {
        final CrashlyticsReport.FilesPayload.File.Builder a = CrashlyticsReport.FilesPayload.File.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            final String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (!nextName.equals("filename")) {
                if (!nextName.equals("contents")) {
                    jsonReader.skipValue();
                }
                else {
                    a.b(Base64.decode(jsonReader.nextString(), 2));
                }
            }
            else {
                a.c(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return a.a();
    }
    
    private static CrashlyticsReport.FilesPayload y(final JsonReader jsonReader) throws IOException {
        final CrashlyticsReport.FilesPayload.Builder a = CrashlyticsReport.FilesPayload.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            final String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (!nextName.equals("files")) {
                if (!nextName.equals("orgId")) {
                    jsonReader.skipValue();
                }
                else {
                    a.c(jsonReader.nextString());
                }
            }
            else {
                a.b(k(jsonReader, (a<CrashlyticsReport.FilesPayload.File>)d.a));
            }
        }
        jsonReader.endObject();
        return a.a();
    }
    
    private static CrashlyticsReport.Session.OperatingSystem z(final JsonReader jsonReader) throws IOException {
        final CrashlyticsReport.Session.OperatingSystem.Builder a = CrashlyticsReport.Session.OperatingSystem.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            final String nextName = jsonReader.nextName();
            nextName.hashCode();
            int n = -1;
            switch (nextName) {
                case "platform": {
                    n = 3;
                    break;
                }
                case "version": {
                    n = 2;
                    break;
                }
                case "jailbroken": {
                    n = 1;
                    break;
                }
                case "buildVersion": {
                    n = 0;
                    break;
                }
                default:
                    break;
            }
            switch (n) {
                default: {
                    jsonReader.skipValue();
                    continue;
                }
                case 3: {
                    a.d(jsonReader.nextInt());
                    continue;
                }
                case 2: {
                    a.e(jsonReader.nextString());
                    continue;
                }
                case 1: {
                    a.c(jsonReader.nextBoolean());
                    continue;
                }
                case 0: {
                    a.b(jsonReader.nextString());
                    continue;
                }
            }
        }
        jsonReader.endObject();
        return a.a();
    }
    
    public CrashlyticsReport D(final String s) throws IOException {
        try {
            final JsonReader jsonReader = new JsonReader((Reader)new StringReader(s));
            try {
                final CrashlyticsReport a = A(jsonReader);
                jsonReader.close();
                return a;
            }
            finally {
                try {
                    jsonReader.close();
                }
                finally {
                    final Throwable t;
                    ((Throwable)s).addSuppressed(t);
                }
            }
        }
        catch (final IllegalStateException ex) {
            throw new IOException(ex);
        }
    }
    
    public String E(final CrashlyticsReport crashlyticsReport) {
        return CrashlyticsReportJsonTransform.a.b((Object)crashlyticsReport);
    }
    
    public CrashlyticsReport.Session.Event g(final String s) throws IOException {
        try {
            final JsonReader jsonReader = new JsonReader((Reader)new StringReader(s));
            try {
                final CrashlyticsReport.Session.Event n = n(jsonReader);
                jsonReader.close();
                return n;
            }
            finally {
                try {
                    jsonReader.close();
                }
                finally {
                    final Throwable t;
                    ((Throwable)s).addSuppressed(t);
                }
            }
        }
        catch (final IllegalStateException ex) {
            throw new IOException(ex);
        }
    }
    
    public String h(final CrashlyticsReport.Session.Event event) {
        return CrashlyticsReportJsonTransform.a.b((Object)event);
    }
    
    private interface a<T>
    {
        T a(final JsonReader p0) throws IOException;
    }
}

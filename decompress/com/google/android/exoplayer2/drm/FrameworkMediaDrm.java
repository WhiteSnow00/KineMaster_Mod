// 
// Decompiled by Procyon v0.6.0
// 

package com.google.android.exoplayer2.drm;

import android.media.MediaDrm$PlaybackComponent;
import android.media.metrics.LogSessionId;
import android.media.MediaDrm$KeyRequest;
import android.text.TextUtils;
import java.util.HashMap;
import android.media.NotProvisionedException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import android.media.DeniedByServerException;
import android.media.MediaDrm$OnEventListener;
import android.media.MediaDrmException;
import android.media.MediaDrm$ProvisionRequest;
import com.google.android.exoplayer2.analytics.PlayerId;
import java.util.Map;
import java.util.List;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import java.nio.charset.Charset;
import java.nio.ByteOrder;
import java.nio.ByteBuffer;
import com.google.common.base.Charsets;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.Log;
import android.media.UnsupportedSchemeException;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.Assertions;
import android.media.MediaDrm;
import java.util.UUID;

public final class FrameworkMediaDrm implements ExoMediaDrm
{
    public static final Provider d;
    private final UUID a;
    private final MediaDrm b;
    private int c;
    
    static {
        d = r.a;
    }
    
    private FrameworkMediaDrm(final UUID a) throws UnsupportedSchemeException {
        Assertions.e(a);
        Assertions.b(C.b.equals(a) ^ true, "Use C.CLEARKEY_UUID instead");
        this.a = a;
        final MediaDrm b = new MediaDrm(u(a));
        this.b = b;
        this.c = 1;
        if (C.d.equals(a) && B()) {
            w(b);
        }
    }
    
    private static ExoMediaDrm A(final UUID uuid) {
        try {
            return C(uuid);
        }
        catch (final UnsupportedDrmException ex) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Failed to instantiate a FrameworkMediaDrm for uuid: ");
            sb.append(uuid);
            sb.append(".");
            Log.c("FrameworkMediaDrm", sb.toString());
            return new DummyExoMediaDrm();
        }
    }
    
    private static boolean B() {
        return "ASUS_Z00AD".equals(Util.d);
    }
    
    public static FrameworkMediaDrm C(final UUID uuid) throws UnsupportedDrmException {
        try {
            return new FrameworkMediaDrm(uuid);
        }
        catch (final Exception ex) {
            throw new UnsupportedDrmException(2, ex);
        }
        catch (final UnsupportedSchemeException ex2) {
            throw new UnsupportedDrmException(1, (Exception)ex2);
        }
    }
    
    public static ExoMediaDrm o(final UUID uuid) {
        return A(uuid);
    }
    
    public static void p(final FrameworkMediaDrm frameworkMediaDrm, final OnEventListener onEventListener, final MediaDrm mediaDrm, final byte[] array, final int n, final int n2, final byte[] array2) {
        frameworkMediaDrm.z(onEventListener, mediaDrm, array, n, n2, array2);
    }
    
    private static byte[] q(final byte[] array) {
        final ParsableByteArray parsableByteArray = new ParsableByteArray(array);
        int q = parsableByteArray.q();
        final short s = parsableByteArray.s();
        final short s2 = parsableByteArray.s();
        if (s != 1 || s2 != 1) {
            Log.f("FrameworkMediaDrm", "Unexpected record count or type. Skipping LA_URL workaround.");
            return array;
        }
        final short s3 = parsableByteArray.s();
        final Charset e = Charsets.e;
        final String b = parsableByteArray.B(s3, e);
        if (b.contains("<LA_URL>")) {
            return array;
        }
        final int index = b.indexOf("</DATA>");
        if (index == -1) {
            Log.i("FrameworkMediaDrm", "Could not find the </DATA> tag. Skipping LA_URL workaround.");
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(b.substring(0, index));
        sb.append("<LA_URL>https://x</LA_URL>");
        sb.append(b.substring(index));
        final String string = sb.toString();
        q += 52;
        final ByteBuffer allocate = ByteBuffer.allocate(q);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putInt(q);
        allocate.putShort(s);
        allocate.putShort(s2);
        allocate.putShort((short)(string.length() * 2));
        allocate.put(string.getBytes(e));
        return allocate.array();
    }
    
    private static byte[] r(final UUID uuid, final byte[] array) {
        if (C.c.equals(uuid)) {
            return com.google.android.exoplayer2.drm.a.a(array);
        }
        return array;
    }
    
    private static byte[] s(final UUID uuid, byte[] array) {
        final UUID e = C.e;
        byte[] a = array;
        if (e.equals(uuid)) {
            final byte[] e2 = PsshAtomUtil.e(array, uuid);
            if (e2 != null) {
                array = e2;
            }
            a = PsshAtomUtil.a(e, q(array));
        }
        if (Util.a >= 23 || !C.d.equals(uuid)) {
            if (!e.equals(uuid) || !"Amazon".equals(Util.c)) {
                return a;
            }
            final String d = Util.d;
            if (!"AFTB".equals(d) && !"AFTS".equals(d) && !"AFTM".equals(d) && !"AFTT".equals(d)) {
                return a;
            }
        }
        final byte[] e3 = PsshAtomUtil.e(a, uuid);
        if (e3 != null) {
            return e3;
        }
        return a;
    }
    
    private static String t(final UUID uuid, final String s) {
        if (Util.a < 26 && C.c.equals(uuid) && ("video/mp4".equals(s) || "audio/mp4".equals(s))) {
            return "cenc";
        }
        return s;
    }
    
    private static UUID u(final UUID uuid) {
        UUID b = uuid;
        if (Util.a < 27) {
            b = uuid;
            if (C.c.equals(uuid)) {
                b = C.b;
            }
        }
        return b;
    }
    
    private static void w(final MediaDrm mediaDrm) {
        mediaDrm.setPropertyString("securityLevel", "L3");
    }
    
    private static DrmInitData.SchemeData y(final UUID uuid, final List<DrmInitData.SchemeData> list) {
        if (!C.d.equals(uuid)) {
            return (DrmInitData.SchemeData)list.get(0);
        }
        Label_0224: {
            if (Util.a >= 28 && list.size() > 1) {
                final DrmInitData.SchemeData schemeData = (DrmInitData.SchemeData)list.get(0);
                int i = 0;
                int n = 0;
                while (true) {
                    while (i < list.size()) {
                        final DrmInitData.SchemeData schemeData2 = list.get(i);
                        final byte[] array = Assertions.e(schemeData2.e);
                        if (Util.c(schemeData2.d, schemeData.d) && Util.c(schemeData2.c, schemeData.c) && PsshAtomUtil.c(array)) {
                            n += array.length;
                            ++i;
                        }
                        else {
                            final boolean b = false;
                            if (b) {
                                final byte[] array2 = new byte[n];
                                int j = 0;
                                int n2 = 0;
                                while (j < list.size()) {
                                    final byte[] array3 = Assertions.e(list.get(j).e);
                                    final int length = array3.length;
                                    System.arraycopy(array3, 0, array2, n2, length);
                                    n2 += length;
                                    ++j;
                                }
                                return schemeData.b(array2);
                            }
                            break Label_0224;
                        }
                    }
                    final boolean b = true;
                    continue;
                }
            }
        }
        for (int k = 0; k < list.size(); ++k) {
            final DrmInitData.SchemeData schemeData3 = list.get(k);
            final int g = PsshAtomUtil.g(Assertions.e(schemeData3.e));
            final int a = Util.a;
            if (a < 23 && g == 0) {
                return schemeData3;
            }
            if (a >= 23 && g == 1) {
                return schemeData3;
            }
        }
        return (DrmInitData.SchemeData)list.get(0);
    }
    
    private void z(final OnEventListener onEventListener, final MediaDrm mediaDrm, final byte[] array, final int n, final int n2, final byte[] array2) {
        onEventListener.a(this, array, n, n2, array2);
    }
    
    @Override
    public void a() {
        synchronized (this) {
            Assertions.g(this.c > 0);
            ++this.c;
        }
    }
    
    @Override
    public Map<String, String> b(final byte[] array) {
        return this.b.queryKeyStatus(array);
    }
    
    @Override
    public void c(final byte[] array, final PlayerId playerId) {
        if (Util.a >= 31) {
            try {
                FrameworkMediaDrm.a.b(this.b, array, playerId);
            }
            catch (final UnsupportedOperationException ex) {
                Log.i("FrameworkMediaDrm", "setLogSessionId failed.");
            }
        }
    }
    
    @Override
    public ProvisionRequest d() {
        final MediaDrm$ProvisionRequest provisionRequest = this.b.getProvisionRequest();
        return new ProvisionRequest(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }
    
    @Override
    public byte[] e() throws MediaDrmException {
        return this.b.openSession();
    }
    
    @Override
    public void f(final byte[] array, final byte[] array2) {
        this.b.restoreKeys(array, array2);
    }
    
    @Override
    public void g(final OnEventListener onEventListener) {
        final MediaDrm b = this.b;
        Object onEventListener2;
        if (onEventListener == null) {
            onEventListener2 = null;
        }
        else {
            onEventListener2 = new q(this, onEventListener);
        }
        b.setOnEventListener((MediaDrm$OnEventListener)onEventListener2);
    }
    
    @Override
    public void h(final byte[] array) throws DeniedByServerException {
        this.b.provideProvisionResponse(array);
    }
    
    @Override
    public int i() {
        return 2;
    }
    
    @Override
    public /* bridge */ CryptoConfig j(final byte[] array) throws MediaCryptoException {
        return this.v(array);
    }
    
    @Override
    public boolean k(byte[] array, final String s) {
        if (Util.a >= 31) {
            return FrameworkMediaDrm.a.a(this.b, s);
        }
        try {
            array = (byte[])(Object)new MediaCrypto(this.a, array);
            try {
                return ((MediaCrypto)(Object)array).requiresSecureDecoderComponent(s);
            }
            finally {
                ((MediaCrypto)(Object)array).release();
            }
        }
        catch (final MediaCryptoException ex) {
            return true;
        }
    }
    
    @Override
    public void l(final byte[] array) {
        this.b.closeSession(array);
    }
    
    @Override
    public byte[] m(final byte[] array, final byte[] array2) throws NotProvisionedException, DeniedByServerException {
        byte[] b = array2;
        if (C.c.equals(this.a)) {
            b = com.google.android.exoplayer2.drm.a.b(array2);
        }
        return this.b.provideKeyResponse(array, b);
    }
    
    @Override
    public KeyRequest n(final byte[] array, final List<DrmInitData.SchemeData> list, int requestType, final HashMap<String, String> hashMap) throws NotProvisionedException {
        final DrmInitData.SchemeData schemeData = null;
        DrmInitData.SchemeData y;
        byte[] s;
        String t;
        if (list != null) {
            y = y(this.a, list);
            s = s(this.a, Assertions.e(y.e));
            t = t(this.a, y.d);
        }
        else {
            s = null;
            t = null;
            y = schemeData;
        }
        final MediaDrm$KeyRequest keyRequest = this.b.getKeyRequest(array, s, t, requestType, (HashMap)hashMap);
        final byte[] r = r(this.a, keyRequest.getData());
        String defaultUrl;
        if ("https://x".equals(defaultUrl = keyRequest.getDefaultUrl())) {
            defaultUrl = "";
        }
        String c = defaultUrl;
        if (TextUtils.isEmpty((CharSequence)defaultUrl)) {
            c = defaultUrl;
            if (y != null) {
                c = defaultUrl;
                if (!TextUtils.isEmpty((CharSequence)y.c)) {
                    c = y.c;
                }
            }
        }
        if (Util.a >= 23) {
            requestType = keyRequest.getRequestType();
        }
        else {
            requestType = Integer.MIN_VALUE;
        }
        return new KeyRequest(r, c, requestType);
    }
    
    @Override
    public void release() {
        synchronized (this) {
            final int c = this.c - 1;
            this.c = c;
            if (c == 0) {
                this.b.release();
            }
        }
    }
    
    public FrameworkCryptoConfig v(final byte[] array) throws MediaCryptoException {
        return new FrameworkCryptoConfig(u(this.a), array, Util.a < 21 && C.d.equals(this.a) && "L3".equals(this.x("securityLevel")));
    }
    
    public String x(final String s) {
        return this.b.getPropertyString(s);
    }
    
    private static class a
    {
        public static boolean a(final MediaDrm mediaDrm, final String s) {
            return mediaDrm.requiresSecureDecoder(s);
        }
        
        public static void b(final MediaDrm mediaDrm, final byte[] array, final PlayerId playerId) {
            final LogSessionId a = playerId.a();
            if (!a.equals((Object)LogSessionId.LOG_SESSION_ID_NONE)) {
                Assertions.e(mediaDrm.getPlaybackComponent(array)).setLogSessionId(a);
            }
        }
    }
}

// 
// Decompiled by Procyon v0.6.0
// 

package com.facebook.ads.internal.dynamicloading;

import java.io.FilterOutputStream;
import java.net.HttpURLConnection;
import java.io.InputStream;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.io.DataOutputStream;
import org.json.JSONArray;
import java.util.UUID;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.net.URL;
import java.net.URLConnection;
import com.facebook.ads.internal.api.BuildConfigApi;
import android.os.Build;
import android.os.Build$VERSION;
import android.content.pm.PackageManager$NameNotFoundException;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

public class DexLoadErrorReporter
{
    private static final String LOGGING_URL = "https://www.facebook.com/adnw_logging/";
    public static final double SAMPLING = 0.1;
    private static final AtomicBoolean sAlreadyReported;
    
    static {
        sAlreadyReported = new AtomicBoolean();
    }
    
    static void access$000(final Context context, final JSONObject jsonObject, final String s) throws JSONException, PackageManager$NameNotFoundException {
        addEnvFields(context, jsonObject, s);
    }
    
    private static void addEnvFields(final Context context, final JSONObject jsonObject, final String s) throws JSONException, PackageManager$NameNotFoundException {
        final String packageName = context.getPackageName();
        jsonObject.put("APPBUILD", context.getPackageManager().getPackageInfo(packageName, 0).versionCode);
        jsonObject.put("APPNAME", (Object)context.getPackageManager().getApplicationLabel(context.getPackageManager().getApplicationInfo(packageName, 0)));
        jsonObject.put("APPVERS", (Object)context.getPackageManager().getPackageInfo(packageName, 0).versionName);
        jsonObject.put("OSVERS", (Object)Build$VERSION.RELEASE);
        jsonObject.put("SDK", (Object)"android");
        jsonObject.put("SESSION_ID", (Object)s);
        jsonObject.put("MODEL", (Object)Build.MODEL);
        jsonObject.put("BUNDLE", (Object)packageName);
        jsonObject.put("SDK_VERSION", (Object)BuildConfigApi.getVersionName(context));
        jsonObject.put("OS", (Object)"Android");
    }
    
    public static void reportDexLoadingIssue(final Context context, final String s, final double n) {
        final AtomicBoolean sAlreadyReported = DexLoadErrorReporter.sAlreadyReported;
        if (!sAlreadyReported.get() && Math.random() < n) {
            sAlreadyReported.set(true);
            new Thread(context, s) {
                final Context a;
                final String b;
                
                @Override
                public void run() {
                    super.run();
                    Label_0675: {
                        Exception ex;
                        Exception ex2;
                        HttpURLConnection httpURLConnection;
                        try {
                            Object o = FirebasePerfUrlConnection.instrument((Object)new URL("https://www.facebook.com/adnw_logging/").openConnection());
                            try {
                                ((HttpURLConnection)o).setRequestMethod("POST");
                                ((URLConnection)o).setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
                                ((URLConnection)o).setRequestProperty("Accept", "application/json");
                                ((URLConnection)o).setRequestProperty("Accept-Charset", "UTF-8");
                                ((URLConnection)o).setRequestProperty("user-agent", "[FBAN/AudienceNetworkForAndroid;FBSN/Android]");
                                ((URLConnection)o).setDoOutput(true);
                                ((URLConnection)o).setDoInput(true);
                                ((HttpURLConnection)o).connect();
                                final String string = UUID.randomUUID().toString();
                                final JSONObject jsonObject = new JSONObject();
                                jsonObject.put("attempt", (Object)"0");
                                DexLoadErrorReporter.access$000(this.a, jsonObject, string);
                                final JSONObject jsonObject2 = new JSONObject();
                                jsonObject2.put("subtype", (Object)"generic");
                                jsonObject2.put("subtype_code", (Object)"1320");
                                jsonObject2.put("caught_exception", (Object)"1");
                                jsonObject2.put("stacktrace", (Object)this.b);
                                final JSONObject jsonObject3 = new JSONObject();
                                jsonObject3.put("id", (Object)UUID.randomUUID().toString());
                                jsonObject3.put("type", (Object)"debug");
                                final StringBuilder sb = new StringBuilder();
                                sb.append("");
                                final long currentTimeMillis = System.currentTimeMillis();
                                final Throwable t = (Throwable)o;
                                try {
                                    sb.append(currentTimeMillis / 1000L);
                                    jsonObject3.put("session_time", (Object)sb.toString());
                                    final StringBuilder sb2 = new StringBuilder();
                                    sb2.append("");
                                    sb2.append(System.currentTimeMillis() / 1000L);
                                    jsonObject3.put("time", (Object)sb2.toString());
                                    jsonObject3.put("session_id", (Object)string);
                                    jsonObject3.put("data", (Object)jsonObject2);
                                    jsonObject3.put("attempt", (Object)"0");
                                    DexLoadErrorReporter.access$000(this.a, jsonObject2, string);
                                    final JSONArray jsonArray = new JSONArray();
                                    jsonArray.put((Object)jsonObject3);
                                    final JSONObject jsonObject4 = new JSONObject();
                                    jsonObject4.put("data", (Object)jsonObject);
                                    jsonObject4.put("events", (Object)jsonArray);
                                    final String string2 = jsonObject4.toString();
                                    final DataOutputStream dataOutputStream = new DataOutputStream(((URLConnection)t).getOutputStream());
                                    try {
                                        final StringBuilder sb3 = new StringBuilder();
                                        sb3.append("payload=");
                                        sb3.append(URLEncoder.encode(string2, "UTF-8"));
                                        dataOutputStream.writeBytes(sb3.toString());
                                        dataOutputStream.flush();
                                        final byte[] array = new byte[16384];
                                        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                        final InputStream inputStream = ((URLConnection)t).getInputStream();
                                        try {
                                            while (true) {
                                                final int read = inputStream.read(array);
                                                if (read == -1) {
                                                    break;
                                                }
                                                byteArrayOutputStream.write(array, 0, read);
                                            }
                                            byteArrayOutputStream.flush();
                                            try {
                                                dataOutputStream.close();
                                            }
                                            catch (final Exception o) {
                                                Log.e("FBAudienceNetwork", "Can't close connection.", (Throwable)o);
                                            }
                                            try {
                                                inputStream.close();
                                                break Label_0675;
                                            }
                                            catch (final Exception o) {
                                                Log.e("FBAudienceNetwork", "Can't close connection.", (Throwable)o);
                                                break Label_0675;
                                            }
                                        }
                                        finally {
                                            o = inputStream;
                                        }
                                    }
                                    finally {}
                                }
                                finally {}
                            }
                            finally {}
                        }
                        finally {
                            ex = null;
                            ex2 = null;
                            httpURLConnection = null;
                        }
                        try {
                            final Throwable t2;
                            Log.e("FBAudienceNetwork", "Can't send error.", t2);
                            if (ex != null) {
                                try {
                                    ((FilterOutputStream)ex).close();
                                }
                                catch (final Exception ex) {
                                    Log.e("FBAudienceNetwork", "Can't close connection.", (Throwable)ex);
                                }
                            }
                            if (ex2 != null) {
                                try {
                                    ((InputStream)ex2).close();
                                }
                                catch (final Exception ex2) {
                                    Log.e("FBAudienceNetwork", "Can't close connection.", (Throwable)ex2);
                                }
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        }
                        finally {
                            if (ex != null) {
                                try {
                                    ((DataOutputStream)ex).close();
                                }
                                catch (final Exception ex3) {
                                    Log.e("FBAudienceNetwork", "Can't close connection.", (Throwable)ex3);
                                }
                            }
                            if (ex2 != null) {
                                try {
                                    ((InputStream)ex2).close();
                                }
                                catch (final Exception ex4) {
                                    Log.e("FBAudienceNetwork", "Can't close connection.", (Throwable)ex4);
                                }
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        }
                    }
                }
            }.start();
        }
    }
}

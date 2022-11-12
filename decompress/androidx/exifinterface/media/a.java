// 
// Decompiled by Procyon v0.6.0
// 

package androidx.exifinterface.media;

import java.io.FilterOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataInput;
import java.util.regex.Matcher;
import android.util.Pair;
import java.nio.ByteBuffer;
import java.io.EOFException;
import java.util.zip.CRC32;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import android.system.OsConstants;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.TimeZone;
import java.util.Locale;
import java.util.Collection;
import java.util.Arrays;
import android.util.Log;
import java.nio.ByteOrder;
import java.util.Set;
import android.content.res.AssetManager$AssetInputStream;
import java.io.FileDescriptor;
import java.util.List;
import java.util.regex.Pattern;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.HashMap;
import java.text.SimpleDateFormat;

public class a
{
    public static final int[] A;
    static final byte[] B;
    private static final byte[] C;
    private static final byte[] D;
    private static final byte[] E;
    private static final byte[] F;
    private static final byte[] G;
    private static final byte[] H;
    private static final byte[] I;
    private static final byte[] J;
    private static final byte[] K;
    private static final byte[] L;
    private static final byte[] M;
    private static final byte[] N;
    private static final byte[] O;
    private static final byte[] P;
    private static final byte[] Q;
    private static final byte[] R;
    private static final byte[] S;
    private static final byte[] T;
    private static SimpleDateFormat U;
    private static SimpleDateFormat V;
    static final String[] W;
    static final int[] X;
    static final byte[] Y;
    private static final e[] Z;
    private static final e[] a0;
    private static final e[] b0;
    private static final e[] c0;
    private static final e[] d0;
    private static final e e0;
    private static final e[] f0;
    private static final e[] g0;
    private static final e[] h0;
    private static final e[] i0;
    static final e[][] j0;
    private static final e[] k0;
    private static final HashMap<Integer, e>[] l0;
    private static final HashMap<String, e>[] m0;
    private static final HashSet<String> n0;
    private static final HashMap<Integer, Integer> o0;
    static final Charset p0;
    static final byte[] q0;
    private static final byte[] r0;
    private static final Pattern s0;
    private static final Pattern t0;
    private static final Pattern u0;
    private static final boolean v;
    private static final Pattern v0;
    private static final List<Integer> w;
    private static final List<Integer> x;
    public static final int[] y;
    public static final int[] z;
    private String a;
    private FileDescriptor b;
    private AssetManager$AssetInputStream c;
    private int d;
    private boolean e;
    private final HashMap<String, d>[] f;
    private Set<Integer> g;
    private ByteOrder h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private byte[] n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private boolean t;
    private boolean u;
    
    static {
        final Integer value = 3;
        v = Log.isLoggable("ExifInterface", 3);
        final Integer value2 = 1;
        final Integer value3 = 2;
        final Integer value4 = 8;
        w = Arrays.asList(value2, 6, value, value4);
        final Integer value5 = 7;
        final Integer value6 = 5;
        x = Arrays.asList(value3, value5, 4, value6);
        y = new int[] { 8, 8, 8 };
        z = new int[] { 4 };
        A = new int[] { 8 };
        B = new byte[] { -1, -40, -1 };
        C = new byte[] { 102, 116, 121, 112 };
        D = new byte[] { 109, 105, 102, 49 };
        E = new byte[] { 104, 101, 105, 99 };
        F = new byte[] { 79, 76, 89, 77, 80, 0 };
        G = new byte[] { 79, 76, 89, 77, 80, 85, 83, 0, 73, 73 };
        H = new byte[] { -119, 80, 78, 71, 13, 10, 26, 10 };
        I = new byte[] { 101, 88, 73, 102 };
        J = new byte[] { 73, 72, 68, 82 };
        K = new byte[] { 73, 69, 78, 68 };
        L = new byte[] { 82, 73, 70, 70 };
        M = new byte[] { 87, 69, 66, 80 };
        N = new byte[] { 69, 88, 73, 70 };
        O = new byte[] { -99, 1, 42 };
        P = "VP8X".getBytes(Charset.defaultCharset());
        Q = "VP8L".getBytes(Charset.defaultCharset());
        R = "VP8 ".getBytes(Charset.defaultCharset());
        S = "ANIM".getBytes(Charset.defaultCharset());
        T = "ANMF".getBytes(Charset.defaultCharset());
        W = new String[] { "", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD" };
        X = new int[] { 0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1 };
        Y = new byte[] { 65, 83, 67, 73, 73, 0, 0, 0 };
        final e[] array = Z = new e[] { new e("NewSubfileType", 254, 4), new e("SubfileType", 255, 4), new e("ImageWidth", 256, 3, 4), new e("ImageLength", 257, 3, 4), new e("BitsPerSample", 258, 3), new e("Compression", 259, 3), new e("PhotometricInterpretation", 262, 3), new e("ImageDescription", 270, 2), new e("Make", 271, 2), new e("Model", 272, 2), new e("StripOffsets", 273, 3, 4), new e("Orientation", 274, 3), new e("SamplesPerPixel", 277, 3), new e("RowsPerStrip", 278, 3, 4), new e("StripByteCounts", 279, 3, 4), new e("XResolution", 282, 5), new e("YResolution", 283, 5), new e("PlanarConfiguration", 284, 3), new e("ResolutionUnit", 296, 3), new e("TransferFunction", 301, 3), new e("Software", 305, 2), new e("DateTime", 306, 2), new e("Artist", 315, 2), new e("WhitePoint", 318, 5), new e("PrimaryChromaticities", 319, 5), new e("SubIFDPointer", 330, 4), new e("JPEGInterchangeFormat", 513, 4), new e("JPEGInterchangeFormatLength", 514, 4), new e("YCbCrCoefficients", 529, 5), new e("YCbCrSubSampling", 530, 3), new e("YCbCrPositioning", 531, 3), new e("ReferenceBlackWhite", 532, 5), new e("Copyright", 33432, 2), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("SensorTopBorder", 4, 4), new e("SensorLeftBorder", 5, 4), new e("SensorBottomBorder", 6, 4), new e("SensorRightBorder", 7, 4), new e("ISO", 23, 3), new e("JpgFromRaw", 46, 7), new e("Xmp", 700, 1) };
        final e[] array2 = a0 = new e[] { new e("ExposureTime", 33434, 5), new e("FNumber", 33437, 5), new e("ExposureProgram", 34850, 3), new e("SpectralSensitivity", 34852, 2), new e("PhotographicSensitivity", 34855, 3), new e("OECF", 34856, 7), new e("SensitivityType", 34864, 3), new e("StandardOutputSensitivity", 34865, 4), new e("RecommendedExposureIndex", 34866, 4), new e("ISOSpeed", 34867, 4), new e("ISOSpeedLatitudeyyy", 34868, 4), new e("ISOSpeedLatitudezzz", 34869, 4), new e("ExifVersion", 36864, 2), new e("DateTimeOriginal", 36867, 2), new e("DateTimeDigitized", 36868, 2), new e("OffsetTime", 36880, 2), new e("OffsetTimeOriginal", 36881, 2), new e("OffsetTimeDigitized", 36882, 2), new e("ComponentsConfiguration", 37121, 7), new e("CompressedBitsPerPixel", 37122, 5), new e("ShutterSpeedValue", 37377, 10), new e("ApertureValue", 37378, 5), new e("BrightnessValue", 37379, 10), new e("ExposureBiasValue", 37380, 10), new e("MaxApertureValue", 37381, 5), new e("SubjectDistance", 37382, 5), new e("MeteringMode", 37383, 3), new e("LightSource", 37384, 3), new e("Flash", 37385, 3), new e("FocalLength", 37386, 5), new e("SubjectArea", 37396, 3), new e("MakerNote", 37500, 7), new e("UserComment", 37510, 7), new e("SubSecTime", 37520, 2), new e("SubSecTimeOriginal", 37521, 2), new e("SubSecTimeDigitized", 37522, 2), new e("FlashpixVersion", 40960, 7), new e("ColorSpace", 40961, 3), new e("PixelXDimension", 40962, 3, 4), new e("PixelYDimension", 40963, 3, 4), new e("RelatedSoundFile", 40964, 2), new e("InteroperabilityIFDPointer", 40965, 4), new e("FlashEnergy", 41483, 5), new e("SpatialFrequencyResponse", 41484, 7), new e("FocalPlaneXResolution", 41486, 5), new e("FocalPlaneYResolution", 41487, 5), new e("FocalPlaneResolutionUnit", 41488, 3), new e("SubjectLocation", 41492, 3), new e("ExposureIndex", 41493, 5), new e("SensingMethod", 41495, 3), new e("FileSource", 41728, 7), new e("SceneType", 41729, 7), new e("CFAPattern", 41730, 7), new e("CustomRendered", 41985, 3), new e("ExposureMode", 41986, 3), new e("WhiteBalance", 41987, 3), new e("DigitalZoomRatio", 41988, 5), new e("FocalLengthIn35mmFilm", 41989, 3), new e("SceneCaptureType", 41990, 3), new e("GainControl", 41991, 3), new e("Contrast", 41992, 3), new e("Saturation", 41993, 3), new e("Sharpness", 41994, 3), new e("DeviceSettingDescription", 41995, 7), new e("SubjectDistanceRange", 41996, 3), new e("ImageUniqueID", 42016, 2), new e("CameraOwnerName", 42032, 2), new e("BodySerialNumber", 42033, 2), new e("LensSpecification", 42034, 5), new e("LensMake", 42035, 2), new e("LensModel", 42036, 2), new e("Gamma", 42240, 5), new e("DNGVersion", 50706, 1), new e("DefaultCropSize", 50720, 3, 4) };
        final e[] array3 = b0 = new e[] { new e("GPSVersionID", 0, 1), new e("GPSLatitudeRef", 1, 2), new e("GPSLatitude", 2, 5, 10), new e("GPSLongitudeRef", 3, 2), new e("GPSLongitude", 4, 5, 10), new e("GPSAltitudeRef", 5, 1), new e("GPSAltitude", 6, 5), new e("GPSTimeStamp", 7, 5), new e("GPSSatellites", 8, 2), new e("GPSStatus", 9, 2), new e("GPSMeasureMode", 10, 2), new e("GPSDOP", 11, 5), new e("GPSSpeedRef", 12, 2), new e("GPSSpeed", 13, 5), new e("GPSTrackRef", 14, 2), new e("GPSTrack", 15, 5), new e("GPSImgDirectionRef", 16, 2), new e("GPSImgDirection", 17, 5), new e("GPSMapDatum", 18, 2), new e("GPSDestLatitudeRef", 19, 2), new e("GPSDestLatitude", 20, 5), new e("GPSDestLongitudeRef", 21, 2), new e("GPSDestLongitude", 22, 5), new e("GPSDestBearingRef", 23, 2), new e("GPSDestBearing", 24, 5), new e("GPSDestDistanceRef", 25, 2), new e("GPSDestDistance", 26, 5), new e("GPSProcessingMethod", 27, 7), new e("GPSAreaInformation", 28, 7), new e("GPSDateStamp", 29, 2), new e("GPSDifferential", 30, 3), new e("GPSHPositioningError", 31, 5) };
        final e[] array4 = c0 = new e[] { new e("InteroperabilityIndex", 1, 2) };
        final e[] array5 = d0 = new e[] { new e("NewSubfileType", 254, 4), new e("SubfileType", 255, 4), new e("ThumbnailImageWidth", 256, 3, 4), new e("ThumbnailImageLength", 257, 3, 4), new e("BitsPerSample", 258, 3), new e("Compression", 259, 3), new e("PhotometricInterpretation", 262, 3), new e("ImageDescription", 270, 2), new e("Make", 271, 2), new e("Model", 272, 2), new e("StripOffsets", 273, 3, 4), new e("ThumbnailOrientation", 274, 3), new e("SamplesPerPixel", 277, 3), new e("RowsPerStrip", 278, 3, 4), new e("StripByteCounts", 279, 3, 4), new e("XResolution", 282, 5), new e("YResolution", 283, 5), new e("PlanarConfiguration", 284, 3), new e("ResolutionUnit", 296, 3), new e("TransferFunction", 301, 3), new e("Software", 305, 2), new e("DateTime", 306, 2), new e("Artist", 315, 2), new e("WhitePoint", 318, 5), new e("PrimaryChromaticities", 319, 5), new e("SubIFDPointer", 330, 4), new e("JPEGInterchangeFormat", 513, 4), new e("JPEGInterchangeFormatLength", 514, 4), new e("YCbCrCoefficients", 529, 5), new e("YCbCrSubSampling", 530, 3), new e("YCbCrPositioning", 531, 3), new e("ReferenceBlackWhite", 532, 5), new e("Xmp", 700, 1), new e("Copyright", 33432, 2), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("DNGVersion", 50706, 1), new e("DefaultCropSize", 50720, 3, 4) };
        e0 = new e("StripOffsets", 273, 3);
        final e[][] array6 = j0 = new e[][] { array, array2, array3, array4, array5, array, f0 = new e[] { new e("ThumbnailImage", 256, 7), new e("CameraSettingsIFDPointer", 8224, 4), new e("ImageProcessingIFDPointer", 8256, 4) }, g0 = new e[] { new e("PreviewImageStart", 257, 4), new e("PreviewImageLength", 258, 4) }, h0 = new e[] { new e("AspectFrame", 4371, 3) }, i0 = new e[] { new e("ColorSpace", 55, 3) } };
        k0 = new e[] { new e("SubIFDPointer", 330, 4), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("InteroperabilityIFDPointer", 40965, 4), new e("CameraSettingsIFDPointer", 8224, 1), new e("ImageProcessingIFDPointer", 8256, 1) };
        l0 = new HashMap[array6.length];
        m0 = new HashMap[array6.length];
        n0 = new HashSet<String>(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        o0 = new HashMap<Integer, Integer>();
        final Charset charset = p0 = Charset.forName("US-ASCII");
        q0 = "Exif\u0000\u0000".getBytes(charset);
        r0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(charset);
        final Locale us = Locale.US;
        (a.U = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", us)).setTimeZone(TimeZone.getTimeZone("UTC"));
        (a.V = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", us)).setTimeZone(TimeZone.getTimeZone("UTC"));
        int n = 0;
        while (true) {
            final e[][] j = a.j0;
            if (n >= j.length) {
                break;
            }
            a.l0[n] = new HashMap<Integer, e>();
            a.m0[n] = new HashMap<String, e>();
            for (final e e : j[n]) {
                a.l0[n].put(e.a, e);
                a.m0[n].put(e.b, e);
            }
            ++n;
        }
        final HashMap<Integer, Integer> o = a.o0;
        final e[] k = a.k0;
        o.put(k[0].a, value6);
        o.put(k[1].a, value2);
        o.put(k[2].a, value3);
        o.put(k[3].a, value);
        o.put(k[4].a, value5);
        o.put(k[5].a, value4);
        s0 = Pattern.compile(".*[1-9].*");
        t0 = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
        u0 = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
        v0 = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
    }
    
    public a(FileDescriptor b) throws IOException {
        final e[][] j0 = androidx.exifinterface.media.a.j0;
        this.f = new HashMap[j0.length];
        this.g = new HashSet<Integer>(j0.length);
        this.h = ByteOrder.BIG_ENDIAN;
        Objects.requireNonNull(b, "fileDescriptor cannot be null");
        this.c = null;
        this.a = null;
        boolean b2 = false;
        Closeable closeable = null;
        Label_0097: {
            if (D(b)) {
                this.b = b;
                try {
                    b = androidx.exifinterface.media.b.a.b(b);
                    b2 = true;
                    break Label_0097;
                }
                catch (final Exception ex) {
                    throw new IOException("Failed to duplicate file descriptor", ex);
                }
            }
            this.b = null;
            try {
                final FileInputStream fileInputStream = new FileInputStream(b);
                try {
                    this.I(fileInputStream);
                    androidx.exifinterface.media.b.c(fileInputStream);
                    if (b2) {
                        androidx.exifinterface.media.b.b(b);
                    }
                    return;
                }
                finally {}
            }
            finally {
                closeable = null;
            }
        }
        androidx.exifinterface.media.b.c(closeable);
        if (b2) {
            androidx.exifinterface.media.b.b(b);
        }
    }
    
    public a(final InputStream inputStream) throws IOException {
        this(inputStream, 0);
    }
    
    public a(InputStream inputStream, int n) throws IOException {
        final e[][] j0 = androidx.exifinterface.media.a.j0;
        this.f = new HashMap[j0.length];
        this.g = new HashSet<Integer>(j0.length);
        this.h = ByteOrder.BIG_ENDIAN;
        Objects.requireNonNull(inputStream, "inputStream cannot be null");
        this.a = null;
        if (n == 1) {
            n = 1;
        }
        else {
            n = 0;
        }
        Label_0185: {
            if (n != 0) {
                inputStream = new BufferedInputStream(inputStream, androidx.exifinterface.media.a.q0.length);
                if (!w((BufferedInputStream)inputStream)) {
                    Log.w("ExifInterface", "Given data does not follow the structure of an Exif-only data.");
                    return;
                }
                this.e = true;
                this.c = null;
                this.b = null;
            }
            else if (inputStream instanceof AssetManager$AssetInputStream) {
                this.c = (AssetManager$AssetInputStream)inputStream;
                this.b = null;
            }
            else {
                if (inputStream instanceof FileInputStream) {
                    final FileInputStream fileInputStream = (FileInputStream)inputStream;
                    if (D(fileInputStream.getFD())) {
                        this.c = null;
                        this.b = fileInputStream.getFD();
                        break Label_0185;
                    }
                }
                this.c = null;
                this.b = null;
            }
        }
        this.I(inputStream);
    }
    
    public a(final String s) throws IOException {
        final e[][] j0 = androidx.exifinterface.media.a.j0;
        this.f = new HashMap[j0.length];
        this.g = new HashSet<Integer>(j0.length);
        this.h = ByteOrder.BIG_ENDIAN;
        Objects.requireNonNull(s, "filename cannot be null");
        this.v(s);
    }
    
    private boolean A(final byte[] array) throws IOException {
        int n = 0;
        while (true) {
            final byte[] h = androidx.exifinterface.media.a.H;
            if (n >= h.length) {
                return true;
            }
            if (array[n] != h[n]) {
                return false;
            }
            ++n;
        }
    }
    
    private boolean B(final byte[] array) throws IOException {
        final byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i = 0; i < bytes.length; ++i) {
            if (array[i] != bytes[i]) {
                return false;
            }
        }
        return true;
    }
    
    private boolean C(final byte[] array) throws IOException {
        boolean b = false;
        try {
            final b b2 = new b(array);
            try {
                b2.d(this.h = this.L(b2));
                if (b2.readShort() == 85) {
                    b = true;
                }
                b2.close();
                return b;
            }
            catch (final Exception ex) {}
        }
        catch (final Exception ex2) {
            goto Label_0083;
        }
    }
    
    private static boolean D(final FileDescriptor fileDescriptor) {
        try {
            androidx.exifinterface.media.b.a.c(fileDescriptor, 0L, OsConstants.SEEK_CUR);
            return true;
        }
        catch (final Exception ex) {
            if (a.v) {
                Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
            }
            return false;
        }
    }
    
    private boolean E(final HashMap hashMap) throws IOException {
        final d d = hashMap.get("BitsPerSample");
        if (d != null) {
            final int[] array = (int[])d.o(this.h);
            final int[] y = androidx.exifinterface.media.a.y;
            if (Arrays.equals(y, array)) {
                return true;
            }
            if (this.d == 3) {
                final d d2 = hashMap.get("PhotometricInterpretation");
                if (d2 != null) {
                    final int m = d2.m(this.h);
                    if ((m == 1 && Arrays.equals(array, androidx.exifinterface.media.a.A)) || (m == 6 && Arrays.equals(array, y))) {
                        return true;
                    }
                }
            }
        }
        if (androidx.exifinterface.media.a.v) {
            Log.d("ExifInterface", "Unsupported data type value");
        }
        return false;
    }
    
    private static boolean F(final int n) {
        return n == 4 || n == 13 || n == 14 || n == 3 || n == 0;
    }
    
    private boolean G(final HashMap hashMap) throws IOException {
        final d d = hashMap.get("ImageLength");
        final d d2 = hashMap.get("ImageWidth");
        if (d != null && d2 != null) {
            final int m = d.m(this.h);
            final int i = d2.m(this.h);
            if (m <= 512 && i <= 512) {
                return true;
            }
        }
        return false;
    }
    
    private boolean H(final byte[] array) throws IOException {
        int n = 0;
        while (true) {
            final byte[] l = androidx.exifinterface.media.a.L;
            if (n < l.length) {
                if (array[n] != l[n]) {
                    return false;
                }
                ++n;
            }
            else {
                int n2 = 0;
                while (true) {
                    final byte[] m = androidx.exifinterface.media.a.M;
                    if (n2 >= m.length) {
                        return true;
                    }
                    if (array[androidx.exifinterface.media.a.L.length + n2 + 4] != m[n2]) {
                        return false;
                    }
                    ++n2;
                }
            }
        }
    }
    
    private void I(final InputStream inputStream) {
        Objects.requireNonNull(inputStream, "inputstream shouldn't be null");
        int i = 0;
        try {
            Label_0292: {
                try {
                    while (i < androidx.exifinterface.media.a.j0.length) {
                        this.f[i] = new HashMap<String, d>();
                        ++i;
                    }
                    InputStream inputStream2 = inputStream;
                    if (!this.e) {
                        inputStream2 = new BufferedInputStream(inputStream, 5000);
                        this.d = this.i((BufferedInputStream)inputStream2);
                    }
                    if (X(this.d)) {
                        final g g = new g(inputStream2);
                        if (this.e) {
                            this.o(g);
                        }
                        else {
                            final int d = this.d;
                            if (d == 12) {
                                this.g(g);
                            }
                            else if (d == 7) {
                                this.j(g);
                            }
                            else if (d == 10) {
                                this.n(g);
                            }
                            else {
                                this.m(g);
                            }
                        }
                        g.h(this.p);
                        this.W((b)g);
                    }
                    else {
                        final b b = new b(inputStream2);
                        final int d2 = this.d;
                        if (d2 == 4) {
                            this.h(b, 0, 0);
                        }
                        else if (d2 == 13) {
                            this.k(b);
                        }
                        else if (d2 == 9) {
                            this.l(b);
                        }
                        else if (d2 == 14) {
                            this.r(b);
                        }
                    }
                    this.a();
                    if (androidx.exifinterface.media.a.v) {
                        break Label_0292;
                    }
                }
                finally {
                    this.a();
                    if (androidx.exifinterface.media.a.v) {
                        this.K();
                    }
                    final boolean v = androidx.exifinterface.media.a.v;
                    iftrue(Label_0284:)(!v);
                    Log.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", (Throwable)inputStream);
                    Label_0284: {
                        break Label_0284;
                        Label_0296: {
                            return;
                        }
                    }
                    this.a();
                    iftrue(Label_0296:)(!v);
                    this.K();
                }
            }
        }
        catch (final UnsupportedOperationException ex) {}
        catch (final IOException ex2) {}
    }
    
    private void J(final b b) throws IOException {
        b.d(this.h = this.L(b));
        final int unsignedShort = b.readUnsignedShort();
        final int d = this.d;
        if (d != 7 && d != 10 && unsignedShort != 42) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Invalid start code: ");
            sb.append(Integer.toHexString(unsignedShort));
            throw new IOException(sb.toString());
        }
        int int1 = b.readInt();
        if (int1 >= 8) {
            int1 -= 8;
            if (int1 > 0) {
                b.e(int1);
            }
            return;
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append("Invalid first Ifd offset: ");
        sb2.append(int1);
        throw new IOException(sb2.toString());
    }
    
    private void K() {
        for (int i = 0; i < this.f.length; ++i) {
            final StringBuilder sb = new StringBuilder();
            sb.append("The size of tag group[");
            sb.append(i);
            sb.append("]: ");
            sb.append(this.f[i].size());
            Log.d("ExifInterface", sb.toString());
            for (final Map.Entry<K, d> entry : this.f[i].entrySet()) {
                final d d = entry.getValue();
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("tagName: ");
                sb2.append((String)entry.getKey());
                sb2.append(", tagType: ");
                sb2.append(d.toString());
                sb2.append(", tagValue: '");
                sb2.append(d.n(this.h));
                sb2.append("'");
                Log.d("ExifInterface", sb2.toString());
            }
        }
    }
    
    private ByteOrder L(final b b) throws IOException {
        final short short1 = b.readShort();
        if (short1 == 18761) {
            if (androidx.exifinterface.media.a.v) {
                Log.d("ExifInterface", "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (short1 == 19789) {
            if (androidx.exifinterface.media.a.v) {
                Log.d("ExifInterface", "readExifSegment: Byte Align MM");
            }
            return ByteOrder.BIG_ENDIAN;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Invalid byte order: ");
        sb.append(Integer.toHexString(short1));
        throw new IOException(sb.toString());
    }
    
    private void M(final byte[] array, final int n) throws IOException {
        final g g = new g(array);
        this.J((b)g);
        this.N(g, n);
    }
    
    private void N(final g g, int int1) throws IOException {
        this.g.add(((b)g).c);
        final short short1 = ((b)g).readShort();
        final boolean v = androidx.exifinterface.media.a.v;
        final String s = "ExifInterface";
        if (v) {
            final StringBuilder sb = new StringBuilder();
            sb.append("numberOfDirectoryEntry: ");
            sb.append(short1);
            Log.d("ExifInterface", sb.toString());
        }
        if (short1 <= 0) {
            return;
        }
        for (short n = 0; n < short1; ++n) {
            final int unsignedShort = ((b)g).readUnsignedShort();
            int unsignedShort2 = ((b)g).readUnsignedShort();
            final int int2 = ((b)g).readInt();
            final long n2 = ((b)g).a() + 4L;
            final e e = androidx.exifinterface.media.a.l0[int1].get(unsignedShort);
            final boolean v2 = androidx.exifinterface.media.a.v;
            if (v2) {
                String b;
                if (e != null) {
                    b = e.b;
                }
                else {
                    b = null;
                }
                Log.d(s, String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", int1, unsignedShort, b, unsignedShort2, int2));
            }
            int c = 0;
            int n4 = 0;
            long n5 = 0L;
            Label_0537: {
                Label_0527: {
                    Label_0264: {
                        if (e == null) {
                            if (v2) {
                                final StringBuilder sb2 = new StringBuilder();
                                sb2.append("Skip the tag entry since tag number is not defined: ");
                                sb2.append(unsignedShort);
                                Log.d(s, sb2.toString());
                            }
                        }
                        else {
                            if (unsignedShort2 > 0) {
                                final int[] x = androidx.exifinterface.media.a.X;
                                if (unsignedShort2 < x.length) {
                                    if (!e.a(unsignedShort2)) {
                                        if (v2) {
                                            final StringBuilder sb3 = new StringBuilder();
                                            sb3.append("Skip the tag entry since data format (");
                                            sb3.append(androidx.exifinterface.media.a.W[unsignedShort2]);
                                            sb3.append(") is unexpected for tag: ");
                                            sb3.append(e.b);
                                            Log.d(s, sb3.toString());
                                        }
                                        break Label_0264;
                                    }
                                    else {
                                        if ((c = unsignedShort2) == 7) {
                                            c = e.c;
                                        }
                                        final long n3 = int2 * (long)x[c];
                                        if (n3 >= 0L && n3 <= 2147483647L) {
                                            n4 = 1;
                                            n5 = n3;
                                            break Label_0537;
                                        }
                                        n5 = n3;
                                        unsignedShort2 = c;
                                        if (v2) {
                                            final StringBuilder sb4 = new StringBuilder();
                                            sb4.append("Skip the tag entry since the number of components is invalid: ");
                                            sb4.append(int2);
                                            Log.d(s, sb4.toString());
                                            n5 = n3;
                                            unsignedShort2 = c;
                                        }
                                        break Label_0527;
                                    }
                                }
                            }
                            if (v2) {
                                final StringBuilder sb5 = new StringBuilder();
                                sb5.append("Skip the tag entry since data format is invalid: ");
                                sb5.append(unsignedShort2);
                                Log.d(s, sb5.toString());
                            }
                        }
                    }
                    n5 = 0L;
                }
                final int n6 = 0;
                c = unsignedShort2;
                n4 = n6;
            }
            if (n4 == 0) {
                g.h(n2);
            }
            else {
                if (n5 > 4L) {
                    final int int3 = ((b)g).readInt();
                    if (v2) {
                        final StringBuilder sb6 = new StringBuilder();
                        sb6.append("seek to data offset: ");
                        sb6.append(int3);
                        Log.d(s, sb6.toString());
                    }
                    if (this.d == 7) {
                        if ("MakerNote".equals(e.b)) {
                            this.q = int3;
                        }
                        else if (int1 == 6 && "ThumbnailImage".equals(e.b)) {
                            this.r = int3;
                            this.s = int2;
                            final d j = androidx.exifinterface.media.a.d.j(6, this.h);
                            final d f = androidx.exifinterface.media.a.d.f(this.r, this.h);
                            final d f2 = androidx.exifinterface.media.a.d.f(this.s, this.h);
                            this.f[4].put("Compression", j);
                            this.f[4].put("JPEGInterchangeFormat", f);
                            this.f[4].put("JPEGInterchangeFormatLength", f2);
                        }
                    }
                    g.h(int3);
                }
                final Integer n7 = androidx.exifinterface.media.a.o0.get(unsignedShort);
                if (v2) {
                    final StringBuilder sb7 = new StringBuilder();
                    sb7.append("nextIfdType: ");
                    sb7.append(n7);
                    sb7.append(" byteCount: ");
                    sb7.append(n5);
                    Log.d(s, sb7.toString());
                }
                final String s2 = s;
                if (n7 != null) {
                    long c2 = -1L;
                    Label_0933: {
                        int n8;
                        if (c != 3) {
                            if (c == 4) {
                                c2 = ((b)g).c();
                                break Label_0933;
                            }
                            if (c != 8) {
                                if (c != 9 && c != 13) {
                                    break Label_0933;
                                }
                                n8 = ((b)g).readInt();
                            }
                            else {
                                n8 = ((b)g).readShort();
                            }
                        }
                        else {
                            n8 = ((b)g).readUnsignedShort();
                        }
                        c2 = n8;
                    }
                    if (v2) {
                        Log.d(s2, String.format("Offset: %d, tagName: %s", c2, e.b));
                    }
                    if (c2 > 0L) {
                        if (!this.g.contains((int)c2)) {
                            g.h(c2);
                            this.N(g, n7);
                        }
                        else if (v2) {
                            final StringBuilder sb8 = new StringBuilder();
                            sb8.append("Skip jump into the IFD since it has already been read: IfdType ");
                            sb8.append(n7);
                            sb8.append(" (at ");
                            sb8.append(c2);
                            sb8.append(")");
                            Log.d(s2, sb8.toString());
                        }
                    }
                    else if (v2) {
                        final StringBuilder sb9 = new StringBuilder();
                        sb9.append("Skip jump into the IFD since its offset is invalid: ");
                        sb9.append(c2);
                        Log.d(s2, sb9.toString());
                    }
                    g.h(n2);
                }
                else {
                    final int a = ((b)g).a();
                    final int p2 = this.p;
                    final byte[] array = new byte[(int)n5];
                    ((b)g).readFully(array);
                    final d d = new d(c, int2, a + p2, array);
                    this.f[int1].put(e.b, d);
                    if ("DNGVersion".equals(e.b)) {
                        this.d = 3;
                    }
                    if ((("Make".equals(e.b) || "Model".equals(e.b)) && d.n(this.h).contains("PENTAX")) || ("Compression".equals(e.b) && d.m(this.h) == 65535)) {
                        this.d = 8;
                    }
                    if (((b)g).a() != n2) {
                        g.h(n2);
                    }
                }
            }
        }
        int1 = ((b)g).readInt();
        final boolean v3 = androidx.exifinterface.media.a.v;
        if (v3) {
            Log.d(s, String.format("nextIfdOffset: %d", int1));
        }
        final long n9 = int1;
        if (n9 > 0L) {
            if (!this.g.contains(int1)) {
                g.h(n9);
                if (this.f[4].isEmpty()) {
                    this.N(g, 4);
                }
                else if (this.f[5].isEmpty()) {
                    this.N(g, 5);
                }
            }
            else if (v3) {
                final StringBuilder sb10 = new StringBuilder();
                sb10.append("Stop reading file since re-reading an IFD may cause an infinite loop: ");
                sb10.append(int1);
                Log.d(s, sb10.toString());
            }
        }
        else if (v3) {
            final StringBuilder sb11 = new StringBuilder();
            sb11.append("Stop reading file since a wrong offset may cause an infinite loop: ");
            sb11.append(int1);
            Log.d(s, sb11.toString());
        }
    }
    
    private void O(final String s) {
        for (int i = 0; i < androidx.exifinterface.media.a.j0.length; ++i) {
            this.f[i].remove(s);
        }
    }
    
    private void P(final int n, final String s, final String s2) {
        if (!this.f[n].isEmpty() && this.f[n].get(s) != null) {
            final HashMap<String, d>[] f = this.f;
            f[n].put(s2, f[n].get(s));
            this.f[n].remove(s);
        }
    }
    
    private void Q(final g g, final int n) throws IOException {
        final d d = this.f[n].get("ImageLength");
        final d d2 = this.f[n].get("ImageWidth");
        if (d == null || d2 == null) {
            final d d3 = this.f[n].get("JPEGInterchangeFormat");
            final d d4 = this.f[n].get("JPEGInterchangeFormatLength");
            if (d3 != null && d4 != null) {
                final int m = d3.m(this.h);
                final int i = d3.m(this.h);
                g.h(m);
                final byte[] array = new byte[i];
                g.read(array);
                this.h(new b(array), m, n);
            }
        }
    }
    
    private void S(final InputStream inputStream, final OutputStream outputStream) throws IOException {
        if (androidx.exifinterface.media.a.v) {
            final StringBuilder sb = new StringBuilder();
            sb.append("saveJpegAttributes starting with (inputStream: ");
            sb.append(inputStream);
            sb.append(", outputStream: ");
            sb.append(outputStream);
            sb.append(")");
            Log.d("ExifInterface", sb.toString());
        }
        final b b = new b(inputStream);
        final c c = new c(outputStream, ByteOrder.BIG_ENDIAN);
        if (b.readByte() != -1) {
            throw new IOException("Invalid marker");
        }
        c.c(-1);
        if (b.readByte() == -40) {
            c.c(-40);
            d d2;
            final d d = d2 = null;
            if (this.d("Xmp") != null) {
                d2 = d;
                if (this.u) {
                    d2 = this.f[0].remove("Xmp");
                }
            }
            c.c(-1);
            c.c(-31);
            this.b0(c);
            if (d2 != null) {
                this.f[0].put("Xmp", d2);
            }
            final byte[] array = new byte[4096];
            while (b.readByte() == -1) {
                final byte byte1 = b.readByte();
                if (byte1 == -39 || byte1 == -38) {
                    c.c(-1);
                    c.c(byte1);
                    androidx.exifinterface.media.b.e(b, c);
                    return;
                }
                if (byte1 != -31) {
                    c.c(-1);
                    c.c(byte1);
                    int i = b.readUnsignedShort();
                    c.i(i);
                    i -= 2;
                    if (i < 0) {
                        throw new IOException("Invalid length");
                    }
                    while (i > 0) {
                        final int read = b.read(array, 0, Math.min(i, 4096));
                        if (read < 0) {
                            break;
                        }
                        c.write(array, 0, read);
                        i -= read;
                    }
                }
                else {
                    final int n = b.readUnsignedShort() - 2;
                    if (n < 0) {
                        throw new IOException("Invalid length");
                    }
                    final byte[] array2 = new byte[6];
                    if (n >= 6) {
                        if (b.read(array2) != 6) {
                            throw new IOException("Invalid exif");
                        }
                        if (Arrays.equals(array2, androidx.exifinterface.media.a.q0)) {
                            b.e(n - 6);
                            continue;
                        }
                    }
                    c.c(-1);
                    c.c(byte1);
                    c.i(n + 2);
                    int j;
                    if ((j = n) >= 6) {
                        j = n - 6;
                        c.write(array2);
                    }
                    while (j > 0) {
                        final int read2 = b.read(array, 0, Math.min(j, 4096));
                        if (read2 < 0) {
                            break;
                        }
                        c.write(array, 0, read2);
                        j -= read2;
                    }
                }
            }
            throw new IOException("Invalid marker");
        }
        throw new IOException("Invalid marker");
    }
    
    private void T(InputStream inputStream, final OutputStream outputStream) throws IOException {
        if (androidx.exifinterface.media.a.v) {
            final StringBuilder sb = new StringBuilder();
            sb.append("savePngAttributes starting with (inputStream: ");
            sb.append(inputStream);
            sb.append(", outputStream: ");
            sb.append(outputStream);
            sb.append(")");
            Log.d("ExifInterface", sb.toString());
        }
        final b b = new b(inputStream);
        final ByteOrder big_ENDIAN = ByteOrder.BIG_ENDIAN;
        final c c = new c(outputStream, big_ENDIAN);
        final byte[] h = androidx.exifinterface.media.a.H;
        androidx.exifinterface.media.b.f(b, c, h.length);
        final int p2 = this.p;
        if (p2 == 0) {
            final int int1 = b.readInt();
            c.d(int1);
            androidx.exifinterface.media.b.f(b, c, int1 + 4 + 4);
        }
        else {
            androidx.exifinterface.media.b.f(b, c, p2 - h.length - 4 - 4);
            b.e(b.readInt() + 4 + 4);
        }
        Object byteArray = null;
        Throwable t;
        try {
            inputStream = (InputStream)new ByteArrayOutputStream();
            try {
                byteArray = new c((OutputStream)inputStream, big_ENDIAN);
                this.b0((c)byteArray);
                byteArray = ((ByteArrayOutputStream)((c)byteArray).a).toByteArray();
                c.write((byte[])byteArray);
                final CRC32 crc32 = new CRC32();
                crc32.update((byte[])byteArray, 4, ((byte[])byteArray).length - 4);
                c.d((int)crc32.getValue());
                androidx.exifinterface.media.b.c(inputStream);
                androidx.exifinterface.media.b.e(b, c);
                return;
            }
            finally {}
        }
        finally {
            final Throwable t2;
            t = t2;
        }
        androidx.exifinterface.media.b.c((Closeable)byteArray);
        throw t;
    }
    
    private void U(final InputStream inputStream, OutputStream outputStream) throws IOException {
        Object o = null;
        if (androidx.exifinterface.media.a.v) {
            o = new StringBuilder();
            ((StringBuilder)o).append("saveWebpAttributes starting with (inputStream: ");
            ((StringBuilder)o).append(inputStream);
            ((StringBuilder)o).append(", outputStream: ");
            ((StringBuilder)o).append(outputStream);
            ((StringBuilder)o).append(")");
            Log.d("ExifInterface", ((StringBuilder)o).toString());
        }
        final ByteOrder little_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        final b b = new b(inputStream, little_ENDIAN);
        final c c = new c(outputStream, little_ENDIAN);
        final byte[] l = androidx.exifinterface.media.a.L;
        androidx.exifinterface.media.b.f(b, c, l.length);
        final byte[] m = androidx.exifinterface.media.a.M;
        b.e(m.length + 4);
        byte[] array = null;
        final OutputStream outputStream2 = outputStream = null;
        try {
            try {
                o = new(java.io.ByteArrayOutputStream.class)();
                outputStream = outputStream2;
                new ByteArrayOutputStream();
                try {
                    outputStream = new c((OutputStream)o, little_ENDIAN);
                    final int p = this.p;
                    if (p != 0) {
                        androidx.exifinterface.media.b.f(b, outputStream, p - (l.length + 4 + m.length) - 4 - 4);
                        b.e(4);
                        b.e(b.readInt());
                        this.b0((c)outputStream);
                    }
                    else {
                        array = new byte[4];
                        if (b.read(array) != 4) {
                            throw new IOException("Encountered invalid length while parsing WebP chunk type");
                        }
                        final byte[] p2 = androidx.exifinterface.media.a.P;
                        final boolean equals = Arrays.equals(array, p2);
                        final int n = 1;
                        if (equals) {
                            final int int1 = b.readInt();
                            int n2;
                            if (int1 % 2 == 1) {
                                n2 = int1 + 1;
                            }
                            else {
                                n2 = int1;
                            }
                            array = new byte[n2];
                            b.read(array);
                            array[0] |= 0x8;
                            int n3;
                            if ((array[0] >> 1 & 0x1) == 0x1) {
                                n3 = n;
                            }
                            else {
                                n3 = 0;
                            }
                            ((c)outputStream).write(p2);
                            ((c)outputStream).d(int1);
                            ((c)outputStream).write(array);
                            if (n3 != 0) {
                                this.b(b, (c)outputStream, androidx.exifinterface.media.a.S, null);
                                while (true) {
                                    array = new byte[4];
                                    inputStream.read(array);
                                    if (!Arrays.equals(array, androidx.exifinterface.media.a.T)) {
                                        break;
                                    }
                                    this.c(b, (c)outputStream, array);
                                }
                                this.b0((c)outputStream);
                            }
                            else {
                                this.b(b, (c)outputStream, androidx.exifinterface.media.a.R, androidx.exifinterface.media.a.Q);
                                this.b0((c)outputStream);
                            }
                        }
                        else {
                            final byte[] r = androidx.exifinterface.media.a.R;
                            if (Arrays.equals(array, r) || Arrays.equals(array, androidx.exifinterface.media.a.Q)) {
                                final int int2 = b.readInt();
                                int n4;
                                if (int2 % 2 == 1) {
                                    n4 = int2 + 1;
                                }
                                else {
                                    n4 = int2;
                                }
                                final byte[] array2 = new byte[3];
                                int n5;
                                int n6;
                                int n7;
                                int n8;
                                if (Arrays.equals(array, r)) {
                                    b.read(array2);
                                    final byte[] array3 = new byte[3];
                                    if (b.read(array3) != 3 || !Arrays.equals(androidx.exifinterface.media.a.O, array3)) {
                                        throw new IOException("Encountered error while checking VP8 signature");
                                    }
                                    n5 = b.readInt();
                                    n6 = n5 << 18 >> 18;
                                    n7 = n5 << 2 >> 18;
                                    n4 -= 10;
                                    n8 = 0;
                                }
                                else if (Arrays.equals(array, androidx.exifinterface.media.a.Q)) {
                                    if (b.readByte() != 47) {
                                        throw new IOException("Encountered error while checking VP8L signature");
                                    }
                                    n5 = b.readInt();
                                    n8 = (n5 & 0x8);
                                    n4 -= 5;
                                    n7 = (n5 << 4 >> 18) + 1;
                                    n6 = (n5 << 18 >> 18) + 1;
                                }
                                else {
                                    n5 = 0;
                                    n6 = 0;
                                    n7 = (n8 = n6);
                                }
                                ((c)outputStream).write(p2);
                                ((c)outputStream).d(10);
                                final byte[] array4 = new byte[10];
                                array4[0] |= 0x8;
                                array4[0] |= (byte)(n8 << 4);
                                --n6;
                                --n7;
                                array4[4] = (byte)n6;
                                array4[5] = (byte)(n6 >> 8);
                                array4[6] = (byte)(n6 >> 16);
                                array4[7] = (byte)n7;
                                array4[8] = (byte)(n7 >> 8);
                                array4[9] = (byte)(n7 >> 16);
                                ((c)outputStream).write(array4);
                                ((c)outputStream).write(array);
                                ((c)outputStream).d(int2);
                                if (Arrays.equals(array, r)) {
                                    ((c)outputStream).write(array2);
                                    ((c)outputStream).write(androidx.exifinterface.media.a.O);
                                    ((c)outputStream).d(n5);
                                }
                                else if (Arrays.equals(array, androidx.exifinterface.media.a.Q)) {
                                    ((FilterOutputStream)outputStream).write(47);
                                    ((c)outputStream).d(n5);
                                }
                                androidx.exifinterface.media.b.f(b, outputStream, n4);
                                this.b0((c)outputStream);
                            }
                        }
                    }
                    androidx.exifinterface.media.b.e(b, outputStream);
                    final int size = ((ByteArrayOutputStream)o).size();
                    final byte[] i = androidx.exifinterface.media.a.M;
                    c.d(size + i.length);
                    c.write(i);
                    ((ByteArrayOutputStream)o).writeTo(c);
                    androidx.exifinterface.media.b.c((Closeable)o);
                    return;
                }
                catch (final Exception ex) {
                    outputStream = (OutputStream)o;
                    o = ex;
                }
                finally {
                    outputStream = (OutputStream)o;
                }
            }
            finally {}
        }
        catch (final Exception o) {}
        throw new IOException("Failed to save WebP file", (Throwable)o);
        androidx.exifinterface.media.b.c(outputStream);
    }
    
    private void W(final b b) throws IOException {
        final HashMap<String, d> hashMap = this.f[4];
        final d d = hashMap.get("Compression");
        if (d != null) {
            final int m = d.m(this.h);
            if ((this.o = m) != 1) {
                if (m == 6) {
                    this.t(b, hashMap);
                    return;
                }
                if (m != 7) {
                    return;
                }
            }
            if (this.E(hashMap)) {
                this.u(b, hashMap);
            }
        }
        else {
            this.o = 6;
            this.t(b, hashMap);
        }
    }
    
    private static boolean X(final int n) {
        return n != 4 && n != 9 && n != 13 && n != 14;
    }
    
    private void Y(final int n, final int n2) throws IOException {
        if (!this.f[n].isEmpty() && !this.f[n2].isEmpty()) {
            final d d = this.f[n].get("ImageLength");
            final d d2 = this.f[n].get("ImageWidth");
            final d d3 = this.f[n2].get("ImageLength");
            final d d4 = this.f[n2].get("ImageWidth");
            if (d != null && d2 != null) {
                if (d3 != null && d4 != null) {
                    final int m = d.m(this.h);
                    final int i = d2.m(this.h);
                    final int j = d3.m(this.h);
                    final int k = d4.m(this.h);
                    if (m < j && i < k) {
                        final HashMap<String, d>[] f = this.f;
                        final HashMap<String, d> hashMap = f[n];
                        f[n] = f[n2];
                        f[n2] = hashMap;
                    }
                }
                else if (androidx.exifinterface.media.a.v) {
                    Log.d("ExifInterface", "Second image does not contain valid size information");
                }
            }
            else if (androidx.exifinterface.media.a.v) {
                Log.d("ExifInterface", "First image does not contain valid size information");
            }
            return;
        }
        if (androidx.exifinterface.media.a.v) {
            Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
        }
    }
    
    private void Z(final g g, final int n) throws IOException {
        final d d = this.f[n].get("DefaultCropSize");
        final d d2 = this.f[n].get("SensorTopBorder");
        final d d3 = this.f[n].get("SensorLeftBorder");
        final d d4 = this.f[n].get("SensorBottomBorder");
        final d d5 = this.f[n].get("SensorRightBorder");
        if (d != null) {
            d d6;
            d d7;
            if (d.a == 5) {
                final f[] array = (f[])d.o(this.h);
                if (array == null || array.length != 2) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Invalid crop size values. cropSize=");
                    sb.append(Arrays.toString(array));
                    Log.w("ExifInterface", sb.toString());
                    return;
                }
                d6 = androidx.exifinterface.media.a.d.h(array[0], this.h);
                d7 = androidx.exifinterface.media.a.d.h(array[1], this.h);
            }
            else {
                final int[] array2 = (int[])d.o(this.h);
                if (array2 == null || array2.length != 2) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Invalid crop size values. cropSize=");
                    sb2.append(Arrays.toString(array2));
                    Log.w("ExifInterface", sb2.toString());
                    return;
                }
                d6 = androidx.exifinterface.media.a.d.j(array2[0], this.h);
                d7 = androidx.exifinterface.media.a.d.j(array2[1], this.h);
            }
            this.f[n].put("ImageWidth", d6);
            this.f[n].put("ImageLength", d7);
        }
        else if (d2 != null && d3 != null && d4 != null && d5 != null) {
            final int m = d2.m(this.h);
            final int i = d4.m(this.h);
            final int j = d5.m(this.h);
            final int k = d3.m(this.h);
            if (i > m && j > k) {
                final d l = androidx.exifinterface.media.a.d.j(i - m, this.h);
                final d j2 = androidx.exifinterface.media.a.d.j(j - k, this.h);
                this.f[n].put("ImageLength", l);
                this.f[n].put("ImageWidth", j2);
            }
        }
        else {
            this.Q(g, n);
        }
    }
    
    private void a() {
        final String d = this.d("DateTimeOriginal");
        if (d != null && this.d("DateTime") == null) {
            this.f[0].put("DateTime", androidx.exifinterface.media.a.d.e(d));
        }
        if (this.d("ImageWidth") == null) {
            this.f[0].put("ImageWidth", androidx.exifinterface.media.a.d.f(0L, this.h));
        }
        if (this.d("ImageLength") == null) {
            this.f[0].put("ImageLength", androidx.exifinterface.media.a.d.f(0L, this.h));
        }
        if (this.d("Orientation") == null) {
            this.f[0].put("Orientation", androidx.exifinterface.media.a.d.f(0L, this.h));
        }
        if (this.d("LightSource") == null) {
            this.f[1].put("LightSource", androidx.exifinterface.media.a.d.f(0L, this.h));
        }
    }
    
    private void a0() throws IOException {
        this.Y(0, 5);
        this.Y(0, 4);
        this.Y(5, 4);
        final d d = this.f[1].get("PixelXDimension");
        final d d2 = this.f[1].get("PixelYDimension");
        if (d != null && d2 != null) {
            this.f[0].put("ImageWidth", d);
            this.f[0].put("ImageLength", d2);
        }
        if (this.f[4].isEmpty() && this.G(this.f[5])) {
            final HashMap<String, d>[] f = this.f;
            f[4] = f[5];
            f[5] = new HashMap<String, d>();
        }
        if (!this.G(this.f[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        this.P(0, "ThumbnailOrientation", "Orientation");
        this.P(0, "ThumbnailImageLength", "ImageLength");
        this.P(0, "ThumbnailImageWidth", "ImageWidth");
        this.P(5, "ThumbnailOrientation", "Orientation");
        this.P(5, "ThumbnailImageLength", "ImageLength");
        this.P(5, "ThumbnailImageWidth", "ImageWidth");
        this.P(4, "Orientation", "ThumbnailOrientation");
        this.P(4, "ImageLength", "ThumbnailImageLength");
        this.P(4, "ImageWidth", "ThumbnailImageWidth");
    }
    
    private void b(final b b, final c c, final byte[] array, final byte[] array2) throws IOException {
        byte[] array3;
        do {
            array3 = new byte[4];
            if (b.read(array3) != 4) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Encountered invalid length while copying WebP chunks up tochunk type ");
                final Charset p4 = androidx.exifinterface.media.a.p0;
                sb.append(new String(array, p4));
                String string;
                if (array2 == null) {
                    string = "";
                }
                else {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append(" or ");
                    sb2.append(new String(array2, p4));
                    string = sb2.toString();
                }
                sb.append(string);
                throw new IOException(sb.toString());
            }
            this.c(b, c, array3);
        } while (!Arrays.equals(array3, array) && (array2 == null || !Arrays.equals(array3, array2)));
    }
    
    private int b0(final c c) throws IOException {
        final e[][] j0 = androidx.exifinterface.media.a.j0;
        final int[] array = new int[j0.length];
        final int[] array2 = new int[j0.length];
        final e[] k0 = androidx.exifinterface.media.a.k0;
        for (int length = k0.length, i = 0; i < length; ++i) {
            this.O(k0[i].b);
        }
        if (this.i) {
            if (this.j) {
                this.O("StripOffsets");
                this.O("StripByteCounts");
            }
            else {
                this.O("JPEGInterchangeFormat");
                this.O("JPEGInterchangeFormatLength");
            }
        }
        for (int l = 0; l < androidx.exifinterface.media.a.j0.length; ++l) {
            final Object[] array3 = this.f[l].entrySet().toArray();
            for (int length2 = array3.length, n = 0; n < length2; ++n) {
                final Map.Entry entry = (Map.Entry)array3[n];
                if (entry.getValue() == null) {
                    this.f[l].remove(entry.getKey());
                }
            }
        }
        if (!this.f[1].isEmpty()) {
            this.f[0].put(androidx.exifinterface.media.a.k0[1].b, androidx.exifinterface.media.a.d.f(0L, this.h));
        }
        if (!this.f[2].isEmpty()) {
            this.f[0].put(androidx.exifinterface.media.a.k0[2].b, androidx.exifinterface.media.a.d.f(0L, this.h));
        }
        if (!this.f[3].isEmpty()) {
            this.f[1].put(androidx.exifinterface.media.a.k0[3].b, androidx.exifinterface.media.a.d.f(0L, this.h));
        }
        if (this.i) {
            if (this.j) {
                this.f[4].put("StripOffsets", androidx.exifinterface.media.a.d.j(0, this.h));
                this.f[4].put("StripByteCounts", androidx.exifinterface.media.a.d.j(this.m, this.h));
            }
            else {
                this.f[4].put("JPEGInterchangeFormat", androidx.exifinterface.media.a.d.f(0L, this.h));
                this.f[4].put("JPEGInterchangeFormatLength", androidx.exifinterface.media.a.d.f(this.m, this.h));
            }
        }
        for (int n2 = 0; n2 < androidx.exifinterface.media.a.j0.length; ++n2) {
            final Iterator<Map.Entry<String, d>> iterator = this.f[n2].entrySet().iterator();
            int n3 = 0;
            while (iterator.hasNext()) {
                final int p = ((Map.Entry<K, d>)iterator.next()).getValue().p();
                if (p > 4) {
                    n3 += p;
                }
            }
            array2[n2] += n3;
        }
        int m = 8;
        int n5;
        for (int n4 = 0; n4 < androidx.exifinterface.media.a.j0.length; ++n4, m = n5) {
            n5 = m;
            if (!this.f[n4].isEmpty()) {
                array[n4] = m;
                n5 = m + (this.f[n4].size() * 12 + 2 + 4 + array2[n4]);
            }
        }
        int n6 = m;
        if (this.i) {
            if (this.j) {
                this.f[4].put("StripOffsets", androidx.exifinterface.media.a.d.j(m, this.h));
            }
            else {
                this.f[4].put("JPEGInterchangeFormat", androidx.exifinterface.media.a.d.f(m, this.h));
            }
            this.l = m;
            n6 = m + this.m;
        }
        int n7 = n6;
        if (this.d == 4) {
            n7 = n6 + 8;
        }
        if (androidx.exifinterface.media.a.v) {
            for (int n8 = 0; n8 < androidx.exifinterface.media.a.j0.length; ++n8) {
                Log.d("ExifInterface", String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", n8, array[n8], this.f[n8].size(), array2[n8], n7));
            }
        }
        if (!this.f[1].isEmpty()) {
            this.f[0].put(androidx.exifinterface.media.a.k0[1].b, androidx.exifinterface.media.a.d.f(array[1], this.h));
        }
        if (!this.f[2].isEmpty()) {
            this.f[0].put(androidx.exifinterface.media.a.k0[2].b, androidx.exifinterface.media.a.d.f(array[2], this.h));
        }
        if (!this.f[3].isEmpty()) {
            this.f[1].put(androidx.exifinterface.media.a.k0[3].b, androidx.exifinterface.media.a.d.f(array[3], this.h));
        }
        final int d = this.d;
        if (d != 4) {
            if (d != 13) {
                if (d == 14) {
                    c.write(androidx.exifinterface.media.a.N);
                    c.d(n7);
                }
            }
            else {
                c.d(n7);
                c.write(androidx.exifinterface.media.a.I);
            }
        }
        else {
            c.i(n7);
            c.write(androidx.exifinterface.media.a.q0);
        }
        short n9;
        if (this.h == ByteOrder.BIG_ENDIAN) {
            n9 = 19789;
        }
        else {
            n9 = 18761;
        }
        c.e(n9);
        c.a(this.h);
        c.i(42);
        c.h(8L);
        for (int n10 = 0; n10 < androidx.exifinterface.media.a.j0.length; ++n10) {
            if (!this.f[n10].isEmpty()) {
                c.i(this.f[n10].size());
                int n11 = array[n10] + 2 + this.f[n10].size() * 12 + 4;
                for (final Map.Entry<Object, V> entry2 : this.f[n10].entrySet()) {
                    final int a = androidx.exifinterface.media.a.m0[n10].get(entry2.getKey()).a;
                    final d d2 = (d)entry2.getValue();
                    int p2 = d2.p();
                    c.i(a);
                    c.i(d2.a);
                    c.d(d2.b);
                    int n12;
                    if (p2 > 4) {
                        c.h(n11);
                        n12 = n11 + p2;
                    }
                    else {
                        c.write(d2.d);
                        n12 = n11;
                        if (p2 < 4) {
                            while (true) {
                                n12 = n11;
                                if (p2 >= 4) {
                                    break;
                                }
                                c.c(0);
                                ++p2;
                            }
                        }
                    }
                    n11 = n12;
                }
                if (n10 == 0 && !this.f[4].isEmpty()) {
                    c.h(array[4]);
                }
                else {
                    c.h(0L);
                }
                final Iterator<Map.Entry<String, d>> iterator3 = this.f[n10].entrySet().iterator();
                while (iterator3.hasNext()) {
                    final byte[] d3 = ((Map.Entry<K, d>)iterator3.next()).getValue().d;
                    if (d3.length > 4) {
                        c.write(d3, 0, d3.length);
                    }
                }
            }
        }
        if (this.i) {
            c.write(this.q());
        }
        if (this.d == 14 && n7 % 2 == 1) {
            c.c(0);
        }
        c.a(ByteOrder.BIG_ENDIAN);
        return n7;
    }
    
    private void c(final b b, final c c, final byte[] array) throws IOException {
        final int int1 = b.readInt();
        c.write(array);
        c.d(int1);
        int n = int1;
        if (int1 % 2 == 1) {
            n = int1 + 1;
        }
        b.f(b, c, n);
    }
    
    private d f(final String s) {
        Objects.requireNonNull(s, "tag shouldn't be null");
        String s2 = s;
        if ("ISOSpeedRatings".equals(s)) {
            if (androidx.exifinterface.media.a.v) {
                Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            s2 = "PhotographicSensitivity";
        }
        for (int i = 0; i < androidx.exifinterface.media.a.j0.length; ++i) {
            final d d = this.f[i].get(s2);
            if (d != null) {
                return d;
            }
        }
        return null;
    }
    
    private void g(final g p0) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: bipush          28
        //     5: if_icmplt       548
        //     8: new             Landroid/media/MediaMetadataRetriever;
        //    11: dup            
        //    12: invokespecial   android/media/MediaMetadataRetriever.<init>:()V
        //    15: astore          8
        //    17: new             Landroidx/exifinterface/media/a$a;
        //    20: astore          5
        //    22: aload           5
        //    24: aload_0        
        //    25: aload_1        
        //    26: invokespecial   androidx/exifinterface/media/a$a.<init>:(Landroidx/exifinterface/media/a;Landroidx/exifinterface/media/a$g;)V
        //    29: aload           8
        //    31: aload           5
        //    33: invokestatic    androidx/exifinterface/media/b$b.a:(Landroid/media/MediaMetadataRetriever;Landroid/media/MediaDataSource;)V
        //    36: aload           8
        //    38: bipush          33
        //    40: invokevirtual   android/media/MediaMetadataRetriever.extractMetadata:(I)Ljava/lang/String;
        //    43: astore          9
        //    45: aload           8
        //    47: bipush          34
        //    49: invokevirtual   android/media/MediaMetadataRetriever.extractMetadata:(I)Ljava/lang/String;
        //    52: astore          10
        //    54: aload           8
        //    56: bipush          26
        //    58: invokevirtual   android/media/MediaMetadataRetriever.extractMetadata:(I)Ljava/lang/String;
        //    61: astore          6
        //    63: aload           8
        //    65: bipush          17
        //    67: invokevirtual   android/media/MediaMetadataRetriever.extractMetadata:(I)Ljava/lang/String;
        //    70: astore          5
        //    72: ldc_w           "yes"
        //    75: aload           6
        //    77: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    80: istore          4
        //    82: aconst_null    
        //    83: astore          7
        //    85: iload           4
        //    87: ifeq            120
        //    90: aload           8
        //    92: bipush          29
        //    94: invokevirtual   android/media/MediaMetadataRetriever.extractMetadata:(I)Ljava/lang/String;
        //    97: astore          7
        //    99: aload           8
        //   101: bipush          30
        //   103: invokevirtual   android/media/MediaMetadataRetriever.extractMetadata:(I)Ljava/lang/String;
        //   106: astore          5
        //   108: aload           8
        //   110: bipush          31
        //   112: invokevirtual   android/media/MediaMetadataRetriever.extractMetadata:(I)Ljava/lang/String;
        //   115: astore          6
        //   117: goto            167
        //   120: ldc_w           "yes"
        //   123: aload           5
        //   125: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   128: ifeq            161
        //   131: aload           8
        //   133: bipush          18
        //   135: invokevirtual   android/media/MediaMetadataRetriever.extractMetadata:(I)Ljava/lang/String;
        //   138: astore          7
        //   140: aload           8
        //   142: bipush          19
        //   144: invokevirtual   android/media/MediaMetadataRetriever.extractMetadata:(I)Ljava/lang/String;
        //   147: astore          5
        //   149: aload           8
        //   151: bipush          24
        //   153: invokevirtual   android/media/MediaMetadataRetriever.extractMetadata:(I)Ljava/lang/String;
        //   156: astore          6
        //   158: goto            167
        //   161: aconst_null    
        //   162: astore          5
        //   164: aconst_null    
        //   165: astore          6
        //   167: aload           7
        //   169: ifnull          197
        //   172: aload_0        
        //   173: getfield        androidx/exifinterface/media/a.f:[Ljava/util/HashMap;
        //   176: iconst_0       
        //   177: aaload         
        //   178: ldc_w           "ImageWidth"
        //   181: aload           7
        //   183: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //   186: aload_0        
        //   187: getfield        androidx/exifinterface/media/a.h:Ljava/nio/ByteOrder;
        //   190: invokestatic    androidx/exifinterface/media/a$d.j:(ILjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;
        //   193: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   196: pop            
        //   197: aload           5
        //   199: ifnull          227
        //   202: aload_0        
        //   203: getfield        androidx/exifinterface/media/a.f:[Ljava/util/HashMap;
        //   206: iconst_0       
        //   207: aaload         
        //   208: ldc_w           "ImageLength"
        //   211: aload           5
        //   213: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //   216: aload_0        
        //   217: getfield        androidx/exifinterface/media/a.h:Ljava/nio/ByteOrder;
        //   220: invokestatic    androidx/exifinterface/media/a$d.j:(ILjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;
        //   223: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   226: pop            
        //   227: aload           6
        //   229: ifnull          298
        //   232: iconst_1       
        //   233: istore_2       
        //   234: aload           6
        //   236: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //   239: istore_3       
        //   240: iload_3        
        //   241: bipush          90
        //   243: if_icmpeq       274
        //   246: iload_3        
        //   247: sipush          180
        //   250: if_icmpeq       269
        //   253: iload_3        
        //   254: sipush          270
        //   257: if_icmpeq       263
        //   260: goto            277
        //   263: bipush          8
        //   265: istore_2       
        //   266: goto            277
        //   269: iconst_3       
        //   270: istore_2       
        //   271: goto            277
        //   274: bipush          6
        //   276: istore_2       
        //   277: aload_0        
        //   278: getfield        androidx/exifinterface/media/a.f:[Ljava/util/HashMap;
        //   281: iconst_0       
        //   282: aaload         
        //   283: ldc_w           "Orientation"
        //   286: iload_2        
        //   287: aload_0        
        //   288: getfield        androidx/exifinterface/media/a.h:Ljava/nio/ByteOrder;
        //   291: invokestatic    androidx/exifinterface/media/a$d.j:(ILjava/nio/ByteOrder;)Landroidx/exifinterface/media/a$d;
        //   294: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   297: pop            
        //   298: aload           9
        //   300: ifnull          448
        //   303: aload           10
        //   305: ifnull          448
        //   308: aload           9
        //   310: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //   313: istore_2       
        //   314: aload           10
        //   316: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //   319: istore_3       
        //   320: iload_3        
        //   321: bipush          6
        //   323: if_icmple       435
        //   326: aload_1        
        //   327: iload_2        
        //   328: i2l            
        //   329: invokevirtual   androidx/exifinterface/media/a$g.h:(J)V
        //   332: bipush          6
        //   334: newarray        B
        //   336: astore          9
        //   338: aload_1        
        //   339: aload           9
        //   341: invokevirtual   java/io/InputStream.read:([B)I
        //   344: bipush          6
        //   346: if_icmpne       422
        //   349: iinc            3, -6
        //   352: aload           9
        //   354: getstatic       androidx/exifinterface/media/a.q0:[B
        //   357: invokestatic    java/util/Arrays.equals:([B[B)Z
        //   360: ifeq            409
        //   363: iload_3        
        //   364: newarray        B
        //   366: astore          9
        //   368: aload_1        
        //   369: aload           9
        //   371: invokevirtual   java/io/InputStream.read:([B)I
        //   374: iload_3        
        //   375: if_icmpne       396
        //   378: aload_0        
        //   379: iload_2        
        //   380: bipush          6
        //   382: iadd           
        //   383: putfield        androidx/exifinterface/media/a.p:I
        //   386: aload_0        
        //   387: aload           9
        //   389: iconst_0       
        //   390: invokespecial   androidx/exifinterface/media/a.M:([BI)V
        //   393: goto            448
        //   396: new             Ljava/io/IOException;
        //   399: astore_1       
        //   400: aload_1        
        //   401: ldc_w           "Can't read exif"
        //   404: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //   407: aload_1        
        //   408: athrow         
        //   409: new             Ljava/io/IOException;
        //   412: astore_1       
        //   413: aload_1        
        //   414: ldc_w           "Invalid identifier"
        //   417: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //   420: aload_1        
        //   421: athrow         
        //   422: new             Ljava/io/IOException;
        //   425: astore_1       
        //   426: aload_1        
        //   427: ldc_w           "Can't read identifier"
        //   430: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //   433: aload_1        
        //   434: athrow         
        //   435: new             Ljava/io/IOException;
        //   438: astore_1       
        //   439: aload_1        
        //   440: ldc_w           "Invalid exif length"
        //   443: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //   446: aload_1        
        //   447: athrow         
        //   448: getstatic       androidx/exifinterface/media/a.v:Z
        //   451: ifeq            517
        //   454: new             Ljava/lang/StringBuilder;
        //   457: astore_1       
        //   458: aload_1        
        //   459: invokespecial   java/lang/StringBuilder.<init>:()V
        //   462: aload_1        
        //   463: ldc_w           "Heif meta: "
        //   466: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   469: pop            
        //   470: aload_1        
        //   471: aload           7
        //   473: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   476: pop            
        //   477: aload_1        
        //   478: ldc_w           "x"
        //   481: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   484: pop            
        //   485: aload_1        
        //   486: aload           5
        //   488: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   491: pop            
        //   492: aload_1        
        //   493: ldc_w           ", rotation "
        //   496: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   499: pop            
        //   500: aload_1        
        //   501: aload           6
        //   503: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   506: pop            
        //   507: ldc             "ExifInterface"
        //   509: aload_1        
        //   510: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   513: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
        //   516: pop            
        //   517: aload           8
        //   519: invokevirtual   android/media/MediaMetadataRetriever.release:()V
        //   522: return         
        //   523: astore_1       
        //   524: goto            541
        //   527: astore_1       
        //   528: new             Ljava/lang/UnsupportedOperationException;
        //   531: astore_1       
        //   532: aload_1        
        //   533: ldc_w           "Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported."
        //   536: invokespecial   java/lang/UnsupportedOperationException.<init>:(Ljava/lang/String;)V
        //   539: aload_1        
        //   540: athrow         
        //   541: aload           8
        //   543: invokevirtual   android/media/MediaMetadataRetriever.release:()V
        //   546: aload_1        
        //   547: athrow         
        //   548: new             Ljava/lang/UnsupportedOperationException;
        //   551: dup            
        //   552: ldc_w           "Reading EXIF from HEIF files is supported from SDK 28 and above"
        //   555: invokespecial   java/lang/UnsupportedOperationException.<init>:(Ljava/lang/String;)V
        //   558: athrow         
        //    Exceptions:
        //  throws java.io.IOException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                        
        //  -----  -----  -----  -----  ----------------------------
        //  17     82     527    541    Ljava/lang/RuntimeException;
        //  17     82     523    527    Any
        //  90     117    527    541    Ljava/lang/RuntimeException;
        //  90     117    523    527    Any
        //  120    158    527    541    Ljava/lang/RuntimeException;
        //  120    158    523    527    Any
        //  172    197    527    541    Ljava/lang/RuntimeException;
        //  172    197    523    527    Any
        //  202    227    527    541    Ljava/lang/RuntimeException;
        //  202    227    523    527    Any
        //  234    240    527    541    Ljava/lang/RuntimeException;
        //  234    240    523    527    Any
        //  277    298    527    541    Ljava/lang/RuntimeException;
        //  277    298    523    527    Any
        //  308    320    527    541    Ljava/lang/RuntimeException;
        //  308    320    523    527    Any
        //  326    349    527    541    Ljava/lang/RuntimeException;
        //  326    349    523    527    Any
        //  352    393    527    541    Ljava/lang/RuntimeException;
        //  352    393    523    527    Any
        //  396    409    527    541    Ljava/lang/RuntimeException;
        //  396    409    523    527    Any
        //  409    422    527    541    Ljava/lang/RuntimeException;
        //  409    422    523    527    Any
        //  422    435    527    541    Ljava/lang/RuntimeException;
        //  422    435    523    527    Any
        //  435    448    527    541    Ljava/lang/RuntimeException;
        //  435    448    523    527    Any
        //  448    517    527    541    Ljava/lang/RuntimeException;
        //  448    517    523    527    Any
        //  528    541    523    527    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0396:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2604)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:206)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:761)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:638)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:162)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:137)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:129)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private void h(final b b, final int n, final int n2) throws IOException {
        final boolean v = androidx.exifinterface.media.a.v;
        final String s = "ExifInterface";
        if (v) {
            final StringBuilder sb = new StringBuilder();
            sb.append("getJpegAttributes starting with: ");
            sb.append(b);
            Log.d("ExifInterface", sb.toString());
        }
        b.d(ByteOrder.BIG_ENDIAN);
        final byte byte1 = b.readByte();
        if (byte1 != -1) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid marker: ");
            sb2.append(Integer.toHexString(byte1 & 0xFF));
            throw new IOException(sb2.toString());
        }
        if (b.readByte() != -40) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Invalid marker: ");
            sb3.append(Integer.toHexString(byte1 & 0xFF));
            throw new IOException(sb3.toString());
        }
        int n3 = 2;
        while (true) {
            final byte byte2 = b.readByte();
            if (byte2 != -1) {
                final StringBuilder sb4 = new StringBuilder();
                sb4.append("Invalid marker:");
                sb4.append(Integer.toHexString(byte2 & 0xFF));
                throw new IOException(sb4.toString());
            }
            final byte byte3 = b.readByte();
            final boolean v2 = androidx.exifinterface.media.a.v;
            if (v2) {
                final StringBuilder sb5 = new StringBuilder();
                sb5.append("Found JPEG segment indicator: ");
                sb5.append(Integer.toHexString(byte3 & 0xFF));
                Log.d(s, sb5.toString());
            }
            if (byte3 == -39 || byte3 == -38) {
                b.d(this.h);
                return;
            }
            final int n4 = b.readUnsignedShort() - 2;
            int n5 = n3 + 1 + 1 + 2;
            if (v2) {
                final StringBuilder sb6 = new StringBuilder();
                sb6.append("JPEG segment: ");
                sb6.append(Integer.toHexString(byte3 & 0xFF));
                sb6.append(" (length: ");
                sb6.append(n4 + 2);
                sb6.append(")");
                Log.d(s, sb6.toString());
            }
            if (n4 < 0) {
                throw new IOException("Invalid length");
            }
            int n7 = 0;
            Label_0760: {
                int n8;
                if (byte3 != -31) {
                    if (byte3 != -2) {
                        int n6 = 0;
                        Label_0404: {
                            switch (byte3) {
                                default:
                                    Label_0411: {
                                        switch (byte3) {
                                            default: {
                                                switch (byte3) {
                                                    default: {
                                                        switch (byte3) {
                                                            default: {
                                                                n6 = n4;
                                                                break Label_0404;
                                                            }
                                                            case -51:
                                                            case -50:
                                                            case -49: {
                                                                break Label_0411;
                                                            }
                                                        }
                                                        break;
                                                    }
                                                    case -55:
                                                    case -54:
                                                    case -53: {
                                                        break Label_0411;
                                                    }
                                                }
                                                break;
                                            }
                                            case -59:
                                            case -58:
                                            case -57: {
                                                break Label_0411;
                                            }
                                        }
                                        break;
                                    }
                                case -64:
                                case -63:
                                case -62:
                                case -61: {
                                    b.e(1);
                                    final HashMap<String, d> hashMap = this.f[n2];
                                    String s2;
                                    if (n2 != 4) {
                                        s2 = "ImageLength";
                                    }
                                    else {
                                        s2 = "ThumbnailImageLength";
                                    }
                                    hashMap.put(s2, androidx.exifinterface.media.a.d.f(b.readUnsignedShort(), this.h));
                                    final HashMap<String, d> hashMap2 = this.f[n2];
                                    String s3;
                                    if (n2 != 4) {
                                        s3 = "ImageWidth";
                                    }
                                    else {
                                        s3 = "ThumbnailImageWidth";
                                    }
                                    hashMap2.put(s3, androidx.exifinterface.media.a.d.f(b.readUnsignedShort(), this.h));
                                    n6 = n4 - 5;
                                    break;
                                }
                            }
                        }
                        n7 = n6;
                        break Label_0760;
                    }
                    final byte[] array = new byte[n4];
                    if (b.read(array) != n4) {
                        throw new IOException("Invalid exif");
                    }
                    if (this.d("UserComment") == null) {
                        this.f[1].put("UserComment", androidx.exifinterface.media.a.d.e(new String(array, androidx.exifinterface.media.a.p0)));
                    }
                    n8 = n5;
                }
                else {
                    final byte[] array2 = new byte[n4];
                    b.readFully(array2);
                    final byte[] q0 = androidx.exifinterface.media.a.q0;
                    if (b.g(array2, q0)) {
                        final byte[] copyOfRange = Arrays.copyOfRange(array2, q0.length, n4);
                        this.p = n + n5 + q0.length;
                        this.M(copyOfRange, n2);
                        this.W(new b(copyOfRange));
                    }
                    else {
                        final byte[] r0 = androidx.exifinterface.media.a.r0;
                        if (b.g(array2, r0)) {
                            final int length = r0.length;
                            final byte[] copyOfRange2 = Arrays.copyOfRange(array2, r0.length, n4);
                            if (this.d("Xmp") == null) {
                                this.f[0].put("Xmp", new d(1, copyOfRange2.length, n5 + length, copyOfRange2));
                                this.u = true;
                            }
                        }
                    }
                    n8 = n5 + n4;
                }
                n7 = 0;
                n5 = n8;
            }
            if (n7 < 0) {
                throw new IOException("Invalid length");
            }
            b.e(n7);
            n3 = n5 + n7;
        }
    }
    
    private int i(final BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        final byte[] array = new byte[5000];
        bufferedInputStream.read(array);
        bufferedInputStream.reset();
        if (y(array)) {
            return 4;
        }
        if (this.B(array)) {
            return 9;
        }
        if (this.x(array)) {
            return 12;
        }
        if (this.z(array)) {
            return 7;
        }
        if (this.C(array)) {
            return 10;
        }
        if (this.A(array)) {
            return 13;
        }
        if (this.H(array)) {
            return 14;
        }
        return 0;
    }
    
    private void j(final g g) throws IOException {
        this.m(g);
        final d d = this.f[1].get("MakerNote");
        if (d != null) {
            final g g2 = new g(d.d);
            ((b)g2).d(this.h);
            final byte[] f = androidx.exifinterface.media.a.F;
            final byte[] array = new byte[f.length];
            ((b)g2).readFully(array);
            g2.h(0L);
            final byte[] g3 = androidx.exifinterface.media.a.G;
            final byte[] array2 = new byte[g3.length];
            ((b)g2).readFully(array2);
            if (Arrays.equals(array, f)) {
                g2.h(8L);
            }
            else if (Arrays.equals(array2, g3)) {
                g2.h(12L);
            }
            this.N(g2, 6);
            final d d2 = this.f[7].get("PreviewImageStart");
            final d d3 = this.f[7].get("PreviewImageLength");
            if (d2 != null && d3 != null) {
                this.f[5].put("JPEGInterchangeFormat", d2);
                this.f[5].put("JPEGInterchangeFormatLength", d3);
            }
            final d d4 = this.f[8].get("AspectFrame");
            if (d4 != null) {
                final int[] array3 = (int[])d4.o(this.h);
                if (array3 != null && array3.length == 4) {
                    if (array3[2] > array3[0] && array3[3] > array3[1]) {
                        final int n = array3[2] - array3[0] + 1;
                        final int n2 = array3[3] - array3[1] + 1;
                        int n3;
                        int n4;
                        if ((n3 = n) < (n4 = n2)) {
                            final int n5 = n + n2;
                            n4 = n5 - n2;
                            n3 = n5 - n4;
                        }
                        final d j = androidx.exifinterface.media.a.d.j(n3, this.h);
                        final d i = androidx.exifinterface.media.a.d.j(n4, this.h);
                        this.f[0].put("ImageWidth", j);
                        this.f[0].put("ImageLength", i);
                    }
                }
                else {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Invalid aspect frame values. frame=");
                    sb.append(Arrays.toString(array3));
                    Log.w("ExifInterface", sb.toString());
                }
            }
        }
    }
    
    private void k(final b b) throws IOException {
        if (androidx.exifinterface.media.a.v) {
            final StringBuilder sb = new StringBuilder();
            sb.append("getPngAttributes starting with: ");
            sb.append(b);
            Log.d("ExifInterface", sb.toString());
        }
        b.d(ByteOrder.BIG_ENDIAN);
        final byte[] h = androidx.exifinterface.media.a.H;
        b.e(h.length);
        int n = h.length + 0;
        try {
            while (true) {
                int int1 = b.readInt();
                final byte[] array = new byte[4];
                Label_0353: {
                    if (b.read(array) != 4) {
                        break Label_0353;
                    }
                    final int p = n + 4 + 4;
                    if (p == 16 && !Arrays.equals(array, androidx.exifinterface.media.a.J)) {
                        throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                    }
                    if (Arrays.equals(array, androidx.exifinterface.media.a.K)) {
                        break;
                    }
                    if (Arrays.equals(array, androidx.exifinterface.media.a.I)) {
                        final byte[] array2 = new byte[int1];
                        if (b.read(array2) != int1) {
                            final StringBuilder sb2 = new StringBuilder();
                            sb2.append("Failed to read given length for given PNG chunk type: ");
                            sb2.append(b.a(array));
                            throw new IOException(sb2.toString());
                        }
                        final int int2 = b.readInt();
                        final CRC32 crc32 = new CRC32();
                        crc32.update(array);
                        crc32.update(array2);
                        if ((int)crc32.getValue() == int2) {
                            this.p = p;
                            this.M(array2, 0);
                            this.a0();
                            this.W(new b(array2));
                            break;
                        }
                        final StringBuilder sb3 = new StringBuilder();
                        sb3.append("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: ");
                        sb3.append(int2);
                        sb3.append(", calculated CRC value: ");
                        sb3.append(crc32.getValue());
                        throw new IOException(sb3.toString());
                    }
                    int1 += 4;
                    try {
                        b.e(int1);
                        n = p + int1;
                        continue;
                        throw new IOException("Encountered invalid length while parsing PNG chunktype");
                    }
                    catch (final EOFException ex) {
                        throw new IOException("Encountered corrupt PNG file.");
                    }
                }
            }
        }
        catch (final EOFException ex2) {}
    }
    
    private void l(final b b) throws IOException {
        final boolean v = androidx.exifinterface.media.a.v;
        if (v) {
            final StringBuilder sb = new StringBuilder();
            sb.append("getRafAttributes starting with: ");
            sb.append(b);
            Log.d("ExifInterface", sb.toString());
        }
        b.e(84);
        final byte[] array = new byte[4];
        final byte[] array2 = new byte[4];
        final byte[] array3 = new byte[4];
        b.read(array);
        b.read(array2);
        b.read(array3);
        final int int1 = ByteBuffer.wrap(array).getInt();
        final int int2 = ByteBuffer.wrap(array2).getInt();
        final int int3 = ByteBuffer.wrap(array3).getInt();
        final byte[] array4 = new byte[int2];
        b.e(int1 - b.a());
        b.read(array4);
        this.h(new b(array4), int1, 5);
        b.e(int3 - b.a());
        b.d(ByteOrder.BIG_ENDIAN);
        final int int4 = b.readInt();
        if (v) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("numberOfDirectoryEntry: ");
            sb2.append(int4);
            Log.d("ExifInterface", sb2.toString());
        }
        for (int i = 0; i < int4; ++i) {
            final int unsignedShort = b.readUnsignedShort();
            final int unsignedShort2 = b.readUnsignedShort();
            if (unsignedShort == androidx.exifinterface.media.a.e0.a) {
                final short short1 = b.readShort();
                final short short2 = b.readShort();
                final d j = androidx.exifinterface.media.a.d.j(short1, this.h);
                final d k = androidx.exifinterface.media.a.d.j(short2, this.h);
                this.f[0].put("ImageLength", j);
                this.f[0].put("ImageWidth", k);
                if (androidx.exifinterface.media.a.v) {
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("Updated to length: ");
                    sb3.append(short1);
                    sb3.append(", width: ");
                    sb3.append(short2);
                    Log.d("ExifInterface", sb3.toString());
                }
                return;
            }
            b.e(unsignedShort2);
        }
    }
    
    private void m(g g) throws IOException {
        this.J((b)g);
        this.N(g, 0);
        this.Z(g, 0);
        this.Z(g, 5);
        this.Z(g, 4);
        this.a0();
        if (this.d == 8) {
            final d d = this.f[1].get("MakerNote");
            if (d != null) {
                g = new g(d.d);
                ((b)g).d(this.h);
                ((b)g).e(6);
                this.N(g, 9);
                final d d2 = this.f[9].get("ColorSpace");
                if (d2 != null) {
                    this.f[1].put("ColorSpace", d2);
                }
            }
        }
    }
    
    private void n(final g g) throws IOException {
        if (androidx.exifinterface.media.a.v) {
            final StringBuilder sb = new StringBuilder();
            sb.append("getRw2Attributes starting with: ");
            sb.append(g);
            Log.d("ExifInterface", sb.toString());
        }
        this.m(g);
        final d d = this.f[0].get("JpgFromRaw");
        if (d != null) {
            this.h(new b(d.d), (int)d.c, 5);
        }
        final d d2 = this.f[0].get("ISO");
        final d d3 = this.f[1].get("PhotographicSensitivity");
        if (d2 != null && d3 == null) {
            this.f[1].put("PhotographicSensitivity", d2);
        }
    }
    
    private void o(final g g) throws IOException {
        final byte[] q0 = androidx.exifinterface.media.a.q0;
        ((b)g).e(q0.length);
        final byte[] array = new byte[((b)g).available()];
        ((b)g).readFully(array);
        this.p = q0.length;
        this.M(array, 0);
    }
    
    private void r(final b b) throws IOException {
        if (androidx.exifinterface.media.a.v) {
            final StringBuilder sb = new StringBuilder();
            sb.append("getWebpAttributes starting with: ");
            sb.append(b);
            Log.d("ExifInterface", sb.toString());
        }
        b.d(ByteOrder.LITTLE_ENDIAN);
        b.e(androidx.exifinterface.media.a.L.length);
        final int n = b.readInt() + 8;
        final byte[] m = androidx.exifinterface.media.a.M;
        b.e(m.length);
        int n2 = m.length + 8;
        try {
            while (true) {
                final byte[] array = new byte[4];
                if (b.read(array) != 4) {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
                final int int1 = b.readInt();
                final int p = n2 + 4 + 4;
                if (Arrays.equals(androidx.exifinterface.media.a.N, array)) {
                    final byte[] array2 = new byte[int1];
                    if (b.read(array2) == int1) {
                        this.p = p;
                        this.M(array2, 0);
                        this.W(new b(array2));
                        break;
                    }
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to read given length for given PNG chunk type: ");
                    sb2.append(b.a(array));
                    throw new IOException(sb2.toString());
                }
                else {
                    int n3 = int1;
                    if (int1 % 2 == 1) {
                        n3 = int1 + 1;
                    }
                    final int n4 = p + n3;
                    if (n4 == n) {
                        break;
                    }
                    if (n4 > n) {
                        throw new IOException("Encountered WebP file with invalid chunk size");
                    }
                    b.e(n3);
                    n2 = n4;
                }
            }
        }
        catch (final EOFException ex) {
            throw new IOException("Encountered corrupt WebP file.");
        }
    }
    
    private static Pair<Integer, Integer> s(final String s) {
        final boolean contains = s.contains(",");
        int i = 1;
        final Integer value = 2;
        final Integer value2 = -1;
        if (contains) {
            final String[] split = s.split(",", -1);
            Pair s2;
            final Pair<Integer, Integer> pair = (Pair<Integer, Integer>)(s2 = s(split[0]));
            if ((int)pair.first == 2) {
                return pair;
            }
            while (i < split.length) {
                final Pair<Integer, Integer> s3 = s(split[i]);
                int intValue;
                if (!((Integer)s3.first).equals(s2.first) && !((Integer)s3.second).equals(s2.first)) {
                    intValue = -1;
                }
                else {
                    intValue = (int)s2.first;
                }
                int intValue2;
                if ((int)s2.second != -1 && (((Integer)s3.first).equals(s2.second) || ((Integer)s3.second).equals(s2.second))) {
                    intValue2 = (int)s2.second;
                }
                else {
                    intValue2 = -1;
                }
                if (intValue == -1 && intValue2 == -1) {
                    return (Pair<Integer, Integer>)new Pair((Object)value, (Object)value2);
                }
                if (intValue == -1) {
                    s2 = new Pair((Object)intValue2, (Object)value2);
                }
                else if (intValue2 == -1) {
                    s2 = new Pair((Object)intValue, (Object)value2);
                }
                ++i;
            }
            return (Pair<Integer, Integer>)s2;
        }
        else {
            Label_0417: {
                if (!s.contains("/")) {
                    break Label_0417;
                }
                final String[] split2 = s.split("/", -1);
                Label_0405: {
                    if (split2.length != 2) {
                        break Label_0405;
                    }
                    try {
                        final long n = (long)Double.parseDouble(split2[0]);
                        final long n2 = (long)Double.parseDouble(split2[1]);
                        if (n < 0L || n2 < 0L) {
                            return (Pair<Integer, Integer>)new Pair((Object)10, (Object)value2);
                        }
                        if (n <= 2147483647L && n2 <= 2147483647L) {
                            return (Pair<Integer, Integer>)new Pair((Object)10, (Object)5);
                        }
                        return (Pair<Integer, Integer>)new Pair((Object)5, (Object)value2);
                        try {
                            final Long value3 = Long.parseLong(s);
                            if (value3 >= 0L && value3 <= 65535L) {
                                return (Pair<Integer, Integer>)new Pair((Object)3, (Object)4);
                            }
                            if (value3 < 0L) {
                                return (Pair<Integer, Integer>)new Pair((Object)9, (Object)value2);
                            }
                            return (Pair<Integer, Integer>)new Pair((Object)4, (Object)value2);
                        }
                        catch (final NumberFormatException ex) {
                            try {
                                Double.parseDouble(s);
                                return (Pair<Integer, Integer>)new Pair((Object)12, (Object)value2);
                            }
                            catch (final NumberFormatException ex2) {
                                return (Pair<Integer, Integer>)new Pair((Object)value, (Object)value2);
                            }
                        }
                        return (Pair<Integer, Integer>)new Pair((Object)value, (Object)value2);
                    }
                    catch (final NumberFormatException ex3) {
                        return (Pair<Integer, Integer>)new Pair((Object)value, (Object)value2);
                    }
                }
            }
        }
    }
    
    private void t(final b b, final HashMap hashMap) throws IOException {
        final d d = hashMap.get("JPEGInterchangeFormat");
        final d d2 = hashMap.get("JPEGInterchangeFormatLength");
        if (d != null && d2 != null) {
            final int m = d.m(this.h);
            final int i = d2.m(this.h);
            int l = m;
            if (this.d == 7) {
                l = m + this.q;
            }
            if (l > 0 && i > 0) {
                this.i = true;
                if (this.a == null && this.c == null && this.b == null) {
                    final byte[] n = new byte[i];
                    b.skip(l);
                    b.read(n);
                    this.n = n;
                }
                this.l = l;
                this.m = i;
            }
            if (androidx.exifinterface.media.a.v) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Setting thumbnail attributes with offset: ");
                sb.append(l);
                sb.append(", length: ");
                sb.append(i);
                Log.d("ExifInterface", sb.toString());
            }
        }
    }
    
    private void u(final b b, final HashMap hashMap) throws IOException {
        final d d = hashMap.get("StripOffsets");
        final d d2 = hashMap.get("StripByteCounts");
        if (d != null && d2 != null) {
            final long[] d3 = b.d(d.o(this.h));
            final long[] d4 = b.d(d2.o(this.h));
            if (d3 != null && d3.length != 0) {
                if (d4 == null || d4.length == 0) {
                    Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
                    return;
                }
                if (d3.length != d4.length) {
                    Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
                    return;
                }
                long n = 0L;
                for (int length = d4.length, i = 0; i < length; ++i) {
                    n += d4[i];
                }
                final int m = (int)n;
                final byte[] n2 = new byte[m];
                this.k = true;
                this.j = true;
                this.i = true;
                int j = 0;
                int n4;
                int n3 = n4 = 0;
                while (j < d3.length) {
                    final int n5 = (int)d3[j];
                    final int n6 = (int)d4[j];
                    if (j < d3.length - 1 && n5 + n6 != d3[j + 1]) {
                        this.k = false;
                    }
                    final int n7 = n5 - n3;
                    if (n7 < 0) {
                        Log.d("ExifInterface", "Invalid strip offset value");
                        return;
                    }
                    final long n8 = n7;
                    if (b.skip(n8) != n8) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Failed to skip ");
                        sb.append(n7);
                        sb.append(" bytes.");
                        Log.d("ExifInterface", sb.toString());
                        return;
                    }
                    final byte[] array = new byte[n6];
                    if (b.read(array) != n6) {
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("Failed to read ");
                        sb2.append(n6);
                        sb2.append(" bytes.");
                        Log.d("ExifInterface", sb2.toString());
                        return;
                    }
                    n3 = n3 + n7 + n6;
                    System.arraycopy(array, 0, n2, n4, n6);
                    n4 += n6;
                    ++j;
                }
                this.n = n2;
                if (this.k) {
                    this.l = (int)d3[0];
                    this.m = m;
                }
            }
            else {
                Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
            }
        }
    }
    
    private void v(final String a) throws IOException {
        Objects.requireNonNull(a, "filename cannot be null");
        Closeable closeable = null;
        this.c = null;
        this.a = a;
        try {
            final FileInputStream fileInputStream = new FileInputStream(a);
            try {
                if (D(fileInputStream.getFD())) {
                    this.b = fileInputStream.getFD();
                }
                else {
                    this.b = null;
                }
                this.I(fileInputStream);
                androidx.exifinterface.media.b.c(fileInputStream);
                return;
            }
            finally {
                closeable = fileInputStream;
            }
        }
        finally {}
        androidx.exifinterface.media.b.c(closeable);
    }
    
    private static boolean w(final BufferedInputStream bufferedInputStream) throws IOException {
        final byte[] q0 = a.q0;
        bufferedInputStream.mark(q0.length);
        final byte[] array = new byte[q0.length];
        bufferedInputStream.read(array);
        bufferedInputStream.reset();
        int n = 0;
        while (true) {
            final byte[] q2 = a.q0;
            if (n >= q2.length) {
                return true;
            }
            if (array[n] != q2[n]) {
                return false;
            }
            ++n;
        }
    }
    
    private boolean x(byte[] array) throws IOException {
        final InputStream inputStream = null;
        Object o2;
        final Object o = o2 = null;
        b b = null;
        InputStream inputStream2;
        try {
            try {
                o2 = o;
                b = new b(array);
                try {
                    long long1 = b.readInt();
                    o2 = new byte[4];
                    b.read((byte[])o2);
                    if (!Arrays.equals((byte[])o2, androidx.exifinterface.media.a.C)) {
                        b.close();
                        return false;
                    }
                    long n = 16L;
                    if (long1 == 1L) {
                        if ((long1 = b.readLong()) < 16L) {
                            b.close();
                            return false;
                        }
                    }
                    else {
                        n = 8L;
                    }
                    long n2 = long1;
                    if (long1 > array.length) {
                        n2 = array.length;
                    }
                    final long n3 = n2 - n;
                    if (n3 < 8L) {
                        b.close();
                        return false;
                    }
                    array = new byte[4];
                    long n4 = 0L;
                    int n5 = 0;
                    int n6 = 0;
                    while (n4 < n3 / 4L) {
                        if (b.read(array) != 4) {
                            b.close();
                            return false;
                        }
                        int n7;
                        if (n4 == 1L) {
                            n7 = n6;
                        }
                        else {
                            int n8;
                            if (Arrays.equals(array, androidx.exifinterface.media.a.D)) {
                                n8 = 1;
                            }
                            else {
                                final boolean equals = Arrays.equals(array, androidx.exifinterface.media.a.E);
                                n8 = n5;
                                if (equals) {
                                    n6 = 1;
                                    n8 = n5;
                                }
                            }
                            n5 = n8;
                            n7 = n6;
                            if (n8 != 0) {
                                n5 = n8;
                                if ((n7 = n6) != 0) {
                                    b.close();
                                    return true;
                                }
                            }
                        }
                        ++n4;
                        n6 = n7;
                    }
                    b.close();
                    return false;
                }
                catch (final Exception o2) {}
                finally {
                    o2 = b;
                }
            }
            finally {}
        }
        catch (final Exception b) {
            inputStream2 = inputStream;
        }
        if (androidx.exifinterface.media.a.v) {
            Log.d("ExifInterface", "Exception parsing HEIF file type box.", (Throwable)b);
        }
        if (inputStream2 != null) {
            inputStream2.close();
        }
        return false;
        if (o2 != null) {
            ((InputStream)o2).close();
        }
    }
    
    private static boolean y(final byte[] array) throws IOException {
        int n = 0;
        while (true) {
            final byte[] b = a.B;
            if (n >= b.length) {
                return true;
            }
            if (array[n] != b[n]) {
                return false;
            }
            ++n;
        }
    }
    
    private boolean z(final byte[] array) throws IOException {
        boolean b = false;
        try {
            final b b2 = new b(array);
            try {
                b2.d(this.h = this.L(b2));
                final short short1 = b2.readShort();
                if (short1 == 20306 || short1 == 21330) {
                    b = true;
                }
                b2.close();
                return b;
            }
            catch (final Exception ex) {}
        }
        catch (final Exception ex2) {
            goto Label_0094;
        }
    }
    
    public void R() throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        androidx/exifinterface/media/a.d:I
        //     4: invokestatic    androidx/exifinterface/media/a.F:(I)Z
        //     7: ifeq            1088
        //    10: aload_0        
        //    11: getfield        androidx/exifinterface/media/a.b:Ljava/io/FileDescriptor;
        //    14: ifnonnull       38
        //    17: aload_0        
        //    18: getfield        androidx/exifinterface/media/a.a:Ljava/lang/String;
        //    21: ifnull          27
        //    24: goto            38
        //    27: new             Ljava/io/IOException;
        //    30: dup            
        //    31: ldc_w           "ExifInterface does not support saving attributes for the current input."
        //    34: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //    37: athrow         
        //    38: aload_0        
        //    39: getfield        androidx/exifinterface/media/a.i:Z
        //    42: ifeq            73
        //    45: aload_0        
        //    46: getfield        androidx/exifinterface/media/a.j:Z
        //    49: ifeq            73
        //    52: aload_0        
        //    53: getfield        androidx/exifinterface/media/a.k:Z
        //    56: ifeq            62
        //    59: goto            73
        //    62: new             Ljava/io/IOException;
        //    65: dup            
        //    66: ldc_w           "ExifInterface does not support saving attributes when the image file has non-consecutive thumbnail strips"
        //    69: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //    72: athrow         
        //    73: aload_0        
        //    74: iconst_1       
        //    75: putfield        androidx/exifinterface/media/a.t:Z
        //    78: aload_0        
        //    79: aload_0        
        //    80: invokevirtual   androidx/exifinterface/media/a.p:()[B
        //    83: putfield        androidx/exifinterface/media/a.n:[B
        //    86: aconst_null    
        //    87: astore          10
        //    89: aconst_null    
        //    90: astore          6
        //    92: aconst_null    
        //    93: astore          7
        //    95: aconst_null    
        //    96: astore          8
        //    98: ldc_w           "temp"
        //   101: ldc_w           "tmp"
        //   104: invokestatic    java/io/File.createTempFile:(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
        //   107: astore          14
        //   109: aload_0        
        //   110: getfield        androidx/exifinterface/media/a.a:Ljava/lang/String;
        //   113: ifnull          137
        //   116: new             Ljava/io/FileInputStream;
        //   119: astore          9
        //   121: aload           9
        //   123: aload_0        
        //   124: getfield        androidx/exifinterface/media/a.a:Ljava/lang/String;
        //   127: invokespecial   java/io/FileInputStream.<init>:(Ljava/lang/String;)V
        //   130: aload           9
        //   132: astore          6
        //   134: goto            166
        //   137: aload_0        
        //   138: getfield        androidx/exifinterface/media/a.b:Ljava/io/FileDescriptor;
        //   141: lconst_0       
        //   142: getstatic       android/system/OsConstants.SEEK_SET:I
        //   145: invokestatic    androidx/exifinterface/media/b$a.c:(Ljava/io/FileDescriptor;JI)J
        //   148: pop2           
        //   149: new             Ljava/io/FileInputStream;
        //   152: dup            
        //   153: aload_0        
        //   154: getfield        androidx/exifinterface/media/a.b:Ljava/io/FileDescriptor;
        //   157: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/FileDescriptor;)V
        //   160: astore          9
        //   162: aload           9
        //   164: astore          6
        //   166: new             Ljava/io/FileOutputStream;
        //   169: astore          7
        //   171: aload           7
        //   173: aload           14
        //   175: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;)V
        //   178: aload           6
        //   180: aload           7
        //   182: invokestatic    androidx/exifinterface/media/b.e:(Ljava/io/InputStream;Ljava/io/OutputStream;)I
        //   185: pop            
        //   186: aload           6
        //   188: invokestatic    androidx/exifinterface/media/b.c:(Ljava/io/Closeable;)V
        //   191: aload           7
        //   193: invokestatic    androidx/exifinterface/media/b.c:(Ljava/io/Closeable;)V
        //   196: iconst_0       
        //   197: istore_2       
        //   198: iconst_0       
        //   199: istore          4
        //   201: iconst_0       
        //   202: istore          5
        //   204: iconst_0       
        //   205: istore_1       
        //   206: iconst_0       
        //   207: istore_3       
        //   208: new             Ljava/io/FileInputStream;
        //   211: astore          6
        //   213: aload           6
        //   215: aload           14
        //   217: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //   220: aload_0        
        //   221: getfield        androidx/exifinterface/media/a.a:Ljava/lang/String;
        //   224: ifnull          244
        //   227: new             Ljava/io/FileOutputStream;
        //   230: astore          8
        //   232: aload           8
        //   234: aload_0        
        //   235: getfield        androidx/exifinterface/media/a.a:Ljava/lang/String;
        //   238: invokespecial   java/io/FileOutputStream.<init>:(Ljava/lang/String;)V
        //   241: goto            269
        //   244: aload_0        
        //   245: getfield        androidx/exifinterface/media/a.b:Ljava/io/FileDescriptor;
        //   248: lconst_0       
        //   249: getstatic       android/system/OsConstants.SEEK_SET:I
        //   252: invokestatic    androidx/exifinterface/media/b$a.c:(Ljava/io/FileDescriptor;JI)J
        //   255: pop2           
        //   256: new             Ljava/io/FileOutputStream;
        //   259: dup            
        //   260: aload_0        
        //   261: getfield        androidx/exifinterface/media/a.b:Ljava/io/FileDescriptor;
        //   264: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/FileDescriptor;)V
        //   267: astore          8
        //   269: new             Ljava/io/BufferedInputStream;
        //   272: astore          9
        //   274: aload           9
        //   276: aload           6
        //   278: invokespecial   java/io/BufferedInputStream.<init>:(Ljava/io/InputStream;)V
        //   281: new             Ljava/io/BufferedOutputStream;
        //   284: astore          12
        //   286: aload           12
        //   288: aload           8
        //   290: invokespecial   java/io/BufferedOutputStream.<init>:(Ljava/io/OutputStream;)V
        //   293: iload           4
        //   295: istore_1       
        //   296: aload           9
        //   298: astore          7
        //   300: aload           12
        //   302: astore          11
        //   304: aload_0        
        //   305: getfield        androidx/exifinterface/media/a.d:I
        //   308: istore          5
        //   310: iload           5
        //   312: iconst_4       
        //   313: if_icmpne       338
        //   316: iload           4
        //   318: istore_1       
        //   319: aload           9
        //   321: astore          7
        //   323: aload           12
        //   325: astore          11
        //   327: aload_0        
        //   328: aload           9
        //   330: aload           12
        //   332: invokespecial   androidx/exifinterface/media/a.S:(Ljava/io/InputStream;Ljava/io/OutputStream;)V
        //   335: goto            462
        //   338: iload           5
        //   340: bipush          13
        //   342: if_icmpne       367
        //   345: iload           4
        //   347: istore_1       
        //   348: aload           9
        //   350: astore          7
        //   352: aload           12
        //   354: astore          11
        //   356: aload_0        
        //   357: aload           9
        //   359: aload           12
        //   361: invokespecial   androidx/exifinterface/media/a.T:(Ljava/io/InputStream;Ljava/io/OutputStream;)V
        //   364: goto            462
        //   367: iload           5
        //   369: bipush          14
        //   371: if_icmpne       396
        //   374: iload           4
        //   376: istore_1       
        //   377: aload           9
        //   379: astore          7
        //   381: aload           12
        //   383: astore          11
        //   385: aload_0        
        //   386: aload           9
        //   388: aload           12
        //   390: invokespecial   androidx/exifinterface/media/a.U:(Ljava/io/InputStream;Ljava/io/OutputStream;)V
        //   393: goto            462
        //   396: iload           5
        //   398: iconst_3       
        //   399: if_icmpeq       407
        //   402: iload           5
        //   404: ifne            462
        //   407: iload           4
        //   409: istore_1       
        //   410: aload           9
        //   412: astore          7
        //   414: aload           12
        //   416: astore          11
        //   418: new             Landroidx/exifinterface/media/a$c;
        //   421: astore          10
        //   423: iload           4
        //   425: istore_1       
        //   426: aload           9
        //   428: astore          7
        //   430: aload           12
        //   432: astore          11
        //   434: aload           10
        //   436: aload           12
        //   438: getstatic       java/nio/ByteOrder.BIG_ENDIAN:Ljava/nio/ByteOrder;
        //   441: invokespecial   androidx/exifinterface/media/a$c.<init>:(Ljava/io/OutputStream;Ljava/nio/ByteOrder;)V
        //   444: iload           4
        //   446: istore_1       
        //   447: aload           9
        //   449: astore          7
        //   451: aload           12
        //   453: astore          11
        //   455: aload_0        
        //   456: aload           10
        //   458: invokespecial   androidx/exifinterface/media/a.b0:(Landroidx/exifinterface/media/a$c;)I
        //   461: pop            
        //   462: aload           9
        //   464: invokestatic    androidx/exifinterface/media/b.c:(Ljava/io/Closeable;)V
        //   467: aload           12
        //   469: invokestatic    androidx/exifinterface/media/b.c:(Ljava/io/Closeable;)V
        //   472: aload           14
        //   474: invokevirtual   java/io/File.delete:()Z
        //   477: pop            
        //   478: aload_0        
        //   479: aconst_null    
        //   480: putfield        androidx/exifinterface/media/a.n:[B
        //   483: return         
        //   484: astore          10
        //   486: aload           6
        //   488: astore          7
        //   490: aload           8
        //   492: astore          6
        //   494: aload           12
        //   496: astore          8
        //   498: goto            603
        //   501: astore          6
        //   503: aconst_null    
        //   504: astore          11
        //   506: iload           5
        //   508: istore_1       
        //   509: aload           9
        //   511: astore          7
        //   513: goto            965
        //   516: astore          10
        //   518: aconst_null    
        //   519: astore          11
        //   521: aload           6
        //   523: astore          7
        //   525: aload           8
        //   527: astore          6
        //   529: aload           11
        //   531: astore          8
        //   533: goto            603
        //   536: astore          10
        //   538: aconst_null    
        //   539: astore          11
        //   541: aconst_null    
        //   542: astore          9
        //   544: aload           6
        //   546: astore          7
        //   548: aload           8
        //   550: astore          6
        //   552: aload           11
        //   554: astore          8
        //   556: goto            603
        //   559: astore          8
        //   561: aload           6
        //   563: astore          7
        //   565: aload           8
        //   567: astore          6
        //   569: goto            590
        //   572: astore          6
        //   574: aconst_null    
        //   575: astore          11
        //   577: aload           10
        //   579: astore          7
        //   581: goto            965
        //   584: astore          6
        //   586: aload           8
        //   588: astore          7
        //   590: aconst_null    
        //   591: astore          8
        //   593: aconst_null    
        //   594: astore          9
        //   596: aload           6
        //   598: astore          10
        //   600: aconst_null    
        //   601: astore          6
        //   603: new             Ljava/io/FileInputStream;
        //   606: astore          12
        //   608: aload           12
        //   610: aload           14
        //   612: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //   615: aload           6
        //   617: astore          11
        //   619: aload           6
        //   621: astore          7
        //   623: aload_0        
        //   624: getfield        androidx/exifinterface/media/a.a:Ljava/lang/String;
        //   627: ifnonnull       687
        //   630: aload           6
        //   632: astore          11
        //   634: aload           6
        //   636: astore          7
        //   638: aload_0        
        //   639: getfield        androidx/exifinterface/media/a.b:Ljava/io/FileDescriptor;
        //   642: lconst_0       
        //   643: getstatic       android/system/OsConstants.SEEK_SET:I
        //   646: invokestatic    androidx/exifinterface/media/b$a.c:(Ljava/io/FileDescriptor;JI)J
        //   649: pop2           
        //   650: aload           6
        //   652: astore          11
        //   654: aload           6
        //   656: astore          7
        //   658: new             Ljava/io/FileOutputStream;
        //   661: astore          13
        //   663: aload           6
        //   665: astore          11
        //   667: aload           6
        //   669: astore          7
        //   671: aload           13
        //   673: aload_0        
        //   674: getfield        androidx/exifinterface/media/a.b:Ljava/io/FileDescriptor;
        //   677: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/FileDescriptor;)V
        //   680: aload           13
        //   682: astore          6
        //   684: goto            708
        //   687: aload           6
        //   689: astore          11
        //   691: aload           6
        //   693: astore          7
        //   695: new             Ljava/io/FileOutputStream;
        //   698: dup            
        //   699: aload_0        
        //   700: getfield        androidx/exifinterface/media/a.a:Ljava/lang/String;
        //   703: invokespecial   java/io/FileOutputStream.<init>:(Ljava/lang/String;)V
        //   706: astore          6
        //   708: aload           6
        //   710: astore          11
        //   712: aload           6
        //   714: astore          7
        //   716: aload           12
        //   718: aload           6
        //   720: invokestatic    androidx/exifinterface/media/b.e:(Ljava/io/InputStream;Ljava/io/OutputStream;)I
        //   723: pop            
        //   724: iload           4
        //   726: istore_1       
        //   727: aload           9
        //   729: astore          7
        //   731: aload           8
        //   733: astore          11
        //   735: aload           12
        //   737: invokestatic    androidx/exifinterface/media/b.c:(Ljava/io/Closeable;)V
        //   740: iload           4
        //   742: istore_1       
        //   743: aload           9
        //   745: astore          7
        //   747: aload           8
        //   749: astore          11
        //   751: aload           6
        //   753: invokestatic    androidx/exifinterface/media/b.c:(Ljava/io/Closeable;)V
        //   756: iload           4
        //   758: istore_1       
        //   759: aload           9
        //   761: astore          7
        //   763: aload           8
        //   765: astore          11
        //   767: new             Ljava/io/IOException;
        //   770: astore          6
        //   772: iload           4
        //   774: istore_1       
        //   775: aload           9
        //   777: astore          7
        //   779: aload           8
        //   781: astore          11
        //   783: aload           6
        //   785: ldc_w           "Failed to save new file"
        //   788: aload           10
        //   790: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   793: iload           4
        //   795: istore_1       
        //   796: aload           9
        //   798: astore          7
        //   800: aload           8
        //   802: astore          11
        //   804: aload           6
        //   806: athrow         
        //   807: astore          6
        //   809: iload_3        
        //   810: istore_2       
        //   811: aload           12
        //   813: astore          7
        //   815: goto            908
        //   818: astore          10
        //   820: aload           7
        //   822: astore          6
        //   824: aload           12
        //   826: astore          7
        //   828: goto            846
        //   831: astore          10
        //   833: aload           7
        //   835: astore          13
        //   837: aload           6
        //   839: astore          12
        //   841: goto            920
        //   844: astore          10
        //   846: new             Ljava/io/IOException;
        //   849: astore          11
        //   851: new             Ljava/lang/StringBuilder;
        //   854: astore          12
        //   856: aload           12
        //   858: invokespecial   java/lang/StringBuilder.<init>:()V
        //   861: aload           12
        //   863: ldc_w           "Failed to save new file. Original file is stored in "
        //   866: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   869: pop            
        //   870: aload           12
        //   872: aload           14
        //   874: invokevirtual   java/io/File.getAbsolutePath:()Ljava/lang/String;
        //   877: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   880: pop            
        //   881: aload           11
        //   883: aload           12
        //   885: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   888: aload           10
        //   890: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   893: aload           11
        //   895: athrow         
        //   896: astore          10
        //   898: iconst_1       
        //   899: istore_2       
        //   900: aload           6
        //   902: astore          11
        //   904: aload           10
        //   906: astore          6
        //   908: aload           11
        //   910: astore          12
        //   912: aload           7
        //   914: astore          13
        //   916: aload           6
        //   918: astore          10
        //   920: iload_2        
        //   921: istore_1       
        //   922: aload           9
        //   924: astore          7
        //   926: aload           8
        //   928: astore          11
        //   930: aload           13
        //   932: invokestatic    androidx/exifinterface/media/b.c:(Ljava/io/Closeable;)V
        //   935: iload_2        
        //   936: istore_1       
        //   937: aload           9
        //   939: astore          7
        //   941: aload           8
        //   943: astore          11
        //   945: aload           12
        //   947: invokestatic    androidx/exifinterface/media/b.c:(Ljava/io/Closeable;)V
        //   950: iload_2        
        //   951: istore_1       
        //   952: aload           9
        //   954: astore          7
        //   956: aload           8
        //   958: astore          11
        //   960: aload           10
        //   962: athrow         
        //   963: astore          6
        //   965: aload           7
        //   967: invokestatic    androidx/exifinterface/media/b.c:(Ljava/io/Closeable;)V
        //   970: aload           11
        //   972: invokestatic    androidx/exifinterface/media/b.c:(Ljava/io/Closeable;)V
        //   975: iload_1        
        //   976: ifne            985
        //   979: aload           14
        //   981: invokevirtual   java/io/File.delete:()Z
        //   984: pop            
        //   985: aload           6
        //   987: athrow         
        //   988: astore          8
        //   990: goto            1003
        //   993: astore          8
        //   995: goto            1023
        //   998: astore          8
        //  1000: aconst_null    
        //  1001: astore          7
        //  1003: aload           6
        //  1005: astore          9
        //  1007: aload           8
        //  1009: astore          6
        //  1011: aload           9
        //  1013: astore          8
        //  1015: goto            1075
        //  1018: astore          8
        //  1020: aconst_null    
        //  1021: astore          7
        //  1023: goto            1047
        //  1026: astore          6
        //  1028: aconst_null    
        //  1029: astore          9
        //  1031: aload           7
        //  1033: astore          8
        //  1035: aload           9
        //  1037: astore          7
        //  1039: goto            1075
        //  1042: astore          8
        //  1044: aconst_null    
        //  1045: astore          7
        //  1047: new             Ljava/io/IOException;
        //  1050: astore          9
        //  1052: aload           9
        //  1054: ldc_w           "Failed to copy original file to temp file"
        //  1057: aload           8
        //  1059: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //  1062: aload           9
        //  1064: athrow         
        //  1065: astore          9
        //  1067: aload           6
        //  1069: astore          8
        //  1071: aload           9
        //  1073: astore          6
        //  1075: aload           8
        //  1077: invokestatic    androidx/exifinterface/media/b.c:(Ljava/io/Closeable;)V
        //  1080: aload           7
        //  1082: invokestatic    androidx/exifinterface/media/b.c:(Ljava/io/Closeable;)V
        //  1085: aload           6
        //  1087: athrow         
        //  1088: new             Ljava/io/IOException;
        //  1091: dup            
        //  1092: ldc_w           "ExifInterface only supports saving attributes for JPEG, PNG, WebP, and DNG formats."
        //  1095: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //  1098: athrow         
        //    Exceptions:
        //  throws java.io.IOException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  98     130    1042   1047   Ljava/lang/Exception;
        //  98     130    1026   1042   Any
        //  137    162    1042   1047   Ljava/lang/Exception;
        //  137    162    1026   1042   Any
        //  166    178    1018   1023   Ljava/lang/Exception;
        //  166    178    998    1003   Any
        //  178    186    993    998    Ljava/lang/Exception;
        //  178    186    988    993    Any
        //  208    220    584    590    Ljava/lang/Exception;
        //  208    220    572    584    Any
        //  220    241    559    572    Ljava/lang/Exception;
        //  220    241    572    584    Any
        //  244    269    559    572    Ljava/lang/Exception;
        //  244    269    572    584    Any
        //  269    281    536    559    Ljava/lang/Exception;
        //  269    281    572    584    Any
        //  281    293    516    536    Ljava/lang/Exception;
        //  281    293    501    516    Any
        //  304    310    484    501    Ljava/lang/Exception;
        //  304    310    963    965    Any
        //  327    335    484    501    Ljava/lang/Exception;
        //  327    335    963    965    Any
        //  356    364    484    501    Ljava/lang/Exception;
        //  356    364    963    965    Any
        //  385    393    484    501    Ljava/lang/Exception;
        //  385    393    963    965    Any
        //  418    423    484    501    Ljava/lang/Exception;
        //  418    423    963    965    Any
        //  434    444    484    501    Ljava/lang/Exception;
        //  434    444    963    965    Any
        //  455    462    484    501    Ljava/lang/Exception;
        //  455    462    963    965    Any
        //  603    615    844    846    Ljava/lang/Exception;
        //  603    615    831    844    Any
        //  623    630    818    831    Ljava/lang/Exception;
        //  623    630    807    818    Any
        //  638    650    818    831    Ljava/lang/Exception;
        //  638    650    807    818    Any
        //  658    663    818    831    Ljava/lang/Exception;
        //  658    663    807    818    Any
        //  671    680    818    831    Ljava/lang/Exception;
        //  671    680    807    818    Any
        //  695    708    818    831    Ljava/lang/Exception;
        //  695    708    807    818    Any
        //  716    724    818    831    Ljava/lang/Exception;
        //  716    724    807    818    Any
        //  735    740    963    965    Any
        //  751    756    963    965    Any
        //  767    772    963    965    Any
        //  783    793    963    965    Any
        //  804    807    963    965    Any
        //  846    896    896    908    Any
        //  930    935    963    965    Any
        //  945    950    963    965    Any
        //  960    963    963    965    Any
        //  1047   1065   1065   1075   Any
        // 
        // The error that occurred was:
        // 
        // java.lang.UnsupportedOperationException
        //     at java.util.Collections$1.remove(Unknown Source)
        //     at java.util.AbstractCollection.removeAll(Unknown Source)
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:3018)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2501)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:203)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:761)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:638)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:162)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:137)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:129)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public void V(String s, String s2) {
        final String s3 = s2;
        Objects.requireNonNull(s, "tag shouldn't be null");
        String replaceAll = null;
        Label_0175: {
            if (!"DateTime".equals(s) && !"DateTimeOriginal".equals(s)) {
                replaceAll = s3;
                if (!"DateTimeDigitized".equals(s)) {
                    break Label_0175;
                }
            }
            if ((replaceAll = s3) != null) {
                final boolean find = androidx.exifinterface.media.a.u0.matcher(s3).find();
                final boolean find2 = androidx.exifinterface.media.a.v0.matcher(s3).find();
                if (s2.length() != 19 || (!find && !find2)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Invalid value for ");
                    sb.append(s);
                    sb.append(" : ");
                    sb.append(s3);
                    Log.w("ExifInterface", sb.toString());
                    return;
                }
                replaceAll = s3;
                if (find2) {
                    replaceAll = s3.replaceAll("-", ":");
                }
            }
        }
        s2 = s;
        if ("ISOSpeedRatings".equals(s)) {
            if (androidx.exifinterface.media.a.v) {
                Log.d("ExifInterface", "setAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            s2 = "PhotographicSensitivity";
        }
        int n = 1;
        if ((s = replaceAll) != null) {
            s = replaceAll;
            if (androidx.exifinterface.media.a.n0.contains(s2)) {
                if (s2.equals("GPSTimeStamp")) {
                    final Matcher matcher = androidx.exifinterface.media.a.t0.matcher(replaceAll);
                    if (!matcher.find()) {
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("Invalid value for ");
                        sb2.append(s2);
                        sb2.append(" : ");
                        sb2.append(replaceAll);
                        Log.w("ExifInterface", sb2.toString());
                        return;
                    }
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append(Integer.parseInt(matcher.group(1)));
                    sb3.append("/1,");
                    sb3.append(Integer.parseInt(matcher.group(2)));
                    sb3.append("/1,");
                    sb3.append(Integer.parseInt(matcher.group(3)));
                    sb3.append("/1");
                    s = sb3.toString();
                }
                else {
                    try {
                        s = new f(Double.parseDouble(replaceAll)).toString();
                    }
                    catch (final NumberFormatException ex) {
                        final StringBuilder sb4 = new StringBuilder();
                        sb4.append("Invalid value for ");
                        sb4.append(s2);
                        sb4.append(" : ");
                        sb4.append(replaceAll);
                        Log.w("ExifInterface", sb4.toString());
                        return;
                    }
                }
            }
        }
        for (int i = 0; i < androidx.exifinterface.media.a.j0.length; ++i) {
            if (i != 4 || this.i) {
                final e e = androidx.exifinterface.media.a.m0[i].get(s2);
                if (e != null) {
                    if (s == null) {
                        this.f[i].remove(s2);
                    }
                    else {
                        final Pair<Integer, Integer> s4 = s(s);
                        int n2;
                        if (e.c != (int)s4.first && e.c != (int)s4.second) {
                            final int d = e.d;
                            if (d != -1 && (d == (int)s4.first || e.d == (int)s4.second)) {
                                n2 = e.d;
                            }
                            else {
                                n2 = e.c;
                                if (n2 != n && n2 != 7 && n2 != 2) {
                                    if (androidx.exifinterface.media.a.v) {
                                        final StringBuilder sb5 = new StringBuilder();
                                        sb5.append("Given tag (");
                                        sb5.append(s2);
                                        sb5.append(") value didn't match with one of expected formats: ");
                                        final String[] w = androidx.exifinterface.media.a.W;
                                        sb5.append(w[e.c]);
                                        final int d2 = e.d;
                                        final String s5 = "";
                                        String string;
                                        if (d2 == -1) {
                                            string = "";
                                        }
                                        else {
                                            final StringBuilder sb6 = new StringBuilder();
                                            sb6.append(", ");
                                            sb6.append(w[e.d]);
                                            string = sb6.toString();
                                        }
                                        sb5.append(string);
                                        sb5.append(" (guess: ");
                                        sb5.append(w[(int)s4.first]);
                                        String string2;
                                        if ((int)s4.second == -1) {
                                            string2 = s5;
                                        }
                                        else {
                                            final StringBuilder sb7 = new StringBuilder();
                                            sb7.append(", ");
                                            sb7.append(w[(int)s4.second]);
                                            string2 = sb7.toString();
                                        }
                                        sb5.append(string2);
                                        sb5.append(")");
                                        Log.d("ExifInterface", sb5.toString());
                                    }
                                    continue;
                                }
                            }
                        }
                        else {
                            n2 = e.c;
                        }
                        switch (n2) {
                            default: {
                                final int n3 = n = n;
                                if (androidx.exifinterface.media.a.v) {
                                    final StringBuilder sb8 = new StringBuilder();
                                    sb8.append("Data format isn't one of expected formats: ");
                                    sb8.append(n2);
                                    Log.d("ExifInterface", sb8.toString());
                                    n = n3;
                                }
                                continue;
                            }
                            case 12: {
                                final String[] split = s.split(",", -1);
                                final double[] array = new double[split.length];
                                for (int j = 0; j < split.length; ++j) {
                                    array[j] = Double.parseDouble(split[j]);
                                }
                                this.f[i].put(s2, androidx.exifinterface.media.a.d.b(array, this.h));
                                continue;
                            }
                            case 10: {
                                final String[] split2 = s.split(",", -1);
                                final f[] array2 = new f[split2.length];
                                for (int k = 0; k < split2.length; ++k, n = 1) {
                                    final String[] split3 = split2[k].split("/", -1);
                                    array2[k] = new f((long)Double.parseDouble(split3[0]), (long)Double.parseDouble(split3[n]));
                                }
                                this.f[i].put(s2, androidx.exifinterface.media.a.d.d(array2, this.h));
                                break;
                            }
                            case 9: {
                                final String[] split4 = s.split(",", -1);
                                final int[] array3 = new int[split4.length];
                                for (int l = 0; l < split4.length; ++l) {
                                    array3[l] = Integer.parseInt(split4[l]);
                                }
                                this.f[i].put(s2, androidx.exifinterface.media.a.d.c(array3, this.h));
                                break;
                            }
                            case 5: {
                                final String[] split5 = s.split(",", -1);
                                final f[] array4 = new f[split5.length];
                                for (int n4 = 0; n4 < split5.length; ++n4) {
                                    final String[] split6 = split5[n4].split("/", -1);
                                    array4[n4] = new f((long)Double.parseDouble(split6[0]), (long)Double.parseDouble(split6[1]));
                                }
                                n = 1;
                                this.f[i].put(s2, androidx.exifinterface.media.a.d.i(array4, this.h));
                                continue;
                            }
                            case 4: {
                                final String[] split7 = s.split(",", -1);
                                final long[] array5 = new long[split7.length];
                                for (int n5 = 0; n5 < split7.length; ++n5) {
                                    array5[n5] = Long.parseLong(split7[n5]);
                                }
                                this.f[i].put(s2, androidx.exifinterface.media.a.d.g(array5, this.h));
                                continue;
                            }
                            case 3: {
                                final String[] split8 = s.split(",", -1);
                                final int[] array6 = new int[split8.length];
                                for (int n6 = 0; n6 < split8.length; ++n6) {
                                    array6[n6] = Integer.parseInt(split8[n6]);
                                }
                                this.f[i].put(s2, androidx.exifinterface.media.a.d.k(array6, this.h));
                                continue;
                            }
                            case 2:
                            case 7: {
                                this.f[i].put(s2, androidx.exifinterface.media.a.d.e(s));
                                continue;
                            }
                            case 1: {
                                this.f[i].put(s2, androidx.exifinterface.media.a.d.a(s));
                                continue;
                            }
                        }
                        n = 1;
                    }
                }
            }
        }
    }
    
    public String d(String string) {
        Objects.requireNonNull(string, "tag shouldn't be null");
        final d f = this.f(string);
        Label_0253: {
            if (f == null) {
                break Label_0253;
            }
            if (!androidx.exifinterface.media.a.n0.contains(string)) {
                return f.n(this.h);
            }
            if (string.equals("GPSTimeStamp")) {
                final int a = f.a;
                if (a != 5 && a != 10) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("GPS Timestamp format is not rational. format=");
                    sb.append(f.a);
                    Log.w("ExifInterface", sb.toString());
                    return null;
                }
                final f[] array = (f[])f.o(this.h);
                if (array != null && array.length == 3) {
                    return String.format("%02d:%02d:%02d", (int)(array[0].a / (float)array[0].b), (int)(array[1].a / (float)array[1].b), (int)(array[2].a / (float)array[2].b));
                }
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Invalid GPS Timestamp array. array=");
                sb2.append(Arrays.toString(array));
                Log.w("ExifInterface", sb2.toString());
                return null;
            }
            try {
                string = Double.toString(f.l(this.h));
                return string;
                return null;
            }
            catch (final NumberFormatException ex) {
                return null;
            }
        }
    }
    
    public int e(final String s, final int n) {
        Objects.requireNonNull(s, "tag shouldn't be null");
        final d f = this.f(s);
        if (f == null) {
            return n;
        }
        try {
            return f.m(this.h);
        }
        catch (final NumberFormatException ex) {
            return n;
        }
    }
    
    public byte[] p() {
        final int o = this.o;
        if (o != 6 && o != 7) {
            return null;
        }
        return this.q();
    }
    
    public byte[] q() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        androidx/exifinterface/media/a.i:Z
        //     4: istore_3       
        //     5: aconst_null    
        //     6: astore          8
        //     8: iload_3        
        //     9: ifne            14
        //    12: aconst_null    
        //    13: areturn        
        //    14: aload_0        
        //    15: getfield        androidx/exifinterface/media/a.n:[B
        //    18: astore          6
        //    20: aload           6
        //    22: ifnull          28
        //    25: aload           6
        //    27: areturn        
        //    28: aload_0        
        //    29: getfield        androidx/exifinterface/media/a.c:Landroid/content/res/AssetManager$AssetInputStream;
        //    32: astore          6
        //    34: aload           6
        //    36: ifnull          90
        //    39: aload           6
        //    41: invokevirtual   java/io/InputStream.markSupported:()Z
        //    44: ifeq            58
        //    47: aload           6
        //    49: invokevirtual   java/io/InputStream.reset:()V
        //    52: aconst_null    
        //    53: astore          7
        //    55: goto            155
        //    58: ldc             "ExifInterface"
        //    60: ldc_w           "Cannot read thumbnail from inputstream without mark/reset support"
        //    63: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
        //    66: pop            
        //    67: aload           6
        //    69: invokestatic    androidx/exifinterface/media/b.c:(Ljava/io/Closeable;)V
        //    72: aconst_null    
        //    73: areturn        
        //    74: astore          7
        //    76: aconst_null    
        //    77: astore          10
        //    79: goto            458
        //    82: astore          8
        //    84: aconst_null    
        //    85: astore          7
        //    87: goto            416
        //    90: aload_0        
        //    91: getfield        androidx/exifinterface/media/a.a:Ljava/lang/String;
        //    94: ifnull          113
        //    97: new             Ljava/io/FileInputStream;
        //   100: dup            
        //   101: aload_0        
        //   102: getfield        androidx/exifinterface/media/a.a:Ljava/lang/String;
        //   105: invokespecial   java/io/FileInputStream.<init>:(Ljava/lang/String;)V
        //   108: astore          6
        //   110: goto            52
        //   113: aload_0        
        //   114: getfield        androidx/exifinterface/media/a.b:Ljava/io/FileDescriptor;
        //   117: invokestatic    androidx/exifinterface/media/b$a.b:(Ljava/io/FileDescriptor;)Ljava/io/FileDescriptor;
        //   120: astore          6
        //   122: aload           6
        //   124: lconst_0       
        //   125: getstatic       android/system/OsConstants.SEEK_SET:I
        //   128: invokestatic    androidx/exifinterface/media/b$a.c:(Ljava/io/FileDescriptor;JI)J
        //   131: pop2           
        //   132: new             Ljava/io/FileInputStream;
        //   135: dup            
        //   136: aload           6
        //   138: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/FileDescriptor;)V
        //   141: astore          7
        //   143: aload           7
        //   145: astore          8
        //   147: aload           6
        //   149: astore          7
        //   151: aload           8
        //   153: astore          6
        //   155: aload           6
        //   157: astore          9
        //   159: aload           7
        //   161: astore          10
        //   163: aload           6
        //   165: aload_0        
        //   166: getfield        androidx/exifinterface/media/a.l:I
        //   169: aload_0        
        //   170: getfield        androidx/exifinterface/media/a.p:I
        //   173: iadd           
        //   174: i2l            
        //   175: invokevirtual   java/io/InputStream.skip:(J)J
        //   178: lstore          4
        //   180: aload           6
        //   182: astore          9
        //   184: aload           7
        //   186: astore          10
        //   188: aload_0        
        //   189: getfield        androidx/exifinterface/media/a.l:I
        //   192: istore_2       
        //   193: aload           6
        //   195: astore          9
        //   197: aload           7
        //   199: astore          10
        //   201: aload_0        
        //   202: getfield        androidx/exifinterface/media/a.p:I
        //   205: istore_1       
        //   206: lload           4
        //   208: iload_2        
        //   209: iload_1        
        //   210: iadd           
        //   211: i2l            
        //   212: lcmp           
        //   213: ifne            326
        //   216: aload           6
        //   218: astore          9
        //   220: aload           7
        //   222: astore          10
        //   224: aload_0        
        //   225: getfield        androidx/exifinterface/media/a.m:I
        //   228: newarray        B
        //   230: astore          8
        //   232: aload           6
        //   234: astore          9
        //   236: aload           7
        //   238: astore          10
        //   240: aload           6
        //   242: aload           8
        //   244: invokevirtual   java/io/InputStream.read:([B)I
        //   247: aload_0        
        //   248: getfield        androidx/exifinterface/media/a.m:I
        //   251: if_icmpne       286
        //   254: aload           6
        //   256: astore          9
        //   258: aload           7
        //   260: astore          10
        //   262: aload_0        
        //   263: aload           8
        //   265: putfield        androidx/exifinterface/media/a.n:[B
        //   268: aload           6
        //   270: invokestatic    androidx/exifinterface/media/b.c:(Ljava/io/Closeable;)V
        //   273: aload           7
        //   275: ifnull          283
        //   278: aload           7
        //   280: invokestatic    androidx/exifinterface/media/b.b:(Ljava/io/FileDescriptor;)V
        //   283: aload           8
        //   285: areturn        
        //   286: aload           6
        //   288: astore          9
        //   290: aload           7
        //   292: astore          10
        //   294: new             Ljava/io/IOException;
        //   297: astore          8
        //   299: aload           6
        //   301: astore          9
        //   303: aload           7
        //   305: astore          10
        //   307: aload           8
        //   309: ldc_w           "Corrupted image"
        //   312: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //   315: aload           6
        //   317: astore          9
        //   319: aload           7
        //   321: astore          10
        //   323: aload           8
        //   325: athrow         
        //   326: aload           6
        //   328: astore          9
        //   330: aload           7
        //   332: astore          10
        //   334: new             Ljava/io/IOException;
        //   337: astore          8
        //   339: aload           6
        //   341: astore          9
        //   343: aload           7
        //   345: astore          10
        //   347: aload           8
        //   349: ldc_w           "Corrupted image"
        //   352: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //   355: aload           6
        //   357: astore          9
        //   359: aload           7
        //   361: astore          10
        //   363: aload           8
        //   365: athrow         
        //   366: astore          8
        //   368: goto            416
        //   371: astore          7
        //   373: aload           6
        //   375: astore          10
        //   377: aload           8
        //   379: astore          6
        //   381: goto            458
        //   384: astore          8
        //   386: aload           6
        //   388: astore          7
        //   390: aconst_null    
        //   391: astore          6
        //   393: goto            416
        //   396: astore          7
        //   398: aconst_null    
        //   399: astore          10
        //   401: aload           8
        //   403: astore          6
        //   405: goto            458
        //   408: astore          8
        //   410: aconst_null    
        //   411: astore          6
        //   413: aconst_null    
        //   414: astore          7
        //   416: aload           6
        //   418: astore          9
        //   420: aload           7
        //   422: astore          10
        //   424: ldc             "ExifInterface"
        //   426: ldc_w           "Encountered exception while getting thumbnail"
        //   429: aload           8
        //   431: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   434: pop            
        //   435: aload           6
        //   437: invokestatic    androidx/exifinterface/media/b.c:(Ljava/io/Closeable;)V
        //   440: aload           7
        //   442: ifnull          450
        //   445: aload           7
        //   447: invokestatic    androidx/exifinterface/media/b.b:(Ljava/io/FileDescriptor;)V
        //   450: aconst_null    
        //   451: areturn        
        //   452: astore          7
        //   454: aload           9
        //   456: astore          6
        //   458: aload           6
        //   460: invokestatic    androidx/exifinterface/media/b.c:(Ljava/io/Closeable;)V
        //   463: aload           10
        //   465: ifnull          473
        //   468: aload           10
        //   470: invokestatic    androidx/exifinterface/media/b.b:(Ljava/io/FileDescriptor;)V
        //   473: aload           7
        //   475: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  28     34     408    416    Ljava/lang/Exception;
        //  28     34     396    408    Any
        //  39     52     82     90     Ljava/lang/Exception;
        //  39     52     74     82     Any
        //  58     67     82     90     Ljava/lang/Exception;
        //  58     67     74     82     Any
        //  90     110    408    416    Ljava/lang/Exception;
        //  90     110    396    408    Any
        //  113    122    408    416    Ljava/lang/Exception;
        //  113    122    396    408    Any
        //  122    143    384    396    Ljava/lang/Exception;
        //  122    143    371    384    Any
        //  163    180    366    371    Ljava/lang/Exception;
        //  163    180    452    458    Any
        //  188    193    366    371    Ljava/lang/Exception;
        //  188    193    452    458    Any
        //  201    206    366    371    Ljava/lang/Exception;
        //  201    206    452    458    Any
        //  224    232    366    371    Ljava/lang/Exception;
        //  224    232    452    458    Any
        //  240    254    366    371    Ljava/lang/Exception;
        //  240    254    452    458    Any
        //  262    268    366    371    Ljava/lang/Exception;
        //  262    268    452    458    Any
        //  294    299    366    371    Ljava/lang/Exception;
        //  294    299    452    458    Any
        //  307    315    366    371    Ljava/lang/Exception;
        //  307    315    452    458    Any
        //  323    326    366    371    Ljava/lang/Exception;
        //  323    326    452    458    Any
        //  334    339    366    371    Ljava/lang/Exception;
        //  334    339    452    458    Any
        //  347    355    366    371    Ljava/lang/Exception;
        //  347    355    452    458    Any
        //  363    366    366    371    Ljava/lang/Exception;
        //  363    366    452    458    Any
        //  424    435    452    458    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0283:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2604)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:206)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:761)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:638)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:162)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:137)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:129)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private static class b extends InputStream implements DataInput
    {
        private static final ByteOrder e;
        private static final ByteOrder f;
        final DataInputStream a;
        private ByteOrder b;
        int c;
        private byte[] d;
        
        static {
            e = ByteOrder.LITTLE_ENDIAN;
            f = ByteOrder.BIG_ENDIAN;
        }
        
        b(final InputStream inputStream) throws IOException {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }
        
        b(final InputStream inputStream, final ByteOrder b) throws IOException {
            this.b = ByteOrder.BIG_ENDIAN;
            (this.a = new DataInputStream(inputStream)).mark(0);
            this.c = 0;
            this.b = b;
        }
        
        b(final byte[] array) throws IOException {
            this(new ByteArrayInputStream(array), ByteOrder.BIG_ENDIAN);
        }
        
        public int a() {
            return this.c;
        }
        
        @Override
        public int available() throws IOException {
            return this.a.available();
        }
        
        public long c() throws IOException {
            return (long)this.readInt() & 0xFFFFFFFFL;
        }
        
        public void d(final ByteOrder b) {
            this.b = b;
        }
        
        public void e(final int n) throws IOException {
            int i;
            int read;
            for (i = 0; i < n; i += read) {
                final DataInputStream a = this.a;
                final int n2 = n - i;
                if ((read = (int)a.skip(n2)) <= 0) {
                    if (this.d == null) {
                        this.d = new byte[8192];
                    }
                    read = this.a.read(this.d, 0, Math.min(8192, n2));
                    if (read == -1) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Reached EOF while skipping ");
                        sb.append(n);
                        sb.append(" bytes.");
                        throw new EOFException(sb.toString());
                    }
                }
            }
            this.c += i;
        }
        
        @Override
        public void mark(final int n) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }
        
        @Override
        public int read() throws IOException {
            ++this.c;
            return this.a.read();
        }
        
        @Override
        public int read(final byte[] array, int read, final int n) throws IOException {
            read = this.a.read(array, read, n);
            this.c += read;
            return read;
        }
        
        @Override
        public boolean readBoolean() throws IOException {
            ++this.c;
            return this.a.readBoolean();
        }
        
        @Override
        public byte readByte() throws IOException {
            ++this.c;
            final int read = this.a.read();
            if (read >= 0) {
                return (byte)read;
            }
            throw new EOFException();
        }
        
        @Override
        public char readChar() throws IOException {
            this.c += 2;
            return this.a.readChar();
        }
        
        @Override
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(this.readLong());
        }
        
        @Override
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(this.readInt());
        }
        
        @Override
        public void readFully(final byte[] array) throws IOException {
            this.c += array.length;
            this.a.readFully(array);
        }
        
        @Override
        public void readFully(final byte[] array, final int n, final int n2) throws IOException {
            this.c += n2;
            this.a.readFully(array, n, n2);
        }
        
        @Override
        public int readInt() throws IOException {
            this.c += 4;
            final int read = this.a.read();
            final int read2 = this.a.read();
            final int read3 = this.a.read();
            final int read4 = this.a.read();
            if ((read | read2 | read3 | read4) < 0) {
                throw new EOFException();
            }
            final ByteOrder b = this.b;
            if (b == androidx.exifinterface.media.a.b.e) {
                return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
            }
            if (b == androidx.exifinterface.media.a.b.f) {
                return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Invalid byte order: ");
            sb.append(this.b);
            throw new IOException(sb.toString());
        }
        
        @Override
        public String readLine() throws IOException {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }
        
        @Override
        public long readLong() throws IOException {
            this.c += 8;
            final int read = this.a.read();
            final int read2 = this.a.read();
            final int read3 = this.a.read();
            final int read4 = this.a.read();
            final int read5 = this.a.read();
            final int read6 = this.a.read();
            final int read7 = this.a.read();
            final int read8 = this.a.read();
            if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) < 0) {
                throw new EOFException();
            }
            final ByteOrder b = this.b;
            if (b == androidx.exifinterface.media.a.b.e) {
                return ((long)read8 << 56) + ((long)read7 << 48) + ((long)read6 << 40) + ((long)read5 << 32) + ((long)read4 << 24) + ((long)read3 << 16) + ((long)read2 << 8) + read;
            }
            if (b == androidx.exifinterface.media.a.b.f) {
                return ((long)read << 56) + ((long)read2 << 48) + ((long)read3 << 40) + ((long)read4 << 32) + ((long)read5 << 24) + ((long)read6 << 16) + ((long)read7 << 8) + read8;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Invalid byte order: ");
            sb.append(this.b);
            throw new IOException(sb.toString());
        }
        
        @Override
        public short readShort() throws IOException {
            this.c += 2;
            final int read = this.a.read();
            final int read2 = this.a.read();
            if ((read | read2) < 0) {
                throw new EOFException();
            }
            final ByteOrder b = this.b;
            if (b == androidx.exifinterface.media.a.b.e) {
                return (short)((read2 << 8) + read);
            }
            if (b == androidx.exifinterface.media.a.b.f) {
                return (short)((read << 8) + read2);
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Invalid byte order: ");
            sb.append(this.b);
            throw new IOException(sb.toString());
        }
        
        @Override
        public String readUTF() throws IOException {
            this.c += 2;
            return this.a.readUTF();
        }
        
        @Override
        public int readUnsignedByte() throws IOException {
            ++this.c;
            return this.a.readUnsignedByte();
        }
        
        @Override
        public int readUnsignedShort() throws IOException {
            this.c += 2;
            final int read = this.a.read();
            final int read2 = this.a.read();
            if ((read | read2) < 0) {
                throw new EOFException();
            }
            final ByteOrder b = this.b;
            if (b == androidx.exifinterface.media.a.b.e) {
                return (read2 << 8) + read;
            }
            if (b == androidx.exifinterface.media.a.b.f) {
                return (read << 8) + read2;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Invalid byte order: ");
            sb.append(this.b);
            throw new IOException(sb.toString());
        }
        
        @Override
        public void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }
        
        @Override
        public int skipBytes(final int n) throws IOException {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }
    }
    
    private static class c extends FilterOutputStream
    {
        final OutputStream a;
        private ByteOrder b;
        
        public c(final OutputStream a, final ByteOrder b) {
            super(a);
            this.a = a;
            this.b = b;
        }
        
        public void a(final ByteOrder b) {
            this.b = b;
        }
        
        public void c(final int n) throws IOException {
            this.a.write(n);
        }
        
        public void d(final int n) throws IOException {
            final ByteOrder b = this.b;
            if (b == ByteOrder.LITTLE_ENDIAN) {
                this.a.write(n >>> 0 & 0xFF);
                this.a.write(n >>> 8 & 0xFF);
                this.a.write(n >>> 16 & 0xFF);
                this.a.write(n >>> 24 & 0xFF);
            }
            else if (b == ByteOrder.BIG_ENDIAN) {
                this.a.write(n >>> 24 & 0xFF);
                this.a.write(n >>> 16 & 0xFF);
                this.a.write(n >>> 8 & 0xFF);
                this.a.write(n >>> 0 & 0xFF);
            }
        }
        
        public void e(final short n) throws IOException {
            final ByteOrder b = this.b;
            if (b == ByteOrder.LITTLE_ENDIAN) {
                this.a.write(n >>> 0 & 0xFF);
                this.a.write(n >>> 8 & 0xFF);
            }
            else if (b == ByteOrder.BIG_ENDIAN) {
                this.a.write(n >>> 8 & 0xFF);
                this.a.write(n >>> 0 & 0xFF);
            }
        }
        
        public void h(final long n) throws IOException {
            this.d((int)n);
        }
        
        public void i(final int n) throws IOException {
            this.e((short)n);
        }
        
        @Override
        public void write(final byte[] array) throws IOException {
            this.a.write(array);
        }
        
        @Override
        public void write(final byte[] array, final int n, final int n2) throws IOException {
            this.a.write(array, n, n2);
        }
    }
    
    private static class d
    {
        public final int a;
        public final int b;
        public final long c;
        public final byte[] d;
        
        d(final int a, final int b, final long c, final byte[] d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
        
        d(final int n, final int n2, final byte[] array) {
            this(n, n2, -1L, array);
        }
        
        public static d a(final String s) {
            if (s.length() == 1 && s.charAt(0) >= '0' && s.charAt(0) <= '1') {
                return new d(1, 1, new byte[] { (byte)(s.charAt(0) - '0') });
            }
            final byte[] bytes = s.getBytes(a.p0);
            return new d(1, bytes.length, bytes);
        }
        
        public static d b(final double[] array, final ByteOrder byteOrder) {
            final ByteBuffer wrap = ByteBuffer.wrap(new byte[a.X[12] * array.length]);
            wrap.order(byteOrder);
            for (int length = array.length, i = 0; i < length; ++i) {
                wrap.putDouble(array[i]);
            }
            return new d(12, array.length, wrap.array());
        }
        
        public static d c(final int[] array, final ByteOrder byteOrder) {
            final ByteBuffer wrap = ByteBuffer.wrap(new byte[a.X[9] * array.length]);
            wrap.order(byteOrder);
            for (int length = array.length, i = 0; i < length; ++i) {
                wrap.putInt(array[i]);
            }
            return new d(9, array.length, wrap.array());
        }
        
        public static d d(final f[] array, final ByteOrder byteOrder) {
            final ByteBuffer wrap = ByteBuffer.wrap(new byte[a.X[10] * array.length]);
            wrap.order(byteOrder);
            for (final f f : array) {
                wrap.putInt((int)f.a);
                wrap.putInt((int)f.b);
            }
            return new d(10, array.length, wrap.array());
        }
        
        public static d e(final String s) {
            final StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append('\0');
            final byte[] bytes = sb.toString().getBytes(a.p0);
            return new d(2, bytes.length, bytes);
        }
        
        public static d f(final long n, final ByteOrder byteOrder) {
            return g(new long[] { n }, byteOrder);
        }
        
        public static d g(final long[] array, final ByteOrder byteOrder) {
            final ByteBuffer wrap = ByteBuffer.wrap(new byte[a.X[4] * array.length]);
            wrap.order(byteOrder);
            for (int length = array.length, i = 0; i < length; ++i) {
                wrap.putInt((int)array[i]);
            }
            return new d(4, array.length, wrap.array());
        }
        
        public static d h(final f f, final ByteOrder byteOrder) {
            return i(new f[] { f }, byteOrder);
        }
        
        public static d i(final f[] array, final ByteOrder byteOrder) {
            final ByteBuffer wrap = ByteBuffer.wrap(new byte[a.X[5] * array.length]);
            wrap.order(byteOrder);
            for (final f f : array) {
                wrap.putInt((int)f.a);
                wrap.putInt((int)f.b);
            }
            return new d(5, array.length, wrap.array());
        }
        
        public static d j(final int n, final ByteOrder byteOrder) {
            return k(new int[] { n }, byteOrder);
        }
        
        public static d k(final int[] array, final ByteOrder byteOrder) {
            final ByteBuffer wrap = ByteBuffer.wrap(new byte[a.X[3] * array.length]);
            wrap.order(byteOrder);
            for (int length = array.length, i = 0; i < length; ++i) {
                wrap.putShort((short)array[i]);
            }
            return new d(3, array.length, wrap.array());
        }
        
        public double l(final ByteOrder byteOrder) {
            final Object o = this.o(byteOrder);
            if (o == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            }
            if (o instanceof String) {
                return Double.parseDouble((String)o);
            }
            if (o instanceof long[]) {
                final long[] array = (long[])o;
                if (array.length == 1) {
                    return (double)array[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            else if (o instanceof int[]) {
                final int[] array2 = (int[])o;
                if (array2.length == 1) {
                    return array2[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            else if (o instanceof double[]) {
                final double[] array3 = (double[])o;
                if (array3.length == 1) {
                    return array3[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            else {
                if (!(o instanceof f[])) {
                    throw new NumberFormatException("Couldn't find a double value");
                }
                final f[] array4 = (f[])o;
                if (array4.length == 1) {
                    return array4[0].a();
                }
                throw new NumberFormatException("There are more than one component");
            }
        }
        
        public int m(final ByteOrder byteOrder) {
            final Object o = this.o(byteOrder);
            if (o == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            }
            if (o instanceof String) {
                return Integer.parseInt((String)o);
            }
            if (o instanceof long[]) {
                final long[] array = (long[])o;
                if (array.length == 1) {
                    return (int)array[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            else {
                if (!(o instanceof int[])) {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
                final int[] array2 = (int[])o;
                if (array2.length == 1) {
                    return array2[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
        }
        
        public String n(final ByteOrder byteOrder) {
            final Object o = this.o(byteOrder);
            if (o == null) {
                return null;
            }
            if (o instanceof String) {
                return (String)o;
            }
            final StringBuilder sb = new StringBuilder();
            final boolean b = o instanceof long[];
            final int n = 0;
            final int n2 = 0;
            final int n3 = 0;
            int i = 0;
            if (b) {
                int n4;
                for (long[] array = (long[])o; i < array.length; i = n4) {
                    sb.append(array[i]);
                    n4 = i + 1;
                    if ((i = n4) != array.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (o instanceof int[]) {
                final int[] array2 = (int[])o;
                int n5;
                for (int j = n; j < array2.length; j = n5) {
                    sb.append(array2[j]);
                    n5 = j + 1;
                    if ((j = n5) != array2.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (o instanceof double[]) {
                final double[] array3 = (double[])o;
                int n6;
                for (int k = n2; k < array3.length; k = n6) {
                    sb.append(array3[k]);
                    n6 = k + 1;
                    if ((k = n6) != array3.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (o instanceof f[]) {
                final f[] array4 = (f[])o;
                int n7;
                for (int l = n3; l < array4.length; l = n7) {
                    sb.append(array4[l].a);
                    sb.append('/');
                    sb.append(array4[l].b);
                    n7 = l + 1;
                    if ((l = n7) != array4.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            return null;
        }
        
        Object o(final ByteOrder p0) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     3: new             Landroidx/exifinterface/media/a$b;
            //     6: astore          14
            //     8: aload           14
            //    10: aload_0        
            //    11: getfield        androidx/exifinterface/media/a$d.d:[B
            //    14: invokespecial   androidx/exifinterface/media/a$b.<init>:([B)V
            //    17: aload           14
            //    19: astore          13
            //    21: aload           14
            //    23: aload_1        
            //    24: invokevirtual   androidx/exifinterface/media/a$b.d:(Ljava/nio/ByteOrder;)V
            //    27: aload           14
            //    29: astore          13
            //    31: aload_0        
            //    32: getfield        androidx/exifinterface/media/a$d.a:I
            //    35: istore          12
            //    37: iconst_1       
            //    38: istore          5
            //    40: iconst_0       
            //    41: istore          11
            //    43: iconst_0       
            //    44: istore_2       
            //    45: iconst_0       
            //    46: istore          8
            //    48: iconst_0       
            //    49: istore          7
            //    51: iconst_0       
            //    52: istore_3       
            //    53: iconst_0       
            //    54: istore          10
            //    56: iconst_0       
            //    57: istore          9
            //    59: iconst_0       
            //    60: istore          4
            //    62: iconst_0       
            //    63: istore          6
            //    65: iload           12
            //    67: tableswitch {
            //                2: 880
            //                3: 684
            //                4: 618
            //                5: 552
            //                6: 474
            //                7: 880
            //                8: 684
            //                9: 408
            //               10: 342
            //               11: 264
            //               12: 197
            //               13: 131
            //          default: 128
            //        }
            //   128: goto            997
            //   131: aload           14
            //   133: astore          13
            //   135: aload_0        
            //   136: getfield        androidx/exifinterface/media/a$d.b:I
            //   139: newarray        D
            //   141: astore_1       
            //   142: iload           6
            //   144: istore_2       
            //   145: aload           14
            //   147: astore          13
            //   149: iload_2        
            //   150: aload_0        
            //   151: getfield        androidx/exifinterface/media/a$d.b:I
            //   154: if_icmpge       175
            //   157: aload           14
            //   159: astore          13
            //   161: aload_1        
            //   162: iload_2        
            //   163: aload           14
            //   165: invokevirtual   androidx/exifinterface/media/a$b.readDouble:()D
            //   168: dastore        
            //   169: iinc            2, 1
            //   172: goto            145
            //   175: aload           14
            //   177: invokevirtual   java/io/InputStream.close:()V
            //   180: goto            195
            //   183: astore          13
            //   185: ldc             "ExifInterface"
            //   187: ldc             "IOException occurred while closing InputStream"
            //   189: aload           13
            //   191: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
            //   194: pop            
            //   195: aload_1        
            //   196: areturn        
            //   197: aload           14
            //   199: astore          13
            //   201: aload_0        
            //   202: getfield        androidx/exifinterface/media/a$d.b:I
            //   205: newarray        D
            //   207: astore_1       
            //   208: iload           11
            //   210: istore_2       
            //   211: aload           14
            //   213: astore          13
            //   215: iload_2        
            //   216: aload_0        
            //   217: getfield        androidx/exifinterface/media/a$d.b:I
            //   220: if_icmpge       242
            //   223: aload           14
            //   225: astore          13
            //   227: aload_1        
            //   228: iload_2        
            //   229: aload           14
            //   231: invokevirtual   androidx/exifinterface/media/a$b.readFloat:()F
            //   234: f2d            
            //   235: dastore        
            //   236: iinc            2, 1
            //   239: goto            211
            //   242: aload           14
            //   244: invokevirtual   java/io/InputStream.close:()V
            //   247: goto            262
            //   250: astore          13
            //   252: ldc             "ExifInterface"
            //   254: ldc             "IOException occurred while closing InputStream"
            //   256: aload           13
            //   258: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
            //   261: pop            
            //   262: aload_1        
            //   263: areturn        
            //   264: aload           14
            //   266: astore          13
            //   268: aload_0        
            //   269: getfield        androidx/exifinterface/media/a$d.b:I
            //   272: anewarray       Landroidx/exifinterface/media/a$f;
            //   275: astore_1       
            //   276: aload           14
            //   278: astore          13
            //   280: iload_2        
            //   281: aload_0        
            //   282: getfield        androidx/exifinterface/media/a$d.b:I
            //   285: if_icmpge       320
            //   288: aload           14
            //   290: astore          13
            //   292: aload_1        
            //   293: iload_2        
            //   294: new             Landroidx/exifinterface/media/a$f;
            //   297: dup            
            //   298: aload           14
            //   300: invokevirtual   androidx/exifinterface/media/a$b.readInt:()I
            //   303: i2l            
            //   304: aload           14
            //   306: invokevirtual   androidx/exifinterface/media/a$b.readInt:()I
            //   309: i2l            
            //   310: invokespecial   androidx/exifinterface/media/a$f.<init>:(JJ)V
            //   313: aastore        
            //   314: iinc            2, 1
            //   317: goto            276
            //   320: aload           14
            //   322: invokevirtual   java/io/InputStream.close:()V
            //   325: goto            340
            //   328: astore          13
            //   330: ldc             "ExifInterface"
            //   332: ldc             "IOException occurred while closing InputStream"
            //   334: aload           13
            //   336: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
            //   339: pop            
            //   340: aload_1        
            //   341: areturn        
            //   342: aload           14
            //   344: astore          13
            //   346: aload_0        
            //   347: getfield        androidx/exifinterface/media/a$d.b:I
            //   350: newarray        I
            //   352: astore_1       
            //   353: iload           8
            //   355: istore_2       
            //   356: aload           14
            //   358: astore          13
            //   360: iload_2        
            //   361: aload_0        
            //   362: getfield        androidx/exifinterface/media/a$d.b:I
            //   365: if_icmpge       386
            //   368: aload           14
            //   370: astore          13
            //   372: aload_1        
            //   373: iload_2        
            //   374: aload           14
            //   376: invokevirtual   androidx/exifinterface/media/a$b.readInt:()I
            //   379: iastore        
            //   380: iinc            2, 1
            //   383: goto            356
            //   386: aload           14
            //   388: invokevirtual   java/io/InputStream.close:()V
            //   391: goto            406
            //   394: astore          13
            //   396: ldc             "ExifInterface"
            //   398: ldc             "IOException occurred while closing InputStream"
            //   400: aload           13
            //   402: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
            //   405: pop            
            //   406: aload_1        
            //   407: areturn        
            //   408: aload           14
            //   410: astore          13
            //   412: aload_0        
            //   413: getfield        androidx/exifinterface/media/a$d.b:I
            //   416: newarray        I
            //   418: astore_1       
            //   419: iload           7
            //   421: istore_2       
            //   422: aload           14
            //   424: astore          13
            //   426: iload_2        
            //   427: aload_0        
            //   428: getfield        androidx/exifinterface/media/a$d.b:I
            //   431: if_icmpge       452
            //   434: aload           14
            //   436: astore          13
            //   438: aload_1        
            //   439: iload_2        
            //   440: aload           14
            //   442: invokevirtual   androidx/exifinterface/media/a$b.readShort:()S
            //   445: iastore        
            //   446: iinc            2, 1
            //   449: goto            422
            //   452: aload           14
            //   454: invokevirtual   java/io/InputStream.close:()V
            //   457: goto            472
            //   460: astore          13
            //   462: ldc             "ExifInterface"
            //   464: ldc             "IOException occurred while closing InputStream"
            //   466: aload           13
            //   468: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
            //   471: pop            
            //   472: aload_1        
            //   473: areturn        
            //   474: aload           14
            //   476: astore          13
            //   478: aload_0        
            //   479: getfield        androidx/exifinterface/media/a$d.b:I
            //   482: anewarray       Landroidx/exifinterface/media/a$f;
            //   485: astore_1       
            //   486: iload_3        
            //   487: istore_2       
            //   488: aload           14
            //   490: astore          13
            //   492: iload_2        
            //   493: aload_0        
            //   494: getfield        androidx/exifinterface/media/a$d.b:I
            //   497: if_icmpge       530
            //   500: aload           14
            //   502: astore          13
            //   504: aload_1        
            //   505: iload_2        
            //   506: new             Landroidx/exifinterface/media/a$f;
            //   509: dup            
            //   510: aload           14
            //   512: invokevirtual   androidx/exifinterface/media/a$b.c:()J
            //   515: aload           14
            //   517: invokevirtual   androidx/exifinterface/media/a$b.c:()J
            //   520: invokespecial   androidx/exifinterface/media/a$f.<init>:(JJ)V
            //   523: aastore        
            //   524: iinc            2, 1
            //   527: goto            488
            //   530: aload           14
            //   532: invokevirtual   java/io/InputStream.close:()V
            //   535: goto            550
            //   538: astore          13
            //   540: ldc             "ExifInterface"
            //   542: ldc             "IOException occurred while closing InputStream"
            //   544: aload           13
            //   546: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
            //   549: pop            
            //   550: aload_1        
            //   551: areturn        
            //   552: aload           14
            //   554: astore          13
            //   556: aload_0        
            //   557: getfield        androidx/exifinterface/media/a$d.b:I
            //   560: newarray        J
            //   562: astore_1       
            //   563: iload           10
            //   565: istore_2       
            //   566: aload           14
            //   568: astore          13
            //   570: iload_2        
            //   571: aload_0        
            //   572: getfield        androidx/exifinterface/media/a$d.b:I
            //   575: if_icmpge       596
            //   578: aload           14
            //   580: astore          13
            //   582: aload_1        
            //   583: iload_2        
            //   584: aload           14
            //   586: invokevirtual   androidx/exifinterface/media/a$b.c:()J
            //   589: lastore        
            //   590: iinc            2, 1
            //   593: goto            566
            //   596: aload           14
            //   598: invokevirtual   java/io/InputStream.close:()V
            //   601: goto            616
            //   604: astore          13
            //   606: ldc             "ExifInterface"
            //   608: ldc             "IOException occurred while closing InputStream"
            //   610: aload           13
            //   612: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
            //   615: pop            
            //   616: aload_1        
            //   617: areturn        
            //   618: aload           14
            //   620: astore          13
            //   622: aload_0        
            //   623: getfield        androidx/exifinterface/media/a$d.b:I
            //   626: newarray        I
            //   628: astore_1       
            //   629: iload           9
            //   631: istore_2       
            //   632: aload           14
            //   634: astore          13
            //   636: iload_2        
            //   637: aload_0        
            //   638: getfield        androidx/exifinterface/media/a$d.b:I
            //   641: if_icmpge       662
            //   644: aload           14
            //   646: astore          13
            //   648: aload_1        
            //   649: iload_2        
            //   650: aload           14
            //   652: invokevirtual   androidx/exifinterface/media/a$b.readUnsignedShort:()I
            //   655: iastore        
            //   656: iinc            2, 1
            //   659: goto            632
            //   662: aload           14
            //   664: invokevirtual   java/io/InputStream.close:()V
            //   667: goto            682
            //   670: astore          13
            //   672: ldc             "ExifInterface"
            //   674: ldc             "IOException occurred while closing InputStream"
            //   676: aload           13
            //   678: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
            //   681: pop            
            //   682: aload_1        
            //   683: areturn        
            //   684: iload           4
            //   686: istore_2       
            //   687: aload           14
            //   689: astore          13
            //   691: aload_0        
            //   692: getfield        androidx/exifinterface/media/a$d.b:I
            //   695: getstatic       androidx/exifinterface/media/a.Y:[B
            //   698: arraylength    
            //   699: if_icmplt       766
            //   702: iconst_0       
            //   703: istore_2       
            //   704: aload           14
            //   706: astore          13
            //   708: getstatic       androidx/exifinterface/media/a.Y:[B
            //   711: astore_1       
            //   712: iload           5
            //   714: istore_3       
            //   715: aload           14
            //   717: astore          13
            //   719: iload_2        
            //   720: aload_1        
            //   721: arraylength    
            //   722: if_icmpge       752
            //   725: aload           14
            //   727: astore          13
            //   729: aload_0        
            //   730: getfield        androidx/exifinterface/media/a$d.d:[B
            //   733: iload_2        
            //   734: baload         
            //   735: aload_1        
            //   736: iload_2        
            //   737: baload         
            //   738: if_icmpeq       746
            //   741: iconst_0       
            //   742: istore_3       
            //   743: goto            752
            //   746: iinc            2, 1
            //   749: goto            704
            //   752: iload           4
            //   754: istore_2       
            //   755: iload_3        
            //   756: ifeq            766
            //   759: aload           14
            //   761: astore          13
            //   763: aload_1        
            //   764: arraylength    
            //   765: istore_2       
            //   766: aload           14
            //   768: astore          13
            //   770: new             Ljava/lang/StringBuilder;
            //   773: astore_1       
            //   774: aload           14
            //   776: astore          13
            //   778: aload_1        
            //   779: invokespecial   java/lang/StringBuilder.<init>:()V
            //   782: aload           14
            //   784: astore          13
            //   786: iload_2        
            //   787: aload_0        
            //   788: getfield        androidx/exifinterface/media/a$d.b:I
            //   791: if_icmpge       849
            //   794: aload           14
            //   796: astore          13
            //   798: aload_0        
            //   799: getfield        androidx/exifinterface/media/a$d.d:[B
            //   802: iload_2        
            //   803: baload         
            //   804: istore_3       
            //   805: iload_3        
            //   806: ifne            812
            //   809: goto            849
            //   812: iload_3        
            //   813: bipush          32
            //   815: if_icmplt       832
            //   818: aload           14
            //   820: astore          13
            //   822: aload_1        
            //   823: iload_3        
            //   824: i2c            
            //   825: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
            //   828: pop            
            //   829: goto            843
            //   832: aload           14
            //   834: astore          13
            //   836: aload_1        
            //   837: bipush          63
            //   839: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
            //   842: pop            
            //   843: iinc            2, 1
            //   846: goto            782
            //   849: aload           14
            //   851: astore          13
            //   853: aload_1        
            //   854: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
            //   857: astore_1       
            //   858: aload           14
            //   860: invokevirtual   java/io/InputStream.close:()V
            //   863: goto            878
            //   866: astore          13
            //   868: ldc             "ExifInterface"
            //   870: ldc             "IOException occurred while closing InputStream"
            //   872: aload           13
            //   874: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
            //   877: pop            
            //   878: aload_1        
            //   879: areturn        
            //   880: aload           14
            //   882: astore          13
            //   884: aload_0        
            //   885: getfield        androidx/exifinterface/media/a$d.d:[B
            //   888: astore_1       
            //   889: aload           14
            //   891: astore          13
            //   893: aload_1        
            //   894: arraylength    
            //   895: iconst_1       
            //   896: if_icmpne       959
            //   899: aload_1        
            //   900: iconst_0       
            //   901: baload         
            //   902: iflt            959
            //   905: aload_1        
            //   906: iconst_0       
            //   907: baload         
            //   908: iconst_1       
            //   909: if_icmpgt       959
            //   912: aload           14
            //   914: astore          13
            //   916: new             Ljava/lang/String;
            //   919: dup            
            //   920: iconst_1       
            //   921: newarray        C
            //   923: dup            
            //   924: iconst_0       
            //   925: aload_1        
            //   926: iconst_0       
            //   927: baload         
            //   928: bipush          48
            //   930: iadd           
            //   931: i2c            
            //   932: castore        
            //   933: invokespecial   java/lang/String.<init>:([C)V
            //   936: astore_1       
            //   937: aload           14
            //   939: invokevirtual   java/io/InputStream.close:()V
            //   942: goto            957
            //   945: astore          13
            //   947: ldc             "ExifInterface"
            //   949: ldc             "IOException occurred while closing InputStream"
            //   951: aload           13
            //   953: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
            //   956: pop            
            //   957: aload_1        
            //   958: areturn        
            //   959: aload           14
            //   961: astore          13
            //   963: new             Ljava/lang/String;
            //   966: dup            
            //   967: aload_1        
            //   968: getstatic       androidx/exifinterface/media/a.p0:Ljava/nio/charset/Charset;
            //   971: invokespecial   java/lang/String.<init>:([BLjava/nio/charset/Charset;)V
            //   974: astore_1       
            //   975: aload           14
            //   977: invokevirtual   java/io/InputStream.close:()V
            //   980: goto            995
            //   983: astore          13
            //   985: ldc             "ExifInterface"
            //   987: ldc             "IOException occurred while closing InputStream"
            //   989: aload           13
            //   991: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
            //   994: pop            
            //   995: aload_1        
            //   996: areturn        
            //   997: aload           14
            //   999: invokevirtual   java/io/InputStream.close:()V
            //  1002: goto            1015
            //  1005: astore_1       
            //  1006: ldc             "ExifInterface"
            //  1008: ldc             "IOException occurred while closing InputStream"
            //  1010: aload_1        
            //  1011: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
            //  1014: pop            
            //  1015: aconst_null    
            //  1016: areturn        
            //  1017: astore          13
            //  1019: aload           14
            //  1021: astore_1       
            //  1022: aload           13
            //  1024: astore          14
            //  1026: goto            1037
            //  1029: astore_1       
            //  1030: goto            1074
            //  1033: astore          14
            //  1035: aconst_null    
            //  1036: astore_1       
            //  1037: aload_1        
            //  1038: astore          13
            //  1040: ldc             "ExifInterface"
            //  1042: ldc             "IOException occurred during reading a value"
            //  1044: aload           14
            //  1046: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
            //  1049: pop            
            //  1050: aload_1        
            //  1051: ifnull          1071
            //  1054: aload_1        
            //  1055: invokevirtual   java/io/InputStream.close:()V
            //  1058: goto            1071
            //  1061: astore_1       
            //  1062: ldc             "ExifInterface"
            //  1064: ldc             "IOException occurred while closing InputStream"
            //  1066: aload_1        
            //  1067: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
            //  1070: pop            
            //  1071: aconst_null    
            //  1072: areturn        
            //  1073: astore_1       
            //  1074: aload           13
            //  1076: ifnull          1099
            //  1079: aload           13
            //  1081: invokevirtual   java/io/InputStream.close:()V
            //  1084: goto            1099
            //  1087: astore          13
            //  1089: ldc             "ExifInterface"
            //  1091: ldc             "IOException occurred while closing InputStream"
            //  1093: aload           13
            //  1095: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
            //  1098: pop            
            //  1099: aload_1        
            //  1100: athrow         
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                 
            //  -----  -----  -----  -----  ---------------------
            //  3      17     1033   1037   Ljava/io/IOException;
            //  3      17     1029   1033   Any
            //  21     27     1017   1029   Ljava/io/IOException;
            //  21     27     1073   1074   Any
            //  31     37     1017   1029   Ljava/io/IOException;
            //  31     37     1073   1074   Any
            //  135    142    1017   1029   Ljava/io/IOException;
            //  135    142    1073   1074   Any
            //  149    157    1017   1029   Ljava/io/IOException;
            //  149    157    1073   1074   Any
            //  161    169    1017   1029   Ljava/io/IOException;
            //  161    169    1073   1074   Any
            //  175    180    183    195    Ljava/io/IOException;
            //  201    208    1017   1029   Ljava/io/IOException;
            //  201    208    1073   1074   Any
            //  215    223    1017   1029   Ljava/io/IOException;
            //  215    223    1073   1074   Any
            //  227    236    1017   1029   Ljava/io/IOException;
            //  227    236    1073   1074   Any
            //  242    247    250    262    Ljava/io/IOException;
            //  268    276    1017   1029   Ljava/io/IOException;
            //  268    276    1073   1074   Any
            //  280    288    1017   1029   Ljava/io/IOException;
            //  280    288    1073   1074   Any
            //  292    314    1017   1029   Ljava/io/IOException;
            //  292    314    1073   1074   Any
            //  320    325    328    340    Ljava/io/IOException;
            //  346    353    1017   1029   Ljava/io/IOException;
            //  346    353    1073   1074   Any
            //  360    368    1017   1029   Ljava/io/IOException;
            //  360    368    1073   1074   Any
            //  372    380    1017   1029   Ljava/io/IOException;
            //  372    380    1073   1074   Any
            //  386    391    394    406    Ljava/io/IOException;
            //  412    419    1017   1029   Ljava/io/IOException;
            //  412    419    1073   1074   Any
            //  426    434    1017   1029   Ljava/io/IOException;
            //  426    434    1073   1074   Any
            //  438    446    1017   1029   Ljava/io/IOException;
            //  438    446    1073   1074   Any
            //  452    457    460    472    Ljava/io/IOException;
            //  478    486    1017   1029   Ljava/io/IOException;
            //  478    486    1073   1074   Any
            //  492    500    1017   1029   Ljava/io/IOException;
            //  492    500    1073   1074   Any
            //  504    524    1017   1029   Ljava/io/IOException;
            //  504    524    1073   1074   Any
            //  530    535    538    550    Ljava/io/IOException;
            //  556    563    1017   1029   Ljava/io/IOException;
            //  556    563    1073   1074   Any
            //  570    578    1017   1029   Ljava/io/IOException;
            //  570    578    1073   1074   Any
            //  582    590    1017   1029   Ljava/io/IOException;
            //  582    590    1073   1074   Any
            //  596    601    604    616    Ljava/io/IOException;
            //  622    629    1017   1029   Ljava/io/IOException;
            //  622    629    1073   1074   Any
            //  636    644    1017   1029   Ljava/io/IOException;
            //  636    644    1073   1074   Any
            //  648    656    1017   1029   Ljava/io/IOException;
            //  648    656    1073   1074   Any
            //  662    667    670    682    Ljava/io/IOException;
            //  691    702    1017   1029   Ljava/io/IOException;
            //  691    702    1073   1074   Any
            //  708    712    1017   1029   Ljava/io/IOException;
            //  708    712    1073   1074   Any
            //  719    725    1017   1029   Ljava/io/IOException;
            //  719    725    1073   1074   Any
            //  729    741    1017   1029   Ljava/io/IOException;
            //  729    741    1073   1074   Any
            //  763    766    1017   1029   Ljava/io/IOException;
            //  763    766    1073   1074   Any
            //  770    774    1017   1029   Ljava/io/IOException;
            //  770    774    1073   1074   Any
            //  778    782    1017   1029   Ljava/io/IOException;
            //  778    782    1073   1074   Any
            //  786    794    1017   1029   Ljava/io/IOException;
            //  786    794    1073   1074   Any
            //  798    805    1017   1029   Ljava/io/IOException;
            //  798    805    1073   1074   Any
            //  822    829    1017   1029   Ljava/io/IOException;
            //  822    829    1073   1074   Any
            //  836    843    1017   1029   Ljava/io/IOException;
            //  836    843    1073   1074   Any
            //  853    858    1017   1029   Ljava/io/IOException;
            //  853    858    1073   1074   Any
            //  858    863    866    878    Ljava/io/IOException;
            //  884    889    1017   1029   Ljava/io/IOException;
            //  884    889    1073   1074   Any
            //  893    899    1017   1029   Ljava/io/IOException;
            //  893    899    1073   1074   Any
            //  916    937    1017   1029   Ljava/io/IOException;
            //  916    937    1073   1074   Any
            //  937    942    945    957    Ljava/io/IOException;
            //  963    975    1017   1029   Ljava/io/IOException;
            //  963    975    1073   1074   Any
            //  975    980    983    995    Ljava/io/IOException;
            //  997    1002   1005   1015   Ljava/io/IOException;
            //  1040   1050   1073   1074   Any
            //  1054   1058   1061   1071   Ljava/io/IOException;
            //  1079   1084   1087   1099   Ljava/io/IOException;
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0128:
            //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
            //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2604)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
            //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:206)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:93)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:868)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:761)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:638)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:662)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:605)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:195)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:162)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:137)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
            //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
            //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
            //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:129)
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
        
        public int p() {
            return androidx.exifinterface.media.a.X[this.a] * this.b;
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(androidx.exifinterface.media.a.W[this.a]);
            sb.append(", data length:");
            sb.append(this.d.length);
            sb.append(")");
            return sb.toString();
        }
    }
    
    static class e
    {
        public final int a;
        public final String b;
        public final int c;
        public final int d;
        
        e(final String b, final int a, final int c) {
            this.b = b;
            this.a = a;
            this.c = c;
            this.d = -1;
        }
        
        e(final String b, final int a, final int c, final int d) {
            this.b = b;
            this.a = a;
            this.c = c;
            this.d = d;
        }
        
        boolean a(final int n) {
            final int c = this.c;
            if (c != 7) {
                if (n != 7) {
                    if (c != n) {
                        final int d = this.d;
                        if (d != n) {
                            return ((c == 4 || d == 4) && n == 3) || ((c == 9 || d == 9) && n == 8) || ((c == 12 || d == 12) && n == 11);
                        }
                    }
                }
            }
            return true;
        }
    }
    
    private static class f
    {
        public final long a;
        public final long b;
        
        f(final double n) {
            this((long)(n * 10000.0), 10000L);
        }
        
        f(final long a, final long b) {
            if (b == 0L) {
                this.a = 0L;
                this.b = 1L;
                return;
            }
            this.a = a;
            this.b = b;
        }
        
        public double a() {
            return this.a / (double)this.b;
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append("/");
            sb.append(this.b);
            return sb.toString();
        }
    }
    
    private static class g extends b
    {
        g(final InputStream inputStream) throws IOException {
            super(inputStream);
            if (inputStream.markSupported()) {
                super.a.mark(Integer.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
        }
        
        g(final byte[] array) throws IOException {
            super(array);
            super.a.mark(Integer.MAX_VALUE);
        }
        
        public void h(long n) throws IOException {
            final int c = super.c;
            if (c > n) {
                super.c = 0;
                super.a.reset();
            }
            else {
                n -= c;
            }
            ((b)this).e((int)n);
        }
    }
}

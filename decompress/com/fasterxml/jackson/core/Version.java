// 
// Decompiled by Procyon v0.6.0
// 

package com.fasterxml.jackson.core;

import java.io.Serializable;

public class Version implements Comparable<Version>, Serializable
{
    private static final Version a;
    private static final long serialVersionUID = 1L;
    protected final String _artifactId;
    protected final String _groupId;
    protected final int _majorVersion;
    protected final int _minorVersion;
    protected final int _patchLevel;
    protected final String _snapshotInfo;
    
    static {
        a = new Version(0, 0, 0, null, null, null);
    }
    
    @Deprecated
    public Version(final int n, final int n2, final int n3, final String s) {
        this(n, n2, n3, s, null, null);
    }
    
    public Version(final int majorVersion, final int minorVersion, final int patchLevel, String artifactId, final String s, final String s2) {
        this._majorVersion = majorVersion;
        this._minorVersion = minorVersion;
        this._patchLevel = patchLevel;
        this._snapshotInfo = artifactId;
        artifactId = s;
        if (s == null) {
            artifactId = "";
        }
        this._groupId = artifactId;
        if ((artifactId = s2) == null) {
            artifactId = "";
        }
        this._artifactId = artifactId;
    }
    
    public static Version unknownVersion() {
        return Version.a;
    }
    
    @Override
    public int compareTo(final Version version) {
        if (version == this) {
            return 0;
        }
        int n;
        if ((n = this._groupId.compareTo(version._groupId)) == 0 && (n = this._artifactId.compareTo(version._artifactId)) == 0 && (n = this._majorVersion - version._majorVersion) == 0 && (n = this._minorVersion - version._minorVersion) == 0) {
            n = this._patchLevel - version._patchLevel;
        }
        return n;
    }
    
    @Override
    public /* bridge */ int compareTo(final Object o) {
        return this.compareTo((Version)o);
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o.getClass() != this.getClass()) {
            return false;
        }
        final Version version = (Version)o;
        if (version._majorVersion != this._majorVersion || version._minorVersion != this._minorVersion || version._patchLevel != this._patchLevel || !version._artifactId.equals(this._artifactId) || !version._groupId.equals(this._groupId)) {
            b = false;
        }
        return b;
    }
    
    public String getArtifactId() {
        return this._artifactId;
    }
    
    public String getGroupId() {
        return this._groupId;
    }
    
    public int getMajorVersion() {
        return this._majorVersion;
    }
    
    public int getMinorVersion() {
        return this._minorVersion;
    }
    
    public int getPatchLevel() {
        return this._patchLevel;
    }
    
    @Override
    public int hashCode() {
        return this._artifactId.hashCode() ^ this._groupId.hashCode() + this._majorVersion - this._minorVersion + this._patchLevel;
    }
    
    public boolean isSnapshot() {
        final String snapshotInfo = this._snapshotInfo;
        return snapshotInfo != null && snapshotInfo.length() > 0;
    }
    
    @Deprecated
    public boolean isUknownVersion() {
        return this.isUnknownVersion();
    }
    
    public boolean isUnknownVersion() {
        return this == Version.a;
    }
    
    public String toFullString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this._groupId);
        sb.append('/');
        sb.append(this._artifactId);
        sb.append('/');
        sb.append(this.toString());
        return sb.toString();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this._majorVersion);
        sb.append('.');
        sb.append(this._minorVersion);
        sb.append('.');
        sb.append(this._patchLevel);
        if (this.isSnapshot()) {
            sb.append('-');
            sb.append(this._snapshotInfo);
        }
        return sb.toString();
    }
}

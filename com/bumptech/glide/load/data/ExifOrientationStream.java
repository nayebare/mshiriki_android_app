package com.bumptech.glide.load.data;

import android.support.v4.view.MotionEventCompat;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ExifOrientationStream extends FilterInputStream {
    private static final byte[] EXIF_SEGMENT;
    private static final int ORIENTATION_POSITION;
    private static final int SEGMENT_LENGTH;
    private static final int SEGMENT_START_POSITION = 2;
    private final byte orientation;
    private int position;

    static {
        EXIF_SEGMENT = new byte[]{(byte) -1, (byte) -31, (byte) 0, (byte) 28, (byte) 69, (byte) 120, (byte) 105, (byte) 102, (byte) 0, (byte) 0, (byte) 77, (byte) 77, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 8, (byte) 0, (byte) 1, (byte) 1, (byte) 18, (byte) 0, (byte) 2, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0};
        SEGMENT_LENGTH = EXIF_SEGMENT.length;
        ORIENTATION_POSITION = SEGMENT_LENGTH + SEGMENT_START_POSITION;
    }

    public ExifOrientationStream(InputStream in, int orientation) {
        super(in);
        if (orientation < -1 || orientation > 8) {
            throw new IllegalArgumentException("Cannot add invalid orientation: " + orientation);
        }
        this.orientation = (byte) orientation;
    }

    public boolean markSupported() {
        return false;
    }

    public void mark(int readlimit) {
        throw new UnsupportedOperationException();
    }

    public int read() throws IOException {
        int result;
        if (this.position < SEGMENT_START_POSITION || this.position > ORIENTATION_POSITION) {
            result = super.read();
        } else if (this.position == ORIENTATION_POSITION) {
            result = this.orientation;
        } else {
            result = EXIF_SEGMENT[this.position - 2] & MotionEventCompat.ACTION_MASK;
        }
        if (result != -1) {
            this.position++;
        }
        return result;
    }

    public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        int read;
        if (this.position > ORIENTATION_POSITION) {
            read = super.read(buffer, byteOffset, byteCount);
        } else if (this.position == ORIENTATION_POSITION) {
            buffer[byteOffset] = this.orientation;
            read = 1;
        } else if (this.position < SEGMENT_START_POSITION) {
            read = super.read(buffer, byteOffset, 2 - this.position);
        } else {
            read = Math.min(ORIENTATION_POSITION - this.position, byteCount);
            System.arraycopy(EXIF_SEGMENT, this.position - 2, buffer, byteOffset, read);
        }
        if (read > 0) {
            this.position += read;
        }
        return read;
    }

    public long skip(long byteCount) throws IOException {
        long skipped = super.skip(byteCount);
        if (skipped > 0) {
            this.position = (int) (((long) this.position) + skipped);
        }
        return skipped;
    }

    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }
}

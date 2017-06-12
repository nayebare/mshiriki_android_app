package org.apache.http.entity;

import android.support.v7.widget.RecyclerView.ItemAnimator;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
public class BasicHttpEntity extends AbstractHttpEntity {
    private InputStream content;
    private long length;

    public BasicHttpEntity() {
        this.length = -1;
    }

    public long getContentLength() {
        return this.length;
    }

    public InputStream getContent() throws IllegalStateException {
        if (this.content != null) {
            return this.content;
        }
        throw new IllegalStateException("Content has not been provided");
    }

    public boolean isRepeatable() {
        return false;
    }

    public void setContentLength(long len) {
        this.length = len;
    }

    public void setContent(InputStream instream) {
        this.content = instream;
    }

    public void writeTo(OutputStream outstream) throws IOException {
        if (outstream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        InputStream instream = getContent();
        try {
            byte[] tmp = new byte[ItemAnimator.FLAG_MOVED];
            while (true) {
                int l = instream.read(tmp);
                if (l == -1) {
                    break;
                }
                outstream.write(tmp, 0, l);
            }
        } finally {
            instream.close();
        }
    }

    public boolean isStreaming() {
        return this.content != null;
    }

    @Deprecated
    public void consumeContent() throws IOException {
        if (this.content != null) {
            this.content.close();
        }
    }
}

package com.bumptech.glide.gifencoder;

import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.wallet.WalletConstants.CardNetwork;

class NeuQuant {
    protected static final int alphabiasshift = 10;
    protected static final int alpharadbias = 262144;
    protected static final int alpharadbshift = 18;
    protected static final int beta = 64;
    protected static final int betagamma = 65536;
    protected static final int betashift = 10;
    protected static final int gamma = 1024;
    protected static final int gammashift = 10;
    protected static final int initalpha = 1024;
    protected static final int initrad = 32;
    protected static final int initradius = 2048;
    protected static final int intbias = 65536;
    protected static final int intbiasshift = 16;
    protected static final int maxnetpos = 255;
    protected static final int minpicturebytes = 1509;
    protected static final int ncycles = 100;
    protected static final int netbiasshift = 4;
    protected static final int netsize = 256;
    protected static final int prime1 = 499;
    protected static final int prime2 = 491;
    protected static final int prime3 = 487;
    protected static final int prime4 = 503;
    protected static final int radbias = 256;
    protected static final int radbiasshift = 8;
    protected static final int radiusbias = 64;
    protected static final int radiusbiasshift = 6;
    protected static final int radiusdec = 30;
    protected int alphadec;
    protected int[] bias;
    protected int[] freq;
    protected int lengthcount;
    protected int[] netindex;
    protected int[][] network;
    protected int[] radpower;
    protected int samplefac;
    protected byte[] thepicture;

    public NeuQuant(byte[] thepic, int len, int sample) {
        this.netindex = new int[radbias];
        this.bias = new int[radbias];
        this.freq = new int[radbias];
        this.radpower = new int[initrad];
        this.thepicture = thepic;
        this.lengthcount = len;
        this.samplefac = sample;
        this.network = new int[radbias][];
        for (int i = 0; i < radbias; i++) {
            this.network[i] = new int[netbiasshift];
            int[] p = this.network[i];
            int i2 = (i << 12) / radbias;
            p[2] = i2;
            p[1] = i2;
            p[0] = i2;
            this.freq[i] = radbias;
            this.bias[i] = 0;
        }
    }

    public byte[] colorMap() {
        int i;
        byte[] map = new byte[768];
        int[] index = new int[radbias];
        for (i = 0; i < radbias; i++) {
            index[this.network[i][3]] = i;
        }
        i = 0;
        int k = 0;
        while (i < radbias) {
            int j = index[i];
            int i2 = k + 1;
            map[k] = (byte) this.network[j][0];
            k = i2 + 1;
            map[i2] = (byte) this.network[j][1];
            i2 = k + 1;
            map[k] = (byte) this.network[j][2];
            i++;
            k = i2;
        }
        return map;
    }

    public void inxbuild() {
        int previouscol = 0;
        int startpos = 0;
        for (int i = 0; i < radbias; i++) {
            int j;
            int[] q;
            int[] p = this.network[i];
            int smallpos = i;
            int smallval = p[1];
            for (j = i + 1; j < radbias; j++) {
                q = this.network[j];
                if (q[1] < smallval) {
                    smallpos = j;
                    smallval = q[1];
                }
            }
            q = this.network[smallpos];
            if (i != smallpos) {
                j = q[0];
                q[0] = p[0];
                p[0] = j;
                j = q[1];
                q[1] = p[1];
                p[1] = j;
                j = q[2];
                q[2] = p[2];
                p[2] = j;
                j = q[3];
                q[3] = p[3];
                p[3] = j;
            }
            if (smallval != previouscol) {
                this.netindex[previouscol] = (startpos + i) >> 1;
                for (j = previouscol + 1; j < smallval; j++) {
                    this.netindex[j] = i;
                }
                previouscol = smallval;
                startpos = i;
            }
        }
        this.netindex[previouscol] = (startpos + maxnetpos) >> 1;
        for (j = previouscol + 1; j < radbias; j++) {
            this.netindex[j] = maxnetpos;
        }
    }

    public void learn() {
        int i;
        int step;
        if (this.lengthcount < minpicturebytes) {
            this.samplefac = 1;
        }
        this.alphadec = ((this.samplefac - 1) / 3) + radiusdec;
        byte[] p = this.thepicture;
        int pix = 0;
        int lim = this.lengthcount;
        int samplepixels = this.lengthcount / (this.samplefac * 3);
        int delta = samplepixels / ncycles;
        int alpha = initalpha;
        int radius = initradius;
        int rad = initradius >> radiusbiasshift;
        if (rad <= 1) {
            rad = 0;
        }
        for (i = 0; i < rad; i++) {
            this.radpower[i] = ((((rad * rad) - (i * i)) * radbias) / (rad * rad)) * initalpha;
        }
        if (this.lengthcount < minpicturebytes) {
            step = 3;
        } else if (this.lengthcount % prime1 != 0) {
            step = 1497;
        } else if (this.lengthcount % prime2 != 0) {
            step = 1473;
        } else if (this.lengthcount % prime3 != 0) {
            step = 1461;
        } else {
            step = minpicturebytes;
        }
        i = 0;
        while (i < samplepixels) {
            int b = (p[pix + 0] & maxnetpos) << netbiasshift;
            int g = (p[pix + 1] & maxnetpos) << netbiasshift;
            int r = (p[pix + 2] & maxnetpos) << netbiasshift;
            int j = contest(b, g, r);
            altersingle(alpha, j, b, g, r);
            if (rad != 0) {
                alterneigh(rad, j, b, g, r);
            }
            pix += step;
            if (pix >= lim) {
                pix -= this.lengthcount;
            }
            i++;
            if (delta == 0) {
                delta = 1;
            }
            if (i % delta == 0) {
                alpha -= alpha / this.alphadec;
                radius -= radius / radiusdec;
                rad = radius >> radiusbiasshift;
                if (rad <= 1) {
                    rad = 0;
                }
                for (j = 0; j < rad; j++) {
                    this.radpower[j] = ((((rad * rad) - (j * j)) * radbias) / (rad * rad)) * alpha;
                }
            }
        }
    }

    public int map(int b, int g, int r) {
        int bestd = CardNetwork.OTHER;
        int best = -1;
        int i = this.netindex[g];
        int j = i - 1;
        while (true) {
            if (i >= radbias && j < 0) {
                return best;
            }
            int[] p;
            int dist;
            int a;
            if (i < radbias) {
                p = this.network[i];
                dist = p[1] - g;
                if (dist >= bestd) {
                    i = radbias;
                } else {
                    i++;
                    if (dist < 0) {
                        dist = -dist;
                    }
                    a = p[0] - b;
                    if (a < 0) {
                        a = -a;
                    }
                    dist += a;
                    if (dist < bestd) {
                        a = p[2] - r;
                        if (a < 0) {
                            a = -a;
                        }
                        dist += a;
                        if (dist < bestd) {
                            bestd = dist;
                            best = p[3];
                        }
                    }
                }
            }
            if (j >= 0) {
                p = this.network[j];
                dist = g - p[1];
                if (dist >= bestd) {
                    j = -1;
                } else {
                    j--;
                    if (dist < 0) {
                        dist = -dist;
                    }
                    a = p[0] - b;
                    if (a < 0) {
                        a = -a;
                    }
                    dist += a;
                    if (dist < bestd) {
                        a = p[2] - r;
                        if (a < 0) {
                            a = -a;
                        }
                        dist += a;
                        if (dist < bestd) {
                            bestd = dist;
                            best = p[3];
                        }
                    }
                }
            }
        }
    }

    public byte[] process() {
        learn();
        unbiasnet();
        inxbuild();
        return colorMap();
    }

    public void unbiasnet() {
        for (int i = 0; i < radbias; i++) {
            int[] iArr = this.network[i];
            iArr[0] = iArr[0] >> netbiasshift;
            iArr = this.network[i];
            iArr[1] = iArr[1] >> netbiasshift;
            iArr = this.network[i];
            iArr[2] = iArr[2] >> netbiasshift;
            this.network[i][3] = i;
        }
    }

    protected void alterneigh(int rad, int i, int b, int g, int r) {
        int lo = i - rad;
        if (lo < -1) {
            lo = -1;
        }
        int hi = i + rad;
        if (hi > radbias) {
            hi = radbias;
        }
        int m = 1;
        int k = i - 1;
        int j = i + 1;
        while (true) {
            if (j < hi || k > lo) {
                int j2;
                int[] p;
                int m2 = m + 1;
                int a = this.radpower[m];
                if (j < hi) {
                    j2 = j + 1;
                    p = this.network[j];
                    try {
                        p[0] = p[0] - (((p[0] - b) * a) / alpharadbias);
                        p[1] = p[1] - (((p[1] - g) * a) / alpharadbias);
                        p[2] = p[2] - (((p[2] - r) * a) / alpharadbias);
                    } catch (Exception e) {
                    }
                } else {
                    j2 = j;
                }
                if (k > lo) {
                    int k2 = k - 1;
                    p = this.network[k];
                    try {
                        p[0] = p[0] - (((p[0] - b) * a) / alpharadbias);
                        p[1] = p[1] - (((p[1] - g) * a) / alpharadbias);
                        p[2] = p[2] - (((p[2] - r) * a) / alpharadbias);
                        m = m2;
                        k = k2;
                        j = j2;
                    } catch (Exception e2) {
                        m = m2;
                        k = k2;
                        j = j2;
                    }
                } else {
                    m = m2;
                    j = j2;
                }
            } else {
                return;
            }
        }
    }

    protected void altersingle(int alpha, int i, int b, int g, int r) {
        int[] n = this.network[i];
        n[0] = n[0] - (((n[0] - b) * alpha) / initalpha);
        n[1] = n[1] - (((n[1] - g) * alpha) / initalpha);
        n[2] = n[2] - (((n[2] - r) * alpha) / initalpha);
    }

    protected int contest(int b, int g, int r) {
        int[] iArr;
        int bestd = Strategy.TTL_SECONDS_INFINITE;
        int bestbiasd = Strategy.TTL_SECONDS_INFINITE;
        int bestpos = -1;
        int bestbiaspos = -1;
        for (int i = 0; i < radbias; i++) {
            int[] n = this.network[i];
            int dist = n[0] - b;
            if (dist < 0) {
                dist = -dist;
            }
            int a = n[1] - g;
            if (a < 0) {
                a = -a;
            }
            dist += a;
            a = n[2] - r;
            if (a < 0) {
                a = -a;
            }
            dist += a;
            if (dist < bestd) {
                bestd = dist;
                bestpos = i;
            }
            int biasdist = dist - (this.bias[i] >> 12);
            if (biasdist < bestbiasd) {
                bestbiasd = biasdist;
                bestbiaspos = i;
            }
            int betafreq = this.freq[i] >> gammashift;
            iArr = this.freq;
            iArr[i] = iArr[i] - betafreq;
            iArr = this.bias;
            iArr[i] = iArr[i] + (betafreq << gammashift);
        }
        iArr = this.freq;
        iArr[bestpos] = iArr[bestpos] + radiusbias;
        iArr = this.bias;
        iArr[bestpos] = iArr[bestpos] - intbias;
        return bestbiaspos;
    }
}

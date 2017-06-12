package com.google.android.gms.wallet;

import com.google.android.gms.wallet.Wallet.WalletOptions;
import java.util.Locale;

public final class Wallet$WalletOptions$Builder {
    private int mTheme;
    private int zzbPw;
    private boolean zzbPx;

    public Wallet$WalletOptions$Builder() {
        this.zzbPw = 3;
        this.mTheme = 0;
        this.zzbPx = true;
    }

    public WalletOptions build() {
        return new WalletOptions(this, null);
    }

    public Wallet$WalletOptions$Builder setEnvironment(int i) {
        if (i == 0 || i == 2 || i == 1 || i == 3) {
            this.zzbPw = i;
            return this;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "Invalid environment value %d", new Object[]{Integer.valueOf(i)}));
    }

    public Wallet$WalletOptions$Builder setTheme(int i) {
        if (i == 0 || i == 1) {
            this.mTheme = i;
            return this;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "Invalid theme value %d", new Object[]{Integer.valueOf(i)}));
    }

    @Deprecated
    public Wallet$WalletOptions$Builder useGoogleWallet() {
        this.zzbPx = false;
        return this;
    }
}

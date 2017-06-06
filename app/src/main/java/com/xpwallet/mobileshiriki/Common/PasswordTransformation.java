package com.xpwallet.mobileshiriki.Common;

import android.text.method.PasswordTransformationMethod;
import android.view.View;

/**
 * Created by Desktop on 16-Nov-16.
 */
public class PasswordTransformation extends PasswordTransformationMethod {
    @Override
    public CharSequence getTransformation(CharSequence source, View view) {
        return new PasswordCharSequence(source);
    }

    public class PasswordCharSequence implements CharSequence{
        private CharSequence sequence;

        public PasswordCharSequence(CharSequence source) {
            sequence = source;
        }

        @Override
        public int length() {
            return sequence.length();
        }

        @Override
        public char charAt(int index) {
            return '*';
        }

        @Override
        public CharSequence subSequence(int start, int end) {
            return sequence.subSequence(start,end);
        }
    }
}

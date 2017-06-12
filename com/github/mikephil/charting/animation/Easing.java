package com.github.mikephil.charting.animation;

import android.support.v7.mediarouter.C0308R;
import com.android.volley.toolbox.ImageRequest;
import com.google.android.gms.C0473R;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.BuyButtonText;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import org.apache.http.protocol.HTTP;

public class Easing {

    /* renamed from: com.github.mikephil.charting.animation.Easing.1 */
    static /* synthetic */ class C04541 {
        static final /* synthetic */ int[] f11xe0165a6e;

        static {
            f11xe0165a6e = new int[EasingOption.values().length];
            try {
                f11xe0165a6e[EasingOption.Linear.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f11xe0165a6e[EasingOption.EaseInQuad.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f11xe0165a6e[EasingOption.EaseOutQuad.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f11xe0165a6e[EasingOption.EaseInOutQuad.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f11xe0165a6e[EasingOption.EaseInCubic.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f11xe0165a6e[EasingOption.EaseOutCubic.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f11xe0165a6e[EasingOption.EaseInOutCubic.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f11xe0165a6e[EasingOption.EaseInQuart.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f11xe0165a6e[EasingOption.EaseOutQuart.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f11xe0165a6e[EasingOption.EaseInOutQuart.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f11xe0165a6e[EasingOption.EaseInSine.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f11xe0165a6e[EasingOption.EaseOutSine.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f11xe0165a6e[EasingOption.EaseInOutSine.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f11xe0165a6e[EasingOption.EaseInExpo.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f11xe0165a6e[EasingOption.EaseOutExpo.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                f11xe0165a6e[EasingOption.EaseInOutExpo.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                f11xe0165a6e[EasingOption.EaseInCirc.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
            try {
                f11xe0165a6e[EasingOption.EaseOutCirc.ordinal()] = 18;
            } catch (NoSuchFieldError e18) {
            }
            try {
                f11xe0165a6e[EasingOption.EaseInOutCirc.ordinal()] = 19;
            } catch (NoSuchFieldError e19) {
            }
            try {
                f11xe0165a6e[EasingOption.EaseInElastic.ordinal()] = 20;
            } catch (NoSuchFieldError e20) {
            }
            try {
                f11xe0165a6e[EasingOption.EaseOutElastic.ordinal()] = 21;
            } catch (NoSuchFieldError e21) {
            }
            try {
                f11xe0165a6e[EasingOption.EaseInOutElastic.ordinal()] = 22;
            } catch (NoSuchFieldError e22) {
            }
            try {
                f11xe0165a6e[EasingOption.EaseInBack.ordinal()] = 23;
            } catch (NoSuchFieldError e23) {
            }
            try {
                f11xe0165a6e[EasingOption.EaseOutBack.ordinal()] = 24;
            } catch (NoSuchFieldError e24) {
            }
            try {
                f11xe0165a6e[EasingOption.EaseInOutBack.ordinal()] = 25;
            } catch (NoSuchFieldError e25) {
            }
            try {
                f11xe0165a6e[EasingOption.EaseInBounce.ordinal()] = 26;
            } catch (NoSuchFieldError e26) {
            }
            try {
                f11xe0165a6e[EasingOption.EaseOutBounce.ordinal()] = 27;
            } catch (NoSuchFieldError e27) {
            }
            try {
                f11xe0165a6e[EasingOption.EaseInOutBounce.ordinal()] = 28;
            } catch (NoSuchFieldError e28) {
            }
        }
    }

    private static class EasingFunctions {
        public static final EasingFunction EaseInBack;
        public static final EasingFunction EaseInBounce;
        public static final EasingFunction EaseInCirc;
        public static final EasingFunction EaseInCubic;
        public static final EasingFunction EaseInElastic;
        public static final EasingFunction EaseInExpo;
        public static final EasingFunction EaseInOutBack;
        public static final EasingFunction EaseInOutBounce;
        public static final EasingFunction EaseInOutCirc;
        public static final EasingFunction EaseInOutCubic;
        public static final EasingFunction EaseInOutElastic;
        public static final EasingFunction EaseInOutExpo;
        public static final EasingFunction EaseInOutQuad;
        public static final EasingFunction EaseInOutQuart;
        public static final EasingFunction EaseInOutSine;
        public static final EasingFunction EaseInQuad;
        public static final EasingFunction EaseInQuart;
        public static final EasingFunction EaseInSine;
        public static final EasingFunction EaseOutBack;
        public static final EasingFunction EaseOutBounce;
        public static final EasingFunction EaseOutCirc;
        public static final EasingFunction EaseOutCubic;
        public static final EasingFunction EaseOutElastic;
        public static final EasingFunction EaseOutExpo;
        public static final EasingFunction EaseOutQuad;
        public static final EasingFunction EaseOutQuart;
        public static final EasingFunction EaseOutSine;
        public static final EasingFunction Linear;

        /* renamed from: com.github.mikephil.charting.animation.Easing.EasingFunctions.1 */
        static class C04551 implements EasingFunction {
            C04551() {
            }

            public float getInterpolation(float input) {
                return input;
            }
        }

        /* renamed from: com.github.mikephil.charting.animation.Easing.EasingFunctions.2 */
        static class C04562 implements EasingFunction {
            C04562() {
            }

            public float getInterpolation(float input) {
                return input * input;
            }
        }

        /* renamed from: com.github.mikephil.charting.animation.Easing.EasingFunctions.3 */
        static class C04573 implements EasingFunction {
            C04573() {
            }

            public float getInterpolation(float input) {
                return (-input) * (input - ImageRequest.DEFAULT_IMAGE_BACKOFF_MULT);
            }
        }

        /* renamed from: com.github.mikephil.charting.animation.Easing.EasingFunctions.4 */
        static class C04584 implements EasingFunction {
            C04584() {
            }

            public float getInterpolation(float input) {
                float position = input / 0.5f;
                if (position < TextTrackStyle.DEFAULT_FONT_SCALE) {
                    return (0.5f * position) * position;
                }
                position -= TextTrackStyle.DEFAULT_FONT_SCALE;
                return -0.5f * (((position - ImageRequest.DEFAULT_IMAGE_BACKOFF_MULT) * position) - TextTrackStyle.DEFAULT_FONT_SCALE);
            }
        }

        /* renamed from: com.github.mikephil.charting.animation.Easing.EasingFunctions.5 */
        static class C04595 implements EasingFunction {
            C04595() {
            }

            public float getInterpolation(float input) {
                return (input * input) * input;
            }
        }

        /* renamed from: com.github.mikephil.charting.animation.Easing.EasingFunctions.6 */
        static class C04606 implements EasingFunction {
            C04606() {
            }

            public float getInterpolation(float input) {
                input -= TextTrackStyle.DEFAULT_FONT_SCALE;
                return ((input * input) * input) + TextTrackStyle.DEFAULT_FONT_SCALE;
            }
        }

        /* renamed from: com.github.mikephil.charting.animation.Easing.EasingFunctions.7 */
        static class C04617 implements EasingFunction {
            C04617() {
            }

            public float getInterpolation(float input) {
                float position = input / 0.5f;
                if (position < TextTrackStyle.DEFAULT_FONT_SCALE) {
                    return ((0.5f * position) * position) * position;
                }
                position -= ImageRequest.DEFAULT_IMAGE_BACKOFF_MULT;
                return (((position * position) * position) + ImageRequest.DEFAULT_IMAGE_BACKOFF_MULT) * 0.5f;
            }
        }

        /* renamed from: com.github.mikephil.charting.animation.Easing.EasingFunctions.8 */
        static class C04628 implements EasingFunction {
            C04628() {
            }

            public float getInterpolation(float input) {
                return ((input * input) * input) * input;
            }
        }

        /* renamed from: com.github.mikephil.charting.animation.Easing.EasingFunctions.9 */
        static class C04639 implements EasingFunction {
            C04639() {
            }

            public float getInterpolation(float input) {
                input -= TextTrackStyle.DEFAULT_FONT_SCALE;
                return -((((input * input) * input) * input) - TextTrackStyle.DEFAULT_FONT_SCALE);
            }
        }

        private EasingFunctions() {
        }

        static {
            Linear = new C04551();
            EaseInQuad = new C04562();
            EaseOutQuad = new C04573();
            EaseInOutQuad = new C04584();
            EaseInCubic = new C04595();
            EaseOutCubic = new C04606();
            EaseInOutCubic = new C04617();
            EaseInQuart = new C04628();
            EaseOutQuart = new C04639();
            EaseInOutQuart = new EasingFunction() {
                public float getInterpolation(float input) {
                    float position = input / 0.5f;
                    if (position < TextTrackStyle.DEFAULT_FONT_SCALE) {
                        return (((0.5f * position) * position) * position) * position;
                    }
                    position -= ImageRequest.DEFAULT_IMAGE_BACKOFF_MULT;
                    return -0.5f * ((((position * position) * position) * position) - ImageRequest.DEFAULT_IMAGE_BACKOFF_MULT);
                }
            };
            EaseInSine = new EasingFunction() {
                public float getInterpolation(float input) {
                    return (-((float) Math.cos(((double) input) * 1.5707963267948966d))) + TextTrackStyle.DEFAULT_FONT_SCALE;
                }
            };
            EaseOutSine = new EasingFunction() {
                public float getInterpolation(float input) {
                    return (float) Math.sin(((double) input) * 1.5707963267948966d);
                }
            };
            EaseInOutSine = new EasingFunction() {
                public float getInterpolation(float input) {
                    return -0.5f * (((float) Math.cos(3.141592653589793d * ((double) input))) - TextTrackStyle.DEFAULT_FONT_SCALE);
                }
            };
            EaseInExpo = new EasingFunction() {
                public float getInterpolation(float input) {
                    return input == 0.0f ? 0.0f : (float) Math.pow(2.0d, (double) (10.0f * (input - TextTrackStyle.DEFAULT_FONT_SCALE)));
                }
            };
            EaseOutExpo = new EasingFunction() {
                public float getInterpolation(float input) {
                    return input == TextTrackStyle.DEFAULT_FONT_SCALE ? TextTrackStyle.DEFAULT_FONT_SCALE : -((float) Math.pow(2.0d, (double) ((TextTrackStyle.DEFAULT_FONT_SCALE + input) * -10.0f)));
                }
            };
            EaseInOutExpo = new EasingFunction() {
                public float getInterpolation(float input) {
                    if (input == 0.0f) {
                        return 0.0f;
                    }
                    if (input == TextTrackStyle.DEFAULT_FONT_SCALE) {
                        return TextTrackStyle.DEFAULT_FONT_SCALE;
                    }
                    float position = input / 0.5f;
                    if (position < TextTrackStyle.DEFAULT_FONT_SCALE) {
                        return ((float) Math.pow(2.0d, (double) (10.0f * (position - TextTrackStyle.DEFAULT_FONT_SCALE)))) * 0.5f;
                    }
                    return ((-((float) Math.pow(2.0d, (double) (-10.0f * (position - TextTrackStyle.DEFAULT_FONT_SCALE))))) + ImageRequest.DEFAULT_IMAGE_BACKOFF_MULT) * 0.5f;
                }
            };
            EaseInCirc = new EasingFunction() {
                public float getInterpolation(float input) {
                    return -(((float) Math.sqrt((double) (TextTrackStyle.DEFAULT_FONT_SCALE - (input * input)))) - TextTrackStyle.DEFAULT_FONT_SCALE);
                }
            };
            EaseOutCirc = new EasingFunction() {
                public float getInterpolation(float input) {
                    input -= TextTrackStyle.DEFAULT_FONT_SCALE;
                    return (float) Math.sqrt((double) (TextTrackStyle.DEFAULT_FONT_SCALE - (input * input)));
                }
            };
            EaseInOutCirc = new EasingFunction() {
                public float getInterpolation(float input) {
                    float position = input / 0.5f;
                    if (position < TextTrackStyle.DEFAULT_FONT_SCALE) {
                        return -0.5f * (((float) Math.sqrt((double) (TextTrackStyle.DEFAULT_FONT_SCALE - (position * position)))) - TextTrackStyle.DEFAULT_FONT_SCALE);
                    }
                    position -= ImageRequest.DEFAULT_IMAGE_BACKOFF_MULT;
                    return (((float) Math.sqrt((double) (TextTrackStyle.DEFAULT_FONT_SCALE - (position * position)))) + TextTrackStyle.DEFAULT_FONT_SCALE) * 0.5f;
                }
            };
            EaseInElastic = new EasingFunction() {
                public float getInterpolation(float input) {
                    if (input == 0.0f) {
                        return 0.0f;
                    }
                    float position = input;
                    if (position == TextTrackStyle.DEFAULT_FONT_SCALE) {
                        return TextTrackStyle.DEFAULT_FONT_SCALE;
                    }
                    position -= TextTrackStyle.DEFAULT_FONT_SCALE;
                    return -(((float) Math.pow(2.0d, (double) (10.0f * position))) * ((float) Math.sin((((double) (position - ((0.3f / 6.2831855f) * ((float) Math.asin(1.0d))))) * 6.283185307179586d) / ((double) 1050253722))));
                }
            };
            EaseOutElastic = new EasingFunction() {
                public float getInterpolation(float input) {
                    if (input == 0.0f) {
                        return 0.0f;
                    }
                    float position = input;
                    if (position == TextTrackStyle.DEFAULT_FONT_SCALE) {
                        return TextTrackStyle.DEFAULT_FONT_SCALE;
                    }
                    return (((float) Math.pow(2.0d, (double) (-10.0f * position))) * ((float) Math.sin((((double) (position - ((0.3f / 6.2831855f) * ((float) Math.asin(1.0d))))) * 6.283185307179586d) / ((double) 1050253722)))) + TextTrackStyle.DEFAULT_FONT_SCALE;
                }
            };
            EaseInOutElastic = new EasingFunction() {
                public float getInterpolation(float input) {
                    if (input == 0.0f) {
                        return 0.0f;
                    }
                    float position = input / 0.5f;
                    if (position == ImageRequest.DEFAULT_IMAGE_BACKOFF_MULT) {
                        return TextTrackStyle.DEFAULT_FONT_SCALE;
                    }
                    float s = (0.45000002f / 6.2831855f) * ((float) Math.asin(1.0d));
                    if (position < TextTrackStyle.DEFAULT_FONT_SCALE) {
                        position -= TextTrackStyle.DEFAULT_FONT_SCALE;
                        return -0.5f * (((float) Math.sin((((double) ((TextTrackStyle.DEFAULT_FONT_SCALE * position) - s)) * 6.283185307179586d) / ((double) 1055286887))) * ((float) Math.pow(2.0d, (double) (10.0f * position))));
                    }
                    position -= TextTrackStyle.DEFAULT_FONT_SCALE;
                    return ((((float) Math.pow(2.0d, (double) (-10.0f * position))) * ((float) Math.sin((((double) ((position * TextTrackStyle.DEFAULT_FONT_SCALE) - s)) * 6.283185307179586d) / ((double) 1055286887)))) * 0.5f) + TextTrackStyle.DEFAULT_FONT_SCALE;
                }
            };
            EaseInBack = new EasingFunction() {
                public float getInterpolation(float input) {
                    float position = input;
                    return (position * position) * ((2.70158f * position) - 1.70158f);
                }
            };
            EaseOutBack = new EasingFunction() {
                public float getInterpolation(float input) {
                    float position = input - TextTrackStyle.DEFAULT_FONT_SCALE;
                    return ((position * position) * ((2.70158f * position) + 1.70158f)) + TextTrackStyle.DEFAULT_FONT_SCALE;
                }
            };
            EaseInOutBack = new EasingFunction() {
                public float getInterpolation(float input) {
                    float position = input / 0.5f;
                    if (position < TextTrackStyle.DEFAULT_FONT_SCALE) {
                        float s = 1.70158f * 1.525f;
                        return ((position * position) * (((TextTrackStyle.DEFAULT_FONT_SCALE + s) * position) - s)) * 0.5f;
                    }
                    position -= ImageRequest.DEFAULT_IMAGE_BACKOFF_MULT;
                    s = 1.70158f * 1.525f;
                    return (((position * position) * (((TextTrackStyle.DEFAULT_FONT_SCALE + s) * position) + s)) + ImageRequest.DEFAULT_IMAGE_BACKOFF_MULT) * 0.5f;
                }
            };
            EaseInBounce = new EasingFunction() {
                public float getInterpolation(float input) {
                    return TextTrackStyle.DEFAULT_FONT_SCALE - EasingFunctions.EaseOutBounce.getInterpolation(TextTrackStyle.DEFAULT_FONT_SCALE - input);
                }
            };
            EaseOutBounce = new EasingFunction() {
                public float getInterpolation(float input) {
                    float position = input;
                    if (position < 0.36363637f) {
                        return (7.5625f * position) * position;
                    }
                    if (position < 0.72727275f) {
                        position -= 0.54545456f;
                        return ((7.5625f * position) * position) + 0.75f;
                    } else if (position < 0.90909094f) {
                        position -= 0.8181818f;
                        return ((7.5625f * position) * position) + 0.9375f;
                    } else {
                        position -= 0.95454544f;
                        return ((7.5625f * position) * position) + 0.984375f;
                    }
                }
            };
            EaseInOutBounce = new EasingFunction() {
                public float getInterpolation(float input) {
                    if (input < 0.5f) {
                        return EasingFunctions.EaseInBounce.getInterpolation(ImageRequest.DEFAULT_IMAGE_BACKOFF_MULT * input) * 0.5f;
                    }
                    return (EasingFunctions.EaseOutBounce.getInterpolation((ImageRequest.DEFAULT_IMAGE_BACKOFF_MULT * input) - TextTrackStyle.DEFAULT_FONT_SCALE) * 0.5f) + 0.5f;
                }
            };
        }
    }

    public enum EasingOption {
        Linear,
        EaseInQuad,
        EaseOutQuad,
        EaseInOutQuad,
        EaseInCubic,
        EaseOutCubic,
        EaseInOutCubic,
        EaseInQuart,
        EaseOutQuart,
        EaseInOutQuart,
        EaseInSine,
        EaseOutSine,
        EaseInOutSine,
        EaseInExpo,
        EaseOutExpo,
        EaseInOutExpo,
        EaseInCirc,
        EaseOutCirc,
        EaseInOutCirc,
        EaseInElastic,
        EaseOutElastic,
        EaseInOutElastic,
        EaseInBack,
        EaseOutBack,
        EaseInOutBack,
        EaseInBounce,
        EaseOutBounce,
        EaseInOutBounce
    }

    public static EasingFunction getEasingFunctionFromOption(EasingOption easing) {
        switch (C04541.f11xe0165a6e[easing.ordinal()]) {
            case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                return EasingFunctions.EaseInQuad;
            case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                return EasingFunctions.EaseOutQuad;
            case Dimension.UNIT_IN /*4*/:
                return EasingFunctions.EaseInOutQuad;
            case Dimension.UNIT_MM /*5*/:
                return EasingFunctions.EaseInCubic;
            case BuyButtonText.LOGO_ONLY /*6*/:
                return EasingFunctions.EaseOutCubic;
            case BuyButtonText.DONATE_WITH /*7*/:
                return EasingFunctions.EaseInOutCubic;
            case Requests.MAX_REQUEST_RECIPIENTS /*8*/:
                return EasingFunctions.EaseInQuart;
            case HTTP.HT /*9*/:
                return EasingFunctions.EaseOutQuart;
            case HTTP.LF /*10*/:
                return EasingFunctions.EaseInOutQuart;
            case ConnectionResult.LICENSE_CHECK_FAILED /*11*/:
                return EasingFunctions.EaseInSine;
            case C0473R.styleable.MapAttrs_uiZoomGestures /*12*/:
                return EasingFunctions.EaseOutSine;
            case HTTP.CR /*13*/:
                return EasingFunctions.EaseInOutSine;
            case GamesStatusCodes.STATUS_INTERRUPTED /*14*/:
                return EasingFunctions.EaseInExpo;
            case GamesStatusCodes.STATUS_TIMEOUT /*15*/:
                return EasingFunctions.EaseOutExpo;
            case Notifications.NOTIFICATION_TYPE_LEVEL_UP /*16*/:
                return EasingFunctions.EaseInOutExpo;
            case ConnectionResult.SIGN_IN_FAILED /*17*/:
                return EasingFunctions.EaseInCirc;
            case ConnectionResult.SERVICE_UPDATING /*18*/:
                return EasingFunctions.EaseOutCirc;
            case ConnectionResult.SERVICE_MISSING_PERMISSION /*19*/:
                return EasingFunctions.EaseInOutCirc;
            case ConnectionResult.RESTRICTED_PROFILE /*20*/:
                return EasingFunctions.EaseInElastic;
            case C0473R.styleable.MapAttrs_latLngBoundsNorthEastLatitude /*21*/:
                return EasingFunctions.EaseOutElastic;
            case C0473R.styleable.MapAttrs_latLngBoundsNorthEastLongitude /*22*/:
                return EasingFunctions.EaseInOutElastic;
            case C0308R.styleable.Toolbar_collapseContentDescription /*23*/:
                return EasingFunctions.EaseInBack;
            case C0308R.styleable.Toolbar_navigationIcon /*24*/:
                return EasingFunctions.EaseOutBack;
            case C0308R.styleable.Toolbar_navigationContentDescription /*25*/:
                return EasingFunctions.EaseInOutBack;
            case C0308R.styleable.Toolbar_logoDescription /*26*/:
                return EasingFunctions.EaseInBounce;
            case C0308R.styleable.Toolbar_titleTextColor /*27*/:
                return EasingFunctions.EaseOutBounce;
            case C0308R.styleable.Toolbar_subtitleTextColor /*28*/:
                return EasingFunctions.EaseInOutBounce;
            default:
                return EasingFunctions.Linear;
        }
    }
}

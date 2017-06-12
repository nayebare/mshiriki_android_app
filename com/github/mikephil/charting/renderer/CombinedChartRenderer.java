package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.charts.CombinedChart.DrawOrder;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.google.android.gms.wallet.fragment.WalletFragmentStyle.Dimension;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.MessageApi;
import java.util.ArrayList;
import java.util.List;

public class CombinedChartRenderer extends DataRenderer {
    protected List<DataRenderer> mRenderers;

    /* renamed from: com.github.mikephil.charting.renderer.CombinedChartRenderer.1 */
    static /* synthetic */ class C04691 {
        static final /* synthetic */ int[] f16x2dab6d3b;

        static {
            f16x2dab6d3b = new int[DrawOrder.values().length];
            try {
                f16x2dab6d3b[DrawOrder.BAR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f16x2dab6d3b[DrawOrder.BUBBLE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f16x2dab6d3b[DrawOrder.LINE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f16x2dab6d3b[DrawOrder.CANDLE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f16x2dab6d3b[DrawOrder.SCATTER.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public CombinedChartRenderer(CombinedChart chart, ChartAnimator animator, ViewPortHandler viewPortHandler) {
        super(animator, viewPortHandler);
        createRenderers(chart, animator, viewPortHandler);
    }

    protected void createRenderers(CombinedChart chart, ChartAnimator animator, ViewPortHandler viewPortHandler) {
        this.mRenderers = new ArrayList();
        for (DrawOrder order : chart.getDrawOrder()) {
            switch (C04691.f16x2dab6d3b[order.ordinal()]) {
                case MessageApi.FILTER_PREFIX /*1*/:
                    if (chart.getBarData() == null) {
                        break;
                    }
                    this.mRenderers.add(new BarChartRenderer(chart, animator, viewPortHandler));
                    break;
                case ChannelListener.CLOSE_REASON_REMOTE_CLOSE /*2*/:
                    if (chart.getBubbleData() == null) {
                        break;
                    }
                    this.mRenderers.add(new BubbleChartRenderer(chart, animator, viewPortHandler));
                    break;
                case ChannelListener.CLOSE_REASON_LOCAL_CLOSE /*3*/:
                    if (chart.getLineData() == null) {
                        break;
                    }
                    this.mRenderers.add(new LineChartRenderer(chart, animator, viewPortHandler));
                    break;
                case Dimension.UNIT_IN /*4*/:
                    if (chart.getCandleData() == null) {
                        break;
                    }
                    this.mRenderers.add(new CandleStickChartRenderer(chart, animator, viewPortHandler));
                    break;
                case Dimension.UNIT_MM /*5*/:
                    if (chart.getScatterData() == null) {
                        break;
                    }
                    this.mRenderers.add(new ScatterChartRenderer(chart, animator, viewPortHandler));
                    break;
                default:
                    break;
            }
        }
    }

    public void initBuffers() {
        for (DataRenderer renderer : this.mRenderers) {
            renderer.initBuffers();
        }
    }

    public void drawData(Canvas c) {
        for (DataRenderer renderer : this.mRenderers) {
            renderer.drawData(c);
        }
    }

    public void drawValues(Canvas c) {
        for (DataRenderer renderer : this.mRenderers) {
            renderer.drawValues(c);
        }
    }

    public void drawExtras(Canvas c) {
        for (DataRenderer renderer : this.mRenderers) {
            renderer.drawExtras(c);
        }
    }

    public void drawHighlighted(Canvas c, Highlight[] indices) {
        for (DataRenderer renderer : this.mRenderers) {
            renderer.drawHighlighted(c, indices);
        }
    }

    public void calcXBounds(BarLineScatterCandleBubbleDataProvider chart, int xAxisModulus) {
        for (DataRenderer renderer : this.mRenderers) {
            renderer.calcXBounds(chart, xAxisModulus);
        }
    }

    public DataRenderer getSubRenderer(int index) {
        if (index >= this.mRenderers.size() || index < 0) {
            return null;
        }
        return (DataRenderer) this.mRenderers.get(index);
    }

    public List<DataRenderer> getSubRenderers() {
        return this.mRenderers;
    }

    public void setSubRenderers(List<DataRenderer> renderers) {
        this.mRenderers = renderers;
    }
}

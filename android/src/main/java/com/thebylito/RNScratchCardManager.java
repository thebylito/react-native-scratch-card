package com.thebylito;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.clock.scratch.ScratchView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

public class RNScratchCardManager extends ViewGroupManager<FrameLayout> {
    private ThemedReactContext mContext = null;
    private Activity mActivity = null;

    public static final String REACT_CLASS = "RNScratchCardManager";
    ScratchView scratchView;

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public FrameLayout createViewInstance(ThemedReactContext reactContext) {
        mContext = reactContext;
        mActivity = mContext.getCurrentActivity();
        scratchView = new ScratchView(mContext);
        scratchView.setEraseStatusListener(new ScratchView.EraseStatusListener() {
            @Override
            public void onProgress(int percent) {
                emitPan(percent);
            }

            @Override
            public void onCompleted(View view) {
                Log.d("ACABOUUUUU", "ACABOU");
            }
        });
        FrameLayout relativeLayout = new FrameLayout(mContext);
        RelativeLayout.LayoutParams lP = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        scratchView.setLayoutParams(lP);
        relativeLayout.addView(scratchView);
        return relativeLayout;
    }

    @ReactProp(name = "color")
    public void setColor(FrameLayout view, String color) {
        scratchView.setMaskColor(Color.parseColor(color));
    }

    @ReactProp(name = "maxPercent")
    public void setMaxPercent(FrameLayout view, Integer percent) {
        scratchView.setMaxPercent(percent);
    }

    private void emitPan(Integer valor) {
        WritableMap args = Arguments.createMap();
        args.putInt("value", valor);
        ReactContext reactContext = mContext;
        reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit("percentEv", args);
    }
}
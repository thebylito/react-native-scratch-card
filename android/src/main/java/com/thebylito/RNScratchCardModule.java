
package com.thebylito;

import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class RNScratchCardModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNScratchCardModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNScratchCard";
  }

  @ReactMethod
  public void acao(){
    Log.d("RNNA", "OLAAAAA");
  }

}
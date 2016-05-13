package com.cube.rn.cardview;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by tim on 23/03/2016.
 */
public class RNCardViewPackage implements ReactPackage
{
	@Override
	public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext)
	{
		return Collections.emptyList();
	}

	@Override
	public List<Class<? extends JavaScriptModule>> createJSModules()
	{
		return Collections.emptyList();
	}

	@Override
	public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext)
	{
		return Arrays.<ViewManager>asList(new RNCardViewManager());
	}
}

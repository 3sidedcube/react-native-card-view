package com.cube.rn.cardview;

import android.graphics.Color;

import com.facebook.csslayout.CSSConstants;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;

/**
 * Created by tim on 13/05/2016.
 */
public class RNCardViewManager extends ViewGroupManager<ReactCardView>
{
	public static final String REACT_CLASS = "RNCardView";
	private static final String PROP_ELEVATION = "elevation";

	@Override
	public String getName()
	{
		return REACT_CLASS;
	}

	@Override
	protected ReactCardView createViewInstance(ThemedReactContext reactContext)
	{
		return new ReactCardView(reactContext);
	}

	@Override
	@ReactProp(name = ViewProps.BACKGROUND_COLOR,
	           defaultInt = Color.WHITE,
	           customType = "Color")
	public void setBackgroundColor(ReactCardView view, int backgroundColor)
	{
		view.setCardBackgroundColor(backgroundColor);
	}

	@ReactProp(name = ViewProps.BORDER_RADIUS,
	           defaultFloat = CSSConstants.UNDEFINED)
	public void setBorderRadius(ReactCardView view, float borderRadius)
	{
		if (!CSSConstants.isUndefined(borderRadius))
		{
			view.setRadius(PixelUtil.toPixelFromDIP(borderRadius));
		}
	}

	@Override
	@ReactProp(name = PROP_ELEVATION,
	           defaultFloat = CSSConstants.UNDEFINED)
	public void setElevation(ReactCardView view, float elevation)
	{
		if (!CSSConstants.isUndefined(elevation))
		{
			view.setCardElevation(PixelUtil.toPixelFromDIP(elevation));
		}
	}

	@ReactPropGroup(names = {ViewProps.PADDING, ViewProps.PADDING_HORIZONTAL, ViewProps.PADDING_VERTICAL, ViewProps.PADDING_TOP, ViewProps.PADDING_BOTTOM,
	                         ViewProps.PADDING_LEFT, ViewProps.PADDING_RIGHT}, defaultFloat = CSSConstants.UNDEFINED)
	public void setPadding(ReactCardView view, int index, float padding)
	{
		int paddingPx = (int) PixelUtil.toPixelFromDIP(padding);

		int paddingTop = view.getContentPaddingTop();
		int paddingBottom = view.getContentPaddingBottom();
		int paddingLeft = view.getContentPaddingLeft();
		int paddingRight = view.getContentPaddingRight();

		switch (index)
		{
			case 0:
			{
				paddingTop = paddingPx;
				paddingBottom = paddingPx;
				paddingLeft = paddingPx;
				paddingRight = paddingPx;
				break;
			}
			case 1:
			{
				paddingLeft = paddingPx / 2;
				paddingRight = paddingLeft;
				break;
			}
			case 2:
			{
				paddingTop = paddingPx / 2;
				paddingBottom = paddingTop;
				break;
			}
			case 3:
			{
				paddingTop = paddingPx;
				break;
			}
			case 4:
			{
				paddingBottom = paddingPx;
				break;
			}
			case 5:
			{
				paddingLeft = paddingPx;
				break;
			}
			case 6:
			{
				paddingRight = paddingPx;
				break;
			}
		}

		view.setContentPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
	}
}

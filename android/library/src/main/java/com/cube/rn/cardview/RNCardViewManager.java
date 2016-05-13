package com.cube.rn.cardview;

import android.graphics.Color;
import android.support.v7.widget.CardView;

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
public class RNCardViewManager extends ViewGroupManager<CardView>
{
	public static final String REACT_CLASS = "RNCardView";
	private static final String PROP_BACKGROUND_COLOR = ViewProps.BACKGROUND_COLOR;
	private static final String PROP_ELEVATION = "elevation";
	private static final String PROP_CORNER_RADIUS = "cornerRadius";

	@Override
	public String getName()
	{
		return REACT_CLASS;
	}

	@Override
	protected CardView createViewInstance(ThemedReactContext reactContext)
	{
		return new CardView(reactContext);
	}

	@Override
	@ReactProp(name = ViewProps.BACKGROUND_COLOR,
	           defaultInt = Color.WHITE,
	           customType = "Color")
	public void setBackgroundColor(CardView view, int backgroundColor)
	{
		view.setCardBackgroundColor(backgroundColor);
	}

	@ReactProp(name = ViewProps.BORDER_RADIUS,
	           defaultFloat = CSSConstants.UNDEFINED)
	public void setBorderRadius(CardView view, float borderRadius)
	{
		if (!CSSConstants.isUndefined(borderRadius))
		{
			view.setRadius(PixelUtil.toPixelFromDIP(borderRadius));
		}
	}

	@Override
	@ReactProp(name = PROP_ELEVATION,
	           defaultFloat = CSSConstants.UNDEFINED)
	public void setElevation(CardView view, float elevation)
	{
		if (!CSSConstants.isUndefined(elevation))
		{
			view.setCardElevation(PixelUtil.toPixelFromDIP(elevation));
		}
	}

	@ReactPropGroup(names = {ViewProps.PADDING, ViewProps.PADDING_HORIZONTAL, ViewProps.PADDING_VERTICAL, ViewProps.PADDING_TOP, ViewProps.PADDING_BOTTOM,
	                         ViewProps.PADDING_LEFT, ViewProps.PADDING_RIGHT}, defaultFloat = CSSConstants.UNDEFINED)
	public void setPadding(CardView view, int index, float padding)
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

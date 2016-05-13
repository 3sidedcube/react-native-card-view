package com.cube.rn.cardview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.CardView;

import com.facebook.react.uimanager.MeasureSpecAssertions;

/**
 * Created by tim on 13/05/2016.
 */
public class ReactCardView extends CardView
{
	public ReactCardView(Context context)
	{
		super(context);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		MeasureSpecAssertions.assertExplicitMeasureSpec(widthMeasureSpec, heightMeasureSpec);

		setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.getSize(heightMeasureSpec));
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom)
	{
		// No-op since UIManagerModule handles actually laying out children.
	}

	@SuppressLint("MissingSuperCall")
	@Override
	public void requestLayout()
	{
		// No-op, terminate `requestLayout` here, UIManagerModule handles laying out children and
		// `layout` is called on all RN-managed views by `NativeViewHierarchyManager`
	}
}

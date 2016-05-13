"use strict";
import React, {PropTypes} from "react";
import {Platform, StyleSheet, View} from "react-native";
const requireNativeComponent = require("requireNativeComponent");

const Card = React.createClass({

	propTypes: {
		class: React.PropTypes.oneOf(["default", "transparent"]),
		...View.propTypes
	},

	getDefaultProps() {
		return {
			class: "default",
			style: {}
		};
	},

	render() {
		// TODO: Remove the following code when styles are implemented from content
		let defaultStyles = styles[this.props.class];

		let overrideStyles = {}
		if (this.props.backgroundColour) {
			overrideStyles["backgroundColor"] = this.props.backgroundColour;
		}

		if (this.props.topShadowColour) {
			overrideStyles["borderTopWidth"] = 1.0
			overrideStyles["borderTopColor"] = this.props.topShadowColour;
		}

		if (this.props.bottomShadowColour) {
			overrideStyles["borderBottomWidth"] = 1.0
			overrideStyles["borderBottomColor"] = this.props.bottomShadowColour;
		}

		if (this.props.paddingVertical || this.props.paddingVertical === 0) {
			overrideStyles["paddingVertical"] = this.props.paddingVertical;
		}

		if (this.props.paddingHorizontal || this.props.paddingHorizontal === 0) {
			overrideStyles["paddingHorizontal"] = this.props.paddingHorizontal;
		}

		if (Platform.OS === "android") {
			return (
				<AndroidCardView
					style={[styles.container, defaultStyles, this.props.style, overrideStyles]}
				>
					{this.props.children}
				</AndroidCardView>
			);
		}

		return (
			<View style={[styles.container, defaultStyles, this.props.style, overrideStyles]}>
				{this.props.children}
			</View>
		);
	}
});

const styles = StyleSheet.create({

	container: {
		flex: 1,
		paddingVertical: 16,
		paddingHorizontal: 16
	},

	default: {
		borderBottomWidth: 1,
		borderBottomColor: "#d2d2d2",
		backgroundColor: "#fff"
	},

	transparent: {}
});

const AndroidCardView = requireNativeComponent("RNCardView", {
	name: "RNCardView",
	propTypes: {
		...View.propTypes
	},
});

export default Card;

"use strict";
import React, {Component} from "react";
import {StyleSheet, View} from "react-native";

const Card = React.createClass({

	propTypes: {
		...View.propTypes,
		elevation: React.PropTypes.number,
		backgroundColour: React.PropTypes.string,
		bottomShadowColour: React.PropTypes.string,
		topShadowColour: React.PropTypes.string,
		class: React.PropTypes.oneOf(["default", "transparent"]),
		paddingVertical: React.PropTypes.number,
		paddingHorizontal: React.PropTypes.number
	},

	getDefaultProps() {
		return {
			elevation: 0,
			class: "default"
		};
	},

	render() {
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

		return (
			<View elevation={Number(this.props.elevation)} style={[styles.container, defaultStyles, this.props.style, overrideStyles]}>
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

export default Card;

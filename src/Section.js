"use strict";
import React, {Component} from "react";
import {StyleSheet, View, Text} from "react-native";
import Card from "./Card";

const Section = React.createClass({

	propTypes: {
		...Card.propTypes,
		header: React.PropTypes.string,
		footer: React.PropTypes.string
	},

	render() {

		let HeaderComponent;
		let FooterComponent;
		if (this.props.header) {
			HeaderComponent = (
				<Text style={styles.header}> {this.props.header} </Text>
			);
		}

		if (this.props.footer) {
			FooterComponent = (
				<Text style={styles.footer}> {this.props.footer} </Text>
			);
		}

		return (
			<View style={[styles.container, this.props.style]}>
				{HeaderComponent}
				<Card {...this.props}>
					{this.props.children}
				</Card>
				{FooterComponent}
			</View>
		);
	}
});

const styles = StyleSheet.create({

	container: {
		flex: 1,
		paddingVertical: 16,
	},

	header: {
		flex: 1,
		paddingBottom: 6,
		paddingHorizontal: 15,
		color: '#6D6D72',
		fontSize: 13
	},

	footer: {
		flex: 1,
		paddingTop: 6,
		paddingHorizontal: 15,
		color: '#6D6D72',
		fontSize: 13
	}
});

export default Section;

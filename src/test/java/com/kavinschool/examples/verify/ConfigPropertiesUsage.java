package com.kavinschool.examples.verify;

import org.aeonbits.owner.ConfigFactory;

import com.kavinschool.examples.props.ServerProperties;

public class ConfigPropertiesUsage {
	public static void main(String[] args) {
		ServerProperties serverProps = ConfigFactory.create(ServerProperties.class);
		System.out.println("Base Url=" + serverProps.baseUrl());
		System.out.println("Chrome Driver Path=" + serverProps.chromeDriverBinary());
	}
}

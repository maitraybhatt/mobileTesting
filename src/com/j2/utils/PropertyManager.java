package com.j2.utils;

import org.apache.log4j.Logger;

public class PropertyManager {
	static Logger log = Logger.getLogger(PropertyManager.class.getName());

	/**
	 * Thread Safe Properties Object
	 * 
	 */

	private static ThreadLocal<Property> Properties = new ThreadLocal<Property>() {
		protected Property initialValue() {
			Property p = new Property(System.getProperty("base.property.file",
					"resources/base.properties"));
			return p;
		};
	};

	/**
	 * Resource Bundler Object
	 * 
	 * @return Property
	 * 
	 */

	public static Property getResourceBundle() {
		return Properties.get();
	}
}
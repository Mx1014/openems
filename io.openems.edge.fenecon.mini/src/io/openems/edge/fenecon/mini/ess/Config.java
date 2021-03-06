package io.openems.edge.fenecon.mini.ess;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

import io.openems.edge.ess.api.Phase;

@ObjectClassDefinition( //
		name = "FENECON Mini ESS", //
		description = "The energy storage system implementation of a FENECON Mini.")
@interface Config {

	String id() default "ess0";

	boolean enabled() default true;

	@AttributeDefinition(name = "Phase", description = "On which Phase is the Mini connected?")
	Phase Phase() default Phase.L1;

	@AttributeDefinition(name = "Modbus-ID", description = "ID of Modbus bridge.")
	String modbus_id();

	@AttributeDefinition(name = "Modbus target filter", description = "This is auto-generated by 'Modbus-ID'.")
	String Modbus_target() default "";

	String webconsole_configurationFactory_nameHint() default "FENECON Mini ESS [{id}]";
}
package io.openems.backend.openemswebsocket.session;

import com.google.gson.JsonObject;

import io.openems.backend.metadata.api.device.MetadataDevice;
import io.openems.common.session.SessionData;

public class OpenemsSessionData extends SessionData {
	private final MetadataDevice device;

	public OpenemsSessionData(MetadataDevice device) {
		this.device = device;
	}

	public MetadataDevice getDevice() {
		return device;
	}

	@Override
	public JsonObject toJsonObject() {
		return this.device.toJsonObject();
	}
}

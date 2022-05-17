package com.github.startsmercury.simply.no.shading.config;

import java.io.IOException;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class SimplyNoShadingFabricClientConfig extends SimplyNoShadingClientConfig {
	public final ShadingRule enhancedBlockEntityShading = new ShadingRule.Impl(true);

	@Override
	public void read(final JsonReader in) throws IOException {
		do {
			final var shadingRule = switch (in.nextName()) {
			case "allShading" -> this.allShading;
			case "blockShading" -> this.blockShading;
			case "cloudShading" -> this.cloudShading;
			case "enhancedBlockEntityShading" -> this.enhancedBlockEntityShading;
			default -> ShadingRule.Root.DUMMY;
			};

			shadingRule.read(in);
		} while (in.peek() != JsonToken.END_OBJECT);
	}

	@Override
	public void write(final JsonWriter out) throws IOException {
		// @formatter:off
		out.name("allShading"); this.allShading.write(out);
		out.name("blockShading"); this.blockShading.write(out);
		out.name("cloudShading"); this.cloudShading.write(out);
		out.name("enhancedBlockEntityShading"); this.enhancedBlockEntityShading.write(out);
		// @formatter:on
	}
}

package dream.first.core.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dream.first.base.gson.DreamFirstGsonSupplier;

/**
 * @see DreamFirstGsonSupplier
 */
public final class GsonSupplier {

	private GsonSupplier() {
	}

	public static Gson getDefaultGson() {
		return DreamFirstGsonSupplier.getDefaultGson();
	}

	public synchronized static void setDefaultGson(Gson defaultGson) {
		DreamFirstGsonSupplier.setDefaultGson(defaultGson);
	}

	public static Gson createGson() {
		return DreamFirstGsonSupplier.createGson();
	}

	public static GsonBuilder getDefaultGsonBuilder() {
		return DreamFirstGsonSupplier.getDefaultGsonBuilder();
	}

	public static void setDefaultGsonBuilder(GsonBuilder defaultGsonBuilder) {
		DreamFirstGsonSupplier.setDefaultGsonBuilder(defaultGsonBuilder);
	}

	public static GsonBuilder createGsonBuilder() {
		return DreamFirstGsonSupplier.createGsonBuilder();
	}

}

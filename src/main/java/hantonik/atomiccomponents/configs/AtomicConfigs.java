package hantonik.atomiccomponents.configs;

import hantonik.atomiccomponents.AtomicComponents;
import hantonik.atomiccore.utils.helpers.ConfigHelper;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.loading.FMLPaths;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class AtomicConfigs {
    public static final ForgeConfigSpec CLIENT_SETTINGS;
    public static final ForgeConfigSpec COMMON_SETTINGS;

    public static final ForgeConfigSpec.BooleanValue ENABLE_DEFAULT_RECIPES;

    // CLIENT CONFIG
    static {
        final ForgeConfigSpec.Builder client = new ForgeConfigSpec.Builder();

        client.push("ClientSettings"); {
        } client.pop();

        CLIENT_SETTINGS = client.build();
    }

    // COMMON CONFIG
    static {
        final ForgeConfigSpec.Builder common = new ForgeConfigSpec.Builder();

        common.push("CommonSettings"); {
            ENABLE_DEFAULT_RECIPES = common
                    .comment("Enable default recipes.")
                    .translation("enable_default_recipes")
                    .define("enableDefaultRecipes", true);
        } common.pop();

        COMMON_SETTINGS = common.build();
    }

    public static void setup() {
        try {
            Files.createDirectory(Paths.get(FMLPaths.CONFIGDIR.get().toAbsolutePath().toString(), AtomicComponents.MOD_ID));
        } catch (FileAlreadyExistsException e) {
            AtomicComponents.LOGGER.warn(AtomicComponents.CONFIG_MARKER, AtomicComponents.MOD_NAME + " config directory already exists.");
        } catch (IOException e) {
            AtomicComponents.LOGGER.error(AtomicComponents.CONFIG_MARKER, "Failed to create " + AtomicComponents.MOD_NAME + " config directory.", e);
        }

        ConfigHelper.load(CLIENT_SETTINGS, AtomicComponents.MOD_ID + "/client-config.toml");
        ConfigHelper.load(COMMON_SETTINGS, AtomicComponents.MOD_ID + "/common-config.toml");
    }
}

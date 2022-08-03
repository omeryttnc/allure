package Tests;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import utilities.DeleteFile;

import static org.junit.jupiter.api.extension.ExtensionContext.Namespace.GLOBAL;

public class YourExtension implements BeforeAllCallback, ExtensionContext.Store.CloseableResource {
    private static final String FILE_DIRECTORY = "target\\Screenshots";
    private static final String FILE_EXTENSION = ".png";
    private static boolean started = false;

    @Override
    public void beforeAll(ExtensionContext context) {
        if (!started) {
            started = true;

                new DeleteFile().deleteFile(FILE_DIRECTORY, FILE_EXTENSION);

            // Your "before all tests" startup logic goes here
            // The following line registers a callback hook when the root test context is shut down
            context.getRoot().getStore(GLOBAL).put("any unique name", this);
        }
    }

    @Override
    public void close() {
        // Your "after all tests" logic goes here
    }
}
package helpers;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import io.qameta.allure.Allure;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

/**
 * Minimal TestWatcher that adds a simple text attachment on failure/success/finish.
 * This works when JUnit @Rule fields are honored by the runner.
 */
public class AllureJUnit4Rule extends TestWatcher {

    @Override
    protected void failed(Throwable e, Description description) {
        String name = description.getClassName() + "#" + description.getMethodName();
        String msg = "Test failed: " + name + "\n" + e.toString();
        Allure.addAttachment("Failure - " + name, "text/plain", new ByteArrayInputStream(msg.getBytes(StandardCharsets.UTF_8)), ".txt");
    }

    @Override
    protected void succeeded(Description description) {
        String name = description.getClassName() + "#" + description.getMethodName();
        String msg = "Test passed: " + name;
        Allure.addAttachment("Success - " + name, "text/plain", new ByteArrayInputStream(msg.getBytes(StandardCharsets.UTF_8)), ".txt");
    }

    @Override
    protected void finished(Description description) {
        String name = description.getClassName() + "#" + description.getMethodName();
        String msg = "Finished: " + name;
        Allure.addAttachment("Finished - " + name, "text/plain", new ByteArrayInputStream(msg.getBytes(StandardCharsets.UTF_8)), ".txt");
    }
}


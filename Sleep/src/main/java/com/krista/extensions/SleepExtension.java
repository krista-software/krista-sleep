package com.krista.extensions;

import app.krista.extension.executor.Invoker;
import app.krista.extension.impl.anno.Extension;
import app.krista.extension.impl.anno.InvokerRequest;
import app.krista.extension.impl.anno.Java;
import app.krista.extension.impl.anno.StaticResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.Map;
@Java(version = Java.Version.JAVA_21)
@Extension(name = "Sleep", version = "1.0.2", jaxrsId = "sleep")
@StaticResource(path = "docs", file = "documentations")
@SuppressWarnings("unused")
public final class SleepExtension {
    private static final Logger log = LoggerFactory.getLogger(SleepExtension.class);


    @Inject
    public SleepExtension() {
        log.info("SleepExtension created");
    }

    @InvokerRequest(InvokerRequest.Type.VALIDATE_ATTRIBUTES)
    public void validateAttributes(Map<String, Object> attributes) {
        log.info("validateAttributes(): not implemented");
    }
    @InvokerRequest(InvokerRequest.Type.CUSTOM_TABS)
    public Map<String, String> customTabs() {
        return Map.of("Documentation", "static/docs");
    }

    @InvokerRequest(InvokerRequest.Type.INVOKER_LOADED)
    public void onInvokerLoad() {
        log.info("onInvokerLoad(): not implemented");
    }

    @InvokerRequest(InvokerRequest.Type.INVOKER_UNLOADED)
    public void onInvokerUnload() {
        log.info("onInvokerUnload(): not implemented");
    }
}

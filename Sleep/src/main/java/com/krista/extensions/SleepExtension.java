/*
 * Sleep Extension for Krista
 * Copyright (C) 2025 Krista Software
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

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

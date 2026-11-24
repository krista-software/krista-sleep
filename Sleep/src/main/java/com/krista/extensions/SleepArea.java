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

import app.krista.extension.impl.anno.CatalogRequest;
import app.krista.extension.impl.anno.*;
import com.krista.extensions.service.SleepService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

@Domain(id = "catEntryDomain_439009dc-8308-4c72-bb8f-a0bcdddef912",
        name = "Conversation Authoring",
        ecosystemId = "catEntryEcosystem_84b53163-327b-4b1b-8c96-9334d292f9f5",
        ecosystemName = "Essentials",
        ecosystemVersion = "b743b501-e0f9-4a8e-b9d0-6c303c88dcee")
public class SleepArea {

    private final SleepService sleepService;

    @Inject
    public SleepArea(SleepService sleepService) {
        this.sleepService = sleepService;
    }

    @CatalogRequest(
            id = "localDomainRequest_cc46e9d1-35cf-4f69-8b2f-006706ec02f3",
            name = "Conversation Sleep",
            description = "Pause a conversation for the specified number of seconds",
            area = "Sleep",
            type = CatalogRequest.Type.CHANGE_SYSTEM)
    public void conversationSleep(
            @Field(name = "Seconds to Sleep", type = "Number", required = true, attributes = {@Attribute(name = "visualWidth", value = "S")}, options = {}) Double secondsToSleep) {
        sleepService.sleep(secondsToSleep);
    }
}

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.nifi.util;

import org.apache.nifi.controller.ControllerService;
import org.apache.nifi.controller.ControllerServiceInitializationContext;
import org.apache.nifi.controller.ControllerServiceLookup;
import org.apache.nifi.logging.ComponentLog;

public class MockControllerServiceInitializationContext extends MockControllerServiceLookup implements ControllerServiceInitializationContext, ControllerServiceLookup {

    private final String identifier;
    private final ComponentLog logger;

    public MockControllerServiceInitializationContext(final ControllerService controllerService, final String identifier) {
        this(controllerService, identifier, new MockProcessorLog(identifier, controllerService));
    }

    public MockControllerServiceInitializationContext(final ControllerService controllerService, final String identifier, final ComponentLog logger) {
        this.identifier = identifier;
        this.logger = logger;
        addControllerService(controllerService, identifier);
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String getControllerServiceName(final String serviceIdentifier) {
        return null;
    }

    @Override
    public ControllerServiceLookup getControllerServiceLookup() {
        return this;
    }

    @Override
    public ComponentLog getLogger() {
        return logger;
    }
}

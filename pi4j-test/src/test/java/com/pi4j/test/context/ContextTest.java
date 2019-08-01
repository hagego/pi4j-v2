package com.pi4j.test.context;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: UNITTEST :: Unit/Integration Tests
 * FILENAME      :  ContextTest.java
 *
 * This file is part of the Pi4J project. More information about
 * this project can be found here:  https://pi4j.com/
 * **********************************************************************
 * %%
 * Copyright (C) 2012 - 2019 Pi4J
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.exception.Pi4JException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class ContextTest {

    private Context pi4j;

    @Before
    public void beforeTest() throws Pi4JException {
        // initialize Pi4J with a default context
        // A default context includes AUTO-DETECT BINDINGS enabled
        // which will load all detected Pi4J binding libraries
        // in the class path for this test case
        pi4j = Pi4J.newDefaultContext();
    }

    @After
    public void afterTest() {
        try {
            pi4j.shutdown();
        } catch (Pi4JException e) { /* do nothing */ }
    }

    @Test
    public void testFactoryContextAcquisition() throws Pi4JException {
        assertNotNull(pi4j);
        System.out.println("-------------------------------------------------");
        System.out.println("Pi4J CONTEXT <acquired via factory accessor>");
        System.out.println("-------------------------------------------------");
        pi4j.describe().print(System.out);
    }
}

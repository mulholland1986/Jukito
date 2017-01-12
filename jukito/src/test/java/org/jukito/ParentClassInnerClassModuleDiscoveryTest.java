/*
 * Copyright 2017 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package org.jukito;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Test which ensures that nested TestModules in parent classes are discovered by the JukitoRunner.
 */
@RunWith(JukitoRunner.class)
public class ParentClassInnerClassModuleDiscoveryTest extends SampleParentTestClassWithInnerTestModule {

    private static final AtomicInteger numberOfTestRuns = new AtomicInteger(0);

    @AfterClass
    public static void afterClass() throws Exception {
        Assert.assertEquals(2, numberOfTestRuns.get());
    }

    @Test
    public void testSomething(@All final String bindingsFromParent) throws Exception {
        numberOfTestRuns.incrementAndGet();
    }
}

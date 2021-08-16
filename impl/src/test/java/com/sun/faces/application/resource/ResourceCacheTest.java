/*
 * Copyright (c) 2017, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package com.sun.faces.application.resource;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ResourceCacheTest {

    @Test
    public void noMemoryLeakWithContracts() {
        ResourceCache cache = new ResourceCache(-1L);
        ResourceInfo resourceInfo = new ResourceInfo(new ContractInfo("foo"), "bar.gif", null, null);
        List<String> contracts = new ArrayList<>(Arrays.asList("foo", "baz"));
        cache.add(resourceInfo, contracts);
        // now we clear the contracts list, which was used to create the cache entry.
        contracts.clear();
        ResourceInfo cachedResourceInfo = cache.get("bar.gif", null, null, Arrays.asList("foo", "baz"));
        assertThat(cachedResourceInfo, is(resourceInfo));
    }

}

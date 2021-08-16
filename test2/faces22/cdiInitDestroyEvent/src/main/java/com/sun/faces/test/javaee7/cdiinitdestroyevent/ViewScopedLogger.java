/*
 * Copyright (c) 1997, 2020 Oracle and/or its affiliates. All rights reserved.
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

package com.sun.faces.test.javaee7.cdiinitdestroyevent;

import static java.lang.System.currentTimeMillis;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.Destroyed;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.faces.component.UIViewRoot;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;

@Dependent
public class ViewScopedLogger {

    @Inject
    private UserBean userBean;

    public void observeViewScopedStart(@Observes @Initialized(ViewScoped.class) UIViewRoot root) {
        userBean.setInitViewScopeMesasge("" + currentTimeMillis());
    }

    public void observeViewScopedEnd(@Observes @Destroyed(ViewScoped.class) UIViewRoot root) {
        userBean.setDestroyViewScopeMessage("" + currentTimeMillis());
    }

}

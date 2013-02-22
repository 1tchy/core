/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.weld.bean.builtin;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;

import javax.enterprise.event.Event;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.InjectionPoint;

import org.jboss.weld.injection.ForwardingInjectionPoint;

/**
 * {@link InjectionPoint} that represents an injected {@link Event} or {@link Instance} object.
 *
 * @see CDI 1.1 5.5.7
 *
 * @author Jozef Hartinger
 *
 */
public class DynamicLookupInjectionPoint extends ForwardingInjectionPoint implements Serializable {

    private static final long serialVersionUID = -4102173765226078459L;

    private final InjectionPoint injectionPoint;
    private final Type type;
    private final Set<Annotation> qualifiers;

    public DynamicLookupInjectionPoint(InjectionPoint injectionPoint, Type type, Set<Annotation> qualifiers) {
        this.injectionPoint = injectionPoint;
        this.type = type;
        this.qualifiers = qualifiers;
    }

    @Override
    protected InjectionPoint delegate() {
        return injectionPoint;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public Set<Annotation> getQualifiers() {
        return qualifiers;
    }
}

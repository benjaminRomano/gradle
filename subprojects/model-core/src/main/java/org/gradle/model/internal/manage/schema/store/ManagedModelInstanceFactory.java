/*
 * Copyright 2014 the original author or authors.
 *
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
 */

package org.gradle.model.internal.manage.schema.store;

import net.jcip.annotations.ThreadSafe;
import org.gradle.internal.Factory;
import org.gradle.model.internal.manage.schema.ModelSchema;
import org.gradle.model.internal.manage.state.ManagedModelElement;

@ThreadSafe
public class ManagedModelInstanceFactory<T> implements Factory<T> {
    private final ModelSchema<T> modelSchema;

    public ManagedModelInstanceFactory(ModelSchema<T> modelSchema) {
        this.modelSchema = modelSchema;
    }

    public T create() {
        ManagedModelElement<T> managedModelElement = new ManagedModelElement<T>(modelSchema);
        return managedModelElement.createInstance();
    }
}

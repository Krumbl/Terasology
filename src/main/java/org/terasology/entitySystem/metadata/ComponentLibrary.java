/*
 * Copyright 2012 Benjamin Glatzel <benjamin.glatzel@me.com>
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
package org.terasology.entitySystem.metadata;

import org.terasology.entitySystem.Component;

/**
 * The library for metadata about components (and their fields).
 *
 * @author Immortius <immortius@gmail.com>
 */
public interface ComponentLibrary extends Iterable<ComponentMetadata> {

    /**
     * Registers a handler for a specific type.
     * <p/>
     * Type handlers are used when analysing a component class, and provide the functionality for serializing,
     * deserializing and cloning supported types
     *
     * @param forClass The type to support
     * @param handler  The handler for forClass
     * @param <T>
     */
    <T> void registerTypeHandler(Class<? extends T> forClass, TypeHandler<T> handler);

    /**
     * Registers a componentClass
     *
     * @param componentClass
     */
    <T extends Component> void registerComponentClass(Class<T> componentClass);

    /**
     * @param componentClass
     * @param <T>
     * @return The metadata for the given componentClass, or null if not registered.
     */
    <T extends Component> ComponentMetadata<T> getMetadata(Class<T> componentClass);

    <T extends Component> ComponentMetadata<? extends T> getMetadata(T component);

    /**
     * Copies a component
     *
     * @param component
     * @param <T>
     * @return A copy of the component, or null if not registered
     */
    <T extends Component> T copy(T component);

    /**
     * @param componentName
     * @return The metadata for the given component, or null if not registered.
     */
    ComponentMetadata<?> getMetadata(String componentName);

}

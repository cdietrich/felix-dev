/* 
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.felix.ipojo;

import java.util.Dictionary;

import org.apache.felix.ipojo.architecture.ComponentDescription;
import org.osgi.framework.BundleContext;

/**
 * The component instance class manages one instance of a component type.
 * @author <a href="mailto:felix-dev@incubator.apache.org">Felix Project Team</a>
 */
public interface ComponentInstance {

    /**
     * Component Instance State : STOPPED.
     * The component instance is not started.
     */
    int STOPPED = 0;
	
	/**
     * Component Instance State : INVALID.
     * The component is invalid when it start or when a component dependency is unvalid.
     */
    int INVALID = 1;

    /**
     * Component Instance State : VALID.
     * The component is resolved when it is running and all its component dependencies are valid.
     */
    int VALID = 2;

    /**
     * Start the component instance.
     */
    void start();

    /**
     * Stop the component instance.
     */
    void stop();

    /**
     * @return the actual state of the component instance.
     */
    int getState();

    /**
     * @return the component type information.
     * Each handler can participate to the component description.
     */
    ComponentDescription getComponentDescription();

    /**
     * @return the factory of the component instance.
     */
    ComponentFactory getFactory();
    
    /**
     * @return the context of the instance manager
     */
    BundleContext getContext();
    
    /**
     * @return the name of the component instance
     */
    String getInstanceName();
    
    /**
     * @return true if getState returns INVALID or VALID.
     */
    boolean isStarted();
    
    /**
     * Re-configurare an instance.
     * Do nothing if the instance does not support dynamic reconfiguration.
     * The reconfiguration does not stop the instance.
     * @param configuration : the new configuration.
     */
    void reconfigure(Dictionary configuration);


}

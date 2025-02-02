/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
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
package co.elastic.apm.agent.jdbc.helper;

import co.elastic.apm.agent.sdk.state.GlobalState;
import co.elastic.apm.agent.sdk.weakconcurrent.WeakConcurrent;
import co.elastic.apm.agent.sdk.weakconcurrent.WeakMap;

import java.sql.Connection;

@GlobalState
public class JdbcGlobalState {

    public static final WeakMap<Object, String> statementSqlMap = WeakConcurrent.buildMap();
    public static final WeakMap<Connection, ConnectionMetaData> metaDataMap = WeakConcurrent.buildMap();
    public static final WeakMap<Class<?>, Boolean> metadataSupported = WeakConcurrent.buildMap();
    public static final WeakMap<Class<?>, Boolean> connectionSupported = WeakConcurrent.buildMap();

    public static void clearInternalStorage() {
        metaDataMap.clear();
        metadataSupported.clear();
        connectionSupported.clear();
    }

}

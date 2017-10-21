package org.noggit;

/**
 *  Copyright 2006- Yonik Seeley
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.IOException;

/**
 * Use this class to push all entries of a Map into an output.
 * This avoids creating map instances and is supposed to be memory efficient.
 * If the entries are primitives, unnecessary boxing is also avoided
 */
public interface MapWriter  {



    void writeMap(EntryWriter ew) throws IOException;

    /**
     * An interface to push one entry at a time to the output
     */
    interface EntryWriter {

        /**
         * Writes a key value into the map
         *
         * @param k The key
         * @param v The value can be any supported object
         */
        EntryWriter put(String k, Object v) throws IOException;

        default EntryWriter putIfNotNull(String k, Object v) throws IOException {
            if(v != null) put(k,v);
            return this;
        }


        default EntryWriter put(String k, int v) throws IOException {
            put(k, (Integer) v);
            return this;
        }


        default EntryWriter put(String k, long v) throws IOException {
            put(k, (Long) v);
            return this;
        }


        default EntryWriter put(String k, float v) throws IOException {
            put(k, (Float) v);
            return this;
        }

        default EntryWriter put(String k, double v) throws IOException {
            put(k, (Double) v);
            return this;
        }

        default EntryWriter put(String k, boolean v) throws IOException {
            put(k, (Boolean) v);
            return this;
        }
    }
}

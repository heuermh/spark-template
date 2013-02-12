/*
 * Copyright 2011- Per Wendel
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package spark.template;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import spark.Route;

/**
 * Abstract template route.
 *
 * Example:
 * <pre>
 * {@code
 * Spark.get(new TemplateRoute("/hello/:name") {
 *    public Object handle(Request request, Response response) {
 *       Person person = Person.find(request.params("name"));
 *       return template("hello").render("person", person);
 *    }
 * });
 * </pre>
 */
public abstract class TemplateRoute extends Route {

    /**
     * Constructor
     * 
     * @param path The route path which is used for matching. (e.g. /hello, users/:name) 
     */
    protected TemplateRoute(String path) {
        super(path);
    }


    /**
     * Create and return a template with the specified name.
     *
     * @param name The template name
     *
     * @return The template with the specified name
     */
    public abstract Template template(String name);

    /**
     * Abstract template.
     */
    protected abstract class Template {
        private final Map<String, Object> emptyContext = Collections.emptyMap();

        protected Template() {
            // empty
        }


        /**
         * Render this template with the specified context.
         *
         * @param context The context with which to render this template
         *
         * @return The content of this template rendered with the specified context
         */
        public abstract Object render(Map<String, Object> context);

        /**
         * Render this template with an empty context.
         *
         * @return The content of this template rendered with an empty context
         */
        public final Object render() {
            return render(emptyContext);
        }

        /**
         * Render this template with the specified key value pair as context.
         *
         * @param key key
         * @param value value
         *
         * @return The content of this template rendered with the specified key value pair as context
         */
        public final Object render(String key, Object value) {
            Map<String, Object> context = new HashMap<String, Object>();
            context.put(key, value);
            return render(context);
        }

        /**
         * Render this template with the specified key value pairs as context.
         *
         * @param key1 first key
         * @param value1 first value
         * @param key2 second key
         * @param value2 second value
         *
         * @return The content of this template rendered with the specified key value pairs as context
         */
        public final Object render(String key1, Object value1, String key2, Object value2) {
            Map<String, Object> context = new HashMap<String, Object>();
            context.put(key1, value1);
            context.put(key2, value2);
            return render(context);
        }

        /**
         * Render this template with the specified key value pairs as context.
         *
         * @param key1 first key
         * @param value1 first value
         * @param key2 second key
         * @param value2 second value
         * @param key3 third key
         * @param value3 third value
         *
         * @return The content of this template rendered with the specified key value pairs as context
         */
        public final Object render(String key1, Object value1, String key2, Object value2, String key3, Object value3) {
            Map<String, Object> context = new HashMap<String, Object>();
            context.put(key1, value1);
            context.put(key2, value2);
            context.put(key3, value3);
            return render(context);
        }

        /**
         * Render this template with the specified key value pairs as context.
         *
         * @param key1 first key
         * @param value1 first value
         * @param key2 second key
         * @param value2 second value
         * @param key3 third key
         * @param value3 third value
         * @param key4 fourth key
         * @param value4 fourth value
         *
         * @return The content of this template rendered with the specified key value pairs as context
         */
        public final Object render(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4) {
            Map<String, Object> context = new HashMap<String, Object>();
            context.put(key1, value1);
            context.put(key2, value2);
            context.put(key3, value3);
            context.put(key4, value4);
            return render(context);
        }

        /**
         * Render this template with the specified key value pairs as context.
         *
         * @param key1 first key
         * @param value1 first value
         * @param key2 second key
         * @param value2 second value
         * @param key3 third key
         * @param value3 third value
         * @param key4 fourth key
         * @param value4 fourth value
         * @param key5 fifth key
         * @param value5 fifth value
         *
         * @return The content of this template rendered with the specified key value pairs as context
         */
        public final Object render(String key1, Object value1, String key2, Object value2, String key3, Object value3, String key4, Object value4, String key5, Object value5) {
            Map<String, Object> context = new HashMap<String, Object>();
            context.put(key1, value1);
            context.put(key2, value2);
            context.put(key3, value3);
            context.put(key4, value4);
            context.put(key5, value5);
            return render(context);
        }
    }
}

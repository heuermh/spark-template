/*
 * Copyright 2011- Per Wendel, Michael Heuer
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
package spark.template.velocity;

import java.io.StringWriter;

import java.util.Map;
import java.util.Properties;

import org.apache.velocity.VelocityContext;

import org.apache.velocity.app.VelocityEngine;

import spark.template.TemplateRoute;

/**
 * Template route based on Apache Velocity.
 *
 * Example:
 * <pre>
 * {@code
 * Spark.get(new VelocityTemplateRoute("/hello/:name") {
 *    public Object handle(Request request, Response response) {
 *       Person person = Person.find(request.params("name"));
 *       return template("hello.wm").render("person", person);
 *    }
 * });
 * </pre>
 */
public abstract class VelocityTemplateRoute extends TemplateRoute {
    private final VelocityEngine velocityEngine;

    /**
     * Constructor
     * 
     * @param path The route path which is used for matching. (e.g. /hello, users/:name) 
     */
    protected VelocityTemplateRoute(String path) {
        super(path);

        Properties properties = new Properties();
        properties.setProperty("resource.loader", "class");
        properties.setProperty("class.resource.loader.class",
                               "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        velocityEngine = new VelocityEngine(properties);
    }

    /**
     * Constructor
     * 
     * @param path The route path which is used for matching. (e.g. /hello, users/:name)
     * @param velocityEngine The velocity engine, must not be null.
     */
    protected VelocityTemplateRoute(String path, VelocityEngine velocityEngine) {
        super(path);
        if (velocityEngine == null) {
            throw new NullPointerException("velocityEngine must not be null");
        }
        this.velocityEngine = velocityEngine;
    }


    @Override
    public final Template template(String name) {
        return new VelocityTemplate(velocityEngine.getTemplate(name));
    }

    /**
     * Abstract template.
     */
    private final class VelocityTemplate extends Template {
        private final org.apache.velocity.Template template;

        private VelocityTemplate(org.apache.velocity.Template template) {
            this.template = template;
        }

        @Override
        public Object render(Map<String, Object> context) {
            VelocityContext velocityContext = new VelocityContext(context);
            StringWriter writer = new StringWriter();
            template.merge(velocityContext, writer);
            return writer;
        }
    }
}

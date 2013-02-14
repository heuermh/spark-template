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
package spark.template.mustache.example;

import static spark.Spark.get;

import spark.Request;
import spark.Response;

import spark.template.mustache.MustacheTemplateRoute;

/**
 * MustacheTemplateRoute example.
 */
public final class MustacheTemplateExample {
    public static void main(final String[] args) {
        get(new MustacheTemplateRoute("/hello/:name") {
                @Override
                public Object handle(final Request request, final Response response) {
                    Person person = Person.find(request.params("name"));
                    return template("hello.mustache").render("person", person);
                }
            });
    }
}

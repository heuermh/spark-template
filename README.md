spark-template
==============

Template routes for Spark web framework


To build

    $ mvn install


To build velocity example

    $ cd velocity-example
    $ mvn assembly:assembly


To run velocity example

    $ java -jar target/spark-template-velocity-example-0.9.9.5-SNAPSHOT-jar-with-dependencies.jar 
    == Spark has ignited ...
    >> Listening on 0.0.0.0:4567

Then open

    http://localhost:4567/hello/foo

in a browser.



To add a new Template engine

 - Create a new module
 - Add dependency to spark-template
 - Add dependency to new template engine
 - Extend https://github.com/heuermh/spark-template/blob/master/api/src/main/java/spark/template/TemplateRoute.java
 - (optional) Create a new example module
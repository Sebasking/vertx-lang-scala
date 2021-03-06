/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.scala.ext.web

import scala.collection.JavaConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.ext.web.common.{WebEnvironment => JWebEnvironment}

package object common{


  /**
    * A template template uses a specific template and the data in a routing context to render a resource into a buffer.
    * 
    * Concrete implementations exist for several well-known template engines.
    */

  implicit class TemplateEngineScala(val asJava: io.vertx.ext.web.common.template.TemplateEngine) extends AnyVal {

    /**
     * Like [[render]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def renderFuture(context: io.vertx.core.json.JsonObject,templateFileName: java.lang.String): scala.concurrent.Future[io.vertx.core.buffer.Buffer] = {
      val promise = concurrent.Promise[io.vertx.core.buffer.Buffer]()
      asJava.render(context, templateFileName, {a:AsyncResult[io.vertx.core.buffer.Buffer] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }


  object WebEnvironment {
    /**
     * Like [[development]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def development() = {
      io.vertx.ext.web.common.WebEnvironment.development()
    }
    /**
     * Like [[mode]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def modeOption() = {
      scala.Option(io.vertx.ext.web.common.WebEnvironment.mode())
    }
  }


}

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

package io.vertx.scala.ext.web.handler

import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import scala.reflect.runtime.universe._
import io.vertx.scala.ext.web.RoutingContext
import io.vertx.ext.web.handler.{FaviconHandler => JFaviconHandler}
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * A handler that serves favicons.
  * 
  * If no file system path is specified it will attempt to serve a resource called `favicon.ico` from the classpath.
  */

class FaviconHandler(private val _asJava: Object) extends io.vertx.core.Handler[RoutingContext] {
  def asJava = _asJava






  override def handle (arg0: RoutingContext): Unit = {
    asJava.asInstanceOf[JFaviconHandler].handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }


}

object FaviconHandler {
  def apply(asJava: JFaviconHandler) = new FaviconHandler(asJava)
  
  /**
   * Create a handler with defaults   * @return the handler
   */
  def create(): FaviconHandler = {
    FaviconHandler(JFaviconHandler.create())
  }

  /**
   * Create a handler attempting to load favicon file from the specified path   * @param path the path
   * @return the handler
   */
  def create(path: String): FaviconHandler = {
    FaviconHandler(JFaviconHandler.create(path.asInstanceOf[java.lang.String]))
  }

  /**
   * Create a handler attempting to load favicon file from the specified path, and with the specified max cache time   * @param path the path
   * @param maxAgeSeconds max how long the file will be cached by browser, in seconds
   * @return the handler
   */
  def create(path: String,maxAgeSeconds: Long): FaviconHandler = {
    FaviconHandler(JFaviconHandler.create(path.asInstanceOf[java.lang.String], maxAgeSeconds.asInstanceOf[java.lang.Long]))
  }

  /**
   * Create a handler with the specified max cache time   * @param maxAgeSeconds max how long the file will be cached by browser, in seconds
   * @return the handler
   */
  def create(maxAgeSeconds: Long): FaviconHandler = {
    FaviconHandler(JFaviconHandler.create(maxAgeSeconds.asInstanceOf[java.lang.Long]))
  }

}

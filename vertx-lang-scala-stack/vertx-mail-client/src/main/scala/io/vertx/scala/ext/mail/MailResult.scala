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

package io.vertx.scala.ext.mail

import io.vertx.ext.mail.{MailResult => JMailResult}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * Represent the result of the sendMail operation
 */

class MailResult(private val _asJava: JMailResult) {
  def asJava = _asJava
  /**

   */
  def setMessageID(value: String) = {
    asJava.setMessageID(value)
    this
  }

  def getMessageID: String = {
    asJava.getMessageID().asInstanceOf[String]
  }

  /**

   */
  def setRecipients(value: scala.collection.mutable.Buffer[String]) = {
    asJava.setRecipients(value.asJava)
    this
  }

  def getRecipients: scala.collection.mutable.Buffer[String] = {
    asJava.getRecipients().asScala.map(x => x.asInstanceOf[String])
  }

}


object MailResult {
  
  def apply() = {
    new MailResult(new JMailResult(emptyObj()))
  }
  
  def apply(t: JMailResult) = {
    if (t != null) {
      new MailResult(t)
    } else {
      new MailResult(new JMailResult(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): MailResult = {
    if (json != null) {
      new MailResult(new JMailResult(json))
    } else {
      new MailResult(new JMailResult(emptyObj()))
    }
  }
}


package time.tagless

import java.time.ZonedDateTime

import time.tagless.Tagless.TimeAlgebra

import scalaz.concurrent.Task

object TaskInterpreter {
  lazy val timeAlgebraInterpreter = new TimeAlgebra[Task] {
    override def getTime: Task[ZonedDateTime] = Task.delay(ZonedDateTime.now())
  }
}

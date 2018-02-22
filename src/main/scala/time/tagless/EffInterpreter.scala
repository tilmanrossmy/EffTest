package time.tagless

import java.time.ZonedDateTime

import org.atnos.eff.addon.scalaz.concurrent.TimedTask
import org.atnos.eff.addon.scalaz.task
import org.atnos.eff.{Eff, |=}
import time.tagless.Tagless.TimeAlgebra

import scalaz.concurrent.Task

final class EffInterpreter[R](implicit member: TimedTask |= R) extends TimeAlgebra[Eff[R,?]] {

  override def getTime() = task.fromTask[R,ZonedDateTime](Task.delay(ZonedDateTime.now()))
}

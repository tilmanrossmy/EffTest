package time.tagless

import java.time.ZonedDateTime

import cats.Eval
import time.tagless.Tagless.TimeAlgebra

object EvalInterpreter extends TimeAlgebra[Eval]{
  override def getTime(): Eval[ZonedDateTime] = Eval.later(ZonedDateTime.now())
}

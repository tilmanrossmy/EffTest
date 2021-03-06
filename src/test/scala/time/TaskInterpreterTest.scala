package time

import org.atnos.eff.Fx
import org.atnos.eff.addon.scalaz.concurrent.TimedTask
import org.atnos.eff.syntax.addon.scalaz.task._
import time.TaskInterpreter.TimeEffectTaskInterpreterSyntax
import time.Effect.TimeAlgebra

import scala.concurrent.ExecutionContext.Implicits.global

/**
  */
object TaskInterpreterTest extends App {

  implicit val dts = scalaz.concurrent.Strategy.DefaultTimeoutScheduler

  type Stack=Fx.fx2[TimedTask,TimeAlgebra]

  private val time = Effect.getTime[Stack]().runTime.runSequential.unsafePerformSync

  println(time)


}

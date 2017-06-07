package time

import cats.Eval
import org.atnos.eff._
import org.atnos.eff.syntax.all._
import time.EvalInterpreter.TimeEffectEvalInterpreterSyntax
import time.Effect.TimeAlgebra


/**
  * Created by tilman on 15.05.17.
  */
object EvalInterpreterTest extends App {

  implicit val dts = scalaz.concurrent.Strategy.DefaultTimeoutScheduler

  type Stack=Fx.fx2[Eval,TimeAlgebra]

  private val time = Effect.getTime[Stack]().runTime.runEval.run

  println(time)


}

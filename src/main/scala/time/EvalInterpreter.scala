package time

import java.time.ZonedDateTime

import org.atnos.eff.EvalEffect._
import org.atnos.eff._
import org.atnos.eff.interpret._
import time.Effect.{GetTime, TimeAlgebra}

/**
  * Created by tilman on 15.05.17.
  */
object EvalInterpreter
{

  outer =>
  def runTime[R, U, A](effects: Eff[R, A])
                      (implicit m: Member.Aux[TimeAlgebra, R, U],
                      evalEffect:_eval[U]
                      ): Eff[U, A] = {

    translate(effects)(new Translate[TimeAlgebra, U] {
      def apply[X](kv: TimeAlgebra[X]): Eff[U, X] =
        kv match {
          case GetTime() => eval.delay(ZonedDateTime.now())
        }
    })
  }

  implicit class TimeEffectEvalInterpreterSyntax[R, A](eff: Eff[R, A]) {
    def runTime[U](implicit m: Member.Aux[TimeAlgebra, R, U],eval:_eval[U]): Eff[U, A] = outer.runTime(eff)
  }


}

package time

import java.time.ZonedDateTime

import org.atnos.eff._
import org.atnos.eff.addon.scalaz.concurrent.TaskEffect._task
import org.atnos.eff.addon.scalaz.task.fromTask
import org.atnos.eff.interpret._
import time.Effect.{GetTime, TimeAlgebra}

import scalaz.concurrent.Task


object TaskInterpreter {

  outer =>
  def runTime[R, U, A](effects: Eff[R, A])
                      (implicit m: Member.Aux[TimeAlgebra, R, U],
                       taskEffect: _task[U]
                      ): Eff[U, A] = {

    translate(effects)(new Translate[TimeAlgebra, U] {
      def apply[X](kv: TimeAlgebra[X]): Eff[U, X] =
        kv match {
          case GetTime() => fromTask(Task.delay(ZonedDateTime.now()))
        }
    })
  }

  implicit class TimeEffectTaskInterpreterSyntax[R, A](eff: Eff[R, A]) {
    def runTime[U](implicit m: Member.Aux[TimeAlgebra, R, U],
                   task: _task[U]): Eff[U, A] = outer.runTime(eff)
  }


}

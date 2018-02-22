package time.tagless

import java.time.ZonedDateTime

import cats.data.Writer
import org.atnos.eff.{Fx2, _}
import org.atnos.eff.addon.scalaz.concurrent.TimedTask
import org.atnos.eff.syntax.addon.scalaz.task._
import org.atnos.eff.syntax.writer.WriterEffectOps

import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Combining getTime with eff's WriterEffect
  */
object EffectInterpreterTest extends App {

  implicit val dts = scalaz.concurrent.Strategy.DefaultTimeoutScheduler

  type S = Fx2[TimedTask, Writer[String, ?]]

 val program: Eff[S, ZonedDateTime] = for {
    time <- new EffInterpreter[S]().getTime()
    _ <- WriterEffect.tell[S,String](time.toString)
  } yield time

  private val result: (ZonedDateTime, List[String]) = program.runWriter.runSequential.unsafePerformSync
  println(result)
}

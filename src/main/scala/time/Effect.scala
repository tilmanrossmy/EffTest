package time

import java.time.ZonedDateTime

import org.atnos.eff.Eff
import org.atnos.eff.MemberIn.|=


object Effect {

  type _time[R] = TimeAlgebra |= R

  sealed trait TimeAlgebra[T]

  case class GetTime() extends TimeAlgebra[ZonedDateTime]

  def getTime[R: _time](): Eff[R, ZonedDateTime] = Eff.send(GetTime())

}

package time

import java.time.ZonedDateTime

import org.atnos.eff.Eff
import org.atnos.eff.MemberIn.|=

/**
  * Created by tilman on 15.05.17.
  */
object TimeEffect {

  type _time[R]= TimeAlgebra |= R

  sealed trait TimeAlgebra[T]

  case class GetTime() extends TimeAlgebra[ZonedDateTime]

  def getTime[R:_time](): Eff[R, ZonedDateTime] =Eff.send[TimeAlgebra,R,ZonedDateTime](GetTime())

}

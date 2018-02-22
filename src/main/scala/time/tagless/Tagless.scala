package time.tagless

import java.time.ZonedDateTime

object Tagless {

  trait TimeAlgebra[F[_]]{
    def getTime():F[ZonedDateTime]
  }

}

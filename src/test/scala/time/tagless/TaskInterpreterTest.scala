package time.tagless

object TaskInterpreterTest extends App{
    println(TaskInterpreter.timeAlgebraInterpreter.getTime.unsafePerformSync)
}

package time.tagless

object TaskInterpreterTest extends App{
    println(TaskInterpreter.getTime().unsafePerformSync)
}

import akka.actor.{ActorSystem, Props}
import poolexample.PoolRouter
import worker.Work

object  PoolExample extends App{
  val system = ActorSystem("poolexample")
  val router= system.actorOf(Props(classOf[PoolRouter]))
  router ! Work("hi")
  router ! Work("hello")
  system.terminate()
}
import akka.actor.{ActorSystem, Props}
import groupexample.RouterGroup
import worker.{Work, Worker}

object GroupExample extends App{
  val system = ActorSystem("groupexample")


system.actorOf(Props[Worker],name = "worker1")
system.actorOf(Props[Worker],name = "worker2")
system.actorOf(Props[Worker],name = "worker3")

val workers :List[String]=List("/user/worker1",
    "/user/worker2",
    "/user/worker3")

  val routerGroup= system.actorOf(Props(classOf[RouterGroup],workers))

  routerGroup ! Work("Hiii")
  routerGroup ! Work("Hello")
}

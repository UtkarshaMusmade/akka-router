package groupexample

import akka.actor.{Actor, ActorLogging}
import worker.Work

class RouterGroup(routees : List[String])extends Actor with ActorLogging {
  override def receive = {
    case msg: Work => log.info("Router sending message to worker...")
      context.actorSelection(routees(util.Random.nextInt(routees.size))) forward (msg)
  }
}
package poolexample

import akka.actor.{Actor, ActorLogging, ActorRef, Props}
import worker.{Work, Worker}

class PoolRouter extends Actor with ActorLogging{
  var routees: List[ActorRef] = _

  override def preStart()={
    routees = List.fill(5){
      context.actorOf(Props[Worker])
    }
  }

  override def receive={
    case msg:Work => log.info("Router sending message to worker ...")
      routees(util.Random.nextInt(routees.size))forward(msg)
  }

}
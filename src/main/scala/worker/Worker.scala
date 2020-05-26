package worker

import akka.actor.{Actor, ActorLogging}

case class Work(name:String)

class Worker extends Actor with ActorLogging {
  override def receive={
    case Work(msg) => log.info(s"${self.path.name} received message $msg")
  }
}


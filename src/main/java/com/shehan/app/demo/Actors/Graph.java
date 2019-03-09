package com.shehan.app.demo.Actors;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.shehan.app.demo.models.GraphData;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;


public class Graph extends UntypedActor {
    private String response;
    LoggingAdapter log = Logging.getLogger(getContext().system(), this);
    public static Props props() {
        return Props.create(Graph.class);
    }

    @MessageMapping("/send/message7")
    @SendTo("/chat7")
    public String graph() throws Exception{
        return response;
    }
    
    
    
    @Override
    public void onReceive(Object message) throws Throwable {
      if(message instanceof GraphData){
          GraphData graphData = (GraphData) message;
          GraphData newMessage = new GraphData(graphData.getValue());
          log.info("Get Value:"+newMessage.getValue());
          returnMSG(Double.toString(newMessage.getValue()));
          getContext().system().scheduler().scheduleOnce(Duration.create(5, TimeUnit.SECONDS),
                  ()->{
              getSelf().tell(newMessage, ActorRef.noSender());
          },getContext().system().dispatcher());

      }else{
          unhandled(message);
      }
        
    }

    public String returnMSG(String response){
        this.response=response;
        return response;
    }
}

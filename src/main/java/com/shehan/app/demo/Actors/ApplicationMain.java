package com.shehan.app.demo.Actors;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.shehan.app.demo.models.GraphData;

import java.util.Date;

public class ApplicationMain {

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("actor");
        ActorRef scheduleActor1 = system.actorOf(Graph.props(), "actor1");

        for (Long id = 1L; id <= 1000L; id++) {
            //scheduleActor1.tell(new ScheduleActor.Schedule(id, new Date()), null);
            scheduleActor1.tell(new GraphData(110.2),null);

                 }


        // This example app will ping pong 3 times and thereafter terminate the ActorSystem -
        // see counter logic in PingActor
        system.scheduler();
    }

}

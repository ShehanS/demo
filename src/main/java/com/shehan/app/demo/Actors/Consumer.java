package com.shehan.app.demo.Actors;

import akka.actor.ActorIdentity;
import akka.actor.ActorRef;
import akka.actor.UntypedActor;

public class Consumer extends UntypedActor {
    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof Integer) {
            System.out.println("<<< Receiving & printing " + message);
        }
    }
}

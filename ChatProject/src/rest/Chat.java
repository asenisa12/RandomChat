package rest;

import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Path("/chat")
public class Chat {

    final static Map<String, AsyncResponse> waiters = new ConcurrentHashMap<>();
    final static ExecutorService ex = Executors.newSingleThreadExecutor();

    @Path("/{nick}")
    @GET
    @Produces("text/plain")
    public void hangUp(@Suspended AsyncResponse asyncResp, @PathParam("nick") String nick) {

        waiters.put(nick, asyncResp);
    }

    @Path("/{nick}")
    @POST
    @Produces("text/plain")
    @Consumes("text/plain")
    public String sendMessage(final @PathParam("nick") String nick, final String message) {

        ex.submit(new Runnable() {
            @Override
            public void run() {
                Set<String> nicks = waiters.keySet();
                for (String n : nicks) {
                    // Sends message to all, except sender
                    if (!n.equalsIgnoreCase(nick))
                        waiters.get(n).resume(nick + ": " + message);
                }
            }
        });

        return "Message is sent..";
    }
}
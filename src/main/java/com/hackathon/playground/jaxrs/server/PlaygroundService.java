package com.hackathon.playground.jaxrs.server;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.hackathon.playground.jaxrs.exception.PlaygroundException;
import org.jboss.logging.Logger;
import org.joda.time.DateTime;

@Path("/playground")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class PlaygroundService {

    private static final Logger log = Logger.getLogger(PlaygroundService.class);

    private static Map<String, PlayDate> playDates = new LinkedHashMap<String, PlayDate>();
    static {
        PlayDate[] playdateArray = new PlayDate[] {
                new PlayDate("All American Park", "Fun park times", "dhenry", new Date(), new Date(), 36.155384, -115.263625),
                new PlayDate("All American Park", "More fun park times", "dhenry", new DateTime().plusDays(1).toDate(), new DateTime().plusDays(2).toDate(), 36.155384, -115.263625),
                new PlayDate("All American Park", "I love this park", "dhenry", new DateTime().plusDays(1).toDate(), new DateTime().plusDays(3).toDate(), 36.155384, -115.263625)
        };
        for (PlayDate playDate : playdateArray) {
            playDates.put(playDate.getId(), playDate);
        }
    }

    @GET
    @Path("/playdates")
    public Collection<PlayDate> getPlayDates() {
        Collection<PlayDate> result = playDates.values();
        log.infof("getPlayDates: %s", result);
        return result;
    }

    @GET
    @Path("/playdates/{id}")
    public PlayDate getPlayDate(@PathParam("id") String id) {
        PlayDate playDate = playDates.get(id);
        log.infof("getPlayDate: %s", playDate);
        return playDate;
    }

    @POST
    @Path("/playdates")
    @Consumes("application/json")
    public PlayDate addPlayDate(PlayDate newPlayDate) {
        log.infof("addPlayDate: %s", newPlayDate);
        playDates.put(newPlayDate.getId(), newPlayDate);
        return newPlayDate;
    }

    @PUT
    @Path("/playdates/{id}/addattendee")
    public PlayDate addAttendee(@PathParam("id") String id, @QueryParam("attendee") String attendee) throws PlaygroundException {
        PlayDate playDate = playDates.get(id);
        if (playDate != null) {
            playDate.addAttendee(attendee);
        } else {
            throw new PlaygroundException("Playdate with id: " + id + " wasn't found");
        }
        log.infof("addAttendee: %s", playDate);
        return playDate;
    }

    @PUT
    @Path("/playdates/{id}/removeattendee")
    public PlayDate removeAttendee(@PathParam("id") String id, @QueryParam("attendee") String attendee) throws PlaygroundException {
        PlayDate playDate = playDates.get(id);
        if (playDate != null) {
            if (playDate.getOrganiser().equals(attendee)) {
                throw new PlaygroundException("The Playdate organizer cannot be removed from the attendees!");
            }
            playDate.removeAttendee(attendee);
        } else {
            throw new PlaygroundException("Playdate with id: " + id + " wasn't found");
        }
        log.infof("removeAttendee: %s", playDate);
        return playDate;
    }

    @DELETE
    @Path("/playdates/{id}")
    public PlayDate cancelPlayDate(@PathParam("id") String id) {
        PlayDate playDate = playDates.remove(id);
        log.infof("cancelPlayDate: %s", playDate);
        return playDate;
    }
}
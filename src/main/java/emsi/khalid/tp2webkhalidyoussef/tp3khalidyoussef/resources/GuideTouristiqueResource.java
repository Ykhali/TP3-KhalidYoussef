package emsi.khalid.tp2webkhalidyoussef.tp3khalidyoussef.resources;

import emsi.khalid.tp2webkhalidyoussef.tp3khalidyoussef.llm.LlmClient;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("/guide")
public class GuideTouristiqueResource {
    @Inject
    private LlmClient llmClient;

    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public String hello(@PathParam("ville_ou_pays") String lieu) {
        return llmClient.poserQuestion(lieu);
    }
}

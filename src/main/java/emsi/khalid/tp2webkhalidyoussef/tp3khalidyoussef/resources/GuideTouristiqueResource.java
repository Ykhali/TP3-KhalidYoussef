package emsi.khalid.tp2webkhalidyoussef.tp3khalidyoussef.resources;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("/guide")
public class GuideTouristiqueResource {

    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> hello(@PathParam("ville_ou_pays") String lieu) {
        List<String> lieux = new ArrayList<>();

        lieux.add("Lieu touristique 1 pour " + lieu);
        lieux.add("Lieu touristique 2 pour " + lieu);

        return lieux;
    }
}

package org.acme.view;

import org.acme.model.Cours;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;

@Path("/page/cours")
public class CoursPage {

    @Inject
    Template cours; // Le fichier cours.html

    @GET
    public TemplateInstance afficher() {
        List<Cours> liste = Cours.listAll();
        return cours.data("cours", liste);
    }
}

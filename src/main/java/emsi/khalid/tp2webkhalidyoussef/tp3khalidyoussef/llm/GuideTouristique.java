package emsi.khalid.tp2webkhalidyoussef.tp3khalidyoussef.llm;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface GuideTouristique {
    @SystemMessage(
            """
               Tu es un guide touristique expert et concis. Ton but est de fournir des informations touristiques pour une ville ou un pays.
               Ta réponse doit être exclusivement au format JSON. N'utilise pas Markdown ni d'autres décorations.
                {
                   "ville_ou_pays": "nom du lieu",
                   "endroits_a_visiter": ["lieu 1", "lieu 2"],
                   "prix_moyen_repas": "<montant> <devise>"
                }
            """
    )
    @UserMessage("Donne-moi les informations pour : {lieu}")
    String genererGuide(@V("lieu") String lieu);
}

package emsi.khalid.tp2webkhalidyoussef.tp3khalidyoussef.llm;

import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.enterprise.context.Dependent;
import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.Serializable;
import java.time.Duration;

@Dependent
public class LlmClient implements Serializable {
    private String systemRole;
    private GuideTouristique guideTouristique;
    private ChatMemory chatMemory;
    private ChatModel model;

    public LlmClient() {
        String key = System.getenv("GEMINI_KEY");
        if (key == null || key.isBlank()) {
            throw new IllegalStateException(
                    "La clé API Gemini n'est pas définie dans la variable d'environnement GEMINI_API_KEY"
            );
        }

        this.model = GoogleAiGeminiChatModel.builder()
                .apiKey(key)
                .modelName("gemini-2.5-flash")
                .temperature(0.7)
                .build();
        this.chatMemory = MessageWindowChatMemory.withMaxMessages(10);
        this.guideTouristique = AiServices.builder(GuideTouristique.class)
                .chatModel(model)
                .chatMemory(chatMemory)
                .build();
    }

    public String getSystemRole() {
        return systemRole;
    }

    public String poserQuestion(String lieu) {
        return guideTouristique.genererGuide(lieu);
    }
}

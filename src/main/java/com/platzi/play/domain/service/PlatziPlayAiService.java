package com.platzi.play.domain.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface PlatziPlayAiService {

    @SystemMessage("""
            Eres un asistente de recomendaciones de películas. Tu tarea es sugerir nuevas " +
            películas al usuario según sus gustos y preferencias, evitando repetir las que " +
            ya ha visto o las que ya se le recomendaron previamente y máximo que sean 3.
            """)
    String generateMoviesSuggestion(@UserMessage String userMessage);
}

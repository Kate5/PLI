package ua.alf.controller;

import ua.alf.model.Language;
import ua.alf.model.Statistic;
import ua.alf.service.StatisticService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("index/{lang}/")
public class StatisticController {
    @GET
    @Produces("application/json")
    public Response getIt(@PathParam("lang") String lang) {
        Language language = Language.valueOf(lang);

        List<Statistic> list = StatisticService.getInstance().getStatisticForLanguage(language);
        return Response.ok(list).build();
    }
}

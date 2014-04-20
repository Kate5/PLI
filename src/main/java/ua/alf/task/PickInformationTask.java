package ua.alf.task;

import ua.alf.model.Language;
import ua.alf.service.StatisticService;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: Eugene Chipachenko
 * Date: 20.04.2014
 * Time: 13:52
 */
public class PickInformationTask implements Runnable {
    private static final Client client = ClientBuilder.newClient();
    private static final Pattern pattern = Pattern.compile(">([A-Za-z +./]+)</a><em>(\\d+)</em>");

    @Override
    public void run() {
        System.out.println("Collecting vacancies count... ");
        WebTarget webTarget = client.target("http://jobs.dou.ua/");
        Response response = webTarget.request().get();

        String content = response.readEntity(String.class);

        Matcher m = pattern.matcher(content);

        while (m.find()) {
            String name = m.group(1);
            String val = m.group(2);

            Language l = Language.findByName(name);
            if (l == null)
                continue;

            StatisticService.getInstance().save(l, val);
        }
    }

}

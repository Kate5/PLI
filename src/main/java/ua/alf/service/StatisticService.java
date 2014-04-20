package ua.alf.service;

import ua.alf.model.Language;
import ua.alf.model.Statistic;
import ua.alf.repository.StatisticRepository;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Eugene Chipachenko
 * Date: 20.04.2014
 * Time: 13:47
 */
public class StatisticService {
    private static final StatisticRepository repo = StatisticRepository.getInstance();
    private static StatisticService ourInstance = new StatisticService();

    public static StatisticService getInstance() {
        return ourInstance;
    }

    private StatisticService() {
    }

    public void save(Language language, String val) {
        Integer i = Integer.valueOf(val);

        Statistic statistic = new Statistic();
        statistic.setDate(new Date());
        statistic.setLanguage(language);
        statistic.setValue(i);

        Statistic old = repo.findByLangAndDate(language, statistic.getDate());
        if (old != null)
            repo.remove(old);

        repo.save(statistic);
    }

    public List<Statistic> getStatisticForLanguage(Language lang) {
        return repo.findByLanguage(lang);
    }
}

package zac.languages.languages;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class LanguageService{
    private final LanguageRepository langRepo;

    public LanguageService(LanguageRepository langRepo){
        this.langRepo = langRepo;
    }

    public List<Language> allLanguages(){
        return langRepo.findAll();
    }

    public Language createLanguage(Language lang){
        return langRepo.save(lang);
    }

    public Language findLanguage(Long id){
        Optional<Language> optionalLang = langRepo.findById(id);
        if(optionalLang.isPresent()){
            return optionalLang.get();
        } else {
            return null;
        }
    }

    public Language updateLanguage(Language lang){
        return updateLanguage(lang.getId(), lang.getName(), lang.getCreator(), lang.getVersion());
    }

    public Language updateLanguage(Long id, String name, String creator, String version) {
        Optional<Language> lang = langRepo.findById(id);
        if (lang.isPresent()){
            lang.get().setName(name);
            lang.get().setCreator(creator);
            lang.get().setVersion(version);
            return langRepo.save(lang.get());
        } else {
            return null;
        }
    }
}

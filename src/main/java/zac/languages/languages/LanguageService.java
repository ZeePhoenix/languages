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
}

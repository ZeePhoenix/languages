package zac.languages.languages;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguageApi {
    private final LanguageService langService;

    public LanguageApi(LanguageService langService){
        this.langService = langService;
    }

    @RequestMapping("/api/languages")
    public List<Language> index(){
        return langService.allLanguages();
    }

    @RequestMapping(value="/api/languages", method = RequestMethod.POST)
    public Language create(@RequestParam(value="name")String name, @RequestParam(value="creator")String creator, @RequestParam(value="version")String version){
        Language lang = new Language(name, creator, version);
        return langService.createLanguage(lang);
    }

    @RequestMapping("/api/languages/{id}")
    public Language show(@PathVariable("id") Long id){
        Language lang = langService.findLanguage(id);
        return lang;
    }
}
